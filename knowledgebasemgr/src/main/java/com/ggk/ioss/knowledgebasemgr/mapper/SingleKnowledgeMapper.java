package com.ggk.ioss.knowledgebasemgr.mapper;

import org.apache.ibatis.annotations.Param;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface SingleKnowledgeMapper {

	public TicketMainInfo getTicketMainById(@Param("id") String id);
}
