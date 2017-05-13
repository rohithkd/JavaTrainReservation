package com.railway.ticket;

import java.sql.SQLException;

import com.railway.passenger.PassengerDTO;
import com.railway.train.TrainDTO;

public interface TicketDAO {
	public void reserveTicket(int trainNum,PassengerDTO p1) throws SQLException;
	public void cancelticket(TicketDTO t1) throws SQLException;
	public void showTicket(TicketDTO t1) throws SQLException;


}
