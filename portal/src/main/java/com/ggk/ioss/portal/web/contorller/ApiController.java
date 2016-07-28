package com.ggk.ioss.portal.web.contorller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.portal.conf.SystemConfigs;
import com.ggk.ioss.portal.utils.HttpClientUtils;

@RestController
@EnableConfigurationProperties(SystemConfigs.class)
public class ApiController{
	
	@Autowired
	private SystemConfigs conf;
	
	@RequestMapping(value = "/ioss/knowledge/queryer")
    public String index(@RequestParam String queryParams) {
		if(!StringUtils.isEmpty(queryParams)){
			queryParams = queryParams.trim();
			queryParams = queryParams.replaceAll(" ", "");
		}
		JSONObject body = new JSONObject();
		body.put("queryParams", queryParams);
		String url = "http://"+ conf.getKnowledgebaseip() + ":" + conf.getKnowledgebaseport();
        return HttpClientUtils.doPost(url + "/ioss/knowledge/queryer?queryParams="+queryParams, body.toJSONString());
    }
	
}