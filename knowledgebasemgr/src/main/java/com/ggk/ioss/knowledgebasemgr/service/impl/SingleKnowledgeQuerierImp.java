package com.ggk.ioss.knowledgebasemgr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.mapper.SingleKnowledgeMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.SingleKnowledgeQuerier;

@Service
public class SingleKnowledgeQuerierImp implements SingleKnowledgeQuerier {
    
    @Autowired
    private SingleKnowledgeMapper singleKnowledgeMapper;

    @Override
    public TicketMainInfo getTicketMainInfo(String id) {
        return singleKnowledgeMapper.getTicketMainById(id);
    }

    
}
