package org.khl.chat.service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.khl.chat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service

public class TokenServiceImpl implements TokenService {

	@Autowired
	public TokenServiceImpl(@Qualifier("db") UserService userService) {
		this.userService = userService;
	}
	private UserService userService;

	@Override
	public String getToken(String email, String password) {

		UserDto userDto = new UserDto();
		userDto = userService.findUserByEmail(email);
		String jws = Jwts.builder()
				.claim("email", userDto.getEmail())
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3*3600 + 300)))
				.claim("id", userDto.getId())
				.claim("name", userDto.getName())
				.claim("role", userDto.getRole())
				.signWith(SignatureAlgorithm.HS512, "secretKey"
				).compact();

		return jws;
	}

	@Override
	public boolean verificationToken(String token) {
		if (token == null)
			return false;
		try {
			Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();
			System.out.println("Valid Token " + token);
			return true;

		} catch (ExpiredJwtException expiredJwtException) {
			System.out.println("Token Expires " + expiredJwtException);
			return false;
		}

		catch (Exception exception) {
			System.out.println("Exceptioin " + exception);
			return false;
		}
	}

}
