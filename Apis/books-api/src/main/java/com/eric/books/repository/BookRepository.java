package com.eric.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.books.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	public Book findById(long id);
	public List<Book> findAllByOrderByIdAsc();
	
}