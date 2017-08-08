package jp.co.rakus.java_marathon_middle.controller;

public class ArticleForm {
	private Integer id;
	private String name;
	private String content;
	public String getName() {
		return name;
	
}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setName(String name) {
		this.name = name;
	}
}