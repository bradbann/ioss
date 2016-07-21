package com.ggk.ioss.knowledgebasemgr.service;

import java.util.List;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface IKnowledgeOperator {
	
	public void insertKnowledgeByTickt(List<TicketMainInfo> ticketMainInfos);
}
