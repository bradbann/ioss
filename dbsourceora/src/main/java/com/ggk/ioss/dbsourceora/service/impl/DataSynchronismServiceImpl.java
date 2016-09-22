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
        return mapper.getTicketMainInfoFromOral(startDate.getTime()/1000,endDate.getTime()/1000, start, end);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return mapper.getDateEventCount(startDate.getTime()/1000,endDate.getTime()/1000);
    }
}

