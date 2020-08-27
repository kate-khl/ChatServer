package org.khl.chat.model;

import java.util.Date;

import org.khl.chat.entity.Chat;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class MessageDto {
	
	private Long id;
	private String value;
	private Long authorId;
	private Date date;
	private Chat chat;
	

	public MessageDto(Long id, String value, Long authorId, Date date) {
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
	
	public MessageDto(String value, Long authorId) {

		this.value = value;
		this.authorId = authorId;
		this.date = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthor(Long authorId) {
		this.authorId = authorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public Chat getChat() {
		return chat;
	}

	
}
