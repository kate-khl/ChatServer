package org.khl.chat.model;

import java.util.Date;

import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class MessageDto {
	
	private int id;
	private String value;
	private User author;
	private Date date;
	
	public MessageDto(int id, String value, User author, Date date) {
		super();
		this.id = id;
		this.value = value;
		this.author = author;
		this.date = date;
	}
	
	public MessageDto(Message msg) {
		this.id = msg.getId();
		this.value = msg.getValue();
		this.author = msg.getAuthor();
		this.date = msg.getDate();
	}
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
