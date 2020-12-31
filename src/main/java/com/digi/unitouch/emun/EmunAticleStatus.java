/**
 * 
 */
/**
 * @author 80055
 *
 */
package com.digi.unitouch.emun;

import static com.digi.unitouch.emailScheduler.AppConstrants.ARTICLE_TITLE;
import static com.digi.unitouch.emailScheduler.AppConstrants.JOURNAL;
import static com.digi.unitouch.emailScheduler.AppConstrants.JOURNAL_NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.MANUSCRIPTID;
import static com.digi.unitouch.emailScheduler.AppConstrants.TITLE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.Journal;

@Component
public class EmunAticleStatus {

	public enum ArticleStatus {
		Yet_to_Start, InProgress, Completed, Paused, InPool, Skipped, Rejected, Completed_by_Proxy, Withdraw;
	}

	public enum withdrawStatus {
		Y, N;
	}

	public static String LoginEMail(String title, String Username, String email, String password, String role) {
	String mailBody="<p>Dear "+Username+",</p>\r\n" + 
			"\r\n" + 
			"<p>Greetings!</p>\r\n" + 
			"\r\n" + 
			"<p>We have created your account on the new production system.</p>\r\n" + 
			"\r\n" + 
			"<p>Your email id is :"+email+"</p>\r\n" + 
			"\r\n" + 
			"<p>Your password is :" + password + "</p>\r\n" + 
			"\r\n" + 
			"<p>You have been provided with the following role: " + role + "</p>\r\n" + 
			"\r\n" + 
			"<p>URL - https://production.jow.medknow.com</p>\r\n" + 
			"\r\n" + 
			"<p>Thank you.</p>\r\n" + 
			"\r\n" + 
			"<p>Best Regards</p>\r\n" + 
			"\r\n" + 
			"<p>Production Team<br />\r\n" + 
			"Wolters Kluwer - Medknow</p>\r\n" + 
			"\r\n  <p style=\"color: red;\"><strong><em>This is system generated password please reset it</em></strong></p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"";
//		String mail = "<p>Welcome&nbsp;<strong>" + title + "</strong>&nbsp; <strong>" + Username + "</strong></p>\r\n"
//				+ "\r\n" + "<p>Your email id is :<strong>" + email + "</strong></p>\r\n" + "\r\n"
//				+ "<p>Your password is :<strong>" + password + "</strong></p>\r\n" + "\r\n"
//				+ "<p>You have been provided with the following role:<strong> " + role + "</strong></p>\r\n" + "\r\n"
//				+ "\r\n URL - <a> https://production.jow.medknow.com </a>" + "<p><strong>Thank you.</strong></p>\r\n"
//				+ "\r\n" + "<p>Best Regards</p>\r\n" + "\r\n" + "<p>Unitouch</p>";
		return mailBody;
	}

	public static List<String> fiststageMail(String ARTICLE_TITLE, String MANUSCRIPTID, String JOURNAL_NAME) {
		List<String> mail = new ArrayList<String>();
		String sub = "Article for Technical/Content checking: "+MANUSCRIPTID+"";
		String fststge = "Dear Vendor, "
				+ "  \r\n" + "\r\n" + MANUSCRIPTID + " - “" + ARTICLE_TITLE
				+ "” has been assigned for technical/Content checking (TE and CE) in your area of " 
				+ JOURNAL_NAME
				+ ".\r\n" + "\r\n"
				+ " In case of help or clarification please contact wkhlrpmedknow_techsupport@wolterskluwer.com.\r\n"
				+ "\r\n" + "Production Team,\r\n" + "\r\n" 
				+ "Wolters Kluwer - Medknow\r\n";
		mail.add(sub);
		mail.add(fststge);
		return mail;
	}

	public static List<String> toProduction(String ARTICLE_TITLE, String MANUSCRIPTID, String JOURNAL_NAME) {
		List<String> mail = new ArrayList<String>();
		String sub = "	Article for Technical/Content checking: " + MANUSCRIPTID + "";
		String fststge = "Dear PE,"
				+ "\r\n" + "\r\n" + MANUSCRIPTID
				+ " has been assigned to the vendor for Technical/Content checking.\r\n" 
				+ "\r\n" + JOURNAL_NAME + ". ";
		mail.add(sub);
		mail.add(fststge);
		return mail;
	}
	
	
	//for issue
	public static List<String> fiststageforIssueMailVender(String issueTitle, String producionEditor, String JOURNAL_NAME) {
		List<String> mail = new ArrayList<String>();
		String sub = "Combined PDF/Issue preparation: "+issueTitle+"\r\n";
		String fststge ="<p>Dear Vendor,</p>\r\n" + 
				"\r\n" + 
				"<p>Kindly prepare the Combined PDF/Issue "+issueTitle+" as per the sequence provided in the excel file which is available for download in your area.</p>\r\n" + 
				"\r\n" + 
				"<p>Regards,</p>\r\n" + 
				"\r\n" + 
				"<p>"+producionEditor+"</p>\r\n" + 
				"";
		mail.add(sub);
		mail.add(fststge);
		return mail;
	}
	
	
	public static List<String> toProductionforIssue(String issueTitle, String producionEditor, String JOURNAL_NAME) {
		List<String> mail = new ArrayList<String>();
		String sub = "Combined PDF/Issue preparation: "+issueTitle+"";
		String fststge = "<p>Dear "+producionEditor+",</p>\r\n" + 
				"\r\n" + 
				"<p>Request to prepare Combined PDF/Issue "+issueTitle+" has been sent to the vendor.</p>\r\n" + 
				"\r\n" + 
				"<p>Medknow Team</p>\r\n" + 
				"";
		mail.add(sub);
		mail.add(fststge);
		return mail;
	}
	
	
	public  static String modifiedMailTemplate(String maildata, ArticleDetail emailTriggerVo,Journal journal) {
		String body = maildata;
		if(body!=null) {
		
		if (body.contains(MANUSCRIPTID) && emailTriggerVo.getAid() != null)
			body = body.replace(MANUSCRIPTID, emailTriggerVo.getAid());
		else
			body = body.replace(MANUSCRIPTID, "");

		if (body.contains(ARTICLE_TITLE) && emailTriggerVo.getArticle_title() != null)
			body = body.replace(ARTICLE_TITLE, emailTriggerVo.getArticle_title());
		else
			body = body.replace(ARTICLE_TITLE, "");

		if (body.contains(TITLE) && emailTriggerVo.getArticle_title() != null)
			body = body.replace(TITLE, emailTriggerVo.getArticle_title());
		else
			body = body.replace(TITLE, "");

		if (body.contains(JOURNAL_NAME) && journal.getJournalName() != null)
			body = body.replace(JOURNAL_NAME,journal.getJournalName());
		else
			body = body.replace(JOURNAL_NAME, "");

		if (body.contains(JOURNAL) && journal.getJournalName()!= null)
			body = body.replace(JOURNAL,journal.getJournalName());
		else
			body = body.replace(JOURNAL, "");

		}else {
			return "";
		}
		return body.toString();
	}

	public static String articleSysnco(String articleID, Exception e) {
		String msg = "Dear User\r\n" + "Article is not Synchronized" 
					+ "\r\n ArticleID - " + articleID 
					+ "\r\n Exception - "+ e 
					+ "\r\nThanks";
		return msg;
	}
	
}