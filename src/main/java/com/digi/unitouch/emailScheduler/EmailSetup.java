package com.digi.unitouch.emailScheduler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.service.EmailJournalWorkflowService;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.util.LoggerClass;
@Component
public class EmailSetup extends LoggerClass {
	@Autowired
	EmailJournalWorkflowService emailJournalWorkflowService;
	@Autowired
	EmailTriggerService emailTriggerService;

	public boolean emailSetupforDone(Integer aid, Integer JrID, Integer workFlowID, Integer taskID) {
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, taskID);
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(aid);
			trigger.setTaskId(taskID);
			trigger.setEtSubject("" + emailJournalWorkflow.getEmailTemp().getToSubject());
			trigger.setEtBody("" + emailJournalWorkflow.getEmailTemp().getEditorData());
			trigger.setEtTo(emailJournalWorkflow.getTo().toString());
			trigger.setEtBcc("" + emailJournalWorkflow.getBcc());
			trigger.setEtCc("" + emailJournalWorkflow.getCc());
			if (emailJournalWorkflow.getEmailTemp().getFinishBody() != null) {
				trigger.setFinishBody("" + emailJournalWorkflow.getEmailTemp().getFinishBody());
			}
			if (emailJournalWorkflow.getEmailTemp().getFinishSubject() != null) {
				trigger.setFinishSubject("" + emailJournalWorkflow.getEmailTemp().getFinishSubject());
			}
			if (emailJournalWorkflow.getEmailTemp().getReplySubject() != null) {
				trigger.setReplySubject("" + emailJournalWorkflow.getEmailTemp().getReplySubject());
			}
			if (emailJournalWorkflow.getEmailTemp().getReplyBody() != null) {
				trigger.setReplyBody("" + emailJournalWorkflow.getEmailTemp().getReplyBody());
			}
			if (emailJournalWorkflow.getNextUserid() != null) {
				trigger.setNextUser(emailJournalWorkflow.getNextUserid().toString());
			}
			if (emailJournalWorkflow.getPreUserid() != null) {
				trigger.setPreUser(emailJournalWorkflow.getPreUserid().toString());
			}
			if (emailJournalWorkflow.getPreTaskid() != null) {
				trigger.setPreTaskid(emailJournalWorkflow.getPreTaskid());
			}
			if (emailJournalWorkflow.getNextTaskid() != null) {
				trigger.setNextTaskid(emailJournalWorkflow.getNextTaskid());
			}
			if (emailJournalWorkflow.getPreUserid() != null) {
				trigger.setPreUserid(emailJournalWorkflow.getPreUserid());
			}
			if (emailJournalWorkflow.getNextUserid() != null) {
				trigger.setNextUserid(emailJournalWorkflow.getNextUserid());
			}
			trigger.setIsActive(0);
			trigger.setCreatedAt(new Date());
			trigger.setCreatedBy("System");
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");

		}
		return true;
	}

}
