package org.khl.chat.dto;

import java.util.Collection;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CreateRequestChat {

	private Collection<Long> users;
	private String name;
	private String message;
//	private User creator;


	public String getMessage() {
		return message;
	}

	public Collection<Long> getUsers() {
		return users;
	}

	public String getName() {
		return name;
	}
}
