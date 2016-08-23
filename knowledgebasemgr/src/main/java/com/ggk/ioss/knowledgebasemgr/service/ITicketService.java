package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;

import com.ggk.ioss.knowledgebasemgr.model.TicketDealInfo;
import com.ggk.ioss.knowledgebasemgr.model.TicketES;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface ITicketService {

	public List<TicketDealInfo> queryTicketDealInfoByPage(long start, long limit);

	public Long queryTicketDealInfoTotalNumber();

	public List<TicketMainInfo> queryTicketMainInfoByPage(long start, long limit);
	
	public List<TicketES> queryTicketES(long start, long limit);

	public Long queryTicketMainInfoTotalNumber();
}
