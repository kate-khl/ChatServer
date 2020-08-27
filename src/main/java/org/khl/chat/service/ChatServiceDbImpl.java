package org.khl.chat.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.khl.chat.Session;
import org.khl.chat.dao.ChatDao;
import org.khl.chat.dao.MessageDao;
import org.khl.chat.dao.UserDao;
import org.khl.chat.entity.Chat;
import org.khl.chat.entity.Message;
import org.khl.chat.entity.User;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.CreateRequestChat;
import org.khl.chat.model.MessageDto;
import org.khl.chat.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import antlr.collections.List;

@Service
@Qualifier("db")
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
public class ChatServiceDbImpl implements ChatService{

	@Autowired
	private ChatDao chDao;
	@Autowired
	private UserDao uDao;
	@Autowired
	private MessageDao msgDao;
	@Autowired
	private Session session;
	
	@Override
	public ChatDto createChat(CreateRequestChat crChat) {
		
		Chat c = new Chat();
		c.setName(crChat.getName());
		c.setUsers(uDao.findAllById(crChat.getUsers()));
		User author = uDao.findById(session.getId()).get();
		c.getUsers().add(author);
		chDao.save(c);
		Message msg = new Message(crChat.getMessage(), author.getId(), c);
		msgDao.save(msg);
		Collection<Message> msgList = new ArrayList<Message>();
		msgList.add(msg);
		c.setMessages(msgList);
		
		return new ChatDto(chDao.save(c));
	}
	
//	private Collection<User> idUsersToList (Collection<Long> id) {
//		Collection<User> users = uDao.findAllById(id);
//		
//		return usersDto;
//	}

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
