package com.javatrainingschool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatrainingschool.entity.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public List<Book> findByName(String name);

}