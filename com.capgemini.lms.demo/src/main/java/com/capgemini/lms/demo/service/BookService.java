package com.capgemini.lms.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.demo.dao.BookDao;
import com.capgemini.lms.demo.dtos.Books;
@Service
public class BookService 
{
	@Autowired
	private BookDao library;

	public List<Books> getAllBooks() {
		System.out.println("Books...");
		return library.findAll();
	}

	public Books getBookById(Long id) {
		System.out.println("Book");
		return library.findById(id).get();
	}

	public Books addBook(Books book) {
		System.out.println("Book added.");
		return library.save(book);

	}

	public Books updateBook(Long id, Books book) {
		System.out.println("Book updated.");

		Optional<Books> repBook = library.findById(id);

		if (repBook.isPresent()) {

			Books bookToBeUpdated = repBook.get();
			bookToBeUpdated.setTitle(book.getTitle());
			bookToBeUpdated.setSubject(book.getSubject());
			bookToBeUpdated.setAuthor(book.getAuthor());
			bookToBeUpdated.setPublisher(book.getPublisher());
			bookToBeUpdated.setPublishedYear(book.getPublishedYear());
			bookToBeUpdated.setIsbn_code(book.getIsbn_code());
			bookToBeUpdated.setQuantity(book.getQuantity());
			bookToBeUpdated.setShelf_details(book.getShelf_details());
			
			return library.save(bookToBeUpdated);

		}

		return null;
}
        public String removeBook(Long bookId)
        {
		System.out.println("Book removed.");

		library.deleteById(bookId);
		return "Book deleted Sucessfully";
	    }
       /* public List<Books> searchBooksBySubject(String keyword)
        {
        	List<Books> books=new ArrayList<Books>();
    		library.findAll().forEach(book1->books.add(book1));
    		List<Books> subjectBasedBooks=new ArrayList<Books>();
    		for(Books m:books)
    		{
    			if(m.getSubject().equals(keyword))
    			subjectBasedBooks.add(m);
    		}
    		return subjectBasedBooks;
    	}*/
          
        }
