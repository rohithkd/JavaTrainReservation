package com.railway.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImp implements UserDAO {
	Connection con;

	public UserDAOImp() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainsystem", "root", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createNewUser(UserDTO t1) throws SQLException {
		PreparedStatement stat = con.prepareStatement("INSERT INTO user(username,password) VALUES(?,?)");
		stat.setString(1, t1.getUserName());
		stat.setString(2, t1.getPassword());
		stat.executeUpdate();

	}

	public boolean authenticateUser(UserDTO t1) throws SQLException {
		PreparedStatement stat = con.prepareStatement("select password from user where username=?");
		stat.setString(1, t1.getUserName());
		ResultSet rs = stat.executeQuery();
		String password = null;
		while (rs.next()) {
			password = rs.getString(1);
		}
		if (t1.getPassword().equals(password))
			return true;
		else
			return false;

	}

}
