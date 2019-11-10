package com.telusko.dao;

import java.util.List;

import com.telusko.model.Member;

public interface MemberDao {
public List<Member> listAllMembers();
	
	public void addMember(Member member);
	
	public void updateMember(Member member); 
	
	public void deleteMember(int id);
	
	public Member findMemberById(int id);
	public void updateCount(int mid);
	public List<Member> listTopThree();
	public Member findByUsername(String username);
}
