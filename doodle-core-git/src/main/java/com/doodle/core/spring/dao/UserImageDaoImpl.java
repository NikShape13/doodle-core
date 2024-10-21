package com.doodle.core.spring.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
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
public class UserImageDaoImpl implements UserImageDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserImage getUserImage(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserImage.class, id);
	}

	@Override
	public void saveUserImage(UserImage userImage) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userImage);
	}

	@Override
	public void deleteUserImage(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(id);
	}
	
	@Override
	public List<UserImage> getAllUserImages(MyUser myUser) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserImage where userid=:userUserId");
		query.setParameter("userUserId", myUser.getId());
		
		List<UserImage> list = query.getResultList();
		return list;
	}
	
	@Override
	public List<UserImage> getAllUserImages(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserImage where userid=:userUserId");
		query.setParameter("userUserId", userid);
		
		List<UserImage> list = query.getResultList();
		return list;
	}

	@Override
	public List<UserImage> getAllImagesForWord(Word word) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserImage where wordid=:wordWordId");
		query.setParameter("wordWordId", word.getId());
		
		List<UserImage> list = query.getResultList();
		return list;
	}
	
	@Override
	public UserImage getUserImageByUserAndWordId(int userid, int wordid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserImage where userid=:ui and where wordid=:wi");
		query.setParameter("ui", userid);
		query.setParameter("wi", wordid);
		UserImage userImage = (UserImage)query.getResultList().get(0);
		return userImage;
	}
	
	@Override
	public UserImage getUserImageForUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT ui FROM UserImage ui WHERE userid!=:currentUserId AND( NOT EXISTS (SELECT 1 FROM ui.users u WHERE u.id=:currentUserId)) ORDER BY RANDOM()");
		query.setParameter("currentUserId", userId);
		query.setMaxResults(1);

	    List<UserImage> results = query.getResultList();
	    if (!results.isEmpty()) {
	        return results.get(0);
	    }
	    return null;
	}

	
	public void updateUserImage(UserImage userImage) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userImage);
	}
}
