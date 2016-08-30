package com.ggk.ioss.portal.web.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
            queryParams = queryParams.replaceAll(" ", "%20");
        }
        JSONObject body = new JSONObject();
        body.put("queryParams", queryParams);
        
        String url = "http://"+ conf.getKnowledgebaseip() + ":" + conf.getKnowledgebaseport();
        //更新查询热词
        HttpClientUtils.doGet(url + "/ioss/knowledge/updatehotword?hotword=" + queryParams, null);
        //返回查询结果
        return HttpClientUtils.doPost(url + "/ioss/knowledge/queryer?queryParams="+queryParams, body.toJSONString());
    }
    
    @RequestMapping(value = {"/ioss/knowledge/queryhotwords"}, method = RequestMethod.GET)
    public JSONObject queryHotWordByKeyword(@RequestParam String keyword) {
        String url = "http://"+ conf.getKnowledgebaseip() + ":" + conf.getKnowledgebaseport() 
                   + "/ioss/knowledge/queryhotword?keyword=" + keyword;
        return JSONObject.parseObject(HttpClientUtils.doGet(url, null));
    }

}