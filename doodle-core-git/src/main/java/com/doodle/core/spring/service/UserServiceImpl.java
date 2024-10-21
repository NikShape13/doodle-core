package com.doodle.core.spring.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.UsersDao;
import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersDao usersDao;

	@Override
	@Transactional
	public List<MyUser> getAllUsers() {
		return usersDao.getAllUsers();
	}

	@Override
	@Transactional
	public MyUser getUser(String username) {
		return usersDao.getUser(username);
	}
	
	@Override
	@Transactional
	public MyUser getUser(int id) {
		return usersDao.getUser(id);
	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		usersDao.deleteUser(username);
	}
	
	@Override
	@Transactional
	public void deleteUser(int id) {
		usersDao.deleteUser(id);
	}

	@Override
	@Transactional
	public Integer saveUser(MyUser myUser) {
		return usersDao.saveUser(myUser);
	}

	@Override
	@Transactional
	public MyUser checkEmail(String email) {
		return usersDao.checkEmail(email);
	}

	@Override
	@Transactional
	public void updateUser(MyUser user) {
		usersDao.updateUser(user);
	}

	@Override
	@Transactional
	public List<Word> getDrawingWords(MyUser user) {
		return usersDao.getDrawingWords(user);
	}

	@Override
	@Transactional
	public List<UserImage> getGuessedImages(MyUser user) {
		return usersDao.getGuessedImages(user);
	}
	
	@Transactional
	public MyUser getUserWithInitializedLists(int userid) {
		MyUser user = usersDao.getUser(userid);

        return user;
	}
	

}
