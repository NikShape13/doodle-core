package com.doodle.core.spring.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

@Repository
public class WordsDaoImpl implements WordsDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Word getWord(int id) {
		Session session = sessionFactory.getCurrentSession();
		Word word = session.get(Word.class, id);
		return word;
	}

	@Override
	public List<Word> getAllWords(MyUser myUser) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Word where userid=:userUserId");
		query.setParameter("userUserId", myUser.getId());
		
		List<Word> list = query.getResultList();
		return list;
	}
	
	@Override
	public List<Word> getAllWords(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Word where userid=:userUserId");
		query.setParameter("userUserId", userid);
		
		List<Word> list = query.getResultList();
		return list;
	}

	@Override
	public void saveWord(Word word) {
		Session session = sessionFactory.getCurrentSession();
		session.save(word);
	}
	
	@Override
	public void updateWord(Word word) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(word);
	}

	@Override
	public void deleteWord(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(id);
	}
	
	@Override
	public Word getWordForUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT w FROM Word w WHERE w.userid != :currentUserId AND (NOT EXISTS (SELECT 1 FROM w.drawingUsers u WHERE u.id =: currentUserId)) ORDER BY RANDOM()");
		query.setParameter("currentUserId", userId);
		query.setMaxResults(1);

	    List<Word> results = query.getResultList();
	    if (!results.isEmpty()) {
	    	Word word = results.get(0);
	        return word;
	    }
		
		return null;
	}
}




