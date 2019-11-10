package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import com.telusko.model.Authenticate;

@Repository
public class AuthenticateDaoImpl implements AuthenticateDao{
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}

private SqlParameterSource getSqlParameterByModel(Authenticate authenticate)
{
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(authenticate!= null)
	   {
		   paramSource.addValue("username", authenticate.getUsername());
		   paramSource.addValue("password", authenticate.getPassword());
		   paramSource.addValue("role", authenticate.getRole());
		   
		   
	   }
	   
	   
	   return paramSource;
}
private static final class AuthenticateMapper implements RowMapper<Authenticate>
{
	   public Authenticate mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Authenticate authenticate=new Authenticate();
		   authenticate.setUsername(rs.getString("username"));
		   authenticate.setPassword(rs.getString("password"));
		   authenticate.setRole(rs.getString("role"));
		   
		   return authenticate;
		   
	   }
}
	@Override
	public void addAuthenticate(Authenticate authenticate) {
		// TODO Auto-generated method stub
		String role=authenticate.getRole();
		String sql="INSERT INTO authentication(username,password,role)  values (:username,:password,:role)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(authenticate));
	}
	@Override
	public int check(Authenticate authenticate)
	{
		
		String username=authenticate.getUsername();
		String real=authenticate.getPassword();
		String dummy;
		System.out.println(real);
		
		
		String SELECT_BY_Username_QUERY="select * from  authentication where username=:username";
		dummy=namedParameterJdbcTemplate.queryForObject(SELECT_BY_Username_QUERY, new MapSqlParameterSource(
		           "username", username), new AuthenticateMapper()).getPassword();
		System.out.println(real);
		if(dummy.equals(real))
			
			return 1;
		else
			
			return 0;
		}
	@Override
	public Authenticate getpsd(String username)
	{
		Authenticate authenticate=new Authenticate();
		String SELECT_BY_Username_QUERY="select * from  authentication where username=:username";
		authenticate=namedParameterJdbcTemplate.queryForObject(SELECT_BY_Username_QUERY, new MapSqlParameterSource(
		           "username", username), new AuthenticateMapper());
		return authenticate;
	}
	@Override
	 public void deleteByUsername(String username)
	 {
		String sql="DELETE FROM authentication WHERE username=:username";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Authenticate(username)));
	 }
}
