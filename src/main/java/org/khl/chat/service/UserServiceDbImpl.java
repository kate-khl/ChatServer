package org.khl.chat.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.khl.chat.dao.ChatDao;
import org.khl.chat.dao.UserDao;
import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.Chat;
import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class UserServiceDbImpl implements UserService{

	
	@Autowired
	private UserDao uDao;
	@Autowired
	private ChatDao chDao;
	@Autowired
	private UserMapper userMapper;;
//	@Autowired
//	private Session session;
	
	@Override
	@Transactional
	public UserDto create(UserDto userDto) {
		User u = userMapper.toEntity(userDto);
		uDao.save(u);
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public Collection<UserDto> getAllUsers() {
		ArrayList<UserDto> userDtoList = new ArrayList<>();
		
		Collection<User> users = uDao.findAll();
		
//		for (User u : uDao.findAll()){
//			UserDto uDto = new UserDto(u.getId(), u.getName(), u.getEmail(), null, u.getRole());
//			userDtoList.add(uDto);
//		}
		return userMapper.toListOfDto(users);
	}

	@Override
	@Transactional
	public UserDto findById(Long id) {
		User u = uDao.findById(id).get();
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public boolean edit(User user) {
		try {
			uDao.save(user);
			return true;
		} catch (Exception e) {
			System.out.println("Error" + e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		try {
			uDao.deleteById(id);;
			return true;
		} catch (Exception e) {
			System.out.println("Error" + e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean checkLogin(String email, String password) {
		User u = new User();
		u = uDao.findByEmail(email).get();
		if (u.getEmail().equals(email)) {
			if(u.getPassword().equals(password)) {
				return true;
			}
			else throw new NotAuthorizeException("Ошибка авторизации1"); //ResponseStatusException(HttpStatus.UNAUTHORIZED, "ololololo");//;
		}
		else throw new NotAuthorizeException("Ошибка авторизации");
		
	//	return false;
	}

	@Override
	@Transactional
	public UserDto findUserByEmail(String email) {
		
		User u = uDao.findByEmail(email).get();
		//User result = opt.isPresent() ? opt.get() : null;
		return userMapper.toDto(u);
	}

	@Override
	@Transactional
	public Collection<ChatDto> getChats(Long userId) {
		User u = uDao.findById(userId).get();
		//Collection chDtoList = this.toChatDtoColl(u.getChats());
		return null; //chDtoList;
	}
	
	@Override
	public Collection<UserDto> getUsers(Long chatId) {
		Chat c = chDao.getOne(chatId);
		return userMapper.toListOfDto(c.getUsers());
	}
	
//	private Collection<ChatDto> toChatDtoColl(Collection<Chat> chatList){
//		Collection<ChatDto> chDtoList = new ArrayList<ChatDto>();
//		for (Chat chat : chatList) {
//			chDtoList.add(new ChatDto(chat));
//		}
//		return chDtoList;
//	}

}
