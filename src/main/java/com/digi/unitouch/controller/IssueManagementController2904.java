//package com.digi.unitouch.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import com.digi.unitouch.ApplicationResponse;
//import com.digi.unitouch.model.ArticleDetail;
//import com.digi.unitouch.model.ArticleTaskDetail;
//import com.digi.unitouch.model.CurrentArticleStatus;
//import com.digi.unitouch.model.CurrentIssueStatus;
//import com.digi.unitouch.model.Department;
//import com.digi.unitouch.model.ErrorProcess;
//import com.digi.unitouch.model.FileVersion;
//import com.digi.unitouch.model.IssueArticle;
//import com.digi.unitouch.model.IssueComment;
//import com.digi.unitouch.model.IssueDetail;
//import com.digi.unitouch.model.IssueFileVersion;
//import com.digi.unitouch.model.IssueSequence;
//import com.digi.unitouch.model.IssueSequencePublicationHistory;
//import com.digi.unitouch.model.IssueTaskDetail;
//import com.digi.unitouch.model.IssueTaskScheduler;
//import com.digi.unitouch.model.Journal;
//import com.digi.unitouch.model.ManageJournalWorkflow;
//import com.digi.unitouch.model.Publisher;
//import com.digi.unitouch.model.TaskDetails;
//import com.digi.unitouch.model.TaskScheduler;
//import com.digi.unitouch.model.UserDepartment;
//import com.digi.unitouch.model.Users;
//import com.digi.unitouch.model.Workflow;
//import com.digi.unitouch.model.WorkflowTaskSeq;
//import com.digi.unitouch.model.XmlFilePath;
//import com.digi.unitouch.service.ArticleService;
//import com.digi.unitouch.service.DepartmentService;
//import com.digi.unitouch.service.ErrorProcessService;
//import com.digi.unitouch.service.FileVersionService;
//import com.digi.unitouch.service.IssueArticleService;
//import com.digi.unitouch.service.IssueDetailService;
//import com.digi.unitouch.service.IssueSequenceService;
//import com.digi.unitouch.service.IssueTaskDetailService;
//import com.digi.unitouch.service.IssueTaskSchedulerService;
//import com.digi.unitouch.service.JournalService;
//import com.digi.unitouch.service.ManageJournalworkflowService;
//import com.digi.unitouch.service.PublisherService;
//import com.digi.unitouch.service.TaskManagementService;
//import com.digi.unitouch.service.TaskService;
//import com.digi.unitouch.service.UserService;
//import com.digi.unitouch.service.WorkflowService;
//import com.digi.unitouch.service.WorkflowTaskService;
//import com.digi.unitouch.service.XmlFileService;
//import com.digi.unitouch.serviceImpl.CurrentIssueServiceImpl;
//import com.digi.unitouch.util.DateApi;
//import com.digi.unitouch.util.EmailEngineUnitouch;
//import com.digi.unitouch.util.FileVersionChange;
//import com.digi.unitouch.util.LoggerClass;
//import com.digi.unitouch.vo.IssueTaskManagementVo;
//import com.digi.unitouch.vo.TaskManagementVo;
//import com.digi.unitouch.vo.UserVo;
//import com.digi.unitouch.vo.userDepartmentVo;
//
//@Controller
//public class IssueManagementController2904 extends LoggerClass {
//
//	@Autowired
//	private Environment env;
//	@Autowired
//	WorkflowService workflowService;
//	@Autowired
//	IssueSequenceService issueSequenceService;
//	@Autowired
//	TaskManagementService taskManagementService;
//	@Autowired
//	ManageJournalworkflowService manageJournalworkflowService;
//	@Autowired
//	IssueDetailService issueDetailService;
//	@Autowired
//	CurrentIssueServiceImpl currentIssueServiceImpl;
//	@Autowired
//	ArticleService articleService;
//	@Autowired
//	PublisherService publisherService;
//	@Autowired
//	TaskService taskService;
//	@Autowired
//	FileVersionService fileVersionService;
//	@Autowired
//	IssueTaskSchedulerService issueTaskSchedulerService;
//	@Autowired
//	IssueTaskDetailService issueTaskDetailService;
//	@Autowired
//	JournalService journalService;
//	@Autowired
//	WorkflowTaskService workflowTaskService;
//	@Autowired
//	ErrorProcessService errorprocessService;
//	@Autowired
//	XmlFileService xmlFilePath;
//	@Autowired
//	IssueArticleService issueArticleService;
//	@Autowired
//	DepartmentService departmentService;
//	@Autowired
//	FileVersionService fileversionservice;
//
//	@Autowired
//	UserService userService;
//	@Value("${journal.path}")
//	private String UPLOAD_FOLDER;
//
//	@Value("${journal.path}")
//	private String journalPath;
//
//	@Value("${journal.InputPath}")
//	private String InputPath;
//
//	@Value("${journal.OutputPath}")
//	private String OutputPath;
//
//	@Value("${journalErrorPath}")
//	private String ErrorPath;
//
//	@RequestMapping(value = { "/issuegrouptask" })
//	public ModelAndView GroupTaskDetail(ModelMap model) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		model.put("flag", 0);
////	List<TaskManagementVo> taskManagementVo = taskManagementService.getTaskManagementGroupList(users.getUserID());
//		List<IssueTaskManagementVo> taskManagementVo = new ArrayList<IssueTaskManagementVo>();
//		List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//		// int dptId = users.getGroup1().get(0).getDeptID();
//		for (Department dept : users.getGroup1()) {
//			userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//			mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//		}
//
//		for (ManageJournalWorkflow manageJourWk : mjw) {
//			taskManagementVo.addAll(issueDetailService.getIssueTaskManagementGroupList(manageJourWk.getWorkflow_id(),
//					manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//		}
//		System.out.println(userDepartmentVo.toString());
//		model.put("userDepartment", userDepartmentVo);
//		System.out.println(mjw.toString());
//		model.put("taskManagementVo", taskManagementVo);
//		return new ModelAndView("Issue/IssueGroupTaskList");
//	}
//
//	@RequestMapping(value = { "/issueMyTask" })
//	public ModelAndView myTaskList(ModelMap model) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		model.put("flag", 1);
//		List<IssueTaskManagementVo> taskManagementVo = issueDetailService.getIssueTaskManagementList(users.getUserID());
//		System.out.println(taskManagementVo.toString());
//		model.put("taskScheduler", taskManagementVo);
//		return new ModelAndView("Issue/IssueMyTask");
//	}
//
//	@RequestMapping(value = "/view-groupTaskIssue", method = RequestMethod.POST)
//	public ModelAndView showGroupTask(ModelMap model, HttpServletRequest request, IssueTaskDetail issueTaskDetails) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		LOGGER.debug(name);
//		Users users = userService.findUserIdByUserName(name);
//		String ID = request.getParameter("article_task_id");
//		int id = Integer.parseInt(ID);
//		model.put("article_task_id", id);
//		String aid = request.getParameter("article_id");
//		if (aid == null) {
//			aid = request.getParameter("article_id_" + ID);
//		}
//		// String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
//		model.put("article_id", Aid);
//		String flag = request.getParameter("flag");
//		model.put("flag", flag);
//		String flagDash = request.getParameter("flagDash");
//		model.put("flagDash", flagDash);
//		IssueTaskManagementVo taskManagementVo = issueDetailService.findGroupTaskByArticleId(id);
//		model.put("taskManagementVo", taskManagementVo);
//		IssueTaskScheduler tschedule = issueTaskSchedulerService.getIssueTaskScheById(id);
//		tschedule.setUserId(users.getUserID());
//		issueTaskSchedulerService.saveTaskSchedulars(tschedule);
//		model.put("taskscheduler", tschedule);
////		int runId = tschedule.getRunId();
//		int taskID = tschedule.getTaskId();
//
//		// ArticleDetail articleDetail = articleService.findArticleDetailBy(Aid);
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		int JrID = issueDetail.getJournalId();
//		String article_name = issueDetail.getIssue_title();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		model.put("articleDetail", issueDetail);
//		model.put("journal", journal);
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
//		int currentTaskSequence = workflowTaskSeq.getSequence();
//		model.put("approval", workflowTaskSeq.getApproval());
//		model.put("skip", workflowTaskSeq.getSkip());
//		model.put("fileType", workflowTaskSeq.getFileType());
//		model.put("journalIssueEdite",workflowTaskSeq.getEditeIssueJournal());
//			System.out.println(workflowTaskSeq.toString());
//		List<TaskDetails> task = taskService.getPreviousTaskListBy(workFlowID, currentTaskSequence);
//		model.put("TaskList", task);
//
//		List<TaskDetails> nextTasks = taskService.getnextTaskListBy(workFlowID, currentTaskSequence);
//		model.put("nextTasks", nextTasks);
//		List<ErrorProcess> errorProcess = errorprocessService.ErrorbyTaskId(taskID);
//		if (errorProcess.size() == 0) {
//			model.put("errorprocess", "NOERROR");
//
//		} else {
//			model.put("errorprocess", errorProcess);
//			LOGGER.debug(errorProcess.toString());
//		}
//		LOGGER.debug(Aid + " ::" + taskID);
//		List<XmlFilePath> xmlfilepath = xmlFilePath.findByAidAndTaskId(Aid, taskID);
//		LOGGER.debug("xml :" + xmlfilepath);
//		if (xmlfilepath.size() == 0) {
//			model.put("xmlFile", "file path not found");
//		} else {
//			model.put("xmlFile", xmlfilepath.get(0).getXmlPath());
//		}
//		model.put("workFlowId", workFlowID);
//
//		TaskDetails taskDetails = taskService.getTaskNameBy(taskID);
//
//		model.put("taskName", taskDetails.getTaskName());
//		model.put("taskId", taskID);
//
//		// model.put("runValue", taskScheduler.getRunId());
//
//		LOGGER.debug(taskDetails.toString());
//		// ArticleTaskDetail articletaskdetail =
//		// articleTaskDetailService.findtaskDetailById(id);
//		IssueTaskDetail issuetaskdetail = issueTaskDetailService.getIssueTaskScheById(id);
//
//		// Users users = userService.findUserIdByUserName(name);
//		model.put("roleId", users.getGroup1().get(0).getRole().getRoleID());
//		LOGGER.debug("user :: " + users.toString() + "\n roleid :" + users.getGroup1().get(0).getRole().getRoleID());
//		if (issuetaskdetail == null) {
//			IssueTaskDetail issueTaskDetail = new IssueTaskDetail();
//			issueTaskDetail.setUserId(users.getUserID());
//			issueTaskDetail.setIssueTaskId(id);
//			issueTaskDetail.setIssueId(Aid);
//			issueTaskDetail.setTaskStatus("In Progress");
//			issueTaskDetail.setStartDateTime(new Date());
//			issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//		} else {
//		}
//		IssueTaskScheduler taskscheduler1 = issueTaskSchedulerService.getIssueTaskScheById(id);
//		taskscheduler1.setTaskStatus("In Progress");
//		taskscheduler1.setTaskEstTimeFrom(new Date());
//		issueTaskSchedulerService.saveTaskSchedulars(taskscheduler1);
//		LOGGER.debug("In Progress");
//		model.put("article_name", article_name);
//		List<IssueComment> issueCommentsList = issueDetailService.getIssueCommentsList(journal.getJournalId(),Aid);
//		model.put("commentsList", issueCommentsList);
//		List<IssueFileVersion> issuefileVersions = fileversionservice.findbyissueIdJid(Aid,
//				journal.getJournalId());
//		/*
//		 * ArticleSearchDetailvo articleSearchDetailvo;
//		 * articleSearchDetailvo.getSch_end_time()
//		 */
//		model.put("fileVersions", issuefileVersions);
//		System.out.println("issue View group Task");
//		return new ModelAndView("Issue/IssueViewGroupTask");
//	}
//
//	@RequestMapping(value = "/issueCompleteTask", method = RequestMethod.POST, consumes = { "multipart/form-data" })
//	public ModelAndView CompleteTask(ModelMap model, HttpServletRequest request,
//			@RequestParam MultipartFile attachment) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//
//		String ID = request.getParameter("article_task_id");
//		int id = Integer.parseInt(ID);
//		model.put("article_task_id", id);
//		String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		// String arID = articleDetail.getAid();
//		String flag = request.getParameter("flag");
//		int JrID = issueDetail.getJournalId();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		IssueTaskDetail issueTaskDetail = null;
////		ArticleTaskDetail articleTaskDetail = null;
//		IssueTaskScheduler taskscheduler = issueTaskSchedulerService.getIssueTaskScheById(id);
//		int taskID = taskscheduler.getTaskId();
//		TaskDetails task = taskService.getTaskNameBy(taskID);
//		String taskName = task.getTaskName();
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
//		// for current task seq list^|
//		// Add Comments
//		String assignReason = request.getParameter("assign_reason");
//
//		IssueComment issueComment =new IssueComment();
//		issueComment.setIssueId(Aid);;
//		issueComment.setTaskid(taskscheduler.getTaskId());
//		issueComment.setJid(JrID);
//		issueComment.setUserName(users.getFirstName() + " " + users.getLastName());
//		issueComment.setCommentDate(new Date());
//		issueComment.setRoleid(users.getGroup1().get(0).getRole().getRoleID());
//		issueComment.setIssueComments(assignReason + "hello");
//		issueDetailService.IssueCommentSave(issueComment);;
//		// String approval = workflowTaskSeq.getApproval();
//		// int roleId = workflowTaskSeq.getRoleId();
//		// for next task Sequence
//		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
//		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
//
//		int nextTaskID = workflowTaskSequ.getTaskId();
//		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
//				(JrID), (workflowTaskSequ.getRoleId()), workflowTaskSequ.getTaskId());
//		int deptId = manageJournalWorkflow.getDept_id();
//		UserDepartment userDepartment = new UserDepartment();
//		userDepartment.setDeptID(deptId);
//		List<UserVo> userLIst = departmentService.getUserNameByDeptID(userDepartment);
//		// String taskname = task.getTaskName();
//		Path path = null;
//		byte[] bytes = null;
//		// List<FileVersion> filevVersion1 = fileVersionService.findbyAidJidTid(Aid,
//		// JrID, task.getId());
//
//		if (!attachment.isEmpty()) {
//
//			try {
//				bytes = attachment.getBytes();
//				if (!new File(
//						UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//								+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_'))
//										.exists()) {
//					new File(
//							UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//									+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_'))
//											.mkdirs();
//				}
//
//				List<IssueFileVersion> filevVersion1 = fileVersionService.findbyissueIdJid(Aid, JrID);
//				String updatedfileName = "";
//				int count = 0;
//				for (IssueFileVersion fileVersion : filevVersion1) {
//					if (fileVersion.getFileName().equalsIgnoreCase(attachment.getOriginalFilename())) {
//						updatedfileName = FileVersionChange.versionChange(attachment.getOriginalFilename(),
//								fileVersion.getFileVersion() + 1);
//						path = Paths.get(UPLOAD_FOLDER + File.separator
//								+ journal.getJournalAbbrName().toLowerCase().toLowerCase() + File.separator
//								+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_')
//								+ File.separator + updatedfileName);
//						fileVersion.setIssueId(Aid);
//						fileVersion.setFileName(updatedfileName);
//						fileVersion.setSize(attachment.getSize() + "bytes");
//						fileVersion.setTaskId(task.getId());
//						fileVersion.setFileType(attachment.getContentType());
//						fileVersion.setJournalId(JrID);
//						fileVersion.setFilePath(path.toString());
//						fileVersion.setFileVersion(taskscheduler.getAssignBackCount() + 1);
//						fileVersion.setCreated_by(users.getUserID());
//						fileVersion.setCreatedAt(new Date());
//						// fileVersionService.saveFileVersion(fileVersion);
//						count++;
//					}
//
//				}
//				if (count == 0) {
//					IssueFileVersion fileVersion = new IssueFileVersion();
//					fileVersion.setIssueId(Aid);
//					updatedfileName = attachment.getOriginalFilename();
//					path = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
//							+ File.separator + issueDetail.getIssue_id() + File.separator
//							+ task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
//					fileVersion.setFileName(attachment.getOriginalFilename());
//					fileVersion.setSize(attachment.getSize() + "bytes");
//					fileVersion.setTaskId(task.getId());
//					fileVersion.setFileType(attachment.getContentType());
//					fileVersion.setJournalId(JrID);
//					fileVersion.setFilePath(path.toString());
//					fileVersion.setFileVersion(taskscheduler.getAssignBackCount() + 1);
//					fileVersion.setCreated_by(users.getUserID());
//					fileVersion.setCreatedAt(new Date());
//					 fileVersionService.saveIssueFileVersion(fileVersion);
//
//				}
//
//				Files.write(path, bytes);
//
//				/// pending for task completed(final stage -->end of work)
//				if (workflowTaskSequ == null) {
//					List<TaskManagementVo> taskManagementVo = taskManagementService
//							.getmyTaskManagementList(users.getUserID());
//					model.put("taskScheduler", taskManagementVo);
//					return new ModelAndView("myTaskList");
//				} else {
//					IssueTaskScheduler taskPoolUpdate = issueTaskSchedulerService.getIssueSchedulerDetail(Aid,
//							nextTaskID);
//					if (userLIst.size() == 1) {
//						taskPoolUpdate.setTaskStatus("In Progress");
//						taskPoolUpdate.setUserId(userLIst.get(0).getId());
//						taskPoolUpdate.setTaskEstTimeFrom(new Date());
//					} else {
//						taskPoolUpdate.setTaskStatus("InPool");
//					}
//					issueTaskSchedulerService.saveTaskSchedulars(taskPoolUpdate);
//				}
//
//				CurrentIssueStatus currentIssueStatus = currentIssueServiceImpl.findCurrentIssueStatusBy(taskID, Aid);
//				currentIssueStatus.setTaskId(nextTaskID);
//				currentIssueServiceImpl.saveCurrentIssueS(currentIssueStatus);
//
//				taskscheduler.setTaskStatus("Completed");
//				taskscheduler.setRatingStar(0);
//				taskscheduler.setTaskEstTimeEnd(new Date());
//				issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//				issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(id);
//				issueTaskDetail.setTaskStatus("Completed");
//				issueTaskDetail.setCompletedDateTime(new Date());
//				issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//				model.addAttribute("message", taskName + " data has been successfully saved.");
//				model.addAttribute("css", "success");
//
//			} catch (IOException e) {
//				model.addAttribute("Error", "Error in uploading file please try again");
//				return showGroupTask(model, request, issueTaskDetail);
//
//			}
//		}
//		// mail trigger
//		// EmailJournalWorkflow emailJournalWorkflow =
//		// emailJournalWorkflowService.findByTaskId(taskID);
//		/*
//		 * emailJournalWorkflow.getBcc(); emailJournalWorkflow.getCc();
//		 */
//		// emailJournalWorkflow.getRole();
////		EmailTrigger trigger = new EmailTrigger();
////		trigger.setArticleId(Aid);
////		trigger.setTaskId(taskID);
////		trigger.setEtSubject(""+emailJournalWorkflow.getEmailTemp().getToSubject());
////		trigger.setEtBody(""+emailJournalWorkflow.getEmailTemp().getEditorData());
////		trigger.setEtTo("");
////		trigger.setEtBcc("");
////		trigger.setEtCc("");
////		trigger.setCreatedAt(new Date());
////		trigger.setCreatedBy(name);
////		emailTriggerService.save(trigger);
//		// fileServi.findbyAidJidTid(articleDetail.getArticle_id(),
//		// journal.getJournalId(), taskID);
//		/*
//		 * FileVersion fileversion = new FileVersion(); fileversion.setArticleId(Aid);
//		 * fileversion.setFileName(attachment.getOriginalFilename());
//		 * fileversion.setFilePath(path.toString());
//		 * 
//		 * int i = 0; for (byte b : bytes) { i += b; }
//		 * 
//		 * fileversion.setSize(attachment.getSize()+ "bytes");
//		 * fileversion.setCreatedAt(new Date()); fileversion.setFileVersion(1);
//		 * fileversion.setCreated_by(users.getUserID());
//		 * fileversion.setJournalId(journal.getJournalId());
//		 * fileversion.setTaskId(taskID); fileServi.saveFileVersion(fileversion);
//		 */
//		if (flag == "0") {
//			List<IssueTaskManagementVo> taskManagementVo = new ArrayList<IssueTaskManagementVo>();
//			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//			// int dptId = users.getGroup1().get(0).getDeptID();
//			for (Department dept : users.getGroup1()) {
//				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//				mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//			}
//
//			for (ManageJournalWorkflow manageJourWk : mjw) {
//				taskManagementVo.addAll(issueDetailService.getIssueTaskManagementGroupList(
//						manageJourWk.getWorkflow_id(), manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//			}
//			System.out.println(userDepartmentVo.toString());
//			model.put("userDepartment", userDepartmentVo);
//			System.out.println(mjw.toString());
//			model.put("taskManagementVo", taskManagementVo);
//			return new ModelAndView("Issue/IssueGroupTaskList");
//		} else {
//			List<IssueTaskManagementVo> taskManagementVo = issueDetailService
//					.getIssueTaskManagementList(users.getUserID());
//			model.put("taskScheduler", taskManagementVo);
//			return new ModelAndView("Issue/IssueMyTask");
//		}
//
//	}
//
//	@RequestMapping(value = "/issueApproveTask", method = RequestMethod.POST ,consumes = { "multipart/form-data" })
//	public ModelAndView approveTask(ModelMap model, HttpServletRequest request,@RequestParam MultipartFile attachment) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		String ID = request.getParameter("article_task_id");
//		int id = Integer.parseInt(ID);
//		model.put("article_task_id", id);
//		String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
//		String rating = request.getParameter("ratingStar");
//		int ratingStar = Integer.parseInt(rating);
//		LOGGER.debug("RatingI : " + rating);
//		String comments = request.getParameter("comments");
//
//		LOGGER.debug("comments : " + comments);
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		String flag = request.getParameter("flag");
//		int JrID = issueDetail.getJournalId();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		IssueTaskDetail issueTaskDetail = null;
//
//		IssueTaskScheduler taskscheduler = issueTaskSchedulerService.getIssueTaskScheById(id);
//		int taskID = taskscheduler.getTaskId();
//		TaskDetails task = taskService.getTaskNameBy(taskID);
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
//		// String approval = workflowTaskSeq.getApproval();
//		int nextTaskSequenceP = (workflowTaskSeq.getSequence() - 1);
//		int nextTaskSequenceNext = (workflowTaskSeq.getSequence() + 1);
//		WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(nextTaskSequenceP, workFlowID);
//		int prevTaskID = workflowTaskSequP.getTaskId();
//		WorkflowTaskSeq workflowTaskSequNext = workflowTaskService.getNextTaskIdBy(nextTaskSequenceNext, workFlowID);
//		if (workflowTaskSequNext == null) {
//
//			taskscheduler.setTaskStatus("Completed");
//			taskscheduler.setTaskEstTimeEnd(new Date());
//			// UPDATE TIME HEAR
//
//			issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//			issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(id);
//			;
//			issueTaskDetail.setTaskStatus("Completed");
//			issueTaskDetail.setCompletedDateTime(new Date());
//			issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//			IssueTaskScheduler taskschedulerprev = issueTaskSchedulerService.getIssueTaskScheById(id);
//			taskschedulerprev.setRatingStar(5);
//			taskschedulerprev.setComments(comments);
//			issueTaskSchedulerService.saveTaskSchedulars(taskschedulerprev);
//			List<IssueTaskManagementVo> taskManagementVo = issueDetailService
//					.getIssueTaskManagementList(users.getUserID());
//			model.put("taskScheduler", taskManagementVo);
//			model.addAttribute("css", "success");
//			model.addAttribute("message",
//					"Issue Title :\r\n" + issueDetail.getIssue_title() + "\r\n And \r\n" + "journal Abbr : \r\n"
//							+ issueDetail.getJournals().getJournalAbbrName() + " is completed successfully");
//			String msgBody = "Dear Author " + "\r\n" + "\r\n" + "Issue Title : " + issueDetail.getIssue_title()
//					+ "\r\n And \r\n" + "journal Name : " + issueDetail.getJournals().getJournalName()
//					+ " \r\n completed successfully in Unitouch\r\n" + "\r\n" + "Thanks,\r\n" + "Unitouch\r\n" + "";
//			String msgSubject = "Automated Email: Unitouch ";
//			EmailEngineUnitouch.sendEmailAttachement(EmailEnum.to, msgSubject, msgBody);
//			return new ModelAndView("myTaskList");
//		}
//		System.out.println("workflowTaskSequNext-->" + workflowTaskSequNext.toString());
//		int roleId = workflowTaskSequNext.getRoleId();
//		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
//				(JrID), (roleId), workflowTaskSequNext.getTaskId());
//		System.out.println("manageJournalWorkflow---->" + manageJournalWorkflow.toString());
//		int deptId = manageJournalWorkflow.getDept_id();
//		UserDepartment userDepartment = new UserDepartment();
//		userDepartment.setDeptID(deptId);
//		List<UserVo> userLIst = departmentService.getUserNameByDeptID(userDepartment);
//		IssueComment issueComment = new IssueComment();
//		issueComment.setIssueId(Aid);
//		issueComment.setTaskid(taskscheduler.getTaskId());
//		issueComment.setJid(JrID);
//		issueComment.setUserName(users.getFirstName() + " " + users.getLastName());
//		issueComment.setCommentDate(new Date());
//		issueComment.setRoleid(users.getGroup1().get(0).getRole().getRoleID());
//		issueComment.setIssueComments(comments);
//		issueDetailService.IssueCommentSave(issueComment);
//		
//		// byte[] bytes = approval.getBytes();
//		if (!new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//				+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_')).exists()) {
//			new File(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//					+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_')).mkdirs();
//		}
//		TaskDetails prevtask = taskService.getTaskNameBy(prevTaskID);
//		Path TO = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//				+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_'));
//		Path From = Paths
//				.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
//						+ issueDetail.getIssue_id() + File.separator + prevtask.getTaskName().replace(' ', '_'));
//		File target = new File(From.toString());
//		String fileName = "";
//		File[] listOfFiles = target.listFiles();
//		for (int i = 0; i < listOfFiles.length; i++) {
//			if (listOfFiles[i].isFile()) {
//				LOGGER.debug("File " + listOfFiles[i].getName());
//				fileName = listOfFiles[i].getName();
//			} else if (listOfFiles[i].isDirectory()) {
//				LOGGER.debug("Directory " + listOfFiles[i].getName());
//			}
//		}
//		Path sourcePath = Paths.get(From.toString() + "/" + fileName);
//		Path targetPath = Paths.get(TO.toString() + "/" + fileName);
//
//		try {
//			Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);// copy with
//			if(!attachment.isEmpty()) {																					// REPLACE_EXISTING
//			byte[]	bytes = attachment.getBytes();												// option
//			Files.write(path, bytes);
//			IssueFileVersion fileVersion = new IssueFileVersion();
//			fileVersion.setIssueId(Aid);
//			String updatedfileName = attachment.getOriginalFilename();
//			path = Paths.get(UPLOAD_FOLDER + File.separator + journal.getJournalAbbrName().toLowerCase()
//					+ File.separator + issueDetail.getIssue_id() + File.separator
//					+ task.getTaskName().replace(' ', '_') + File.separator + updatedfileName);
//			fileVersion.setFileName(attachment.getOriginalFilename());
//			fileVersion.setSize(attachment.getSize() + "bytes");
//			fileVersion.setTaskId(task.getId());
//			fileVersion.setFileType(attachment.getContentType());
//			fileVersion.setJournalId(JrID);
//			fileVersion.setFilePath(path.toString());
//			fileVersion.setFileVersion(taskscheduler.getAssignBackCount() + 1);
//			fileVersion.setCreated_by(users.getUserID());
//			fileVersion.setCreatedAt(new Date());
//			 fileVersionService.saveIssueFileVersion(fileVersion);
//			LOGGER.debug("Target file Path : " + path);
//			}
//			LOGGER.debug("Target file Path : " + path);
//			LOGGER.debug("Copied Content : \n" + new String(Files.readAllBytes(path)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// FileUtils.copyDirectory(source, target);
//		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
//
//		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
//
//		if (workflowTaskSequ == null) {
//			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
//			model.addAttribute("css", "success");
//			model.addAttribute("message", "All Task is Completed successfully");
//			model.put("taskScheduler", taskManagementVo);
//			taskscheduler.setTaskStatus("Completed");
//			taskscheduler.setTaskEstTimeEnd(new Date());
//			// UPDATE TIME HEAR
//			issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//			// taskService.saveTaskSchedulerStatus(taskscheduler);
//			issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(id);
//			issueTaskDetail.setTaskStatus("Completed");
//			issueTaskDetail.setCompletedDateTime(new Date());
//			issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//			int prevId = (id - 1);
//			TaskScheduler taskschedulerprev = taskService.findtaskDetailById(prevId);
//			taskschedulerprev.setRatingStar(ratingStar);
//			taskschedulerprev.setComments(comments);
//			taskService.saveTaskSchedulerStatus(taskschedulerprev);
//			return new ModelAndView("myTaskList");
//		} else {
//			IssueTaskScheduler taskPoolUpdate = issueTaskSchedulerService.getIssueSchedulerDetail(Aid,
//					workflowTaskSequ.getTaskId());
//			// TaskScheduler taskPoolUpdate = taskService.getRunId(Aid,
//			// workflowTaskSequ.getTaskId());
//			if (userLIst.size() == 1) {
//
//				taskPoolUpdate.setTaskStatus("In Progress");
//				taskPoolUpdate.setUserId(userLIst.get(0).getId());
//				taskPoolUpdate.setTaskEstTimeFrom(new Date());
//			} else {
//				taskPoolUpdate.setTaskStatus("InPool");
//			}
//			issueTaskSchedulerService.saveTaskSchedulars(taskPoolUpdate);
//		}
//		int nextTaskID = workflowTaskSequ.getTaskId();
//		CurrentIssueStatus currentIssueStatus = currentIssueServiceImpl.findCurrentIssueStatusBy(taskID, Aid);
//		currentIssueStatus.setTaskId(nextTaskID);
//		currentIssueServiceImpl.saveCurrentIssueS(currentIssueStatus);
//
//		taskscheduler.setTaskStatus("Completed");
//		taskscheduler.setTaskEstTimeEnd(new Date());
//		// UPDATE TIME HEAR
//		issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//		issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(id);
//		issueTaskDetail.setTaskStatus("Completed");
//		issueTaskDetail.setCompletedDateTime(new Date());
//		issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//		int prevId = (id - 1);
//		IssueTaskScheduler taskschedulerprev = issueTaskSchedulerService.getIssueTaskScheById(prevId);
//		taskschedulerprev.setRatingStar(ratingStar);
//		taskschedulerprev.setComments(comments);
//		issueTaskSchedulerService.saveTaskSchedulars(taskschedulerprev);
//
//		if (flag == "0") {
//
//			List<IssueTaskManagementVo> taskManagementVo = new ArrayList<IssueTaskManagementVo>();
//			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//			// int dptId = users.getGroup1().get(0).getDeptID();
//			for (Department dept : users.getGroup1()) {
//				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//				mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//			}
//
//			for (ManageJournalWorkflow manageJourWk : mjw) {
//				taskManagementVo.addAll(issueDetailService.getIssueTaskManagementGroupList(
//						manageJourWk.getWorkflow_id(), manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//			}
//			System.out.println(userDepartmentVo.toString());
//			model.put("userDepartment", userDepartmentVo);
//			System.out.println(mjw.toString());
//			model.put("taskManagementVo", taskManagementVo);
//			return new ModelAndView("Issue/IssueGroupTaskList");
//		} else {
////			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
////			model.put("taskScheduler", taskManagementVo);
//			List<IssueTaskManagementVo> taskManagementVo = issueDetailService
//					.getIssueTaskManagementList(users.getUserID());
//			model.put("taskScheduler", taskManagementVo);
//			return new ModelAndView("Issue/IssueMyTask");
//		}
//	}
//
//	@RequestMapping(value = { "/editGetIssueData" })
//	public ModelAndView getIssueData(ModelMap model, HttpServletRequest request) {
//		List<ArticleDetail> issueArticleSeq = new ArrayList<ArticleDetail>();
//		List<Journal> journalList = journalService.getallList();
//		model.put("journallist", journalList);
//		List<Publisher> publisher = publisherService.getallList();
//		model.put("publisherList", publisher);
//		String issueId = request.getParameter("issueId");
//		IssueDetail issueData = issueDetailService.getIsuuelistbyid(Integer.parseInt(issueId));
//		model.put("issueData", issueData);
//		CopyOnWriteArrayList<ArticleDetail> articleList = articleService
//				.getunassignedArticleListbyJrId(issueData.getJournalId());
//		int i = 0;
//		for (ArticleDetail articleDetail : articleList) {
//			for (IssueArticle issueArticle : issueData.getIsssueArticle()) {
//				if (articleDetail.getArticle_id().intValue() == issueArticle.getArticleId().intValue()) {
//					System.out.println("ar -> " + articleDetail.toString());
//					issueArticleSeq.addAll(articleList);
//					articleList.remove(i);
//					i--;
//				}
//			}
//			i++;
//		}
//		System.out.println("issueArticleSeq-->" + issueArticleSeq.toString());
//		List<IssueSequence> issueSeq = issueSequenceService.getAllElements(Integer.parseInt(issueId));
//		System.out.println(issueData.toString());
//		Journal journal = journalService.getJournalNameby(issueData.getJournalId());
//		model.put("journal", journal);
//
//		Workflow workflow = workflowService.findworkflowbyname(journal.getIssueWorkflowId());
//		model.put("workflow", workflow);
//		model.put("ArticleDetail", articleList);
//		LOGGER.debug("articleList :" + articleList.toString());
//		model.put("articleIssue", articleList);
//		model.put("issueSeq", issueSeq);
//		return new ModelAndView("Issue/editeIssueMakeupList");
//
//	}
//
//	@RequestMapping(value = "editeCreateIsserSeq", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ApplicationResponse> createIsserSeq(@RequestParam("files") MultipartFile files[],
//			HttpServletRequest request, @RequestParam String filedata, @RequestParam String jrID,
//			@RequestParam String issueID) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Integer issueId = 0;
//		Integer filecount = 0;
//		int count = 1;
//		List<IssueSequencePublicationHistory> history = new ArrayList<IssueSequencePublicationHistory>();
//		List<IssueSequence> issueList = issueSequenceService.getAllElements(Integer.parseInt(issueID));
//		for (IssueSequence issueSequence : issueList) {
//			IssueSequencePublicationHistory issueHistory= new IssueSequencePublicationHistory();
//			issueHistory.setArticleDoi(issueSequence.getArticleDoi());
//			issueHistory.setArticletitle(issueSequence.getArticletitle());
//			issueHistory.setCoverArticleId(issueSequence.getCoverArticleId());
//			issueHistory.setFileFlag(issueSequence.getFileFlag());
//			issueHistory.setFilePath(issueSequence.getFilePath());
//			issueHistory.setIspId(issueSequence.getIspId());
//			issueHistory.setIssueId(issueSequence.getIssueId());
//			issueHistory.setjId(issueSequence.getjId());
//			issueHistory.setSequenceNo(issueSequence.getPage_from());
//			issueHistory.setPages(issueSequence.getPages());
//			issueHistory.setReadOnly(issueSequence.getReadOnly());
//			issueHistory.setTo_page(issueSequence.getTo_page());
//			issueHistory.setSequenceNo(issueSequence.getSequenceNo());
//			issueHistory.setUpdatedAt(DateApi.getCurrentIndianTimeFormet());
//			issueHistory.setUpdatedBy(name);
//			issueHistory.setWorkflowid(issueSequence.getWorkflowid());
//			history.add(issueHistory);
//		}
//		boolean status = issueSequenceService.saveIssueSequencePublicationHistory(history);
//		if (status) {
//			status = issueSequenceService.deleteFromIssuePublication(Integer.parseInt(issueID));
//			if (!status) {
//				ApplicationResponse applicatonResponse = new ApplicationResponse();
//				applicatonResponse.setMessage("Error in Editing a Issue ");
//				return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.EXPECTATION_FAILED);
//			} else {
//				Journal journal = journalService.getjournalbyId(Integer.parseInt(jrID));
//
////		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.getTaskId(journal.getArticleWorkflowId());
//				ApplicationResponse applicatonResponse = new ApplicationResponse();
//				JSONArray array = new JSONArray(filedata);
//				for (int i = 0; i < array.length(); i++) {
//					IssueSequence issueSequence = new IssueSequence();
//					JSONObject object = array.getJSONObject(i);
//					System.out.println(object.getString("articleId"));
//					System.out.println(object.getString("pages"));
//					issueSequence.setArticleDoi(object.getString("articleDOI"));
//					issueSequence.setPage_from(Integer.parseInt(object.getString("pageFrom")));
//					issueSequence.setTo_page(Integer.parseInt(object.getString("pageTo")));
//					issueSequence.setSequenceNo(count++);
//					issueId = Integer.parseInt(object.getString("issueId"));
//					issueSequence.setArticletitle(object.getString("articletitle"));
//					if (object.getString("pages").equals("")) {
//						issueSequence.setPages(0);
//					} else {
//						issueSequence.setPages(Integer.parseInt(object.getString("pages")));
//					}
//					issueSequence.setCoverArticleId(object.getString("articleId"));
//					if (object.getString("articleDOI").equalsIgnoreCase("Remove")) {
//						issueSequence.setArticleDoi("Remove");
//						if(files.length<0) {
//							issueSequence.setFileFlag("no file found");
//						}else {
//						issueSequence.setFileFlag(files[filecount].getName());
//						}
//						if (!files[filecount].isEmpty()) {
//							try {
//								byte[] bytes = files[filecount].getBytes();
//								if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
//										+ File.separator + issueId + File.separator + "Origin").exists()) {
//									new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
//											+ File.separator + issueId + File.separator + "Origin").mkdirs();
//								}
//
//								Path path = Paths
//										.get(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
//												+ File.separator + issueId + File.separator + "Origin" + File.separator
//												+ files[filecount].getOriginalFilename());
//								// FileVersion fileVersion = new FileVersion();
//
//								// fileversionservice.saveFileVersion(fileVersion);
//								Files.write(path, bytes);
//								issueSequence.setFilePath(path.toString());
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//						LOGGER.debug(object.getString("articleId") + " : :cover Id we got");
//						filecount++;
//					} else {
//						ArticleDetail articleDetails = articleService.findByAid(object.getString("articleId"));
//						IssueArticle issueArticle = new IssueArticle();
//						issueArticle.setArticleId(articleDetails.getArticle_id());
//						issueArticle.setIssueId(Integer.parseInt(object.getString("issueId")));
//						issueArticleService.SaveIssueArticle(issueArticle);
//					}
//					issueSequence.setWorkflowid(Integer.parseInt(object.getString("workflowid")));
//					issueSequence.setjId(Integer.parseInt(object.getString("jId")));
//					issueSequence.setCreatedAt(new Date());
//					issueSequence.setCreatedBy(name);
//					issueSequence.setIssueId(Integer.parseInt(object.getString("issueId")));
//
//					LOGGER.debug("----------------------");
//					LOGGER.debug("issue ::" + issueSequence.toString());
//					issueSequenceService.Save(issueSequence);
//				}
//
//				List<IssueSequence> issueList1 = issueSequenceService.getAllElements(issueId);
//				LOGGER.debug("issueList ------------------------------:: " + issueList.toString());
//				System.out.println(issueId);
//				applicatonResponse.setPayload(issueList1);
//				applicatonResponse.setMessage("OK");
//				return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
//			}
//		} else {
//			ApplicationResponse applicatonResponse = new ApplicationResponse();
//			applicatonResponse.setMessage("Error in Editing a Issue ");
//			return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//
//	
//	
//	@RequestMapping(value = { "/skipIssueTasks" })
//	public ModelAndView skipTasks(ModelMap model, HttpServletRequest request, CurrentArticleStatus currentArticleStatus,
//			TaskDetails taskDetails) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		String currentTaskID = request.getParameter("article_task_id");
//		int currentTaskid = Integer.parseInt(currentTaskID);
//		String ID = request.getParameter("id");
//		int Taskid = Integer.parseInt(ID);
//		model.put("id", Taskid);
//		String flag = request.getParameter("flag");
//		String assignReason = request.getParameter("assign_reason");
//		String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
////		****************************************************
//
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		int JrID = issueDetail.getJournalId();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);
//		int EndCount = workflowTaskSeq.getSequence();
//		IssueTaskScheduler issueTaskschedulerup = issueTaskSchedulerService.getIssueTaskScheById(currentTaskid);
//		//IssueTaskScheduler issueTaskschedulerup = taskService.findtaskDetailById(currentTaskid);
//		issueTaskschedulerup.setTaskStatus("Completed");
//		issueTaskschedulerup.setTaskEstTimeEnd(new Date());
//		issueTaskSchedulerService.saveTaskSchedulars(issueTaskschedulerup);
//		WorkflowTaskSeq workflowTaskSeqSt = workflowTaskService.gettaskDetailsbyid(issueTaskschedulerup.getTaskId(),
//				workFlowID);
//		int StratCount = workflowTaskSeqSt.getSequence() + 1;
//		for (int i = StratCount; i < EndCount; i++) {
//			WorkflowTaskSeq workflowTaskSequP = workflowTaskService.getNextTaskIdBy(i, workFlowID);
//			IssueTaskScheduler taskschedulerEach = issueTaskSchedulerService.getIssueSchedulerDetail(Aid,workflowTaskSequP.getTaskId());
//			taskschedulerEach.setTaskStatus("Skiped");
//			taskschedulerEach.setTaskEstTimeEnd(new Date());
//			taskschedulerEach.setTaskEstTimeFrom(new Date());
//			issueTaskSchedulerService.saveTaskSchedulars(taskschedulerEach);
//
//		}
//	
//		IssueTaskScheduler taskscheduler = issueTaskSchedulerService.getIssueSchedulerDetail(Aid, taskDetails.getId());
//		taskscheduler.setTaskStatus("InPool");
//		taskscheduler.setAssignReason(taskscheduler.getAssignReason() + " = " + assignReason + ":: BY"
//				+ users.getFirstName() + " " + users.getLastName());
//	
//		issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//		CurrentIssueStatus currentArticleStatus1 =  currentIssueServiceImpl.findIssuetatusById(Aid);
//		currentArticleStatus1.setTaskId(taskDetails.getId());
//		currentIssueServiceImpl.saveCurrentIssueS(currentArticleStatus1);
//		model.put("article_task_id", currentTaskid);
//		IssueTaskDetail issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(currentTaskid, Aid);
//		issueTaskDetail.setTaskStatus("Skiped");
//		IssueComment issueCom= new IssueComment();
//		issueCom.setIssueId(Aid);
//		issueCom.setTaskid(taskscheduler.getTaskId());
//		issueCom.setJid(JrID);
//		issueCom.setUserName(users.getFirstName()+" "+users.getLastName());
//		issueCom.setCommentDate(new Date());
//		issueCom.setIssueComments(assignReason);
//		issueCom.setRoleid(users.getGroup1().get(0).getRole().getRoleID());
//		issueDetailService.IssueCommentSave(issueCom);
//		issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//		if (flag == "0") {
//
//			List<IssueTaskManagementVo> taskManagementVo = new ArrayList<IssueTaskManagementVo>();
//			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//			// int dptId = users.getGroup1().get(0).getDeptID();
//			for (Department dept : users.getGroup1()) {
//				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//				mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//			}
//
//			for (ManageJournalWorkflow manageJourWk : mjw) {
//				taskManagementVo.addAll(issueDetailService.getIssueTaskManagementGroupList(
//						manageJourWk.getWorkflow_id(), manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//			}
//			System.out.println(userDepartmentVo.toString());
//			model.put("userDepartment", userDepartmentVo);
//			System.out.println(mjw.toString());
//			model.put("taskManagementVo", taskManagementVo);
//			return new ModelAndView("Issue/IssueGroupTaskList");
//		} else {
//			List<IssueTaskManagementVo> taskManagementVo = issueDetailService
//					.getIssueTaskManagementList(users.getUserID());
//			model.put("taskScheduler", taskManagementVo);
//			return new ModelAndView("Issue/IssueMyTask");
//		}
//	}
//	
//	@RequestMapping(value = { "/issueAssignBack" })
//	public ModelAndView AssignBack(ModelMap model, HttpServletRequest request,
//			CurrentArticleStatus currentArticleStatus, TaskDetails taskDetails) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//		String currentTaskID = request.getParameter("article_task_id");
//		int currentTaskid = Integer.parseInt(currentTaskID);
//		String ID = request.getParameter("id");
//		int Taskid = Integer.parseInt(ID);
//		model.put("id", Taskid);
//		String flag = request.getParameter("flag");
//		String assignReason = request.getParameter("assign_reason");
//		String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
////		****************************************************
//
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		int JrID = issueDetail.getJournalId();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(Taskid, workFlowID);
//	//	int StratCount = workflowTaskSeq.getSequence();
//
//		List<WorkflowTaskSeq> workflowTaskSeqsList = workflowTaskService.workflowTaskSeqlist(workFlowID);
//		int count = 0;
//		for (WorkflowTaskSeq workflowBack : workflowTaskSeqsList) {
//			if (workflowBack.getId() == workflowTaskSeq.getId()) {
//				WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(count, workFlowID);
//				int taskid = workflowTaskSeqtask.getTaskId();
//				issueTaskSchedulerService.changeIssueTaskStatusUserDel(Aid, taskid, workFlowID, "In Progress");
//				count++;
//				IssueTaskScheduler issueTaskscheduler = issueTaskSchedulerService.getIssueSchedulerDetail(Aid, taskid);//findtaskDetailBytaskIdarticleid(taskid, Aid);
//				issueTaskscheduler.setTaskStatus("Yet-to-Start");
//				int assignBackCount = (issueTaskscheduler.getAssignBackCount() + 1);
//				String assignreason = issueTaskscheduler.getAssignReason();
//				String toReason="";
//				if(assignreason==null) {
//					 toReason= assignBackCount + " : "+ assignReason + ":: BY" + users.getFirstName() + " " + users.getLastName();
//					issueTaskscheduler.setAssignReason(toReason.trim());
//				}
//				else {
//					toReason=issueTaskscheduler.getAssignReason() + "**" + assignBackCount + " = "+ assignReason + ":: BY" + users.getFirstName() + " " + users.getLastName();
//					issueTaskscheduler.setAssignReason(toReason.trim());
//					
//				}
//				IssueComment issueComment= new IssueComment();
//				issueComment.setIssueId(Aid);
//				issueComment.setTaskid(issueTaskscheduler.getTaskId());
//				issueComment.setJid(JrID);
//				issueComment.setUserName(users.getFirstName()+" "+users.getLastName());
//				issueComment.setCommentDate(new Date());
//				issueComment.setIssueComments(assignReason);
//				issueComment.setRoleid(users.getGroup1().get(0).getRole().getRoleID());
//				issueDetailService.IssueCommentSave(issueComment);;
////				taskscheduler.setAssign_reason(taskscheduler.getAssign_reason() + "**" + assignBackCount + " = "
////						+ assignReason + ":: BY" + users.getFirstName() + " " + users.getLastName());
//
//				issueTaskscheduler.setAssignBackCount(assignBackCount);
//				issueTaskSchedulerService.saveTaskSchedulars(issueTaskscheduler);
//			}
//			if (workflowBack.getId() == workflowTaskSeq.getId()) {
//
//				for (int swq = count; swq < workflowTaskSeqsList.size(); swq++) {
//					WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(swq, workFlowID);
//					int taskid = workflowTaskSeqtask.getTaskId();
//					issueTaskSchedulerService.changeIssueTaskStatusUserDel(Aid, taskid, workFlowID, "Yet-to-Start");
////				TaskScheduler taskScheduler= taskService.getTaskScheduler(Aid, taskid, workFlowID);
////				if(taskScheduler.getUser_id()!=null) {
////					ArticleTaskDetail articleTaskDetail = articleTaskDetailService.findtaskDetailById(taskScheduler.getArticle_task_id(),Aid);
////					articleTaskDetail.setTask_status("Yet-to-Start");
////					articleTaskDetail.setUser_id(0);
////					articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
////				}
//				}
//			}
//			count++;
//		}
//
////		int size = workflowTaskSeqsList.size();
////
////		for (int i = StratCount-1; i < size; i++) {
////
////			WorkflowTaskSeq workflowTaskSeqtask = workflowTaskService.getNextTaskIdBy(i, workFlowID);
////			int taskid = workflowTaskSeqtask.getTaskId();
////			taskService.deleteusers(Aid, taskid, workFlowID);
//////			public void deleteusers(int aid, int taskid, int workFlowID);
////		}
////		**************************************************************
//	
//		CurrentIssueStatus currentIssueStatus = currentIssueServiceImpl.findIssuetatusById(Aid);
//		currentIssueStatus.setTaskId(taskDetails.getId());
//		currentIssueServiceImpl.saveCurrentIssueS(currentIssueStatus);
//
//		model.put("article_task_id", currentTaskid);
//		IssueTaskScheduler issuetaskscheduler = issueTaskSchedulerService.getIssueTaskScheById(currentTaskid); // articleTaskId pk
//		issuetaskscheduler.setTaskStatus("Yet-to-Start");
//		issuetaskscheduler.setAssignReason(assignReason);
//		/*	IssueTaskScheduler taskschedulerprev = issueTaskSchedulerService.getIssueTaskScheById(prevId);
//		 * ArticleComment ac= new ArticleComment(); ac.setAid(Aid);
//		 * ac.setTaskid(taskscheduler.getTask_id()); ac.setJid(JrID);
//		 * ac.setCommentDate(new Date());
//		 * ac.setUserName(users.getFirstName()+" "+users.getLastName());
//		 * ac.setRoleid(users.getGroup1().get(0).getRole().getRoleID());
//		 * ac.setComment(assignReason); articleService.save(ac);
//		 */
//		int assignBackCount = (issuetaskscheduler.getAssignBackCount() + 1);
//		issuetaskscheduler.setAssignBackCount(assignBackCount);
//		issueTaskSchedulerService.saveTaskSchedulars(issuetaskscheduler);
//		IssueTaskDetail articleTaskDetail = issueTaskDetailService.getIssueTaskScheById(currentTaskid, Aid);//findtaskDetailById(currentTaskid, Aid);
//		articleTaskDetail.setTaskStatus("Rejected");
//		issueTaskDetailService.saveIssueTaskDetail(articleTaskDetail);
//		if (flag == "0") {
//
//			List<IssueTaskManagementVo> taskManagementVo = new ArrayList<IssueTaskManagementVo>();
//			List<userDepartmentVo> userDepartmentVo = new ArrayList<userDepartmentVo>();
//			List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//			// int dptId = users.getGroup1().get(0).getDeptID();
//			for (Department dept : users.getGroup1()) {
//				userDepartmentVo.addAll(taskManagementService.getuserlistbydeptId(dept.getDeptID()));
//				mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//			}
//
//			for (ManageJournalWorkflow manageJourWk : mjw) {
//				taskManagementVo.addAll(issueDetailService.getIssueTaskManagementGroupList(
//						manageJourWk.getWorkflow_id(), manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//			}
//			System.out.println(userDepartmentVo.toString());
//			model.put("userDepartment", userDepartmentVo);
//			System.out.println(mjw.toString());
//			model.put("taskManagementVo", taskManagementVo);
//			return new ModelAndView("Issue/IssueGroupTaskList");
//		} else {
//			List<IssueTaskManagementVo> taskManagementVo = issueDetailService
//					.getIssueTaskManagementList(users.getUserID());
//			model.put("taskScheduler", taskManagementVo);
//			return new ModelAndView("Issue/IssueMyTask");
//		}
//	}
//	
//	@RequestMapping(value = "/completeIssueProxyTask", method = RequestMethod.POST, consumes = { "multipart/form-data" })
//	public RedirectView CompleteProxyTask(ModelMap model, HttpServletRequest request,
//			@RequestParam MultipartFile[] attachmentList) {
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
//
//		String ID = request.getParameter("article_task_id");
//		int id = Integer.parseInt(ID);
//		model.put("article_task_id", id);
//		String aid = request.getParameter("article_id");
//		int Aid = Integer.parseInt(aid);
//		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Aid);
//		// String arID = articleDetail.getAid();
//		String flag = request.getParameter("flag");
//		int JrID = issueDetail.getJournalId();
//		Journal journal = journalService.getJournalNameby(JrID);
//		int workFlowID = journal.getIssueWorkflowId();
//		IssueTaskDetail issueTaskDetail = null;
//		IssueTaskScheduler taskscheduler = issueTaskSchedulerService.getIssueTaskScheById(id);
//		int taskID = taskscheduler.getTaskId();
//		TaskDetails task = taskService.getTaskNameBy(taskID);
//		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
//		// for current task seq list^|
//		String approval = workflowTaskSeq.getApproval();
//		int roleId = workflowTaskSeq.getRoleId();
//		ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
//				(workFlowID), (JrID),(roleId),workflowTaskSeq.getTaskId());
//		int deptId=manageJournalWorkflow.getDept_id();
//		UserDepartment userDepartment=new UserDepartment();
//		userDepartment.setDeptID(deptId);
//		List<UserVo> userLIst=departmentService.getUserNameByDeptID( userDepartment);
//		// String taskname = task.getTaskName();
//		Path path = null;
//		byte[] bytes = null;
//		int taskcoun = 0;
//		for (MultipartFile attachment : attachmentList) {
//			
//		
//		if (!attachment.isEmpty()) {
//
//			try {
//				bytes = attachment.getBytes();
//				if (!new File(UPLOAD_FOLDER + File.separator+ journal.getJournalAbbrName().toLowerCase() + File.separator
//						+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_'))
//								.exists()) {
//					new File(UPLOAD_FOLDER + File.separator+ journal.getJournalAbbrName().toLowerCase() + File.separator
//							+ issueDetail.getIssue_id()+ File.separator + task.getTaskName().replace(' ', '_'))
//									.mkdirs();
//				}
//
//				List<IssueFileVersion> filevVersion1 = fileVersionService.findbyissueIdJid(Aid, JrID);//(Aid, JrID);
//				String updatedfileName = "";
//				int count = 0;
//				for (IssueFileVersion fileVersion : filevVersion1) {
//					if (fileVersion.getFileName().equalsIgnoreCase(attachment.getOriginalFilename())) {
//						updatedfileName = FileVersionChange.versionChange(attachment.getOriginalFilename(),
//								fileVersion.getFileVersion() + 1);
//						path = Paths.get(UPLOAD_FOLDER + File.separator+ journal.getJournalAbbrName().toLowerCase() + File.separator
//								+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_')
//								+ File.separator + updatedfileName);
//						fileVersion.setIssueId(Aid);
//						fileVersion.setFileName(updatedfileName);
//						fileVersion.setIssueId(issueDetail.getIssue_id());
//						fileVersion.setSize(attachment.getSize() + "bytes");
//						fileVersion.setTaskId(task.getId());
//						fileVersion.setFileType(attachment.getContentType());
//						fileVersion.setJournalId(JrID);
//						fileVersion.setFilePath(path.toString());
//						fileVersion.setFileVersion(taskscheduler.getAssignBackCount());
//						fileVersion.setCreated_by(users.getUserID());
//						fileVersion.setCreatedAt(new Date());
//						fileVersionService.saveIssueFileVersion(fileVersion);
//						count++;
//					}
//
//				}
//				if (count == 0) {
//					IssueFileVersion fileVersion = new IssueFileVersion();
//					fileVersion.setId(Aid);
//					updatedfileName = attachment.getOriginalFilename();
//					path = Paths.get(UPLOAD_FOLDER + File.separator+ journal.getJournalAbbrName().toLowerCase() + File.separator
//							+ issueDetail.getIssue_id() + File.separator + task.getTaskName().replace(' ', '_')
//							+ File.separator + updatedfileName);
//					fileVersion.setFileName(attachment.getOriginalFilename());
//					fileVersion.setSize(attachment.getSize() + "bytes");
//					fileVersion.setTaskId(task.getId());
//					fileVersion.setIssueId(issueDetail.getIssue_id());
//					fileVersion.setFileType(attachment.getContentType());
//					fileVersion.setJournalId(JrID);
//					fileVersion.setFilePath(path.toString());
//					fileVersion.setFileVersion(taskscheduler.getAssignBackCount());
//					fileVersion.setCreated_by(users.getUserID());
//					fileVersion.setCreatedAt(new Date());
//					fileVersionService.saveIssueFileVersion(fileVersion);
//				}
//				Files.write(path, bytes);
//
//				// for next task Sequence
//				int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
//				WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
//
//				// for next to next task Sequence
//				// WorkflowTaskSeq taskSequNTN =
//				// workflowTaskService.getNextTaskIdBy(nextTaskSequence + 1, workFlowID);
//			
//
//				/// pending for task completed(final stage -->end of work)
//				if (workflowTaskSequ == null) {
//					List<TaskManagementVo> taskManagementVo = taskManagementService
//							.getmyTaskManagementList(users.getUserID());
//					model.put("taskScheduler", taskManagementVo);
//					RedirectView rv = new RedirectView();
//					rv.setContextRelative(true);
//					rv.setUrl("/dashboard");
//					return rv;
//				} else {
//
//					if(userLIst.size()==1) {
//						if(taskcoun==0) {
//						int nextTaskID = workflowTaskSequ.getTaskId();
//						IssueTaskScheduler taskPoolUpdate = issueTaskSchedulerService.getIssueSchedulerDetail(Aid, nextTaskID);//findtaskDetailById(currentTaskid, Aid);
//						
//					//	IssueTaskScheduler taskPoolUpdate = taskService.getRunId(Aid, nextTaskID);
//						taskPoolUpdate.setTaskStatus("In Progress");
//						taskPoolUpdate.setUserId(userLIst.get(0).getId());
//						taskPoolUpdate.setSchEndTime(new Date());
//						issueTaskSchedulerService.saveTaskSchedulars(taskPoolUpdate);
//						IssueTaskDetail issuetaskDetails = new IssueTaskDetail();
//						issuetaskDetails.setIssueTaskId(taskscheduler.getIssueTaskId());
//						issuetaskDetails.setIssueId(taskscheduler.getIssueId());
//						issuetaskDetails.setStartDateTime(new Date());	
//						issuetaskDetails.setUserId(userLIst.get(0).getId());
//						issuetaskDetails.setTaskStatus("In Progress");
//						issueTaskDetailService.saveIssueTaskDetail(issuetaskDetails);
//						LOGGER.debug("atd :" + issuetaskDetails.toString());
//					}
//						}else 
//					{
//						int nextTaskID = workflowTaskSequ.getTaskId();
//						IssueTaskScheduler taskPoolUpdate = issueTaskSchedulerService.getIssueSchedulerDetail(Aid, nextTaskID);
//						taskPoolUpdate.setTaskStatus("InPool");
//						issueTaskSchedulerService.saveTaskSchedulars(taskPoolUpdate);
//					}
//					/*
//					 * articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
//					 * articleTaskDetail.setTask_status("InPool");
//					 * articleTaskDetail.setCompleted_date_time(new Date());
//					 * articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
//					 */
//				}
//				int nextTaskID = workflowTaskSequ.getTaskId();
//				if(taskcoun==0) { // only one type uppdate in current article Status
//				CurrentIssueStatus currentArticleStatus = currentIssueServiceImpl.findCurrentIssueStatusBy(taskID, Aid);//(taskID, Aid);
//				currentArticleStatus.setTaskId(nextTaskID);
//				currentIssueServiceImpl.saveCurrentIssueS(currentArticleStatus);
//				}
//				taskscheduler.setTaskStatus("Completed_by_Proxy");
//				taskscheduler.setRatingStar(0);
//				taskscheduler.setTaskEstTimeEnd(new Date());
//				issueTaskSchedulerService.saveTaskSchedulars(taskscheduler);
//				
//				if(taskcoun==0) {
//					issueTaskDetail = issueTaskDetailService.getIssueTaskScheById(id);
//				if(issueTaskDetail==null) {
//					IssueTaskDetail issueTask= new IssueTaskDetail();
//					issueTask.setIssueId(Aid);
//					issueTask.setIssueTaskId(id);
//					issueTask.setUserId(users.getUserID());
//					issueTask.setTaskStatus("Completed_by_Proxy");
//					issueTask.setStartDateTime(new Date());
//					issueTask.setCompletedDateTime(new Date());
//					issueTaskDetailService.saveIssueTaskDetail(issueTask);
//				}else {
//				issueTaskDetail.setTaskStatus("Completed_by_Proxy");
//				issueTaskDetail.setCompletedDateTime(new Date());
//				issueTaskDetailService.saveIssueTaskDetail(issueTaskDetail);
//				}
//				}	
//				} catch (IOException e) {
//				model.addAttribute("Error", "Error in uploading file please try again");
//				RedirectView rv = new RedirectView();
//				rv.setContextRelative(true);
//				rv.setUrl("/dashboard");
//				return rv;
//
//			}
//		}
//		taskcoun++;
//		}
//		RedirectView rv = new RedirectView();
//		rv.setContextRelative(true);
//		rv.setUrl("/dashboard");
//		return rv;
//	}
//	}
