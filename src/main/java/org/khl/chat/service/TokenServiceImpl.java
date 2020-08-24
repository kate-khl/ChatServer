package org.khl.chat.service;

import java.time.Instant;
import java.util.Date;

import org.khl.chat.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service
public class TokenServiceImpl implements TokenService{


	public TokenServiceImpl(){}
//	public TokenServiceImpl(UserService userService) {
//		this.userService = userService;
//	}
	private UserService userService;

	@Override
	public String getToken(String email, String password) {

		UserDto userDto = new UserDto();
		userDto = userService.findUserByEmail(email);
		String jws = Jwts.builder()
				  .setHeaderParam("typ", "JWT")
				  .setIssuer("issuer")
				  .setSubject(userDto.getEmail())
				  .claim("id", userDto.getId())
				  .claim("name", userDto.getName())
				  .claim("role", userDto.getRole())
//				   //Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
//				  .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
//				   //Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
//				  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				  .signWith(
						  SignatureAlgorithm.HS512, "secretKey"
//				    SignatureAlgorithm.HS256,
//				    TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
				  )
				  .compact();
		
		return jws;
	}
	
	@Override
    public boolean verificationToken (String token)
    {
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
