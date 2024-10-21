package com.doodle.core.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role getRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, id);
	}

}
