/*
	 * File Name：DataSynchronismMapper.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 上午11:37:18
 */
package com.ggk.ioss.dbsourceora.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ggk.ioss.dbsourceora.model.TicketMainInfo;


/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 上午11:37:18
 */
public interface DataSynchronismMapper {
    public List<TicketMainInfo> getTicketMainInfoFromOral(@Param("startDate") long startDate,
            @Param("endDate") long endDate, @Param("start") long start, @Param("end") long end);
    public long getDateEventCount(@Param("startDate") long startDate,@Param("endDate") long endDate);
    public List<TicketMainInfo> getHistoryData( @Param("start") long start, @Param("end") long end);
    public long getHistoryDataCount();
    public List<TicketMainInfo> getRealTimeData(@Param("startDate") long startDate, @Param("endDate") long endDate);
}

