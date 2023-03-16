package com.sliit.userpublisher;

public interface UserServicePublish {
	public User creteUser(String user_id , String username, String age, String contect_number,String address);
	public User getUsereById(String user_id);
}
