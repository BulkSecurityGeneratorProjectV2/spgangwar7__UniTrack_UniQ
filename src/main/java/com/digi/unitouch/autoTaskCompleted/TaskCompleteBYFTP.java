//package com.digi.unitouch.autoTaskCompleted;
//
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.digi.unitouch.model.ArticleDetail;
//import com.digi.unitouch.model.CurrentArticleStatus;
//import com.digi.unitouch.model.ManageJournalWorkflow;
//import com.digi.unitouch.model.TaskScheduler;
//import com.digi.unitouch.model.WorkflowTaskSeq;
//import com.digi.unitouch.service.ArticleService;
//import com.digi.unitouch.service.ManageJournalworkflowService;
//import com.digi.unitouch.service.TaskService;
//import com.digi.unitouch.service.WorkflowTaskService;
//
//public class TaskCompleteBYFTP {
//	@Autowired
//	ArticleService articleService;
//	@Autowired
//	WorkflowTaskService workflowTaskService;
//	@Autowired
//	TaskService taskService;
//	@Autowired
//	ManageJournalworkflowService manageJournalworkflowService;
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//	@Scheduled(fixedRate = 5000)
//	public void taskDoneSheduler() {
//		System.out.println("------------------------------------------------------------------------------------------------");
//		List<CurrentArticleStatus> currentArticle = articleService.getCurrentArticleList();
//		for (int i = 0; i < currentArticle.size(); i++) {
//
//			ArticleDetail articleDetail = articleService.findArticleDetailBy(currentArticle.get(i).getArticle_id());
//
//			log.info("articleDetail----------->" + articleDetail.toString());
//			TaskScheduler taskscheduler = taskService.getRunId(currentArticle.get(i).getArticle_id(),
//					currentArticle.get(i).getTask_id()); // currentTaskID
//			WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskscheduler.getTask_id(),
//					taskscheduler.getWorkflow_id());
//			int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);
//
//			WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence,
//					taskscheduler.getWorkflow_id());
//			final String startFilepath = "/" + "Uni_SFTP" + "//" + "medknow" + "//"
//					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + "//"
//					+ taskscheduler.getTask().getTaskName().replace(' ', '_') + "//" + "output";
//
//			final String endFileCopypath = "/" + "Uni_SFTP" + "//" + "medknow" + "//"
//					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + "//"
//					+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_') + "//" + "output";
//			
//			final String InputServerPath="C://unitouch" +"//" + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
//					+"//" + articleDetail.getArticle_doi() + ""//"
//					+ taskscheduler.getTask().getTaskName().replace(' ', '_') ;
//			FileLookupInSFTP ftp= new FileLookupInSFTP();
//		boolean status=	ftp.getFileName(startFilepath, endFileCopypath, InputServerPath);
//		if(status) {
//			log.info("workflowTaskSequ----------->" + workflowTaskSequ.toString());
//			int nextTaskID = workflowTaskSequ.getTaskId();
//			ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby(
//					(taskscheduler.getWorkflow_id()), (taskscheduler.getArticleDetail().getJournalId()),
//					(workflowTaskSequ.getRole().getRoleID()), nextTaskID);
//			log.info("manageJournalAuthor------->" + manageJournalAuthor);
//			CurrentArticleStatus currentArticleStatus = articleService
//					.findCurrentArticleStatusBy(taskscheduler.getTask_id(), taskscheduler.getArticle_id());
//			currentArticleStatus.setTask_id(nextTaskID);
//			articleService.saveCurrentArticleTaskStatus(currentArticleStatus);
//			taskscheduler.setTask_status("Completed");
//			taskscheduler.setTask_est_time_end(new Date());
//			taskService.saveTaskSchedulerStatus(taskscheduler);
//			log.info("taskscheduler---------------->" + taskscheduler);
//			TaskScheduler taskPoolUpdate = taskService.getRunId(taskscheduler.getArticle_id(),
//					workflowTaskSequ.getTaskId());
//			taskPoolUpdate.setTask_status("Yet-to-Start");
//			taskPoolUpdate.setUser_id(manageJournalAuthor.getUser_id());
//			taskPoolUpdate.setTask_est_time_from(new Date());
//			taskService.saveTaskSchedulerStatus(taskPoolUpdate);
//			log.info("taskPoolUpdate------------->" + taskPoolUpdate);
//		}else {
//			log.info("no file found");
//		}
//		}
//		
//	}
//}
