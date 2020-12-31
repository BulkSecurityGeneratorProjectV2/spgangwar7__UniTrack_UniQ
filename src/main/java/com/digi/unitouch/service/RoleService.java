package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.UserRole;

public interface RoleService {
	
	public List<Role> getRoleList();
	
	public List<Role> getaskList();

	public Integer saveNewRole(Role role);

	public void deleteRole(Role role);

	public List<Role> getRolesByID(Role role);
	
	Role getRoleByID(Integer roleId);

	public String getuserListByroleID(UserRole userrole);
}
