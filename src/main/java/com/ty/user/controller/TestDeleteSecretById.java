package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.SecretDao;
import com.ty.user.dto.Secret;

public class TestDeleteSecretById {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Secret secret = new Secret();
		SecretDao secretdao = new SecretDao();
		System.out.println("Enter Secret Id");
		int userid = scan.nextInt();
		secret.setUserid(userid);
		secretdao.deleteById(userid);
		System.out.println("Deleted Done");
	}

}
