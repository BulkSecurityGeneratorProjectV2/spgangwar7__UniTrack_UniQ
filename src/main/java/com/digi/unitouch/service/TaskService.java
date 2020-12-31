package com.digi.unitouch.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.vo.PlannerVo;
import com.digi.unitouch.vo.ProductivityTaskVo;

public interface TaskService {

	public void createTask(TaskDetails task);

	public List<TaskDetails> getTask();

	public Integer saveTask(TaskDetails task);

	//public TaskDetails findbyName(String taskName);

	public void deleteTaskById(Integer taskId);

	public List<WorkflowTaskSeq> getTaskByWorkflow(Integer id);

	public List<TaskDetails> getAlltaskList();
	
	public CopyOnWriteArrayList<TaskDetails> getAlltaskListDraft();

	public Optional<TaskDetails> gettaskDetailsbyid(int id);

	public void savetakSchedulars(TaskScheduler tschedule);

	public void updateTaskSchedulerUserID(int id, String name);

	public List<TaskScheduler> getMyTaskListByUserID(String name);

	public List<TaskScheduler> getOverDueTaskList(Integer integer);

	public List<ProductivityTaskVo> getproductivityTaskCount(Integer userId);
	public List<ProductivityTaskVo> getproductivityTaskCount();

	public void saveTaskSchedulerStatus(TaskScheduler taskScheduler);

//	public List<TaskDetails> getAlltaskList(int uid);

	public TaskScheduler findtaskDetailById(int id);

	public TaskDetails getTaskNameBy(int taskID);

	public TaskDetails getTaskNameByName(String taskname);

	public List<TaskDetails> getPreviousTaskListBy(int workFlowID, int currentTaskSequence);

	public List<TaskScheduler> getOverDueTaskListDetails();

	public void updatetaskRun(Integer taskId, Integer runId, Integer articleId);

	public TaskScheduler getRunId(Integer articleId, Integer taskId);

	public List<TaskScheduler> findalltaskDetailById(int Aid);

	public List<TaskScheduler> getOverDueTaskListadmin();

	void resetDataFormScheduler();

	public List<TaskScheduler> gettaskSchedulerpendingall();

	public List<TaskScheduler> gettaskSchedulerpendingToday();

	public List<TaskScheduler> gettotalarticleavailable();

	public List<TaskScheduler> gettotalarticleavailableToday();

	public List<TaskScheduler> gettotalarticleavailablepast24();

	public List<TaskScheduler> gettotalarticleavailablepast48();

	public List<TaskScheduler> gettotalarticleavailablepastdate();

	public List<TaskScheduler> gettotalarticleOnDeptTodayVirtual();

	public List<PlannerVo> gettotalarticleavailableGraph(int taskId);

	public List<TaskScheduler> gettaskSchedulerpendingallBYdeptandUser(int deptId, int userId);

	public List<TaskScheduler> gettaskSchedulerpendingTodayBYdeptandUser(int deptId, int userId);

	public List<TaskScheduler> gettotalarticleavailableTodayBydeptandUser(int dept, int uid);

	public List<TaskScheduler> gettotalarticleavailablepast24BYdeptandUser(int dept, int uid);

	public List<TaskScheduler> gettotalarticleavailablepast48BYdeptandUser(int dept, int uid);

	public List<TaskScheduler> gettotalarticleavailablepastdateBYdeptandUser(int dept, int uid);

	public List<TaskScheduler> gettaskSchedulerpendingallBYdept(int dept);

	public List<TaskScheduler> gettaskSchedulerpendingTodayBYdept(int dept);

	public List<TaskScheduler> gettotalarticleavailableTodayBydept(int dept);

	public List<TaskScheduler> gettotalarticleavailablepast24BYdept(int dept);

	public List<TaskScheduler> gettotalarticleavailablepast48BYdept(int dept);

	public List<TaskScheduler> gettotalarticleavailablepastdateBYdept(int dept);

	public List<PlannerVo> gettotalarticleavailableGraphBYdeptandUser(int dept, int uid);

	public List<PlannerVo> gettotalarticleavailableGraphBYdeptartment(int dept);

	public TaskScheduler gettaskIdbyJournal();

	public TaskScheduler findtaskDetailBytaskIdarticleid(int taskId, int articleId);

	public void changeTaskStatus(int aid, int taskid, int workFlowID, String taskStatus);

	public TaskScheduler getTaskScheduler(int aid, int taskid, int workFlowID);

	public void changeTaskStatusUserDel(int aid, int taskid, int workFlowID, String taskStatus);

	public List<TaskDetails> getnextTaskListBy(int workFlowID, int currentTaskSequence);

	public List<TaskScheduler> getTotalcountByRejected(String status);

	public List<TaskScheduler> getAricleIDORTaskID(Integer article_id);

	public TaskScheduler getOne(int currentTaskid);

}
