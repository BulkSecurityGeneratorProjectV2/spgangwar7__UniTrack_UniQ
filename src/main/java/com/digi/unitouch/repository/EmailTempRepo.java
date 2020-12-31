package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digi.unitouch.model.EmailTemp;
@Repository
public interface EmailTempRepo extends JpaRepository<EmailTemp , Integer>{
	@Query("SELECT e FROM EmailTemp e WHERE e.id =?1 ")
	EmailTemp getEmailByID(Integer id);
}
