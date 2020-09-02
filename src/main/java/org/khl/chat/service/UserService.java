package org.khl.chat.service;

import java.util.Collection;
import java.util.List;

import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {


	   UserDto create(UserDto userDto);
	   
	   Collection<UserDto> getAllUsers(int page, int size);
	   
	   UserDto findById(Long id);
	   
	   boolean edit(User user);
	   
	   boolean remove(Long id);
	   
	   boolean checkLogin(String email, String password);
	   
	   UserDto findUserByEmail (String Email);
	   
	   public Collection<ChatDto> getChats(Long userId);
	   
	   public Collection<UserDto> getUsers(Long chatId);
}
