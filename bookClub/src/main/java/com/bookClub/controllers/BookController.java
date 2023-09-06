package com.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookClub.models.Book;
import com.bookClub.models.User;
import com.bookClub.services.BookService;
import com.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

		@Autowired
		private BookService bookService;
		
		@Autowired
		private UserService userService;
		
		@GetMapping("/book/{id}")
		public String bookDetails(@PathVariable Long id, Model model, HttpSession session) {
		    Book book = bookService.findBookById(id);
		    model.addAttribute("book", book);
		    User loggedInUser = (User) session.getAttribute("user");
		    model.addAttribute("user", loggedInUser);
		    return "bookDetails.jsp";
		}
		
		@GetMapping("/addBook")
		public String addNewBook(Model model, HttpSession session) {
		    model.addAttribute("newBook", new Book());
		    User loggedInUser = (User) session.getAttribute("user");
		    model.addAttribute("user", loggedInUser);
		    return "addBook.jsp";
		}
		
		@GetMapping("/edit/{id}")
		public String editBook(@PathVariable Long id, Model model, HttpSession session) {
			Book book = bookService.findBookById(id);
		    model.addAttribute("updatedBook", book);
		    User loggedInUser = (User) session.getAttribute("user");
		    model.addAttribute("user", loggedInUser);
		    return "editBook.jsp";
		}

		
		@PostMapping("/addBook")
		public String addBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, Model model, HttpSession session) {
			User loggedInUser = (User) session.getAttribute("user");
			if (loggedInUser == null) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				  model.addAttribute("newBook", newBook);
				  return "addBook.jsp";
				}
			newBook.setPostedBy(loggedInUser);
			bookService.addBook(newBook, result);
			return "redirect:/dashboard";
		}
		
		@PatchMapping("/editBook")
		public String editBook(@Valid @ModelAttribute("updatedBook") Book updatedBook, BindingResult result, Model model, HttpSession session) {
		    User loggedInUser = (User) session.getAttribute("user");
		    if (loggedInUser == null) {
		        return "redirect:/";
		    }

		    Book originalBook = bookService.findBookById(updatedBook.getId());
		    
		    if (result.hasErrors()) {
		        updatedBook.setId(originalBook.getId());
		        model.addAttribute("updatedBook", updatedBook);
		        return "editBook.jsp";
		    }

		    if (originalBook.getPostedBy().getId().equals(loggedInUser.getId())) {
		        if (updatedBook.getTitle() != null) {
		            originalBook.setTitle(updatedBook.getTitle());
		        }
		        if (updatedBook.getAuthor() != null) {
		            originalBook.setAuthor(updatedBook.getAuthor());
		        }
		        if (updatedBook.getThoughts() != null) {
		            originalBook.setThoughts(updatedBook.getThoughts());
		        }
		        
		        bookService.updateBook(originalBook);
		        return "redirect:/dashboard";
		    } else {
		        return "redirect:/dashboard";
		    }
		}


		
		@DeleteMapping("/delete/{id}")
		public String deleteBook(Model model, @PathVariable Long id ) {
			bookService.deleteBook(id);
			return "redirect:/dashboard";
		}

}
