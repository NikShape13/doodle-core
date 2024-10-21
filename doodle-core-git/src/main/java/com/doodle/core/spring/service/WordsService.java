package com.doodle.core.spring.service;

import java.util.List;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Word;

public interface WordsService {
	public Word getWord(int id);
	
	public List<Word> getAllWords(MyUser myUser);
	
	public void saveWord(Word word);
	
	public void deleteWord(int id);
	
	public Word getWordForUser(int userId);
	
	public void updateWord(Word word);
	
	public Word getWordWithDrawingUsers(int wordId);
	
	public Word initializeDrawingUsers(Word word);
	
	List<Word> getAllWords(int userid);
}
