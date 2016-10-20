/*
 * File Name：OralServiceImpl.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午4:32:45
 */
package com.ggk.ioss.dbsourceora.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggk.ioss.dbsourceora.mapper.DataSynchronismMapper;
import com.ggk.ioss.dbsourceora.model.TicketMainInfo;
import com.ggk.ioss.dbsourceora.service.DataSynchronismService;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午4:32:45
 */
@Service
public class DataSynchronismServiceImpl implements DataSynchronismService {
    
    @Autowired
    private DataSynchronismMapper mapper;
    @Override
    public List<TicketMainInfo> getTicketMainInfoFromOral(String date, long start, long end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59"); 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return mapper.getTicketMainInfoFromOral(startDate.getTime()/1000, 
                endDate.getTime()/1000, start, end);
    }
    
    @Override
    public long getDateEventCount(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59"); 
        } catch (ParseException e) {
            e.printStackTrace();
        } 
        return mapper.getDateEventCount(startDate.getTime()/1000, endDate.getTime()/1000);
    }
    
    @Override
    public List<TicketMainInfo> getHistoryData(long start, long end) {
        return mapper.getHistoryData(start, end);
    }
    
    @Override
    public long getHistoryDataCount() {
        return mapper.getHistoryDataCount();
    }

    /**
     * 废弃
     */
    @Override
    public List<TicketMainInfo> getRealTimeData(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate1 = new Date();
        Date endDate1 = new Date();
        try {
            startDate1 = sdf.parse(startDate);
            endDate1 = sdf.parse(endDate); 
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mapper.getRealTimeData(startDate1.getTime() / 1000, 
                endDate1.getTime() / 1000);
        
    }

    @Override
    public List<TicketMainInfo> getRealTimeOralData(long startTime) {
        return mapper.getRealTimeOralData(startTime);
    }

    @Override
    public long getMinUpdateTime() {
        return mapper.getMinUpdateTime();
    }

    @Override
    public long getMaxUpdateTime() {
        return mapper.getMaxUpdateTime();
    }

    @Override
    public List<TicketMainInfo> getHistoryDataByUpdateTime(long startTime,
            long endTime) {
        return mapper.getHistoryDataByUpdateTime(startTime, endTime);
    }
}

