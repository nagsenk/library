package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.telusko.model.Employee;
import com.telusko.model.Member;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }

		 public List listAllEmployee() {
			  String sql = "SELECT * FROM Employee";
			  
			  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new  EmployeeMapper());
			  
			  return list;
			 }
	   private SqlParameterSource getSqlParameterByModel( Employee  employee)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if( employee!= null)
		   {
			   paramSource.addValue("empid",  employee.getEmpid());
			   paramSource.addValue("firstname", employee.getFirstname());
			   paramSource.addValue("lastname",  employee.getLastname());
			   paramSource.addValue("address",  employee.getAddress());
			   paramSource.addValue("usname",  employee.getUsname());
			   paramSource.addValue("joindate",  employee.getJoindate());
			   
			
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class  EmployeeMapper implements RowMapper< Employee>
	   {
		   public  Employee mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Employee employee=new Employee();
			   employee.setEmpid(rs.getInt("empid"));
			   employee.setFirstname(rs.getString("firstname"));
			   employee.setLastname(rs.getString("lastname"));
			   employee.setAddress(rs.getString("address"));
			   employee.setUsname(rs.getString("usname"));
			   employee.setJoindate(rs.getDate("joindate"));			   
			   return employee;
			   
		   }
	   }
		@Override
		public void addEmployee( Employee employee) {
			// TODO Auto-generated method stub
			try {
				String sql="INSERT INTO Employee (firstname,lastname,usname,address,joindate) values (:firstname,:lastname,:usname,:address,:joindate)";
				namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(employee));
			} catch (DuplicateKeyException e) {

			        System.out.println("handle other error code here!");
			    }
			
		
		}

		@Override
		public void updateEmployee( Employee  employee) {
			// TODO Auto-generated method stub
			String sql="UPDATE Employee set firstname= :firstname,lastname=:lastname where empid=:empid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(employee));
			 
		}

		@Override
		public void deleteEmployee(int empid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM Employee WHERE empid=:empid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Employee(empid)));
			
		}

		@Override
		public Employee findEmployeeById(int empid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM Employee WHERE empid=:empid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Employee(empid)),new EmployeeMapper() );
			
		}

}
