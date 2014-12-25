package com.test.dao;

import java.util.List;

import com.test.entity.People;
import com.test.entity.ProjectList;

public interface ProjectListDAO {
	
	public List<ProjectList> getProjectList();
	public List<ProjectList> getProjectListWithUser();
	public void insertProjectList(ProjectList projectList);
	public boolean updateProjectList(ProjectList projectList, ProjectList projectListcurrent);
	
	public boolean deactivateProjectList(ProjectList projectList);
	public void deletProjectList(ProjectList projectList);
	public void deletAllProjectList(ProjectList projectList);
	public String getProjectList(String porjectName);
	
	public ProjectList getProjectList(int id);
	


}
