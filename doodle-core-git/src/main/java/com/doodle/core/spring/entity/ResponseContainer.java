package com.doodle.core.spring.entity;

public class ResponseContainer {
	private int userid;
	
	private Object data;
	
	private String token;

	public ResponseContainer() {
	}

	public ResponseContainer(int userid, Object data, String token) {
		super();
		this.userid = userid;
		this.data = data;
		this.token = token;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
