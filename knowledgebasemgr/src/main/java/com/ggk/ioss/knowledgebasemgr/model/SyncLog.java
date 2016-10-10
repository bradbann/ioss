/*
 * File Name：SyncLog.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年10月9日 下午5:58:38
 */
package com.ggk.ioss.knowledgebasemgr.model;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年10月9日 下午5:58:38
 */
public class SyncLog {
    private String syncType;
    private String syncUrl;
    private String syncStatus;
    
    public String getSyncType() {
        return syncType;
    }
    public void setSyncType(String syncType) {
        this.syncType = syncType;
    }
    public String getSyncUrl() {
        return syncUrl;
    }
    public void setSyncUrl(String syncUrl) {
        this.syncUrl = syncUrl;
    }
    public String getSyncStatus() {
        return syncStatus;
    }
    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }
}

