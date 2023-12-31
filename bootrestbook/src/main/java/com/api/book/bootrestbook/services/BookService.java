package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
//	public static List<Book> list = new ArrayList<>();
	
//	static {
//		list.add(new Book(12, "Java", "JK rolling"));
//		list.add(new Book(32, "DotNet", "XYZ"));
//		list.add(new Book(4245, "python programming", "ABC"));
//	}
	
	//getting all books
	public List<Book> getAllBooks() {
		List<Book> findAll = (List<Book>) bookRepository.findAll();
		
//		return list;
		return findAll;
	}
	
	//getting a single book
	public Book getBookbyId(int id) {
		Book book=null;
		try {
//			book = list.stream().filter(item -> item.getId() == id).findFirst().get();
			book = bookRepository.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
		
	}
	
	//create/addIng book
	public Book addBook(Book book) {
//		 list.add(book);	
		Book save = bookRepository.save(book);
		 
		return save;
	}
	
	//deleting a book
	public void deleteBook(int id) {
//		list = list.stream().filter(item -> item.getId() != id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}
	
	//updating a book
	public void updateBook(Book book, int id) {
//		list = list.stream().map(item -> {
//					if(item.getId() == id) {
//						item.setTitle(book.getTitle());
//						item.setAuthor(book.getAuthor());
//					}
//					return item;
//				}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);
	}

}
