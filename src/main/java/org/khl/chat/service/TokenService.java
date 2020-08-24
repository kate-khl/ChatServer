package org.khl.chat.service;

import org.khl.chat.model.UserDto;

public interface TokenService {

	public String getToken (String Email, String password);
	public boolean verificationToken (String token);

}
