package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.unitouch.model.EmailScheduler;

public interface EmailSchedulerRepo extends JpaRepository<EmailScheduler, Integer> {

}
