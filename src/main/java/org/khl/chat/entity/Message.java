package org.khl.chat.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.khl.chat.model.MessageDto;

@Entity
public class Message {

	@Id
	private int id;
	private String value;
	private int userId;
	private Date date;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "chat_id")
	private Chat chat;
	
	public Message() {}
	
	public Message(int id, String value, int authorId, Date date) {
		super();
		this.id = id;
		this.value = value;
		this.userId = authorId;
		this.date = date;
	}
	
	public Message(MessageDto msgDto) {
		super();
		this.id = msgDto.getId();
		this.value = msgDto.getValue();
		this.userId = msgDto.getAuthorId();
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
		return userId;
	}
	public void setAuthorId(int authorId) {
		this.userId = authorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
