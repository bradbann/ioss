package com.ggk.ioss.knowledgebasemgr.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.ioss.knowledgebasemgr.commons.IConstants;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeQueryer;

@RestController
public class QueryerController {

    @Autowired
    private IKnowledgeQueryer queryer;

    @RequestMapping(value = { "/ioss/knowledge/queryer" }, method = RequestMethod.GET)
    public Map<String, Object> query(@RequestParam String queryParams, int start, int limit) {
//        return queryer.queryKnowledge(IConstants.deafult_index_name, IConstants.deafult_index_type, queryParams);
        return queryer.queryKnowledgeByPage(IConstants.deafult_index_name, IConstants.deafult_index_type, queryParams,start,limit);
    }
    
//    @RequestMapping(value = { "/ioss/knowledge/queryernum" }, method = RequestMethod.GET)
//    public long query(@RequestParam String queryParams) {
//        return queryer.queryKnowledgeNum(IConstants.deafult_index_name, IConstants.deafult_index_type, queryParams);
//    }
}
