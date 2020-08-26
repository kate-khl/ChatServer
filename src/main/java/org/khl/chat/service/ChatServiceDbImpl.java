package org.khl.chat.service;

import java.util.Collection;

import org.khl.chat.Session;
import org.khl.chat.dao.ChatDao;
import org.khl.chat.dao.UserDao;
import org.khl.chat.entity.Chat;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class ChatServiceDbImpl implements ChatService{

	@Autowired
	private ChatDao chDao;
	@Autowired
	private Session session;
	
	@Override
	public void createChat(ChatDto chatDto) {
		chDao.save(new Chat(chatDto));
	}

	@Override
	public void addUsers(Collection<UserDto> users, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUsers(Collection<UserDto> users, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<UserDto> getUsers(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeChat(int id) {
		// TODO Auto-generated method stub
		
	}

}
