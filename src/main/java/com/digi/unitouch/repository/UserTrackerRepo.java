package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.unitouch.model.UserTracker;

public interface UserTrackerRepo extends JpaRepository<UserTracker, Integer> {

}
