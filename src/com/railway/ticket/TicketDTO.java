package com.railway.ticket;

public class TicketDTO {
	int pnrnumber;
	int trainid;
	String name;
	int noofpassengers;
	String source;
	String destination;
	public int getPnrnumber() {
		return pnrnumber;
	}
	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}
	public int getTrainid() {
		return trainid;
	}
	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoofpassengers() {
		return noofpassengers;
	}
	public void setNoofpassengers(int noofpassengers) {
		this.noofpassengers = noofpassengers;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	

}
