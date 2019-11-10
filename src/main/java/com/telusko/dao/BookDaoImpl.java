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
@Repository
public class BookDaoImpl implements BookDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }
	  private SqlParameterSource getSqlParameterByModel(Book book)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(book!= null)
		   {
			   paramSource.addValue("bid", book.getBid());
			   paramSource.addValue("title",book.getTitle());
			   paramSource.addValue("availability",book.getAvailability());
			  
			   
			
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class BookMapper implements RowMapper<Book>
	   {
		   public Book mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Book book=new Book();
			   book.setBid(rs.getInt("bid"));
			   book.setTitle(rs.getString("title"));
			   book.setAvailability(rs.getString("availability"));
			  
			   return book;
			   
		   }
	   }
		@Override
		public void addBook(Book book) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO Books (title) values (:title)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(book));
		}
		@Override
		public List<Book> listAllBooks() {
			 String sql = "SELECT * FROM Books";
			  
			  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new BookMapper());
			  
			  return list;
		}
		@Override
		public Book findBookById(int bid)
		{
			String sql="SELECT * FROM Books WHERE bid=:bid";
			return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Book(bid)),new BookMapper() );
		}
		@Override
		public void deleteBook(int bid)
		{
			String sql="DELETE FROM Books WHERE bid=:bid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Book(bid)));
			
		}
        @Override
        public void setavailability(int bid)
        {
        	String sql="UPDATE Books set availability='available' where bid=:bid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Book(bid)));
        }
        @Override
        public void resetavailability(int bid)
        {
        	String sql="UPDATE Books set availability='unavailable' where bid=:bid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Book(bid)));
        }
}
