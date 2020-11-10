package com.capgemini.lms.demo.exceptions;

public class AuthorNotFoundException extends Exception
{
	public AuthorNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

}
