package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.entity.People;
import com.test.entity.ProjectList;


@Repository
public class PeopleDAOImpl implements PeopleDAO{
	
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
	public List<People> getPeopleLink(ProjectList projectList) {
		List<People> peopleLinked =new ArrayList<People>();
		String sql="select * from people where projectname=?";
		
		peopleLinked=jdbcTemplate.query(sql, new Object[]{projectList.getProjectName()}, new PeopleLinkedRowMapper());

		return peopleLinked;
	}

	@Override
	public void insertPeopleLink(People people) {
		String sql="insert into people(projectname,completename) values(?,?)";
		jdbcTemplate.update(sql, new Object[]{people.getProjectName(), people.getCompleteName()});
	
		
	}

	@Override
	public void updatePeopleLink(People peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletPeopleLink(People peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletAllPeopleLink(People peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	

	private static final class PeopleLinkedRowMapper implements RowMapper<People>{

		public People mapRow(ResultSet rs, int rowNum) throws SQLException {
			People peopleLinked=new People();
			peopleLinked.setProjectName(rs.getString("projectname"));
			peopleLinked.setCompleteName(rs.getString("completename"));
		
			return peopleLinked;
		}
		
	}



	@Override
	public List<People> getAllPeople() {
		List<People> allpeople=new ArrayList<People>();
		String sql="select * from people";
		allpeople=jdbcTemplate.query(sql, new PeopleLinkedRowMapper());
		return allpeople;
	}



	
}
