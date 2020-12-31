package com.digi.unitouch.serviceImpl;

import static com.digi.unitouch.emailScheduler.AppConstrants.ARTICLE_TITLE;
import static com.digi.unitouch.emailScheduler.AppConstrants.AUTHORITY_NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.DEFAULT_EDITOR;
import static com.digi.unitouch.emailScheduler.AppConstrants.DUE_DATE;
import static com.digi.unitouch.emailScheduler.AppConstrants.FIRST_NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.ISSUE_DET;
import static com.digi.unitouch.emailScheduler.AppConstrants.JOURNAL;
import static com.digi.unitouch.emailScheduler.AppConstrants.JOURNAL_NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.LAST_NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.MANUSCRIPTID;
import static com.digi.unitouch.emailScheduler.AppConstrants.NAME;
import static com.digi.unitouch.emailScheduler.AppConstrants.TITLE;
import static com.digi.unitouch.emailScheduler.AppConstrants.URL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.emailScheduler.EmailTriggerVo;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.EmailScheduler;
import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.IssueEmailTrigger;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.ArticleRepo;
import com.digi.unitouch.repository.EmailSchedulerRepo;
import com.digi.unitouch.repository.EmailTriggerRepo;
import com.digi.unitouch.repository.IssueEmailTriggerRepo;
import com.digi.unitouch.repository.SchedularRepo;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.util.SendEmailUtility;


@Service
@Transactional
public class EmailTriggerServiceImpl implements EmailTriggerService {
	@Autowired
	EmailTriggerRepo emailTriggerRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ArticleRepo articleRepo;

	@Autowired
	SchedularRepo schedularRepo;

	/* EmailTriggerTemplateUtils emailTriggerTemplateUtils; */

	@Autowired
	EmailSchedulerRepo emailSchedulerRepo;
	
	@Autowired
	IssueEmailTriggerRepo issueEmailTriggerRepo;

	@Override
	public void saveIssueEmailTrigger(IssueEmailTrigger issueemailTrigger) {
		issueEmailTriggerRepo.save(issueemailTrigger);
	}

	@Override
	public void save(EmailTrigger emailTrigger) {
		emailTriggerRepo.save(emailTrigger);
	}
	
	@Override
	public EmailTrigger findByAJWT(int aid, int taskID) {
		// TODO Auto-generated method stub
		return emailTriggerRepo.findByAJWT(aid, taskID);
	}

	@Override
	public void allGetData(List<EmailTrigger> emailTrigger) {
		EmailTrigger taskEmailDetails = null;
		String toMailID = null;
		String mailSubject = null;
		String mailBody = null;
		String finishbody = null;
		String finishsubject = null;
		String replybody = null;
		String replysubject = null;
		String fromEmail = null;
		String fromPassword = null;
		String nextMailID = null;
		String preMailID = null;
		Users userDetail = null;
		Users userDetailcc = null;
		Users userDetailbcc = null;
		Users userDetailnextUser = null;
		Users userDetailpreUser = null;
		
		try {
			for (int i = 0; i < emailTrigger.size(); i++) {
				taskEmailDetails = emailTriggerRepo.getArticleIdAndTaskId(emailTrigger.get(i).getArticleId(),
						emailTrigger.get(i).getTaskId());
				if (taskEmailDetails != null) {

					fromEmail =taskEmailDetails.getArticle().getJournals().getFromEmail();
					System.out.println("FromEmail :"+fromEmail);
					
					fromPassword =taskEmailDetails.getArticle().getJournals().getFromPassword();
					System.out.println("FromPassword :"+fromPassword);
					
					userDetail = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getEtTo()));
					if (userDetail != null) {
						toMailID = userDetail.getUsername();
					}
					userDetailnextUser = userRepo.getToUserName(taskEmailDetails.getNextUserid());
					if (userDetailnextUser != null) {
						nextMailID = userDetailnextUser.getUsername();
					}
					userDetailpreUser = userRepo.getToUserName(taskEmailDetails.getPreUserid());
					if (userDetailpreUser != null) {
						preMailID = userDetailpreUser.getUsername();
					}

					mailSubject = getAllDataSubject(taskEmailDetails);
					mailBody = getAllDataBody(taskEmailDetails);
					finishbody= getAllFinishDataBody(taskEmailDetails);
					finishsubject= getAllFinishDataSubject(taskEmailDetails);
					replybody= getAllReplyDataBody(taskEmailDetails);
					replysubject= getAllReplyDataSubject(taskEmailDetails);

					emailTriggerRepo.updateisactive(taskEmailDetails.getArticleId(), taskEmailDetails.getTaskId());
					
					EmailScheduler emailScheduler = new EmailScheduler();

					emailScheduler.setArticleId(taskEmailDetails.getArticleId());
					emailScheduler.setTaskId(taskEmailDetails.getTaskId());
					emailScheduler.setEtTo(userDetail.getUsername());
					if(userDetailnextUser != null) {
					  emailScheduler.setNextUser(userDetailnextUser.getUsername());
					}
					if(userDetailpreUser!= null ) {
					  emailScheduler.setPreUser(userDetailpreUser.getUsername());
					}
					
					emailScheduler.setEtBody(mailBody);
					emailScheduler.setEtSubject(mailSubject);
					if(taskEmailDetails.getNextTaskid() != null) {
					  emailScheduler.setNextTaskid(taskEmailDetails.getNextTaskid().toString());
					}
					if(taskEmailDetails.getPreTaskid() != null) {
					  emailScheduler.setPreTaskid(taskEmailDetails.getPreTaskid().toString());
					}
					if(userDetailnextUser != null) {
					  emailScheduler.setNextUserid(userDetailnextUser.getUsername());
					}
					if(userDetailpreUser != null) {
					  emailScheduler.setPreUserid(userDetailpreUser.getUsername());
					}
					if(finishbody != null) {
					  emailScheduler.setFinishBody(finishbody);
					}
					if(finishsubject != null) {
					  emailScheduler.setFinishSubject(finishsubject);
					}
					if(replybody != null) {
					  emailScheduler.setReplyBody(replybody);
					}
					if(replysubject != null) {
					  emailScheduler.setReplySubject(replysubject);
					}
					emailScheduler.setCreatedAt(new Date());
					emailSchedulerRepo.save(emailScheduler);
					System.out.println(emailScheduler);
					
					if(userDetail != null) {
						SendEmailUtility.sendEmailUpdateEmailScheduler(toMailID, mailSubject, mailBody,fromEmail);
					}
					
					if(userDetailnextUser != null &&  finishsubject != null && finishbody != null) {
						SendEmailUtility.sendEmailUpdateEmailFinishScheduler(nextMailID, finishsubject,finishbody,fromEmail);
					}
					
//	                if(userDetailpreUser != null && replysubject != null && replybody != null) {
//	                	SendEmailUtility.sendEmailUpdateEmailReplyScheduler(preMailID, replysubject, replybody,fromEmail);
//	                }
	              
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	return null;
	}

//	@Override
//	public String allGetData(List<EmailTrigger> emailTrigger) {
//		EmailTrigger taskEmailDetails = null;
//		String toMailID = null;
//		String mailSubject = null;
//		String mailBody = null;
//		String finishbody = null;
//		String finishsubject = null;
//		String replybody = null;
//		String replysubject = null;
//		String fromEmail = null;
//		String fromPassword = null;
//		String nextMailID = null;
//		String preMailID = null;
//		Users userDetail = null;
//		Users userDetailcc = null;
//		Users userDetailbcc = null;
//		Users userDetailnextUser = null;
//		Users userDetailpreUser = null;
//
//		try {
//			for (int i = 0; i < emailTrigger.size(); i++) {
//				taskEmailDetails = emailTriggerRepo.getArticleIdAndTaskId(emailTrigger.get(i).getArticleId(),
//						emailTrigger.get(i).getTaskId());
//				if (taskEmailDetails != null) {
//
//					fromEmail = taskEmailDetails.getArticle().getJournals().getFromEmail();
//					System.out.println("FromEmail :" + fromEmail);
//
//					fromPassword = taskEmailDetails.getArticle().getJournals().getFromPassword();
//					System.out.println("FromPassword :" + fromPassword);
//
//					userDetail = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getEtTo()));
//					if (userDetail != null) {
//						toMailID = userDetail.getUsername();
//					}
//					userDetailnextUser = userRepo.getToUserName(taskEmailDetails.getNextUserid());
//					if (userDetailnextUser != null) {
//						nextMailID = userDetailnextUser.getUsername();
//					}
//					userDetailpreUser = userRepo.getToUserName(taskEmailDetails.getPreUserid());
//					if (userDetailpreUser != null) {
//						preMailID = userDetailpreUser.getUsername();
//					}
//
//					mailSubject = getAllDataSubject(taskEmailDetails);
//					mailBody = getAllDataBody(taskEmailDetails);
//					finishbody = getAllFinishDataBody(taskEmailDetails);
//					finishsubject = getAllFinishDataSubject(taskEmailDetails);
//					replybody = getAllReplyDataBody(taskEmailDetails);
//					replysubject = getAllReplyDataSubject(taskEmailDetails);
//
//					EmailScheduler emailScheduler = new EmailScheduler();
//
//					emailScheduler.setArticleId(taskEmailDetails.getArticleId());
//					emailScheduler.setTaskId(taskEmailDetails.getTaskId());
//					emailScheduler.setEtTo(userDetail.getUsername());
//					if (userDetailnextUser != null) {
//						emailScheduler.setNextUser(userDetailnextUser.getUsername());
//					}
//					if (userDetailpreUser != null) {
//						emailScheduler.setPreUser(userDetailpreUser.getUsername());
//					}
//
//					emailScheduler.setEtBody(mailBody);
//					emailScheduler.setEtSubject(mailSubject);
//					if (taskEmailDetails.getNextTaskid() != null) {
//						emailScheduler.setNextTaskid(taskEmailDetails.getNextTaskid().toString());
//					}
//					if (taskEmailDetails.getPreTaskid() != null) {
//						emailScheduler.setPreTaskid(taskEmailDetails.getPreTaskid().toString());
//					}
//					if (userDetailnextUser != null) {
//						emailScheduler.setNextUserid(userDetailnextUser.getUsername());
//					}
//					if (userDetailpreUser != null) {
//						emailScheduler.setPreUserid(userDetailpreUser.getUsername());
//					}
//					if (finishbody != null) {
//						emailScheduler.setFinishBody(finishbody);
//					}
//					if (finishsubject != null) {
//						emailScheduler.setFinishSubject(finishsubject);
//					}
//					if (replybody != null) {
//						emailScheduler.setReplyBody(replybody);
//					}
//					if (replysubject != null) {
//						emailScheduler.setReplySubject(replysubject);
//					}
//					emailScheduler.setCreatedAt(new Date());
//					emailSchedulerRepo.save(emailScheduler);
//
//					emailTriggerRepo.updateisactive(taskEmailDetails.getArticleId(), taskEmailDetails.getTaskId());
//
//					if (userDetail != null) {
//						EmailEngineUnitouch.sendEmailUpdateEmailScheduler(toMailID, mailSubject, mailBody, fromEmail,
//								fromPassword);
//					}
//
//					if (userDetailnextUser != null) {
//						EmailEngineUnitouch.sendEmailUpdateEmailFinishScheduler(nextMailID, finishsubject, finishbody,
//								fromEmail, fromPassword);
//					}
//
//					if (userDetailpreUser != null) {
//						EmailEngineUnitouch.sendEmailUpdateEmailReplyScheduler(preMailID, replysubject, replybody,
//								fromEmail, fromPassword);
//					}
//
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public String getAllDataBody(EmailTrigger taskEmailDetails) {
		String body = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());

		Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getEtTo()));
		emailTriggerVo.setFirstName(toDetails.getFirstName());
		emailTriggerVo.setLastName(toDetails.getLastName());

		emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());

		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getTaskId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(ts.getSch_end_time());
		System.out.println(dueDate);
		emailTriggerVo.setDueDate(dueDate);

		String msgbody = taskEmailDetails.getEtBody();
		//msgbody = msgbody.replaceAll("\\<.*?\\>", "");
		// String text = Jsoup.parse(strHtml).text();

		body = reModifiedMailTemplateBody(msgbody, emailTriggerVo);
		return body;
	}

	private String reModifiedMailTemplateBody(String etBody, EmailTriggerVo emailTriggerVo) {
		String body = etBody;
		if(body!=null) {
		
		if (body.contains(MANUSCRIPTID) && emailTriggerVo.getManuscriptId() != null)
			body = body.replace(MANUSCRIPTID, emailTriggerVo.getManuscriptId());
		else
			body = body.replace(MANUSCRIPTID, "");

		if (body.contains(FIRST_NAME) && emailTriggerVo.getFirstName() != null)
			body = body.replace(FIRST_NAME, emailTriggerVo.getFirstName());
		else
			body = body.replace(FIRST_NAME, "");

		if (body.contains(LAST_NAME) && emailTriggerVo.getLastName() != null)
			body = body.replace(LAST_NAME, emailTriggerVo.getLastName());
		else
			body = body.replace(LAST_NAME, "");

		if (body.contains(ARTICLE_TITLE) && emailTriggerVo.getArticleTitle() != null)
			body = body.replace(ARTICLE_TITLE, emailTriggerVo.getArticleTitle());
		else
			body = body.replace(ARTICLE_TITLE, "");

		if (body.contains(TITLE) && emailTriggerVo.getArticleTitle() != null)
			body = body.replace(TITLE, emailTriggerVo.getArticleTitle());
		else
			body = body.replace(TITLE, "");

		if (body.contains(JOURNAL_NAME) && emailTriggerVo.getJournalName() != null)
			body = body.replace(JOURNAL_NAME, emailTriggerVo.getJournalName());
		else
			body = body.replace(JOURNAL_NAME, "");

		if (body.contains(URL) && emailTriggerVo.getUrl() != null)
			body = body.replace(URL, emailTriggerVo.getUrl());
		else
			body = body.replace(URL, "");

		if (body.contains(ISSUE_DET) && emailTriggerVo.getIssuetld() != null)
			body = body.replace(ISSUE_DET, emailTriggerVo.getIssuetld());
		else
			body = body.replace(ISSUE_DET, "");

		if (body.contains(DEFAULT_EDITOR) && emailTriggerVo.getDefault_editor() != null)
			body = body.replace(DEFAULT_EDITOR, emailTriggerVo.getDefault_editor());
		else
			body = body.replace(DEFAULT_EDITOR, "");

		if (body.contains(NAME) && emailTriggerVo.getFirstName() != null)
			body = body.replace(NAME, emailTriggerVo.getFirstName() + " " + emailTriggerVo.getLastName());
		else
			body = body.replace(NAME, "");

		if (body.contains(DUE_DATE) && emailTriggerVo.getDueDate() != null)
			body = body.replace(DUE_DATE, emailTriggerVo.getDueDate());
		else
			body = body.replace(DUE_DATE, "");

		if (body.contains(AUTHORITY_NAME) && emailTriggerVo.getAuthorityName() != null)
			body = body.replace(AUTHORITY_NAME, emailTriggerVo.getAuthorityName());
		else
			body = body.replace(AUTHORITY_NAME, "");

		if (body.contains(JOURNAL) && emailTriggerVo.getJournalName() != null)
			body = body.replace(JOURNAL, emailTriggerVo.getJournalName());
		else
			body = body.replace(JOURNAL, "");

		}else {
			return "";
		}
		return body.toString();
	}

	public String getAllDataSubject(EmailTrigger taskEmailDetails) {
		String subject = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());

		Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getEtTo()));
		emailTriggerVo.setFirstName(toDetails.getFirstName());
		emailTriggerVo.setLastName(toDetails.getLastName());

		emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());

		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getTaskId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(ts.getSch_end_time());
		System.out.println(dueDate);
		emailTriggerVo.setDueDate(dueDate);

		subject = reModifiedMailTemplateSubject(taskEmailDetails.getEtSubject(), emailTriggerVo);

		return subject;
	}

	private String reModifiedMailTemplateSubject(String etSubject, EmailTriggerVo emailTriggerVo) {

		String body = etSubject;
		if (body != null) {
			if (body.contains(MANUSCRIPTID) && emailTriggerVo.getManuscriptId() != null)
				body = body.replace(MANUSCRIPTID, emailTriggerVo.getManuscriptId());
			else
				body = body.replace(MANUSCRIPTID, "");

			if (body.contains(FIRST_NAME) && emailTriggerVo.getFirstName() != null)
				body = body.replace(FIRST_NAME, emailTriggerVo.getFirstName());
			else
				body = body.replace(FIRST_NAME, "");

			if (body.contains(LAST_NAME) && emailTriggerVo.getLastName() != null)
				body = body.replace(LAST_NAME, emailTriggerVo.getLastName());
			else
				body = body.replace(LAST_NAME, "");

			if (body.contains(ARTICLE_TITLE) && emailTriggerVo.getArticleTitle() != null)
				body = body.replace(ARTICLE_TITLE, emailTriggerVo.getArticleTitle());
			else
				body = body.replace(ARTICLE_TITLE, "");

			if (body.contains(TITLE) && emailTriggerVo.getArticleTitle() != null)
				body = body.replace(TITLE, emailTriggerVo.getArticleTitle());
			else
				body = body.replace(TITLE, "");

			if (body.contains(JOURNAL_NAME) && emailTriggerVo.getJournalName() != null)
				body = body.replace(JOURNAL_NAME, emailTriggerVo.getJournalName());
			else
				body = body.replace(JOURNAL_NAME, "");

			if (body.contains(URL) && emailTriggerVo.getUrl() != null)
				body = body.replace(URL, emailTriggerVo.getUrl());
			else
				body = body.replace(URL, "");

			if (body.contains(ISSUE_DET) && emailTriggerVo.getIssuetld() != null)
				body = body.replace(ISSUE_DET, emailTriggerVo.getIssuetld());
			else
				body = body.replace(ISSUE_DET, "");

			if (body.contains(DEFAULT_EDITOR) && emailTriggerVo.getDefault_editor() != null)
				body = body.replace(DEFAULT_EDITOR, emailTriggerVo.getDefault_editor());
			else
				body = body.replace(DEFAULT_EDITOR, "");

			if (body.contains(NAME) && emailTriggerVo.getFirstName() != null)
				body = body.replace(NAME, emailTriggerVo.getFirstName() + " " + emailTriggerVo.getLastName());
			else
				body = body.replace(NAME, "");

			if (body.contains(DUE_DATE) && emailTriggerVo.getDueDate() != null)
				body = body.replace(DUE_DATE, emailTriggerVo.getDueDate());
			else
				body = body.replace(DUE_DATE, "");

			if (body.contains(AUTHORITY_NAME) && emailTriggerVo.getAuthorityName() != null)
				body = body.replace(AUTHORITY_NAME, emailTriggerVo.getAuthorityName());
			else
				body = body.replace(AUTHORITY_NAME, "");

			if (body.contains(JOURNAL) && emailTriggerVo.getJournalName() != null)
				body = body.replace(JOURNAL, emailTriggerVo.getJournalName());
			else
				body = body.replace(JOURNAL, "");

		} else {
			return "";
		}
		return body.toString();

	}

	public String getAllFinishDataBody(EmailTrigger taskEmailDetails) {
		String body = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());

		Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getNextUser()));
		emailTriggerVo.setFirstName(toDetails.getFirstName());
		emailTriggerVo.setLastName(toDetails.getLastName());

		emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());

		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getTaskId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(ts.getSch_end_time());
		System.out.println(dueDate);
		emailTriggerVo.setDueDate(dueDate);

		String msgbody = taskEmailDetails.getFinishBody();
		//msgbody = msgbody.replaceAll("\\<.*?\\>", "");

		body = reModifiedMailTemplateBody(msgbody, emailTriggerVo);
		return body;
	}

	public String getAllReplyDataBody(EmailTrigger taskEmailDetails) {
		String body = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());

		if (taskEmailDetails.getPreUser() != null) {
			Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getPreUser()));
			if (toDetails != null) {
				emailTriggerVo.setFirstName(toDetails.getFirstName());
				emailTriggerVo.setLastName(toDetails.getLastName());

				emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());
			}
		}
		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getPreTaskid());
		if (ts != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dueDate = dateFormat.format(ts.getSch_end_time());

			System.out.println(dueDate);
			emailTriggerVo.setDueDate(dueDate);
		}
		String msgbody = taskEmailDetails.getReplyBody();
	//	msgbody = msgbody.replaceAll("\\<.*?\\>", "");

		if (msgbody != null) {
			body = reModifiedMailTemplateBody(msgbody, emailTriggerVo);
		}
		return body;
	}

	public String getAllFinishDataSubject(EmailTrigger taskEmailDetails) {
		String subject = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());
		if (taskEmailDetails.getNextUser() != null) {
			Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getNextUser()));
			if (toDetails != null) {
				emailTriggerVo.setFirstName(toDetails.getFirstName());
				emailTriggerVo.setLastName(toDetails.getLastName());
				emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());
			}
		}
		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getNextTaskid());
		if (ts != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dueDate = dateFormat.format(ts.getSch_end_time());
			System.out.println(dueDate);
			emailTriggerVo.setDueDate(dueDate);
		}
		subject = reModifiedMailTemplateSubject(taskEmailDetails.getFinishSubject(), emailTriggerVo);

		return subject;
	}

	public String getAllReplyDataSubject(EmailTrigger taskEmailDetails) {
		String subject = null;
		ArticleDetail adetails = null;
		EmailTriggerVo emailTriggerVo = new EmailTriggerVo();

		adetails = articleRepo.findArticleDetailBy(taskEmailDetails.getArticleId());
		emailTriggerVo.setArticleTitle(adetails.getArticle_title());
		emailTriggerVo.setManuscriptId(adetails.getAid());
		emailTriggerVo.setJournalName(adetails.getJournals().getJournalName());

		if (taskEmailDetails.getPreUser() != null) {
			Users toDetails = userRepo.getToUserName(Integer.parseInt(taskEmailDetails.getPreUser()));
			if (toDetails != null) {
				emailTriggerVo.setFirstName(toDetails.getFirstName());
				emailTriggerVo.setLastName(toDetails.getLastName());
				emailTriggerVo.setName(toDetails.getFirstName() + " " + toDetails.getLastName());
			}
		}
		TaskScheduler ts = schedularRepo.getrunId(taskEmailDetails.getArticleId(), taskEmailDetails.getPreTaskid());
		if (ts != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dueDate = dateFormat.format(ts.getSch_end_time());
			System.out.println(dueDate);
			emailTriggerVo.setDueDate(dueDate);
		}

		subject = reModifiedMailTemplateSubject(taskEmailDetails.getReplySubject(), emailTriggerVo);

		return subject;
	}

}
