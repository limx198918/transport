package com.sto.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sto.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book,String> {

}
