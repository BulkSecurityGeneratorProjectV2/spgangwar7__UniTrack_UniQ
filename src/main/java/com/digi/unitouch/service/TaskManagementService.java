package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.TaskManagementVoc;
import com.digi.unitouch.vo.userDepartmentVo;

public interface TaskManagementService {

//	List<TaskManagementVo> getTaskManagementGroupList(Integer integer);

	TaskManagementVo findGroupTaskByArticleId(int id);

	List<TaskManagementVo> getmyTaskManagementList(Integer userID);
	
	TaskManagementVo getspecificTask(Integer userID,Integer articleId);
	
	List<TaskManagementVo> getmyTaskManagementListforPlanner(Integer userID);

	List<TaskManagementVo> getTaskManagementGroupList();

	List<TaskManagementVoc> getmyTaskManagementLists();

	List<userDepartmentVo> getuserlistbydeptId(int dptId);

	List<TaskManagementVo> getTaskManagementGroupList(Integer workflowId, Integer journalId, Integer taskId);

	List<DepartmentsTask> getAllTaskAndALLJournalByDept(Integer user_id);

	List<DepartmentsTask> getAllTaskAndALLJournalByDept(Integer dpt, Integer jrid);

	List<TaskManagementVo> getmyTaskManagementList(Integer userID, Integer journal_jid);
	
	List<TaskManagementVo> getmyTaskManagementTotalList(Integer userid);
	
	List<TaskManagementVo> getmyTotalList();

	List<DepartmentsTask> getAllTaskAndALLJournalByUserID(Integer user_id);

}
