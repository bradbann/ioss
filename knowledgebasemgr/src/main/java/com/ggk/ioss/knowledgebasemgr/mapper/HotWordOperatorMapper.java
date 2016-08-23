package com.ggk.ioss.knowledgebasemgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ggk.ioss.knowledgebasemgr.model.HotWord;

public interface HotWordOperatorMapper {
    
    public void updateHotWord(@Param("hotword") String hotword);
    
    public List<HotWord> queryHotWordsByKeyword(@Param("keyword") String keyword);
}
