package org.khl.chat.service;

import java.util.Collection;

import org.khl.chat.entity.Chat;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.CreateRequestChat;
import org.khl.chat.model.MessageDto;
import org.khl.chat.model.UserDto;

public interface ChatService {

	public ChatDto createChat(CreateRequestChat chat);
	public void addUsers(Collection<Long> userIds, Long id);
	public void removeUsers(Collection<Long> userIds, Long id);
	public Collection<UserDto> getUsers(Long id);
	public void removeChat(Long id);
	public ChatDto findChat(Long id);
	public Collection<MessageDto> getMessages(Long chatId);
	
	
	
}
