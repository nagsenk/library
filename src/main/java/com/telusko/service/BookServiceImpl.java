package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.BookDao;
import com.telusko.dao.MemberDao;
import com.telusko.model.Book;
import com.telusko.model.BookInfo;


@Service
@Component
public class BookServiceImpl implements BookService {
	
	
	BookDao bookDao;
	@Autowired
	public void setBookdao(BookDao bookdao) {
		this.bookDao = bookdao;
	}
@Override
public void addBook(Book book)
{
	bookDao.addBook(book);
}
@Override
public List<Book> listAllBooks()
{
	return bookDao.listAllBooks();
}
@Override
public Book findBookById(int id )
{
	return bookDao.findBookById(id);
}
@Override
public void deleteBook(int id)
{
	bookDao.deleteBook(id);
}
@Override
public void setavailability(int bid)
{
	bookDao.setavailability(bid);
}
@Override
public void resetavailability(int bid)
{
	bookDao.resetavailability(bid);
}
}
