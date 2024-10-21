package com.doodle.core.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.doodle.core.spring.dao.JWTDao;
import com.doodle.core.spring.entity.JWTEntity;

import jakarta.transaction.Transactional;

@Service
public class JWTServiceImpl implements JWTService {
	private static final String SECRET = "SECRET";
	@Autowired
	private JWTDao jwtDao;

	@Override
	@Transactional
	public void saveJWT(JWTEntity jwt) {
		jwtDao.saveJWT(jwt);
	}
	
	@Transactional
	public JWTEntity saveJWT(int userid) {
		JWTEntity jwt = new JWTEntity();
		
		Algorithm algorithm = Algorithm.HMAC256(SECRET);
		
		String token = JWT.create()
                .withIssuer("doodle-core")           
                .withSubject(Integer.toString(userid))                   
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))
                .sign(algorithm);  
		
		jwt.setUserid(userid);
		jwt.setToken(token);
		
		jwtDao.saveJWT(jwt);
		
		return jwt;
	}


	@Override
	@Transactional
	public JWTEntity getJwt(int userid) {
		return jwtDao.getJwt(userid);
	}
	
	@Transactional
	public boolean checkJwt(String token, int userid) {
		try {
	        Algorithm algorithm = Algorithm.HMAC256(SECRET);

	        JWTVerifier verifier = JWT.require(algorithm)
	                .withIssuer("doodle-core")
	                .build();

	        DecodedJWT jwt = verifier.verify(token);

	        String subject = jwt.getSubject();
	        System.out.println(subject+" | "+Integer.toString(userid));
	        if (!subject.equals(Integer.toString(userid))) {
	            System.out.println("Invalid user id");
	            return false;
	        }

	        Date expiresAt = jwt.getExpiresAt();
	        if (expiresAt.before(new Date())) {
	            System.out.println("Token expired");
	            return false;
	        }

	        JWTEntity jwtEntity =  jwtDao.getJwt(userid);
	        if (!jwtEntity.getToken().equals(token)) {
	            System.out.println("Invalid token");
	            return false;
	        }

	        return true;

	    } catch (JWTVerificationException exception) {
	        System.out.println("Invalid token: " + exception.getMessage());
	        return false;
	    }
	}

	@Override
	@Transactional
	public void deleteJwt(int userid) {
		jwtDao.deleteJwt(userid);
	}

}
