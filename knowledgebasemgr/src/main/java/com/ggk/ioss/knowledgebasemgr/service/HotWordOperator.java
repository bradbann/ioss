package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;

public interface HotWordOperator {
    public void updateHotWord(String hotword);
    
    public List<String> queryHotWordsByKeyword(String keyword);
}
