package com.railway.ticket;

import java.sql.*;
import java.util.Random;

import com.railway.passenger.PassengerDTO;
import com.railway.train.TrainDTO;

public class TicketDAOImp implements TicketDAO{
	
	Connection con;

	public TicketDAOImp() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainsystem", "root", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserveTicket(int trainNum,PassengerDTO p1) throws SQLException {
		
		int trainnumber=trainNum;
		Random rand = new Random();
		int  pnrnumber = rand.nextInt(1000000) + 1;
		// My table has no passenger number as of now. Need to integrate it //
		java.sql.PreparedStatement ticketadder=con.prepareStatement("insert into ticket values (?, ?, ?,?,?,?);");
		ticketadder.setInt(1, pnrnumber);
		ticketadder.setInt(2,trainnumber);
		
		ticketadder.setString(3, p1.getName());
		ticketadder.setInt(4, p1.getNoofpassengers());
		
		/* Finding source and destination from train */
		java.sql.PreparedStatement trainroutefounder=con.prepareStatement("select source,destination from train where trainid=(?);");
		trainroutefounder.setInt(1, trainnumber);
		ResultSet trainfoundout=trainroutefounder.executeQuery();
		String source="";
		String destination="";
		while(trainfoundout.next())
		{
		 source =  trainfoundout.getString(1);
		 destination = trainfoundout.getString(2);
		}
		ticketadder.setString(5, source);
		ticketadder.setString(6, destination);
		ticketadder.executeUpdate();
	}

	public void cancelticket(TicketDTO t1) throws SQLException {
		int pnrtodelete=t1.getPnrnumber();
		java.sql.PreparedStatement pnrvalidator=con.prepareStatement("select * from ticket where pnrnumber = (?);");
		pnrvalidator.setInt(1,pnrtodelete);
		ResultSet pnrcheck = pnrvalidator.executeQuery();
		if(pnrcheck.next()){
		java.sql.PreparedStatement pnrdeletion=con.prepareStatement("delete  from ticket where pnrnumber = (?);");
		pnrdeletion.setInt(1, pnrtodelete);
		pnrdeletion.executeUpdate();
		}
		else{
		System.out.println("You entered wrong PNR");
		}
		
	}
	
	public void showTicket(TicketDTO t1) throws SQLException{
		int pnrToShow=t1.getPnrnumber();
		java.sql.PreparedStatement pnrShow=con.prepareStatement("select * from ticket where pnrnumber = (?);");
		pnrShow.setInt(1,pnrToShow );
		ResultSet show = pnrShow.executeQuery();
		if(show.next()){
		while (show.next()) {
		System.out.println(show.getInt(1) + " " + show.getInt(2)+ " " + show.getString(3) + " " + show.getInt(4) + " " + " " + show.getString(5)+ " " + show.getString(6));
		}
		}
		else{
		System.out.println("No ticket found");
		}
		}
	

}
