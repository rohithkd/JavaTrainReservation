import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.railway.passenger.PassengerDAOImp;
import com.railway.passenger.PassengerDTO;
import com.railway.ticket.TicketDAOImp;
import com.railway.ticket.TicketDTO;
import com.railway.train.TrainDAO;
import com.railway.train.TrainDAOImp;
import com.railway.train.TrainDTO;
import com.railway.user.UserDAOImp;
import com.railway.user.UserDTO;

public class RailwayApp {
	public static void main(String args[]) throws IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		String cont=null;
		do{
		System.out.println("Enter your choice 1.Login 2.Sign Up");
		char choice = (char) System.in.read();
		switch (choice) {
		case '1':
			UserDAOImp u1 = new UserDAOImp();
			UserDTO d1 = new UserDTO();
			System.out.println("*******************");
			System.out.println("Enter your username\n");
			String userName = sc.next();
			d1.setUserName(userName);
			System.out.println("*******************");
			System.out.println("Enter your password\n");
			String password = sc.next();
			d1.setPassword(password);
			if(u1.authenticateUser(d1)){
				System.out.println("Enter your choice 1.Show train 2.Book ticket 3. Cancel ticket 4. Show  ticket ");
				char secondchoice = (char) System.in.read();
				switch(secondchoice){
					case '1' : 
						System.out.println("Enter the source station");
						String source = sc.next();
						System.out.println("Enter the destination station");
						String destination = sc.next();
						TrainDAOImp train=new TrainDAOImp();
						train.getTrainsBySourceAndDes(source, destination);
						break;
					case '2' :
						System.out.println("Enter the train Id");
						int id=sc.nextInt();
						System.out.println("Enter the number of passengers:");
						int num=sc.nextInt();
						System.out.println("Enter name of passenger");
						String name = sc.next();
						System.out.println("Enter the age of main passenger:");
						int age=sc.nextInt();
						System.out.println("Enter gender of main passenger");
						String gender = sc.next();
						PassengerDTO passengerdetail=new PassengerDTO(name, age, num, gender);
						PassengerDAOImp passenger=new PassengerDAOImp();
						passenger.addPassenger(passengerdetail);
						TicketDAOImp newTicket=new TicketDAOImp();
						newTicket.reserveTicket(id, passengerdetail);
						break;
					case '3' :
						System.out.println("Enter the ticket number to cancel");
						int ticketNum=sc.nextInt();
						TicketDTO ticket=new TicketDTO();
						ticket.setPnrnumber(ticketNum);
						TicketDAOImp deleteTicket=new TicketDAOImp();
						deleteTicket.cancelticket(ticket);
						break;
						
					case '4' :
						System.out.println("Enter the ticket number to see details");
						int ticketNumToView=sc.nextInt();
						TicketDTO ticketView=new TicketDTO();
						ticketView.setPnrnumber(ticketNumToView);
						TicketDAOImp seeTicket=new TicketDAOImp();
						seeTicket.showTicket(ticketView);
						break;
				}
				
				
				
				System.out.println("Do you want to stop Application y/n?");
				cont=sc.next();
			}
			else{
				System.out.println("Invalid Username/Password");
				System.out.println("Do you want to stop Application y/n?");
				cont=sc.next();
			}
			break;

		case '2':
			UserDAOImp u2 = new UserDAOImp();
			UserDTO d2 = new UserDTO();
			System.out.println("****************************");
			System.out.println("Enter your username you want");
			String userName1 = sc.next();
			d2.setUserName(userName1);
			System.out.println("****************************");
			System.out.println("Enter your password you want");
			String password1 = sc.next();
			d2.setPassword(password1);
			u2.createNewUser(d2);
			System.out.println("Do you want to stop Application y/n?");
			cont=sc.next();

		}
		}while(cont.equalsIgnoreCase("n"));
		
	}
}
