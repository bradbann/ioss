package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.mapper.HotWordOperatorMapper;
import com.ggk.ioss.knowledgebasemgr.model.HotWord;
import com.ggk.ioss.knowledgebasemgr.service.HotWordOperator;

@Service
public class HotWordOperatorImp implements HotWordOperator{
    
    @Autowired
    private HotWordOperatorMapper hotwordMapper;

    @Override
    public void updateHotWord(String hotword) {
        hotwordMapper.updateHotWord(hotword);
    }

    @Override
    public List<String> queryHotWordsByKeyword(String keyword) {
        List<HotWord> hotwords = hotwordMapper.queryHotWordsByKeyword(keyword);
        List<String> result = new ArrayList<String>();
        String query = keyword.replace("%", "");
        for(HotWord hotWord : hotwords) {
            result.add(hotWord.getHotword().replace(query, "<strong>" + query + "</strong>"));
        }
        return result;
    }
    
}
