package com.doodle.core.spring.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.UserImageDao;
import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;

import jakarta.transaction.Transactional;

@Service
public class UserImageServiceImpl implements UserImageService{
	@Autowired
	private UserImageDao userImageDao;
	
	@Override
	@Transactional
	public UserImage getUserImage(int id) {
		return userImageDao.getUserImage(id);
	}

	@Override
	@Transactional
	public void saveUserImage(UserImage userImage) {
		try {
			String base64Image = userImage.getImagedata();
			String imageData = base64Image.split(",")[1];
			
			byte[] imageBytes = Base64.getDecoder().decode(imageData);
			
		    String imagePath = "/home/user/resources/user_images/" + userImage.getUserid() +"_"+ userImage.getWordid() + ".png";

			FileOutputStream fos = new FileOutputStream(imagePath);
			fos.write(imageBytes);
			
			
			String imageUrl = "http://{ip:port}/doodle-core/api/get_image/" + userImage.getUserid() +"_"+ userImage.getWordid();
			userImage.setImagedata(imageUrl);
			
		} catch (IOException e) {
				e.printStackTrace();
		}
		
		userImageDao.saveUserImage(userImage);
	}

	@Override
	@Transactional
	public void deleteUserImage(int id) {
		userImageDao.deleteUserImage(id);
	}

	@Override
	@Transactional
	public List<UserImage> getAllUserImages(MyUser myUser) {
		return userImageDao.getAllUserImages(myUser);
	}

	@Override
	@Transactional
	public List<UserImage> getAllImagesForWord(Word word) {
		return userImageDao.getAllImagesForWord(word);
	}

	@Override
	@Transactional
	public UserImage getUserImageByUserAndWordId(int userid, int wordid) {
		return userImageDao.getUserImageByUserAndWordId(userid, wordid);
	}

	@Override
	@Transactional
	public UserImage getUserImageForUser(int userId) {
		return userImageDao.getUserImageForUser(userId);
	}

	@Transactional
	public void updateUserImage(UserImage userImage) {
		userImageDao.updateUserImage(userImage);
	}

	@Override
	@Transactional
	public List<UserImage> getAllUserImages(int userid) {
		return userImageDao.getAllUserImages(userid);
	}
	
}
