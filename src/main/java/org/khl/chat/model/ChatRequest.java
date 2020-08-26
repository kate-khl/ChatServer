package org.khl.chat.model;

import java.util.Collection;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class ChatRequest {

	private int id;
	private Long[] users;
	private String name;
	private Collection<MessageDto> messages;
//	private User creator;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long[] getUsers() {
		return users;
	}
	public void setUsers(Long[] users) {
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
}
