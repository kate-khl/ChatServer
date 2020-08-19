package org.khl.chat.service;

import org.khl.chat.model.MessageDto;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.khl.chat.entity.Message;
import org.khl.chat.exception.NotFoundException;;

public class MessageServiceImpl implements MessageService{
	
	private static final Map<Integer, Message> MESSAGE_MAP_REPOSITORY = new HashMap<>();
	private static final AtomicInteger MESSAGE_ID = new AtomicInteger();

	@Override
	public void send(MessageDto msgDto) {
		int msg_id = MESSAGE_ID.incrementAndGet();
		msgDto.setId(msg_id);
		MESSAGE_MAP_REPOSITORY.put(msg_id, new Message(msgDto));
	}

	@Override
	public void delete(int id) {
		if (MESSAGE_MAP_REPOSITORY.containsKey(id))
			MESSAGE_MAP_REPOSITORY.remove(id);
		else throw new NotFoundException("Сообщение не найдено");
		
	}

	@Override
	public MessageDto edit(int id, String text) {
		if (MESSAGE_MAP_REPOSITORY.containsKey(id))	{	
			Message msg = new Message();
			msg.setValue(text);
			MESSAGE_MAP_REPOSITORY.replace(id, msg);
			
			return new MessageDto(msg);
		}
		else throw new NotFoundException("Сообщение не найдено");

	}

	
}
