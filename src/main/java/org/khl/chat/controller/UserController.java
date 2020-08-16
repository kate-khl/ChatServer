package org.khl.chat.controller;

import javax.validation.Valid;

import org.khl.chat.model.LoginRequestDto;
import org.khl.chat.model.UserDto;
import org.khl.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	   private final UserService userService;

	   @Autowired
	   public UserController(UserService userService) {
	       this.userService = userService;
	   }
	   
	   @PostMapping ("/auth")
	   public ResponseEntity<?> auth(@RequestBody LoginRequestDto requestDto) {
		   userService.checkLogin(requestDto.getEmail(), requestDto.getPassword());
	      return new ResponseEntity<>(HttpStatus.ACCEPTED);
	   }
	   
	   @PostMapping("/users")
	   @ResponseStatus(code = HttpStatus.CREATED)
	   public UserDto create(@RequestBody @Valid UserDto user) {
		   userService.create(user);
		   return user;
	   }
}
