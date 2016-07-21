package com.ggk.ioss.knowledgebasemgr.storage;

import java.util.concurrent.LinkedBlockingQueue;

import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public class TicketDataStore {
	
	private static LinkedBlockingQueue<TicketMainInfo> ticketMainInfoList = new LinkedBlockingQueue<TicketMainInfo>(3000);

	public static LinkedBlockingQueue<TicketMainInfo> getTicketMainInfoList() {
		return ticketMainInfoList;
	}

	public static void setTicketMainInfoList(LinkedBlockingQueue<TicketMainInfo> ticketMainInfoList) {
		TicketDataStore.ticketMainInfoList = ticketMainInfoList;
	}

}
