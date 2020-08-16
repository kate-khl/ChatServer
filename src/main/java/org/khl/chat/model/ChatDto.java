package org.khl.chat.model;

import java.util.Collection;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;

public class ChatDto {

	private int id;
	private Collection<User> users;
	private String name;
	private Collection<Message> messages;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Message> getMessages() {
		return messages;
	}
	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
}
