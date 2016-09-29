/*
 * File Name：DataSynchronismServiceImpl.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午8:06:14
 */
package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.ArrayList;
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
    @Override
    public void syncHistory() {
        JSONObject obj = new JSONObject();
        Convertor convertor = new Convertor();
        String url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  + "/data/getHistoryDataCount";
        String countStr = HttpClientUtils.doGet(url , null);
        obj = obj.parseObject(countStr);
        long countValue = Long.parseLong(obj.get("count").toString());
        int syncSize = 1000;    //每次同步1000条
        for(int time = 0; time <= countValue / syncSize; time++) {
            url = "http://" + conf.getOrclip() + ":" + conf.getOrclport()  
                + "/data/getHistoryData?start=" + (time * syncSize) + "&end=" +((time+1) * syncSize);
            String ticketInfoStr = HttpClientUtils.doGet(url , null);
            obj = obj.parseObject(ticketInfoStr);
            syncDataFromOral(convertor.getTicketMainInfoList(obj));
        }
    }
    
}

