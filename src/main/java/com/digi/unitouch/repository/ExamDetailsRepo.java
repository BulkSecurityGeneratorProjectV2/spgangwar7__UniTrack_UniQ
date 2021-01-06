package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digi.unitouch.model.ExamDetails;

@Repository
public interface ExamDetailsRepo  extends JpaRepository<ExamDetails, Integer>{

}
