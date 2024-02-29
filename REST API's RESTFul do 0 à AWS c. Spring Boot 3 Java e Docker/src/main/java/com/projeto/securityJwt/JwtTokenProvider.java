package com.projeto.securityJwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.projeto.data.vo.v1.security.TokenVO;

import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {

	@Value("${security.jwt.token.security-key:secret}")
	private String secretKey = "secret";
	
	@Value("${security.jwt.token.expire-lenght:36000}")
	private long validityInMilliseconds = 36000;
	
	@Autowired
	private UserDetailsService userDatailService;
	
	Algorithm algorithm = null;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());

	}
	
	private TokenVO createAcessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		var acessToken = getAcessToken(username, roles, now, validity);
		var refreshToken = getAcessToken(username, roles, now);
		return new TokenVO(username, true, now, validity, acessToken, refreshToken);	
	}

	private String getAcessToken(String username, List<String> roles, Date now) {
		return null;
	}

	private String getAcessToken(String username, List<String> roles, Date now, Date validity) {
		// TODO Auto-generated method stub
		return null;
	}
}