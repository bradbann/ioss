package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.mapper.TicketMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketDealInfo;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.ITicketService;

@Service
public class TicketService implements ITicketService {
	
	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public List<TicketDealInfo> queryTicketDealInfoByPage(long start, long limit) {
		// TODO Auto-generated method stub
		return ticketMapper.queryTicketDealInfoByPage(start, limit);
	}

	@Override
	public Long queryTicketDealInfoTotalNumber() {
		// TODO Auto-generated method stub
		return ticketMapper.queryTicketDealInfoTotalNumber();
	}

	@Override
	public List<TicketMainInfo> queryTicketMainInfoByPage(long start, long limit) {
		// TODO Auto-generated method stub
		return ticketMapper.queryTicketMainInfoByPage(start, limit);
	}

	@Override
	public Long queryTicketMainInfoTotalNumber() {
		// TODO Auto-generated method stub
		return ticketMapper.queryTicketMainInfoTotalNumber();
	}

}
