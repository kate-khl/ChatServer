package org.khl.chat.service;

import org.khl.chat.model.MessageDto;
import org.khl.chat.model.SendMessageRequest;

public interface MessageService {

	public void send (SendMessageRequest smReq, Long chatId);
	
	public void delete (Long id);
	
	public MessageDto edit (Long id, String text);
}
