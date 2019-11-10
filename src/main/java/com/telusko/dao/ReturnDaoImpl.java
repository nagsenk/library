package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.telusko.model.Book;
import com.telusko.model.Member;
import com.telusko.model.Return;
//import com.telusko.model.User;
@Repository
public class ReturnDaoImpl implements ReturnDao{
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		private SqlParameterSource getSqlParameterByModel(Return return2)
		   {
			   MapSqlParameterSource paramSource =new MapSqlParameterSource();
			   if(return2!= null)
			   {
				   paramSource.addValue("mID", return2.getmID());
				   paramSource.addValue("isbn", return2.getIsbn());
				   paramSource.addValue("returndate", return2.getReturndate());
				   
			   }
			   
			   
			   return paramSource;
		   }
		   private static final class ReturnMapper implements RowMapper<Return>
		   {
			   public Return mapRow(ResultSet rs,int rowNum) throws SQLException
			   {
				   Return return2=new Return();
				   return2.setmID(rs.getInt("mID"));
				   return2.setIsbn(rs.getInt("isbn"));
				   return2.setReturndate(rs.getDate("returndate"));
				  
				   return return2;
				   
			   }
		   }
			@Override
			public void addReturn(Return return2) {
				// TODO Auto-generated method stub
				String sql="INSERT INTO Returninfo values (:mID,:isbn,:returndate)";
				namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(return2));
			}
			@Override
			public void deleteBid(int isbn)
			{
				String sql="DELETE FROM Returninfo WHERE isbn=:isbn";
				namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Return(isbn)));
				
			}
			@Override
			public List<Return> findAllRefID(int mID)
			{
				String sql="SELECT * From Returninfo ";
				return namedParameterJdbcTemplate.query(sql,getSqlParameterByModel(null), new ReturnMapper() );
			}
			@Override
			public Return findbyisbn(int isbn)
			{
				String sql="SELECT * FROM Returninfo WHERE isbn=:isbn";
				return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Return(isbn)),new ReturnMapper() );
			}
}
