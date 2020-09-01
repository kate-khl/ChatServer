package org.khl.chat.service;

import java.util.Collection;

import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.CreateRequestChat;
import org.khl.chat.dto.MessageDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.Chat;

public interface ChatService {

	public ChatDto createChat(CreateRequestChat chat);
	public void addUsers(Collection<Long> userIds, Long id);
	public void removeUsers(Collection<Long> userIds, Long id);
//	public Collection<UserDto> getUsers(Long id);
	public void removeChat(Long id);
	public ChatDto findChat(Long id);
//	public Collection<MessageDto> getMessages(Long chatId);
	
	
	
}
