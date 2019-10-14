package com.sto.service;

import java.util.List;

import com.sto.model.Book;

public interface BookService {

	List<Book> findByAll();

	Book findById(String id);

	int save(Book book);

	String delete(Book book);
	
	List<Book> findByTitle(String title);

}
