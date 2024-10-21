package com.doodle.core.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;


@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MyUser> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<MyUser> myUsers = session.createQuery("from MyUser", MyUser.class).getResultList();
		return myUsers;
	}

	@Override
	public MyUser getUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MyUser where username=:userName");
		query.setParameter("userName", username);
		MyUser user = query.getResultList().isEmpty()? null : (MyUser) query.getResultList().get(0);
		return user;
	}

	@Override
	public MyUser getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(MyUser.class, id);
	}
	
	@Override
	public Integer saveUser(MyUser myUser) {
		Session session = sessionFactory.getCurrentSession();
		Integer userId = (Integer)session.save(myUser);
		return userId;
	}

	@Override
	public void deleteUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<MyUser> query = session.createQuery("delete from Users where username =:userName");
		query.setParameter("userName", username);
		query.executeUpdate();
	}
	
	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<MyUser> query = session.createQuery("delete from Users where id =:userId");
		query.setParameter("userId", id);
		query.executeUpdate();
	}

	@Override
	public MyUser checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<MyUser> query = session.createQuery("from Users where email =:userEmail");
		query.setParameter("userEmail", email);
		
		List<MyUser> emails = query.getResultList();
		
		if(emails.size()==1) {
			return emails.get(0);
		}
		
		return null;
	}

	@Override
	public void updateUser(MyUser user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public List<Word> getDrawingWords(MyUser user) {
		return null;
	}

	@Override
	public List<UserImage> getGuessedImages(MyUser user) {
		return null;
	}

}
