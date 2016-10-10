/*
 * File Name：Convertor.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月29日 上午8:58:54
 */
package com.ggk.ioss.knowledgebasemgr.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月29日 上午8:58:54
 */
public class Convertor {
    public List<TicketMainInfo> getTicketMainInfoList(JSONObject obj) {
        List<TicketMainInfo> list = new ArrayList<TicketMainInfo>();
        JSONArray objArray = obj.getJSONArray("data");
        int size = objArray.size();
        for(int index = 0; index < size; index++) {
            JSONObject j = objArray.getJSONObject(index);
            TicketMainInfo tk = new TicketMainInfo();
            tk.setEventId(j.getString("eventId"));
            tk.setReportArea(j.getString("reportArea"));
            tk.setReportor(j.getString("reportor"));
            tk.setEventType(j.getString("eventType"));
            tk.setCommitTime(j.getString("commitTime"));
            tk.setEventTitle(j.getString("eventTitle"));
            tk.setEventDescr(j.getString("eventDescr"));
            tk.setEventClassify(j.getString("eventClassify"));
            tk.setOwnerSystem(j.getString("ownerSystem"));
            tk.setOwnerModule(j.getString("ownerModule"));
            tk.setSubModule(j.getString("subModule"));
            tk.setFuncMenu(j.getString("funcMenu"));
            tk.setAffectRange(j.getString("affectRange"));
            tk.setAffectDegree(j.getString("affectDegree"));
            tk.setCriticalDegree(j.getString("criticalDegree"));
            tk.setPri(j.getString("pri"));
            tk.setEventSource(j.getString("eventSource"));
            tk.setEventStatus(j.getString("eventStatus"));
            tk.setStatusReason(j.getString("statusReason"));
            tk.setSolveCode(j.getString("solveCode"));
            tk.setCloseCode(j.getString("closeCode"));
            tk.setCurrentDealGroup(j.getString("currentDealGroup"));
            tk.setCurrentDealor(j.getString("currentDealor"));
            tk.setSolution(j.getString("solution"));
            tk.setCreateTime(j.getString("createTime"));
            tk.setUpdateTime(j.getString("updateTime"));
            tk.setRequestId(j.getString("requestId"));
            tk.setEntryId(j.getString("entryId"));
            tk.setPhoneNumber(j.getString("phoneNumber"));
            list.add(tk);
        }
        return list;
    }
}

