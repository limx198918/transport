package com.sto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sto.model.Book;
import com.sto.service.BookService;

@RestController
public class ElasticController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/findByAll")
	public List<Book> findByAll() {
		return bookService.findByAll();
	}
	
	@RequestMapping("/findById")
	public Book findById(@RequestParam(name="id") String id) {
		return bookService.findById(id);
	}

	@RequestMapping("/save")
	public int save(Book book) {
		return bookService.save(book);
	}
	
	@RequestMapping("/delete")
	public String delete(Book book) {
		return bookService.delete(book);
	}
	
	@RequestMapping("/findByTitle")
	public List<Book> findByTitle(@RequestParam(name="title") String title) {
		return bookService.findByTitle(title);
	}
}
