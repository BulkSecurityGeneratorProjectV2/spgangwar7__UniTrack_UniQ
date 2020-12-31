//package com.digi.unitouch.util;
//
//import java.util.Properties;
//
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	public String sendEmail(String email, String Subject, String Body) {
//
//		String htmlText = "<font color='#040f07'>" + Body + "</font>";
//		MimeMessage mime = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper;
//		try {
//			helper = new MimeMessageHelper(mime, true);
//			helper.setFrom("digiscape@gmail.com");
//		//	helper.setFrom("haramohan.nanda@digiscapetech.com");
//			helper.setTo(email);
//			helper.setSubject(Subject);
//			helper.setText(htmlText, true);
//			this.javaMailSender.send(mime);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			return "Error";
//		}
//		return "Success!";
//	}
//
//	public void sendEmail(String fromMailID, String toMailID, String mailSubject, String mailBody) {
//
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setFrom(fromMailID);
//		msg.setTo(toMailID);
//		msg.setSubject(mailSubject);
//		msg.setText(mailBody);
//		
//		/*
//		 * Properties props = new Properties();
//		 * 
//		 * props.put("mail.smtp.host", "smtp.office365.com");
//		 * props.put("mail.smtp.port", "587"); props.put("mail.smtp.ssl.trust",
//		 * "smtp.office365.com"); props.put("mail.smtp.starttls.enable", "true");
//		 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.connectiontimeout",
//		 * "10000");
//		 * 
//		 * final String EmailUser = "haramohan.nanda@digiscapetech.com"; final String
//		 * EmailPassword = "swAs8Qef3#"; Session session = Session.getInstance(props,
//		 * new javax.mail.Authenticator() { protected PasswordAuthentication
//		 * getPasswordAuthentication() { return new PasswordAuthentication(EmailUser,
//		 * EmailPassword); } }); InternetAddress fromAddress = new
//		 * InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
//		 * InternetAddress toAddress1 = new
//		 * InternetAddress("uniproofdigiscape@gmail.com", "Uniproof Team");
//		 * InternetAddress toAddress2 = new
//		 * InternetAddress("thomsondigital.book@gmail.com", "Unitouch Team");
//		 * 
//		 * Message msg = new MimeMessage(session);
//		 * 
//		 * msg.setFrom(fromAddress);
//		 * 
//		 * msg.addRecipient(Message.RecipientType.CC, toAddress1);
//		 * msg.addRecipient(Message.RecipientType.TO, toAddress2);
//		 * 
//		 * 
//		 * String msgSubject = "Automated Email: Unitouch Tracker"; String msgBody =
//		 * "Dear ,\r\n" + "\r\n" + "Please find the Unitouch Tracker \r\n" + "\r\n" +
//		 * "Thanks,\r\n" + "Unitouch\r\n" + "";
//		 * 
//		 * msg.setSubject(msgSubject); msg.setText(msgBody);
//		 * 
//		 * // Create the message part BodyPart messageBodyPart = new MimeBodyPart();
//		 * 
//		 * // Now set the actual message messageBodyPart.setText(msgBody); // Create a
//		 * multipar message Multipart multipart = new MimeMultipart();
//		 * 
//		 * // Set text message part multipart.addBodyPart(messageBodyPart);
//		 * 
//		 * msg.setContent(multipart);
//		 * 
//		 * Transport transport = session.getTransport("smtp"); transport.connect();
//		 * transport.sendMessage(msg, msg.getAllRecipients());
//		 */
//
//		javaMailSender.send(msg);
//
//	}
//
//}
