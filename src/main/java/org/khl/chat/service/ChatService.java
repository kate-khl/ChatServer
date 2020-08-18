package org.khl.chat.service;

import java.util.Collection;

import org.khl.chat.entity.Chat;
import org.khl.chat.model.UserDto;

public interface ChatService {

	public void createChat(Collection<UserDto> users, String name);
	public void addUsers(Collection<UserDto> users, int id);
	public void removeUsers(Collection<UserDto> users, int id);
	public Collection<UserDto> getUsers(int id);
	public void removeChat(int id);
	
	
	
}
