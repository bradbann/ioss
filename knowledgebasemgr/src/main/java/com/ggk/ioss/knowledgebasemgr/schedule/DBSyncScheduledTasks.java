/*
 * File Name：DBSyncScheduledTasks.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年10月9日 下午5:08:53
 */
package com.ggk.ioss.knowledgebasemgr.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ggk.ioss.knowledgebasemgr.service.DataSynchronismService;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年10月9日 下午5:08:53
 */
@Component
@Configurable
@EnableScheduling
public class DBSyncScheduledTasks {
    @Autowired
    private DataSynchronismService service;
    @Scheduled(cron = "* * 0/12 * * *")    //每12小时执行一次
    public void dbSyncTasks(){
        service.syncRealTimeData();
        System.out.println("--------------------DBSyncTasks--------------");
    }
}