package com.ggk.ioss.knowledgebasemgr.model;

/**
 * @author : lcc
 * @description : Ticket Event Model for ITSM
 * @problem : csv中存在两个优先级。
 */
public class TicketEvent {
    private String eventNum;                  //事件工单号
    private String problemEventNum;           //总局问题单号
    private String eventTitle;                //事件标题
    private String eventDesc;                 //事件描述
    private String eventType;                 //事件类型
    private String eventCategory;             //事件分类
    private String belongModel;               //归属模块
    private String belongSystem;              //归属系统
    private String subModel;                  //子模块
    private String funcMenu;                  //功能菜单
    private String useCaseVersion;            //用例版本
    private String influenceRange;            //影响范围
    private String influenceLevel;            //影响程度
    private String severity;                  //紧急程度
    private String priority;                  //优先级
    private String eventStatus;               //事件状态
    private String reportRegion;              //报告地区
    private String organization;              //组织
    private String reporter;                  //报告人员
    private String reportTime;                //报告时间
    private String blockedGroup;              //当前受阻组
    private String currentDealer;             //当前受理人
    private String solution;                  //解决方案
    private String responseTime;              //总局反馈时间
    private String lastFixTime;               //最后解决时间
    private String lastFixDealer;             //最后解决人
    private String regionFixReport;           //地市解决情况
    private String provinceTime;              //升级到省级服务时间
    private String exceptTime;                //目标响应时间
    private String actualTime;                //实际响应时间
    private String exceptFixTime;             //目标解决时间
    private String actualFixTime;             //实际解决时间
    public String getEventNum() {
        return eventNum;
    }
    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }
    public String getProblemEventNum() {
        return problemEventNum;
    }
    public void setProblemEventNum(String problemEventNum) {
        this.problemEventNum = problemEventNum;
    }
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public String getEventDesc() {
        return eventDesc;
    }
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getEventCategory() {
        return eventCategory;
    }
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
    public String getBelongModel() {
        return belongModel;
    }
    public void setBelongModel(String belongModel) {
        this.belongModel = belongModel;
    }
    public String getBelongSystem() {
        return belongSystem;
    }
    public void setBelongSystem(String belongSystem) {
        this.belongSystem = belongSystem;
    }
    public String getSubModel() {
        return subModel;
    }
    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }
    public String getFuncMenu() {
        return funcMenu;
    }
    public void setFuncMenu(String funcMenu) {
        this.funcMenu = funcMenu;
    }
    public String getUseCaseVersion() {
        return useCaseVersion;
    }
    public void setUseCaseVersion(String useCaseVersion) {
        this.useCaseVersion = useCaseVersion;
    }
    public String getInfluenceRange() {
        return influenceRange;
    }
    public void setInfluenceRange(String influenceRange) {
        this.influenceRange = influenceRange;
    }
    public String getInfluenceLevel() {
        return influenceLevel;
    }
    public void setInfluenceLevel(String influenceLevel) {
        this.influenceLevel = influenceLevel;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getEventStatus() {
        return eventStatus;
    }
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
    public String getReportRegion() {
        return reportRegion;
    }
    public void setReportRegion(String reportRegion) {
        this.reportRegion = reportRegion;
    }
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public String getReporter() {
        return reporter;
    }
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    public String getReportTime() {
        return reportTime;
    }
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
    public String getBlockedGroup() {
        return blockedGroup;
    }
    public void setBlockedGroup(String blockedGroup) {
        this.blockedGroup = blockedGroup;
    }
    public String getCurrentDealer() {
        return currentDealer;
    }
    public void setCurrentDealer(String currentDealer) {
        this.currentDealer = currentDealer;
    }
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getResponseTime() {
        return responseTime;
    }
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }
    public String getLastFixTime() {
        return lastFixTime;
    }
    public void setLastFixTime(String lastFixTime) {
        this.lastFixTime = lastFixTime;
    }
    public String getLastFixDealer() {
        return lastFixDealer;
    }
    public void setLastFixDealer(String lastFixDealer) {
        this.lastFixDealer = lastFixDealer;
    }
    public String getRegionFixReport() {
        return regionFixReport;
    }
    public void setRegionFixReport(String regionFixReport) {
        this.regionFixReport = regionFixReport;
    }
    public String getProvinceTime() {
        return provinceTime;
    }
    public void setProvinceTime(String provinceTime) {
        this.provinceTime = provinceTime;
    }
    public String getExceptTime() {
        return exceptTime;
    }
    public void setExceptTime(String exceptTime) {
        this.exceptTime = exceptTime;
    }
    public String getActualTime() {
        return actualTime;
    }
    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }
    public String getExceptFixTime() {
        return exceptFixTime;
    }
    public void setExceptFixTime(String exceptFixTime) {
        this.exceptFixTime = exceptFixTime;
    }
    public String getActualFixTime() {
        return actualFixTime;
    }
    public void setActualFixTime(String actualFixTime) {
        this.actualFixTime = actualFixTime;
    }
}
