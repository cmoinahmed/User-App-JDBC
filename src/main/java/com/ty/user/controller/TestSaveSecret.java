package com.ty.user.controller;

import java.util.Scanner;

import com.ty.user.dao.SecretDao;
import com.ty.user.dto.Secret;



public class TestSaveSecret {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER Secret UserId, Name, Key, Password, Descrption");
		Secret secret = new Secret();
		SecretDao secretdao = new SecretDao();
		int userid = scan.nextInt();
		String name = scan.next();
		String key  = scan.next();
		String password = scan.next();
		String descrption = scan.next();
		
		secret.setUserid(userid);
		secret.setName(name);
		secret.setKey(key);
		secret.setPassword(password);
		secret.setDescrption(descrption);
		secretdao.saveSecret( secret);
		System.out.println("SecretKey is Saved");
		
	}

}
