package com.doodle.core.spring.dao;

import com.doodle.core.spring.entity.JWTEntity;

public interface JWTDao {
	public void saveJWT(JWTEntity jwt);
	
	public JWTEntity getJwt(int userid);
	
	public void deleteJwt(int userid);
}
