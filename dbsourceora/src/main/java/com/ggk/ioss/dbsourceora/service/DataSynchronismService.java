/*
 * File Name：OralService.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午4:31:31
 */
package com.ggk.ioss.dbsourceora.service;

import java.util.List;

import com.ggk.ioss.dbsourceora.model.TicketMainInfo;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午4:31:31
 */
public interface DataSynchronismService {
    public List<TicketMainInfo> getTicketMainInfoFromOral(String date, long start, long end);
    public long getDateEventCount(String date);
    public List<TicketMainInfo> getHistoryData(long start, long end);
    public long getHistoryDataCount();
    public List<TicketMainInfo> getRealTimeData(String startDate, String endDate);
    public List<TicketMainInfo> getRealTimeOralData(long startTime);
}

