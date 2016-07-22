package com.ggk.ioss.portal.web.contorller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.portal.utils.HttpClientUtils;

@RestController
public class ApiController{
	
	@RequestMapping(value = "/ioss/knowledge/queryer")
    public String index(@RequestParam String queryParams) {
		if(!StringUtils.isEmpty(queryParams)){
			queryParams = queryParams.trim();
			queryParams = queryParams.replaceAll(" ", "");
		}
		JSONObject body = new JSONObject();
		body.put("queryParams", queryParams);
        return HttpClientUtils.doPost("http://localhost:8004/ioss/knowledge/queryer?queryParams="+queryParams, body.toJSONString());
    }
	
}