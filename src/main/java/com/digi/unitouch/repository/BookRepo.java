package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.unitouch.model.Books;

public interface BookRepo extends JpaRepository<Books, Integer> {

}
