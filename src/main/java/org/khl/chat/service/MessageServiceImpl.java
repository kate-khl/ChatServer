package org.khl.chat.service;

import org.khl.chat.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.khl.chat.dao.MessageDao;
import org.khl.chat.entity.Message;
import org.khl.chat.exception.NotFoundException;;
 @Service
public class MessageServiceImpl implements MessageService{
	
	private static final Map<Long, Message> MESSAGE_MAP_REPOSITORY = new HashMap<>();
	private static final AtomicInteger MESSAGE_ID = new AtomicInteger();

	
//	@Autowired
//	private MessageDao mdao;
	
	@Override
	public void send(String value, Long chatId) {
		/*Long msg_id = (long)MESSAGE_ID.incrementAndGet();
		msgDto.setId(msg_id);
		MESSAGE_MAP_REPOSITORY.put(msg_id, new Message(msgDto));*/
	}

	@Override
	public void delete(Long id) {
		if (MESSAGE_MAP_REPOSITORY.containsKey(id))
			MESSAGE_MAP_REPOSITORY.remove(id);
		else throw new NotFoundException("Сообщение не найдено");
		
	}

	@Override
	public MessageDto edit(Long id, String text) {
		if (MESSAGE_MAP_REPOSITORY.containsKey(id))	{	
			Message msg = new Message();
			msg.setValue(text);
			MESSAGE_MAP_REPOSITORY.replace(id, msg);
			
			return new MessageDto(msg);
		}
		else throw new NotFoundException("Сообщение не найдено");

	}

	
}
