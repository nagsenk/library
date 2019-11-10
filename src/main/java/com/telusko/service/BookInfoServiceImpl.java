package com.telusko.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.BookDao;
import com.telusko.dao.BookInfoDao;
import com.telusko.model.Book;
import com.telusko.model.BookInfo;
@Service
@Component
public class BookInfoServiceImpl implements BookInfoService{
	BookInfoDao bookinfoDao;
	@Autowired
	public void setBookInfodao(BookInfoDao bookinfodao) {
		this.bookinfoDao = bookinfodao;
	}
@Override
public void addupdateBookInfo(BookInfo bookinfo)
{
	
	bookinfoDao.addupdateBookInfo(bookinfo);
}
@Override
public BookInfo findBookInfoById(String title)
{
	return bookinfoDao.findBookInfoById(title);
}
@Override
public void updateCopies(String title)
{
	 bookinfoDao.updateCopies(title);
}
@Override
public List<BookInfo> findAllBookInfo()
{
return	bookinfoDao.findAllBookInfo();
}
@Override
public void updateincCopies(String title)
{
	bookinfoDao.updateincCopies( title);
	
}


}
