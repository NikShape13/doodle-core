package com.doodle.core.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Points;

@Repository
public class PointsDaoImpl implements PointsDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void savePoints(Points points) {
		Session session = sessionFactory.getCurrentSession();
		session.save(points);
	}

	@Override
	public void awardPoints(int id, int points) {
		Session session = sessionFactory.getCurrentSession();
		Query<Points> query = session.createQuery("UPDATE Points p SET p.points = p.points + :amount WHERE p.userid = :id");
		query.setParameter("amount", points);
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

	@Override
	public Points getPoints(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Points.class, id);
	}

}
