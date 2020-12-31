package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.vo.UserRoleVo;

public interface UserRoleService {
	public List<UserRole> getUserID(int roleID);

	public List<UserRoleVo> usersbyRoleId(int roleId);
}
