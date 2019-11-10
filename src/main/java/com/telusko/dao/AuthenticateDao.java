package com.telusko.dao;

import com.telusko.model.Authenticate;

public interface AuthenticateDao {
	public void addAuthenticate(Authenticate authenticate);
	public int  check(Authenticate authenticate);
	public Authenticate getpsd(String username);
	 public void deleteByUsername(String username);
}
