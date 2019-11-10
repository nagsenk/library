package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.UserDao;
import com.telusko.model.Return;
import com.telusko.dao.ReturnDao;
@Service
@Component
public class ReturnServiceImpl implements ReturnService{
	
	ReturnDao returnDao;
	
	
	@Autowired
	public void setReturndao(ReturnDao returndao) {
		this.returnDao = returndao;
	}
	@Override
    public void addReturn(Return return2)
    {
		returnDao.addReturn(return2);
    }

	@Override
    public void deleteBid(int isbn)
    {
		returnDao.deleteBid(isbn);
    }
    @Override
    public List<Return> findAllRefID(int mID)
    {
      return	returnDao.findAllRefID(mID);
    }
	@Override
	public Return findbyisbn(int isbn)
	{
		return returnDao.findbyisbn(isbn);
	}
}
