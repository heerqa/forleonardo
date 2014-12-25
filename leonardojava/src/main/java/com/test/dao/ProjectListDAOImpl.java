package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;








import javax.sql.DataSource;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;











import com.test.entity.People;
import com.test.entity.ProjectList;

@Repository
public class ProjectListDAOImpl implements ProjectListDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	@Autowired
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

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
		
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    		String sql="select * from projectlist";
	    		
	    		projectList=jdbcTemplate.query(sql, new ProjectListAllRowMapper());
     
	    		transactionManager.commit(status);
	    	
	    	  
	      } catch (DataAccessException e) {
	    	 
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          throw e;
	          
	       }
		/*String sql="select * from projectlist";
		
		projectList=jdbcTemplate.query(sql, new ProjectListAllRowMapper());
*/
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
			//projectList.setAll_users(rs.getString("all_users"));
			projectList.setCompletename(rs.getString("completename"));
			
			
			return projectList;
		}
		
	}

	@Override
	public void insertProjectList(ProjectList projectList) {
		
			TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    		String sql="insert into projectlist(projectname,projectdescription) values(?,?);";
	    		jdbcTemplate.update(sql, new Object[]{projectList.getProjectName(), projectList.getProjectDescrition()});
	    			    		    	  
	    	     
	    		transactionManager.commit(status);
	    	
	    	  
	      } catch (DataAccessException e) {
	    	 
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          throw e;
	          
	       }
	       return;
	       

		
	}

	@Override
	public boolean updateProjectList(ProjectList projectList, ProjectList projectListcurrent) {
		boolean transactionsaved=false;
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    		String sql="update projectlist set projectname=?,projectdescription=? where id=? ";
	    		jdbcTemplate.update(sql, new Object[]{projectList.getProjectName(), projectList.getProjectDescrition(), projectList.getId()});
	    		
	    		String sql2="update people set projectname=? where projectname=? ";
	    		jdbcTemplate.update(sql2, new Object[]{projectList.getProjectName(), projectListcurrent.getProjectName()});
	    			    		    	  
	    	     
	    		transactionManager.commit(status);
	    		transactionsaved=true;
	    	  
	      } catch (DataAccessException e) {
	    	  
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          transactionsaved=false;
	          throw e;
	          
	    	  
	       }
	       return transactionsaved;
	       
		
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
		
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    		String sql="select projectlist.id, projectlist.projectname,projectlist.projectdescription, array_to_string(array_agg(distinct people.completename),',') as completename from "

	    				+" projectlist inner join people on projectlist.projectname=people.projectname where projectlist.status='t' group by projectlist.id, projectlist.projectname,projectlist.projectdescription  UNION ALL select projectlist.id,projectname,projectdescription,completename from projectlist where linkedcount=0 and status='t'";
	    		
	    			    		    	  
	    		projectList=jdbcTemplate.query(sql, new ProjectListRowMapper());

	    	
	    		transactionManager.commit(status);
	    	
	    	  
	      } catch (DataAccessException e) {
	    	 
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          throw e;
	          
	       }
	       return projectList;
	       
/*		String sql="select projectlist.id, projectlist.projectname,projectlist.projectdescription, array_to_string(array_agg(distinct people.completename),',') as completename from"  

				+" projectlist inner join people on projectlist.projectname=people.projectname group by projectlist.id, projectlist.projectname,projectlist.projectdescription UNION ALL " 

+" select projectlist.id,projectname,projectdescription,completename from projectlist where linkedcount=0";	
		projectList=jdbcTemplate.query(sql, new ProjectListRowMapper());

		return projectList;*/
	}

	@Override
	public ProjectList getProjectList(int id) {
		ProjectList projectList;
		
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    	  String sql="select * from projectlist where id=?";
	  		projectList=(ProjectList) jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProjectListAllRowMapper() ); 
	    	     
	    		transactionManager.commit(status);
	    	
	    	  
	      } catch (DataAccessException e) {
	    	 
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          throw e;
	          
	       }
		/*String sql="select * from projectlist where id=?";
		projectList=(ProjectList) jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProjectListAllRowMapper() );
		*/return projectList;
	}
	@Override
	public boolean deactivateProjectList(ProjectList projectList) {
		boolean transactionsaved=false;
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try{
	    		String sql="update projectlist set status='f' where id=?";
	    		jdbcTemplate.update(sql, new Object[]{ projectList.getId()});
	    			    		    	  
	    	     
	    		transactionManager.commit(status);
	    		transactionsaved=true;
	    	  
	      } catch (DataAccessException e) {
	    	  
	          System.out.println("Error in creating record, rolling back");
	          transactionManager.rollback(status);
	          transactionsaved=false;
	          throw e;
	          
	    	  
	       }
	       return transactionsaved;
	       
	}

}
