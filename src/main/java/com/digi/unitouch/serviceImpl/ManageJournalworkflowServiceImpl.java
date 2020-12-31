package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.repository.ManageJournalworkflowRepo;
import com.digi.unitouch.service.ManageJournalworkflowService;

@Service
@Transactional
public class ManageJournalworkflowServiceImpl implements ManageJournalworkflowService {

	@Autowired
	ManageJournalworkflowRepo manageJournalworkflowRepo;
	@Override
	public boolean savemanageworkflow(ManageJournalWorkflow manageJournalWorkflow) {
		manageJournalworkflowRepo.save(manageJournalWorkflow);
		return true;
	}
	@Override
	public ManageJournalWorkflow getdepartmentIdby(int workflowid, int journalId, int roleId) {
		System.out.println("workflowid :"+workflowid +"journalId: "+journalId+" roleId: "+roleId );
		System.out.println("dfgds b:"+manageJournalworkflowRepo.getdepartmentIdby(workflowid, journalId, roleId));
		return manageJournalworkflowRepo.getdepartmentIdby(workflowid, journalId, roleId);
	}
	@Override
	public void deleteManageJournalworkflow(int journalId, int workflowid) {
		manageJournalworkflowRepo.deleteManageJournalworkflow(journalId,workflowid);		
	}
	@Override
	public List<ManageJournalWorkflow> getmanagedetailsbyId(int journalId) {
		return manageJournalworkflowRepo.getmanagedetailsbyId(journalId);
	}
	@Override
	public ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID) {
		return manageJournalworkflowRepo.getdepartmentIdallby(workflowid, journalId, roleId, taskID);
	}
	
	@Override
	public ManageJournalWorkflow getUsersallby(int workflowid, int journalId, int taskID) {
		// TODO Auto-generated method stub
		return manageJournalworkflowRepo.getUsersallby(workflowid, journalId, taskID);
	}
	
//	@Override
//	public ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID,String fileFtp) {
//		return manageJournalworkflowRepo.getdepartmentIdallby(workflowid, journalId, roleId, taskID, fileFtp);
//	}
	@Override
	public List<ManageJournalWorkflow> getlistbyId(int journalId, int wfId) {
		return manageJournalworkflowRepo.getlistbyId(journalId, wfId);
	}
//	@Override
//	public Set<Department> getGroupList(int journalId, int wfId) {
//		Set<Department> dp= new HashSet<Department>();
//				List<ManageJournalWorkflow> listGroup= manageJournalworkflowRepo.getlistbyId(journalId, wfId);
//		listGroup.stream().forEach(x->{
//			Department dpt= new Department();
//			dpt.setDeptID(x.getDept_id());
//			dpt.setGroupName(x.getDepartment().getGroupName());
//			dp.add(dpt);
//		});
//		return dp;
//	}
	@Override
	public void deleteManageJournalwork(int journalId) {
		manageJournalworkflowRepo.deleteManageJournalwork(journalId);	
		
	}
//	@Override
//	public List<ManageJournalWorkflow> getManageJournalByDptId(Integer dptId) {
//		
//		return manageJournalworkflowRepo.getmanagedetailsbyDptId(dptId);
//	}
	@Override
	public ManageJournalWorkflow findBymjWkID(Integer id) {
		// TODO Auto-generated method stub
		return manageJournalworkflowRepo.getOne(id);
	}

	@Override
	public List<ManageJournalWorkflow> getManageJournalByroleId(int role) {
		return  manageJournalworkflowRepo.getmanagedetailsbyroleId(role);
	}
	@Override
	public List<ManageJournalWorkflow> getmanagedetailsbyUserId(int userid) {
		// TODO Auto-generated method stub
		return manageJournalworkflowRepo.getmanagedetailsbyUserId(userid);
	}


}
