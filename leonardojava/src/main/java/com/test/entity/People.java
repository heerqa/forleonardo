package com.test.entity;

public class People {

	private int id;//pk
	private String projectName;//fk
	private String firstName;	
	private String lastName;
	public People(String projectName, String firstName, String lastName,
			String completeName) {
		super();
		this.projectName = projectName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.completeName = completeName;
	}
	private String completeName;
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
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	
	public People(){};
	public People(String projectName, String completeName) {
		super();
		this.projectName = projectName;
		this.completeName = completeName;
	}	
	
	
	
	
		
}
