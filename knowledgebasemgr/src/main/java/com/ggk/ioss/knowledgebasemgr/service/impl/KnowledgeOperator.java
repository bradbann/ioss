package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.conf.SystemConfigs;
import com.ggk.ioss.knowledgebasemgr.elasticsearch.ElasticSearchHandle;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeOperator;

@Service
@EnableConfigurationProperties(SystemConfigs.class)
//@EnableConfigurationProperties(TicketMainInfoProperties.class)
public class KnowledgeOperator implements IKnowledgeOperator {

    @Autowired
    private SystemConfigs conf;
    
    @Override
    public void insertKnowledgeByTickt(List<TicketMainInfo> ticketMainInfos) {
        if(!CollectionUtils.isEmpty(ticketMainInfos)){
            ElasticSearchHandle handle = new ElasticSearchHandle(conf.getEsip(),Integer.parseInt(conf.getEsport()), conf.getEscluster());
            JSONObject data = null;
            long start = System.currentTimeMillis();
            for(TicketMainInfo ticketMainInfo : ticketMainInfos){
                data =new JSONObject();
                data.put("eventId", ticketMainInfo.getEventId());
                data.put("title", ticketMainInfo.getEventTitle());
                data.put("content", ticketMainInfo.getSolution());
                data.put("description", ticketMainInfo.getEventDescr());
                data.put("commitTime", ticketMainInfo.getCommitTime());
                data.put("updateTime", ticketMainInfo.getCommitTime());// TODO 使用同一个时间，后续需要修改
                handle.insert(data);
            }
            handle.destory();
            System.out.println("Cost total time : " +( System.currentTimeMillis() - start));
        }
    }
}
