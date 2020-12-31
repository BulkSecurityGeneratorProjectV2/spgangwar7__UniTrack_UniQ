//package com.digi.unitouch.util;
//
//import java.io.UnsupportedEncodingException;
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
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailEngineUnitouch {
//
//	public static void sendEmailAttachement(String to, String msgSubject,String msgBody) {
//		try {
//
//			Properties props = new Properties();
//
//			props.put("mail.smtp.host", "smtp.office365.com");
//			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.connectiontimeout", "10000");
//
//			final String EmailUser = "haramohan.nanda@digiscapetech.com";
//			final String EmailPassword = "swAs8Qef3#1";
//
//			
//			/*
//			 * final String EmailUser = "auto.mis@thomsondigital.com "; final String
//			 * EmailPassword = "P@ssw0rd";
//			 */
//			 
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(EmailUser, EmailPassword);
//				}
//			});
//
//			session.setDebug(true);
//			InternetAddress fromAddress = new InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
//			InternetAddress toAddress1 = new InternetAddress("uniproofdigiscape@gmail.com", "UniTouch Team");
//			InternetAddress toAddress2 = new InternetAddress(EmailEnum.to, "Unitouch Team");
//			InternetAddress toAddress3 = new InternetAddress(to, "Unitouch Team");
//	//		InternetAddress toAddress4 = new InternetAddress("azhar.shaikh@wolterskluwer.com", "Unitouch Team");
//			InternetAddress toAddress5 = new InternetAddress("mudit.bhandari@digiscapetech.com", "Unitouch Team");
//			
////			String msgSubject = "Automated Email: Unitouch Tracker";
////			String msgBody = "Dear ,\r\n" + "\r\n" + "Please �dd  the Issue Workflow in Unitouch\r\n" + "\r\n" + "Thanks,\r\n"
////					+ "Unitouch\r\n" + "";
//
//			Message msg = new MimeMessage(session);
//
//			msg.setFrom(fromAddress);
//
//			msg.addRecipient(Message.RecipientType.CC, toAddress1);
//			msg.addRecipient(Message.RecipientType.BCC, toAddress2);
//			msg.addRecipient(Message.RecipientType.TO, toAddress3);
//		//	msg.addRecipient(Message.RecipientType.TO, toAddress4);
//			msg.addRecipient(Message.RecipientType.TO, toAddress5);
//			msg.setSubject(msgSubject);
//			msg.setText(msgBody);
//
//			// Create the message part
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			// Now set the actual message
//			messageBodyPart.setText(msgBody);
//			// Create a multipar message
//			Multipart multipart = new MimeMultipart();
//
//			// Set text message part
//			multipart.addBodyPart(messageBodyPart);
//
//			msg.setContent(multipart);
//
//			Transport transport = session.getTransport("smtp");
//			transport.connect();
//			transport.sendMessage(msg, msg.getAllRecipients());
//
//		} catch (MessagingException e) {
//			System.out.println(e.getMessage() + e.getStackTrace());
//		} catch (UnsupportedEncodingException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
////	public static void sendEmailUpdateEmailScheduler(String to, String msgSubject,String msgBody,String fromEmail,String fromPassword) {
////		try {
////			Properties props = new Properties();
////
////			props.put("mail.smtp.host", "smtp.office365.com");
////			props.put("mail.smtp.port", "587");
////			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
////			props.put("mail.smtp.starttls.enable", "true");
////			props.put("mail.smtp.auth", "true");
////			props.put("mail.smtp.connectiontimeout", "10000");
////
////			//String EmailUser = fromEmail;
////			//String EmailPassword = fromPassword;
////		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
////			final String EmailPassword = "swAs8Qef3#1";
////
////			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
////				protected PasswordAuthentication getPasswordAuthentication() {
////					return new PasswordAuthentication(EmailUser, EmailPassword);
////				}
////			});
////
////			session.setDebug(true);
////			InternetAddress fromAddress = new InternetAddress(fromEmail, "Auto Unitouch");
////			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
////			InternetAddress toAddress4 = new InternetAddress(EmailEnum.to, "Unitouch Team");
////
////			Message msg = new MimeMessage(session);
////
////			msg.setFrom(fromAddress);
////			msg.addRecipient(Message.RecipientType.CC, toAddress1);
////			msg.addRecipient(Message.RecipientType.TO, toAddress4);
////			msg.setSubject(msgSubject);
////		//	msg.setText(msgBody);
////			msg.setContent(msgBody, "text/html");
////		//	msg.set
////
////			// Create the message part
////			BodyPart messageBodyPart = new MimeBodyPart();
////
////			// Now set the actual message
////			messageBodyPart.setText(msgBody);
////			// Create a multipar message
////			Multipart multipart = new MimeMultipart();
////
////			// Set text message part
////			multipart.addBodyPart(messageBodyPart);
////
////			msg.setContent(multipart);
////
////			Transport transport = session.getTransport("smtp");
////			transport.connect();
////			transport.sendMessage(msg, msg.getAllRecipients());
////
////		} catch (MessagingException e) {
////			System.out.println(e.getMessage() + e.getStackTrace());
////		} catch (UnsupportedEncodingException e) {
////			System.out.println(e.getMessage());
////		}
////	}
//	
////	public static void sendEmailUpdateEmailFinishScheduler(String string, String finishsubject, String finishbody,
////			String fromEmail, String fromPassword) {
////		try {
////			Properties props = new Properties();
////
////			props.put("mail.smtp.host", "smtp.office365.com");
////			props.put("mail.smtp.port", "587");
////			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
////			props.put("mail.smtp.starttls.enable", "true");
////			props.put("mail.smtp.auth", "true");
////			props.put("mail.smtp.connectiontimeout", "10000");
////
////			//String EmailUser = fromEmail;
////			//String EmailPassword = fromPassword;
////		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
////			final String EmailPassword = "swAs8Qef3#1";
////
////			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
////				protected PasswordAuthentication getPasswordAuthentication() {
////					return new PasswordAuthentication(EmailUser, EmailPassword);
////				}
////			});
////
////			session.setDebug(true);
////			InternetAddress fromAddress = new InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
////			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
////			InternetAddress toAddress4 = new InternetAddress(EmailEnum.to, "Unitouch Team");
////
////			Message msg = new MimeMessage(session);
////			msg.setFrom(fromAddress);
////			msg.addRecipient(Message.RecipientType.CC, toAddress1);
////			msg.addRecipient(Message.RecipientType.TO, toAddress4);
////			msg.setSubject(finishsubject);
////			BodyPart messageBodyPart = new MimeBodyPart();
////			messageBodyPart.setContent(finishbody,"text/html");
////			//file 
////			Multipart multipart = new MimeMultipart();
////			multipart.addBodyPart(messageBodyPart);
////			msg.setContent(multipart);
////
////			Transport transport = session.getTransport("smtp");
////			transport.connect();
////			transport.sendMessage(msg, msg.getAllRecipients());
////
////		} catch (MessagingException e) {
////			System.out.println(e.getMessage() + e.getStackTrace());
////		} catch (UnsupportedEncodingException e) {
////			System.out.println(e.getMessage());
////		}
////		
////	}
//
////	public static void sendEmailUpdateEmailReplyScheduler(String string, String replysubject, String replybody,
////			String fromEmail, String fromPassword) {
////		try {
////			Properties props = new Properties();
////
////			props.put("mail.smtp.host", "smtp.office365.com");
////			props.put("mail.smtp.port", "587");
////			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
////			props.put("mail.smtp.starttls.enable", "true");
////			props.put("mail.smtp.auth", "true");
////			props.put("mail.smtp.connectiontimeout", "10000");
////
////			//String EmailUser = fromEmail;
////			//String EmailPassword = fromPassword;
////		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
////			final String EmailPassword = "swAs8Qef3#1";
////
////			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
////				protected PasswordAuthentication getPasswordAuthentication() {
////					return new PasswordAuthentication(EmailUser, EmailPassword);
////				}
////			});
////
////			session.setDebug(true);
////			InternetAddress fromAddress = new InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
////			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
////			InternetAddress toAddress4 = new InternetAddress("sharmaravisharma.15@gmail.com", "Unitouch Team");
////
////			Message msg = new MimeMessage(session);
////
////			msg.setFrom(fromAddress);
////			msg.addRecipient(Message.RecipientType.CC, toAddress1);
////			msg.addRecipient(Message.RecipientType.TO, toAddress4);
////			msg.setSubject(replysubject);
////			msg.setText(replybody);
////
////			BodyPart messageBodyPart = new MimeBodyPart();
////			messageBodyPart.setText(replybody);
////			Multipart multipart = new MimeMultipart();
////			multipart.addBodyPart(messageBodyPart);
////
////			msg.setContent(multipart);
////
////			Transport transport = session.getTransport("smtp");
////			transport.connect();
////			transport.sendMessage(msg, msg.getAllRecipients());
////
////		} catch (MessagingException e) {
////			System.out.println(e.getMessage() + e.getStackTrace());
////		} catch (UnsupportedEncodingException e) {
////		
////			System.out.println(e.getMessage());
////		}
////		
////	}
//
//	
//	
//	public static void sendEmailUpdateEmailScheduler(String to, String msgSubject,String msgBody,String fromEmail,String fromPassword) {
//		try {
//			Properties props = new Properties();
//
//			props.put("mail.smtp.host", "smtp.office365.com");
//			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.connectiontimeout", "10000");
//
//			//String EmailUser = fromEmail;
//			//String EmailPassword = fromPassword;
//		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
//			final String EmailPassword = "swAs8Qef3#1";
//
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(EmailUser, EmailPassword);
//				}
//			});
//
//			session.setDebug(true);
//			InternetAddress fromAddress = new InternetAddress(EmailUser, "Auto Unitouch");
//			//InternetAddress fromAddress = new InternetAddress(fromEmail, "Auto Unitouch");
//			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
//			InternetAddress toAddress4 = new InternetAddress(EmailEnum.to, "Unitouch Team");
//
//			Message msg = new MimeMessage(session);
//
//			msg.setFrom(fromAddress);
//			msg.addRecipient(Message.RecipientType.CC, toAddress1);
//			msg.addRecipient(Message.RecipientType.TO, toAddress4);
//			msg.setSubject(msgSubject);
//			msg.setText(msgBody);
//			//msg.setContent(msgBody, "text/html");
//
//			// Create the message part
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			// Now set the actual message
//			messageBodyPart.setContent(msgBody,"text/html");
//			// Create a multipar message
//			Multipart multipart = new MimeMultipart();
//
//			// Set text message part
//			multipart.addBodyPart(messageBodyPart);
//
//			msg.setContent(multipart);
//
//			Transport transport = session.getTransport("smtp");
//			transport.connect();
//			transport.sendMessage(msg, msg.getAllRecipients());
//
//		} catch (MessagingException e) {
//			System.out.println(e.getMessage() + e.getStackTrace());
//		} catch (UnsupportedEncodingException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public static void sendEmailUpdateEmailFinishScheduler(String nextMailID, String finishsubject, String finishbody,
//			String fromEmail, String fromPassword) {
//		try {
//			Properties props = new Properties();
//
//			props.put("mail.smtp.host", "smtp.office365.com");
//			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.connectiontimeout", "10000");
//
//			//String EmailUser = fromEmail;
//			//String EmailPassword = fromPassword;
//		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
//			final String EmailPassword = "swAs8Qef3#1";
//
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(EmailUser, EmailPassword);
//				}
//			});
//
//			session.setDebug(true);
//			InternetAddress fromAddress = new InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
//			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
//			InternetAddress toAddress4 = new InternetAddress(EmailEnum.to, "Unitouch Team");
//
//			Message msg = new MimeMessage(session);
//
//			msg.setFrom(fromAddress);
//			msg.addRecipient(Message.RecipientType.CC, toAddress1);
//			msg.addRecipient(Message.RecipientType.TO, toAddress4);
//			msg.setSubject(finishsubject);
//			msg.setText(finishbody);
//			//msg.setContent(finishbody, "text/html");
//
//			BodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setContent(finishbody,"text/html");
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//
//			msg.setContent(multipart);
//
//			Transport transport = session.getTransport("smtp");
//			transport.connect();
//			transport.sendMessage(msg, msg.getAllRecipients());
//
//		} catch (MessagingException e) {
//			System.out.println(e.getMessage() + e.getStackTrace());
//		} catch (UnsupportedEncodingException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
//
//	public static void sendEmailUpdateEmailReplyScheduler(String preMailID, String replysubject, String replybody,
//			String fromEmail, String fromPassword) {
//		try {
//			Properties props = new Properties();
//
//			props.put("mail.smtp.host", "smtp.office365.com");
//			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.ssl.trust", "smtp.office365.com");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.connectiontimeout", "10000");
//
//			//String EmailUser = fromEmail;
//			//String EmailPassword = fromPassword;
//		    final String EmailUser = "haramohan.nanda@digiscapetech.com";
//			final String EmailPassword = "swAs8Qef3#1";
//
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(EmailUser, EmailPassword);
//				}
//			});
//
//			session.setDebug(true);
//			InternetAddress fromAddress = new InternetAddress("haramohan.nanda@digiscapetech.com", "Auto Unitouch");
//			InternetAddress toAddress1 = new InternetAddress("sharmaravisharma.15@gmail.com", "UniTouch Team");
//			InternetAddress toAddress4 = new InternetAddress(EmailEnum.to, "Unitouch Team");
//
//			Message msg = new MimeMessage(session);
//
//			msg.setFrom(fromAddress);
//			msg.addRecipient(Message.RecipientType.CC, toAddress1);
//			msg.addRecipient(Message.RecipientType.TO, toAddress4);
//			msg.setSubject(replysubject);
//			msg.setText(replybody);
//			//msg.setContent(replybody, "text/html");
//			
//			BodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setContent(replybody,"text/html");
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//
//			msg.setContent(multipart);
//
//			Transport transport = session.getTransport("smtp");
//			transport.connect();
//			transport.sendMessage(msg, msg.getAllRecipients());
//
//		} catch (MessagingException e) {
//			System.out.println(e.getMessage() + e.getStackTrace());
//		} catch (UnsupportedEncodingException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
//}
