package com.telusko.service;

import java.util.List;

import com.telusko.model.Member;

public interface MemberService {
public List<Member> listAllMembers();
	
	public void addMember(Member member);
	
	public void updateMember(Member member); 
	
	public void deleteMember(int id);
	
	public Member findMemberById(int id);
	public void updateCount(int memid);
	public List<Member> listTopThree();
	public Member findByUsername(String username);

}
