package org.khl.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST)
public class Session {

	@Autowired
	public Session(HttpServletRequest req) {
		System.out.println(req);
	}
	
}