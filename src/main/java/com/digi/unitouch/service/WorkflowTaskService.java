package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.vo.DepartmentRoleVo;
import com.digi.unitouch.vo.WorkflowMax;
import com.digi.unitouch.vo.WorkflowtaskVO;

public interface WorkflowTaskService {

	public void createWorkflowRole(WorkflowTaskSeq workflowRole);

	public List<WorkflowTaskSeq> getWorkflowRole();

	public Integer saveWorkflowRole(WorkflowTaskSeq workflowRole);

	public void deleteWorkflowRoleById(Integer workflowRoleId);

	public void updateTaskWorkflowRole(Integer workFlowId,Integer taskId, String readOnly, String emailFlag, Integer tat,Integer roleID);

	//public String deletejournalId(Integer id);

//	public void updateworkflowTaskSeq(WorkflowTaskSeq workflowTaskSeq);

	public WorkflowTaskSeq gettaskDetailsbyid(int id, int wiD);

	public List<WorkflowTaskSeq> workflowTaskSeqlist(int id);

	public void updateworkflowTaskSeq(WorkflowTaskSeq workflowTaskSeqDetails);

	public WorkflowTaskSeq workflowTaskSeqbyId(Integer id);

	public void getworkflowId(Integer journalId);

	public void deleteworkflowTask(int id);

	public WorkflowTaskSeq getTaskId(int wfid);

	public WorkflowTaskSeq getNextTaskIdBy(int nextTaskSequence, int workFlowID);

	public List<WorkflowtaskVO> WorkflowtaskVOlist(int id);

	public List<DepartmentRoleVo> departmentIdbyRoleId(Integer roleId);

	public List<WorkflowTaskSeq> workflowTaskSeqlistWithRole(Integer wfid);

	public WorkflowTaskSeq getTaskIdandWorkflowid(Integer workflowsid, Integer seqNo);

	List<WorkflowTaskSeq> findMaxSeqNumberInWorkflowTaskSeq();

	List<WorkflowTaskSeq> findLastMaxSeqNumberInWorkflowTaskSeq();

	public boolean checkArticleTask(String currentPhase, int aId);

}
