package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.repository.UserRoleRepo;
import com.digi.unitouch.service.UserRoleService;
import com.digi.unitouch.vo.UserRoleVo;
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
@Autowired
UserRoleRepo userRepo;
	@Override
	public List<UserRole> getUserID(int roleID) {
		return userRepo.getUserID(roleID);
	}

	@Override
	public List<UserRoleVo> usersbyRoleId(int roleId) {
		return userRepo.usersbyRoleId(roleId);
	}

}
