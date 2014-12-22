package com.test.dao;

import java.util.List;

import com.test.entity.People;
import com.test.entity.ProjectList;


public interface PeopleDAO {
	
	public List<People> getPeopleLink(ProjectList projectList);
	public void insertPeopleLink(People people);
	public void updatePeopleLink(People people);
	public void deletPeopleLink(People people);
	public void deletAllPeopleLink(People people);



}
