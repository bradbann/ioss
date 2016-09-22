/*
 * File Name：JSONConvertor.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月20日 下午6:07:19
 */
package com.ggk.ioss.dbsourceora.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.dbsourceora.model.TicketMainInfo;

/**
 *
 * @author lcc (lincc@ggkbigdata.com)
 * @version 1.0, 2016年9月20日 下午6:07:19
 */
public class JSONConvertor {
    public JSONObject convertIntoJSON(List<TicketMainInfo> list) {
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "succes");
        obj.put("count", list.size());
        obj.put("data", list);
        return obj;
    }
    
    public JSONObject getDateEventCountJSON(long count) {
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "success");
        obj.put("count", count);
        return obj;
    }
}

