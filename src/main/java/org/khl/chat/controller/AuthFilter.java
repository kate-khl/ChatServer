package org.khl.chat.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.khl.chat.exception.AccessControlException;
import org.khl.chat.service.TokenService;
import org.khl.chat.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;
	
	private final TokenService ts;

	public AuthFilter(TokenService srv) {
		ts = srv;
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (ts.verificationToken(request.getHeader("Authorization"))) {
			chain.doFilter(request, response);
		} 
		else {
			throw new AccessControlException("Ошибка авторизации");
		}
	}

}
