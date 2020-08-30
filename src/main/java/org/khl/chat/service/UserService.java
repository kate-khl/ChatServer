package org.khl.chat.service;

import java.util.Collection;
import java.util.List;

import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.UserDto;

public interface UserService {


	   UserDto create(UserDto userDto);
	   
	   List<UserDto> readAll();
	   
	   UserDto findById(Long id);
	   
	   boolean edit(User user);
	   
	   boolean remove(Long id);
	   
	   boolean checkLogin(String email, String password);
	   
	   UserDto findUserByEmail (String Email);
	   
	   public Collection<ChatDto> getChats(Long userId);
}
