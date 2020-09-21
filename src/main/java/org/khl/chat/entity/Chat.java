package org.khl.chat.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Chat {

	@Id
    @SequenceGenerator(name = "chatGen")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private User author;

	//	@ManyToMany(mappedBy = "chats")
    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
    		name = "users_chats",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Collection<User> users;
    
	private String name;
	
	@OneToMany(mappedBy = "chat", fetch = FetchType.EAGER)
	private Collection<Message> messages;
	
	public Chat() {}
	
//	public Chat(ChatDto chatDto) {
//		super();
//		this.id = chatDto.getId();
//		this.users = convertDtoToUsers(chatDto.getUsers());
//		this.name = chatDto.getName();
//		this.author = chatDto.getAuthor();
//		this.messages = convertMsgDtoToMsg(chatDto.getMessages());
//	}

	
//	private static Collection<User> convertDtoToUsers(Collection<UserDto> usersDto) {
//		Collection<User> users = new ArrayList<User>();  
//		
//		for (UserDto user : usersDto) {
//			User u = new User(user);
//			users.add(u);
//		}
//		return users;
//	}
	
//	private static Collection<Message> convertMsgDtoToMsg(Collection<MessageDto> msgDto) {
//		Collection<Message> msgs = new ArrayList<Message>();  
//		
//		for (MessageDto msg : msgDto) {
//			Message m = new Message(msg);
//			msgs.add(m);
//		}
//		return msgs;
//	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
//	public Collection<UserDto> getUsersDto() {
//		Collection<UserDto> usersDto = new ArrayList<UserDto>();
//		for (User u : this.users)
//			usersDto.add(new UserDto(u));
//		return usersDto;
//	}
	
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
//	public void setMessages(Collection<Message> messages) {
//		this.messages = messages;
//	}
//	public Collection<Message> getMessages() {
//		return messages;
//	}
	
//	public Collection<MessageDto> getMessagesDto() {
//		Collection<MessageDto> msgsDto = new ArrayList<MessageDto>();
//		for (Message u : this.messages)
//			msgsDto.add(new MessageDto(u));
//		return msgsDto;
//	}
	
}
