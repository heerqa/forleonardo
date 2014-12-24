package com.test.dao;

import java.util.List;

import com.test.entity.People;
import com.test.entity.ProjectList;


public interface PeopleDAO {
	
	public List<People> getPeopleLink(ProjectList projectList);
	public boolean insertPeopleLink(People people, ProjectList projectList);
	public void updatePeopleLink(People people);
	public void deletPeopleLink(People people, ProjectList projectList);
	public void deletAllPeopleLink(People people);
	public List<People> getAllPeople();


}
