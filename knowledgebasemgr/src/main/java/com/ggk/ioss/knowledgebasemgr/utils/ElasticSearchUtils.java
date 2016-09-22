package com.ggk.ioss.knowledgebasemgr.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightField;

/**
 * Elastic Search 工具类 解析查询结果，封装查询对象
 * 
 * @author caiyu
 *
 */
public class ElasticSearchUtils {

    private static Logger logger = Logger.getLogger(ElasticSearchUtils.class);

    public static List<Map<String, Object>> getSearchResult(SearchResponse searchResponse) {
        try {
            List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
            Iterator<Entry<String, Object>> iterator;
            HashMap<String, Object> resultMap;
            Entry<String, Object> entry;

            Map<String, HighlightField> highlightMap;
            Iterator<Entry<String, HighlightField>> highlightIterator;
            Entry<String, HighlightField> entryH;
            Object[] contents;
            for (SearchHit searchHit : searchResponse.getHits()) {
                iterator = searchHit.getSource().entrySet().iterator();
                resultMap = new HashMap<String, Object>();
                while (iterator.hasNext()) {
                    entry = iterator.next();
                    resultMap.put(entry.getKey(), entry.getValue());
                }
                highlightMap = searchHit.highlightFields();
                highlightIterator = highlightMap.entrySet().iterator();
                while (highlightIterator.hasNext()) {
                    entryH = highlightIterator.next();
                    contents = entryH.getValue().fragments();
                    if (contents.length == 1) {
                        resultMap.put(entryH.getKey(), contents[0].toString());
                    } else {
                        logger.warn("搜索结果中的高亮结果出现多数据contents.length = " + contents.length);
                    }
                }
                resultList.add(resultMap);
            }
            return resultList;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
