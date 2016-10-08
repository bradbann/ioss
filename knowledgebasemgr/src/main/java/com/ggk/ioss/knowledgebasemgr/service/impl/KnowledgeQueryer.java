package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.conf.SystemConfigs;
import com.ggk.ioss.knowledgebasemgr.elasticsearch.ElasticSearchHandle;
import com.ggk.ioss.knowledgebasemgr.elasticsearch.ElasticSearchHandleSingleton;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeQueryer;
import com.ggk.ioss.knowledgebasemgr.utils.ElasticSearchUtils;

@Service
@EnableConfigurationProperties(SystemConfigs.class)
public class KnowledgeQueryer implements IKnowledgeQueryer {
    
    @Autowired
    private SystemConfigs conf;
    
    @Autowired
    private ElasticSearchHandleSingleton handle;
    
    @Override
    public List<Map<String, Object>> queryKnowledge(String indexName, String indexType, String queryJson) {
        ElasticSearchHandle handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
        SearchResponse searchResponse = handle.search(null, queryJson, 0, 5);
        handle.destory();
        return ElasticSearchUtils.getSearchResult(searchResponse);
    }

    @Override
    public Map<String, Object> queryKnowledgeByPage(String indexName,
            String indexType, String queryJson, int start, int limit) {
//        System.out.println(System.currentTimeMillis());
        SearchResponse searchResponse = handle.getHandle().search(null, queryJson, start, limit);
//        handle.destory();
//        System.out.println(System.currentTimeMillis());
        return ElasticSearchUtils.getSearchResultWithCount(searchResponse);
    }
}
