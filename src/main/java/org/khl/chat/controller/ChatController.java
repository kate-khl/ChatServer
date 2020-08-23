package org.khl.chat.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.khl.chat.model.ChatDto;
import org.khl.chat.model.UserDto;
import org.khl.chat.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	private final ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	   
	@PostMapping("/chats")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ChatDto create(@RequestBody @Valid ChatDto chatDto) {
		chatService.createChat(chatDto);
		return chatDto;
	}
	
	@DeleteMapping("/chats/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void remove(@PathVariable @Valid int id) {
		chatService.removeChat(id);
	}
	
	@PostMapping("/chats/users")
	@ResponseStatus(code = HttpStatus.OK)
	public void addUsers(@RequestBody @Valid Collection <UserDto> usersDto, int chat_id) {
		chatService.addUsers(usersDto, chat_id);
	}
   
	@PostMapping("/chats/users/remove")
	@ResponseStatus(code = HttpStatus.OK)
	public void removeUsers(@RequestBody @Valid Collection <UserDto> usersDto, int chat_id) {
		chatService.removeUsers(usersDto, chat_id);
	}
	
	@GetMapping("/chats/users/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void getUsers(@PathVariable(name = "id") int chat_id) {
		chatService.getUsers(chat_id);
	}
}
