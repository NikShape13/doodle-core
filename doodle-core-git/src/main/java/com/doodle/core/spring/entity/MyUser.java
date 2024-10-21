package com.doodle.core.spring.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import com.doodle.core.spring.myOwnValidationAnnotations.EmailValidator;
//import com.doodle.core.spring.myOwnValidationAnnotations.PasswordValidator;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class MyUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Size(min=5, max=10)
	@Column(name="username")
	private String username;
	@Email
	@Size(min=10, max=50)
	@Column(name="email")
	private String email;
	@Column(name="password")
	@Size(min=5, max=15)
//	@PasswordValidator
	private String password;
	@Column(name="enabled")
	private Integer enabled = 1;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy="userid", fetch = FetchType.LAZY)
	private List<Word> words;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy="userid", fetch = FetchType.LAZY)
	private List<UserImage> userImages;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="authorities", joinColumns = @JoinColumn(name="userid"),
	inverseJoinColumns = @JoinColumn(name="roleid"))
	private List<Role> roles;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinTable(name="guessed_images", joinColumns = @JoinColumn(name="userid"),
	inverseJoinColumns = @JoinColumn(name="imageid"))
	private List<UserImage> guessedImages;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinTable(name="drawing_word", joinColumns = @JoinColumn(name="userid"),
	inverseJoinColumns = @JoinColumn(name="wordid"))
	private List<Word> drawingWords;
	
	public void addDrawingWord(Word word) {
		if(drawingWords==null) {
			drawingWords = new ArrayList<Word>();
		}
		drawingWords.add(word);
	}
	
	
	public void addGuessedImage(UserImage userImage) {
		if(guessedImages==null) {
			guessedImages = new ArrayList<UserImage>();
		}
		guessedImages.add(userImage);
	}
	
	public void addRole(Role role) {
		if(roles==null) {
			roles = new ArrayList<Role>();
		}
		roles.add(role);
	}
	
	public MyUser() {
	}
	public MyUser(int id, String username, String email, String password, int enabled) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "MyUser [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyUser other = (MyUser) obj;
		return Objects.equals(username, other.username);
	}

	
}
