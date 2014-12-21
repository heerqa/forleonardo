package com.test.dao.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.PeopleLinkedDAOImpl;
import com.test.dao.ProjectListDAO;
import com.test.dao.ProjectListDAOImpl;
import com.test.entity.PeopleLinked;
import com.test.entity.ProjectList;

public class ProjectListDAOImplTest {
	
	ProjectList projectList =new ProjectList("test2", "test desc");
	PeopleLinked peopleLinked =new PeopleLinked("test1", "Naz");
	ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	ProjectListDAOImpl projectListDAOImpl=ctx.getBean("projectListDAOImpl", ProjectListDAOImpl.class);
	PeopleLinkedDAOImpl peopleLinkedDAOImpl=ctx.getBean("peopleLinkedDAOImpl", PeopleLinkedDAOImpl.class);
	@Test
	public void testinsertintoProjectList() {
	
		projectListDAOImpl.insertProjectList(projectList);
	}
	
	@Test
	public void testinsertPeopleLink(){
		peopleLinkedDAOImpl.insertPeopleLink(peopleLinked);
	}

}
