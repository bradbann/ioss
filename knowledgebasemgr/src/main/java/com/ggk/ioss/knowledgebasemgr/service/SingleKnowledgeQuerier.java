package com.ggk.ioss.knowledgebasemgr.service;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface SingleKnowledgeQuerier {

	public TicketMainInfo getTicketMainInfo(String id);
}
