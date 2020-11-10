package com.capgemini.lms.demo.controller;


import org.slf4j.LoggerFactory;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.capgemini.lms.demo.dtos.Books;
import com.capgemini.lms.demo.service.BookService;


//connect from swagger as http://localhost:2020/books/
@Controller
@RequestMapping("/books")
class BookController{

	Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Books> getAllBooks() 
{ 
	
	List<Books> books = bookService.getAllBooks();
	return books;
}

@GetMapping("/{id}")
public @ResponseBody  Books getBookById(@PathVariable Long id) 
{
	
	return bookService.getBookById(id);
}
/*@GetMapping("/{subject}")
public @ResponseBody  List<Books> getBookBySubject(@PathVariable String subject)
{
	return bookService.searchBooksBySubject(subject);
}*/



@PostMapping("/")
public @ResponseBody Books addBook(@RequestBody Books book) 
{
	return bookService.addBook(book);
}
@PutMapping("/{id}")
public @ResponseBody Books updateBook(@PathVariable Long id,@RequestBody Books book) 
{
	return bookService.updateBook(id,book);
}
@DeleteMapping("/{id}")
public @ResponseBody String removeBook(@PathVariable Long id) 
{
	return bookService.removeBook(id);
}
}
