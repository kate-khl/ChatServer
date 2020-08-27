package org.khl.chat.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;
import org.khl.chat.exception.NotFoundException;
import org.khl.chat.model.ChatDto;
import org.khl.chat.model.CreateRequestChat;
import org.khl.chat.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceMapImpl implements ChatService{

	private static final Map<Integer, Chat> CHAT_REPOSITORY_MAP = new HashMap<>();
	private static final AtomicInteger CHAT_ID = new AtomicInteger();
	
	@Override
	public ChatDto createChat(CreateRequestChat crChat) {
		int chat_id = CHAT_ID.incrementAndGet();
		//Chat chat = new Chat();
		//chat.setId(chat_id);
		/*Collection<User> users = new ArrayList<User>();  
		for (UserDto user : usersDto) {
			User u = new User(user);
			users.add(u);
		}*/
		//chat.setUsers(users);
		
//		Chat c = new Chat();
//		c.setName(crChat.getName());
//		c.setUsers(uDto.findAllById(crChat.getUsers()));
//		User author = uDao.findById(session.getId()).get();
//		
//		c.getUsers().add(author);
//		
//		CHAT_REPOSITORY_MAP.put(chat_id, new Chat(chatDto));	
		
		return null;
	}

	@Override
	public void addUsers(Collection<UserDto> usersDto, int id) {
		if (CHAT_REPOSITORY_MAP.containsKey(id)) {
			Chat chat = new Chat();
			chat = CHAT_REPOSITORY_MAP.get(id);
			Collection<User> users = new ArrayList<User>();  
			for (UserDto user : usersDto) {
				User u = new User(user);
				users.add(u);
			}
			chat.getUsers().addAll(users);
		} else throw new NotFoundException("Чат не найден");
	}

	@Override
	public void removeUsers(Collection<UserDto> usersDto, int id) {
		if (CHAT_REPOSITORY_MAP.containsKey(id)) {
			Chat chat = new Chat();
			chat = CHAT_REPOSITORY_MAP.get(id);
			Collection<User> users = new ArrayList<User>();  
			for (UserDto user : usersDto) {
				User u = new User(user);
				users.add(u);
			}
			chat.getUsers().removeAll(users);
		} else throw new NotFoundException("Чат не найден");
	}

	@Override
	public Collection<UserDto> getUsers(int id){

		Collection<UserDto> users = new ArrayList<UserDto>();  
		for (User user : CHAT_REPOSITORY_MAP.get(id).getUsers()) {
			UserDto uDto = new UserDto(user);
			users.add(uDto);
		}
		return users;
	}

	@Override
	public void removeChat(int id) {
		if (CHAT_REPOSITORY_MAP.containsKey(id)) {
			CHAT_REPOSITORY_MAP.remove(id);
		} else throw new NotFoundException("Чат не найден");
	}

	@Override
	public ChatDto findChat(Long id) {
		
		return new ChatDto(CHAT_REPOSITORY_MAP.get(id));
	}
}
