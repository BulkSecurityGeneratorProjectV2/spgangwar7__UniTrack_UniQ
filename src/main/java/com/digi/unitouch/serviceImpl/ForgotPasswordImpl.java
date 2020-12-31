package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.service.ForgotPassword;
import com.digi.unitouch.util.SendEmailUtility;

@Service
@Transactional
public class ForgotPasswordImpl implements ForgotPassword {

//	@Autowired 
//	MailService mailUtils;
	@Autowired
	UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	Environment env;


	@Override
	public String sendMailForPassword(String userEmail, String token) {

		userRepo.updateTokenByUser(userEmail,token);
		
		String fromMailID = env.getProperty("spring.mail.username");
		String toMailID = userEmail;
		String mailSubject = "Forgot Password";
		String mailBody = ForgotPasswaordMailTemplate(token);
		try {
			SendEmailUtility.mailForgetPassword(toMailID, mailSubject, mailBody);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "Password reset URL send on mail successfully.";
		return message;
	}

	private String ForgotPasswaordMailTemplate(String token) {
		StringBuilder builder = new StringBuilder();
		String resetUrl=env.getProperty("resetUrl");
		String resetPasswordURL = resetUrl+"?token="+token+"";
		builder.append("Dear User </br>");
		builder.append("To reset your password, click the link below:\n <a href='"+resetPasswordURL+"'>" +"Click "+ "</a></br>");
		builder.append("</br>");
		builder.append(resetPasswordURL);
		builder.append("</br>THANK YOU !!");
		return builder.toString();
	}

	@Override
	public List<Users> findUserDetailsByToken(String token) {
		return userRepo.findUserDetailsByToken(token);
	}

	@Override
	public void saveUpdatedPassword(String token, String password,String emailID) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		//System.out.println("token"+token +"\npassword"+encodedPassword +"\n"+"emailID"+emailID);
		userRepo.updatePasswordByToken(encodedPassword,token);
		userRepo.deleteTokenByUser(emailID,token);
		
		
	}

	@Override
	public void resetPassword(String username, String newpassword) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(newpassword);
		userRepo.updateUserPassword(encodedPassword,username);
	}

	@Override
	public boolean checkIfValidOldPassword(final Users user, final String oldPassword) {
 		return passwordEncoder.matches(oldPassword, user.getPassword());
	}
}