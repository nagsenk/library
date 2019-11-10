package com.telusko.service;

import java.util.List;

import com.telusko.model.Book;
//import com.telusko.model.Member;


public interface BookService {

	public void addBook(Book book);
	public List<Book> listAllBooks();
	public Book findBookById(int id);
	public void deleteBook(int id);
	public void setavailability(int bid);
	public void resetavailability(int bid);
}
