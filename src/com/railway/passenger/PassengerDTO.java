package com.railway.passenger;

public class PassengerDTO {
	
	String name;
	int age;
	int noofpassengers;
	String gender;
	
	public PassengerDTO(String name, int age,int noofpassengers,String gender){
		this.name=name;
		this.age=age;
		this.noofpassengers=noofpassengers;
		this.gender=gender;
		
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNoofpassengers() {
		return noofpassengers;
	}
	
	public void setNoofpassengers(int noofpassengers) {
		this.noofpassengers = noofpassengers;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

}
