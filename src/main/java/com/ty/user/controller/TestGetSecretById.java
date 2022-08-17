package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.SecretDao;

public class TestGetSecretById {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id");
		int id = scan.nextInt();
		SecretDao secretdao = new SecretDao();
		if(secretdao.getSecretById(id) != null) {
			System.out.println(secretdao.getSecretById(id));
			System.out.println("Got Secret By Id");
		}
		else
			System.out.println("Null");

	}

}
