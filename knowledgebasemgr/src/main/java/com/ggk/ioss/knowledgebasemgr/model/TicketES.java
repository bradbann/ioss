package com.ggk.ioss.knowledgebasemgr.model;

/**
 * @author lcc
 * @desc 数据迁移对象，从MySql中的工单信息TicketMainInfo迁移数据到ES存储中。
 *       ES存储中，仅需要4个字段信息：
 *       eventId：事件Id
 *       eventTitle:事件标题
 *       event_descr:事件描述
 *       affect_degree:影响程度
 *       solution：解决方案
 */
public class TicketES {
    private String eventId;
    private String eventTitle;
    private String eventDescr;
    private String affectDegree;
    private String solution;
    
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getEventDescr() {
        return eventDescr;
    }
    public void setEventDescr(String eventDescr) {
        this.eventDescr = eventDescr;
    }
    public String getAffectDegree() {
        return affectDegree;
    }
    public void setAffectDegree(String affectDegree) {
        this.affectDegree = affectDegree;
    }
    
}
