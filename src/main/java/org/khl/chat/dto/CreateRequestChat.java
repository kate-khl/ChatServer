package org.khl.chat.dto;

import java.util.Collection;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CreateRequestChat {

	private Collection<Long> userIds;
	private String name;
	private String message;
//	private User creator;

	public CreateRequestChat() {}
	
	public CreateRequestChat(Collection<Long> users, String name, String message) {
		this.userIds = users;
		this.name = name;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	public Collection<Long> getUsers() {
		return userIds;
	}

	public String getName() {
		return name;
	}
}
