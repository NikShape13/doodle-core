package com.doodle.core.spring.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class UserImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="userid")
    private MyUser user; 
    @Column(name="userid", insertable=false, updatable=false)
    private int userid;
    @Column(name="imagedata")
    private String imagedata;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name="wordid")
    private Word word;
    @Column(name="wordid", insertable=false, updatable=false)
    private int wordid;
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="guessed_images", joinColumns = @JoinColumn(name="imageid"),
	inverseJoinColumns = @JoinColumn(name="userid"))
	private List<MyUser> users;
		
	public void addUser(MyUser user) {
		if(users==null) {
			users = new ArrayList<MyUser>();
		}
		users.add(user);
	}
    
	public UserImage() {
	}
	public UserImage(int id, MyUser user, String imagedata, Word word) {
		super();
		this.id = id;
		this.imagedata = imagedata;
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
	public String getImagedata() {
		return imagedata;
	}
	public void setImagedata(String imagedata) {
		this.imagedata = imagedata;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getWordid() {
		return wordid;
	}
	public void setWordid(int wordid) {
		this.wordid = wordid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserImage other = (UserImage) obj;
		return id == other.id;
	}
    
	
    
}
