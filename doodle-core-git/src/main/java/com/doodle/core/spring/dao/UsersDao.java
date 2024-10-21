package com.doodle.core.spring.dao;

import java.util.List;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

public interface UsersDao {
	public List<MyUser> getAllUsers();
	
	public MyUser getUser(String username);
	
	public MyUser getUser(int id);
	
	public Integer saveUser(MyUser myUser);
	
	public void deleteUser(String username);
	
	public void deleteUser(int id);
	
	public MyUser checkEmail(String email);
	
	public void updateUser(MyUser user);
	
	public List<Word> getDrawingWords(MyUser user);
	
	public List<UserImage> getGuessedImages(MyUser user);
}
