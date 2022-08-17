package com.ty.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.user.dto.User;
import com.ty.user.helper.ConnectionObject;
import com.ty.user.helper.Encryption;



public class UserDao {
	public void saveUser(User user) {
		Connection connection = ConnectionObject.getConnection();
		String query = "INSERT INTO USER VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, user.getId());
			preparedstatement.setString(2, user.getName());
			preparedstatement.setString(3, user.getEmail());
			String pass = Encryption.encrypt(user.getPassword());
			preparedstatement.setString(4, pass);
			preparedstatement.setLong(5, user.getPhone());
			preparedstatement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User getUserById(int id) {
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM USER WHERE ID = ?";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				User user = new User();
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
				user.setPhone(resultset.getLong(5));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM USER ";
		try {
			User user = new User();
			
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
				user.setPhone(resultset.getLong(5));
				list.add(user);
			}
			for (User user1 : list) {
				System.out.println(user1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean validateUserByEmailAndPassword(String email, String password) {
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD =?";
		try {
			
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) 
			{
				User user = new User();
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
			    user.setPassword(resultset.getString(4));
				user.setPhone(resultset.getLong(5));
				System.out.println("LOGIN SUCCESSFUL");
				System.out.println(user);
				return true;
			} else
				System.out.println("INVALID EMAIL AND PASSWORD");
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean validateUserByPhoneAndPassword(long phone, String password) {
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM USER WHERE PHONE = ? AND PASSWORD =?";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setLong(1, phone);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) 
			{
				User user = new User();
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
				user.setPhone(resultset.getLong(5));
				System.out.println("LOGIN SUCCESSFUL");
				System.out.println(user);
				return true;
			} else
				System.out.println("INVALID PHONE AND PASSWORD");
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}