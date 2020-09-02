package org.khl.chat.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.khl.chat.Session;
import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.CreateRequestChat;
import org.khl.chat.dto.UserDto;
import org.khl.chat.service.ChatService;
import org.khl.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
public class ChatController {

	private final ChatService chatService;
	
	@Autowired
	public ChatController(@Qualifier("db") ChatService chatService) {
		System.out.println("sss");
		this.chatService = chatService;
//		this.s = s;
	}
	
	@PostMapping("/chats")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ChatDto create(@RequestBody @Valid CreateRequestChat createReqChat) {
		ChatDto chatDto = chatService.createChat(createReqChat);
		return chatDto;
	}
	
	@DeleteMapping("/chats/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void remove(@PathVariable @Valid Long id) {
		chatService.removeChat(id);
	}
	
	@PostMapping("/chats/{id}/users")
	@ResponseStatus(code = HttpStatus.OK)
	public void addUsers(@RequestBody @Valid Collection <Long> userIds, @PathVariable(name = "id") Long chatId) {
		chatService.addUsers(userIds, chatId);
	}
   
	@DeleteMapping("/chats/{id}/users")
	@ResponseStatus(code = HttpStatus.OK)
	public void removeUsers(@RequestBody @Valid Collection <Long> userIds, @PathVariable(name = "id") Long chat_id) {
		chatService.removeUsers(userIds, chat_id);
	}

	
}
