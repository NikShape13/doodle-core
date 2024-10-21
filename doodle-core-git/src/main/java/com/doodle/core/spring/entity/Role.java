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
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="role")
	private String role;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="authorities", joinColumns = @JoinColumn(name="roleid"),
	inverseJoinColumns = @JoinColumn(name="userid"))
	private List<MyUser> users;
		
	public void addUser(MyUser user) {
		if(users==null) {
			users = new ArrayList<MyUser>();
		}
		users.add(user);
	}
	
	public Role() {

	}
	
	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
