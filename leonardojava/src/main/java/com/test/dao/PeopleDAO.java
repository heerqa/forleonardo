package com.test.dao;

import java.util.List;

import com.test.entity.People;


public interface PeopleDAO {
	
	public List<People> getPeopleLink();
	public void insertPeopleLink(People people);
	public void updatePeopleLink(People people);
	public void deletPeopleLink(People people);
	public void deletAllPeopleLink(People people);
	public String getPeopleLink(String porjectName);


}
