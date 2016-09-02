package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.conf.SystemConfigs;
import com.ggk.ioss.knowledgebasemgr.elasticsearch.ElasticSearchHandle;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeQueryer;
import com.ggk.ioss.knowledgebasemgr.utils.ElasticSearchUtils;

@Service
@EnableConfigurationProperties(SystemConfigs.class)
public class KnowledgeQueryer implements IKnowledgeQueryer {
    
    @Autowired
    private SystemConfigs conf;

    @Override
    public List<Map<String, Object>> queryKnowledge(String indexName, String indexType, String queryJson) {
        ElasticSearchHandle handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
        SearchResponse searchResponse = handle.search(null, queryJson, 0, 40);    
        handle.destory();
        return ElasticSearchUtils.getSearchResult(searchResponse);
    }

}
