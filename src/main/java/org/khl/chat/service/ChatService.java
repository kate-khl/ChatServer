package org.khl.chat.service;

import java.util.Collection;

import org.khl.chat.entity.Chat;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.CreateRequestChat;
import org.khl.chat.model.UserDto;

public interface ChatService {

	public ChatDto createChat(CreateRequestChat chat);
	public void addUsers(Collection<UserDto> users, int id);
	public void removeUsers(Collection<UserDto> users, int id);
	public Collection<UserDto> getUsers(int id);
	public void removeChat(int id);
	
	
	
}
