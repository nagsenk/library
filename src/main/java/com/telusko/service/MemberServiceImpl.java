package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.MemberDao;
import com.telusko.model.Member;

@Service
@Component
public class MemberServiceImpl implements MemberService{

	
	
	MemberDao memberDao;
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberDao = memberdao;
	}

	@Override
	public List<Member> listAllMembers() {
		return memberDao.listAllMembers();
	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		memberDao.addMember(member);
		
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		memberDao.updateMember(member);
	}

	@Override
	public void deleteMember(int id) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(id);
		
	}

	@Override
	public Member findMemberById(int id) {
		// TODO Auto-generated method stub
		return memberDao.findMemberById(id);
	}
	@Override
	public void updateCount(int memid)
	{
		 memberDao.updateCount(memid);
	}

	@Override
	public List<Member> listTopThree() {
		return memberDao.listTopThree();
	}
	@Override
	public Member findByUsername(String username)
	{
		return memberDao.findByUsername(username);
	}

	
}
