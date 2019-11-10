package com.telusko.service;

import java.util.List;

import com.telusko.model.BookInfo;
import com.telusko.model.Member;

public interface BookInfoService {
	public void addupdateBookInfo(BookInfo bookinfo);
	public BookInfo findBookInfoById(String title);
	public void updateCopies(String title);
	public List<BookInfo> findAllBookInfo();
	  public void updateincCopies(String title);
	  
}
