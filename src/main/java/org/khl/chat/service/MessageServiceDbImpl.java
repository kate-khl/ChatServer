package org.khl.chat.service;

import org.khl.chat.dao.MessageDao;
import org.khl.chat.entity.Message;
import org.khl.chat.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceDbImpl implements MessageService{

	@Autowired
	private MessageDao msgDao; 
	
	@Override
	public void send(String value, Long chatId) {
		
		
		msgDao.save(new Message(msgDto));
		
	}

	@Override
	public void delete(Long id) {
		Message msg = msgDao.findById(id).get();
		msg.setDeleted(true);
	}

	@Override
	public MessageDto edit(Long id, String text) {
		Message msg = msgDao.findById(id).get();
		msg.setValue(text);
		return new MessageDto(msg);
	}
	

}
