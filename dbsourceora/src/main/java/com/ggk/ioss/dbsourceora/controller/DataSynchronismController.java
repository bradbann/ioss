/*
 * File Name：DataSynchronismController.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午4:36:38
 */
package com.ggk.ioss.dbsourceora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.dbsourceora.service.DataSynchronismService;
import com.ggk.ioss.dbsourceora.util.JSONConvertor;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午4:36:38
 */
@RestController
public class DataSynchronismController {
    @Autowired
    private DataSynchronismService service;
    
    private JSONConvertor convertor = new JSONConvertor();
    
    @RequestMapping(value = {"data/getTickInfo"}, method = RequestMethod.GET)
    public JSONObject getDetectionCategory(@RequestParam String date, @RequestParam long start, @RequestParam long end) {
        return convertor.convertIntoJSON(service.getTicketMainInfoFromOral(date, start, end));
    }
    
    @RequestMapping(value = {"data/getDateEventCount"}, method = RequestMethod.GET)
    public JSONObject getDateEventCount(@RequestParam String date) {
        return convertor.getDateEventCountJSON(service.getDateEventCount(date));
    }
}

