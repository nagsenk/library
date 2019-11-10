package com.telusko.dao;

import java.util.List;

import com.telusko.model.Reserve;

public interface ReserveDao {
	public void addReserve(Reserve reserve);
	public List <Reserve> findreservebymid(int mid);
	public void del(Reserve reserve );
}
