package com.test.entity;

import java.sql.Array;

import org.springframework.beans.factory.ListableBeanFactory;
/*
 * Created by: Shagufta Naz
 * Creation date: 22/dec/e014
 * This is java bean for Projects lis
 */

public class ProjectList {
	
	private int id;//pk
	private String projectName;
	private String projectDescrition;
	private boolean status;
	
	private String all_users;
	private String completename;
	
	public ProjectList(int id, String projectName, String projectDescrition,
			boolean status, String all_users, String compeletename) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
		this.status = status;
		this.all_users = all_users;
		this.completename = compeletename;
	}
	public String getCompletename() {
		return completename;
	}
	public void setCompletename(String compeletename) {
		this.completename = compeletename;
	}
	public String getAll_users() {
		return all_users;
	}
	public void setAll_users(String all_users) {
		this.all_users = all_users;
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
	public String getProjectDescrition() {
		return projectDescrition;
	}
	public void setProjectDescrition(String projectDescrition) {
		this.projectDescrition = projectDescrition;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public ProjectList() {
			}
	public ProjectList(int id, String projectName, String projectDescrition,
			boolean status) {
		
		this.id = id;
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
		this.status = status;
	
	}
	
	public ProjectList(String projectName, String projectDescrition) {
		
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
	
		
	}
	public ProjectList(String projectName, String projectDescrition,
			String all_users) {
		super();
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
		this.all_users = all_users;
	}
	
	
	
		
}
