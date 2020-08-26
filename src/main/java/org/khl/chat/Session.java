package org.khl.chat;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

public class Session {

	private Long id;
	private String name;
	private String email;
	private String role;
	
	@Autowired
	public Session() {		
	}
	
	public static Session fromToken(String token) {

		token = token.replace("_", "+").replace("-", "/");
		
		String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];		
        System.out.println(base64EncodedHeader);
        System.out.println(base64EncodedBody);
        
        String body = new String(Base64.getMimeDecoder().decode(base64EncodedBody));
        Gson gson = new Gson();
        Session ss = gson.fromJson(body, Session.class);
        
        return ss;
	}
	
}