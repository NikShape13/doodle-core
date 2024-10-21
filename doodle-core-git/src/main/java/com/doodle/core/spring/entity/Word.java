package com.doodle.core.spring.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="words")
public class Word {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private MyUser user;
	@Column(name="userid", insertable=false, updatable=false)
	private int userid;
	@Column(name="word")
	private String word;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy="wordid", fetch = FetchType.LAZY)
	private List<UserImage> images;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="drawing_word", joinColumns = @JoinColumn(name="wordid"),
	inverseJoinColumns = @JoinColumn(name="userid"))
	private List<MyUser> drawingUsers;
	
	
	public Word(MyUser user, String word) {
		this.user = user;
		this.word = word;
	}
	
	public void addDrawingUsers(MyUser user) {
		if(drawingUsers==null) {
			drawingUsers = new ArrayList<MyUser>();
		}
		drawingUsers.add(user);
	}
	public Word() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", userid=" + userid + ", word=" + word + ", images="  + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
