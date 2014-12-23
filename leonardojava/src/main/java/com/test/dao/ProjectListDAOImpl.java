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
		
		projectList=jdbcTemplate.query(sql, new ProjectListAllRowMapper());

		return projectList;
	}
	
	private static final class ProjectListAllRowMapper implements RowMapper<ProjectList>{

		public ProjectList mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectList projectList=new ProjectList();
			projectList.setId(rs.getInt("id"));
			projectList.setProjectName(rs.getString("projectname"));
			projectList.setProjectDescrition(rs.getString("projectdescription"));
			
			
			return projectList;
		}
		
	}
	private static final class ProjectListRowMapper implements RowMapper<ProjectList>{

		public ProjectList mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectList projectList=new ProjectList();
			projectList.setId(rs.getInt("id"));
			projectList.setProjectName(rs.getString("projectname"));
			projectList.setProjectDescrition(rs.getString("projectdescription"));
			projectList.setAll_users(rs.getString("all_users"));
			
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

	@Override
	public List<ProjectList> getProjectListWithUser() {
		List<ProjectList> projectList =new ArrayList<ProjectList>();
		String sql="select projectlist.projectname,projectlist.projectdescription,projectlist.id, array_to_string(array_agg(distinct people.completename),',') as all_users from " 

		+"projectlist inner join people on projectlist.projectname=people.projectname where status='t' group by "

		+"projectlist.projectname,projectlist.projectdescription,projectlist.id";
		
		projectList=jdbcTemplate.query(sql, new ProjectListRowMapper());

		return projectList;
	}

	@Override
	public ProjectList getProjectList(int id) {
		ProjectList projectList;
		String sql="select * from projectlist where id=?";
		projectList=(ProjectList) jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProjectListAllRowMapper() );
		return projectList;
	}

}
