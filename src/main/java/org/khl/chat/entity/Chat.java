package org.khl.chat.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.khl.chat.model.ChatDto;
import org.khl.chat.model.MessageDto;
import org.khl.chat.model.UserDto;

@Entity
public class Chat {

	@Id
	private int id;
	@ManyToMany(mappedBy = "chats")
	private Collection<User> users;
	private String name;
	@OneToMany(mappedBy = "chat")
	private Collection<Message> messages;
	
	public Chat() {}
	
	public Chat(int id, Collection<User> users, String name, Collection<Message> messages) {
		super();
		this.id = id;
		this.users = users;
		this.name = name;
		this.messages = messages;
	}
	
	public Chat(ChatDto chatDto) {
		super();
		this.id = chatDto.getId();
		this.users = convertDtoToUsers(chatDto.getUsers());
		this.name = chatDto.getName();
		this.messages = convertMsgDtoToMsg(chatDto.getMessages());
	}

	
	private static Collection<User> convertDtoToUsers(Collection<UserDto> usersDto) {
		Collection<User> users = new ArrayList<User>();  
		
		for (UserDto user : usersDto) {
			User u = new User(user);
			users.add(u);
		}
		return users;
	}
	
	private static Collection<Message> convertMsgDtoToMsg(Collection<MessageDto> msgDto) {
		Collection<Message> msgs = new ArrayList<Message>();  
		
		for (MessageDto msg : msgDto) {
			Message m = new Message(msg);
			msgs.add(m);
		}
		return msgs;
	}

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
