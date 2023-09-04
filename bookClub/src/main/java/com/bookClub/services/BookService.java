package com.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookClub.models.Book;
import com.bookClub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public Book addBook(Book newBook, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		return bookRepo.save(newBook);
	}
	
	public List<Book> allBooks(){
        return bookRepo.findAll();
    }
	
	public Book findBookById(Long id) {
	    Optional<Book> optionalBook = bookRepo.findById(id);
	    if (optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        return null;
	    }
	}
	public Book updateBook(Book updatedBook) {
		Optional<Book> optionalBook = bookRepo.findById(updatedBook.getId());
		if (optionalBook.isPresent()) {
			Book bookToBeUpdated = optionalBook.get();
			bookToBeUpdated.setTitle(updatedBook.getTitle());
			bookToBeUpdated.setAuthor(updatedBook.getAuthor());
			bookToBeUpdated.setThoughts(updatedBook.getThoughts());
			return bookRepo.save(bookToBeUpdated);
		}
		return null;
	}

	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
