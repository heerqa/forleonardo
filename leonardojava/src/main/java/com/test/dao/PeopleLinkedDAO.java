package com.test.dao;

import java.util.List;

import com.test.entity.PeopleLinked;


public interface PeopleLinkedDAO {
	
	public List<PeopleLinked> getPeopleLink();
	public void insertPeopleLink(PeopleLinked peopleLinked);
	public void updatePeopleLink(PeopleLinked peopleLinked);
	public void deletPeopleLink(PeopleLinked peopleLinked);
	public void deletAllPeopleLink(PeopleLinked peopleLinked);
	public String getPeopleLink(String porjectName);


}
