
package com.digi.unitouch.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.WorkflowRepo;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;

@Service

@Transactional
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	WorkflowRepo workflowRepo;

	@Autowired
	WorkflowTaskService workflowTaskService;

	@Override
	public List<Workflow> getWorkflow() {
		return workflowRepo.findAll();

	}

	@Override
	public void deleteWorkflowById(Integer workflowId) {
		workflowRepo.deleteById(workflowId);

	}

	@Override
	public void saveWorkflow(Workflow workflow) {
		workflowRepo.save(workflow);
	}
	
	@Override
	public List<Workflow> getallList() {
		//return workflowRepo.findAll();
		return workflowRepo.findlistOrderby();
	}

//
//	@Override
//	public List<Workflow> getallList() {
//		return workflowRepo.findAll();
//	}

	@Override
	public Workflow findworkflowbyname(int id) {
		return workflowRepo.findworkflow(id);
	}

	@Override
	public void updateWorkflowStatus(int id) {
		workflowRepo.updateWorkflowStatus(id);
	}

	@Override
	public List<Workflow> getallListbytype(String workflowType) {
		List<Workflow> workflowListFinal = new ArrayList<Workflow>();
		List<Workflow> workflowList = workflowRepo.findByWorkflowtype(workflowType);
		for (Workflow workflowData : workflowList) {
			List<WorkflowTaskSeq> workFlowTaskSeq = workflowTaskService.workflowTaskSeqlist(workflowData.getId());
			List<WorkflowTaskSeq> workFlowTaskSeqfinal = workflowTaskService
					.workflowTaskSeqlistWithRole(workflowData.getId());
			if (workFlowTaskSeq.size()== workFlowTaskSeqfinal.size()) {
				workflowListFinal.add(workflowData);
			}

		}
		return workflowListFinal;
	}

	@Override
	public List<Workflow> getallListbyIssuetype(String workflowType) {
		return workflowRepo.findByWorkflowIssuetype(workflowType);
	}

	@Override
	public Workflow findworkflowbyname(String name) {
		return workflowRepo.findworkflowbyname(name);
	}

}
