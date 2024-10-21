package com.doodle.core.spring.service;

import com.doodle.core.spring.entity.JWTEntity;

public interface JWTService {
	public void saveJWT(JWTEntity jwt);
	
	public JWTEntity saveJWT(int userid);
		
	public JWTEntity getJwt(int userid);
		
	public void deleteJwt(int userid);
	
	public boolean checkJwt(String token, int userid);
}