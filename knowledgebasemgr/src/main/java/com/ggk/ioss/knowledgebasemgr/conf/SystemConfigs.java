package com.ggk.ioss.knowledgebasemgr.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "knowledgebase")  
public class SystemConfigs {
	
	private String esip;
	private String esport;
	private String dbusername;
	private String dbpassword;
	private String dburl;
	private String dbdriverClassName;
	private String portalip;
	private String portalport;
	private String apiinterfaceip;
	private String apiinterfaceeport;
	private String robotip;
	private String robotport;
	private String itsmcollectip;
	private String itsmcollectport;
	
	public String getPortalip() {
		return portalip;
	}
	public void setPortalip(String portalip) {
		this.portalip = portalip;
	}
	public String getPortalport() {
		return portalport;
	}
	public void setPortalport(String portalport) {
		this.portalport = portalport;
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
	public String getEsip() {
		return esip;
	}
	public void setEsip(String esip) {
		this.esip = esip;
	}
	public String getEsport() {
		return esport;
	}
	public void setEsport(String esport) {
		this.esport = esport;
	}
	public String getDbusername() {
		return dbusername;
	}
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}
	public String getDbpassword() {
		return dbpassword;
	}
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getDbdriverClassName() {
		return dbdriverClassName;
	}
	public void setDbdriverClassName(String dbdriverClassName) {
		this.dbdriverClassName = dbdriverClassName;
	}
	
}
