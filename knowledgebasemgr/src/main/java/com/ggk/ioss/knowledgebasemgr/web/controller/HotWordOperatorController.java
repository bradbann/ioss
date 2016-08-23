package com.ggk.ioss.knowledgebasemgr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.ioss.knowledgebasemgr.model.HotWord;
import com.ggk.ioss.knowledgebasemgr.service.HotWordOperator;

@RestController
public class HotWordOperatorController {
    
    @Autowired
    private HotWordOperator hotwordOperator;
    
    @RequestMapping(value = { "/ioss/knowledge/updatehotword" }, method = RequestMethod.GET)
    public String updateHotWord(@RequestParam String hotword) {
        hotwordOperator.updateHotWord(hotword);
        return "succes";
    }
    
    @RequestMapping(value = { "/ioss/knowledge/queryhotword" }, method = RequestMethod.GET)
    public List<HotWord> queryHotWordByKeyword(@RequestParam String keyword) {
        String query = keyword.replace(keyword, "%" + keyword + "%");
        return hotwordOperator.queryHotWordsByKeyword(query);
    }
}
