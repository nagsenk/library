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
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Member;
import com.telusko.model.Reserve;
import com.telusko.model.Return;
@Repository
public class ReserveDaoImpl implements ReserveDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }
	  private SqlParameterSource getSqlParameterByModel(Reserve reserve)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(reserve!= null)
		   {
			   paramSource.addValue("MID", reserve.getMID());
			   paramSource.addValue("title", reserve.getTitle());
			   paramSource.addValue("reservedate", reserve.getReservedate());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class ReserveMapper implements RowMapper<Reserve>
	   {
		   public Reserve mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Reserve reserve=new Reserve();
			   reserve.setMID(rs.getInt("MID"));
			   reserve.setTitle(rs.getString("title"));
			   reserve.setReservedate(rs.getDate("reservedate"));
			  
			   return reserve;
			   
		   }
	   }
		@Override
		public void addReserve(Reserve reserve) {
			// TODO Auto-generated method stub
			
				 String sql="INSERT INTO Reserve values (:MID,:title,:reservedate)";
					namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(reserve));
			    
		}
		@Override
		public List <Reserve> findreservebymid(int MID)
		{
			System.out.println("in DAO");
			System.out.println(MID);
			
			String sql="SELECT * FROM Reserve WHERE MID=:MID";
			return	namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Reserve(MID)),new ReserveMapper() );
			
		}
		@Override
		public void del(Reserve reserve)
		{
			int MID=reserve.getMID();
			String title=reserve.getTitle();
			String sql="DELETE FROM Reserve WHERE MID=:MID AND title=:title ";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Reserve(MID,title)));
		}
		
}
