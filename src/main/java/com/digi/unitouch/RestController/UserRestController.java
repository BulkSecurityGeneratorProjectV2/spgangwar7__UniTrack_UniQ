package com.digi.unitouch.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.ArticleTaskDetail;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.SchedularRepo;
import com.digi.unitouch.repository.TaskRepo;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.repository.WorkflowTaskRepo;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.ArticleTaskDetailService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.vo.TaskProcess;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	private static String UPLOAD_FOLDER = "C:/unitouch/";

	@Autowired
	UserService userservice;
	@Autowired
	FileVersionService fileVersionService;
	@Autowired
	TaskService taskService;
	@Autowired
	ArticleTaskDetailService articleTaskDetailService;
	@Autowired
	FileVersionService fileServi;
	@Autowired
	TaskRepo taskRepo;
	@Autowired
	SchedularRepo schedularRepo;
	@Autowired
	ArticleService articleService;
	@Autowired
	JournalService journalService;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	WorkflowTaskRepo wrkrepo;

	@PostMapping("getUserListById")
	public List<Users> getUserListByID(@RequestBody Users user) {
		
		List<Users> userList = userservice.getUsersByID(user);
		System.out.println("user rest " + userList.toString());
		return userList;

	}

	@GetMapping("getUser")
	public List<Users> getUser() {
		 Users user= new  Users();
		 user.setUserID(1);
		List<Users> userList = userservice.getUsersByID(user);
		System.out.println("user rest " + userList.toString());
		return userList;
	}

	@PostMapping("getTaskListById")
	public TaskDetails getTaskName(@RequestBody TaskDetails taskDetails) {
		TaskDetails taskList = taskService.getTaskNameBy(taskDetails.getId());
		System.out.println("user rest " + taskList.toString());
		return taskList;

	}

	@PostMapping("updateArticleStage")
	public ResponseEntity<?> updateArticleStage(@RequestBody TaskScheduler taskScheduler) {
		// TaskDetails taskList = taskService.getTaskNameBy(taskDetails.getId());
		System.out.println("task Scheduler : " + taskScheduler.toString());
		List<TaskScheduler> taskSchedulerList = schedularRepo.updateStageByArticleId(taskScheduler.getArticle_id(),
				taskScheduler.getTask_id(), taskScheduler.getTask_status());
		System.out.println("taks rest " + taskScheduler.toString());
		return new ResponseEntity<>(taskSchedulerList, HttpStatus.OK);

	}

	@PostMapping("processStatuss")
	public ResponseEntity<?> bundlingCall(@RequestBody TaskProcess taskProcess, HttpServletResponse response) {
		System.out.println("TaskProcess ::" + taskProcess);
		String jobID =taskProcess.getFileName(); /*"45_14394242165MNT_LWW_JOURNAL-R0_7_226693";*/
		String[] temp = jobID.split("_");

		String aid = temp[5];
		String jrAbId = temp[4];
		String taskId = temp[0];
		String sussec = taskProcess.getProcessStatus();
		String procces = taskProcess.getProcessName();
	
//		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = userService.findUserIdByUserName(name);
		ArticleDetail articleDetail = articleService.findByAid(aid);
		Journal journal = journalService.getJournalbyabbrname(jrAbId);
		TaskScheduler taskscheduler = taskService.findtaskDetailBytaskIdarticleid(Integer.parseInt(taskId),articleDetail.getArticle_id());
		int workFlowID = journal.getArticleWorkflowId();

		int taskID = taskscheduler.getTask_id();
		TaskDetails task = taskService.getTaskNameBy(taskID);
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, workFlowID);
		String approval = workflowTaskSeq.getApproval();

		ArticleTaskDetail articleTaskDetail = null;
		Path path = null;
 		byte[] bytes = null;
//		if (!attachment.isEmpty()) {
//
//			try {
//				bytes = attachment.getBytes();
//				if (!new File(UPLOAD_FOLDER + journal.getJournalAbbrName() + File.separator
//						+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
//								.exists()) {
//					new File(UPLOAD_FOLDER + journal.getJournalAbbrName() + File.separator
//							+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
//									.mkdirs();
//				}
//
//				 path = Paths.get(UPLOAD_FOLDER + journal.getJournalAbbrName() + File.separator
//						+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_')
//						+ File.separator + attachment.getOriginalFilename());
//
//				Files.write(path, bytes);
//
//				int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
//
//				WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
//				int nextTaskID = workflowTaskSequ.getTaskId();
//					///pending for task completed(final stage -->end of work) 
//				if (workflowTaskSequ == null) {
//					return new ResponseEntity<>( Status , HttpStatus.FAILED_DEPENDENCY);
//				}
//				CurrentArticleStatus currentArticleStatus = articleService.findCurrentArticleStatusBy(taskID, Aid);
//				currentArticleStatus.setTask_id(nextTaskID);
//				articleService.saveCurrentArticleTaskStatus(currentArticleStatus);
//
//				taskscheduler.setTask_status("Completed");
//				taskscheduler.setRatingStar(0);
//				taskscheduler.setTask_est_time_end(new Date());
//				taskService.saveTaskSchedulerStatus(taskscheduler);
//				articleTaskDetail = articleTaskDetailService.findtaskDetailById(id);
//				articleTaskDetail.setTask_status("Completed");
//				articleTaskDetail.setCompleted_date_time(new Date());
//				articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
//
//			} catch (IOException e) {
//				
//				return new ResponseEntity<>( "Error in file oploding " , HttpStatus.FAILED_DEPENDENCY);
//
//			}
//		}
		int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
		WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence, workFlowID);
		int nextTaskID = workflowTaskSequ.getTaskId();

		CurrentArticleStatus currentArticleStatus = articleService.findCurrentArticleStatusBy(taskID, articleDetail.getArticle_id());
		currentArticleStatus.setTask_id(nextTaskID);
		articleService.saveCurrentArticleTaskStatus(currentArticleStatus);

		taskscheduler.setTask_status("Completed");
		taskscheduler.setRatingStar(0);
		taskscheduler.setTask_est_time_end(new Date());
		taskService.saveTaskSchedulerStatus(taskscheduler);
	
		TaskDetails taskName = taskService.getTaskNameBy(nextTaskID);
		String pathnext = new String(UPLOAD_FOLDER + journal.getJournalAbbrName() + File.separator
				+ articleDetail.getArticle_doi() + File.separator + taskName.getTaskName().replace(' ', '_'));

		File dest = new File(pathnext);
		File source = new File(taskProcess.getFilePath());
		try {
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("source :: "+source);
		System.out.println("dest :: "+dest);
		FileVersion fileversion = new FileVersion();
		fileversion.setArticleId(articleDetail.getArticle_id());
		fileversion.setFileName(taskProcess.getFileName());
		fileversion.setFilePath(pathnext);
		int i = 0;
		bytes=pathnext.getBytes();
		for (byte b : bytes) {
			System.out.println(b);
			i += b;
		}
		fileversion.setSize(i + "bytes");
		fileversion.setCreatedAt(new Date());
		fileversion.setFileVersion(1);
		fileversion.setCreated_by(1);
		fileversion.setJournalId(journal.getJournalId());
		fileversion.setTaskId(taskID);
		fileServi.saveFileVersion(fileversion);
		
		articleTaskDetail = articleTaskDetailService.findtaskDetailById(taskID);
		articleTaskDetail.setTask_status("Completed");
		articleTaskDetail.setCompleted_date_time(new Date());
		articleTaskDetailService.saveArticleTaskStatus(articleTaskDetail);
		
		return new ResponseEntity<>("ok", HttpStatus.OK);

	}

	
	@PostMapping("processStatus")
	public ResponseEntity<?> bundlinggCall(@RequestBody TaskProcess taskProcess, HttpServletResponse response) {
		System.out.println("TaskProcess ::" + taskProcess);
		String jobID =taskProcess.getFileName(); /*"45_14394242165MNT_LWW_JOURNAL-R0_7_226693";*/
		
		return new ResponseEntity<>("call", HttpStatus.OK);
	}
}
