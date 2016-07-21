package com.ggk.ioss.knowledgebasemgr.model;

public abstract class KnowledgeIndex {
	
	private String code;// 索引编码
	private String type;// 索引类型
	private String name;// 索引名称
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
