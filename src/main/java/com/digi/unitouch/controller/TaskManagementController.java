package com.digi.unitouch.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.zeroturnaround.zip.ZipUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.ApplicationResponse;
import com.digi.unitouch.RestController.ArticleRestApiUniprr;
import com.digi.unitouch.RestController.AuthorRestController;
import com.digi.unitouch.emun.EmailEnum;
import com.digi.unitouch.emun.EmunAticleStatus;
import com.digi.unitouch.ftp.FtpFileCopy;
import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.ArticleFileVersionReplace;
import com.digi.unitouch.model.ArticleTaskDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.AuthorDataApiModel;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.ErrorProcess;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.model.XmlFilePath;
import com.digi.unitouch.repository.FileVersionRepo;
import com.digi.unitouch.repository.WorkflowTaskRepo;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.ArticleTaskDetailService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.EmailJournalWorkflowService;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.service.ErrorProcessService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.service.XmlFileService;
import com.digi.unitouch.util.FilVerVo;
import com.digi.unitouch.util.FileVersionUpdateR;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.util.SendEmailUtility;
import com.digi.unitouch.vo.ArticleDataApi;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.userDepartmentVo;
import com.google.common.net.HttpHeaders;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskManagementController extends LoggerClass {

	@Autowired
	private Environment env;

	@Value("${journal.path}")
	private String UPLOAD_FOLDER;

	// sftp
	@Value("${sftp.host}")
	private String sftpHost;

	@Value("${sftp.port}")
	private String sftpPort;

	@Value("${sftp.user}")
	private String sftpUser;

	@Value("${sftp.password}")
	private String sftpPassword;

	@Value("${sftp.defaultJournlaPath}")
	private String defaultJournlaPath;

	@Value("${sftp.input}")
	private String input;

	@Value("${sftp.output}")
	private String output;
	
	@Autowired
	ErrorProcessService errorprocessService;
	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	FileVersionService fileServi;
	@Autowired
	TaskService taskService;
	@Autowired
	ArticleTaskDetailService articleTaskDetailService;
	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	JournalService journalService;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	WorkflowTaskRepo wrkrepo;
//	@Autowired
//	DataSenderMQ dataMq;
	@Autowired
	FileVersionService fileVersionService;
	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;
	@Autowired
	XmlFileService xmlFilePath;
	@Autowired
	EmailTriggerService emailTriggerService;
	@Autowired
	EmailJournalWorkflowService emailJournalWorkflowService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	FileVersionRepo fileRepo;
	@Autowired
	AuthorArticleService authorArticleService;
	@Autowired
	FileVersionService fileversionservice;

//	//not requerd
//	@GetMapping("getjournalListForPool")
//	public ModelAndView GroupJournal(ModelMap model) {
//		ArrayList<Integer> jrList = new ArrayList<Integer>();
//		Set<Integer> set = new LinkedHashSet<Integer>();
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		model.put("flag", 0);
//		List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();
//		List<Journal> journalList = new ArrayList<Journal>();
//		List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//		for (Department dept : users.getGroup1()) {
//			userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//	//		mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//		}
//		for (ManageJournalWorkflow manageJourWk : mjw) {
//			taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
//					manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//		}
//		System.out.println(userDepartmentVo.toString());
//		model.put("userDepartment", userDepartmentVo);
//		System.out.println(mjw.toString());
//		model.put("taskManagementVo", taskManagementVo);
//		for (TaskManagementVo taskj : taskManagementVo) {
//			jrList.add(taskj.getJournalId());
//		}
//		set.addAll(jrList); // Clear the list
//		jrList.clear(); // add the elements of set // with no duplicates to the list
//		jrList.addAll(set);// return the list
//		for (Integer mjwq : jrList) {
//			journalList.add(journalService.getjournalbyId(mjwq));
//		}
//		model.put("journalList", journalList);
//		return new ModelAndView("groupTaskForJournal");
//	}
////not requerd
//	@PostMapping("getArticleInPool")
//	public ResponseEntity<ApplicationResponse> getArticleInPool(@RequestBody ManageJournalWorkflow mjwv) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		ApplicationResponse applicatonResponse = new ApplicationResponse();
//		Users users = userService.findUserIdByUserName(name);
//		// List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//		List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();
//		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//		for (Department dept : users.getGroup1()) {
//			// userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//		//	mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//		}
//		LOGGER.info("mjw--->" + mjw);
//		LOGGER.info("tmv--->" + mjwv.toString());
//			taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(mjwv.getWorkflow_id(),
//					mjwv.getJournal_id(), mjw.get(0).getTask_id()));
//		
//		LOGGER.info("taskManagementVo--->" + taskManagementVo);
//		applicatonResponse.setPayload(taskManagementVo);
//		applicatonResponse.setMessage("OK");
//		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
//
//	}
	/* not reqierd */
//	@RequestMapping(value = { "/cregrouptask" })
//	public ModelAndView GroupTaskDetail(ModelMap model) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		model.put("flag", 0);
////	List<TaskManagementVo> taskManagementVo = taskManagementService.getTaskManagementGroupList(users.getUserID());
//		List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();
//		List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//		// int dptId = users.getGroup1().get(0).getDeptID();
//		for (Department dept : users.getGroup1()) {
//			userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//	//		mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//		}
//
//		for (ManageJournalWorkflow manageJourWk : mjw) {
//			taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
//					manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//		}
//		System.out.println(userDepartmentVo.toString());
//		model.put("userDepartment", userDepartmentVo);
//		System.out.println(mjw.toString());
//		model.put("taskManagementVo", taskManagementVo);
//		return new ModelAndView("groupTaskList");
//	}
//

	@RequestMapping(value = { "/assignTask" })
	public ModelAndView assignTaskDetail(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String ArticleTaskId = request.getParameter("selectedArticle");

		try {
			String[] temp = ArticleTaskId.split(",");
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].trim().equalsIgnoreCase("on")) {

				} else {
					ArticleTaskDetail atd = new ArticleTaskDetail();
					int ArtTaskId = Integer.parseInt(temp[i].trim());
					TaskScheduler taskscheduler = taskService.findtaskDetailById(ArtTaskId);
					int userId = Integer.parseInt(request.getParameter("userId"));
					taskscheduler.setUser_id(userId);
					taskscheduler.setTask_status("In Progress");
					taskService.savetakSchedulars(taskscheduler);
					atd.setArticle_task_id(taskscheduler.getArticle_task_id());
					atd.setArticle_id(taskscheduler.getArticle_id());
					atd.setStart_date_time(new Date());
					atd.setUser_id(userId);
					atd.setTask_status("In Progress");
					articleTaskDetailService.saveArticleTaskDetail(atd);
					LOGGER.debug("atd :" + atd.toString());
				}
			}
		} catch (Exception e) {
		} finally {
			ArrayList<Integer> jrList = new ArrayList<Integer>();
			Set<Integer> set = new LinkedHashSet<Integer>();
			// String name =
			// SecurityContextHolder.getContext().getAuthentication().getName();
			// Users users = userService.findUserIdByUserName(name);
			model.put("flag", 0);
			List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();
			List<Journal> journalList = new ArrayList<Journal>();
			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
			for (Department dept : users.getGroup1()) {
				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
				// mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
			}
			for (ManageJournalWorkflow manageJourWk : mjw) {
				taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
						manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
			}
			System.out.println(userDepartmentVo.toString());
			model.put("userDepartment", userDepartmentVo);
			System.out.println(mjw.toString());
			model.put("taskManagementVo", taskManagementVo);
			for (TaskManagementVo taskj : taskManagementVo) {
				jrList.add(taskj.getJournalId());
			}
			set.addAll(jrList); // Clear the list
			jrList.clear(); // add the elements of set // with no duplicates to the list
			jrList.addAll(set);// return the list
			for (Integer mjwq : jrList) {
				journalList.add(journalService.getjournalbyId(mjwq));
			}
			model.put("journalList", journalList);
		}

		return new ModelAndView("groupTaskForJournal");
	}

	@RequestMapping(value = { "/grouptask" })
	public ModelAndView GroupTaskDetailPage(ModelMap model) {

		return new ModelAndView("viewGroupRec");
	}

	@RequestMapping(value = "/view-groupTask", method = RequestMethod.POST)
	public ModelAndView showGroupTask(ModelMap model, HttpServletRequest request, ArticleTaskDetail article) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.debug(name);
		Users users = userService.findUserIdByUserName(name);
		String ID = request.getParameter("article_task_id");
		int id = Integer.parseInt(ID);
		model.put("article_task_id", id);
		String aid = request.getParameter("article_id");
		if (aid == null) {
			aid = request.getParameter("article_id_" + ID);
		}
		// String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		model.put("article_id", Aid);

		String flag = request.getParameter("flag");
		model.put("flag", flag);
		String flagDash = request.getParameter("flagDash");
		model.put("flagDash", flagDash);

		TaskManagementVo taskManagementVo = taskManagementService.findGroupTaskByArticleId(id);
		model.put("taskManagementVo", taskManagementVo);
		taskService.updateTaskSchedulerUserID(id, name);

		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		model.put("taskscheduler", taskscheduler);
		// int runId = taskscheduler.getRunId();
		int taskID = taskscheduler.getTask_id();

		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		int JrID = articleDetail.getJournalId();
		String article_name = articleDetail.getArticle_title();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		model.put("articleDetail", articleDetail);
		model.put("journal", journal);
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		System.out.println("workflowTaskSeq--->" + workflowTaskSeq.toString());
		int currentTaskSequence = workflowTaskSeq.getSequence();
		model.put("roleid", workflowTaskSeq.getRoleId());
		model.put("approval", workflowTaskSeq.getApproval());
		model.put("assignBack", workflowTaskSeq.getAssign_back());
		model.put("skip", workflowTaskSeq.getSkip());
		model.put("fileType", workflowTaskSeq.getFileType());
		model.put("sequence", workflowTaskSeq.getSequence());
		model.put("taskId", workflowTaskSeq.getTaskId());
		List<TaskDetails> task = taskService.getPreviousTaskListBy(workFlowID, currentTaskSequence);
		model.put("TaskList", task);

		List<TaskDetails> nextTasks = taskService.getnextTaskListBy(workFlowID, currentTaskSequence);
		model.put("nextTasks", nextTasks);

		TaskScheduler taskScheduler = taskService.getRunId(Aid, taskID);
		List<ErrorProcess> errorProcess = errorprocessService.ErrorbyTaskId(taskID);
		if (errorProcess.size() == 0) {
			model.put("errorprocess", "NOERROR");

		} else {
			model.put("errorprocess", errorProcess);
			LOGGER.debug(errorProcess.toString());
		}
		LOGGER.debug(Aid + " ::" + taskID);
		List<XmlFilePath> xmlfilepath = xmlFilePath.findByAidAndTaskId(Aid, taskID);
		LOGGER.debug("xml :" + xmlfilepath);
		if (xmlfilepath.size() == 0) {
			model.put("xmlFile", "file path not found");
		} else {
			model.put("xmlFile", xmlfilepath.get(0).getXmlPath());
		}
		model.put("workFlowId", workFlowID);

		TaskDetails taskDetails = taskService.getTaskNameBy(taskID);

		model.put("taskName", taskDetails.getTaskName());
		model.put("taskId", taskID);

		model.put("runValue", taskScheduler.getRunId());

		LOGGER.debug(taskDetails.toString());
		try {
			ArticleTaskDetail articletaskdetail = articleTaskDetailService.findtaskDetailById(id);

			model.put("roleId", users.getRole().getRoleID());
			LOGGER.debug("user :: " + users.toString() + "\n roleid :" + users.getRole().getRoleID());
			if (articletaskdetail == null) {
				ArticleTaskDetail articleTaskDetail = new ArticleTaskDetail();
				articleTaskDetail.setUser_id(users.getUserID());
				articleTaskDetail.setArticle_task_id(id);
				articleTaskDetail.setArticle_id(Aid);
				articleTaskDetail.setTask_status("In Progress");
				articleTaskDetail.setStart_date_time(new Date());
				articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail);
			} else {
			}
		} catch (Exception e) {
			ArticleTaskDetail articleTaskDetail = new ArticleTaskDetail();
			articleTaskDetail.setUser_id(users.getUserID());
			articleTaskDetail.setArticle_task_id(id);
			articleTaskDetail.setArticle_id(Aid);
			articleTaskDetail.setTask_status("In Progress");
			articleTaskDetail.setStart_date_time(new Date());
			articleTaskDetail.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail);
		}
		TaskScheduler taskscheduler1 = taskService.findtaskDetailById(id);
		
		if (!taskscheduler1.getTask_status().equalsIgnoreCase("In Progress")) {
			taskscheduler1.setTask_est_time_from(new Date());
		}
		taskscheduler1.setTask_status("In Progress");
		taskService.saveTaskSchedulerStatus(taskscheduler1);
		LOGGER.debug("In Progress");
		model.put("article_name", article_name);
		List<AuthorArticleDetails> authorArticle = authorArticleService.fileByArticleId(Aid);
		System.out.println(authorArticle.toString());
		model.put("authorDetails", authorArticle);
		List<ArticleComment> articleCommentsList = articleService.getArticleCommentsList(journal.getJournalId(), Aid);
		model.put("commentsList", articleCommentsList);
		List<FileVersion> fileVersions = fileversionservice.findbyAidJid(Aid,JrID);
		model.put("fileVersions", fileVersions);
		System.out.println("View group Task");
		return new ModelAndView("viewGroupTask");
	}

	@RequestMapping(value = { "/mytaskJournal" })
	public ModelAndView mytaskJournal(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<Journal> journalList = new ArrayList<Journal>();
		Set<Integer> set = new LinkedHashSet<Integer>();
		List<Integer> journal = new ArrayList<Integer>();
		model.put("flag", 1);
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		for (TaskManagementVo taskManagement : taskManagementVo) {
			journal.add(taskManagement.getJournalId());
		}
		set.addAll(journal);
		journal.clear();
		journal.addAll(set);
		for (Integer jr : journal) {
			journalList.add(journalService.getjournalbyId(jr));
		}
		System.out.println(journalList);
		System.out.println(taskManagementVo.toString());
		model.put("taskScheduler", taskManagementVo);
		model.put("journalList", journalList);
		return new ModelAndView("myTaskList");
	}

	@PostMapping("getArticleInMytask")
	public ResponseEntity<ApplicationResponse> getArticleInMytask(@RequestBody ManageJournalWorkflow mjwv) {

		ApplicationResponse applicatonResponse = new ApplicationResponse();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		System.out.println(taskManagementVo.toString());
		applicatonResponse.setPayload(taskManagementVo);
		applicatonResponse.setMessage("OK");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@RequestMapping(value = { "/mytask" })
	public ModelAndView myTaskList(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		model.put("flag", 1);
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		System.out.println(taskManagementVo.toString());
		model.put("taskScheduler", taskManagementVo);
		return new ModelAndView("myTaskList");
	}

	@RequestMapping(value = { "/pausetask" })
	public ModelAndView PauseTask(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String ID = request.getParameter("article_task_id");
		int id = Integer.parseInt(ID);
		model.put("article_task_id", id);
		String flag = request.getParameter("flag");
		// int flag = Integer.parseInt(FLAG);

		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		taskscheduler.setTask_status("Paused");
		taskService.saveTaskSchedulerStatus(taskscheduler);
		try {
			ArticleTaskDetail articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
			articleTaskDetail.setTask_status("Paused");
			articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
		} catch (Exception e) {
			ArticleTaskDetail articleTaskDetail = new ArticleTaskDetail();
			articleTaskDetail.setUser_id(users.getUserID());
			articleTaskDetail.setArticle_task_id(id);
			articleTaskDetail.setArticle_id(taskscheduler.getArticle_id());
			articleTaskDetail.setTask_status("Paused");
			articleTaskDetail.setStart_date_time(new Date());
			articleTaskDetail.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail);
		}

//		List<TaskManagementVo> taskManagementVo = taskManagementService.getTaskManagementGroupList(users.getUserID());
//		model.put("taskManagementVo", taskManagementVo);
//		return new ModelAndView("groupTaskList");

		if (flag == "0") {

			List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();

			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
			// int dptId = users.getGroup1().get(0).getDeptID();
			for (Department dept : users.getGroup1()) {
				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
				// mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
			}

			for (ManageJournalWorkflow manageJourWk : mjw) {
				taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
						manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
			}
			System.out.println(userDepartmentVo.toString());
			model.put("userDepartment", userDepartmentVo);
			System.out.println(mjw.toString());
			model.put("taskManagementVo", taskManagementVo);
			return new ModelAndView("groupTaskList");
		} else {
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagementVo);
			return new ModelAndView("myTaskList");

		}
	}

	@RequestMapping(value = "/completeTask", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView CompleteTask(ModelMap model, HttpServletRequest request,
			@RequestParam MultipartFile attachment) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);

		String ID = request.getParameter("article_task_id");
		int id = Integer.parseInt(ID);
		model.put("article_task_id", id);
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		String pageNumber = request.getParameter("page_number");
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		String Priority = request.getParameter("priority");
		LOGGER.debug("Priority" + Priority);
		String queInFilee = request.getParameter("que_in_file");
		Integer queInFile=Integer.parseInt(queInFilee);
		System.out.println(Priority);
		if (Priority == null || Priority == "") {
			articleDetail.setPriority(articleDetail.getPriority());
		} else {
			articleDetail.setPriority(Priority);
		}
		articleService.saveArticle(articleDetail);
		if (pageNumber != null) {

			articleDetail.setArticle_pages(Integer.parseInt(pageNumber));
			articleService.saveArticle(articleDetail);
			LOGGER.info("Url=completeTask, Page Number Update -->" + articleDetail);
		} else {
			LOGGER.info("Url=completeTask, Page Number Not Update -->" + articleDetail);
		}
		// String arID = articleDetail.getAid();
		String flag = request.getParameter("flag");
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		ArticleTaskDetail articleTaskDetail = null;
		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		int taskID = taskscheduler.getTask_id();
		TaskDetails task = taskService.getTaskNameBy(taskID);
		String taskName = task.getTaskName();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		// for current task seq list^|
		// Add Comments
		String assignReason = request.getParameter("assign_reason");

		// String approval = workflowTaskSeq.getApproval();
		// int roleId = workflowTaskSeq.getRoleId();
		// for next task Sequence
		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
		
//add new line
		int nextTaskSequenceNext = (workflowTaskSeq.getSequence() + 1);
		WorkflowTaskSeq workflowTaskSequNext = workflowTaskService.getNextTaskIdBy(nextTaskSequenceNext, workFlowID);
//end new line		

		int nextTaskID = workflowTaskSequ.getTaskId();
		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
				(JrID), (workflowTaskSequ.getRoleId()), workflowTaskSequ.getTaskId());
	
		Path path = null;
		byte[] bytes = null;
		if (!attachment.isEmpty()) {

			try {
				bytes = attachment.getBytes();
				if (!new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+ task.getTaskName().replace(' ', '_')).exists()) {
					new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator
							+ task.getTaskName().replace(' ', '_')).mkdirs();
				}

				List<FileVersion> filevVersion1 = fileVersionService.findbyAidJid(Aid, JrID);
				String updatedfileName = "";

				int count = 0;
				for (FileVersion fileVersion1 : filevVersion1) {
					if (fileVersion1.getFileName().equalsIgnoreCase(attachment.getOriginalFilename())) {
//						updatedfileName = FileVersionChange.versionChange(attachment.getOriginalFilename(),
//								fileVersion.getFileVersion() + 1);

					//	FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename());
						int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
						maxnum=maxnum+1;
						FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(attachment.getOriginalFilename(),
								maxnum,articleDetail.getAid());
						updatedfileName = fv.getFilename();
						path = Paths.get(UPLOAD_FOLDER + File.separator
								+ journal.getJournalAbbrName().toLowerCase().toLowerCase() + File.separator
								+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_')
								+ File.separator + updatedfileName);
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(attachment.getSize() + "bytes");
						fileVersion.setTaskId(task.getId());
						fileVersion.setFileType(attachment.getContentType());
						fileVersion.setJournalId(JrID);
						fileVersion.setFilePath(path.toString());
						fileVersion.setQueInFile(queInFile);
						fileVersion.setFileVersion(fv.getUpdateNumber());
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);
						count++;
					}

				}
				if (count == 0) {
				int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
				maxnum=maxnum+1;
				//FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename(),maxnum);
				FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(attachment.getOriginalFilename(),
						maxnum,articleDetail.getAid());
					FileVersion fileVersion = new FileVersion();
					fileVersion.setArticleId(Aid);
				//	updatedfileName = attachment.getOriginalFilename();
					updatedfileName=fv.getFilename();// new update at 16
					path = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator
							+ task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
					fileVersion.setFileName(updatedfileName);
					fileVersion.setSize(attachment.getSize() + "bytes");
					fileVersion.setTaskId(task.getId());
					fileVersion.setFileType(attachment.getContentType());
					fileVersion.setJournalId(JrID);
					fileVersion.setFilePath(path.toString());
					fileVersion.setFileVersion(maxnum);
					fileVersion.setQueInFile(queInFile);
					fileVersion.setCreated_by(users.getUserID());
					fileVersion.setCreatedAt(new Date());
					fileVersionService.saveFileVersion(fileVersion);

				}
				File newfile= new File(path.toString());
				newfile.setExecutable(true, false);
				newfile.setReadable(true, false);
				newfile.setWritable(true, false);	
				Files.write(path, bytes);//file copy in ftp
				
				if (true){
					boolean fileStatus = FtpFileCopy.fileCopyToClientLocation(path.toString(),
							defaultJournlaPath + journal.getJournalAbbrName().toLowerCase()+"//"+workflowTaskSequ.getTask().getTaskName() + input, sftpHost, sftpUser,
							sftpPassword);
					if (fileStatus) {
						System.out.println(fileStatus + " -->:file copy in server ");
					}
				}

				/// pending for task completed(final stage -->end of work)
				if (workflowTaskSequ == null) {
					List<TaskManagementVo> taskManagementVo = taskManagementService
							.getmyTaskManagementList(users.getUserID());
					model.put("taskScheduler", taskManagementVo);
					return new ModelAndView("myTaskList");
				} else {
					TaskScheduler taskPoolUpdate = taskService.getRunId(Aid, nextTaskID);
//					if (userLIst.size() == 1) {
//						taskPoolUpdate.setTask_status("In Progress");
//						taskPoolUpdate.setUser_id(userLIst.get(0).getId());
//						taskPoolUpdate.setTask_est_time_from(new Date());
//					} else {
//						taskPoolUpdate.setTask_status("InPool");
//					}
					taskPoolUpdate.setTask_est_time_from(new Date());
					taskPoolUpdate.setTask_status("Yet-to-Start");
					taskPoolUpdate.setUser_id(manageJournalWorkflow.getUser_id());
					taskService.saveTaskSchedulerStatus(taskPoolUpdate);
				}

				CurrentArticleStatus currentArticleStatus = articleService.findCurrentArticleStatusBy(taskID, Aid);
				currentArticleStatus.setTask_id(nextTaskID);
				articleService.saveCurrentArticleTaskStatus(currentArticleStatus);

				taskscheduler.setTask_status("Completed");
				taskscheduler.setRatingStar(0);
				taskscheduler.setTask_est_time_end(new Date());
				taskService.saveTaskSchedulerStatus(taskscheduler);
				try {
					articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
					articleTaskDetail.setTask_status("Completed");
					articleTaskDetail.setCompleted_date_time(new Date());
					articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
				} catch (Exception e) {
					ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
					articleTaskDetail1.setUser_id(users.getUserID());
					articleTaskDetail1.setArticle_task_id(id);
					articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
					articleTaskDetail1.setTask_status("Completed");
					articleTaskDetail1.setStart_date_time(new Date());
					articleTaskDetail1.setCompleted_date_time(new Date());
					articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
				}
				model.addAttribute("message",
						"Article ID : \r\n" + articleDetail.getAid() + "\r\n , \r\n" + "Journal Abbreviation : "
								+ articleDetail.getJournals().getJournalAbbrName() + "\r\n And \r\n" + "Task Name : "
								+ taskName + "\r\nCompleted Task Successfully");
				model.addAttribute("css", "success");
//		if(nextTaskSequence==1) {
//			int nextTaskSequence1 =2;
//			
//			WorkflowTaskSeq workflowTaskSequ1 = workflowTaskService.getNextTaskIdBy(nextTaskSequence1,workFlowID);
//			int nextTaskID1 = workflowTaskSequ1.getTaskId();
//			
//			CurrentArticleStatus currentArticleStatus1 = new CurrentArticleStatus();
//			currentArticleStatus1.setTask_id(nextTaskID1);
//			currentArticleStatus1.setArticle_id(Aid);
//			articleService.saveCurrentArticleTaskStatus(currentArticleStatus1);
//			
//		}
			} catch (IOException e) {
				model.addAttribute("Error", "Error in uploading file please try again");
				return showGroupTask(model, request, articleTaskDetail);

			}
		}
		// mail trigger
		ArticleComment ac = new ArticleComment();
		ac.setAid(Aid);
		ac.setTaskid(taskscheduler.getTask_id());
		ac.setJid(JrID);
		ac.setUserName(users.getFirstName() + " " + users.getLastName());
		ac.setCommentDate(new Date());
		ac.setRoleid(users.getRole().getRoleID());
		ac.setComment(assignReason);
		articleService.save(ac);
		if (workflowTaskSequNext.getRole().getRoleID().equals(5)) {	
			int uniprrStatus = 57;
			if (workflowTaskSequNext.getTaskId() == 105936) {
				uniprrStatus = 62;
			}
			Path authorPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
					+ File.separator + articleDetail.getArticle_doi() + File.separator
					+ workflowTaskSequNext.getTask().getTaskName().replace(' ', '_'));
			LOGGER.info("Stating Author Api and calling to uniprr--------------> (role Name"
					+ users.getRole().getRoleName() + " )----------> Role ID" + users.getRole().getRoleID());
			AuthorRestController ar = new AuthorRestController();
			// String articleTaskID = "";
			ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
					(JrID), (workflowTaskSequNext.getRole().getRoleID()), workflowTaskSequNext.getTaskId());
			TaskManagementVo taskInThisUser = taskManagementService.getspecificTask(manageJournalAuthor.getUser_id(),
					Aid);
			LOGGER.info("taskInThisUser------------->" + taskInThisUser.toString());
			String pathTO = "http://unitouchcdn.digiscapetech.com" + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
			+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_');
			AuthorDataApiModel apimodel=ar.setCompleteddata(articleDetail.getAid(), uniprrStatus+"",pathTO, authorPath.toString(),
					taskInThisUser.getArticle_task_id().toString(),workflowTaskSequNext.getFileType(),assignReason);
			articleService.saveAuthorAPIData(apimodel);
			LOGGER.info("Author Api called------------------>"+apimodel);
		} else {
			LOGGER.info("no Author role ");
		}
		
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, taskID);
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(Aid);
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
			trigger.setCreatedBy(name);
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");
		}
		
		if (workflowTaskSequ != null) {
			ManageJournalWorkflow mjw = manageJournalworkflowService.getdepartmentIdallby((workFlowID), (JrID),
					(workflowTaskSequ.getRoleId()), workflowTaskSequ.getTaskId());
			Users nextUserData = userService.findByUserId(mjw.getUser_id());
			String msg = "Article ID : \r\n" + articleDetail.getAid() + "\r\n , Journal Abbreviation : \r\n"
					+ articleDetail.getJournals().getJournalAbbrName() + " \r\n , \r\n"
					+ "Manuscript is completed successfully and sent to " + nextUserData.getFirstName() + " \r\n"
					+ nextUserData.getLastName() + "\r\n" + "(" + nextUserData.getRole().getRoleName() + ")";
			model.addAttribute("message", msg);
			model.addAttribute("css", "success");
		} else {
			model.addAttribute("message",
					"Article ID : \r\n" + articleDetail.getAid() + "\r\n" + "Journal Abbreviation : "
							+ articleDetail.getJournals().getJournalAbbrName() + " is completed successfully");
			model.addAttribute("css", "success");
		}
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);
		return new ModelAndView("myTaskList");

	}

	@RequestMapping(value = "/approveTask", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView approveTask(ModelMap model, HttpServletRequest request,
			@RequestParam MultipartFile attachment) throws AddressException, MessagingException {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String ID = request.getParameter("article_task_id");
		int id = Integer.parseInt(ID);
		model.put("article_task_id", id);
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		String rating = request.getParameter("ratingStar");
		int ratingStar = Integer.parseInt(rating);
		LOGGER.debug("RatingI : " + rating);
		String comments = request.getParameter("comments");

		LOGGER.debug("comments : " + comments);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		String Priority = request.getParameter("priority");
		LOGGER.debug("Priority" + Priority);
		System.out.println(Priority);
		if (Priority == null || Priority == "") {
			articleDetail.setPriority(articleDetail.getPriority());
		} else {
			articleDetail.setPriority(Priority);
		}
		articleService.saveArticle(articleDetail);
		// String arID = articleDetail.getAid();
		String flag = request.getParameter("flag");
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		ArticleTaskDetail articleTaskDetail = null;

		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		int taskID = taskscheduler.getTask_id();
		TaskDetails task = taskService.getTaskNameBy(taskID);
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		String approval = workflowTaskSeq.getApproval();
		int nextTaskSequenceP = (workflowTaskSeq.getSequence() - 1);
		int nextTaskSequenceNext = (workflowTaskSeq.getSequence() + 1);
		WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(nextTaskSequenceP, workFlowID);
		int prevTaskID = workflowTaskSequP.getTaskId();

		WorkflowTaskSeq workflowTaskSequNext = workflowTaskService.getNextTaskIdBy(nextTaskSequenceNext, workFlowID);
		if (workflowTaskSequNext == null) {

			taskscheduler.setTask_status("Completed");
			taskscheduler.setTask_est_time_end(new Date());
			// UPDATE TIME HEAR

			taskService.saveTaskSchedulerStatus(taskscheduler);
			try {
				articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
				articleTaskDetail.setTask_status("Completed");
				articleTaskDetail.setCompleted_date_time(new Date());
				articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
			} catch (Exception e) {
				ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
				articleTaskDetail1.setUser_id(users.getUserID());
				articleTaskDetail1.setArticle_task_id(id);
				articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
				articleTaskDetail1.setTask_status("Completed");
				articleTaskDetail1.setStart_date_time(new Date());
				articleTaskDetail1.setCompleted_date_time(new Date());
				articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
			}
			int prevId = (id - 1);
			TaskScheduler taskschedulerprev = taskService.findtaskDetailById(prevId);
			taskschedulerprev.setRatingStar(ratingStar);
			taskschedulerprev.setComments(comments);
			taskService.saveTaskSchedulerStatus(taskschedulerprev);
			ArticleRestApiUniprr aripr = new ArticleRestApiUniprr();
			ArticleDataApi api = aripr.setCompleteddata(articleDetail.getAid());
			LOGGER.info("api------------>" + api);
			// CurrentArticleStatus currentArticl =
			// articleService.findCurrentArticleStatusBy(taskID, Aid);
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.addAttribute("css", "success");
			model.addAttribute("message",
					"Article ID :\r\n" +articleDetail.getAid() + "\r\n And \r\n"
							+ "journal Abbreviation : \r\n" + articleDetail.getJournals().getJournalAbbrName()
							+ " is completed successfully");
			model.put("taskScheduler", taskManagementVo);
			String msgBody = "Dear Author " + "\r\n" + "\r\n" + "Article Title : " + articleDetail.getArticle_title()
					+ "\r\n And \r\n" + "journal Name : " + articleDetail.getJournals().getJournalName()
					+ " \r\n completed successfully in Unitouch\r\n" + "\r\n" + "Thanks,\r\n" + "Unitouch\r\n" + ""
					+ "\r\n" + api;
			String msgSubject = "Automated Email: Unitouch ";
			SendEmailUtility.mail(EmailEnum.to, msgSubject, msgBody);
			return new ModelAndView("myTaskList");
		}
		System.out.println("workflowTaskSequNext-->" + workflowTaskSequNext.toString());
		int roleId = workflowTaskSequNext.getRoleId();
		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
				(JrID), (roleId), workflowTaskSequNext.getTaskId());
		System.out.println("manageJournalWorkflow---->" + manageJournalWorkflow.toString());
		// int deptId = manageJournalWorkflow.getDept_id();
		// UserDepartment userDepartment = new UserDepartment();
		// userDepartment.setDeptID(deptId);
		// List<UserVo> userLIst =
		// departmentService.getUserNameByDeptID(userDepartment);

//		String taskname = task.getTaskName();

		byte[] bytes = approval.getBytes();
		if (!new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
				+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_')).exists()) {
			new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_')).mkdirs();
		}
		TaskDetails prevtask = taskService.getTaskNameBy(prevTaskID);
		Path TO = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
				+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'));
		Path From = Paths
				.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
						+ articleDetail.getArticle_doi() + File.separator + prevtask.getTaskName().replace(' ', '_'));

	File target = new File(From.toString());
		String fileName = "";
		File[] listOfFiles = target.listFiles();
		if (listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					LOGGER.debug("File " + listOfFiles[i].getName());
					fileName = listOfFiles[i].getName();
					System.out.println(fileName);
					Path whereTOStart = Paths.get(From + File.separator + fileName);
					Path whereTOEnd = Paths.get(TO + File.separator + fileName);
					try {
						Path temp = Files.copy(whereTOStart, whereTOEnd, StandardCopyOption.REPLACE_EXISTING);
						LOGGER.info("temp------------>" + temp);
						listOfFiles[i].setExecutable(true, false);
						listOfFiles[i].setReadable(true, false);
						listOfFiles[i].setWritable(true, false);
					} catch (IOException e) {

						e.printStackTrace();
					}
				} else if (listOfFiles[i].isDirectory()) {
					LOGGER.debug("Directory " + listOfFiles[i].getName());
				}
			}
		}
		Path sourcePath = Paths.get(From.toString() + "/" + fileName);
		Path targetPath = Paths.get(TO.toString() + "/" + fileName);

		try {
			Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);// copy with
																								// REPLACE_EXISTING
			if (!attachment.isEmpty()) { // REPLACE_EXISTING
				byte[] attachFile = attachment.getBytes();
				String updatedfileName = attachment.getOriginalFilename();
				Path optionalPath = Paths.get(UPLOAD_FOLDER + File.separator
						+ journal.getJournalAbbrName().toLowerCase() + File.separator + articleDetail.getArticle_doi()
						+ File.separator + task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);// option
				

				int count = 0;
				List<FileVersion> filevVersion1 = fileVersionService.findbyAidJid(Aid, JrID);
				for (FileVersion fileVersion1 : filevVersion1) {
					if (fileVersion1.getFileName().equalsIgnoreCase(attachment.getOriginalFilename())) {
//						updatedfileName = FileVersionChange.versionChange(attachment.getOriginalFilename(),
//								fileVersion.getFileVersion() + 1);
						int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
						maxnum=maxnum+1;
						//FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename(),maxnum);
						FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(attachment.getOriginalFilename(),
								maxnum,articleDetail.getAid());
						updatedfileName = fv.getFilename();
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(attachment.getSize() + "bytes");
						fileVersion.setTaskId(task.getId());
						fileVersion.setFileType(attachment.getContentType());
						fileVersion.setJournalId(JrID);
						optionalPath = Paths.get(UPLOAD_FOLDER + File.separator
								+ journal.getJournalAbbrName().toLowerCase() + File.separator + articleDetail.getArticle_doi()
								+ File.separator + task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
						fileVersion.setFilePath(optionalPath.toString());
						fileVersion.setFileVersion(fv.getUpdateNumber());
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);
						count++;
					}

				}

//				if (count == 0) {
//					FileVersion fileVersion = new FileVersion();
//					fileVersion.setArticleId(Aid);
//					fileVersion.setFileName(attachment.getOriginalFilename());
//					fileVersion.setSize(attachment.getSize() + "bytes");
//					fileVersion.setTaskId(task.getId());
//					fileVersion.setFileType(attachment.getContentType());
//					fileVersion.setJournalId(JrID);
//					fileVersion.setFilePath(optionalPath.toString());
//					fileVersion.setFileVersion(1);
//					fileVersion.setCreated_by(users.getUserID());
//					fileVersion.setCreatedAt(new Date());
//					fileVersionService.saveFileVersion(fileVersion);
//				}
				if (count == 0) {
					int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
					maxnum=maxnum+1;
				//	FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename(),maxnum);
					FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(attachment.getOriginalFilename(),
							maxnum,articleDetail.getAid());
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
					//	updatedfileName = attachment.getOriginalFilename();
						updatedfileName=fv.getFilename();// new update at 16
						optionalPath = Paths.get(UPLOAD_FOLDER + File.separator
								+ journal.getJournalAbbrName().toLowerCase() + File.separator + articleDetail.getArticle_doi()
								+ File.separator + task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(attachment.getSize() + "bytes");
						fileVersion.setTaskId(task.getId());
						fileVersion.setFileType(attachment.getContentType());
						fileVersion.setJournalId(JrID);
						fileVersion.setFilePath(optionalPath.toString());
						fileVersion.setFileVersion(maxnum);
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);

					}
				Files.write(optionalPath, attachFile);
			} // option
			LOGGER.debug("Target file Path : " + path);
			File newfile= new File(path.toString());
			newfile.setExecutable(true, false);
			newfile.setReadable(true, false);
			newfile.setWritable(true, false);	
			LOGGER.debug("Copied Content : \n" + new String(Files.readAllBytes(path)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
		
		//file copy in ftp
		if (true) {
			boolean fileStatus = FtpFileCopy.fileCopyToClientLocation(sourcePath.toString(),
					defaultJournlaPath + journal.getJournalAbbrName().toLowerCase()+"//"+workflowTaskSequ.getTask().getTaskName() + input, sftpHost, sftpUser,
					sftpPassword);
			
			// FtpFileCopy.fileCopyToClientLocation(sourcePath.toString(),
			// manageJournalWorkflow.getFileFtpOutput());
			if (fileStatus) {
				System.out.println(fileStatus + " -->:file copy in server ");
			}
		}
		// FileUtils.copyDirectory(source, target);
	

		

		if (workflowTaskSequ == null) {
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.addAttribute("css", "success");
			model.addAttribute("message", "All Task is Completed successfully");
			model.put("taskScheduler", taskManagementVo);
			taskscheduler.setTask_status("Completed");
			taskscheduler.setTask_est_time_end(new Date());
			// UPDATE TIME HEAR

			taskService.saveTaskSchedulerStatus(taskscheduler);
			try {
				articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
				articleTaskDetail.setTask_status("Completed");
				articleTaskDetail.setCompleted_date_time(new Date());
				articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
			} catch (Exception e) {
				ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
				articleTaskDetail1.setUser_id(users.getUserID());
				articleTaskDetail1.setArticle_task_id(id);
				articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
				articleTaskDetail1.setTask_status("Completed");
				articleTaskDetail1.setStart_date_time(new Date());
				articleTaskDetail1.setCompleted_date_time(new Date());
				articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
			}
			int prevId = (id - 1);
			TaskScheduler taskschedulerprev = taskService.findtaskDetailById(prevId);
			taskschedulerprev.setRatingStar(ratingStar);
			taskschedulerprev.setComments(comments);
			taskService.saveTaskSchedulerStatus(taskschedulerprev);
			return new ModelAndView("myTaskList");
		} else {
			TaskScheduler taskPoolUpdate = taskService.getRunId(Aid, workflowTaskSequ.getTaskId());
			taskPoolUpdate.setTask_status("Yet-to-Start");
			taskPoolUpdate.setUser_id(manageJournalWorkflow.getUser_id());
			taskPoolUpdate.setTask_est_time_from(new Date());
			taskService.saveTaskSchedulerStatus(taskPoolUpdate);
		}
		int nextTaskID = workflowTaskSequ.getTaskId();
		CurrentArticleStatus currentArticleStatus = articleService.findCurrentArticleStatusBy(taskID, Aid);
		currentArticleStatus.setTask_id(nextTaskID);
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus);

		taskscheduler.setTask_status("Completed");
		taskscheduler.setTask_est_time_end(new Date());
		// UPDATE TIME HEAR

		taskService.saveTaskSchedulerStatus(taskscheduler);
		try {
			articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
			articleTaskDetail.setTask_status("Completed");
			articleTaskDetail.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
		} catch (Exception e) {
			ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
			articleTaskDetail1.setUser_id(users.getUserID());
			articleTaskDetail1.setArticle_task_id(id);
			articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
			articleTaskDetail1.setTask_status("Completed");
			articleTaskDetail1.setStart_date_time(new Date());
			articleTaskDetail1.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
		}
		int prevId = (id - 1);
		TaskScheduler taskschedulerprev = taskService.findtaskDetailById(prevId);
		taskschedulerprev.setRatingStar(ratingStar);
		taskschedulerprev.setComments(comments);
		taskService.saveTaskSchedulerStatus(taskschedulerprev);
		// Author Api
		if (workflowTaskSequNext.getRole().getRoleID().equals(5)) {	
			int uniprrStatus = 57;
			if (workflowTaskSequNext.getTaskId() == 105936) {
				uniprrStatus = 62;
			}
			Path authorPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
					+ File.separator + articleDetail.getArticle_doi() + File.separator
					+ workflowTaskSequNext.getTask().getTaskName().replace(' ', '_'));
			LOGGER.info("Stating Author Api and calling to uniprr--------------> (role Name"
					+ users.getRole().getRoleName() + " )----------> Role ID" + users.getRole().getRoleID());
			AuthorRestController ar = new AuthorRestController();
			// String articleTaskID = "";
			ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
					(JrID), (workflowTaskSequNext.getRole().getRoleID()), workflowTaskSequNext.getTaskId());
			TaskManagementVo taskInThisUser = taskManagementService.getspecificTask(manageJournalAuthor.getUser_id(),
					Aid);
			LOGGER.info("taskInThisUser------------->" + taskInThisUser.toString());
			String pathTO = "http://unitouchcdn.digiscapetech.com" + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
			+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_');
			AuthorDataApiModel apimodel=ar.setCompleteddata(articleDetail.getAid(), uniprrStatus+"",pathTO, authorPath.toString(),
					taskInThisUser.getArticle_task_id().toString(),workflowTaskSequNext.getFileType(),comments);
			articleService.saveAuthorAPIData(apimodel);
			LOGGER.info("Author Api called------------------>"+apimodel);
		} else {
			LOGGER.info("no Author role ");
		}
		// end of author api call

		ArticleComment ac = new ArticleComment();
		ac.setAid(Aid);
		ac.setTaskid(taskscheduler.getTask_id());
		ac.setJid(JrID);
		ac.setUserName(users.getFirstName() + " " + users.getLastName());
		ac.setCommentDate(new Date());
		ac.setRoleid(users.getRole().getRoleID());
		ac.setComment(comments);
		articleService.save(ac);

		// email set
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, taskID);
		
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(Aid);
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
			trigger.setCreatedBy(name);
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");
		}

		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);

		// WorkflowTaskSeq workflowTask =
		// workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
		if (workflowTaskSequP != null) {
			ManageJournalWorkflow mjw = manageJournalworkflowService.getdepartmentIdallby((workFlowID), (JrID),
					(workflowTaskSequ.getRoleId()), workflowTaskSequ.getTaskId());
			Users nextUserData = userService.findByUserId(mjw.getUser_id());
			String msg = "Article ID :\r\n" + articleDetail.getAid() + "\r\n , Journal Abbreviation : \r\n"
					+ articleDetail.getJournals().getJournalAbbrName() + " \r\n , \r\n"
					+ "Manuscript is approved successfully and sent to " + nextUserData.getFirstName() + " \r\n"
					+ nextUserData.getLastName() + "\r\n" + "(" + nextUserData.getRole().getRoleName() + ")";
			model.addAttribute("message", msg);
			model.addAttribute("css", "success");
		} else {
			model.addAttribute("message",
					"Article ID :\r\n" + articleDetail.getAid() + "\r\n" + "Journal Abbreviation : "
							+ articleDetail.getJournals().getJournalAbbrName() + " is approved successfully");
			model.addAttribute("css", "success");
		}
		return new ModelAndView("myTaskList");
	}

	@RequestMapping(value = { "/taskList" })
	public ModelAndView taskList(ModelMap model) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		// Users users = userService.findUserIdByUserName(name);
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		return new ModelAndView("taskDetailList");
	}

	@RequestMapping(value = { "/overDuetaskList" })
	public ModelAndView overDuetaskList(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<TaskScheduler> taskScheduler = taskService.getOverDueTaskList(users.getUserID());
		model.put("taskScheduler", taskScheduler);
		System.out.println(taskScheduler.toString());
		return new ModelAndView("overdueTask");
	}

	@RequestMapping(value = { "/assignBack"  },method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView AssignBack(ModelMap model, HttpServletRequest request,
			CurrentArticleStatus currentArticleStatus, TaskDetails taskDetails,@RequestParam MultipartFile backFile) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String assignRoleName = null;
		// Users nextUserData = null;
		Integer nextUserId = null;
		String currentTaskID = request.getParameter("article_task_id");
		int currentTaskid = Integer.parseInt(currentTaskID);
		String ID = request.getParameter("id");
		int Taskid = Integer.parseInt(ID);

		model.put("id", Taskid);
		String flag = request.getParameter("flag");
		String assignReason = request.getParameter("assign_reason");
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
//		****************************************************

		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);
		// int StratCount = workflowTaskSeq.getSequence();

		List<WorkflowTaskSeq> workflowTaskSeqsList = workflowTaskService.workflowTaskSeqlist(workFlowID);
		int count = 0;
		for (WorkflowTaskSeq workflowBack : workflowTaskSeqsList) {
			if (workflowBack.getId() == workflowTaskSeq.getId()) {
				WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(count, workFlowID);
				int taskid = workflowTaskSeqtask.getTaskId();
				taskService.changeTaskStatus(Aid, taskid, workFlowID, "In Progress");
				count++;
				TaskScheduler taskscheduler = taskService.findtaskDetailBytaskIdarticleid(taskid, Aid);
				assignRoleName = workflowTaskSeqtask.getRole().getRoleName();
				nextUserId = taskscheduler.getUser_id();
				taskscheduler.setTask_status("Yet-to-Start");
				int assignBackCount = (taskscheduler.getAssign_back_count() + 1);
				String assignreason = taskscheduler.getAssign_reason();
				String toReason = "";
				if (assignreason == null) {
					toReason = assignBackCount + " : " + assignReason + ":: BY" + users.getFirstName() + " "
							+ users.getLastName();
					taskscheduler.setAssign_reason(toReason.trim());
				} else {
					toReason = taskscheduler.getAssign_reason() + "**" + assignBackCount + " = " + assignReason
							+ ":: BY" + users.getFirstName() + " " + users.getLastName();
					taskscheduler.setAssign_reason(toReason.trim());

				}
				ArticleComment ac = new ArticleComment();
				ac.setAid(Aid);
				ac.setTaskid(taskscheduler.getTask_id());
				ac.setJid(JrID);
				ac.setUserName(users.getFirstName() + " " + users.getLastName());
				ac.setCommentDate(new Date());
				ac.setComment(assignReason);
				ac.setRoleid(users.getRole().getRoleID());
				articleService.save(ac);
//				taskscheduler.setAssign_reason(taskscheduler.getAssign_reason() + "**" + assignBackCount + " = "
//						+ assignReason + ":: BY" + users.getFirstName() + " " + users.getLastName());

				taskscheduler.setAssign_back_count(assignBackCount);
				taskService.saveTaskSchedulerStatus(taskscheduler);
			}
			if (workflowBack.getId() == workflowTaskSeq.getId()) {

				for (int swq = count; swq < workflowTaskSeqsList.size(); swq++) {
					WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(swq, workFlowID);
					int taskid = workflowTaskSeqtask.getTaskId();
					taskService.changeTaskStatusUserDel(Aid, taskid, workFlowID, "Yet-to-Start");
				}
			}
			count++;
		}


		try {
		//	Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);// copy with
		int seq =workflowTaskSeq.getSequence();
		String updatedfileName = backFile.getOriginalFilename();
		WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(seq-1, workFlowID);
		Path optionalPath=null;
			if (seq == 0) {

				optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+"Origin"+ File.separator
						+ updatedfileName);

			} else {

				optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
						+ updatedfileName);

			}
			if (!backFile.isEmpty()) { // REPLACE_EXISTING
				byte[] attachFile = backFile.getBytes();
				// option
				int filetemp=0;
				
				
				List<FileVersion> filevVersion1 = fileVersionService.findbyAidJid(Aid, JrID);
				TaskScheduler taskscheduler = taskService.getOne(currentTaskid);
				for (FileVersion fileVersion1 : filevVersion1) {
					if (fileVersion1.getFileName().equalsIgnoreCase(backFile.getOriginalFilename())) {
					//	FilVerVo fv = FileVersionUpdateR.versionChange(backFile.getOriginalFilename());
						int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
						maxnum = maxnum + 1;
						FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
								backFile.getOriginalFilename(), maxnum, articleDetail.getAid());
						updatedfileName = fv.getFilename();
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(backFile.getSize() + "bytes");
						fileVersion.setTaskId(taskscheduler.getTask_id());
						fileVersion.setFileType(backFile.getContentType());
						fileVersion.setJournalId(JrID);
						if (seq == 0) {
							optionalPath = Paths
									.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
											+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin"
											+ File.separator + updatedfileName);
						} else {
							optionalPath = Paths
									.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
											+ File.separator + articleDetail.getArticle_doi() + File.separator
											+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
											+ updatedfileName);
						}
						fileVersion.setFilePath(optionalPath.toString());
						fileVersion.setFileVersion(fv.getUpdateNumber());
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);
						filetemp++;
					}

				}

//				if (filetemp == 0) {
//					FileVersion fileVersion = new FileVersion();
//					fileVersion.setArticleId(Aid);
//					fileVersion.setFileName(backFile.getOriginalFilename());
//					fileVersion.setSize(backFile.getSize() + "bytes");
//					fileVersion.setTaskId(taskscheduler.getTask_id());
//					fileVersion.setFileType(backFile.getContentType());
//					fileVersion.setJournalId(JrID);
//					fileVersion.setFilePath(optionalPath.toString());
//					fileVersion.setFileVersion(1);
//					fileVersion.setCreated_by(users.getUserID());
//					fileVersion.setCreatedAt(new Date());
//					fileVersionService.saveFileVersion(fileVersion);
//				}
				if (filetemp == 0) {
					int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
					maxnum=maxnum+1;
					//FilVerVo fv = FileVersionUpdateR.versionChange(backFile.getOriginalFilename(),maxnum);
					FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
							backFile.getOriginalFilename(), maxnum, articleDetail.getAid());
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
					//	updatedfileName = attachment.getOriginalFilename();
						updatedfileName=fv.getFilename();// new update at 16
					if (seq == 0) {
						optionalPath = Paths
								.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
										+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin"
										+ File.separator + updatedfileName);
					} else {
						optionalPath = Paths
								.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
										+ File.separator + articleDetail.getArticle_doi() + File.separator
										+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
										+ updatedfileName);
					}
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(backFile.getSize() + "bytes");
						fileVersion.setTaskId(taskscheduler.getTask_id());
						fileVersion.setFileType(backFile.getContentType());
						fileVersion.setJournalId(JrID);
						fileVersion.setFilePath(optionalPath.toString());
						fileVersion.setFileVersion(maxnum);
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);

					}
				
				Files.write(optionalPath, attachFile);
			} // option
		//	LOGGER.debug("Target file Path : " +optionalPath.toString();
		//	LOGGER.debug("Copied Content : \n" + new String(Files.readAllBytes(optionalPath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		CurrentArticleStatus currentArticleStatus1 = articleService.findArticleStatusBy(Aid);
		Integer currenttask=currentArticleStatus1.getTask_id();
		currentArticleStatus1.setTask_id(taskDetails.getId());
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus1);

		model.put("article_task_id", currentTaskid);
		TaskScheduler taskscheduler = taskService.findtaskDetailById(currentTaskid); // articleTaskId pk
		taskscheduler.setTask_status("Yet-to-Start");
		taskscheduler.setAssign_reason(assignReason);
		int assignBackCount = (taskscheduler.getAssign_back_count() + 1);
		taskscheduler.setAssign_back_count(assignBackCount);
		taskService.saveTaskSchedulerStatus(taskscheduler);
	//	WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
//		String approval = workflowTaskSeq.getApproval();
	//	int nextTaskSequenceP = (workflowTaskSeq.getSequence() - 1);
//		int nextTaskSequenceNext = (workflowTaskSeq.getSequence() + 1);
		
	//	WorkflowTaskSeq workflowTaskSequNext = workflowTaskService.getNextTaskIdBy(nextTaskSequenceNext-1, workFlowID);
		WorkflowTaskSeq workflowpre = workflowTaskService.gettaskDetailsbyid(taskDetails.getId(), workFlowID);
		WorkflowTaskSeq taskName = workflowTaskService.getNextTaskIdBy(workflowpre.getSequence()-1, workFlowID);
		if (workflowpre.getSequence() == 0) {
			 taskName=workflowpre;
		}
	//	TaskDetails task = taskService.getTaskNameBy(workflowTaskSequNext.getTaskId());
		if (workflowTaskSeq.getRole().getRoleID().equals(5)) {
			int uniprrStatus = 57;
			if (workflowTaskSeq.getTaskId() == 105936) {
				uniprrStatus = 62;
			}
	//		Path TO = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
	//				+ articleDetail.getArticle_doi() + File.separator + workflowTaskSequNext.getTask().getTaskName().replace(' ', '_'));
			Path authorPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
					+ File.separator + articleDetail.getArticle_doi() + File.separator
					+ workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
			LOGGER.info("Stating Author Api and calling to uniprr--------------> (role Name"
					+ users.getRole().getRoleName() + " )----------> Role ID" + users.getRole().getRoleID());
			AuthorRestController ar = new AuthorRestController();
			// String articleTaskID = "";
			ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
					(JrID), (workflowTaskSeq.getRole().getRoleID()), workflowTaskSeq.getTaskId());
			TaskManagementVo taskInThisUser = taskManagementService.getspecificTask(manageJournalAuthor.getUser_id(),
					Aid);
			LOGGER.info("taskInThisUser------------->" + taskInThisUser.toString());
			String pathTo="http://unitouchcdn.digiscapetech.com"+ File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + taskName.getTask().getTaskName().replace(' ', '_');
			AuthorDataApiModel apimodel=ar.setCompleteddata(articleDetail.getAid(), uniprrStatus+"", pathTo, authorPath.toString(),
					taskInThisUser.getArticle_task_id().toString(), workflowTaskSeq.getFileType(),assignReason);
			articleService.saveAuthorAPIData(apimodel);
			LOGGER.info("Author Api called------------------>"+apimodel+"<----------------status code uniprrStatus--->"+uniprrStatus);
		} else {
			LOGGER.warn("no role of  Author Api calling to uniprr");
		}
		try {
			ArticleTaskDetail articleTaskDetail = articleTaskDetailService.findtaskDetailById(currentTaskid, Aid);
			articleTaskDetail.setTask_status("Rejected");
			articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
		} catch (Exception e) {
			ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
			articleTaskDetail1.setUser_id(users.getUserID());
			articleTaskDetail1.setArticle_task_id(taskscheduler.getArticle_task_id());
			articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
			articleTaskDetail1.setTask_status("Rejected");
			articleTaskDetail1.setStart_date_time(new Date());
			articleTaskDetail1.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
		}
	
		
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);

		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, taskName.getTaskId());
		//	EmailJournalWorkflow emailpre = emailJournalWorkflowService.findByejwt(JrID, workFlowID, workflowpre.getTaskId());
			EmailJournalWorkflow emailTaskWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID,currenttask);
			System.out.println(workflowTaskSeq.toString());
			if (emailJournalWorkflow != null) {
				EmailTrigger trigger = new EmailTrigger();
				trigger.setArticleId(Aid);
				trigger.setTaskId(currenttask);
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
				if(workflowTaskSeq.getSequence()==0) {
					
					List<String> fTask = EmunAticleStatus.fiststageMail(articleDetail.getArticle_title(),
							articleDetail.getAid(), journal.getJournalName());
					trigger.setFinishSubject(fTask.get(0));
					trigger.setFinishBody(fTask.get(1));
					trigger.setNextTaskid(workflowTaskSeq.getTaskId());
					trigger.setNextUserid(nextUserId);
				}

				emailTriggerService.save(trigger);
			} else {
				LOGGER.info("Email template is not set");
				System.out.println("Email template is not set");
			}
		
		Users nextUserData = userService.findByUserId(nextUserId);
		model.addAttribute("message",
				"Article ID : \r\n" + articleDetail.getAid() + "\r\n And \r\n" + "Journal Abbreviation : "
						+ articleDetail.getJournals().getJournalAbbrName() + " is assign back successfully and sent to "
						+ nextUserData.getFirstName() + " \r\n" + nextUserData.getLastName() + "\r\n" + "("
						+ assignRoleName + ")");
		model.addAttribute("css", "success");
		return new ModelAndView("myTaskList");

	}



	@RequestMapping(value = { "/skipTasks" })
	public ModelAndView skipTasks(ModelMap model, HttpServletRequest request, CurrentArticleStatus currentArticleStatus,
			TaskDetails taskDetails) {
		Path startpath = null;// copy path
		byte[] bytes = null;
		Integer taskID = null;
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String currentTaskID = request.getParameter("article_task_id");
		int currentTaskid = Integer.parseInt(currentTaskID);// article task id
		String ID = request.getParameter("id");
		int Taskid = Integer.parseInt(ID);
		model.put("id", Taskid);// to send to particuler task next task id
		String flag = request.getParameter("flag");
		String assignReason = request.getParameter("assign_reason");
		String aid = request.getParameter("article_id");// article id
		int Aid = Integer.parseInt(aid);
//		****************************************************

		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		String Priority = request.getParameter("priority");
		LOGGER.debug("Priority" + Priority);
		System.out.println(Priority);
		if (Priority == null || Priority == "") {
			articleDetail.setPriority(articleDetail.getPriority());
		} else {
			articleDetail.setPriority(Priority);
		}
		articleService.saveArticle(articleDetail);

		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);// next task to
																										// send
		/// past path
		WorkflowTaskSeq workflowpre = workflowTaskService.getNextTaskIdBy(workflowTaskSeq.getSequence() - 1,
				workFlowID);// prev next id
//		WorkflowTaskSeq workflowemMail = workflowTaskService.getNextTaskIdBy(workflowTaskSeq.getSequence() - 2,
//				workFlowID);// prev next id
		Path destination = Paths
				.get(UPLOAD_FOLDER + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+ workflowpre.getTask().getTaskName().replace(' ', '_') + File.separator);

		int EndCount = workflowTaskSeq.getSequence();
		TaskScheduler taskschedulerup = taskService.findtaskDetailById(currentTaskid);
		taskschedulerup.setTask_status("Completed");
		taskschedulerup.setTask_est_time_end(new Date());
		taskService.saveTaskSchedulerStatus(taskschedulerup);
		WorkflowTaskSeq workflowTaskSeqSt = workflowTaskService.gettaskDetailsbyid(taskschedulerup.getTask_id(),
				workFlowID);// current task location
		if (workflowTaskSeqSt.getSequence() == 0) {
			startpath = Paths.get(UPLOAD_FOLDER + File.separator
					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + "Origin" + File.separator);
			// taskID = workflowTaskSeq.getTaskId();
			LOGGER.info(workflowTaskSeq.getSequence() + "<---currentTaskSequence ---- start path File--->"
					+ startpath.toString());

		} else if (workflowTaskSeqSt.getSequence() != 0) {
			int n = EndCount - workflowTaskSeqSt.getSequence();// 8-5
			WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(workflowTaskSeqSt.getSequence() - 1,
					articleDetail.getJournals().getArticleWorkflowId());
			startpath = Paths
					.get(UPLOAD_FOLDER + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator
							+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_') + File.separator);
			// taskID = workflowTaskSequ.getTaskId();
		}
		int StratCount = workflowTaskSeqSt.getSequence() + 1;
		for (int i = StratCount; i < EndCount; i++) {
			WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(i, workFlowID);
			TaskScheduler taskschedulerEach = taskService.findtaskDetailBytaskIdarticleid(workflowTaskSequP.getTaskId(),
					Aid);
			ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
					(workFlowID), (JrID), (workflowTaskSequP.getRoleId()), workflowTaskSequP.getTaskId());
			taskschedulerEach.setTask_status("Skiped");
			taskschedulerEach.setUser_id(manageJournalWorkflow.getUser_id());
			taskschedulerEach.setTask_est_time_end(new Date());// update user id
			taskschedulerEach.setTask_est_time_from(new Date());
			taskService.saveTaskSchedulerStatus(taskschedulerEach);

		}
		WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(EndCount, workFlowID);
		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
				(JrID), (workflowTaskSequP.getRoleId()), taskDetails.getId());// end location
		TaskScheduler taskscheduler = taskService.findtaskDetailBytaskIdarticleid(taskDetails.getId(), Aid);
		taskscheduler.setTask_status("Yet-to-Start");
		taskscheduler.setUser_id(manageJournalWorkflow.getUser_id());
//		int assignBackCount = (taskscheduler.getAssign_back_count() + 1);
		taskscheduler.setAssign_reason(taskscheduler.getAssign_reason() + " = " + assignReason + ":: BY"
				+ users.getFirstName() + " " + users.getLastName());

		taskService.saveTaskSchedulerStatus(taskscheduler);
		CurrentArticleStatus currentArticleStatus1 = articleService.findArticleStatusBy(Aid);
		Integer currenttaskID=currentArticleStatus1.getTask_id();
		currentArticleStatus1.setTask_id(taskDetails.getId());
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus1);
		model.put("article_task_id", currentTaskid);
		ArticleTaskDetail articleTaskDetail = articleTaskDetailService.findtaskDetailById(currentTaskid, Aid);
		articleTaskDetail.setTask_status("Skiped");
		ArticleComment ac = new ArticleComment();
		ac.setAid(Aid);
		ac.setTaskid(taskscheduler.getTask_id());
		ac.setJid(JrID);
		ac.setUserName(users.getFirstName() + " " + users.getLastName());
		ac.setCommentDate(new Date());
		ac.setComment(assignReason);
		ac.setRoleid(users.getRole().getRoleID());
		articleService.save(ac);
		articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);

		File target = new File(startpath.toString());
		String fileName = "";
		File[] listOfFiles = target.listFiles();
		if(listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					LOGGER.debug("File " + listOfFiles[i].getName());
					fileName = listOfFiles[i].getName();
					System.out.println(fileName);
					Path whereTOStart = Paths.get(startpath + File.separator + fileName);
					Path whereTOEnd = Paths.get(destination + File.separator + fileName);
					try {
						Path temp = Files.copy(whereTOStart, whereTOEnd, StandardCopyOption.REPLACE_EXISTING);
						LOGGER.info("temp------------>" + temp);
					} catch (IOException e) {

						e.printStackTrace();
					}
				} else if (listOfFiles[i].isDirectory()) {
					LOGGER.debug("Directory " + listOfFiles[i].getName());
				}
			}
		} else {
			LOGGER.debug(" File is not in Directory--->startpath" + startpath + "\ndestination------------->" + destination);
		}
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, currenttaskID);
	//	EmailJournalWorkflow emailpre = emailJournalWorkflowService.findByejwt(JrID, workFlowID, workflowemMail.getTaskId());
		EmailJournalWorkflow emailTaskWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, workflowpre.getTaskId());
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(Aid);
			trigger.setTaskId(currenttaskID);
			trigger.setEtSubject("" + emailTaskWorkflow.getEmailTemp().getToSubject());
			trigger.setEtBody("" + emailTaskWorkflow.getEmailTemp().getEditorData());
			trigger.setEtTo(emailJournalWorkflow.getTo().toString());
			trigger.setEtBcc("" + emailJournalWorkflow.getBcc());
			trigger.setEtCc("" + emailJournalWorkflow.getCc());
			if (emailTaskWorkflow.getEmailTemp().getFinishBody() != null) {
				trigger.setFinishBody("" + emailTaskWorkflow.getEmailTemp().getFinishBody());
			}
			if (emailTaskWorkflow.getEmailTemp().getFinishSubject() != null) {
				trigger.setFinishSubject("" + emailTaskWorkflow.getEmailTemp().getFinishSubject());
			}
			if (emailTaskWorkflow.getEmailTemp().getReplySubject() != null) {
				trigger.setReplySubject("" + emailTaskWorkflow.getEmailTemp().getReplySubject());
			}
			if (emailTaskWorkflow.getEmailTemp().getReplyBody() != null) {
				trigger.setReplyBody("" + emailTaskWorkflow.getEmailTemp().getReplyBody());
			}
			if (emailTaskWorkflow.getNextUserid() != null) {
				trigger.setNextUser(emailTaskWorkflow.getNextUserid().toString());
			}
			if (emailTaskWorkflow.getPreUserid() != null) {
				trigger.setPreUser(emailTaskWorkflow.getPreUserid().toString());
			}
			if (emailTaskWorkflow.getPreTaskid() != null) {
				trigger.setPreTaskid(emailTaskWorkflow.getPreTaskid());
			}
			if (emailTaskWorkflow.getNextTaskid() != null) {
				trigger.setNextTaskid(emailTaskWorkflow.getNextTaskid());
			}
			if (emailJournalWorkflow.getPreUserid() != null) {
				trigger.setPreUserid(emailJournalWorkflow.getPreUserid());
			}
			if (emailTaskWorkflow.getNextUserid() != null) {
				trigger.setNextUserid(emailTaskWorkflow.getNextUserid());
			}
			trigger.setIsActive(0);
			trigger.setCreatedAt(new Date());
			trigger.setCreatedBy(name);
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");
		}
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);
		String msg = "Article ID : \r\n" + articleDetail.getAid() + "\r\n , Journal Abbreviation : \r\n"
				+ articleDetail.getJournals().getJournalAbbrName() + " \r\n , \r\n"
				+ "Manuscript is skipped successfully and sent to " + manageJournalWorkflow.getUsers().getFirstName()
				+ " \r\n" + manageJournalWorkflow.getUsers().getLastName() + "\r\n" + "("
				+ manageJournalWorkflow.getUsers().getRole().getRoleName() + ")";

		model.addAttribute("message", msg);
		model.addAttribute("css", "success");
		return new ModelAndView("myTaskList");
	}

	@RequestMapping(value = "/download-Completedtask-file")
	public void downloadfiles(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String ID = request.getParameter("article_task_id");
		int id = Integer.parseInt(ID);
		model.put("article_task_id", id);
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		int taskID = taskscheduler.getTask_id();
		// TaskDetails task = taskService.getTaskNameBy(taskID);

		String sourceFile = null;
		int workFlowID = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		int currentTaskSequence = workflowTaskSeq.getSequence();
		if (currentTaskSequence == 0) {
			sourceFile = (UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + "Origin");
			LOGGER.info(currentTaskSequence + "<---currentTaskSequence ---- sourceFile--->" + sourceFile);

		} else if (currentTaskSequence != 0) {
			int previousTaskSequence = currentTaskSequence - 1;

			WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(previousTaskSequence, workFlowID);
			int previousTaskID = workflowTaskSequ.getTaskId();
			TaskDetails taskdetail = taskService.getTaskNameBy(previousTaskID);
			String previousTaskName = taskdetail.getTaskName();
			sourceFile = (UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + previousTaskName);
			LOGGER.info(currentTaskSequence + "<---currentTaskSequence ---- sourceFile--->" + sourceFile);
		}

//		List<FileVersion> file = fileVersionService.findbyAidJidTid(articleDetail.getArticle_id(), JrID,
//				currentTaskSequence - 1);
//		LOGGER.debug("file :::::::" + file);

		File directory = new File(sourceFile);
		LOGGER.info("SourceFile------>" + sourceFile);
		String[] files = null;
		files = directory.list();

		byte[] zip = zipFiles(directory, files);
		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=" + articleDetail.getAid() + ".zip");
		LOGGER.info(response.toString());
		sos.write(zip);
		sos.flush();

	}

	private static byte[] zipFiles(File directory, String[] files) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		byte bytes[] = new byte[10048];
		for (String fileName : files) {
			FileInputStream fis = new FileInputStream(directory.getPath() + File.separator + fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			zos.putNextEntry(new ZipEntry(fileName));
			int bytesRead;
			while ((bytesRead = bis.read(bytes)) != -1) {
				zos.write(bytes, 0, bytesRead);
			}
			zos.closeEntry();
			bis.close();
			fis.close();
		}
		zos.flush();
		baos.flush();
		zos.close();
		baos.close();
		return baos.toByteArray();
	}

	@RequestMapping(value = { "/file" })
	public ModelAndView file(ModelMap model, HttpServletRequest request) throws IOException {

		String ID = request.getParameter("article_task_id");
		String article_name = request.getParameter("article_name");
		model.put("article_task_id", ID);
		model.put("article_name", article_name);
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		model.put("article_id", Aid);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);

		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		String sourceFile = (UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
				+ File.separator + articleDetail.getArticle_doi());
		LOGGER.debug("sourceFile-------------->" + sourceFile);
		System.out.println("sourceFile-------------->" + sourceFile);
		Map<String, Set<String>> map = new LinkedHashMap<>();
		File file = new File(sourceFile);
		String[] directories = file.list(new FilenameFilter() {
			public boolean accept(File current, String name) {
				String[] extensions = { "zip", "docx", "xml", "png", "doc", "pdf" };
				boolean recursive = true;
				LOGGER.debug("task File Name -------------->" + current + File.separator + name);
				System.out.println("task File Name -------------->" + current + File.separator + name);
				File root = new File(current + File.separator + name);

				Set<String> list = new LinkedHashSet<>();
				Collection<File> files = FileUtils.listFiles(root, extensions, recursive);
				LOGGER.debug(current + File.separator + name);
				for (File f : files) {

					list.add(f.getName());
				}
				map.put(name, list);
				LOGGER.debug("list :: " + list.toString());
				System.out.println(list);
				return new File(current, name).isDirectory();
			}

		});
		model.put("testP", map);
		model.put("path", sourceFile);
		System.out.println("testP ------------>" + map);
		System.out.println("path ------------>" + sourceFile);
		return new ModelAndView("IssueMakeupCreate");
	}

	@GetMapping(value = "/dwonload_file")
	public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) {
		String file1 = request.getParameter("fileURL");
		System.out.println("fileURL----->" + file1);
		File file = null;
		System.out.println(file1);
		file = new File(file1);
		InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
			LOGGER.info("file  found ------------->"+file1);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					.contentType(MediaType.APPLICATION_PDF).contentLength(file.length()).body(resource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			LOGGER.info("file not found ------------->"+file1);
			LOGGER.info("]Message------------->"+e.getMessage());
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" +"No__File___Found")
					.contentType(MediaType.APPLICATION_PDF).contentLength(file.length()).body(null);
		}
		
	}

	@PostMapping(value = "/fileReplace")
	public String fileReplace(HttpServletRequest request, RedirectAttributes ra,
			@RequestParam MultipartFile attachmentLis) throws Exception {
		int aid = 0;
		if (!attachmentLis.isEmpty()) {
			LOGGER.info("fileReplace---------URl");
			String fileId = request.getParameter("fileId");
			Path path = null;
			byte[] bytes = null;
			Integer taskID = null;
			bytes = attachmentLis.getBytes();
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			Users users = userService.findUserIdByUserName(name);
			ArticleFileVersionReplace afvr = new ArticleFileVersionReplace();
			FileVersion fileVersion = fileVersionService.getOne(Integer.parseInt(fileId));
			aid=fileVersion.getArticleId();
			CurrentArticleStatus curr = articleService
					.findArticleStatusBy(fileVersion.getArticleDeatils().getArticle_id());

			WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(curr.getTask_id(),
					fileVersion.getArticleDeatils().getJournals().getArticleWorkflowId());

			if (workflowTaskSeq.getSequence() == 0) {
				path = Paths.get(UPLOAD_FOLDER + File.separator
						+ fileVersion.getArticleDeatils().getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + fileVersion.getArticleDeatils().getArticle_doi() + File.separator + "Origin"
						+ File.separator + attachmentLis.getOriginalFilename());
				taskID = workflowTaskSeq.getTaskId();
				LOGGER.info(workflowTaskSeq.getSequence() + "<---currentTaskSequence ---- sourceFile--->"
						+ path.toString());

			} else if (workflowTaskSeq.getSequence() != 0) {
				WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(
						workflowTaskSeq.getSequence() - 1,
						fileVersion.getArticleDeatils().getJournals().getArticleWorkflowId());
				path = Paths.get(UPLOAD_FOLDER + File.separator
						+ fileVersion.getArticleDeatils().getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + fileVersion.getArticleDeatils().getArticle_doi() + File.separator
						+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_') + File.separator
						+ attachmentLis.getOriginalFilename());
				taskID = workflowTaskSequ.getTaskId();
			}

			System.out.println("fileId------------>" + fileId);

			afvr.setFileName(fileVersion.getFileName());
			afvr.setArticleId(fileVersion.getArticleId());
			afvr.setFilePath(fileVersion.getFilePath());
			afvr.setSize(fileVersion.getSize());
			afvr.setUpdaetdAt(new Date());
			afvr.setCreated_by(fileVersion.getCreated_by());
			afvr.setCreatedAt(fileVersion.getCreatedAt());
			afvr.setUpdatedBy(users.getUserID());
			afvr.setJournalId(fileVersion.getJournalId());
			afvr.setTaskId(taskID);
			afvr.setFileType(fileVersion.getFileType());
			afvr.setFileVersion(fileVersion.getFileVersion());
			fileVersionService.saveArticleFileVersionReplaceRepo(afvr);
			LOGGER.info("file save in bkp Table ------------>");
			System.out.println("fileVersion------->" + fileVersion.getFilePath());
			Path target = Paths.get(fileVersion.getFilePath());
			String fileName = fileVersion.getFileName();
			Files.write(path, bytes);
			LOGGER.info("file copy in current path location----------------> " + path.toString());
			fileVersion.setFilePath(path.toString());
			fileVersion.setSize(attachmentLis.getSize() + " bytes");
			fileVersion.setFileType(attachmentLis.getContentType());
			fileVersion.setFileName(attachmentLis.getOriginalFilename());
			fileVersion.setUpdatedBy(users.getUserID());
			fileVersion.setUpdaetdAt(new Date());
			fileVersion.setFileVersion(1);
			fileVersionService.saveFileVersion(fileVersion);

			Path source = Paths.get(UPLOAD_FOLDER + File.separator
					+ fileVersion.getArticleDeatils().getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ fileVersion.getArticleDeatils().getArticle_doi() + File.separator + "replacefile" + File.separator
					+ fileName);
			if (!new File(UPLOAD_FOLDER + File.separator
					+ fileVersion.getArticleDeatils().getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ fileVersion.getArticleDeatils().getArticle_doi() + File.separator + "replacefile").exists()) {
				new File(UPLOAD_FOLDER + File.separator
						+ fileVersion.getArticleDeatils().getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + fileVersion.getArticleDeatils().getArticle_doi() + File.separator
						+ "replacefile").mkdirs();
			}

			System.out.println("fileVersion------->" + fileVersion.getFilePath());
			// Path target=Paths.get(fileVersion.getFilePath());
			LOGGER.info("source file------->" + source.toString());
			LOGGER.info("target file------->" + target.toString());
			try {

				File f = new File(source.toString());
				if (f.exists()) {
					System.out.println("file already exits --->" + source.toString());
				} else {
					Path temp = Files.move(target, source, StandardCopyOption.REPLACE_EXISTING);
					if (temp != null)
						LOGGER.info("temp-----Current bkp path-------->" + temp.toString());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			LOGGER.info("File replace successfully-------->"+aid);
			ra.addAttribute("message", "File replace successfully");
			ra.addAttribute("css", "success");
			ra.addAttribute("article_id", aid);
			return "redirect:articleHistory";

		} else {
			ra.addAttribute("message", "Something went Wrong !! Please do it again");
			ra.addAttribute("article_id", aid);
			ra.addAttribute("css", "danger");
			return "redirect:articleHistory";
		}
	}

	@RequestMapping(value = "/completeProxyTask", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String CompleteProxyTask(ModelMap model, HttpServletRequest request,
			@RequestParam MultipartFile[] attachmentList, RedirectAttributes ra) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		String msg = "";
		// String ID = request.getParameter("article_task_id");
//		int id = Integer.parseInt(ID);

		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		// String arID = articleDetail.getAid();
		CurrentArticleStatus getTaskID = articleService.findArticleStatusBy(Aid);
		TaskScheduler taskschedulerup = taskService.getRunId(Aid, getTaskID.getTask_id()); // currentTaskID
		int id = taskschedulerup.getArticle_task_id();
		model.put("article_task_id", id);
		String flag = request.getParameter("flag");
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		ArticleTaskDetail articleTaskDetail = null;
		TaskScheduler taskscheduler = taskService.findtaskDetailById(id);
		int taskID = taskscheduler.getTask_id();
		TaskDetails task = taskService.getTaskNameBy(taskID);
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		// for current task seq list^|
		String approval = workflowTaskSeq.getApproval();
//		int roleId = workflowTaskSeq.getRoleId();
//		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
//				(workFlowID), (JrID),(roleId),workflowTaskSeq.getTaskId());
//		int deptId=manageJournalWorkflow.getDept_id();
//		UserDepartment userDepartment=new UserDepartment();
//		userDepartment.setDeptID(deptId);
//		List<UserVo> userLIst=departmentService.getUserNameByDeptID( userDepartment);
		// String taskname = task.getTaskName();
		Path path = null;
		byte[] bytes = null;
		int taskcoun = 0;
		for (MultipartFile attachment : attachmentList) {

			if (!attachment.isEmpty()) {

				try {
					bytes = attachment.getBytes();
					if (!new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator
							+ task.getTaskName().replace(' ', '_')).exists()) {
						new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + articleDetail.getArticle_doi() + File.separator
								+ task.getTaskName().replace(' ', '_')).mkdirs();
					}

					List<FileVersion> filevVersion1 = fileVersionService.findbyAidJid(Aid, JrID);
					String updatedfileName = "";
					int count = 0;
					for (FileVersion fileVersion1 : filevVersion1) {
						if (fileVersion1.getFileName().equalsIgnoreCase(attachment.getOriginalFilename())) {
							int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
							maxnum=maxnum+1;
						//	FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename(),maxnum);
							FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
									attachment.getOriginalFilename(), maxnum, articleDetail.getAid());
							updatedfileName = fv.getFilename();
							path = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
									+ File.separator + articleDetail.getArticle_doi() + File.separator
									+ task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
							FileVersion fileVersion = new FileVersion();
							fileVersion.setArticleId(Aid);
							fileVersion.setFileName(updatedfileName);
							fileVersion.setSize(attachment.getSize() + "bytes");
							fileVersion.setTaskId(task.getId());
							fileVersion.setFileType(attachment.getContentType());
							fileVersion.setJournalId(JrID);
							fileVersion.setFilePath(path.toString());
							fileVersion.setFileVersion(fv.getUpdateNumber());
							fileVersion.setCreated_by(users.getUserID());
							fileVersion.setCreatedAt(new Date());
							fileVersionService.saveFileVersion(fileVersion);
							count++;
						}

					}
					if (count == 0) {
						
						FileVersion fileVersion = new FileVersion();
						fileVersion.setArticleId(Aid);
						int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
						maxnum=maxnum+1;
					//	FilVerVo fv = FileVersionUpdateR.versionChange(attachment.getOriginalFilename(),maxnum);
						FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
								attachment.getOriginalFilename(), maxnum, articleDetail.getAid());
						updatedfileName = fv.getFilename();
						path = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + articleDetail.getArticle_doi() + File.separator
								+ task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
						fileVersion.setFileName(updatedfileName);
						fileVersion.setSize(attachment.getSize() + "bytes");
						fileVersion.setTaskId(task.getId());
						fileVersion.setFileType(attachment.getContentType());
						fileVersion.setJournalId(JrID);
						fileVersion.setFilePath(path.toString());
						fileVersion.setFileVersion(fv.getUpdateNumber());
						fileVersion.setCreated_by(users.getUserID());
						fileVersion.setCreatedAt(new Date());
						fileVersionService.saveFileVersion(fileVersion);
					}
					Files.write(path, bytes);

					// for next task Sequence
					int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
					WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence,
							workFlowID);
		
					// for next to next task Sequence
					// WorkflowTaskSeq taskSequNTN =
					// workflowTaskService.getNextTaskIdBy(nextTaskSequence + 1, workFlowID);

					/// pending for task completed(final stage -->end of work)
					if (workflowTaskSequ == null) {
						List<TaskManagementVo> taskManagementVo = taskManagementService
								.getmyTaskManagementList(users.getUserID());
						model.put("taskScheduler", taskManagementVo);
						ra.addAttribute("message", "All task is completed");
						ra.addAttribute("css", "success");
						ra.addAttribute("article_id", Aid);
						return "redirect:articleHistory";
					} else {
						int roleId = workflowTaskSequ.getRoleId();
						ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService
								.getdepartmentIdallby((workFlowID), (JrID), (roleId), workflowTaskSequ.getTaskId());

						if (taskcoun == 0) {
							int nextTaskID = workflowTaskSequ.getTaskId();
							TaskScheduler taskPoolUpdate = taskService.getRunId(Aid, nextTaskID);
							taskPoolUpdate.setTask_status("In Progress");
							taskPoolUpdate.setUser_id(manageJournalWorkflow.getUser_id());
							taskPoolUpdate.setTask_est_time_from(new Date());
							taskService.saveTaskSchedulerStatus(taskPoolUpdate);
							ArticleTaskDetail atd = new ArticleTaskDetail();
							atd.setArticle_task_id(taskscheduler.getArticle_task_id());
							atd.setArticle_id(taskscheduler.getArticle_id());
							atd.setStart_date_time(new Date());
							atd.setUser_id(manageJournalWorkflow.getUser_id());
							atd.setTask_status("In Progress");
							articleTaskDetailService.saveArticleTaskDetail(atd);
							LOGGER.debug("atd :" + atd.toString());
							msg = "Article :" + articleDetail.getArticle_title() + "\r\n , Journal Abbreviation : \r\n"
									+ articleDetail.getJournals().getJournalAbbrName() + " \r\n , \r\n"
									+ "Manuscript is complete by proxy successfully and sent to "
									+ manageJournalWorkflow.getUsers().getFirstName() + " \r\n"
									+ manageJournalWorkflow.getUsers().getLastName() + "\r\n" + "("
									+ manageJournalWorkflow.getUsers().getRole().getRoleName() + ")";

						}

					}
					int nextTaskID = workflowTaskSequ.getTaskId();
					if (taskcoun == 0) { // only one type uppdate in current article Status
						CurrentArticleStatus currentArticleStatus = articleService.findCurrentArticleStatusBy(taskID,
								Aid);
						currentArticleStatus.setTask_id(nextTaskID);
						articleService.saveCurrentArticleTaskStatus(currentArticleStatus);
					}
					taskscheduler.setTask_status("Completed_by_Proxy");
					taskscheduler.setRatingStar(0);
					taskscheduler.setTask_est_time_from(new Date());
					taskscheduler.setTask_est_time_end(new Date());
					taskService.saveTaskSchedulerStatus(taskscheduler);
					
					if (taskcoun == 0) {
						if (workflowTaskSequ.getRole().getRoleID().equals(5)) {
							int uniprrStatus = 57;
							if (workflowTaskSequ.getTaskId() == 105936) {
								uniprrStatus = 62;
							}
							Path authorPath = Paths
									.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
											+ File.separator + articleDetail.getArticle_doi() + File.separator
											+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_'));
							LOGGER.info("Stating Author Api and calling to uniprr--------------> (role Name"
									+ users.getRole().getRoleName() + " )----------> Role ID"
									+ users.getRole().getRoleID());
							AuthorRestController ar = new AuthorRestController();
							// String articleTaskID = "";
							ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService
									.getdepartmentIdallby((workFlowID), (JrID),
											(workflowTaskSequ.getRole().getRoleID()), workflowTaskSequ.getTaskId());
							TaskManagementVo taskInThisUser = taskManagementService
									.getspecificTask(manageJournalAuthor.getUser_id(), Aid);

							LOGGER.info("taskInThisUser------------->" + taskInThisUser.toString());
							String pathTO = "http://unitouchcdn.digiscapetech.com" + File.separator
									+ journal.getJournalAbbrName().toLowerCase() + File.separator
									+ articleDetail.getArticle_doi() + File.separator
									+ task.getTaskName().replace(' ', '_');
							AuthorDataApiModel apimodel = ar.setCompleteddata(articleDetail.getAid(), uniprrStatus + "",
									pathTO, authorPath.toString(), taskInThisUser.getArticle_task_id().toString(),
									workflowTaskSequ.getFileType(), "");
							articleService.saveAuthorAPIData(apimodel);
							LOGGER.info("Author Api called------------------>" + apimodel);
						} else {
							LOGGER.info("no Author role ");
						}
					}

					if (taskcoun == 0) {
						try {
							articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
							if (articleTaskDetail == null) {
								ArticleTaskDetail articleTask = new ArticleTaskDetail();
								articleTask.setArticle_id(Aid);
								articleTask.setArticle_task_id(id);
								articleTask.setUser_id(users.getUserID());
								articleTask.setTask_status("Completed_by_Proxy");
								articleTask.setStart_date_time(new Date());
								articleTask.setCompleted_date_time(new Date());
								articleTaskDetailService.saveArticleTaskStatus(articleTask);
							} else {
								articleTaskDetail.setTask_status("Completed_by_Proxy");
								articleTaskDetail.setCompleted_date_time(new Date());
								articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
							}
						} catch (Exception e) {
							ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
							articleTaskDetail1.setUser_id(users.getUserID());
							articleTaskDetail1.setArticle_task_id(id);
							articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
							articleTaskDetail1.setTask_status("Completed_by_Proxy");
							articleTaskDetail1.setStart_date_time(new Date());
							articleTaskDetail1.setCompleted_date_time(new Date());
							articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
						}
					}
				} catch (IOException e) {
					ra.addAttribute("message", "Error in uploading file please try again");
					ra.addAttribute("css", "danger");
					ra.addAttribute("article_id", Aid);
					return "redirect:articleHistory";

				}
			}
			taskcoun++;
		}
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(JrID, workFlowID, taskID);
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(Aid);
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
			trigger.setCreatedBy(name);
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");
		}
		ra.addAttribute("message", msg);
		ra.addAttribute("css", "success");
		ra.addAttribute("article_id", Aid);
		return "redirect:articleHistory";
	}

	@RequestMapping(value = { "/skipTasksFrom" })
	public String skipTasksFrom(ModelMap model, HttpServletRequest request, CurrentArticleStatus currentArticleStatus,
			TaskDetails taskDetails, RedirectAttributes ra) throws ParseException {
		Path startpath = null;// copy path
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		// String currentTaskID = request.getParameter("articletaskid");
		// int currentTaskid = Integer.parseInt(currentTaskID);//article task id
		String ID = request.getParameter("id");
		int Taskid = Integer.parseInt(ID);
		model.put("id", Taskid);// to send to particuler task next task id
		String flag = request.getParameter("flag");
		String assignReason = request.getParameter("assign_reason");
		String aid = request.getParameter("article_id");// article id
		int Aid = Integer.parseInt(aid);
//		****************************************************

		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		CurrentArticleStatus getTaskID = articleService.findArticleStatusBy(Aid);
		int taskid = getTaskID.getTask_id();
		// TaskScheduler articleTaskDeatils = taskService.getRunId(Aid, taskid);
		// //currentTaskID
		String Priority = request.getParameter("priority");
		LOGGER.debug("Priority" + Priority);
		System.out.println(Priority);
		articleDetail.setPriority(Priority);
		articleService.saveArticle(articleDetail);

		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);// next task to
																										// send
		/// past path
		WorkflowTaskSeq workflowpre = workflowTaskService.getNextTaskIdBy(workflowTaskSeq.getSequence() - 1,
				workFlowID);// prev next id
		Path destination = Paths
				.get(UPLOAD_FOLDER + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+ workflowpre.getTask().getTaskName().replace(' ', '_') + File.separator);

		int EndCount = workflowTaskSeq.getSequence();
		TaskScheduler taskschedulerup = taskService.getRunId(Aid, taskid); // currentTaskID
	//	taskschedulerup.setTask_status("Completed");
		taskschedulerup.setTask_status("Skiped");
		taskschedulerup.setTask_est_time_from(new Date());
		taskschedulerup.setTask_est_time_end(new Date());
		taskService.saveTaskSchedulerStatus(taskschedulerup);
		LOGGER.info("current task completed -------->" + taskschedulerup.toString());
		WorkflowTaskSeq workflowTaskSeqSt = workflowTaskService.gettaskDetailsbyid(taskschedulerup.getTask_id(),
				workFlowID);// current task location
		if (workflowTaskSeqSt.getSequence() == 0) {
			startpath = Paths.get(UPLOAD_FOLDER + File.separator
					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + File.separator
					+ articleDetail.getArticle_doi() + File.separator + "Origin" + File.separator);
			// taskID = workflowTaskSeq.getTaskId();
			LOGGER.info(workflowTaskSeq.getSequence() + "<---currentTaskSequence ---- start path File--->"
					+ startpath.toString());

		} else if (workflowTaskSeqSt.getSequence() != 0) {
			int n = EndCount - workflowTaskSeqSt.getSequence();// 8-5
			WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(workflowTaskSeqSt.getSequence() - 1,
					articleDetail.getJournals().getArticleWorkflowId());
			startpath = Paths
					.get(UPLOAD_FOLDER + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator
							+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_') + File.separator);
			// taskID = workflowTaskSequ.getTaskId();
		}
		int StratCount = workflowTaskSeqSt.getSequence() + 1;
		for (int i = StratCount; i < EndCount; i++) {
			WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(i, workFlowID);
			TaskScheduler taskschedulerEach = taskService.findtaskDetailBytaskIdarticleid(workflowTaskSequP.getTaskId(),
					Aid);
			ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
					(workFlowID), (JrID), (workflowTaskSequP.getRoleId()), workflowTaskSequP.getTaskId());
			taskschedulerEach.setTask_status("Skiped");
			taskschedulerEach.setUser_id(manageJournalWorkflow.getUser_id());
			taskschedulerEach.setTask_est_time_end(new Date());// update user id
			taskschedulerEach.setTask_est_time_from(new Date());
			taskService.saveTaskSchedulerStatus(taskschedulerEach);

		}
		WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(EndCount, workFlowID);
		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
				(JrID), (workflowTaskSequP.getRoleId()), taskDetails.getId());// end location
		TaskScheduler taskscheduler = taskService.findtaskDetailBytaskIdarticleid(taskDetails.getId(), Aid);
		taskscheduler.setTask_status("Yet-to-Start");
		taskscheduler.setUser_id(manageJournalWorkflow.getUser_id());
		taskscheduler.setAssign_reason(taskscheduler.getAssign_reason() + " = " + assignReason + ":: BY"
				+ users.getFirstName() + " " + users.getLastName());

		taskService.saveTaskSchedulerStatus(taskscheduler);
		CurrentArticleStatus currentArticleStatus1 = articleService.findArticleStatusBy(Aid);
		currentArticleStatus1.setTask_id(taskDetails.getId());
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus1);
		model.put("article_task_id", taskschedulerup.getArticle_task_id());
		File target = new File(startpath.toString());
		String fileName = "";
		File[] listOfFiles = target.listFiles();
		if(listOfFiles != null) {
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				LOGGER.debug("File " + listOfFiles[i].getName());
				fileName = listOfFiles[i].getName();
				System.out.println(fileName);
				Path whereTOStart = Paths.get(startpath + File.separator + fileName);
				Path whereTOEnd = Paths.get(destination + File.separator + fileName);
				try {
					Path temp = Files.copy(whereTOStart, whereTOEnd, StandardCopyOption.REPLACE_EXISTING);
					LOGGER.info("temp------------>" + temp);
					listOfFiles[i].setExecutable(true, false);
					listOfFiles[i].setReadable(true, false);
					listOfFiles[i].setWritable(true, false);
				} catch (IOException e) {

					e.printStackTrace();
				}
			} else if (listOfFiles[i].isDirectory()) {
				LOGGER.debug("Directory " + listOfFiles[i].getName());
			}
		}
		}
		try {
			ArticleTaskDetail articleTaskDetail = articleTaskDetailService
					.findtaskDetailById(taskschedulerup.getArticle_task_id(), Aid);
			if (articleTaskDetail == null) {
				ArticleTaskDetail atd = new ArticleTaskDetail();
				atd.setArticle_task_id(taskscheduler.getArticle_task_id());
				atd.setArticle_id(taskscheduler.getArticle_id());
				atd.setStart_date_time(new Date());
				atd.setUser_id(manageJournalWorkflow.getUser_id());
				atd.setTask_status("In Progress");
				articleTaskDetailService.saveArticleTaskDetail(atd);
			} else {
				articleTaskDetail.setTask_status("Skiped");

				articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
			}
		} catch (Exception e) {
			ArticleTaskDetail atd = new ArticleTaskDetail();
			atd.setArticle_task_id(taskscheduler.getArticle_task_id());
			atd.setArticle_id(taskscheduler.getArticle_id());
			atd.setStart_date_time(new Date());
			atd.setUser_id(manageJournalWorkflow.getUser_id());
			atd.setTask_status("In Progress");
			articleTaskDetailService.saveArticleTaskDetail(atd);
		}
		ArticleComment ac = new ArticleComment();
		ac.setAid(Aid);
		ac.setTaskid(taskscheduler.getTask_id());
		ac.setJid(JrID);
		ac.setUserName(users.getFirstName() + " " + users.getLastName());
		ac.setCommentDate(new Date());
		ac.setComment(assignReason);
		ac.setRoleid(users.getRole().getRoleID());
		articleService.save(ac);
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);
		String msg = "Article ID : \r\n" + articleDetail.getAid() + "\r\n , Journal Abbreviation : \r\n"
				+ articleDetail.getJournals().getJournalAbbrName() + " \r\n , \r\n"
				+ "Manuscript is skipped successfully and sent to " + manageJournalWorkflow.getUsers().getFirstName()
				+ " \r\n" + manageJournalWorkflow.getUsers().getLastName() + "\r\n" + "("
				+ manageJournalWorkflow.getUsers().getRole().getRoleName() + ")";

		ra.addAttribute("message", msg);
		ra.addAttribute("css", "success");
		ra.addAttribute("article_id", Aid);
		return "redirect:articleHistory";
	}

//	@PostMapping("assignBackFrom")
	@RequestMapping(value = { "/assignBackFrom" },method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String assignBackFrom(ModelMap model, HttpServletRequest request, CurrentArticleStatus currentArticleStatus,
			TaskDetails taskDetails, RedirectAttributes ra,@RequestParam MultipartFile backFile) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		Integer nextUserId = null;
		String aid = request.getParameter("article_id");
		int Aid = Integer.parseInt(aid);
//		****************************************************
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
		CurrentArticleStatus getTaskID = articleService.findArticleStatusBy(Aid);
		int Taskid = getTaskID.getTask_id();	
		TaskScheduler taskscheduler = taskService.findtaskDetailBytaskIdarticleid(Taskid, Aid);
		int currentTaskid = taskscheduler.getArticle_task_id();
		TaskScheduler pretaskscheduler = taskService.findtaskDetailBytaskIdarticleid(taskDetails.getId(), Aid);
		pretaskscheduler.setTask_status("In Progress");
		pretaskscheduler.setTask_est_time_end(null);
		nextUserId=pretaskscheduler.getUser_id();
		taskService.savetakSchedulars(pretaskscheduler);
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);
		 int StratCount = workflowTaskSeq.getSequence();
		 WorkflowTaskSeq workflowEnd = workflowTaskService.gettaskDetailsbyid(taskDetails.getId(), workFlowID);
		 int endCount= workflowEnd.getSequence();
		 endCount= endCount+1;
		 for(int i=endCount;i<=StratCount;i++) {
			 WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(i, workFlowID);
			 taskService.changeTaskStatusUserDel(Aid, workflowTaskSeqtask.getTaskId(), workFlowID, "Yet-to-Start");
		 }
			try {
				//	Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);// copy with
				int seq =workflowTaskSeq.getSequence();
				String updatedfileName = backFile.getOriginalFilename();
				WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(workflowEnd.getSequence()-1, workFlowID);
				Path optionalPath=null;
					if (seq == 0) {

						optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + articleDetail.getArticle_doi() + File.separator
								+"Origin"+ File.separator
								+ updatedfileName);

					} else {

						optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + articleDetail.getArticle_doi() + File.separator
								+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
								+ updatedfileName);

					}
					if (!backFile.isEmpty()) { // REPLACE_EXISTING
						byte[] attachFile = backFile.getBytes();
						// option
						
						int count = 0;
						TaskScheduler tasksc = taskService.getOne(currentTaskid);
						List<FileVersion> filevVersion1 = fileVersionService.findbyAidJid(Aid, JrID);
						for (FileVersion fileVersion1 : filevVersion1) {
							if (fileVersion1.getFileName().equalsIgnoreCase(backFile.getOriginalFilename())) {
								int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
								maxnum=maxnum+1;
							//	FilVerVo fv = FileVersionUpdateR.versionChange(backFile.getOriginalFilename(),maxnum);
								FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
										backFile.getOriginalFilename(), maxnum, articleDetail.getAid());
								updatedfileName = fv.getFilename();
								FileVersion fileVersion = new FileVersion();
								fileVersion.setArticleId(Aid);
								fileVersion.setFileName(updatedfileName);
								fileVersion.setSize(backFile.getSize() + "bytes");
								fileVersion.setTaskId(tasksc.getTask_id());
								fileVersion.setFileType(backFile.getContentType());
								fileVersion.setJournalId(JrID);
								if (seq == 0) {

									optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
											+ File.separator + articleDetail.getArticle_doi() + File.separator
											+"Origin"+ File.separator
											+ updatedfileName);

								} else {

									optionalPath = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
											+ File.separator + articleDetail.getArticle_doi() + File.separator
											+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
											+ updatedfileName);

								}
								fileVersion.setFilePath(optionalPath.toString());
								fileVersion.setFileVersion(fv.getUpdateNumber());
								fileVersion.setCreated_by(users.getUserID());
								fileVersion.setCreatedAt(new Date());
								fileVersionService.saveFileVersion(fileVersion);
								count++;
							}

						}
						if (count == 0) {
							int maxnum=	fileVersionService.maxVersionArticleIdAndJournalId(Aid, JrID);
							maxnum=maxnum+1;
						//	FilVerVo fv = FileVersionUpdateR.versionChange(backFile.getOriginalFilename(),maxnum);
							FilVerVo fv = FileVersionUpdateR.getfileNameByArticleIDwithVersion(
									backFile.getOriginalFilename(), maxnum, articleDetail.getAid());
							updatedfileName = fv.getFilename();
								FileVersion fileVersion = new FileVersion();
								fileVersion.setArticleId(Aid);
							//	updatedfileName = attachment.getOriginalFilename();
								updatedfileName=fv.getFilename();// new update at 16
					if (seq == 0) {
						optionalPath = Paths
								.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
										+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin"
										+ File.separator + updatedfileName);

					} else {
						optionalPath = Paths
								.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
										+ File.separator + articleDetail.getArticle_doi() + File.separator
										+ workflowTaskSeqtask.getTask().getTaskName().replace(' ', '_') + File.separator
										+ updatedfileName);

					}
								fileVersion.setFileName(updatedfileName);
								fileVersion.setSize(backFile.getSize() + "bytes");
								fileVersion.setTaskId(taskscheduler.getTask_id());
								fileVersion.setFileType(backFile.getContentType());
								fileVersion.setJournalId(JrID);
								fileVersion.setFilePath(optionalPath.toString());
								fileVersion.setFileVersion(maxnum);
								fileVersion.setCreated_by(users.getUserID());
								fileVersion.setCreatedAt(new Date());
								fileVersionService.saveFileVersion(fileVersion);

							}
						Files.write(optionalPath, attachFile);
//						if (count == 0) {
//							FileVersion fileVersion = new FileVersion();
//							fileVersion.setArticleId(Aid);
//							fileVersion.setFileName(updatedfileName);
//							fileVersion.setSize(backFile.getSize() + "bytes");
//							fileVersion.setTaskId(tasksc.getTask_id());
//							fileVersion.setFileType(backFile.getContentType());
//							fileVersion.setJournalId(JrID);
//							fileVersion.setFilePath(optionalPath.toString());
//							fileVersion.setFileVersion(1);
//							fileVersion.setCreated_by(users.getUserID());
//							fileVersion.setCreatedAt(new Date());
//							fileVersionService.saveFileVersion(fileVersion);
//						}
					} // option
				} catch (Exception e) {
					e.printStackTrace();
				}
		CurrentArticleStatus currentArticleStatus1 = articleService.findArticleStatusBy(Aid);
		currentArticleStatus1.setTask_id(taskDetails.getId());
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus1);
		try {
			ArticleTaskDetail articleTaskDetail = articleTaskDetailService.findtaskDetailById(currentTaskid, Aid);
			articleTaskDetail.setTask_status("Rejected");
			articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
		} catch (Exception e) {
			ArticleTaskDetail articleTaskDetail1 = new ArticleTaskDetail();
			articleTaskDetail1.setUser_id(users.getUserID());
			articleTaskDetail1.setArticle_task_id(taskscheduler.getArticle_task_id());
			articleTaskDetail1.setArticle_id(taskscheduler.getArticle_id());
			articleTaskDetail1.setTask_status("Rejected");
			articleTaskDetail1.setStart_date_time(new Date());
			articleTaskDetail1.setCompleted_date_time(new Date());
			articleTaskDetailService.saveArticleTaskDetail(articleTaskDetail1);
		}
		Users nextUserData = userService.findByUserId(nextUserId);
		String msg = "Article ID : \r\n" + articleDetail.getAid() + "\r\n And \r\n" + "Journal Abbreviation : "
				+ articleDetail.getJournals().getJournalAbbrName() + " is assign back successfully and sent to "
				+ nextUserData.getFirstName() + " \r\n" + nextUserData.getLastName() + "\r\n" + "(" + nextUserData.getRole().getRoleName()
				+ ")";
		ra.addAttribute("message", msg);
		ra.addAttribute("css", "success");
		ra.addAttribute("article_id", Aid);
		return "redirect:articleHistory";
	}

	@PostMapping("updateNode")
	public ResponseEntity<?> updateNode(@RequestBody ArticleDetail article) {
		System.out.println(article.toString());
		ArticleDetail articleDetail = articleService.findByAid(article.getAid());
		articleDetail.setArticle_comment(article.getArticle_comment());
		articleDetail.setWordCount(article.getWordCount());
		articleDetail.setColorImgCount(article.getColorImgCount());
		articleDetail.setArticle_pages(article.getArticle_pages());
		articleService.saveArticle(articleDetail);
		System.out.println("articleDetail-------------->" + articleDetail);
		return new ResponseEntity<>(articleDetail, HttpStatus.OK);

	}

}
