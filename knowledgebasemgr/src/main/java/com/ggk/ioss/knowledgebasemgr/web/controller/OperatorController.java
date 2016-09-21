package com.ggk.ioss.knowledgebasemgr.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ggk.ioss.knowledgebasemgr.model.TicketES;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.IKnowledgeOperator;
import com.ggk.ioss.knowledgebasemgr.service.ITicketOperator;
import com.ggk.ioss.knowledgebasemgr.service.ITicketService;

@RestController
public class OperatorController {
	
	@Autowired
	private IKnowledgeOperator operator;
	@Autowired
	private ITicketOperator ticketOperator;
	
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
		long start = 0;
		long limit = 1000;
		try {
			List<TicketMainInfo> ticketMainInfos = null;
			while(start + limit < totalNumber){
				ticketMainInfos = ticketService.queryTicketMainInfoByPage(start, limit);
				operator.insertKnowledgeByTickt(ticketMainInfos);
				start = start + limit;
			}
			ticketMainInfos = ticketService.queryTicketMainInfoByPage(start, limit);
			operator.insertKnowledgeByTickt(ticketMainInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "ok";
	}
	
	@RequestMapping(value={"/ioss/knowledge/ticketes"}, method = RequestMethod.GET)
	public JSONObject queryTicketES(@RequestParam long start, @RequestParam long limit) {
		JSONObject obj = new JSONObject();
		List<TicketES> list = ticketService.queryTicketES(start, limit);
		if(!CollectionUtils.isEmpty(list)) {
			obj.put("code", 200);
			obj.put("message", "success");
			ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
			for(TicketES ticketEs : list) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("eventId", ticketEs.getEventId());
				map.put("eventTitle", ticketEs.getEventTitle());
				map.put("eventDescr", ticketEs.getEventDescr());
				map.put("affectDegree", ticketEs.getAffectDegree());
				map.put("solution", ticketEs.getSolution());
				data.add(map);
			}
			obj.put("data", data);
		} else {
			obj.put("code", 404);
			obj.put("message", "failure");
		}
		return obj;
	}
	
	@RequestMapping(value={"/ioss/knowledge/ticket"}, method = RequestMethod.GET)
	public JSONObject queryTicket(String eventId) {
		JSONObject obj = new JSONObject();
		TicketMainInfo ticketMainInfo = ticketService.queryTicketMainInfoById(eventId);
		if(ticketMainInfo != null) {
			obj.put("code", 200);
			obj.put("message", "success");
			obj.put("data", ticketMainInfo);
		} else {
			obj.put("code", 404);
			obj.put("message", "failure");
		}
		return obj;
	}
	
	@RequestMapping(value={"/ioss/knowledge/tickets"}, method = RequestMethod.GET)
	public List<TicketES> getTickets(@RequestParam long start, @RequestParam long limit) {
		return ticketService.queryTicketES(start, limit);
	}
	
	/**
	 *触发工单入库到MySQL
	 *@param params
	 *@param
	 */
	@RequestMapping(value={"/ioss/knowledge/saveDataTrigger"}, method = RequestMethod.GET)
	public String saveDataTrigger(@RequestParam String filePath) {
		ticketOperator.saveTicketMainInfo(filePath);
		//String path= "C:\\Users\\lcc\\Documents\\文档\\项目\\【2016】地税ITSM\\事件单样例.csv";
		return "SUCCESS";
	}
}
