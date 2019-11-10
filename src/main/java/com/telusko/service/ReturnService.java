package com.telusko.service;

import java.util.List;

import com.telusko.model.Return;

public interface ReturnService {

	public void addReturn(Return return2);
	public void deleteBid(int isbn);
	public List<Return> findAllRefID(int mID);
	public Return findbyisbn(int isbn);
}
