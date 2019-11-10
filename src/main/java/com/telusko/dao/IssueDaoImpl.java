package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.telusko.model.Issue;

@Repository
public class IssueDaoImpl implements IssueDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }
	
	  private SqlParameterSource getSqlParameterByModel(Issue issue)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(issue!= null)
		   {
			   paramSource.addValue("MemId", issue.getMemId());
			   paramSource.addValue("isbn", issue.getIsbn());
			   paramSource.addValue("issuedate", issue.getIssuedate());
			 
			   
			
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class IssueMapper implements RowMapper<Issue>
	   {
		   public Issue mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Issue issue=new Issue();
			   issue.setMemId(rs.getInt("Memid"));
			   issue.setIsbn(rs.getInt("isbn"));
			   issue.setIssuedate(rs.getDate("issuedate"));
			  
			   return issue;
			   
		   }
	   }
		@Override
		public void addIssue(Issue issue) {
			
			String sql="INSERT INTO Issue  values (:MemId,:isbn,:issuedate)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(issue));
		}

	
}
