package com.ty.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.user.dto.Secret;
import com.ty.user.dto.User;
import com.ty.user.helper.ConnectionObject;

public class SecretDao {

	public void saveSecret(Secret secret) {
		Connection connection = ConnectionObject.getConnection();
		String query = "INSERT INTO SECRET VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, secret.getUserid());
			preparedstatement.setString(2, secret.getName());
			preparedstatement.setString(3, secret.getKey());
			preparedstatement.setString(4, secret.getPassword());
			preparedstatement.setString(5, secret.getDescrption());
			preparedstatement.execute();
			connection.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteById(int userid) {
		Connection connection = ConnectionObject.getConnection();
		String query = "DELETE FROM SECRET WHERE USERID = ?";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, userid);
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Secret getSecretById(int userid) {
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM SECRET WHERE USERID = ?";
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, userid);
			ResultSet resultset = preparedstatement.executeQuery();
			Secret secret = new Secret();
			while (resultset.next()) {
				secret.setUserid(resultset.getInt(1));
				secret.setName(resultset.getString(2));
				secret.setKey(resultset.getString(3));
				secret.setPassword(resultset.getString(4));
				secret.setDescrption(resultset.getString(5));
			}
			return secret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Secret getSecretByIdAndName(int userid, String name) {
		Connection connection = ConnectionObject.getConnection();
		String query = "SELECT * FROM SECRET WHERE USERID = ? AND NAME = ?";
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, userid);
			preparedstatement.setString(2, name);
			ResultSet resultset = preparedstatement.executeQuery();
			Secret secret = new Secret();
			while (resultset.next()) {
				secret.setUserid(resultset.getInt(1));
				secret.setName(resultset.getString(2));
				secret.setKey(resultset.getString(3));
				secret.setPassword(resultset.getString(4));
				secret.setDescrption(resultset.getString(5));
			}
			return secret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
