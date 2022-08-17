package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.UserDao;
import com.ty.user.dto.User;



public class TestUserPhoneAndPassword {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Phone and Password");
		User user = new User();
		UserDao userdao = new UserDao();
		long phone = scan.nextLong();
		String password = scan.next();
		user.setPhone(phone);
		user.setPassword(password);
		
		System.out.println(userdao.validateUserByPhoneAndPassword(phone, password));

	}

}
