package com.doodle.core.spring.service;

import java.util.List;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

public interface UserImageService {
	public UserImage getUserImage(int id);
	
	public void saveUserImage(UserImage userImage);
	
	public void deleteUserImage(int id);
	
	public List<UserImage> getAllUserImages(MyUser myUser);
	
	public List<UserImage> getAllImagesForWord(Word word);
	
	public UserImage getUserImageByUserAndWordId(int userid, int wordid);
	
	public UserImage getUserImageForUser(int userId);
	
	public void updateUserImage(UserImage userImage);
	
	public List<UserImage> getAllUserImages(int userid);


}
