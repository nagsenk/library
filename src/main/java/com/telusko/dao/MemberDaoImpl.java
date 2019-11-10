package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.telusko.model.Member;
@Repository
public class MemberDaoImpl implements  MemberDao{
	  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	  @Autowired
	  public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	  {
	  	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	  }

	  public List listAllMembers() 
	  {
			  String sql = "SELECT memid, firstname, lastname, address,memusername FROM members";
			  
			  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MemberMapper());
			  
			  return list;
	  }
	   private SqlParameterSource getSqlParameterByModel(Member member)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(member!= null)
		   {
			   paramSource.addValue("memid", member.getId());
			   paramSource.addValue("firstname", member.getFirstname());
			   paramSource.addValue("lastname", member.getLastname());
			   paramSource.addValue("address", member.getAddress());
			   paramSource.addValue("memusername", member.getMemusername());
			   
			
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class MemberMapper implements RowMapper<Member>
	   {
		   public Member mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Member member=new Member();
			   member.setId(rs.getInt("memid"));
			   member.setFirstname(rs.getString("firstname"));
			   member.setLastname(rs.getString("lastname"));
			   member.setAddress(rs.getString("address"));
			   member.setMemusername(rs.getString("memusername"));
			   return member;
			   
		   }
	   }
		@Override
		public void addMember(Member member) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO members (firstname,lastname,address,memusername) values (:firstname,:lastname,:address,:memusername)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(member));
		}

		@Override
		public void updateMember(Member member) {
			// TODO Auto-generated method stub
			String sql="UPDATE members set firstname= :firstname,lastname=:lastname,address=:address where memid=:id";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(member));
			 
		}

		@Override
		public void deleteMember(int memid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM members WHERE memid=:memid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Member(memid)));
			
		}

		@Override
		public Member findMemberById(int memid) {
		
			System.out.println("id is");
			System.out.println(memid);
			String sql="SELECT * FROM members WHERE memid=:memid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Member(memid)),new MemberMapper() );
			
		}
		@Override 
		public void updateCount(int memid)
		{
			String sql="Update members set count=count+1 where memid=:memid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Member(memid)));
		}
		@Override
		public List listTopThree() {
			  String sql = "SELECT memid,firstname,lastname,address,memusername FROM members order by count desc limit 3";
			  
			  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MemberMapper());
			  
			  return list;
		}
		@Override
		public Member findByUsername(String memusername){
			// TODO Auto-generated method stub
			String sql="SELECT * FROM members WHERE memusername=:memusername";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Member(memusername)),new MemberMapper() );
			
		}

		
}
