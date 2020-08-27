package org.khl.chat.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.transaction.Transactional;

import org.khl.chat.dao.UserDao;
import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.exception.NotFoundException;
import org.khl.chat.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceMapImpl implements UserService {
	
	private static final Map<Long, User> USER_REPOSITORY_MAP = new HashMap<>();
	private static final AtomicInteger USER_ID = new AtomicInteger();
	
//	@Autowired

//	private GenerateTokenService generateTokenService;
//	private static final AtomicInteger SESSION_ID = new AtomicInteger();
	
//	UserServiceImpl(GenerateTokenService generateTokenService){
//		this.generateTokenService = generateTokenService;
//	}
	
	@Override
	@Transactional
	public UserDto create(UserDto userDto) {
		Long user_id = (long)USER_ID.incrementAndGet();
		userDto.setId(user_id);
		User user = new User(userDto);
		USER_REPOSITORY_MAP.put(user_id, user);	
		return userDto;
	}

	@Override
	public List<UserDto> readAll() {
		ArrayList<UserDto> userDtoList = new ArrayList<>();
				
		for (User u : USER_REPOSITORY_MAP.values())
		{
			UserDto uDto = new UserDto(u.getId(), u.getName(), u.getEmail(), null, u.getRole());
			userDtoList.add(uDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto findById(Long id) {
		if(USER_REPOSITORY_MAP.containsKey(id)){
			User user = USER_REPOSITORY_MAP.get(id);
			UserDto uDto = new UserDto(user.getId(), user.getName(), user.getEmail(), null, user.getRole());
			return uDto;
		}
		else throw new NotFoundException("Пользователь не найден");

	}
	
	@Override
	public boolean edit(User user) {
		if(USER_REPOSITORY_MAP.containsKey(user.getId())){
			USER_REPOSITORY_MAP.put(user.getId(), user);
			return true;
		}
		else throw new NotFoundException("Пользователь не найден");
	}

	@Override
	public boolean remove(Long id) {
		if(USER_REPOSITORY_MAP.containsKey(id)){
			USER_REPOSITORY_MAP.remove(id);
			return true;
		}
		else throw new NotFoundException("Пользователь не найден");
	//	return false;
	}

	@Override
	public boolean checkLogin(String email, String password) {
//		USER_REPOSITORY_MAP.forEach((k,v)->{	
//		});
		
		for(User u : USER_REPOSITORY_MAP.values()) {
			if (u.getEmail().equals(email)) {
				if(u.getPassword().equals(password)) {
					return true;
				}
				else throw new NotAuthorizeException("Ошибка авторизации1"); //ResponseStatusException(HttpStatus.UNAUTHORIZED, "ololololo");//;
			}
			else throw new NotAuthorizeException("Ошибка авторизации");
		}
		return false;
	}
	
	public UserDto findUserByEmail(String email) {
		for(User u : USER_REPOSITORY_MAP.values()) {
			if (u.getEmail().equals(email)) {
					return new UserDto(u);	
			}
		}
		return null;
	}
}