package com.digi.unitouch.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digi.unitouch.emun.EmailEnum;
import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.AuthorDataApiModel;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.operatingSystem.OperatingSystem;
import com.digi.unitouch.repository.AuthorArticleRepo;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.EmailJournalWorkflowService;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.vo.AuthorCopyright;
import com.digi.unitouch.vo.AuthorDataApiVo;

@RestController
public class AuthorRestController {
	@Autowired
	ArticleService articleService;

	@Autowired
	AuthorArticleRepo authorArticleRepo;

	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	EmailJournalWorkflowService emailJournalWorkflowService;
	@Autowired
	EmailTriggerService emailTriggerService;
	@Autowired
	FileVersionService fileVersionService;
	@Autowired
	TaskService taskService;
	@Value("${journal.path}")
	private String UPLOAD_FOLDER;

	@Value("${uniprr.Api}")
	private String uniprrApi;

	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;
	@Autowired
	AuthorArticleService authorArticleService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping("taskComplete")
	public ResponseEntity<?> TaskDone(@RequestBody AuthorDataApiVo author) {
		log.info("taskComplete----------->" + author.toString());
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		TaskScheduler taskscheduler = taskService.findtaskDetailById(Integer.parseInt(author.getManuscriptTaskId()));
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskscheduler.getTask_id(),
				taskscheduler.getWorkflow_id());
		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
		int nextTaskSequenceP = (workflowTaskSeq.getSequence() - 1);
		// int nextTaskSequencePP = (workflowTaskSeq.getSequence() - 2);
		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence,
				taskscheduler.getWorkflow_id());
		WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(nextTaskSequenceP,
				taskscheduler.getWorkflow_id());
		// WorkflowTaskSeq workflowTaskSequPP =
		// workflowTaskService.getNextTaskIdBy(nextTaskSequencePP,
		// taskscheduler.getWorkflow_id());

		log.info("workflowTaskSequ----------->" + workflowTaskSequ.toString());
		int nextTaskID = workflowTaskSequ.getTaskId();
		ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby(
				(taskscheduler.getWorkflow_id()), (taskscheduler.getArticleDetail().getJournalId()),
				(workflowTaskSequ.getRole().getRoleID()), nextTaskID);
		log.info("manageJournalAuthor------->" + manageJournalAuthor);
		CurrentArticleStatus currentArticleStatus = articleService
				.findCurrentArticleStatusBy(taskscheduler.getTask_id(), taskscheduler.getArticle_id());
		currentArticleStatus.setTask_id(nextTaskID);
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus);
		taskscheduler.setTask_status("Completed");
		taskscheduler.setTask_est_time_end(new Date());
		taskService.saveTaskSchedulerStatus(taskscheduler);
		log.info("taskscheduler---------------->" + taskscheduler);
		TaskScheduler taskPoolUpdate = taskService.getRunId(taskscheduler.getArticle_id(),
				workflowTaskSequ.getTaskId());
		taskPoolUpdate.setTask_status("Yet-to-Start");
		taskPoolUpdate.setUser_id(manageJournalAuthor.getUser_id());
		taskPoolUpdate.setTask_est_time_from(new Date());
		if (author.getIsRecheck().equalsIgnoreCase("AuthorCheck")) {
			taskPoolUpdate.setComments("");
		} else {
			taskPoolUpdate.setComments("No change/Approved - " + author.getNoChangeApproved()
					+ " \n , Do you wish to recheck the correct proofs - " + author.getIsRecheck());
		}
		taskService.saveTaskSchedulerStatus(taskPoolUpdate);

		if (author.getNoChangeApproved().equalsIgnoreCase("YES")) {
			Path TO = Paths.get(UPLOAD_FOLDER + File.separator
					+ taskscheduler.getArticleDetail().getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ taskscheduler.getArticleDetail().getArticle_doi() + File.separator
					+ taskscheduler.getTask().getTaskName().replace(' ', '_'));
			Path From = Paths.get(UPLOAD_FOLDER + File.separator
					+ taskscheduler.getArticleDetail().getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ taskscheduler.getArticleDetail().getArticle_doi() + File.separator
					+ workflowTaskSequP.getTask().getTaskName().replace(' ', '_'));
			System.out.println(TO.toString() + "\n" + From.toString());
			File target = new File(From.toString());
			String fileName = "";
			File[] listOfFiles = target.listFiles();
			if (listOfFiles != null) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						log.debug("File " + listOfFiles[i].getName());
						fileName = listOfFiles[i].getName();
						System.out.println(fileName);
						Path whereTOStart = Paths.get(From + File.separator + fileName);
						Path whereTOEnd = Paths.get(TO + File.separator + fileName);
						try {
							Path temp = Files.copy(whereTOStart, whereTOEnd, StandardCopyOption.REPLACE_EXISTING);
							log.info("temp------------>" + temp);
						} catch (IOException e) {

							e.printStackTrace();
						}
					} else if (listOfFiles[i].isDirectory()) {
						log.debug("Directory " + listOfFiles[i].getName());
					}
				}
			}
		}
		String authorname = "";
		List<AuthorArticleDetails> ar = authorArticleService.fileByArticleId(taskscheduler.getArticle_id());
		for (AuthorArticleDetails authorArticleDetails : ar) {
			if (authorArticleDetails.getIs_corresponding().equalsIgnoreCase("Y")
					|| authorArticleDetails.getIs_corresponding().equalsIgnoreCase("YES")
					|| authorArticleDetails.getIs_corresponding().equalsIgnoreCase("Primary")) {
				authorname = authorArticleDetails.getTitle() + " " + authorArticleDetails.getfName() + " "
						+ authorArticleDetails.getmName() + " " + authorArticleDetails.getlName();
			}
		}
		ArticleComment ac = new ArticleComment();
		ac.setAid(taskscheduler.getArticle_id());
		ac.setTaskid(taskscheduler.getTask_id());
		String comm = "";
		if (author.getComment().endsWith("Recheck : AuthorCheck")) {
			comm = author.getComment().replace("Recheck : AuthorCheck", " ");
		} else {
			comm = author.getComment();
		}
		ac.setComment(comm);
		ac.setJid(taskscheduler.getArticleDetail().getJournalId());
		ac.setCommentDate(new Date());
		ac.setRoleid(workflowTaskSeq.getRoleId());
		ac.setUserName(authorname);
		articleService.save(ac);
		log.info("taskPoolUpdate------------->" + taskPoolUpdate);
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(
				taskscheduler.getArticleDetail().getJournalId(), taskscheduler.getWorkflow_id(),
				taskscheduler.getTask_id());

		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(taskscheduler.getArticle_id());
			trigger.setTaskId(taskscheduler.getTask_id());
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
			trigger.setCreatedBy(name);
			emailTriggerService.save(trigger);
		} else {
			log.info("Email template is not set");
			System.out.println("Email template is not set");
		}
		Map<String, String> file = author.getFilePathMap();
		for (Map.Entry<String, String> entry : file.entrySet()) {

			FileVersion fileVersion = new FileVersion();
			fileVersion.setArticleId(taskscheduler.getArticle_id());
			fileVersion.setFileName(entry.getKey());
			fileVersion.setSize("" + "bytes");
			fileVersion.setTaskId(taskscheduler.getTask_id());
			fileVersion.setFileType("");
			fileVersion.setJournalId(taskscheduler.getArticleDetail().getJournalId());
			fileVersion.setFilePath(entry.getValue());
			fileVersion.setFileVersion(1);
			fileVersion.setCreated_by(emailJournalWorkflow.getTo());
			fileVersion.setCreatedAt(new Date());
			fileVersionService.saveFileVersion(fileVersion);

			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	@PostMapping("updateCopyright")
	public ResponseEntity<?> updateCopyRight(@RequestBody AuthorCopyright authorCopyright) {
		log.info("AuthorCopyright--->" + authorCopyright.toString());
		ArticleDetail articleDeatail = articleService.findByAid(authorCopyright.getManuScriptId());
		AuthorArticleDetails authorArticle = authorArticleRepo
				.getByArticleIdAndAuthorEmail(articleDeatail.getArticle_id(), authorCopyright.getAuthorEmail());
		authorArticle.setCopyright(authorCopyright.getCopyrightStatus());
		authorArticleRepo.save(authorArticle);
		log.info("AuthorCopyright update " + authorCopyright.getAuthorEmail());
		log.info("AuthorCopyright update " + authorCopyright.getCopyrightStatus() + "\r\nAuthorCopyright-->"
				+ authorCopyright.getManuScriptId());
		return new ResponseEntity<>(authorCopyright, HttpStatus.OK);
	}

	public AuthorDataApiModel setCompleteddata(String manuScriptId, String manuscriptCode, String inputFile,
			String outputFile, String manuscriptTaskId, String fileType, String assignReason) {

		log.info("manuScriptId------------------->" + manuScriptId);
		log.info("manuScriptId------------------->" + manuscriptCode);
		log.info("inputFile---------------------->" + inputFile);
		log.info("outputFile--------------------->" + outputFile);
		log.info("articleTaskID------------------->" + manuscriptTaskId);
		log.info("assignReason Comment------------------->" + assignReason);
		// http://54.214.210.6/uniprrapi/journal/getByJournalCode
		AuthorDataApiModel apimodel = new AuthorDataApiModel();
		// apimodel.setAadId(1);
		apimodel.setManuscriptCode(manuScriptId);
		apimodel.setManuscriptStatusId(manuscriptCode);
		apimodel.setInputFile(inputFile);
		apimodel.setOutputFile(outputFile);
		apimodel.setManuscriptTaskId(manuscriptTaskId);
		apimodel.setFileType(fileType);
		apimodel.setInfoTime(new Date());
		apimodel.setCommentFromProduction(assignReason);
		String uri = "http://54.214.210.6/uniprroneapi/manuScript/updateUrl";
		// String uri = "http://54.214.210.6/uniprrapi/manuScript/updateUrl"; //test
		// server
		apimodel.setApiUrl(uri);
		log.info("uri-->" + uri);
		RestTemplate restTemplate = new RestTemplate();
		AuthorDataApiVo authorApi = null;
		HttpEntity<AuthorDataApiVo> request = new HttpEntity<>(new AuthorDataApiVo(manuScriptId, manuscriptCode,
				inputFile, outputFile, manuscriptTaskId, fileType, assignReason));
		// HttpEntity<ArticleDataApi> request = new HttpEntity<>(api);
		try {
			authorApi = restTemplate.postForObject(uri, request, AuthorDataApiVo.class);
			log.info("--------------->result we got from uniprr---->" + authorApi);
			OperatingSystem.runScrit();// file permission
			apimodel.setResponse_code(200 + "");
			apimodel.setTransmit(EmailEnum.sent);

			return apimodel;
		} catch (Exception e) {
			log.info("Api got Exception---------->" + e.getMessage());
			apimodel.setResponse_code(424 + "");
			apimodel.setTransmit(EmailEnum.failed);

			e.printStackTrace();
			return apimodel;
		}

	}

	@Scheduled(fixedRate = 500000)
	public void autoFailedAuthorScheduled() {
		log.info("----------------------------> Author api runing <--------------------------");
		List<AuthorDataApiModel> autherr = articleService.findbyResponseCodeAndTransmit("200", EmailEnum.failed);
		for (AuthorDataApiModel authorDataApiModel : autherr) {

			AuthorRestController arc = new AuthorRestController();
			AuthorDataApiModel apicall = arc.setCompleteddata(authorDataApiModel.getManuscriptCode(),
					authorDataApiModel.getManuscriptStatusId(), authorDataApiModel.getInputFile(),
					authorDataApiModel.getOutputFile(), authorDataApiModel.getManuscriptTaskId(),
					authorDataApiModel.getFileType(), authorDataApiModel.getCommentFromProduction());
			apicall.setAadId(authorDataApiModel.getAadId());
			log.info("----------------------------> Author api runing inprog<--------------------------");
			if (apicall.getTransmit().equalsIgnoreCase(EmailEnum.sent)) {
				articleService.saveAuthorAPIData(apicall);
			} else {
				articleService.saveAuthorAPIData(apicall);
			}
		}
		log.info("----------------------------> Author api runing END <--------------------------");
	}

//	@PostMapping("/hiturl")
//	public ResponseEntity<?> callcopy(@RequestBody AuthorCopyright authorCopyright) {
//		boolean flag = false;
//		String uri = "http://44.233.195.95:8080/updateCopyright";
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpEntity<AuthorCopyright> request = new HttpEntity<>(authorCopyright);
//
//		try {
//			AuthorCopyright copyRightVOData = restTemplate.postForObject(uri, request, AuthorCopyright.class);
//			System.out.println(copyRightVOData.getManuScriptId());
//
//		} catch (Exception e) {
//			log.info("Api got Exception---------->" + e.getMessage());
//
//		}
//		return new ResponseEntity<>(authorCopyright, HttpStatus.OK);
//	}
}