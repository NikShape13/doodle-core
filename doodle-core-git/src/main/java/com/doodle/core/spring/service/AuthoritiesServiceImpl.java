package com.doodle.core.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.AuthoritiesDao;
import com.doodle.core.spring.entity.Authority;

import jakarta.transaction.Transactional;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
	@Autowired
	private AuthoritiesDao authoritiesDao;

	@Override
	@Transactional
	public void save(Authority authority) {
		authoritiesDao.save(authority);
	}

	@Override
	@Transactional
	public Authority getAuthority(int userid) {
		return authoritiesDao.getAuthority(userid);
	}

	@Override
	@Transactional
	public void deleteAuthority(int userid, String role) {
		authoritiesDao.deleteAuthority(userid, role);
	}

	@Override
	@Transactional
	public void deleteAllUserAuthorities(int userid) {
		authoritiesDao.deleteAllUserAuthorities(userid);
	}

}
