package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.unitouch.emun.EmunAticleStatus;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.UserDepartmentRepo;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.repository.UserRoleRepo;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.util.SendEmailUtility;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleServiceImpl roleServiceImpl;
	@Autowired
	UserDepartmentRepo userDeptRepo;
	
	@Override
	public List<Users> getUsers() {

		return userRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

//	@Override
//	public String createUser(Users user) {
//		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		userRepo.saveAndFlush(user);
//		
//		UserDepartment userDept = new UserDepartment();
//		userDept.setUserID(user.getUserID());
//		userDept.setDeptID(user.getDeptID());
//		userDeptRepo.save(userDept);
//		return "User Created Successfully.";
//	}

	@Override
	@Transactional
	public String saveUser(Users user) {
		Users duplicatUser = userRepo.findByUsername(user.getUsername());
		if (duplicatUser != null) {
			return "User's email already exist. It must be unique";
		} else {
			String temp = user.getPassword();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Users userid = userRepo.saveAndFlush(user);
			UserRole userRole = new UserRole();
			userRole.setUserId(userid.getUserID());
			userRole.setRoleId(user.getRoleID());
			userRoleRepo.save(userRole);
			Role role = roleServiceImpl.getRoleByID(user.getRoleID());
			String mailbody = EmunAticleStatus.LoginEMail("", user.getFirstName() + "\r\n" + user.getLastName(),
					user.getUsername(), temp, role.getRoleName());
			try {
				SendEmailUtility.sendUserCreationMail(user.getUsername(), "Login credentials for new production system",
						mailbody, "unitest@journalonweb.com");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "User is created successfully";

		}
	}

//	@Override
//	public String editUserDetials(Users user) {
//		
//		//user.setActive("Y");
//		userRepo.saveAndFlush(user);
//		
//		UserDepartment userDept = new UserDepartment();
//		userDept.setUserID(user.getUserID());
//		userDept.setDeptID(user.getDeptID());
//		userDeptRepo.save(userDept);
//		
//		return "User Updated Successfully.";
//	}

	@Override
	@Transactional
	public String updateUser(Users user) {
		user.setPassword(user.getPassword());
		userRepo.saveAndFlush(user);
		UserRole ur = new UserRole();
		UserRole urr = userRoleRepo.getUserIDAndRoleID(user.getUserID(), user.getRoleID());
		if (urr == null) {
			ur.setUserId(user.getUserID());
			ur.setRoleId(user.getRoleID());
			userRoleRepo.save(ur);
		} else {
			return "User's email already exist. It must be unique";
		}
		return "User updated successfully";
	}

	@Override
	public String deleteUser(Users user) {
		userRepo.delete(user);
		return "User Deleted Successfully.";
	}

	@Override
	public List<Users> getUsersByID(Users user) {
		return userRepo.getUsersByID(user.getUserID());
	}

	@Override
	public Users findUserIdByUserName(String name) {
		return userRepo.findByUsername(name);
	}

	@Override
	public boolean updateUserProfile(Users user) {
		userRepo.save(user);
		return true;
	}

	@Override
	public Users findByUserId(Integer userId) {
		return userRepo.getOne(userId);
	}
}
