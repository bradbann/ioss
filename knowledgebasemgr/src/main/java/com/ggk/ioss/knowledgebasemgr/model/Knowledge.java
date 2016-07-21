package com.ggk.ioss.knowledgebasemgr.model;

public abstract class Knowledge {
	
	private String code;// 知识编码
	private String title;// 知识标题
	private String description;// 知识描述
	private String content;// 知识内容
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
