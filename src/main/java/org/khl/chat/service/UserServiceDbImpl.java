package org.khl.chat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.khl.chat.dao.UserDao;
import org.khl.chat.entity.User;
import org.khl.chat.exception.NotAuthorizeException;
import org.khl.chat.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class UserServiceDbImpl implements UserService{

	
	@Autowired
	private UserDao udao;
//	@Autowired
//	private Session session;
	
	@Override
	@Transactional
	public UserDto create(UserDto userDto) {
		return new UserDto(udao.save(new User(userDto)));
	}

	@Override
	@Transactional
	public List<UserDto> readAll() {
		ArrayList<UserDto> userDtoList = new ArrayList<>();
		for (User u : udao.findAll()){
			UserDto uDto = new UserDto(u.getId(), u.getName(), u.getEmail(), null, u.getRole());
			userDtoList.add(uDto);
		}
		return userDtoList;
	}

	@Override
	@Transactional
	public UserDto findById(Long id) {
		
		return new UserDto(udao.findById(id).get());
	}

	@Override
	@Transactional
	public boolean edit(User user) {
		try {
			udao.save(user);
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
			udao.deleteById(id);;
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
		u = udao.findByEmail(email).get();
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
		
		Optional<User> opt = udao.findByEmail(email);
		User result = opt.isPresent() ? opt.get() : null;
		return new UserDto(result);
	}

}
