
package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.ArticleRepo;
import com.digi.unitouch.repository.CurrentArticleRepo;
import com.digi.unitouch.repository.DepartmentRoleRepo;
import com.digi.unitouch.repository.WorkflowTaskRepo;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.vo.DepartmentRoleVo;
import com.digi.unitouch.vo.WorkflowtaskVO;

@Service

@Transactional
public class WorkflowTaskServiceImpl implements WorkflowTaskService {

	@Autowired
	WorkflowTaskRepo workflowRoleRepo;
	@Autowired
	CurrentArticleRepo currentArticleRepo;
	@Autowired
	DepartmentRoleRepo departmentRoleRepo;
	@Autowired
	ArticleRepo articleRepo;

	@Override
	public void createWorkflowRole(WorkflowTaskSeq workflowRole) {
		workflowRoleRepo.createTaskWorkflowRole(workflowRole.getWorkflowId(), null, workflowRole.getEmailFlag(),
				workflowRole.getReadOnly(), workflowRole.getTat(), workflowRole.getTaskId(), workflowRole.getInFloder(),
				workflowRole.getOutFolder());
	}

	@Override
	public List<WorkflowTaskSeq> getWorkflowRole() {
		return workflowRoleRepo.findAll();
	}

	@Override
	public Integer saveWorkflowRole(WorkflowTaskSeq workflowRole) {
		workflowRoleRepo.save(workflowRole);
		return workflowRole.getId();
	}

	@Override
	public void deleteWorkflowRoleById(Integer workflowRoleId) {
		workflowRoleRepo.deleteById(workflowRoleId);
	}

	@Override
	public void updateTaskWorkflowRole(Integer workFlowId, Integer taskId, String readOnly, String emailFlag,
			Integer tat, Integer roleID) {
		workflowRoleRepo.updateTaskWorkflowRole(workFlowId, taskId, tat, readOnly, emailFlag, roleID);
	}

	

	/*
	 * @Override public void updateworkflowTaskSeq(WorkflowTaskSeq workflowTaskSeq)
	 * { workflowRoleRepo.updateworkflowTaskSeq(workflowTaskSeq);
	 * 
	 * }
	 */

	@Override
	public WorkflowTaskSeq gettaskDetailsbyid(int id, int wiD) {
		return workflowRoleRepo.findTaskSeq(id, wiD);
	}

	@Override
	public List<WorkflowTaskSeq> workflowTaskSeqlist(int id) {
		return workflowRoleRepo.findWorkflowById(id);
	}

	@Override
	public void updateworkflowTaskSeq(WorkflowTaskSeq workflowTaskSeqDetails) {
		workflowRoleRepo.save(workflowTaskSeqDetails);
	}

	@Override
	public WorkflowTaskSeq workflowTaskSeqbyId(Integer id) {
		return workflowRoleRepo.findworkflowTaskSeqbyId(id);
	}

	@Override
	public void getworkflowId(Integer journalId) {
		workflowRoleRepo.getworkflowId(journalId);
	}

	@Override
	public void deleteworkflowTask(int id) {
		workflowRoleRepo.deletebyworkflowId(id);
	}

	@Override
	public WorkflowTaskSeq getTaskId(int wfid) {
		return workflowRoleRepo.getTaskId(wfid);
	}

	@Override
	public WorkflowTaskSeq getNextTaskIdBy(int nextTaskSequence, int workFlowID) {
		return workflowRoleRepo.getNextTaskIdBy(nextTaskSequence, workFlowID);
	}

	@Override
	public List<WorkflowtaskVO> WorkflowtaskVOlist(int id) {
		return workflowRoleRepo.WorkflowtaskVOlist(id);
	}

	@Override
	public List<DepartmentRoleVo> departmentIdbyRoleId(Integer roleId) {
		return departmentRoleRepo.departmentIdbyRoleId(roleId);
	}

	@Override
	public List<WorkflowTaskSeq> workflowTaskSeqlistWithRole(Integer wfid) {
		// TODO Auto-generated method stub
		return workflowRoleRepo.workflowTaskSeqlistWithRole(wfid);
	}
//
//	@Override
//	public WorkflowTaskSeq getTaskIdandWorkflowid(int parseInt, Integer seqNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public WorkflowTaskSeq getTaskIdandWorkflowid(Integer workflowsid,Integer seqNo) {
		return workflowRoleRepo.getTaskIdandWorkflowid(workflowsid,seqNo);
	}

	
	@Override
	public List<WorkflowTaskSeq> findMaxSeqNumberInWorkflowTaskSeq() {
		return workflowRoleRepo.findMaxSeqNumberInWorkflowTaskSeq();
	}
	
	@Override
	public List<WorkflowTaskSeq> findLastMaxSeqNumberInWorkflowTaskSeq() {
		return workflowRoleRepo.findLastMaxSeqNumberInWorkflowTaskSeq();
	}

	@Override
	public boolean checkArticleTask(String currentPhase, int aid) {
		String taskname = currentPhase.replace(" ", "_");
		taskname=taskname.replace("-", "_");
		ArticleDetail article = articleRepo.getOne(aid);
		article.getJournalId();
		int wkid = article.getJournals().getArticleWorkflowId();
		List<WorkflowTaskSeq> wts = workflowRoleRepo.findWorkflowById(wkid);
		for (WorkflowTaskSeq workflowTaskSeq : wts) {
			if (workflowTaskSeq.getTask().getTaskName().equalsIgnoreCase(taskname)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * @Override public List<DepartmentRole> departmentIdbyRoleId(Integer roleId) {
	 * return departmentRoleRepo.departmentIdbyRoleId(roleId); }
	 */

}
