package com.ggk.ioss.portal.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "portal")  
public class SystemConfigs {
	
	private String knowledgebaseip;
	private String knowledgebaseport;
	private String apiinterfaceip;
	private String apiinterfaceeport;
	private String robotip;
	private String robotport;
	private String itsmcollectip;
	private String itsmcollectport;
	
	public String getKnowledgebaseip() {
		return knowledgebaseip;
	}
	public void setKnowledgebaseip(String knowledgebaseip) {
		this.knowledgebaseip = knowledgebaseip;
	}
	public String getKnowledgebaseport() {
		return knowledgebaseport;
	}
	public void setKnowledgebaseport(String knowledgebaseport) {
		this.knowledgebaseport = knowledgebaseport;
	}
	public String getApiinterfaceip() {
		return apiinterfaceip;
	}
	public void setApiinterfaceip(String apiinterfaceip) {
		this.apiinterfaceip = apiinterfaceip;
	}
	public String getApiinterfaceeport() {
		return apiinterfaceeport;
	}
	public void setApiinterfaceeport(String apiinterfaceeport) {
		this.apiinterfaceeport = apiinterfaceeport;
	}
	public String getRobotip() {
		return robotip;
	}
	public void setRobotip(String robotip) {
		this.robotip = robotip;
	}
	public String getRobotport() {
		return robotport;
	}
	public void setRobotport(String robotport) {
		this.robotport = robotport;
	}
	public String getItsmcollectip() {
		return itsmcollectip;
	}
	public void setItsmcollectip(String itsmcollectip) {
		this.itsmcollectip = itsmcollectip;
	}
	public String getItsmcollectport() {
		return itsmcollectport;
	}
	public void setItsmcollectport(String itsmcollectport) {
		this.itsmcollectport = itsmcollectport;
	}
	
}
