package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.UserDao;
import com.ty.user.dto.User;


public class TestSaveUser {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER USER Id, Name, Email, Password, Phone");
		User user = new User();
		UserDao userdao = new UserDao();
		int id = scan.nextInt();
		String name = scan.next();
		String email  = scan.next();
		String password = scan.next();
		Long phone  = scan.nextLong();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		userdao.saveUser(user);
		System.out.println("User is Saved");
	}

}
