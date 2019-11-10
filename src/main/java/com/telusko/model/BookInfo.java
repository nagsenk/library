package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BookInfo")
public class BookInfo {
	private String title;
	private String Author;
	private String Category;
	private Integer copies;
	public BookInfo() {
		super();
	}
	public BookInfo (String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		this.Category = category;
	}
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	private Integer price;
	
	

}
