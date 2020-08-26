package org.khl.chat.model;

import java.util.Base64;

public class TokenDto {

	private String token;
	private String header;
	private String body;
	private String email;
	private String name;
	private Long id;
	private String role;
	
	public TokenDto(String token) {
		this.token = token.replace("_", "+").replace("-", "/");
		
		String[] split_string = this.token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];		
        System.out.println(base64EncodedHeader);
        System.out.println(base64EncodedBody);
        
        
        this.header = new String(Base64.getMimeDecoder().decode(base64EncodedHeader));
        System.out.println(this.header);
        this.body = new String(Base64.getMimeDecoder().decode(base64EncodedBody));
        System.out.println(this.body);
        
        
	}

	public String getEmail() {
		
	/*	int endIndex = 10;
		int startIndex = this.email.indexOf("\"", 10);
		
		String emailParsed = this.body.substring(startIndex, endIndex);
		System.out.println(emailParsed);
		*/
		return null;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}


	public String getRole() {
		return role;
	}

	public String getToken() {
		return token;
	}
	
	public String getDecodedToken() {
		return new String(Base64.getMimeDecoder().decode(this.token));
	}

	public String getHeader() {
		return header;
	}

	public String getBody() {
		return body;
	}	

}
