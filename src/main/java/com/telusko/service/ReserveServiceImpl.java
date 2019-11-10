package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.telusko.dao.ReserveDao;
import com.telusko.dao.ReturnDao;
import com.telusko.model.Reserve;
import com.telusko.model.Return;
@Service
@Component
public class ReserveServiceImpl implements ReserveService{
	
		ReserveDao reserveDao;
		@Autowired
		public void setReservedao(ReserveDao reservedao) {
			this.reserveDao = reservedao;
		}
		@Override
	    public void addReserve(Reserve reserve)
	    {
			reserveDao.addReserve(reserve);
	    }
		@Override
		public List<Reserve> findreservebymid(int mid)
		{
			return reserveDao.findreservebymid(mid);
		}
		@Override
		public void del(Reserve reserve)
		{
			reserveDao.del(reserve);
		}

	

}
