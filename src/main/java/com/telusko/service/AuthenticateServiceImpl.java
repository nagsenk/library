package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.AuthenticateDao;
import com.telusko.model.Authenticate;

@Service
@Component
public class AuthenticateServiceImpl implements  AuthenticateService{
	AuthenticateDao authenticateDao;
	@Autowired
	public void setAuthenticatedao(AuthenticateDao authenticatedao) {
		this.authenticateDao = authenticatedao;
	}
	@Override
	public void addAuthenticate(Authenticate authenticate) {
		// TODO Auto-generated method stub
		authenticateDao.addAuthenticate(authenticate);
		
	}
	@Override
	public int check(Authenticate authenticate) {
		return (authenticateDao.check(authenticate));
		
	}
	@Override
	public Authenticate getpsd(String username)
	{
		return (authenticateDao.getpsd(username));
	}
    @Override
    public void deleteByUsername(String username)
    {
    	authenticateDao.deleteByUsername(username);
    }
}



