/*
 * File Name：TicketMainInfo.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午4:25:06
 */
package com.ggk.ioss.dbsourceora.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午4:25:06
 */
public class TicketMainInfo {
    private String eventId;
    private String reportArea;
    private String reportor;
    private String eventType;
    private String commitTime;
    private String eventTitle;
    private String eventDescr;
    private String eventClassify;
    private String ownerSystem;
    private String ownerModule;
    private String subModule;
    private String funcMenu;
    private String affectRange;
    private String affectDegree;
    private String criticalDegree;
    private String pri;
    private String eventSource;
    private String eventStatus;
    private String statusReason;
    private String solveCode;
    private String closeCode;
    private String currentDealGroup;
    private String currentDealor;
    private String solution;
    private String createTime;
    private String updateTime;
    
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getReportArea() {
        return reportArea;
    }
    public void setReportArea(String reportArea) {
        this.reportArea = reportArea;
    }
    public String getReportor() {
        return reportor;
    }
    public void setReportor(String reportor) {
        this.reportor = reportor;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;
    }
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public String getEventDescr() {
        return eventDescr;
    }
    public void setEventDescr(String eventDescr) {
        this.eventDescr = eventDescr;
    }
    public String getEventClassify() {
        return eventClassify;
    }
    public void setEventClassify(String eventClassify) {
        this.eventClassify = eventClassify;
    }
    public String getOwnerSystem() {
        return ownerSystem;
    }
    public void setOwnerSystem(String ownerSystem) {
        this.ownerSystem = ownerSystem;
    }
    public String getOwnerModule() {
        return ownerModule;
    }
    public void setOwnerModule(String ownerModule) {
        this.ownerModule = ownerModule;
    }
    public String getSubModule() {
        return subModule;
    }
    public void setSubModule(String subModule) {
        this.subModule = subModule;
    }
    public String getFuncMenu() {
        return funcMenu;
    }
    public void setFuncMenu(String funcMenu) {
        this.funcMenu = funcMenu;
    }
    public String getAffectRange() {
        return affectRange;
    }
    public void setAffectRange(String affectRange) {
        this.affectRange = affectRange;
    }
    public String getAffectDegree() {
        return affectDegree;
    }
    public void setAffectDegree(String affectDegree) {
        this.affectDegree = affectDegree;
    }
    public String getCriticalDegree() {
        return criticalDegree;
    }
    public void setCriticalDegree(String criticalDegree) {
        this.criticalDegree = criticalDegree;
    }
    public String getPri() {
        return pri;
    }
    public void setPri(String pri) {
        this.pri = pri;
    }
    public String getEventSource() {
        return eventSource;
    }
    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }
    public String getEventStatus() {
        return eventStatus;
    }
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
    public String getSolveCode() {
        return solveCode;
    }
    public void setSolveCode(String solveCode) {
        this.solveCode = solveCode;
    }
    public String getCloseCode() {
        return closeCode;
    }
    public void setCloseCode(String closeCode) {
        this.closeCode = closeCode;
    }
    public String getCurrentDealGroup() {
        return currentDealGroup;
    }
    public void setCurrentDealGroup(String currentDealGroup) {
        this.currentDealGroup = currentDealGroup;
    }
    public String getCurrentDealor() {
        return currentDealor;
    }
    public void setCurrentDealor(String currentDealor) {
        this.currentDealor = currentDealor;
    }
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}

