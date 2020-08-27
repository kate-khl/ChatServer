package org.khl.chat.service;

import org.khl.chat.model.MessageDto;

public interface MessageService {

	public void send (String Value, Long chatId);
	
	public void delete (Long id);
	
	public MessageDto edit (Long id, String text);
}
