package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books")
	public String allBooks(Model model)
	{
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	@RequestMapping("/books/{bookId}")
	public String singleBook(@PathVariable("bookId") Long bookId, Model model)
	{
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}
