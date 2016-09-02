package com.ggk.ioss.knowledgebasemgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.HotWordOperator;
import com.ggk.ioss.knowledgebasemgr.service.SingleKnowledgeQuerier;

@RestController
public class HotWordOperatorController {
    
    @Autowired
    private HotWordOperator hotwordOperator;
    
    @Autowired
    private SingleKnowledgeQuerier singleKnowledgeQuerier;
    
    @RequestMapping(value = { "/ioss/knowledge/updatehotword" }, method = RequestMethod.GET)
    public String updateHotWord(@RequestParam String hotword) {
        hotwordOperator.updateHotWord(hotword);
        return "succes";
    }
    
    @RequestMapping(value = { "/ioss/knowledge/queryhotword" }, method = RequestMethod.GET)
    public JSONObject queryHotWordByKeyword(@RequestParam String keyword) {
        String query = keyword.replace(keyword, "%" + keyword + "%");
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "success");
        obj.put("data", hotwordOperator.queryHotWordsByKeyword(query));
        return obj;
    }
    
    @RequestMapping(value = { "/ioss/knowledge/querySingleKnowledge" }, method = RequestMethod.GET)
    public TicketMainInfo querySingleKnowledge(String id) {
    	return singleKnowledgeQuerier.getTicketMainInfo(id);
    }
}
