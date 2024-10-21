package com.doodle.core.spring.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jwt")
public class JWTEntity {
	@Id
	@Column(name="userid")
	private int userid;
	@Column(name="token")
	private String token;

	public JWTEntity() {
	}
	public JWTEntity(int userid, String token) {
		this.userid = userid;
		this.token = token;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JWTEntity other = (JWTEntity) obj;
		return userid == other.userid;
	}
	
	

}
