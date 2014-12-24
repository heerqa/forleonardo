package com.test.dao.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.junit.Ignore;
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
	People peopleLinked =new People("demo1", "zoya", "naz", "zoya naz");
	ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	ProjectListDAOImpl projectListDAOImpl=ctx.getBean("projectListDAOImpl", ProjectListDAOImpl.class);
	PeopleDAOImpl peopleDAOImpl=ctx.getBean("peopleDAOImpl", PeopleDAOImpl.class);
	@Ignore
	@Test
	public void testinsertintoProjectList() {
	
		projectListDAOImpl.insertProjectList(projectList);
	}
	@Ignore
	@Test
	public void testupdateProjectList(){
		ProjectList projectList=new ProjectList();
		projectList.setProjectName("tttt");
		projectList.setProjectDescrition("ddddd");
		projectList.setId(37);
		System.out.println(projectListDAOImpl.updateProjectList(projectList));
	}
	
	@Ignore
	@Test
	public void testinsertPeopleLink(){
		projectList.setId(36);
		System.out.println(peopleDAOImpl.insertPeopleLink(peopleLinked,projectList));
	}
	
	@Ignore
	@Test
	public void testgetPeopleLink(){
		
		
		System.out.println(peopleDAOImpl.getPeopleLink(projectList).size());
	}
	@Ignore
	@Test
	public void testgetProjectListWithUser(){
		List<ProjectList> projectlist=projectListDAOImpl.getProjectListWithUser();
		
		for (ProjectList projectList2 : projectlist) {
			System.out.println(projectList2.getProjectName()+" "+projectList2.getProjectDescrition()+" "+projectList2.getAll_users()+" " );
			
		}
		
		
	}
	@Ignore
	@Test
	public void testgetProjectList(){
		List<ProjectList> projectlist=projectListDAOImpl.getProjectList();
		
		for (ProjectList projectList2 : projectlist) {
			System.out.println(projectList2.getId()+""+projectList2.getProjectName()+" "+projectList2.getProjectDescrition() );
			
		}
		
		
	}
	@Ignore
	@Test
	public void testgetSingleProjectList(){
		ProjectList projectlist=projectListDAOImpl.getProjectList(54);
		
		
			System.out.println(projectlist.getId()+""+projectlist.getProjectName()+" "+projectlist.getProjectDescrition() );
			
		
		
		
	}


}
