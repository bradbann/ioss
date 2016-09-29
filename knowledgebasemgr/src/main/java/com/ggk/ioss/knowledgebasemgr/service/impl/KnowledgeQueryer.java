package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.*;

import org.elasticsearch.action.count.CountResponse;
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
        SearchResponse searchResponse = handle.search(null, queryJson, 0, 5);
        handle.destory();
        return ElasticSearchUtils.getSearchResult(searchResponse);
    }

    @Override
    public Map<String, Object> queryKnowledgeByPage(String indexName,
            String indexType, String queryJson, int start, int limit) {
        ElasticSearchHandle handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
        SearchResponse searchResponse = handle.search(null, queryJson, start, limit);
        //获取总条数
        //long recordCount = searchResponse.getHits().getTotalHits();
        handle.destory();
        return ElasticSearchUtils.getSearchResultWithCount(searchResponse);
    }

//    @SuppressWarnings("deprecation")
//    @Override
//    public long queryKnowledgeNum(String indexName, String indexType,
//            String queryJson) {
//        // TODO Auto-generated method stub
//        ElasticSearchHandle handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
//        /*SearchResponse searchResponse = handle.search(null, queryJson, 0, 1);
//        long response = searchResponse.getHits().getTotalHits();*/
//        //handle.getClient().prepareCount(arg0)
////        CountResponse response = handle.getClient().prepareCount(queryJson)
////                .setQuery(termQuery("_type", "itsm"))
////                .execute()
////                .actionGet();
//        long num = handle.count(queryJson);
//        handle.destory();
//        return num;
//    }

}
