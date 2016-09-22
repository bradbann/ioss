/*
 * File Name：DataSynchronismService.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午8:05:17
 */
package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午8:05:17
 */
public interface DataSynchronismService {
    public void syncDataFromOral(List<TicketMainInfo> list);
    public String updateInscData(String date);
}

