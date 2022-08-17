package com.ty.user.controller;

import com.ty.user.dao.UserDao;

public class TestGetAllUser {

	public static void main(String[] args) 
	{
		UserDao userdao =new UserDao();
		System.out.println("ALL USERS ARE DISPLAYED");
		userdao.getAllUser();
	}

}
