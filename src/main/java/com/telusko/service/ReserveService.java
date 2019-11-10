package com.telusko.service;

import java.util.List;

import com.telusko.model.Reserve;

public interface ReserveService {
	public void addReserve(Reserve reserve);
	public List<Reserve> findreservebymid(int id);
	public void del(Reserve reserve );
}
