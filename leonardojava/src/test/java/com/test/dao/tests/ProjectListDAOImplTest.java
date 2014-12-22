package com.test.dao.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
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
	People peopleLinked =new People("test2", "shagufta Naz");
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
	
	@Test
	public void testgetPeopleLink(){
		
		
		System.out.println(peopleDAOImpl.getPeopleLink(projectList).size());
	}
	
	@Test
	public void testgetProjectListWithUser(){
		List<ProjectList> projectlist=projectListDAOImpl.getProjectListWithUser();
		
		for (ProjectList projectList2 : projectlist) {
			System.out.println(projectList2.getProjectName()+" "+projectList2.getProjectDescrition()+" "+projectList2.getAll_users()+" " );
			
		}
		
		
	}
	
	@Test
	public void testgetProjectList(){
		List<ProjectList> projectlist=projectListDAOImpl.getProjectList();
		
		for (ProjectList projectList2 : projectlist) {
			System.out.println(projectList2.getId()+""+projectList2.getProjectName()+" "+projectList2.getProjectDescrition() );
			
		}
		
		
	}


}
