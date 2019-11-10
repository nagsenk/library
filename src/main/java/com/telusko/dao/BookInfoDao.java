package com.telusko.dao;

import java.util.List;

import com.telusko.model.BookInfo;


public interface BookInfoDao {
	public void addupdateBookInfo(BookInfo bookinfo);
	public BookInfo findBookInfoById(String title);
	public void updateCopies(String title);
	public List<BookInfo> findAllBookInfo();
	  public void updateincCopies(String title);
}
