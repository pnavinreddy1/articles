package com.articles.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Article {
	
	private int docId;
	@NotNull
	@NotEmpty
	private String title;
	@NotNull
	@NotEmpty
	private String content;
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
