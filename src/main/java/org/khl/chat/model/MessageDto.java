package org.khl.chat.model;

import org.khl.chat.entity.User;

public class MessageDto {
	
	private int id;
	private String value;
	private User author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

	
}
