package com.sto.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sto.dao.BookRepository;
import com.sto.model.Book;
import com.sto.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

	@Override
	public List<Book> findByAll() {
		List<Book> arrayBook = new ArrayList<Book>();
		Iterator<Book> iterator = bookRepository.findAll().iterator();
		while (iterator.hasNext()) {
			Book type = (Book) iterator.next();
			arrayBook.add(type);
		}	
		return arrayBook;
	}

	@Override
	public Book findById(String id) {
		Optional<Book> optBook = bookRepository.findById(id);
		Book book = optBook.get();
		return book;
	}

	@Override
	public int save(Book book) {
		bookRepository.save(book);
		return 1;
	}

	@Override
	public String delete(Book book) {
		bookRepository.delete(book);
		return book.getId();
	}

	@Override
	public List<Book> findByTitle(String title) {
		BoolQueryBuilder builder = QueryBuilders.boolQuery();
		
		//范围
		//RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("id").from("1").to("1");
		//builder.must(rangeQuery);
		
		//精确
		//MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", title);
		//builder.must(matchQuery);
		
		//模糊
		WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("title", "*"+title+"*");
		builder.must(wildcardQueryBuilder);
		
		//设置查询
		
		List<Book> arrayBook = new ArrayList<Book>();
		Iterator<Book> iterator = bookRepository.search(builder).iterator();
		while (iterator.hasNext()) {
			Book type = (Book) iterator.next();
			arrayBook.add(type);
		}	
		return arrayBook;
	}
}
