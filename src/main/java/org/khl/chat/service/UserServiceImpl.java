package org.khl.chat.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Map<Integer, User> USER_REPOSITORY_MAP = new HashMap<>();
	private static final AtomicInteger USER_ID = new AtomicInteger();
	private static final AtomicInteger SESSION_ID = new AtomicInteger();
	
	@Override
	public void create(UserDto userDto) {
		int user_id = USER_ID.incrementAndGet();
		userDto.setId(user_id);
		User user = new User(user_id, userDto.getName(), userDto.getEmail(), userDto.getPassword());
		USER_REPOSITORY_MAP.put(user_id, user);	
	}

	@Override
	public List<UserDto> readAll() {
		ArrayList<UserDto> userDtoList = new ArrayList<>();
				
		for (User u : USER_REPOSITORY_MAP.values())
		{
			UserDto uDto = new UserDto(u.getId(), u.getName(), u.getEmail(), null);
			userDtoList.add(uDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto findById(int id) {
		User user = USER_REPOSITORY_MAP.get(id);
		UserDto uDto = new UserDto(user.getId(), user.getName(), user.getEmail(), null);

		return uDto;
	}

	@Override
	public boolean edit(User user, int id) {
		if(USER_REPOSITORY_MAP.containsKey(id)){
			USER_REPOSITORY_MAP.put(id, user);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		if(USER_REPOSITORY_MAP.containsKey(id)){
			USER_REPOSITORY_MAP.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public String checkLogin(String email, String password) {
//		USER_REPOSITORY_MAP.forEach((k,v)->{	
//		});
		
		for(User u : USER_REPOSITORY_MAP.values()) {
			if (u.getEmail().equals(email)) {
				if(u.getPassword().equals(password)) {
					return "secret";
				}
				else throw new NotAuthorizeException("Ошибка авторизации1");
			}
			else throw new NotAuthorizeException("Ошибка авторизации");
		}
		return "n";
	}
	
	

}
