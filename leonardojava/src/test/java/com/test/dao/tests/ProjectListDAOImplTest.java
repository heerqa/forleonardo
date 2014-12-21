package com.test.dao.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.PeopleDAOImpl;
import com.test.dao.ProjectListDAO;
import com.test.dao.ProjectListDAOImpl;
import com.test.entity.People;
import com.test.entity.ProjectList;

public class ProjectListDAOImplTest {
	
	ProjectList projectList =new ProjectList("test2", "test desc");
	People peopleLinked =new People("test1", "naz", "zoya");
	ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	ProjectListDAOImpl projectListDAOImpl=ctx.getBean("projectListDAOImpl", ProjectListDAOImpl.class);
	PeopleDAOImpl peopleDAOImpl=ctx.getBean("peopleDAOImpl", PeopleDAOImpl.class);
	@Test
	public void testinsertintoProjectList() {
	
		projectListDAOImpl.insertProjectList(projectList);
	}
	
	@Test
	public void testinsertPeopleLink(){
		peopleDAOImpl.insertPeopleLink(peopleLinked);
	}

}
