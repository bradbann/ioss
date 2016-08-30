package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;

import com.ggk.ioss.knowledgebasemgr.model.HotWord;

public interface HotWordOperator {
    public void updateHotWord(String hotword);
    
    public List<String> queryHotWordsByKeyword(String keyword);
}
