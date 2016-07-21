package com.ggk.ioss.itsmcollect.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "itsmcollect")  
public class ItsmcollectSettings {
	
	private String esip;
	private String esport;
	private String dbusername;
	private String dbpassword;
	private String dburl;
	private String dbdriverClassName;
	
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
