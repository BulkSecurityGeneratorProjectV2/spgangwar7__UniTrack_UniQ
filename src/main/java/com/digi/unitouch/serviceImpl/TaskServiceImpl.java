package com.digi.unitouch.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.ArticleTaskDetailRepo;
import com.digi.unitouch.repository.JournalRepo;
import com.digi.unitouch.repository.SchedularRepo;
import com.digi.unitouch.repository.TaskRepo;
import com.digi.unitouch.repository.WorkflowTaskRepo;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.vo.PlannerVo;
import com.digi.unitouch.vo.ProductivityTaskVo;

@Service("TaskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepo taskRepo;
	@Autowired
	JournalRepo journalRepo;
	@Autowired
	SchedularRepo schedularRepo;
	@Autowired
	ArticleTaskDetailRepo articleTaskDetailRepo;

	@Autowired
	WorkflowTaskRepo workflowTaskRepo;

	@Override
	public void createTask(TaskDetails task) {
		taskRepo.save(task);

	}

	@Override
	public List<TaskDetails> getTask() {

		return taskRepo.findAll();
	}

	@Override
	public Integer saveTask(TaskDetails task) {
		taskRepo.save(task);
		return task.getId();
	}

	@Override
	public void deleteTaskById(Integer taskId) {
		taskRepo.deleteById(taskId);
	}

	@Override
	public List<WorkflowTaskSeq> getTaskByWorkflow(Integer id) {
		return workflowTaskRepo.getTaskByWorkflow(id);
	}

	@Override
	public List<TaskDetails> getAlltaskList() {
		return taskRepo.findAll();
	}

	@Override
	public CopyOnWriteArrayList<TaskDetails> getAlltaskListDraft() {
		return taskRepo.getAlltaskListDraft();
	}
	@Override
	public Optional<TaskDetails> gettaskDetailsbyid(int id) {
		return taskRepo.findById(id);
	}

	@Override
	public void savetakSchedulars(TaskScheduler tschedule) {

		schedularRepo.save(tschedule);
	}

	@Override
	public void updateTaskSchedulerUserID(int id, String name) {
		schedularRepo.save(id, name);

	}

	@Override
	public List<TaskScheduler> getMyTaskListByUserID(String name) {
		return schedularRepo.getMyTaskListByUserID(name);
	}

	@Override
	public void saveTaskSchedulerStatus(TaskScheduler taskScheduler) {
		schedularRepo.save(taskScheduler);

	}

	@Override
	public List<ProductivityTaskVo> getproductivityTaskCount(Integer userID) {
	
		return schedularRepo.getproductivityTaskCount(userID);
	}

	@Override
	public List<ProductivityTaskVo> getproductivityTaskCount() {
	
		return schedularRepo.getproductivityTaskCount();
	}

//	@Override
//	public List<TaskDetails> getAlltaskList(int uid) {
//	
//		return articleTaskDetailRepo.getAlltaskList(uid);
//	}

	/*
	 * @Override public List<TaskDetails> getAlltaskList(Users uid) { // TODO
	 * Auto-generated method stub return articleTaskDetailRepo.getAlltaskList(uid);
	 * }
	 */

	@Override
	public TaskScheduler findtaskDetailById(int id) {
		return schedularRepo.findtaskDetailById(id);
	}

	@Override
	public TaskDetails getTaskNameBy(int taskID) {
		return taskRepo.getTaskNameBy(taskID);
	}
	
	@Override
	public TaskDetails getTaskNameByName(String taskname) {
		// TODO Auto-generated method stub
		return taskRepo.getTaskNameByName(taskname);
	}

	@Override
	public List<TaskDetails> getPreviousTaskListBy(int workFlowID, int currentTaskSequence) {
		return taskRepo.getPreviousTaskListBy(workFlowID, currentTaskSequence);
	}

	@Override
	public List<TaskScheduler> getOverDueTaskList(Integer integer) {

		return schedularRepo.getOverDueTaskList(integer);
	}

	@Override
	public List<TaskScheduler> getOverDueTaskListDetails() {
	
		return schedularRepo.getOverDueTaskListDetails();
	}

	@Override
	public void updatetaskRun(Integer taskId, Integer runId, Integer articleId) {
		schedularRepo.updatetaskRun(taskId, runId, articleId);

	}

	@Override
	public TaskScheduler getRunId(Integer articleId, Integer taskId) {

		return schedularRepo.getrunId(articleId, taskId);
	}

	@Override
	public List<TaskScheduler> findalltaskDetailById(int Aid) {
		return schedularRepo.findalltaskDetailById(Aid);
	}

	@Override
	public List<TaskScheduler> getOverDueTaskListadmin() {
		return schedularRepo.getOverDueTaskListDetails();
	}
	@Override
	public void resetDataFormScheduler() {
		schedularRepo.resetarticleScheduledTasks();
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingall() {
		return schedularRepo.gettaskSchedulerpendingall();
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingToday() {
		return schedularRepo.gettaskSchedulerpendingToday();
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailable() {
		return schedularRepo.gettotalarticleavailable();
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailableToday() {
		return schedularRepo.gettotalarticleavailableToday();
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast24() {
		return schedularRepo.gettotalarticleavailablepast24();
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast48() {
		return schedularRepo.gettotalarticleavailablepast48();
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepastdate() {
		return schedularRepo.gettotalarticleavailablepastdate();
	}

	@Override
	public List<TaskScheduler> gettotalarticleOnDeptTodayVirtual() {
		return schedularRepo.gettotalarticleOnDeptTodayVirtual();
	}

	@Override
	public List<PlannerVo> gettotalarticleavailableGraph(int taskId) {
	
		return schedularRepo.gettotalarticleavailableGraph();
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingallBYdeptandUser(int deptId, int userId) {
		
		return schedularRepo.gettaskSchedulerpendingallBYdeptandUser(deptId,userId);
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingTodayBYdeptandUser(int deptId, int userId) {
	
		return schedularRepo.gettaskSchedulerpendingTodayBYdeptandUser(deptId,userId);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailableTodayBydeptandUser(int dept, int uid) {

		return schedularRepo.gettotalarticleavailableTodayBydeptandUser(dept,uid);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast24BYdeptandUser(int dept, int uid) {

		return schedularRepo.gettotalarticleavailablepast24BYdeptandUser(dept,uid);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast48BYdeptandUser(int dept, int uid) {
	
		return schedularRepo.gettotalarticleavailablepast48BYdeptandUser(dept,uid);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepastdateBYdeptandUser(int dept, int uid) {

		return schedularRepo.gettotalarticleavailablepastdateBYdeptandUser(dept,uid);
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingallBYdept(int dept) {
	
		return schedularRepo.gettaskSchedulerpendingallBYdept(dept);
	}

	@Override
	public List<TaskScheduler> gettaskSchedulerpendingTodayBYdept(int dept) {
	
		return schedularRepo.gettaskSchedulerpendingTodayBYdept(dept);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailableTodayBydept(int dept) {

		return schedularRepo.gettotalarticleavailableTodayBydept(dept);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast24BYdept(int dept) {
	
		return schedularRepo.gettotalarticleavailablepast24BYdept(dept);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepast48BYdept(int dept) {
	
		return schedularRepo.gettotalarticleavailablepast48BYdept(dept);
	}

	@Override
	public List<TaskScheduler> gettotalarticleavailablepastdateBYdept(int dept) {
	
		return schedularRepo.gettotalarticleavailablepastdateBYdept(dept);
	}

	@Override
	public List<PlannerVo> gettotalarticleavailableGraphBYdeptandUser(int dept, int uid) {
		
		return schedularRepo.gettotalarticleavailableGraphBYdeptandUser(dept,uid);
	}

	@Override
	public List<PlannerVo> gettotalarticleavailableGraphBYdeptartment(int dept) {
		
		return schedularRepo.gettotalarticleavailableGraphBYdeptartment(dept);
	}

	@Override
	public TaskScheduler gettaskIdbyJournal() {
		
		return schedularRepo.gettaskIdbyJournal();
	}

	@Override
	public TaskScheduler findtaskDetailBytaskIdarticleid(int taskId, int articleId) {
		return schedularRepo.findtaskDetailBytaskIdarticleid(taskId,articleId);
	}

	@Override
	public void changeTaskStatus(int aid, int taskid, int workFlowID,String taskStatus) {
		schedularRepo.changeTaskStatus(aid,taskid,workFlowID,taskStatus);
		
	}

	@Override
	public TaskScheduler getTaskScheduler(int aid, int taskid, int workFlowID) {
		
		return schedularRepo.getTaskScheduler(aid,taskid,workFlowID);
	}

	@Override
	public void changeTaskStatusUserDel(int aid, int taskid, int workFlowID, String taskStatus) {
		schedularRepo.changeTaskStatusUserDel(aid,taskid,workFlowID,taskStatus);
		
	}

	@Override
	public List<TaskDetails> getnextTaskListBy(int workFlowID, int currentTaskSequence) {
		return taskRepo.getnextTaskListBy(workFlowID, currentTaskSequence);
	}

	@Override
	public List<TaskScheduler> getTotalcountByRejected(String status) {
		return schedularRepo.getTotalcountByRejected(status);
	}

	@Override
	public List<TaskScheduler> getAricleIDORTaskID(Integer article_id) {
			return schedularRepo.getAricleIDORTaskID(article_id);
	}

	@Override
	public TaskScheduler getOne(int currentTaskid) {
		// TODO Auto-generated method stub
		return schedularRepo.getOne(currentTaskid);
	}

	/*
	 * @Override public TaskDetails findbyName(String taskName) {
	 * 
	 * return taskRepo.getTaskNameByName(taskName); }
	 */

	
}
