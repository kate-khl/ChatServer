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
	
	@PostMapping ("/message")
	@ResponseStatus(code = HttpStatus.OK)
	public void send(@RequestBody @Valid MessageDto msgDto) {
		messageService.send(msgDto);
	}
	
	@DeleteMapping ("/message/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete (@PathVariable(name = "id") int id) {
		messageService.delete(id);
	}
	
	@PostMapping ("/message/edit")
	@ResponseStatus(code = HttpStatus.OK)
	public void edit (@RequestBody String newVal, int msg_id) {
		messageService.edit(msg_id, newVal);
	}
}
