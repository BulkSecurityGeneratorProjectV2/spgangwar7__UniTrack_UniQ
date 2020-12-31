package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Books;

public interface BookService {


	public List<Books> getallList();
	
	public Integer saveBooks(Books books);


}
