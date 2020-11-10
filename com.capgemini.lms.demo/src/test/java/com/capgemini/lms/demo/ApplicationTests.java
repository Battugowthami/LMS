package com.capgemini.lms.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.lms.demo.controller.AuthorController;

@ExtendWith(MockitoExtension.class)
public class ApplicationTests 
{
	private MockMvc mockMvc;

	@InjectMocks
	AuthorController authorController;
	@Test
	public void testHi() {
		System.out.println("testHi");
		//assertThat(authorController.hi()).contains("Hi!");
	}
	@Test
	public void testGetProductById() throws Exception {
		System.out.println("testGetAuthorById");
		//assertThat(authorController.hi()).contains("Hi!");

	}

}
