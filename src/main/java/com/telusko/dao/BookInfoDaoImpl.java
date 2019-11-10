package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import com.telusko.model.BookInfo;
import com.telusko.model.Member;

@Repository
public class BookInfoDaoImpl implements BookInfoDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }
	  private SqlParameterSource getSqlParameterByModel(BookInfo  bookinfo)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(bookinfo!= null)
		   {
			   paramSource.addValue("title", bookinfo.getTitle());
			   paramSource.addValue("Author", bookinfo.getAuthor());
			   paramSource.addValue("Category", bookinfo.getCategory());
			   paramSource.addValue("price", bookinfo.getPrice());
			   paramSource.addValue("copies", bookinfo.getCopies());
			   
			
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class BookInfoMapper implements RowMapper<BookInfo>
	   {
		   public BookInfo mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   BookInfo bookinfo=new BookInfo();
			   bookinfo.setTitle(rs.getString("title"));
			   bookinfo.setAuthor(rs.getString("Author"));
			   bookinfo.setCategory(rs.getString("Category"));
			   bookinfo.setPrice(rs.getInt("price"));
			   bookinfo.setCopies(rs.getInt("copies"));
			   return bookinfo;
			   
		   }
	   }
	   public void addupdateBookInfo(BookInfo bookinfo)
	   {
		   String UPDATE_QUERY="UPDATE BookInfo SET copies=copies+1 WHERE title=:title ";
		   String INSERT_QUERY="INSERT INTO BookInfo(title,Category,Author,price) values(:title,:Category,:Author,:price)";
		    String title=bookinfo.getTitle();
		  
		    SqlParameterSource namedParameters = new MapSqlParameterSource("title", title);
		    int status = namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);
		   
	        if(status != 0){
	            System.out.println("Employee data updated for title " + bookinfo.getTitle());
	            
	        }else{
	            System.out.println("No Employee found with title " + bookinfo.getTitle());
	            Map<String, Object> paramMap = new HashMap<String, Object>();
	            paramMap.put("title", bookinfo.getTitle());
	            paramMap.put("Author", bookinfo.getAuthor());
	          
	            paramMap.put("Category", bookinfo.getCategory());
	            paramMap.put("price", bookinfo.getPrice());
	            // Passing map containing named params
	            namedParameterJdbcTemplate.update(INSERT_QUERY, paramMap); 
	          
	        }
		 }
	   @Override
	   public BookInfo findBookInfoById(String title)
	   {
		   String sql="SELECT * FROM BookInfo WHERE title=:title";
			return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new BookInfo(title)),new BookInfoMapper() );
		   
	   }
	   @Override
	   public void updateCopies(String title)
	   {
		
		   String UPDATE_QUERY="UPDATE BookInfo SET copies=copies-1 WHERE title=:title ";
		   
		    SqlParameterSource namedParameters = new MapSqlParameterSource("title", title);
		    
		    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);
		   
	   }
	   @Override
	   public void updateincCopies(String title)
	   {
		
		   String UPDATE_QUERY="UPDATE BookInfo SET copies=copies+1 WHERE title=:title ";
		   
		    SqlParameterSource namedParameters = new MapSqlParameterSource("title", title);
		    
		    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);
		   
	   }
	   
	@Override
	public List<BookInfo> findAllBookInfo() {
		String sql="Select * from BookInfo";
		
		return namedParameterJdbcTemplate.query(sql,new BookInfoMapper());
	}
}
