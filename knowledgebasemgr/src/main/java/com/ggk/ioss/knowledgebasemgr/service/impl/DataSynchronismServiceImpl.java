/*
 * File Name：DataSynchronismServiceImpl.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午8:06:14
 */
package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
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
        mapper.saveTicketMainInfo(list);             //将Oral的新增的数据保存到MySql
        operator.insertKnowledgeByTickt(list);       //将Oral的新增数据插入到es
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
        try {
            String minUrl = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getMinUpdateTime";
            String maxUrl = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getMinUpdateTime";
            obj = obj.parseObject(HttpClientUtils.doGet(minUrl , null));
            minUpdateTime = Long.parseLong(obj.get("count").toString());
            obj = obj.parseObject(HttpClientUtils.doGet(maxUrl , null));
            maxUpdateTime = Long.parseLong(obj.get("count").toString());
        } catch (NumberFormatException e) {
            //log to MySQL
            e.printStackTrace();
            return "failure";
        }
        String url = "";
        long start = 0;
        long end = 0;
        long syncCount = 0;
        for(start = minUpdateTime; end <= maxUpdateTime; start += end) {
            end = start + 24 * 60 * 60;
            url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getHistoryDataByUpdateTime?startTime=" + start + "&endTime=" + end;
            String ticketInfoStr = HttpClientUtils.doGet(url , null);
            obj = obj.parseObject(ticketInfoStr);
            syncCount = obj.getLongValue("count");
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
            mapper.saveSyncLog("History Data Sync", url, "success", syncCount);
        }
        return "success";
    }
    
    @Override
    public void syncRealTimeData() {
        Date date = new Date();
        Convertor convertor = new Convertor();
        String url;
        long startTime = date.getTime() / 1000 - 12 * 60 * 60; //获取当前时间前12小时的时间戳
        url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getRealTimeOralData?startTime="+startTime;
        try {
            JSONObject obj = new JSONObject();
            String ticketInfoStr = HttpClientUtils.doGet(url , null);
            obj = obj.parseObject(ticketInfoStr);
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
            long syncCount = obj.getLongValue("count");
            mapper.saveSyncLog("Reattime Data Sync", url, "success", syncCount);
        } catch (Exception e) {
            mapper.saveSyncLog("Reattime Data Sync", url, "success", 0);
            e.printStackTrace();
        }
    }
}

