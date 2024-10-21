package com.doodle.core.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.RoleDao;
import com.doodle.core.spring.entity.Role;

import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

}
