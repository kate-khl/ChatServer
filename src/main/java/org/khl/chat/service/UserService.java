package org.khl.chat.service;

import java.util.List;

import org.khl.chat.entity.User;
import org.khl.chat.model.UserDto;

public interface UserService {


	   void create(UserDto userDto);
	   
	   List<UserDto> readAll();
	   
	   UserDto findById(int id);
	   
	   boolean edit(User user, int id);
	   
	   boolean remove(int id);
	   
	   boolean checkLogin(String email, String password);
	   
	   UserDto findUserByEmail (String Email);
}
