package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Users;


public interface ForgotPassword {
	
	public String sendMailForPassword(String userEmail, String token);
	
	public List<Users> findUserDetailsByToken(String token);
	
	public void saveUpdatedPassword(String token, String password,String emailID);

	public void resetPassword(String username, String newpassword);
	
	public boolean checkIfValidOldPassword(final Users user, final String oldPassword);
}