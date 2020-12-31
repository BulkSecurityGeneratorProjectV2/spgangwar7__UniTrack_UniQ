package com.digi.unitouch.util;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.digi.unitouch.emun.EmailEnum;


public class SendEmailUtility {
	public static void mailToCC(String to, String msgSubject, String msgBody,String cc ) throws AddressException, MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
     
        message.setFrom(new InternetAddress("unitest@journalonweb.com"));
		if (to == null) {
			message.setRecipient(RecipientType.TO, new InternetAddress(EmailEnum.to));
		} else {
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
		}
		message.setRecipient(RecipientType.CC, new InternetAddress(cc));
		message.setRecipient(RecipientType.TO, new InternetAddress(EmailEnum.to));
        message.setSubject(msgSubject);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(msgBody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
        Transport.send(message);
    }
	
	
	public static void mail(String to, String msgSubject, String msgBody ) throws AddressException, MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
     
        message.setFrom(new InternetAddress("unitest@journalonweb.com"));
		if (to == null) {
			message.setRecipient(RecipientType.TO, new InternetAddress(EmailEnum.to));
		} else {
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
		}
//		message.setRecipient(RecipientType.BCC, new InternetAddress("mudit.bhandari@digiscapetech.com"));
//		message.setRecipient(RecipientType.CC, new InternetAddress("azhar.shaikh@wolterskluwer.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(EmailEnum.to));
        message.setSubject(msgSubject);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(msgBody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
        Transport.send(message);
    }

//	public static void sendEmailUpdateEmailReplyScheduler(String preMailID, String replysubject, String replybody,
//			String fromEmail) throws AddressException, MessagingException{
//		Properties props = new Properties();
//        props.put("mail.smtp.host", "40.71.95.214");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.debug", "true");
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//        if(fromEmail != null) {
//           message.setFrom(new InternetAddress(fromEmail));
//        }else {
//           message.setFrom(new InternetAddress("unitest@journalonweb.com"));
//        }
//        message.setRecipient(RecipientType.TO, new InternetAddress(preMailID));
//        message.setSubject(replysubject);
//        message.setRecipient(RecipientType.CC, new InternetAddress(EmailEnum.to));  
//	//	message.setText(replybody);
//        message.setSentDate(new Date());
//        BodyPart messageBodyPart = new MimeBodyPart();
//		messageBodyPart.setContent(replybody,"text/html");
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		message.setContent(multipart);
//        Transport.send(message);
//	}

	public static void sendEmailUpdateEmailFinishScheduler(String nextMailID, String finishsubject, String finishbody,
			String fromEmail) throws AddressException, MessagingException {
		Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        if(fromEmail != null) {
           message.setFrom(new InternetAddress(fromEmail));
        }else {
           message.setFrom(new InternetAddress("unitest@journalonweb.com"));
        }
       
        message.setRecipient(RecipientType.TO, new InternetAddress(nextMailID));
        message.setRecipient(RecipientType.CC, new InternetAddress(EmailEnum.to));  
        message.setSubject(finishsubject);
		//message.setText(finishbody);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(finishbody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		message.setContent(multipart);
        Transport.send(message);
	}

	public static void sendEmailUpdateEmailScheduler(String toMailID, String mailSubject, String mailBody,
			String fromEmail) throws AddressException, MessagingException{
		Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        if(fromEmail != null) {
           message.setFrom(new InternetAddress(fromEmail));
        }else {
           message.setFrom(new InternetAddress("unitest@journalonweb.com"));
        }
        message.setRecipient(RecipientType.TO, new InternetAddress(toMailID));
        message.setSubject(mailSubject);
		//message.setText(mailBody);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(mailBody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
        Transport.send(message);
	}
	public static void sendUserCreationMail(String preMailID, String replysubject, String replybody,
			String fromEmail) throws AddressException, MessagingException{
		Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        if(fromEmail != null) {
           message.setFrom(new InternetAddress(fromEmail));
        }else {
           message.setFrom(new InternetAddress("unitest@journalonweb.com"));
        }
        message.setRecipient(RecipientType.TO, new InternetAddress(preMailID));
        message.setSubject(replysubject);
    //    message.setRecipient(RecipientType.CC, new InternetAddress(EmailEnum.to));  
	//	message.setText(replybody);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(replybody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
        Transport.send(message);
	}
	
	public static void sendFistStageProductioMail(String to, String subject, String body,
			String fromEmail) throws AddressException, MessagingException{
		Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        if(fromEmail != null) {
           message.setFrom(new InternetAddress(fromEmail));
        }else {
           message.setFrom(new InternetAddress("unitest@journalonweb.com"));
        }
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setRecipient(RecipientType.CC, new InternetAddress(EmailEnum.to));  
	
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(body,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		System.out.println(body);
		message.setContent(multipart);
        Transport.send(message);
	}

	public static void mailForgetPassword(String to, String msgSubject, String msgBody) throws AddressException, MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "40.71.95.214");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
     
        message.setFrom(new InternetAddress("unitest@journalonweb.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(msgSubject);
        message.setSentDate(new Date());
        BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(msgBody,"text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
        Transport.send(message);
    }
	

}
