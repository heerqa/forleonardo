package com.test.entity;

public class PeopleLinked {

	private int id;//pk
	private String projectName;//fk
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public PeopleLinked(){};
	public PeopleLinked(String projectName, String name) {
		
		this.projectName = projectName;
		this.name = name;
	}
	
	
}
