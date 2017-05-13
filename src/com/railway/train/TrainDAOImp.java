package com.railway.train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDAOImp {

	private static Connection con;

	public TrainDAOImp() {
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

	public ArrayList<Integer> getTrainsBySourceAndDes(String source, String dest) {

		ArrayList<Integer> trainList = new ArrayList<Integer>();
		int trainid = 0;
		try {
			PreparedStatement prepStat = con
					.prepareStatement("SELECT * from train where source = (?) and destination = (?);");

			prepStat.setString(1, source);
			prepStat.setString(2, dest);

			ResultSet rs = prepStat.executeQuery();
			while (rs.next()) {
				trainid = rs.getInt(1);
				trainList.add(trainid);
			}
			if (trainid == 0) {
				System.out.println("No such train");
			}
			
			System.out.println("The matched trains are " + trainList);
			
		} catch (SQLException e) {
			System.out.println("Failed to select from DB");
		}

		return trainList;
	}

	public void getListOfTrains() {

		PreparedStatement prepStat;
		try {
			prepStat = con.prepareStatement("select * from train");

			ResultSet rs = prepStat.executeQuery();
			while (rs.next()) {
				System.out.println(" | " + rs.getInt(1) + " | "
						+ rs.getString(2) + " | " + rs.getString(3));
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
