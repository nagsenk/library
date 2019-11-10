package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.IssueDao;
import com.telusko.model.Issue;
@Service
@Component
public class IssueServiceImpl implements IssueService{

	
	
	IssueDao issueDao;
	@Autowired
	public void setMemberdao(IssueDao issuedao) {
		this.issueDao = issuedao;
	}

	@Override 
	public void addIssue(Issue issue)
	{
		
		issueDao.addIssue(issue);
		
	}
}
