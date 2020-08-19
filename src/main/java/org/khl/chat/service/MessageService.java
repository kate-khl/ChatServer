package org.khl.chat.service;

import org.khl.chat.model.MessageDto;

public interface MessageService {

	public void send (MessageDto msgDto);
	
	public void delete (int id);
	
	public MessageDto edit (int id, String text);
}
