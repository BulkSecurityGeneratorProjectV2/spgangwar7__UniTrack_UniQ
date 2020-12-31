package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Books;
import com.digi.unitouch.repository.BookRepo;
import com.digi.unitouch.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;
	
	@Override
	public List<Books> getallList() {
		
		return bookRepo.findAll();
	}

	@Override
	public Integer saveBooks(Books books) {
		bookRepo.save(books);
		return books.getBookId();
	}

}
