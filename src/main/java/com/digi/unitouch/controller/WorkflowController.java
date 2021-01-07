package com.digi.unitouch.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.EmailTemp;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.model.pList;
import com.digi.unitouch.service.EmailTempService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.WorkflowVO;
import com.digi.unitouch.vo.WorkflowtaskVO;

@Controller

public class WorkflowController extends LoggerClass {

	@Autowired
	WorkflowService workflowService;
	@Autowired
	TaskService taskService;
	@Autowired
	RoleService roleService;
	@Autowired
	WorkflowTaskService workflowRoleService;
	@Autowired
	EmailTempService emailTempService;

	@GetMapping( "workflowList")
	public ModelAndView WorkflowList(ModelMap model, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.debug(name);
		List<Workflow> workflows = workflowService.getallList();
		model.put("workflowslist", workflows);
		model.put("message",message);
		model.put("css", css);
		return new ModelAndView("/Workflow/workFlowList");
	}

	@RequestMapping(value = { "/workflowCreation" })
	public ModelAndView TaskCreation(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.debug(name);
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<Workflow> workflows = workflowService.getallList();
		model.put("workflowslist", workflows);
		model.put("workflowTaskSeqlist", null);
		return new ModelAndView("/Workflow/TaskCreation");
	}

	@RequestMapping(value = { "/editworkFlow" })
	public ModelAndView editworkFlow(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String workflowid = null;
		workflowid = request.getParameter("workflowid");
		if (workflowid == "") {
			workflowid = request.getAttribute("workflowid").toString();
		}
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("workflowid", workflow.getId());
		model.put("workflowType", workflow.getWorkflowType());
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<Role> role = roleService.getaskList();
		model.put("rolelist", role);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(Integer.parseInt(workflowid));
		model.put("workflowTaskSeq", workflowTaskSeq);
		model.put("taskName", 2);
		model.put("taskRealName", workflowTaskSeqlist.get(0).getTask().getTaskName());
		List<EmailTemp> emailTemp=	emailTempService.getEmailList();
		model.put("emailTemp", emailTemp);
		return new ModelAndView("/Workflow/DefineRules");
	}

	@RequestMapping(value = { "/editworkFlowTask" })
	public ModelAndView editworkFlowtask(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String workflowid = request.getParameter("workflowid");
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("workflowid", workflow.getId());
		model.put("workFlowType",workflow.getWorkflowType());
		CopyOnWriteArrayList<TaskDetails> taskDetails = taskService.getAlltaskListDraft();
		model.put("taskDetails", taskDetails);
		List<Role> role = roleService.getaskList();
		model.put("rolelist", role);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		int i = 0;
		for (TaskDetails taskDetail : taskDetails) {
			for (WorkflowTaskSeq workflowTaskSeq : workflowTaskSeqlist) {
				if (workflowTaskSeq.getTask().getId().intValue() == taskDetail.getId().intValue()) {
					taskDetails.remove(i);
					i--;
				}
			}
			i++;

		}
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		return new ModelAndView("/Workflow/TaskCreation");
	}

	@PostMapping("/createworkflow")
	public ModelAndView createworkflow(@ModelAttribute pList pList, ModelMap model, HttpServletRequest request,
			Workflow wf) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String draft = null;
		List<Workflow> workflows = workflowService.getallList();
		for (Workflow workflow : workflows) {
			if(wf.getName().equalsIgnoreCase(workflow.getName()) && workflow.getStatus().equals("Y")) {
				model.put("workflowslist", workflows);
				model.put("message", "Workflow name alredy exsit");
				model.put("css", "danger");
				return new ModelAndView("/Workflow/workFlowList");
			}
		}
		String workflowid = request.getParameter("workflowid");
		draft = request.getParameter("draft");
		wf.setCreatedAT(new Date());
		wf.setCreatedBY(name);
		wf.setStatus("Y");
		int id = 0;
		if (workflowid == "") {
			workflowService.saveWorkflow(wf);
			model.put("workflowName", wf.getName());
			model.put("workflowid", wf.getId());
		} else {
			Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
			workflow.setStatus("Y");
			workflowService.saveWorkflow(workflow);
			model.put("workflowName", workflow.getName());
			model.put("workflowid", workflow.getId());
		}

		if (workflowid == "") {
			id = wf.getId();
		} else {
			id = Integer.parseInt(workflowid);
			workflowRoleService.deleteworkflowTask(id);
		}
		List<String> listString = (List) pList.getListString();
		for (int i = 0; i < listString.size(); i++) {
			try {
				String pLista = pList.getListString().get(i);
				WorkflowTaskSeq workflowTaskSeq = new WorkflowTaskSeq();
				workflowTaskSeq.setSequence((i));
				workflowTaskSeq.setTaskId(Integer.parseInt(pLista));
				workflowTaskSeq.setWorkflowId(id);
				workflowTaskSeq.setCreatedAt(new Date());
				workflowTaskSeq.setCreatedBy(name);
				workflowRoleService.saveWorkflowRole(workflowTaskSeq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<Role> role = roleService.getaskList();
		model.put("rolelist", role);
		List<EmailTemp> emailTemp=	emailTempService.getEmailList();
		model.put("emailTemp", emailTemp);
		WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(id);
		model.put("workflowTaskSeq", workflowTaskSeq);
		List<WorkflowtaskVO> workflowTaskSeqlist = workflowRoleService.WorkflowtaskVOlist(id);
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		model.put("taskName", 1);
		model.put("taskRealName", workflowTaskSeqlist.get(0).getTaskName());
		return new ModelAndView("/Workflow/DefineRules");
//		 
//		  request.setAttribute("workflowid",id);
//		  return editworkFlow(model ,request ); 
	}

	@PostMapping ("workflowDraftAndExit")
	public String WorkflowDraftAndExit(ModelMap model,RedirectAttributes ra, HttpServletRequest request, pList pList, Workflow wf) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		int id = 0;
//		List<Workflow> work=workflowService.getallList();
//		int count=0;
//		for (Workflow workflow : work) {
//			if(wf.getName().equalsIgnoreCase(workflow.getName())) {
//				count++;
//			}
//		}
//		if(1<=count) {
//			//model.put("workflowslist", work);
//			ra.addAttribute("message", "Workflow name alredy exsit");
//			ra.addAttribute("css", "danger");
//			return "redirect:workflowList";
//		}
		String workflowid = request.getParameter("workflowid");
		if (workflowid == "") {
			Workflow wk=workflowService.findworkflowbyname(wf.getName());
			if(wk==null) {
			wf.setCreatedAT(new Date());
			wf.setCreatedBY(name);
			wf.setStatus("N");
			workflowService.saveWorkflow(wf);
			model.put("workflowName", wf.getName());
			model.put("workflowid", wf.getId());
			id = wf.getId();
			}else {
				ra.addAttribute("message", "Workflow name alredy exsit");
				ra.addAttribute("css", "danger");
				return "redirect:workflowList";
			}
		} else {
			id = Integer.parseInt(workflowid);
			workflowRoleService.deleteworkflowTask(id);
		}

		List<String> listString = (List) pList.getListString();
		for (int i = 0; i < listString.size(); i++) {
			try {
				String pLista = pList.getListString().get(i);
				WorkflowTaskSeq workflowTaskSeq = new WorkflowTaskSeq();
				workflowTaskSeq.setSequence((i));
				workflowTaskSeq.setTaskId(Integer.parseInt(pLista));
				workflowTaskSeq.setWorkflowId(id);
				workflowTaskSeq.setCreatedAt(new Date());
				workflowTaskSeq.setCreatedBy(name);
				workflowRoleService.saveWorkflowRole(workflowTaskSeq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		workflowService.updateWorkflowStatus(id);
	//	List<Workflow> workflows = workflowService.getallList();
	//	model.put("workflowslist", workflows);
		ra.addAttribute("message", "Workflow Save in draft  successfully");
		ra.addAttribute("css", "success");
		return "redirect:workflowList";
	}

	@GetMapping("getAllTaskList")
		public ModelAndView getAllTaskList(ModelMap model, HttpServletRequest request) {
			List<TaskDetails> taskDetails1 = taskService.getAlltaskList();
			model.put("taskDetails", taskDetails1);
			return new ModelAndView("/Workflow/TaskList");
		}
	
	@RequestMapping(value = { "/createNewTask" })
	public ModelAndView showdashboarddataPageNewTask(ModelMap model, HttpServletRequest request,
			TaskDetails taskDetails) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String taskName = request.getParameter("taskName").trim().replace(" ", "_");
		
		String workfName = request.getParameter("workflowName");
		TaskDetails task=taskService.getTaskNameByName(taskName);
		if (task==null) {
			taskDetails.setTaskName(taskName);
			taskDetails.setCreatedAt(new Date());
			taskDetails.setCreatedBy(name);
			taskService.saveTask(taskDetails);
			model.addAttribute("message", "Task created successfully");
			model.addAttribute("css", "success");
			LOGGER.info("Task created ----->"+taskName);
		} else {
			model.addAttribute("message", "Task name is already exit");
			model.addAttribute("css", "danger");
			LOGGER.error("Task not created(dublicat)----> "+taskName);
		}
		List<TaskDetails> taskDetails1 = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails1);
//		List<Workflow> workflows = workflowService.getallList();
//		model.put("workflowslist", workflows);
//		LOGGER.info("workflowName and create task -->"+workfName);
//		if (workfName == "") {
//
//		} else {
//			model.put("workflowName", workfName);
//		}
//		return new ModelAndView("/Workflow/TaskCreation");
		List<Workflow> workflows = workflowService.getallList();
		model.put("workflowslist", workflows);

		return new ModelAndView("/Workflow/TaskList");
	}

	@PostMapping(value = { "/editTaskConfiguration" })
	public ModelAndView edittaskConfiguration(ModelMap model, HttpServletRequest request,
			WorkflowTaskSeq WworkflowTaskSeq) { 
		LOGGER.debug(WworkflowTaskSeq.toString());
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String taskid = request.getParameter("taskid");

		String workflowsid = request.getParameter("workflowid");
		String workflowName = request.getParameter("workflowName");
		model.put("workflowName", workflowName);
		model.put("workflowid", workflowsid);
		LOGGER.debug("id" + taskid + workflowsid);
		WorkflowTaskSeq workflowTaskSeq = workflowRoleService.gettaskDetailsbyid(Integer.parseInt(taskid),
				Integer.parseInt(workflowsid));
		model.put("workflowTaskSeq", workflowTaskSeq);
		LOGGER.debug("workflowTaskSeq :" + workflowTaskSeq.getTask().getTaskName());
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowsid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
//			  if (taskName == null) {
//				  taskName = workflowTaskSeqlist.get(0).getTask().getTaskName();
//			  	} 
		List<Role> role = roleService.getaskList();
		/*
		 * List<Role> role1 = new CopyOnWriteArrayList<Role>(role); int i = 0; for (Role
		 * role2 : role1) { i++; if
		 * (workflowTaskSeq.getRole().getRoleName().equalsIgnoreCase(role2.getRoleName()
		 * )) { // role.remove(i); } }
		 */
		// role.set(0, workflowTaskSeq.getRole());
		model.put("rolelist", role);
		List<EmailTemp> emailTemp=	emailTempService.getEmailList();
		model.put("emailTemp", emailTemp);
		model.put("taskRealName", workflowTaskSeq.getTask().getTaskName());
		model.put("taskName", 2);
		model.put("workflowType", workflowTaskSeqlist.get(0).getWorkflow().getWorkflowType());

		return new ModelAndView("/Workflow/DefineRules");
	}

	@PostMapping(value = { "/SaveTaskConfig" })
	public ModelAndView SaveTaskConfig(ModelMap model, HttpServletRequest request, WorkflowTaskSeq workflowTaskSeq) {
		LOGGER.debug("workflowTaskSeq : " + workflowTaskSeq.toString());
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String taskName = request.getParameter("taskname");
		LOGGER.debug("task :" + taskName);
		
		WorkflowTaskSeq workflowTaskSeqDetails = workflowRoleService.workflowTaskSeqbyId(workflowTaskSeq.getId());
		try {
			workflowTaskSeqDetails.setRoleId(workflowTaskSeq.getRoleId());
		} catch (Exception e) {
		}
		workflowTaskSeqDetails.setTat(workflowTaskSeq.getTat());
		workflowTaskSeqDetails.setApproval(workflowTaskSeq.getApproval());
		workflowTaskSeqDetails.setEmailFlag(workflowTaskSeq.getEmailFlag());
		workflowTaskSeqDetails.setReadOnly(workflowTaskSeq.getReadOnly());
		workflowTaskSeqDetails.setAssign_back(workflowTaskSeq.getAssign_back());
		workflowTaskSeqDetails.setFileType(workflowTaskSeq.getFileType());
		workflowTaskSeqDetails.setSkip(workflowTaskSeq.getSkip());
		workflowTaskSeqDetails.setNoms(workflowTaskSeq.getNoms());
		workflowTaskSeqDetails.setEmailId(workflowTaskSeq.getEmailId());
		workflowTaskSeqDetails.setEditeIssueJournal(workflowTaskSeq.getEditeIssueJournal());
		workflowRoleService.updateworkflowTaskSeq(workflowTaskSeqDetails);
		System.out.println("---->"+workflowTaskSeqDetails.toString());
		String taskid = request.getParameter("taskid");
		String workflowsid = request.getParameter("workflowid");
		String workflowName = request.getParameter("workflowName");
		model.put("workflowName", workflowName);
		model.put("workflowid", workflowsid);
		LOGGER.debug("id" + taskid + workflowsid);
		
		
//		WorkflowTaskSeq workflowTaskSeq1 = workflowRoleService.getTaskId(Integer.parseInt(workflowsid));
//		model.put("workflowTaskSeq", workflowTaskSeq1);
        Integer seqNo = workflowTaskSeqDetails.getSequence();
WorkflowTaskSeq workflowTaskSeq1 = workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowsid),seqNo);
System.out.println("tat :- " +workflowTaskSeq1.getTat());   
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowsid));
		
		Role roleName=roleService.getRoleByID(workflowTaskSeq.getRoleId());
		model.put("roleName", roleName);
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		
		List<Role> role = roleService.getaskList();
		model.put("rolelist", role);
		List<EmailTemp> emailTemp=	emailTempService.getEmailList();
		model.put("emailTemp", emailTemp);
		model.put("taskRealName", taskName);
		model.put("taskName", 2);
		model.addAttribute("message", roleName.getRoleName() + "\r\n" +"configuration successfully in"+ "\r\n" + taskName);
		model.addAttribute("css", "success");
		return new ModelAndView("/Workflow/DefineRules");
	}

	@RequestMapping(value = { "/WorkflowPreview" })
	public ModelAndView WorkflowPreview(ModelMap model, HttpServletRequest request, WorkflowTaskSeq workflowTaskSeq) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String workflowsid = request.getParameter("workflowid");
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowsid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		System.out.println("workflowTaskSeqlist :"+workflowTaskSeqlist.toString());
		List<Role> role = roleService.getaskList();
		System.out.println(role.toString());
		/*
		 * model.addAttribute("message", "Workflow data save successfully.");
		 * model.addAttribute("css","success");
		 */
		String workflowName = workflowTaskSeqlist.get(0).getWorkflow().getName();
		model.put("WorkflowName",workflowName);
		model.put("rolelist", role);
		return new ModelAndView("/Workflow/WorkflowPreview");
	}

	/*
	 * public ResponseEntity<?> workflowCreate(@RequestBody WorkflowVO workflow) {
	 * 
	 * Workflow wf = new Workflow(); WorkflowTaskSeq wrs = new WorkflowTaskSeq();
	 * 
	 * wf.setName(workflow.getWorkflowName()); wf.setType(workflow.getType());
	 * wf.setActive(workflow.getActive()); wf.setCreatedBY(workflow.getCreatedBy());
	 * 
	 * // int workflowID = workflowService.saveWorkflow(wf);
	 * 
	 * for (int i = 0; i <= workflow.getTaskSeqVO().size() - 1; i++) {
	 * 
	 * wrs.setWorkflowId(workflowID);
	 * wrs.setStepNo(workflow.getTaskSeqVO().get(i).getSeqNo());
	 * wrs.setCreatedBy(workflow.getCreatedBy());
	 * wrs.setTaskId(workflow.getTaskSeqVO().get(i).getTaskID());
	 * 
	 * workflowRoleService.createWorkflowRole(wrs); }
	 * 
	 * return new ResponseEntity<>("", HttpStatus.CREATED);
	 * 
	 * }
	 */
	@PostMapping("deleteWorkflow")
	public ResponseEntity<?> deleteTask(@RequestBody Workflow workflow) {

		workflowService.deleteWorkflowById(workflow.getId());
		return new ResponseEntity<>("", HttpStatus.OK);

	}

	@GetMapping("getWorkflow")
	public ResponseEntity<?> getTask() {
		List<Workflow> wokflowList = workflowService.getWorkflow();
		return new ResponseEntity<>(wokflowList, HttpStatus.OK);

	}

	@PostMapping("updateworkflowrole")
	public ResponseEntity<?> updateWorkflowRoleByTaskId(@RequestBody WorkflowVO workflow) {

		workflowRoleService.updateTaskWorkflowRole(workflow.getWorkflowID(), workflow.getTaskID(),
				workflow.getReadOnly(), workflow.getEmailFlag(), workflow.getTat(), workflow.getRoleID());
		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
