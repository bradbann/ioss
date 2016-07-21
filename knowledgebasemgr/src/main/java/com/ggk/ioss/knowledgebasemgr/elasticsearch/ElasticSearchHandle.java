package com.ggk.ioss.knowledgebasemgr.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.commons.IConstants;

/**
 * Es 操作类
 * 提供 es 的 增删改查
 * @author caiyu
 *
 */
public class ElasticSearchHandle {

	private Logger logger = Logger.getLogger(ElasticSearchHandle.class);

	private Client client;

	private String addr;

	private int port;

	public ElasticSearchHandle(String addr, int port) {
		this.addr = addr;
		this.port = port;
		if (!this.init()) {
			logger.error("can not instance client due to unknow host : " + this.addr + this.port);
		}
	}

	private boolean init() {
		try {
			setClient(TransportClient.builder().build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(this.addr), this.port)));
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}

	public Client getClient() {
		if (null == client) {
			if (!this.init()) {
				logger.error("can not instance client due to unknown host : " + this.addr + this.port);
			}
		}
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * 关键字查询，将关键字分次后查询，多个字段code content等,分页返回结果
	 * 
	 * @param fields
	 * @param queryKey
	 * @param start
	 * @param limit
	 * @return
	 */
	public SearchResponse search(List<String> fields, String queryKey, int start, int limit) {
		// 构造查询器
		SearchRequestBuilder searchRequestBuilder = this.getClient().prepareSearch(IConstants.deafult_index_name)
				.setTypes(IConstants.deafult_index_type);

		QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(queryKey);
		
		/**
		 * ik分词器
		 * ik_max_word:
		 * 会将文本做最细粒度的拆分，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,中华人民,中华,华人,人民共和国,人民,人,民,共和国,
		 * 共和,和,国国,国歌”，会穷尽各种可能的组合；
		 * ik_smart: 会做最粗粒度的拆分，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,国歌”。
		 */
		// 暂时不用分词器
		queryBuilder.analyzer("ik_max_word");
		if(!CollectionUtils.isEmpty(fields)){
			for(String field : fields){
				if(StringUtils.isNotEmpty(field)){
					queryBuilder.field(field);
					searchRequestBuilder.addHighlightedField(field);
				}
			}
		}else{
			// 默认匹配title description content
			queryBuilder.field("title").field("content").field("description");
			searchRequestBuilder.addHighlightedField("title");
			searchRequestBuilder.addHighlightedField("content");
			searchRequestBuilder.addHighlightedField("description");
		}
		
        searchRequestBuilder.setHighlighterPreTags("<span style=\"color:red\">");
        searchRequestBuilder.setHighlighterPostTags("</span>");
		
		searchRequestBuilder.setQuery(queryBuilder);
		// 分页应用
		searchRequestBuilder.setFrom(start).setSize(limit);
		// 设置是否按查询匹配度排序
		searchRequestBuilder.setExplain(true);

		return searchRequestBuilder.execute().actionGet();

	}
	
	/**
	 * 通用插入方法，新增知识条目
	 * @param sourceJson
	 * @return
	 */
	public IndexResponse insert(JSONObject sourceJson) {
		IndexRequest indexRequest = new IndexRequest(IConstants.deafult_index_name, IConstants.deafult_index_type,
				UUID.randomUUID().toString());
		indexRequest.source(sourceJson);
		return this.getClient().index(indexRequest).actionGet();
	}
	
	/**
	 * 释放连接
	 */
	public void destory(){
		if(null != this.client){
			this.client.close();
		}
		logger.debug("destory client");
		System.out.println("destory client");
	}
	
//	public static void main(String[] args) {
//		ElasticSearchHandle handler = new ElasticSearchHandle("localhost", 9300);
//		JSONObject data =new JSONObject();
//		data.put("title", "韩国和风格");
//		data.put("content", "以太交换机");
//		data.put("description", "很过分的话");
//		//handler.insert(data);
//		System.out.println(handler.search(null, "小当家是韩国的", 0, 1000).getHits().getHits().length);
//		handler.destory();
//	}

}
