package com.projeto.securityJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JwtTokenProvider {

	@Value("${security.jwt.token.security-key:secret}")
	private String securityKey = "secret";
	
	@Value("${security.jwt.token.expire-lenght:36000}")
	private long validityInMilliseconds = 36000;
	
	@Autowired
	private UserDetailsService userDatailService;
	
	Algorithm algorithm = null;
}
