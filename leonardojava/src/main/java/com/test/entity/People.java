package com.test.entity;

public class People {

	private int id;//pk
	private String projectName;//fk
	private String firstName;
	
	private String lastName;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public People(){}
	public People(String projectName, String firstName, String lastName) {
		
		this.projectName = projectName;
		this.firstName = firstName;
		this.lastName = lastName;
	};

	
}
