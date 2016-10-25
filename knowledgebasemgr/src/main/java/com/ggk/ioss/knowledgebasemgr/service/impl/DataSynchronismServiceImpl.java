/*
 * File Name：DataSynchronismServiceImpl.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午8:06:14
 */
package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.conf.SystemConfigs;
import com.ggk.ioss.knowledgebasemgr.mapper.TicketMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.DataSynchronismService;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeOperator;
import com.ggk.ioss.knowledgebasemgr.utils.Convertor;
import com.ggk.ioss.knowledgebasemgr.utils.HttpClientUtils;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午8:06:14
 */
@Service
@EnableConfigurationProperties(SystemConfigs.class)
public class DataSynchronismServiceImpl implements DataSynchronismService {
    
    @Autowired
    private TicketMapper mapper;
    @Autowired
    private IKnowledgeOperator operator;
    @Autowired
    private SystemConfigs conf;
    
    @Override
    public void syncDataFromOral(List<TicketMainInfo> list) {
        if(list.size() == 0) {
            return;
        }
        try {
            mapper.saveTicketMainInfo(list);             //将Oral的新增的数据保存到MySql
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----------------------------------------------------");
            System.out.println("Error In Save Data In MySql");
        }
        try {
            operator.insertKnowledgeByTickt(list);       //将Oral的新增数据插入到es
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----------------------------------------------------");
            System.out.println("Error In Save Data In ES");
        }
    }
    
    @Override
    public String updateInscData(String date) {
        JSONObject obj = new JSONObject();
        //或者date日期内所有的数据数量
        String url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getDateEventCount?date="+ date;
        String countStr = HttpClientUtils.doGet(url , null);
        obj = obj.parseObject(countStr);
        long countValue = Long.parseLong(obj.get("count").toString());
        //获取date日期全部数据
        url = "http://" + conf.getOrclip() + ":" + conf.getOrclport() + "/data/getTickInfo?date="+date+"&start=0&end=100";
        String ticketInfoStr = HttpClientUtils.doGet(url , null);
        obj = obj.parseObject(ticketInfoStr);
        Convertor convertor = new Convertor();
        syncDataFromOral(convertor.getTicketMainInfoList(obj));
        return "success";
    }
    
/*    @Override
    public String syncHistoryData() {
        JSONObject obj = new JSONObject();
        Convertor convertor = new Convertor();
        String url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getHistoryDataCount";
        String countStr = HttpClientUtils.doGet(url , null);
        obj = obj.parseObject(countStr);
        long countValue = Long.parseLong(obj.get("count").toString());
        System.out.println("countValue = " + countValue);
        int syncSize = 500;    //每次同步1000条
        for(int time = 0; time <= countValue / syncSize; time++) {
            url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  
                + "/data/getHistoryData?start=" + (time * syncSize) + "&end=" +((time+1) * syncSize);
            String ticketInfoStr = HttpClientUtils.doGet(url , null);
            obj = obj.parseObject(ticketInfoStr);
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
            mapper.saveSyncLog("History Data Sync", url, "success");   //记录log
        }
        return "success";
    }*/
    @Override
    public String syncHistoryData() {
        JSONObject obj = new JSONObject();
        Convertor convertor = new Convertor();
        long minUpdateTime = 0;
        long maxUpdateTime = 0;
        String minUrl = "";
        String maxUrl = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            minUrl = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getMinUpdateTime";
            maxUrl = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getMaxUpdateTime";
            obj = obj.parseObject(HttpClientUtils.doGet(minUrl , null));
            minUpdateTime = Long.parseLong(obj.get("count").toString());
            System.out.println("minUpdateTime=" + minUpdateTime);
            obj = obj.parseObject(HttpClientUtils.doGet(maxUrl , null));
            maxUpdateTime = Long.parseLong(obj.get("count").toString());
            System.out.println("maxUpdateTime = " + maxUpdateTime);
        } catch (NumberFormatException e) {
            mapper.saveSyncLog("Sync getMinUpdateTime or getMinUpdateTime", minUrl + "\t" + maxUrl, "failure", 0, sdf.format(new Date()));
            e.printStackTrace();
            return "failure";
        }
        String url = "";
        long start = 0;
        long end = 0;
        long syncCount = 0;
        //minUpdateTime = 1445994441;
        minUpdateTime = 1447398441;
        for(start = minUpdateTime; end <= maxUpdateTime; start = end) {
            end = start + 6 * 60 * 60;        //一次同步一天
            url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getHistoryDataByUpdateTime?startTime=" + start + "&endTime=" + end;
            System.out.println(url);
            try {
                String ticketInfoStr = HttpClientUtils.doGet(url , null);
                obj = obj.parseObject(ticketInfoStr);
            } catch (Exception e) {
                mapper.saveSyncLog("History Data Sync", url, "failure", 0, sdf.format(new Date()));
                e.printStackTrace();
            }
            syncCount = obj.getLongValue("count");
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
            mapper.saveSyncLog("History Data Sync", url, "success", syncCount, sdf.format(new Date()));
        }
        return "success";
    }
    
    @Override
    public void syncRealTimeData() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Convertor convertor = new Convertor();
        String url;
        long startTime = date.getTime() / 1000 - 12 * 60 * 60; //获取当前时间前12小时的时间戳
        long endTime = date.getTime() / 1000;
        url = "http://" + conf.getOrclip() + ":" + conf.getOrclport() 
            + "/data/getHistoryDataByUpdateTime?startTime=" + startTime + "&endTime=" + endTime;
        try {
            JSONObject obj = new JSONObject();
            String ticketInfoStr = HttpClientUtils.doGet(url , null);
            obj = obj.parseObject(ticketInfoStr);
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
            long syncCount = obj.getLongValue("count");
            mapper.saveSyncLog("Realtime Data Sync", url, "success", syncCount, sdf.format(new Date()));
        } catch (Exception e) {
            mapper.saveSyncLog("Realtime Data Sync", url, "failure", 0, sdf.format(new Date()));
            e.printStackTrace();
        }
    }
}

