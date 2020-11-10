package com.capgemini.lms.demo.dtos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="author")
public class Author 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "First name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "Last name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name="last_name")
	private String lastName;
	
	@NotEmpty(message = "EmailId is required")
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9]{2,}@[a-z]{5}.com$",message="Email address is invalid")
	@Column(name="last_name")
	private String email;

	@NotEmpty(message = "Contact number is required")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$")
	@Column(name = "contact_no",unique=true)
	private String contactno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Books books;
	
	public Author() 
	{
		super();
	}

	public Author( String firstName, String lastName, String email, String contactno, Books books)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", books=");
		builder.append(books);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}
