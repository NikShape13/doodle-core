package com.doodle.core.spring.dao;

import com.doodle.core.spring.entity.Authority;

public interface AuthoritiesDao {
	public void save(Authority authority);
	
	public Authority getAuthority(int userid);
	
	public void deleteAuthority(int userid, String role);
	
	public void deleteAllUserAuthorities(int userid);
}
