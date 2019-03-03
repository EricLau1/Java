package com.eric.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.books.models.Book;
import com.eric.books.repository.BookRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class BookController  {
	
	@Autowired
	private BookRepository bookRepository;	
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookRepository.findAllByOrderByIdAsc();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable(value="id") long id) {
		return this.bookRepository.findById(id);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> postBook(@RequestBody Book book) {
		book = this.bookRepository.save(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@PutMapping("books/{id}")
	public Book putBook(@PathVariable(value="id") long id, @RequestBody Book book) {
		book.setId(id);
		return this.bookRepository.save(book);
	}
	
	@DeleteMapping("books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value="id") long id) {
		this.bookRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
