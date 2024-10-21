package com.doodle.core.spring.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="points")
public class Points {
	@Id
	@Column(name="userid")
	private int userid;
	@Column(name="points")
	private int points = 0;

	public Points() {
	}
	
	
	public Points(int userid, int points) {
		this.userid = userid;
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
		Points other = (Points) obj;
		return userid == other.getUserid();
	}
}
