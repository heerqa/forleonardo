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

import com.test.entity.PeopleLinked;
import com.test.entity.ProjectList;

@Repository
public class PeopleLinkedDAOImpl implements PeopleLinkedDAO{
	
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
	public List<PeopleLinked> getPeopleLink() {
		List<PeopleLinked> peopleLinked =new ArrayList<PeopleLinked>();
		String sql="select * from peoplelinked";
		
		peopleLinked=jdbcTemplate.query(sql, new PeopleLinkedRowMapper());

		return peopleLinked;
	}

	@Override
	public void insertPeopleLink(PeopleLinked peopleLinked) {
		String sql="insert into peoplelinked(projectname,name) values(?,?)";
		jdbcTemplate.update(sql, new Object[]{peopleLinked.getProjectName(), peopleLinked.getName()});
	
		
	}

	@Override
	public void updatePeopleLink(PeopleLinked peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletPeopleLink(PeopleLinked peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletAllPeopleLink(PeopleLinked peopleLinked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPeopleLink(String porjectName) {
		// TODO Auto-generated method stub
		return null;
	}

	private static final class PeopleLinkedRowMapper implements RowMapper<PeopleLinked>{

		public PeopleLinked mapRow(ResultSet rs, int rowNum) throws SQLException {
			PeopleLinked peopleLinked=new PeopleLinked();
			peopleLinked.setProjectName(rs.getString("projectname"));
			peopleLinked.setName(rs.getString("name"));
			
			return peopleLinked;
		}
		
	}
}
