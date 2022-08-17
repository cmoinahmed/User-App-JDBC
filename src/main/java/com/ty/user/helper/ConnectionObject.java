package com.ty.user.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObject {

	private static String username = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/user_jdbc";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}

