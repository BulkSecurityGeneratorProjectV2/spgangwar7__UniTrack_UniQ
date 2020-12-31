
package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.repository.TaskManagementRepo;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.TaskManagementVoc;
import com.digi.unitouch.vo.userDepartmentVo;

@Service

@Transactional
public class TaskManagementServiceImpl implements TaskManagementService {

	@Autowired
	TaskManagementRepo taskManagementRepo;

//		@Override
//		public List<TaskManagementVo> getTaskManagementGroupList(Integer name) {
//			return taskManagementRepo.getTaskManagementGroupList(name);
//		}

	@Override
	public TaskManagementVo findGroupTaskByArticleId(int id) {
		return taskManagementRepo.findGroupTaskByArticleId(id);
	}

	@Override
	public List<TaskManagementVo> getmyTaskManagementList(Integer userID) {
		return taskManagementRepo.getmyTaskManagementList(userID);
	}

	@Override
	public TaskManagementVo getspecificTask(Integer userID, Integer articleId) {
		// TODO Auto-generated method stub
		return taskManagementRepo.getspecificTask(userID, articleId);
	}

	@Override
	public List<TaskManagementVo> getmyTaskManagementListforPlanner(Integer userID) {
		return taskManagementRepo.getmyTaskManagementListforPlanner(userID);
	}

	@Override
	public List<TaskManagementVo> getTaskManagementGroupList() {
		return taskManagementRepo.getmyTaskManagementList();
	}

	@Override
	public List<TaskManagementVoc> getmyTaskManagementLists() {
		System.out.println(
				"taskManagementRepo.getmyTaskManagementLists() :" + taskManagementRepo.getmyTaskManagementLists());
		return taskManagementRepo.getmyTaskManagementLists();
	}

	@Override
	public List<userDepartmentVo> getuserlistbydeptId(int dptId) {
		return taskManagementRepo.getuserlistbydeptId(dptId);
	}

	@Override
	public List<TaskManagementVo> getTaskManagementGroupList(Integer workflowId, Integer journalId, Integer taskId) {

		return taskManagementRepo.getTaskManagementGroupList(workflowId, journalId, taskId);
	}

	@Override
	public List<DepartmentsTask> getAllTaskAndALLJournalByDept(Integer user_id) {
		return taskManagementRepo.getAllTaskAllJournalBydpt(user_id);
	}

	@Override
	public List<DepartmentsTask> getAllTaskAndALLJournalByUserID(Integer user_id) {
		return taskManagementRepo.getAllTaskAllJournalByUserID(user_id);
	}
	
	@Override
	public List<DepartmentsTask> getAllTaskAndALLJournalByDept(Integer dpt, Integer jrid) {
		return taskManagementRepo.getAllTaskAllJournalBydptJrid(dpt, jrid);
	}

	@Override
	public List<TaskManagementVo> getmyTaskManagementList(Integer userID, Integer journal_jid) {

		return taskManagementRepo.getmyTaskManagementList(userID, journal_jid);
	}
	
	@Override
	public List<TaskManagementVo> getmyTaskManagementTotalList(Integer userid) {
		return taskManagementRepo.getmyTaskManagementTotalList(userid);
	}

	@Override
	public List<TaskManagementVo> getmyTotalList() {
		return taskManagementRepo.getmyTaskManagementList();
	}
}
