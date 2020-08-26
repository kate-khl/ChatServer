package org.khl.chat;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.khl.chat.model.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
public class Session {

	private Long Id;
	private String name;
	private String email;
	private String role;
	
	@Autowired
	public Session(HttpServletRequest req) {
		String token = req.getHeader("Authorization");
		if (token != null) {
			TokenDto tokenDto = new TokenDto(req.getHeader("Authorization"));
			String aa = new String(Base64.getMimeDecoder().decode(tokenDto.getToken()));
			System.out.println(tokenDto.getBody());
			
			tokenDto.getEmail();
		}
		
		
	}
	
}