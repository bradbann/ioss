package com.ggk.ioss.knowledgebasemgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ggk.ioss.knowledgebasemgr.model.TicketDealInfo;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface TicketMapper {
	
	public List<TicketDealInfo> queryTicketDealInfoByPage(@Param("start")long start, @Param("limit")long limit);
	
	public Long queryTicketDealInfoTotalNumber();
	
	public List<TicketMainInfo> queryTicketMainInfoByPage(@Param("start")long start, @Param("limit")long limit);
	
	public Long queryTicketMainInfoTotalNumber();
	
	
}
