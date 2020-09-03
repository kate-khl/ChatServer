package org.khl.chat.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.khl.chat.dao.ChatDao;
import org.khl.chat.dao.UserDao;
import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.mapper.ChatMapper;
import org.khl.chat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class UserServiceDbImpl implements UserService{

	@Autowired
	private UserDao uDao;
	@Autowired
	private ChatDao chDao;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	@Transactional
	public UserDto create(UserDto userDto) {
		User u = userMapper.toEntity(userDto);
		uDao.save(u);
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public Collection<UserDto> getAllUsers(int page, int size) {
		
		Pageable pageParams = PageRequest.of(page, size);
		Page<User> users = uDao.findAll(pageParams);
		
		return userMapper.toListOfDto(users.getContent());
	}

	@Override
	@Transactional
	public UserDto findById(Long id) {
		User u = uDao.findById(id).get();
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public boolean edit(User user) {
		try {
			uDao.save(user);
			return true;
		} catch (Exception e) {
			System.out.println("Error" + e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		try {
			uDao.deleteById(id);;
			return true;
		} catch (Exception e) {
			System.out.println("Error" + e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean checkLogin(String email, String password) {
		User u = new User();
		u = uDao.findByEmail(email).get();
		if (u.getEmail().equals(email)) {
			if(u.getPassword().equals(password)) {
				return true;
			}
			else throw new NotAuthorizeException("Ошибка авторизации1"); 
		}
		else throw new NotAuthorizeException("Ошибка авторизации");
	}

	@Override
	@Transactional
	public UserDto findUserByEmail(String email) {
		
		User u = uDao.findByEmail(email).get();
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public Collection<ChatDto> getChats(Long userId) {
		Collection<Chat> chats = chDao.findChatByUserId(userId);
		
		return chatMapper.toListOfDto(chats);
	}
	
	@Override
	@Transactional
	public Collection<UserDto> getUsers(Long chatId) {
		Chat c = chDao.getOne(chatId);
		return userMapper.toListOfDto(c.getUsers());
	}
	

}
