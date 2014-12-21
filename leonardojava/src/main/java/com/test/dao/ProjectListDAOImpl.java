package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;




import com.test.entity.ProjectList;

@Repository
public class ProjectListDAOImpl implements ProjectListDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}


	@Override
	public List<ProjectList> getProjectList() {
		List<ProjectList> projectList =new ArrayList<ProjectList>();
		String sql="select * from projectlist";
		
		projectList=jdbcTemplate.query(sql, new ProjectListRowMapper());

		return projectList;
	}
	
	private static final class ProjectListRowMapper implements RowMapper<ProjectList>{

		public ProjectList mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectList projectList=new ProjectList();
			projectList.setProjectName(rs.getString("(projectname"));
			projectList.setProjectDescrition(rs.getString("(projectdescription"));
			projectList.setStatus(rs.getBoolean("status"));
			
			return projectList;
		}
		
	}

	@Override
	public void insertProjectList(ProjectList projectList) {
	String sql="insert into projectlist(projectname,projectdescription) values(?,?);";
		jdbcTemplate.update(sql, new Object[]{projectList.getProjectName(), projectList.getProjectDescrition()});
		
		
	}

	@Override
	public void updateProjectList(ProjectList projectList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletProjectList(ProjectList projectList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletAllProjectList(ProjectList projectList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getProjectList(String porjectName) {
		// TODO Auto-generated method stub
		return null;
	}

}
