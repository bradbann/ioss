package com.ggk.ioss.knowledgebasemgr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeOperator;
import com.ggk.ioss.knowledgebasemgr.service.ITicketService;

@RestController
public class OperatorController {
	
	@Autowired
	private IKnowledgeOperator operator;
	
	@Autowired
	private ITicketService ticketService;
	
	@RequestMapping(value = {"/ioss/knowledge/Operator"}, method = RequestMethod.GET)
	public String operation(@RequestParam String params,@RequestParam String operationType){
		return  "ok";
	}
	
	/**
	 * 触发工单入库ES
	 * @param params
	 * @param operationType
	 * @return
	 */
	@RequestMapping(value = {"/ioss/knowledge/trigger"}, method = RequestMethod.GET)
	public String trigger(){
		long totalNumber = ticketService.queryTicketMainInfoTotalNumber();
		List<TicketMainInfo> ticketMainInfos = ticketService.queryTicketMainInfoByPage(0, totalNumber);
		operator.insertKnowledgeByTickt(ticketMainInfos);
		return  "ok";
	}
	
}
