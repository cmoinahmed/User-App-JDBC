package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.UserDao;
import com.ty.user.dto.User;



public class TestUserEmailANdPassword {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Email and Password");
		User user = new User();
		UserDao userdao = new UserDao();
		String email = scan.next();
		String password = scan.next();
		user.setEmail(email);
		user.setPassword(password);
		
		System.out.println(userdao.validateUserByEmailAndPassword(email, password));
		
		


	}

}
