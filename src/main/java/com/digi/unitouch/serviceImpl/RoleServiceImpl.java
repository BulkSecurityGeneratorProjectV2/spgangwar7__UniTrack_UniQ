package com.digi.unitouch.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.RoleRepo;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.repository.UserRoleRepo;
import com.digi.unitouch.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<Role> getRoleList() {
		 return roleRepo.findAll(Sort.by(Sort.Direction.ASC, "roleName"));
	}
	
//	@Override
//	public List<Role> getaskList() {
//		return roleRepo.findAll();
//	}

	@Override
	public List<Role> getaskList() {
		//return roleRepo.findAll();
		List<Role> rolelist = roleRepo.findAllOrderby();
		List<Role> role = new ArrayList<>();
		for(int i = 0; i<rolelist.size(); i++) {
			int roleID = rolelist.get(i).getRoleID();
			
			List<UserRole> ur = userRoleRepo.getUserID(roleID);
			if(ur != null) {
				for(int j =0;j<ur.size();j++) {
				Role  r = new Role();
				r.setRoleID(ur.get(j).getRoleId());
				r.setRoleName(rolelist.get(i).getRoleName());
				r.setStatus(rolelist.get(i).getStatus());
				r.setCreatedBy(rolelist.get(i).getCreatedBy());
				r.setColour(rolelist.get(i).getColour());
				r.setModifiedBy(rolelist.get(i).getModifiedBy());
				//r.setCreatedAt(rolelist.get(i).getCreatedAt());
			
				System.out.println(ur.get(j).getUserId());
				role.add(r);
				break;
				}
			}
		}
		return role;
	}

	@Override
	public Integer saveNewRole(Role role) {
		role.setModifiedAt(new Date());
		roleRepo.saveAndFlush(role);
		return role.getRoleID();
	}

	@Override
	public void deleteRole(Role role) {
		roleRepo.delete(role);
		
	}

	@Override
	public List<Role> getRolesByID(Role role) {
		return roleRepo.getRolesByID(role.getRoleID());
	}

	@Override
	public Role getRoleByID(Integer roleId) {
		return roleRepo.getRoleByID(roleId);
	}
	@Override
	public String getuserListByroleID(UserRole userrole) {
		List<Users> userRoleList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		List<UserRole> rolelist = userRoleRepo.getUserID(userrole.getRoleId());
		builder.append("<label for=\"ExpertiseLevel\">User </label>");
		builder.append("<select id=\"userrole\" class=\"custom-select\">");
		builder.append("<option selected=\"selected\"> Select User ...</option>");

		for (UserRole userRole2 : rolelist) {
			userRoleList = userRepo.getUsersByID(userRole2.getUserId());
			userRoleList.stream().forEach(userlist -> {
				builder.append("<option value=\"" + userlist.getUserID() + "\">" + userlist.getFirstName() + " "
						+ userlist.getLastName() + "</option>");
			});
		}
		builder.append("</select>");
		return builder.toString();
	}
}
