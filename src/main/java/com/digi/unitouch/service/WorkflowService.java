package com.digi.unitouch.service;

import java.util.List;
import java.util.Set;

import com.digi.unitouch.model.Workflow;

public interface WorkflowService {

	public List<Workflow> getWorkflow();

	public void saveWorkflow(Workflow workflow);

	public void deleteWorkflowById(Integer workflowId);

	public List<Workflow> getallList();

	public Workflow findworkflowbyname(int id);

	public void updateWorkflowStatus(int id);

	public List<Workflow> getallListbytype(String workflowType);

	public List<Workflow> getallListbyIssuetype(String workflowType);

	public Workflow findworkflowbyname(String name);


	
	
}
