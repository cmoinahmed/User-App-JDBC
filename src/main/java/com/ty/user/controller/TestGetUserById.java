package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.UserDao;


public class TestGetUserById {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id");
		UserDao userdao = new UserDao();
		int id = scan.nextInt();
		if(userdao.getUserById(id) != null) {
			System.out.println(userdao.getUserById(id));
		}
		else
			System.out.println("Null");

	}

}
