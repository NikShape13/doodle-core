package com.doodle.core.spring.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.WordsDao;
import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Word;

import jakarta.transaction.Transactional;

@Service
public class WordsServiceImpl implements WordsService{
	@Autowired
	private WordsDao wordsDao;

	@Override
	@Transactional
	public Word getWord(int id) {
		return wordsDao.getWord(id);
	}

	@Override
	@Transactional
	public List<Word> getAllWords(MyUser myUser) {
		return wordsDao.getAllWords(myUser);
	}

	@Override
	@Transactional
	public void saveWord(Word word) {
		wordsDao.saveWord(word);
	}

	@Override
	@Transactional
	public void deleteWord(int id) {
		wordsDao.deleteWord(id);
	}
	
	@Override
	@Transactional
	public Word getWordForUser(int userId){
		return wordsDao.getWordForUser(userId);
	}

	@Override
	@Transactional
	public void updateWord(Word word) {
		wordsDao.updateWord(word);
	}

	@Transactional
    public Word getWordWithDrawingUsers(int wordId) {
        Word word = wordsDao.getWord(wordId);
        
        return word;
    }
	
	@Transactional
    public Word initializeDrawingUsers(Word word) {

		return word;
	}

	@Override
	@Transactional
	public List<Word> getAllWords(int userid) {
		return wordsDao.getAllWords(userid);
	}
}
