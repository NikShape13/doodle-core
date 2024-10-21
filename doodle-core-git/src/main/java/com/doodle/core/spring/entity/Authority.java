package com.doodle.core.spring.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
	@Id
	@Column(name="userid", insertable=false, updatable=false)
	private int userid;
	@Column(name="roleid")
	private int roleid;

	public Authority() {
	}
	
	public Authority(int userid, int roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
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
		Authority other = (Authority) obj;
		return Objects.equals(userid, other.userid);
	}	
}
