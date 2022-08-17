package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.SecretDao;

public class TestSecretByIdAndName {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id And Name");
		int id = scan.nextInt();
		String name = scan.next();
		SecretDao secretdao = new SecretDao();
		if(secretdao.getSecretByIdAndName(id, name) != null) {
			System.out.println(secretdao.getSecretByIdAndName(id, name));
			System.out.println("Got Secret By Id and Name");
		}
		else
			System.out.println("Null");

	}

}
