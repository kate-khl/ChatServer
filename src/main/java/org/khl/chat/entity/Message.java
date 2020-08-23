package org.khl.chat.entity;

import java.util.Date;

import org.khl.chat.model.MessageDto;

public class Message {

	private int id;
	private String value;
	private int authorId;
	private Date date;
	
	public Message() {}
	
	public Message(int id, String value, int authorId, Date date) {
		super();
		this.id = id;
		this.value = value;
		this.authorId = authorId;
		this.date = date;
	}
	
	public Message(MessageDto msgDto) {
		super();
		this.id = msgDto.getId();
		this.value = msgDto.getValue();
		this.authorId = msgDto.getAuthorId();
		this.date = msgDto.getDate();
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
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
