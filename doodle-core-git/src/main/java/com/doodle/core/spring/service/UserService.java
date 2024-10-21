package com.doodle.core.spring.service;

import java.util.List;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

public interface UserService {
	public List<MyUser> getAllUsers();
	
	public MyUser getUser(String urename);
	
	public MyUser getUser(int id);
	
	public void deleteUser(String urename);
	
	public void deleteUser(int id);
	
	public Integer saveUser(MyUser myUser);
	
	public MyUser checkEmail(String email);
	
	public void updateUser(MyUser user);
	
	public List<Word> getDrawingWords(MyUser user);
	
	public List<UserImage> getGuessedImages(MyUser user);
	
	public MyUser getUserWithInitializedLists(int userid);

}
