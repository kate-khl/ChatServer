package org.khl.chat.controller;

import javax.validation.Valid;

import org.khl.chat.model.MessageDto;
import org.khl.chat.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping ("/messages")
	@ResponseStatus(code = HttpStatus.OK)
	public void send(@RequestBody @Valid String value, Long chatId) {
		messageService.send(msgDto);
	}
	
	@DeleteMapping ("/messages/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete (@PathVariable(name = "id") Long id) {
		messageService.delete(id);
	}
	
	@PostMapping ("/messages/edit")
	@ResponseStatus(code = HttpStatus.OK)
	public void edit (@RequestBody String newVal, Long msgId) {
		messageService.edit(msgId, newVal);
	}
}
