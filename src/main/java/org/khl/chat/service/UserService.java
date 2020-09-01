package org.khl.chat.service;

import java.util.Collection;
import java.util.List;

import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;

public interface UserService {


	   UserDto create(UserDto userDto);
	   
	   Collection<UserDto> getAllUsers();
	   
	   UserDto findById(Long id);
	   
	   boolean edit(User user);
	   
	   boolean remove(Long id);
	   
	   boolean checkLogin(String email, String password);
	   
	   UserDto findUserByEmail (String Email);
	   
	   public Collection<ChatDto> getChats(Long userId);
	   
	   public Collection<UserDto> getUsers(Long chatId);
}
