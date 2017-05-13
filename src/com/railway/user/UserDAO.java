package com.railway.user;

import java.sql.SQLException;

public interface UserDAO {
	public void createNewUser(UserDTO t1) throws SQLException;

	public boolean authenticateUser(UserDTO t1) throws SQLException;
}
