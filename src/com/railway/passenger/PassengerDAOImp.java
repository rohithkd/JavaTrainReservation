package com.railway.passenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAOImp implements PassengerDAO {

	private static Connection con;

	public PassengerDAOImp() {
		getDBCon();
	}

	private static void getDBCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/trainsystem", "root",
					"root123");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Interrupted");
		}
	}

	public void addPassenger(PassengerDTO psDTO) {
		try {
			PreparedStatement prepStat = con
					.prepareStatement("insert into passenger values(?,?,?,?)");

			prepStat.setString(1, psDTO.getName());
			prepStat.setInt(2, psDTO.getAge());
			prepStat.setInt(3, psDTO.getNoofpassengers());
			prepStat.setString(4, psDTO.getGender());

			int rows_affected = prepStat.executeUpdate();

			if (rows_affected != 0) {
				System.out.println("Rows of DB added succesfully");
			} else {
				System.out.println("Failed to add");
			}

		} catch (SQLException e) {
			System.out.println("Failed to add to DB");
		}

	}

	public void findPassengerInfo() {

		PreparedStatement prepStat;
		try {
			prepStat = con.prepareStatement("select * from passenger");

			ResultSet rs = prepStat.executeQuery();
			while (rs.next()) {
				System.out.println(" | " + rs.getInt(1) + " | "
						+ rs.getString(2) + " | " + rs.getString(3) + " | "
						+ rs.getInt(4) + " | ");
			}

		} catch (SQLException e) {
			System.out.println("Failed to retrieve from DB");
		}

	}

	public void closeDBCon() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Failed to close DB");
		}
	}
}
