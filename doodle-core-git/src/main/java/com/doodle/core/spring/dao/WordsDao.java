package com.doodle.core.spring.dao;

import java.util.List;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Word;

public interface WordsDao {
	public Word getWord(int id);
	
	public List<Word> getAllWords(MyUser myUser);
	
	public void saveWord(Word word);
	
	public void deleteWord(int id);
	
	public Word getWordForUser(int userId);

	public void updateWord(Word word);

	List<Word> getAllWords(int userid);
	
}
