package com.doodle.core.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.Authority;

import jakarta.persistence.Query;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Authority authority) {
		Session session = sessionFactory.getCurrentSession();
		session.save(authority);
	}

	@Override
	public Authority getAuthority(int userid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Authority.class, userid);
	}

	@Override
	public void deleteAuthority(int userid, String role) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Authorities where userid =:userIdParam and authority =:authorityParam");
		query.setParameter("userIdParam", userid);
		query.setParameter("authorityParam", role);
		query.executeUpdate();
	}

	@Override
	public void deleteAllUserAuthorities(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Authorities where userid =:userIdParam");
		query.setParameter("userIdParam", userid);
		query.executeUpdate();
	}

}
