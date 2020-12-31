package com.digi.unitouch.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.UserTracker;
import com.digi.unitouch.repository.UserTrackerRepo;
import com.digi.unitouch.service.UserTrackerService;
@Service
@Transactional
public class UserTrackerServiceImpl implements UserTrackerService {

	@Autowired
	 UserTrackerRepo userTrackerRepo;
	@Override
	public boolean saveUserTrackerDetails(UserTracker userTracker) {
		try {
		userTrackerRepo.save(userTracker);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

}
