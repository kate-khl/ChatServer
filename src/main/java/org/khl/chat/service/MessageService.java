package org.khl.chat.service;

import org.khl.chat.model.MessageDto;

public interface MessageService {

	public void send (MessageDto msgDto);
	
	public void delete (Long id);
	
	public MessageDto edit (Long id, String text);
}
