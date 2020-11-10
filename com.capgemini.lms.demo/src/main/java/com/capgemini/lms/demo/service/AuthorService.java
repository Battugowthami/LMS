package com.capgemini.lms.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.lms.demo.dao.AuthorDao;
import com.capgemini.lms.demo.dtos.Author;
import com.capgemini.lms.demo.exceptions.AuthorNotFoundException;

@Service
public class AuthorService 
{
	@Autowired
	private AuthorDao authorDao;
	
	public List<Author> getAllAuthors() 
	{
		System.out.println("Authors...");
		return authorDao.findAll();
	}
	
	public Author getAuthorById(Long id) 
	{
		System.out.println("Author");
		try {
			Optional<Author>optional = authorDao.findById(id);
       if(!optional.isPresent()) 
       {
    	   throw new AuthorNotFoundException("Author not found for id "+id);
       }
       else
    	   return optional.get();
		}
		catch(AuthorNotFoundException  e) 
		{
			System.err.println(e);
		}
		return null;
	}
	
	public Author addAuthor(Author author) 
	{
		System.out.println("Author added.");
		return authorDao.save(author);
	}
	
	public Author updateAuthor(Long id, Author author) 
	{
		System.out.println("Author updated.");

		Optional<Author> repAuth =authorDao.findById(id);

		if (repAuth.isPresent()) {

			Author authorToBeUpdated = repAuth.get();
			authorToBeUpdated.setFirstName(author.getFirstName());
			authorToBeUpdated.setLastName(author.getLastName());
			authorToBeUpdated.setEmail(author.getEmail());
			authorToBeUpdated.setContactno(author.getContactno());
			authorToBeUpdated.setBooks(author.getBooks());
			return authorDao.save(authorToBeUpdated);
		}
		return null;
	}

	public String removeAuthor(Long authorId) throws AuthorNotFoundException 
	{
		try {
		//System.out.println("Author removed.");
		authorDao.deleteById(authorId);
		}catch(Exception  e) {
			throw new AuthorNotFoundException("Enter correct ");	
		}
		return "Author deleted Sucessfully";
	}
	
}
