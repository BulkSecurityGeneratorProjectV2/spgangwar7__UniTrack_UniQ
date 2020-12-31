package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Users;

public interface  UserService {
	
	public List<Users> getUsers();
	
	//public String createUser(Users user);
	
//	public String editUserDetials(Users user);
	
	public String deleteUser(Users user);

	public List<Users> getUsersByID(Users user);

	public Users findUserIdByUserName(String name);

	 public String saveUser(Users user);

	 public String updateUser(Users user);

	 public boolean updateUserProfile(Users user);

	Users findByUserId(Integer userId);
}
