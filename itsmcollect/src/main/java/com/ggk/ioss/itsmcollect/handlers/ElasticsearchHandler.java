package com.ggk.ioss.itsmcollect.handlers;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.itsmcollect.utils.HttpClientUtils;

@Component
public class ElasticsearchHandler {
	
	private String ip;
	private String port;
	
//	private ElasticsearchHandler handler;
	
	public ElasticsearchHandler(String ip, String port){
//		if(null == handler){
//			handler = new ElasticsearchHandler(ip,port);
//		}
		this.ip = ip;
		this.port = port;
	}
	
//	public ElasticsearchHandler getHandler(){
//		if(null == handler){
//			handler = new ElasticsearchHandler(this.ip,this.port);
//		}
//		return handler;
//	}
	
	public void insert(JSONObject obj){
		JSONObject data =new JSONObject();
		data.put("title", "中华小当家");
		data.put("content", "这是一个特级厨师");
		data.put("description", "这个人物来自一个动画片");
		HttpClientUtils.doPost("http://"+ this.ip + ":" + this.port + "/itsmKB/itsm/", data.toJSONString());
	}
	
	public JSONArray query(JSONObject queryParams){
		
		return null;
	}
	
	public static void main(String[] args) {
		ElasticsearchHandler handler = new ElasticsearchHandler("localhost", "9200");
		handler.insert(null);
	}

	
}
