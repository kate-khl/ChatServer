package org.khl.chat.controller;

import java.util.List;

import javax.validation.Valid;

import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.model.LoginRequestDto;
import org.khl.chat.model.UserDto;
import org.khl.chat.service.TokenService;
import org.khl.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class UserController {

	   private final UserService userService;
	   private final TokenService tokenService;

	   @Autowired
	   public UserController(UserService userService, TokenService tokenService) {
	       this.userService = userService;
	       this.tokenService = tokenService;
	   }
	   
	   @PostMapping ("/auth")
	   public String auth(@RequestBody LoginRequestDto requestDto) {
		   if (userService.checkLogin(requestDto.getEmail(), requestDto.getPassword())) {
			   String token = tokenService.getToken(requestDto.getEmail(), requestDto.getPassword());
			   return token;
		   }
		   else return null;
	   }
	   
	   
	   @PostMapping("/registration")
	   @ResponseStatus(code = HttpStatus.CREATED)
	   public UserDto create(@RequestBody @Valid UserDto user) {
		   
		   userService.create(user);
		   return user;
	   }
	   
	   @DeleteMapping("/users/{id}")
	   @ResponseStatus(code = HttpStatus.OK)
	   public boolean remove(@PathVariable(name = "id") Long id) {
		   userService.remove(id);
		   return true;
	   }
	   
	   @GetMapping("/users/list")
	   @ResponseStatus(code = HttpStatus.OK)
	   public List<UserDto> readAll() {
		   return userService.readAll();
	   }
	   
	   @GetMapping("/users/{id}")
	   @ResponseStatus(code = HttpStatus.OK)
	   public UserDto findById(@PathVariable(name = "id") Long id, @RequestHeader HttpHeaders headers) {
		   String token = headers.getFirst("Authorization");
		   if (tokenService.verificationToken(token)) return userService.findById(id);
		   else throw new NotAuthorizeException("Ошибка авторизации");
	   }
	   
	   @PostMapping("/users/edit")
	   @ResponseStatus(code = HttpStatus.OK)
	   public UserDto edit(@RequestBody @Valid User user) {
		   userService.edit(user);
		   return userService.findById(user.getId());
	   }
	   
	   
}
