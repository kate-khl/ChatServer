package org.khl.chat.model;

import java.util.Date;

import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class MessageDto {
	
	private int id;
	private String value;
	private int authorId;
	private Date date;
	
	public MessageDto(int id, String value, int authorId, Date date) {
		super();
		this.id = id;
		this.value = value;
		this.authorId = authorId;
		this.date = date;
	}
	
	public MessageDto(Message msg) {
		this.id = msg.getId();
		this.value = msg.getValue();
		this.authorId = msg.getAuthorId();
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
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthor(int authorId) {
		this.authorId = authorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
