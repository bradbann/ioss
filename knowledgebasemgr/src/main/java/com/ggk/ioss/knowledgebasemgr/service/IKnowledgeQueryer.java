package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;
import java.util.Map;

public interface IKnowledgeQueryer {
    
    public List<Map<String, Object>> queryKnowledge(String indexName, String indexType, String queryJson);
    
//    public long queryKnowledgeNum(String indexName, String indexType, String queryJson);
    
    public Map<String, Object> queryKnowledgeByPage(String indexName, String indexType, String queryJson, int start, int limit);
}
