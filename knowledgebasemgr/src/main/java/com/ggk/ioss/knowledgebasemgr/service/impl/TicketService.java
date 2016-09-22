package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.mapper.TicketMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketDealInfo;
import com.ggk.ioss.knowledgebasemgr.model.TicketES;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.ITicketService;

@Service
public class TicketService implements ITicketService {
    
    @Autowired
    private TicketMapper ticketMapper;
    
    @Override
    public List<TicketDealInfo> queryTicketDealInfoByPage(long start, long limit) {
        return ticketMapper.queryTicketDealInfoByPage(start, limit);
    }

    @Override
    public Long queryTicketDealInfoTotalNumber() {
        return ticketMapper.queryTicketDealInfoTotalNumber();
    }

    @Override
    public List<TicketMainInfo> queryTicketMainInfoByPage(long start, long limit) {
        return ticketMapper.queryTicketMainInfoByPage(start, limit);
    }

    @Override
    public Long queryTicketMainInfoTotalNumber() {
        return ticketMapper.queryTicketMainInfoTotalNumber();
    }
    
    @Override
    public List<TicketES> queryTicketES(long start, long limit) {
        return ticketMapper.queryTicketES(start, limit);
    }

	@Override
	public TicketMainInfo queryTicketMainInfoById(String eventId) {
		return ticketMapper.queryTicketMainInfoById(eventId);
	}
}
