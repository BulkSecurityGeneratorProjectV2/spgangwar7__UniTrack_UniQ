package com.digi.unitouch.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.IssueTaskScheduler;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.IssueTaskSchedulerRepo;
import com.digi.unitouch.service.IssueTaskSchedulerService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.vo.WorkflowMax;

@Service
@Transactional
public class IssueTaskSchedulerServiceImpl implements IssueTaskSchedulerService {

	@Autowired
	IssueTaskSchedulerRepo issueTaskSchedulerRepo;

	@Autowired
	WorkflowTaskService workflowTaskService;
	
	@Override
	public void saveTaskSchedulars(IssueTaskScheduler tschedule) {

		issueTaskSchedulerRepo.save(tschedule);
	}

	@Override
	public IssueTaskScheduler getIssueTaskScheById(Integer issueTaskId) {
		return issueTaskSchedulerRepo.getOne(issueTaskId);
	}

	@Override
	public IssueTaskScheduler getIssueSchedulerDetail(int issueID, int nextTaskID) {
		// TODO Auto-generated method stub
		return issueTaskSchedulerRepo.getIssueSchedulerDetail(issueID, nextTaskID);
	}
	
	@Override
	public void changeIssueTaskStatusUserDel(int issueId, int taskid, int workFlowID, String taskStatus) {
		issueTaskSchedulerRepo.changeTaskStatusUserDel(issueId,taskid,workFlowID,taskStatus);
		
	}

	@Override
	public void changeIssueTaskStatus(int issueId, int taskid, int workFlowID, String taskStatus) {
		issueTaskSchedulerRepo.changeTaskStatus(issueId,taskid,workFlowID,taskStatus);
		
	}

	@Override
	public List<IssueTaskScheduler> getIssueCompleteDetail() {
		List<IssueTaskScheduler> task = new ArrayList<IssueTaskScheduler>();
//		List<WorkflowTaskSeq> wl = new ArrayList<WorkflowTaskSeq>();
		List<WorkflowTaskSeq> womax = workflowTaskService.findMaxSeqNumberInWorkflowTaskSeq();
		for (WorkflowTaskSeq worSeq : womax) {
			List<IssueTaskScheduler> task1 = issueTaskSchedulerRepo.getIsssueBywkIDTaskID(worSeq.getWorkflowId(),
					worSeq.getTaskId());
			if (task1.isEmpty()) {

			} else {
				task.addAll(task1);
			}
		}
		System.out.println(task.toString());
		return task;
	}

	@Override
	public List<IssueTaskScheduler> getIssueSchedulerDetailByIssueID(Integer issueID){
		return issueTaskSchedulerRepo.getIssueSchedulerDetailByIssueID(issueID);
	}

}
