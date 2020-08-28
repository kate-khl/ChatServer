package org.khl.chat.model;

import java.util.Collection;

import org.khl.chat.entity.Chat;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class ChatDto {

	private Long id;
	private Collection<UserDto> users;
	private String name;
	private Collection<MessageDto> messages;
	private User author;
	
	public ChatDto(Chat chat) {
		this.id = chat.getId();
		this.users = chat.getUsersDto();
		this.name = chat.getName();
		this.messages = chat.getMessagesDto();
		this.author = chat.getAuthor();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<UserDto> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDto> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<MessageDto> getMessages() {
		return messages;
	}
	public void setMessages(Collection<MessageDto> messages) {
		this.messages = messages;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
}
