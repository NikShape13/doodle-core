package com.doodle.core.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.JWTEntity;

@Repository
public class JWTDaoImpl implements JWTDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveJWT(JWTEntity jwt) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jwt);
	}
	@Override
	public JWTEntity getJwt(int userid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(JWTEntity.class, userid);
	}

	@Override
	public void deleteJwt(int userid) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userid);
	}

}
