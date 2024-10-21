package com.doodle.core.spring.service;

import com.doodle.core.spring.entity.Authority;

public interface AuthoritiesService {
	public void save(Authority authority);
	
	public Authority getAuthority(int userid);
	
	public void deleteAuthority(int userid, String role);
	
	public void deleteAllUserAuthorities(int userid);
}
