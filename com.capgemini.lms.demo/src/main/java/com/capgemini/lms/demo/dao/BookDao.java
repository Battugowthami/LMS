package com.capgemini.lms.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.lms.demo.dtos.Books;

@Repository
public interface BookDao extends JpaRepository<Books,Long> {
	

	List<Books> findAll();
	void deleteById(Long id);
	
	
	

}
