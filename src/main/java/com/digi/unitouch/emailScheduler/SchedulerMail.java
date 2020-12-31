package com.digi.unitouch.emailScheduler;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.IssueEmailTrigger;
import com.digi.unitouch.repository.EmailTriggerRepo;
import com.digi.unitouch.repository.IssueEmailTriggerRepo;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.service.IssueEmailTriggerService;

@Configuration
@EnableScheduling
@Service
public class SchedulerMail {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmailTriggerRepo emailTriggerrepo;
	
	@Autowired
	EmailTriggerService emailTriggerService;
	
	@Autowired
	IssueEmailTriggerService issueemailTriggerService;
	@Autowired
	IssueEmailTriggerRepo issueEmailTriggerrepo;
	
	@Scheduled(fixedDelay = 70000)
	//@Scheduled(cron = "0 3 * ? * *")
	public void sendMailJob() {
		log.info("---------------->Inside in Scheduler sendMailJob");
		
		List<EmailTrigger> getAllemailSentToData = emailTriggerrepo.getallDetailsMail();
		emailTriggerService.allGetData(getAllemailSentToData);
		 System.gc();
		log.info("----------------->End of Scheduler sendMailJob");
	}
	
	@Scheduled(fixedDelay = 100000)
	public void sendMailJobForIssue() {
		log.info("---------------------->Inside in Scheduler sendMailJobForIssue");
		
		List<IssueEmailTrigger> getAllemailSentToData = issueEmailTriggerrepo.getallDetailsMail();
		issueemailTriggerService.allGetData(getAllemailSentToData);
		 System.gc();
		log.info("------------->End of Scheduler sendMailJobForIssue");
	}

}
