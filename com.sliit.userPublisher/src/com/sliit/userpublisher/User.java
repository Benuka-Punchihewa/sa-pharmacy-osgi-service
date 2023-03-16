package com.sliit.userpublisher;

import java.io.Serializable;

public class User implements Serializable{

	private String user_id;
	private String username;
	private String age;
	private String contect_number;
	private String address;
	
	
	public User(String user_id, String username, String age, String contect_number, String address) {
		this.user_id = user_id;
		this.username = username;
		this.age = age;
		this.contect_number = contect_number;
		this.address = address;
	}


	public User() {
		super();
	}
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getContect_number() {
		return contect_number;
	}


	public void setContect_number(String contect_number) {
		this.contect_number = contect_number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
