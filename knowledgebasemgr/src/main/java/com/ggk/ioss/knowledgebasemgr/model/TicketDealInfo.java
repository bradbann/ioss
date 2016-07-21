package com.ggk.ioss.knowledgebasemgr.model;

import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TicketDealInfo {
	
	private String eventId;
	private String stepId;
	private String commitor;
	private Timestamp commitTime;
	private String fileNumbers;
	private String dealSuggest;
	private String nextDealGroup;
	private String nextDealor;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getCommitor() {
		return commitor;
	}
	public void setCommitor(String commitor) {
		this.commitor = commitor;
	}
	public Timestamp getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Timestamp commitTime) {
		this.commitTime = commitTime;
	}
	public String getFileNumbers() {
		return fileNumbers;
	}
	public void setFileNumbers(String fileNumbers) {
		this.fileNumbers = fileNumbers;
	}
	public String getDealSuggest() {
		return dealSuggest;
	}
	public void setDealSuggest(String dealSuggest) {
		this.dealSuggest = dealSuggest;
	}
	public String getNextDealGroup() {
		return nextDealGroup;
	}
	public void setNextDealGroup(String nextDealGroup) {
		this.nextDealGroup = nextDealGroup;
	}
	public String getNextDealor() {
		return nextDealor;
	}
	public void setNextDealor(String nextDealor) {
		this.nextDealor = nextDealor;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
