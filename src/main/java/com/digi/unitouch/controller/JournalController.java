package com.digi.unitouch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.EmailJournalWorkflowService;
import com.digi.unitouch.service.EmailTempService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.PublisherService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserRoleService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.JournalVo;
import com.digi.unitouch.vo.UserRoleVo;

@Controller
public class JournalController extends LoggerClass {
	@Autowired
	JournalService journalService;
	@Autowired
	WorkflowService workflowService;
	@Autowired
	TaskService taskService;
	@Autowired
	RoleService roleService;
	@Autowired
	WorkflowTaskService workflowRoleService;
	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DepartmentService deptService;
	@Autowired
	PublisherService pubService;
	@Autowired
	EmailJournalWorkflowService emailJournalWorkflowService;
	@Autowired
	EmailTempService emailTempService;
	@Autowired
	IssueDetailService issueDetailService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserService userService;

	@GetMapping("/journalList")
	public String journalList(ModelMap model, HttpServletRequest request, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		String journalId = request.getParameter("jId");
		String workflowid = request.getParameter("wfId");
		String flag = request.getParameter("issueworkflow");
		List<Journal> journal = journalService.getallList();
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		model.put("journallist", journal);
		if (workflowid == "") {
			workflowid = null;
		}
		if (workflowid != null) {
			Journal journaldata = journalService.getjournalbyId(Integer.parseInt(journalId));
			if (flag.equalsIgnoreCase("1")) {
				journaldata.setIssueWorkflowId(0);
			} else {
				journaldata.setArticleWorkflowId(0);
			}
			journalService.savejournal(journaldata);
			manageJournalworkflowService.deleteManageJournalworkflow(Integer.parseInt(journalId),
					Integer.parseInt(workflowid));
			return "journalList";
		} else {
			return "journalList";
		}

	}

	@GetMapping("journal")
	public ModelAndView journal(ModelMap model) {
		List<Publisher> pubList = pubService.getallList();
		model.addAttribute("publisherList", pubList);
		System.out.println(journalService.getTaskStatusByJournal());

		return new ModelAndView("journal");
	}

	@PostMapping("manageworkFlowJournal")
	public String manageworkFlowJournal(ModelMap model, HttpServletRequest request) {
		String journalId = request.getParameter("jId");
		model.put("journalId", journalId);
		Journal journal = journalService.getjournalbyId(Integer.parseInt(journalId));
		model.put("journalName", journal.getJournalName());
		String workflowid = request.getParameter("wfId");
		if (workflowid == "") {
			List<Workflow> workflows = workflowService.getallListbytype("Issue");
			model.put("workflowslist", workflows);
			model.put("type", "Article");
			return "manageworkFlowJournal";
		}
		List<Workflow> workflows = workflowService.getallListbytype("Issue");
		model.put("workflowslist", workflows);
		model.put("type", "Article");
		return "manageworkFlowJournal";
	}

	@PostMapping("manageIssueworkFlowJournal")
	public String manageIssueworkFlowJournal(ModelMap model, HttpServletRequest request) {
		String journalId = request.getParameter("jId");
		Journal journal = journalService.getjournalbyId(Integer.parseInt(journalId));
		model.put("journalName", journal.getJournalName());
		model.put("journalId", journalId);
		String workflowid = request.getParameter("wfId");
		if (workflowid == "") {
			List<Workflow> workflows = workflowService.getallListbyIssuetype("Issue");
			model.put("workflowslist", workflows);
			model.put("issueworkflow", 1);
			model.put("type", "Issue");
			return "manageworkFlowJournal";
		}
		List<Workflow> workflows = workflowService.getallListbyIssuetype("Issue");
		model.put("workflowslist", workflows);
		model.put("type", "Issue");
		model.put("issueworkflow", 1);
		return "manageworkFlowJournal";
	}

	@PostMapping("viewmanageworkFlowJournal")
	public String viewmanageworkFlowJournal(ModelMap model, HttpServletRequest request) {
		String journalId = request.getParameter("jId");
		Journal journal = journalService.getjournalbyId(Integer.parseInt(journalId));
		int wfId = journal.getArticleWorkflowId();
		Workflow workflow = workflowService.findworkflowbyname(wfId);
		model.put("workflowNmae", workflow.getName());
		model.put("journalName", journal.getJournalName());
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService.workflowTaskSeqlist(wfId);
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		System.out.println(workflowTaskSeqlist.toString());
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(journalId), wfId);
		model.put("manageJournalWorkflows", manageJournalWorkflows);
		System.out.println(manageJournalWorkflows.toString());
		return "viewmanageworkFlowJournal";
	}

	@PostMapping("viewmanageIssueworkFlowJournal")
	public String viewmanageIssueworkFlowJournal(ModelMap model, HttpServletRequest request) {
		String journalId = request.getParameter("jId");
		Journal journal = journalService.getjournalbyId(Integer.parseInt(journalId));
		model.put("journalName", journal.getJournalName());
		int wfId = journal.getIssueWorkflowId();
		Workflow workflow = workflowService.findworkflowbyname(wfId);
		model.put("workflowNmae", workflow.getName());
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService.workflowTaskSeqlist(wfId);
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(journalId), wfId);
		model.put("manageJournalWorkflows", manageJournalWorkflows);
		return "viewmanageworkFlowJournal";
	}

	@PostMapping("savemanageworkFlowJournal")
	public String savemanageworkFlowJournal(ModelMap model, HttpServletRequest request) {
		/// email
		// emailworkflowjournal save
		// String emailId= request.getParameter("emailid");
		// EmailJournalWorkflow emailJournalWorkflow = new EmailJournalWorkflow();
		// ??
		// emailJournalWorkflow.setJrid(jrid);
		// setEmailId(Integer.parseInt(emailId));
		// emailJournalWorkflow.setWkid(Integer.parseInt(workflowsid));
		// emailJournalWorkflowService.saveEmailJournalWorkflow(emailJournalWorkflow);

		String journalId = request.getParameter("jId");
		String workflowid = request.getParameter("id");
		String flag = request.getParameter("issueworkflow");
		String type = request.getParameter("type");

		Journal journal = journalService.getjournalbyId(Integer.parseInt(journalId));
		if (flag.equalsIgnoreCase("1")) {
			journal.setIssueWorkflowId(Integer.parseInt(workflowid));
		} else {
			journal.setArticleWorkflowId(Integer.parseInt(workflowid));
		}
		journalService.savejournal(journal);
		int journalid = Integer.parseInt(journalId);
		int wfId = Integer.parseInt(workflowid);
		model.put("journalId", journalid);
		model.put("wfId", wfId);
		model.put("issueworkflow", flag);

//		manageJournalworkflowService.deleteManageJournalwork(Integer.parseInt(journalId));
		manageJournalworkflowService.deleteManageJournalworkflow(journalid, wfId);
		Map<Integer, List<UserRoleVo>> mapU = new LinkedHashMap<>();// user
		List<WorkflowTaskSeq> uu = workflowRoleService.workflowTaskSeqlist(Integer.parseInt(workflowid));
		Iterator<WorkflowTaskSeq> iterator = uu.iterator();
		while (iterator.hasNext()) {
			WorkflowTaskSeq dashboard = iterator.next();
			ManageJournalWorkflow manageJournalWorkflow = new ManageJournalWorkflow();
			manageJournalWorkflow.setWorkflow_id(Integer.parseInt(workflowid));
			manageJournalWorkflow.setJournal_id(Integer.parseInt(journalId));
			manageJournalWorkflow.setRole_id(dashboard.getRoleId());
			manageJournalWorkflow.setTask_id(dashboard.getTaskId());
			List<UserRoleVo> user = userRoleService.usersbyRoleId(dashboard.getRoleId());//
			manageJournalWorkflow.setUser_id(user.get(0).getUserid());
			manageJournalWorkflow.setFileFtpInput("");
			manageJournalworkflowService.savemanageworkflow(manageJournalWorkflow);
//			List<ManageJournalWorkflow> manageJournalWork = manageJournalworkflowService
//					.getmanagedetailsbyId(Integer.parseInt(journalId));

			List<UserRoleVo> finalList = new ArrayList<UserRoleVo>();//
			List<UserRoleVo> userRole = userRoleService.usersbyRoleId(dashboard.getRoleId());//
			Iterator<UserRoleVo> iteratorUser = userRole.iterator();
			while (iteratorUser.hasNext()) {
				UserRoleVo userRoleVo = iteratorUser.next();
				userRoleVo.setTaskID(dashboard.getTaskId());
				finalList.add(userRoleVo);
			}
			mapU.put(dashboard.getTaskId(), finalList);
			model.put("department", mapU);

//			List<DepartmentRoleVo> finallist = new ArrayList<DepartmentRoleVo>();
//			List<DepartmentRoleVo> departmentRole = workflowRoleService.departmentIdbyRoleId(dashboard.getRoleId());
//			Iterator<DepartmentRoleVo> iterator1 = departmentRole.iterator();
//			while (iterator1.hasNext()) {
//				DepartmentRoleVo DepartmentRolevo = iterator1.next();
//				DepartmentRolevo.setTaskID(dashboard.getTaskId());
//				finallist.add(DepartmentRolevo);
//			}
//
//			map.put(dashboard.getTaskId(), finallist);
//			model.put("department", map);

		}
		List<Workflow> workflows = workflowService.getallListbyIssuetype(type);// workflowService.getallList();
		model.put("workflowslist", workflows);
		List<WorkflowTaskSeq> workflowTaskSeqlist1 = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		List<WorkflowTaskSeq> workflowTaskSeqlist = Collections.synchronizedList(workflowTaskSeqlist1);
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		model.put("type", type);
		model.put("journalName", journal.getJournalName());
		return "manageworkFlowJournal";
	}

	@PostMapping("manageworkFlowTask")
	public String manageworkFlowTask(ModelMap model, HttpServletRequest request) {
		// String journalId = request.getParameter("jId");
		String workflowid = request.getParameter("workflowid");
		List<Workflow> workflows = workflowService.getallList();
		model.put("workflowslist", workflows);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		return "manageworkFlowJournal";
	}

///journal update in 
	@PostMapping("updateJournalWorkflow")
	public String updateJournaWorkflow(ModelMap model, HttpServletRequest request, RedirectAttributes ra,
			ManageJournalWorkflow manageJournalWorkflow) {
		System.out.println("find data we get" + manageJournalWorkflow.toString());
		ManageJournalWorkflow mjw = manageJournalworkflowService.findBymjWkID(manageJournalWorkflow.getId());
		mjw.setUser_id(manageJournalWorkflow.getUser_id());
		boolean status = manageJournalworkflowService.savemanageworkflow(mjw);
		if (status) {
			Users user = userService.findByUserId(manageJournalWorkflow.getUser_id());
			ra.addAttribute("message", user.getFirstName() + "&nbsp; " + user.getLastName() + "&nbsp;("
					+ user.getRole().getRoleName() + ")&nbsp; is updated in Journal successfully");
			ra.addAttribute("css", "success");
		} else {
			ra.addAttribute("message", mjw.getUsers().getFirstName() + "&nbsp; " + mjw.getUsers().getLastName()
					+ "&nbsp; is not updated in Journal successfully");
			ra.addAttribute("css", "danger");
		}

		ra.addAttribute("jour", mjw.getJournal_id());
		ra.addAttribute("work", mjw.getWorkflow_id());
		return "redirect:viewUpdateJournalWorkflow";

	}
	
	@GetMapping("viewUpdateJournalWorkflow")
	public String viewUpdateJournalWorkflow(ModelMap model, HttpServletRequest request,
			@ModelAttribute("message") String message, @ModelAttribute("css") String css,
			@ModelAttribute("jour") String jour,@ModelAttribute("work") String work) {
	///public String viewUpdateJournalWorkflow(ModelMap model, HttpServletRequest request) {
	//	String journalId = request.getParameter("jId");
		Journal journal = journalService.getjournalbyId(Integer.parseInt(jour));
		//int wfId = journal.getArticleWorkflowId();
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(work));
		model.put("workflowNmae", workflow.getName());
		model.put("journalName", journal.getJournalName());
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService.workflowTaskSeqlist(Integer.parseInt(work));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		System.out.println(workflowTaskSeqlist.toString());
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId((Integer.parseInt(jour)), Integer.parseInt(work));
		model.put("manageJournalWorkflows", manageJournalWorkflows);
		System.out.println(manageJournalWorkflows.toString());
		return "viewmanageworkFlowJournal";
	}
	
	

	@PostMapping("savedepartment")
	public String savedepartment(ModelMap model, HttpServletRequest request) throws IOException {
		// BufferedReader reader;
		List<String> fileftpInput = new ArrayList<String>();
		List<String> fileftpOutput = new ArrayList<String>();
		String journalId = request.getParameter("jId");
		String listString = request.getParameter("listString");
		String workflowid = request.getParameter("wfId");
		String type = request.getParameter("type");
		// String roleId = request.getParameter("roleId");
		// String DeptId = request.getParameter("department");
		String[] temp = listString.split(",");
		for (int i = 0; i < temp.length; i++) {
			String DepartId = temp[i];

			if (DepartId.startsWith("test[]:_")) {

				String[] data = DepartId.split("_");
				for (int j = 0; j < 1; j++) {
					String roleId1 = data[1].trim();
					String DepartID = (data[2].trim());
					String taskID = (data[3].trim());
					// String file_ftp = (data[4].trim());
					int dId = Integer.parseInt(DepartID);
					ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
							Integer.parseInt(workflowid), Integer.parseInt(journalId), Integer.parseInt(roleId1),
							Integer.parseInt(taskID));
					// manageJournalWorkflow.setDept_id(dId);//remove 
					manageJournalWorkflow.setUser_id(dId);
			//	boolean status =saveEmailData(manageJournalWorkflow);
					// manageJournalWorkflow.setFileFtp(fileftp.get(0));
					manageJournalworkflowService.savemanageworkflow(manageJournalWorkflow);
				}
			}

			if (DepartId.startsWith("fileftpInput")) {
				String ft = DepartId.replace("fileftpInput:", "");
				fileftpInput.add(ft);
				System.out.println(DepartId);
			}

			if (DepartId.startsWith("fileftpOutput")) {
				String ft = DepartId.replace("fileftpOutput:", "");
				fileftpOutput.add(ft);
				System.out.println(DepartId);
			}
		}
		List<ManageJournalWorkflow> manageJournalWorkflow = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(journalId), Integer.parseInt(workflowid));
		int ftp = 0;
		for (ManageJournalWorkflow manageJournalWork : manageJournalWorkflow) {
			manageJournalWork.setFileFtpInput(fileftpInput.get(ftp));
			manageJournalWork.setFileFtpOutput(fileftpOutput.get(ftp));
			manageJournalworkflowService.savemanageworkflow(manageJournalWork);
			ftp++;
		}
		List<ManageJournalWorkflow> forEmail = manageJournalworkflowService.getlistbyId( Integer.parseInt(journalId),Integer.parseInt(workflowid));
		for (ManageJournalWorkflow manageJournalWorkflow2 : forEmail) {
				saveEmailData(manageJournalWorkflow2);
				LOGGER.info("Email Setup ---->"+manageJournalWorkflow2.getTask().getTaskName());
		}
		List<Journal> journal = journalService.getallList();
		model.put("journallist", journal);
		model.addAttribute("css", "success");
		model.addAttribute("message", type + " Workflow is set successfully to journal");
		return "journalList";
	}

	public boolean saveEmailData(ManageJournalWorkflow mjw) {
		EmailJournalWorkflow ejw = new EmailJournalWorkflow();
		WorkflowTaskSeq ws = workflowRoleService.gettaskDetailsbyid(mjw.getTask_id(), mjw.getWorkflow_id());
		ejw.setEmailId(Integer.parseInt(ws.getEmailId()));
		ejw.setJrid(mjw.getJournal_id());
		ejw.setTaskId(mjw.getTask_id());
		ejw.setWkid(mjw.getWorkflow_id());
		ejw.setTo(mjw.getUser_id());
		WorkflowTaskSeq preSeq=	workflowRoleService.getTaskIdandWorkflowid(mjw.getWorkflow_id(), 	ws.getSequence()-1);
		if (preSeq != null) {
			Integer nextTaskid = preSeq.getTaskId();
			ManageJournalWorkflow preTaskDetails = manageJournalworkflowService.getUsersallby(mjw.getWorkflow_id(),
					mjw.getJournal_id(), nextTaskid);
			// model.put("preTaskDetails", preTaskDetails.getUsers());
			// model.put("preTaskId", preTaskDetails.getTask_id());
			ejw.setPreTaskid(preTaskDetails.getTask_id());
			ejw.setPreUserid(preTaskDetails.getUser_id());
		} else {
			LOGGER.info("preTaskDetails user is not persent");
			// model.put("preTaskId","NA");
		}
		WorkflowTaskSeq wts=	workflowRoleService.getTaskIdandWorkflowid(mjw.getWorkflow_id(), 	ws.getSequence()+1);
		if(wts!=null) {
		Integer nextTaskid=wts.getTaskId();
		ManageJournalWorkflow nextTaskDetails= manageJournalworkflowService.getUsersallby(mjw.getWorkflow_id(), mjw.getJournal_id(), nextTaskid);
	//	model.put("nextUserList", nextTaskDetails.getUsers());
	//	model.put("nextTaskId", nextTaskDetails.getTask_id());
		ejw.setNextTaskid(nextTaskDetails.getTask_id());
		ejw.setNextUserid(nextTaskDetails.getUser_id());
		LOGGER.info("next user is  persent");
		}else {		
			LOGGER.info("next user is not persent");
			//model.put("nextTaskId","NA");
		} 
		LOGGER.debug("emailJournalWorkflow :" + ejw.toString());
		emailJournalWorkflowService.saveEmailJournalWorkflow(ejw);
		return true;
	}
	
	
	@PostMapping("createjournal")
	public String createUser(@Valid @ModelAttribute("journal") JournalVo journalVo, BindingResult result,
			ModelMap model, RedirectAttributes ra) {
		Journal jr = journalService.getJournalbyabbrname(journalVo.getJournalAcronym().toLowerCase());
		Journal jr1 = journalService.getJournalname(journalVo.getJournalTitle());
		List<Journal> journalList = journalService.getallList();
		model.put("journallist", journalList);
		if (jr != null) {
			ra.addAttribute("css", "danger");
			ra.addAttribute("message", journalVo.getJournalAcronym().toUpperCase() + " \r\n already exist");
			return "redirect:journalList";
		} else if (jr1 != null) {
			ra.addAttribute("css", "danger");
			ra.addAttribute("message", journalVo.getJournalTitle() + " \r\n already exist");
			return "redirect:journalList";
		}else {
			Journal journal = new Journal();
			journal.setJournalName(journalVo.getJournalTitle());
			journal.setPrintIssn(journalVo.getPrintIssn());
			journal.setJournalAcronym(journalVo.getJournalAcronym().toLowerCase());
			journal.setJournalAbbrName(journalVo.getJournalAcronym().toLowerCase());
			journal.setDoiPrefix(journalVo.getDoiPrefix());
			journal.setJournalName(journalVo.getJournalTitle());
			journal.setOpenAccessStatus(journalVo.getoAStatus());
			// journal.setJournalIssn(journalVo.);
			journal.setOnlineIssn(journalVo.getOnlineIssn());
			journal.setStatus("Active");
			journal.setArticleWorkflowId(0);
			journal.setJournalType("MEDKNOW");
			journal.setIssueWorkflowId(0);
			journal.setPublisherId(142);
			journal.setFromEmail(journalVo.getFromEmail());
		//	journal.setFromPassword(journalVo.getFromPassword());
			journal.setPublicationType(journalVo.getPublicationType());
			// start volume number is 30, issue number is 1,
			Integer year = Calendar.getInstance().get(Calendar.YEAR);
			journal.setHouseStyle(journalVo.getHouseStyle());
			journal.setPageLayout(journalVo.getPageLayout());
			journal.setPartnerContact(journalVo.getPartnerContact());
			Integer jrid = journalService.savejournal(journal);
			if (journalVo.getPublicationType().equalsIgnoreCase("Quarterly")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Mar" + year.toString(), "Apr-Jun" + year.toString(),
						" Jul-Sep" + year.toString(), " Oct-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Bimonthly")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Feb" + year.toString(), "Mar-Apr" + year.toString(),
						"May-Jun" + year.toString(), "Jul-Aug" + year.toString() , "Sep-Oct" + year.toString(), "Nov-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Semiannual")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Jun" + year.toString(),  "Jul-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					 issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Triannual")) {
				int i = 1;
				String[] issueQuterly = { "Jan-Apr" + year.toString(),"May-Aug" + year.toString(),"Sep-Dec" + year.toString() };
				for (String issueTitel : issueQuterly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					issueDetailService.saveIssue(issue);
					i++;
				}
			}
			
			if (journalVo.getPublicationType().equalsIgnoreCase("Yearly")) {
				String[] issueYearly = { "Jan-Dec" + year.toString() };
				int i = 1;
				for (String issueTitel : issueYearly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					issueDetailService.saveIssue(issue);
					i++;
				}
			}
			if (journalVo.getPublicationType().equalsIgnoreCase("Monthly")) {
				String[] issueMonthly = { "January-" + year.toString(), "February-" + year.toString(),
						"March-" + year.toString(), "April-" + year.toString(), "May-" + year.toString(),
						"June-" + year.toString(), "July-" + year.toString(), "August-" + year.toString(),
						"September-" + year.toString(), "October-" + year.toString(), "November-" + year.toString(),
						"December-" + year.toString() };
				int i = 1;
				for (String issueTitel : issueMonthly) {

					IssueDetail issue = new IssueDetail();
					issue.setIssue_title(issueTitel);
					issue.setCreate_date(new Date());
					issue.setPublisher_id(142);
					issue.setJournalId(jrid);
					issue.setNumber_of_volume_per_year("30");
					issue.setVolume_year(year.toString());
					issue.setLast_issue_number("1");
					issue.setIssueSeqNo(i);
					issue.setIssue_status("Y");
					issue.setIsSupplementary("N");
					issue.setIsScheduled("N");
					issueDetailService.saveIssue(issue);
					i++;
				}
			}
			// model.addAttribute("css", "success");
			// model.addAttribute("message", journalVo.getJournalAcronym().toUpperCase()+"
			// \r\n created successfully");
			// return "journalList";
			//ra.addAttribute("message", journalVo.getJournalAcronym().toUpperCase() + " \r\n Journal created successfully");
			ra.addAttribute("message", "Journal created successfully");
			ra.addAttribute("css", "success");
			return "redirect:journalList";
		}
	}

//	@PostMapping("emailJournalMail")
//	public ModelAndView editworkFlow(ModelMap model, HttpServletRequest request, WorkflowTaskSeq WworkflowTaskSeq) {
//		LOGGER.debug("WworkflowTaskSeq : " + WworkflowTaskSeq.toString());
//		// String name =
//		// SecurityContextHolder.getContext().getAuthentication().getName();
//		String workflowid = null;
//		workflowid = request.getParameter("workflowid");
//		String taskId = request.getParameter("taskid");
//		String jid = request.getParameter("jId");
//		WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(Integer.parseInt(workflowid));
////		Set<Department> manageJournalWorkflow = manageJournalworkflowService.getGroupList(Integer.parseInt(jid),
////				Integer.parseInt(workflowid));
////		LOGGER.debug("manageJournalWorkflow :" + manageJournalWorkflow);
////		model.put("departmentList", manageJournalWorkflow);
//		List<Role> rolelist = roleService.getRoleList();
//		model.put("roleList", rolelist);
//		List<TaskDetails> taskDetails = null;
//		TaskDetails task = null;
//		EmailJournalWorkflow emailDetails = null;
//		if (taskId == null) {
//			model.put("taskRealName", workflowTaskSeq.getTask().getTaskName());
//			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
//					workflowTaskSeq.getTask().getId());
//			model.put("taskid", workflowTaskSeq.getTask().getId());
//			List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
//					.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
//			model.put("manageJournalWorkflows", manageJournalWorkflows);
//			System.out.println(manageJournalWorkflows.toString());
//		} else {
//			LOGGER.debug("taskid :" + Integer.parseInt(taskId));
//			task = taskService.getTaskNameBy(Integer.parseInt(taskId));
//			model.put("taskRealName", task.getTaskName());
//			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
//					Integer.parseInt(taskId));
//			model.put("taskid", Integer.parseInt(taskId));
//			List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
//					.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
//			model.put("manageJournalWorkflows", manageJournalWorkflows);
//			System.out.println(manageJournalWorkflows.toString());
//
//		}
//
//		if (workflowid == "") {
//			workflowid = request.getAttribute("workflowid").toString();
//		}
//		model.put("workflowTaskSeq", workflowTaskSeq);
//	
//		// find email temp id panding
//		// emailJournalWorkflowService.findById(1);
//		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
//		model.put("workflowName", workflow.getName());
//		model.put("workflowid", workflow.getId());
//
//		model.put("taskDetails", taskDetails);
//		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
//				.workflowTaskSeqlist(Integer.parseInt(workflowid));
//		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
//
//		LOGGER.debug("workflowTaskSeq : " + workflowTaskSeq.toString());
//		model.put("taskName", 2);
//		model.put("jrid", jid);
//		if (emailDetails != null) {
//			model.put("emailJournalTask", emailDetails);
//			// System.out.println(emailDetails.toString());
//			String temp = emailTempService.getEmailTemplateID(emailDetails.getEmailId());
//			model.put("template", temp);
//		} else {
//			model.put("emailJournalTask", emailDetails);
//			model.put("template", null);
//		}
//		return new ModelAndView("/email/assignEmail");
//	}

	
	@PostMapping("emailJournalMail")
	public ModelAndView editworkFlow(ModelMap model, HttpServletRequest request, WorkflowTaskSeq WworkflowTaskSeq) {
		LOGGER.debug("WworkflowTaskSeq : " + WworkflowTaskSeq.toString());
		// String name =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		String workflowid = null;
		workflowid = request.getParameter("workflowid");
		String taskId = request.getParameter("taskid");
		String jid = request.getParameter("jId");
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
		
		List<Role> roleDetails = roleService.getRoleList();
		model.addAttribute("roleDetails", roleDetails);
		List<TaskDetails> taskDetails = null;
		TaskDetails task = null;
		EmailJournalWorkflow emailDetails = null;
		if (taskId == null) {
		//	model.put("taskRealName", workflowTaskSeq.getTask().getTaskName());
			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
					manageJournalWorkflows.get(0).getTask().getId());
			model.put("taskid", manageJournalWorkflows.get(0).getTask().getId());
			model.put("taskRealName", manageJournalWorkflows.get(0).getTask().getTaskName());
			model.put("manageJournalWorkflows", manageJournalWorkflows);
			model.put("userList", manageJournalWorkflows.get(0).getUsers());
			model.put("nextUserList", manageJournalWorkflows.get(1).getUsers());
			model.put("nextTaskId", manageJournalWorkflows.get(1).getTask_id());
			LOGGER.info("preTaskDetails user is not persent");
			model.put("preTaskDetails", "NA");
		//	model.put("preTaskId","NA");
			System.out.println(manageJournalWorkflows.toString());
		} else {
			LOGGER.debug("taskid :" + Integer.parseInt(taskId));
			task = taskService.getTaskNameBy(Integer.parseInt(taskId));
			model.put("taskRealName", task.getTaskName());
			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
					Integer.parseInt(taskId));
			ManageJournalWorkflow mj= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), Integer.parseInt(taskId));
			model.put("taskid", Integer.parseInt(taskId));
			model.put("userList", mj.getUsers());
			WorkflowTaskSeq wts = workflowRoleService.gettaskDetailsbyid(Integer.parseInt(taskId),
					Integer.parseInt(workflowid));
			WorkflowTaskSeq ws=	workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid), 	wts.getSequence()+1);
			if(ws!=null) {
			Integer nextTaskid=ws.getTaskId();
			ManageJournalWorkflow nextTaskDetails= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("nextUserList", nextTaskDetails.getUsers());
			model.put("nextTaskId", nextTaskDetails.getTask_id());
			}else {
				LOGGER.info("next user is not persent");
				model.put("nextUserList", "NA");
				//model.put("nextTaskId","NA");
			} 
			WorkflowTaskSeq preSeq=	workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid), 	wts.getSequence()-1);
			if(preSeq!=null) {
				Integer nextTaskid=preSeq.getTaskId();
				ManageJournalWorkflow preTaskDetails= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
				model.put("preTaskDetails", preTaskDetails.getUsers());
				model.put("preTaskId", preTaskDetails.getTask_id());
				}else {
					LOGGER.info("preTaskDetails user is not persent");
					model.put("preTaskDetails", "NA");
				//	model.put("preTaskId","NA");	
					}
			model.put("manageJournalWorkflows", manageJournalWorkflows);
			System.out.println(manageJournalWorkflows.toString());

		}

		if (workflowid == "") {
			workflowid = request.getAttribute("workflowid").toString();
		}
///		model.put("workflowTaskSeq", workflowTaskSeq);
	
		// find email temp id panding
		// emailJournalWorkflowService.findById(1);
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("workflowid", workflow.getId());

		model.put("taskDetails", taskDetails);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);

//		LOGGER.debug("workflowTaskSeq : " + workflowTaskSeq.toString());
		model.put("taskName", 2);
		model.put("jrid", jid);
		if (emailDetails != null) {
			model.put("emailJournalTask", emailDetails);
			// System.out.println(emailDetails.toString());
			String temp = emailTempService.getEmailTemplateID(emailDetails.getEmailId());
			model.put("template", temp);
		} else {
			model.put("emailJournalTask", emailDetails);
			model.put("template", null);
		}
		return new ModelAndView("/email/assignEmail");
	}
	
	
	@PostMapping("saveAssignEmail")
	public ModelAndView saveEmailTemp(ModelMap model, HttpServletRequest request,
			EmailJournalWorkflow emailJournalWorkflow) {
		// String name =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.debug("emailJournalWorkflow :" + emailJournalWorkflow.toString());
		String workflowid = null;
		EmailJournalWorkflow emailDetails = null;
		// String roleid = request.getParameter("roleId");
		String ejwId = request.getParameter("ejwId");
		String jid = request.getParameter("jId");
		workflowid = request.getParameter("workflowid");
		String taskId = request.getParameter("taskid");
		String emailId = request.getParameter("emailid");
		List<Role> roleDetails = roleService.getRoleList();
		model.addAttribute("roleDetails", roleDetails);
		LOGGER.debug("taskid :" + Integer.parseInt(taskId));
		TaskDetails task = taskService.getTaskNameBy(Integer.parseInt(taskId));
		if (workflowid == "") {
			workflowid = request.getAttribute("workflowid").toString();
		}

		emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
				task.getId());
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("jrid", jid);
		model.put("workflowid", workflow.getId());
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		WorkflowTaskSeq wts = workflowRoleService.gettaskDetailsbyid(Integer.parseInt(taskId),
				Integer.parseInt(workflowid));
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
		ManageJournalWorkflow mj = manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid),
				Integer.parseInt(jid), Integer.parseInt(taskId));
		model.put("userList", mj.getUsers());
		WorkflowTaskSeq ws = workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid),
				wts.getSequence() + 1);
		if (ws != null) {
			Integer nextTaskid = ws.getTaskId();
			ManageJournalWorkflow nextTaskDetails = manageJournalworkflowService
					.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("nextUserList", nextTaskDetails.getUsers());
			model.put("nextTaskId", nextTaskDetails.getTask_id());
		} else {
			LOGGER.info("next user is not persent");
			model.put("nextUserList", "NA");
			// model.put("nextTaskId","NA");
		}
		WorkflowTaskSeq preSeq = workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid),
				wts.getSequence() - 1);
		if (preSeq != null) {
			Integer nextTaskid = preSeq.getTaskId();
			ManageJournalWorkflow preTaskDetails = manageJournalworkflowService
					.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("preTaskDetails", preTaskDetails.getUsers());
			model.put("preTaskId", preTaskDetails.getTask_id());
		} else {
			LOGGER.info("preTaskDetails user is not persent");
			model.put("preTaskDetails", "NA");
			// model.put("preTaskId","NA");
		}
		model.put("manageJournalWorkflows", manageJournalWorkflows);
		model.put("taskName", 2);
		model.put("emailJournalTask", emailDetails);
		model.put("taskList", wts);
		model.put("taskRealName", task.getTaskName());
		model.put("taskid", Integer.parseInt(taskId));
		if (ejwId == "") {
			// emailJournalWorkflow.setEjwId(Integer.parseInt(ejwId));

		} else {
			emailJournalWorkflow.setEjwId(Integer.parseInt(ejwId));

		}

		emailJournalWorkflow.setEmailId(Integer.parseInt(emailId));
		emailJournalWorkflow.setJrid(Integer.parseInt(jid));
		emailJournalWorkflow.setTaskId(Integer.parseInt(taskId));
		emailJournalWorkflow.setWkid(Integer.parseInt(workflowid));
		// emailJournalWorkflow.setRoleId(Integer.parseInt(roleid));
		LOGGER.debug("emailJournalWorkflow :" + emailJournalWorkflow.toString());
		Integer emjw = emailJournalWorkflowService.saveEmailJournalWorkflow(emailJournalWorkflow);
		EmailJournalWorkflow emailJournalTask = emailJournalWorkflowService.getOne(emjw);
		model.put("emailJournalTask", emailJournalTask);
		model.put("template", emailTempService.getEmailTemplateID(emailJournalTask.getEmailId()));
		System.out.println(emailJournalTask.toString());
		model.addAttribute("css", "success");
		model.addAttribute("message",
				" Email configuration\r\n" + "\r\n With \r\n " + task.getTaskName() + "\r\n" + " is saved successfully");
		return new ModelAndView("/email/assignEmail");
	}
	
	@PostMapping("emailJournalIssueMail")
	public ModelAndView emailJournalIssueMail(ModelMap model, HttpServletRequest request, WorkflowTaskSeq WworkflowTaskSeq) {
		LOGGER.debug("WworkflowTaskSeq : " + WworkflowTaskSeq.toString());
		// String name =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		String workflowid = null;
		workflowid = request.getParameter("workflowid");
		String taskId = request.getParameter("taskid");
		String jid = request.getParameter("jId");
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
		
		List<Role> roleDetails = roleService.getRoleList();
		model.addAttribute("roleDetails", roleDetails);
		List<TaskDetails> taskDetails = null;
		TaskDetails task = null;
		EmailJournalWorkflow emailDetails = null;
		if (taskId == null) {
		//	model.put("taskRealName", workflowTaskSeq.getTask().getTaskName());
			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
					manageJournalWorkflows.get(0).getTask().getId());
			model.put("taskid", manageJournalWorkflows.get(0).getTask().getId());
			model.put("taskRealName", manageJournalWorkflows.get(0).getTask().getTaskName());
			model.put("manageJournalWorkflows", manageJournalWorkflows);
			model.put("userList", manageJournalWorkflows.get(0).getUsers());
			model.put("nextUserList", manageJournalWorkflows.get(1).getUsers());
			model.put("nextTaskId", manageJournalWorkflows.get(1).getTask_id());
			LOGGER.info("preTaskDetails user is not persent");
			model.put("preTaskDetails", "NA");
		//	model.put("preTaskId","NA");
			System.out.println(manageJournalWorkflows.toString());
		} else {
			LOGGER.debug("taskid :" + Integer.parseInt(taskId));
			task = taskService.getTaskNameBy(Integer.parseInt(taskId));
			model.put("taskRealName", task.getTaskName());
			emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
					Integer.parseInt(taskId));
			ManageJournalWorkflow mj= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), Integer.parseInt(taskId));
			model.put("taskid", Integer.parseInt(taskId));
			model.put("userList", mj.getUsers());
			WorkflowTaskSeq wts = workflowRoleService.gettaskDetailsbyid(Integer.parseInt(taskId),
					Integer.parseInt(workflowid));
			WorkflowTaskSeq ws=	workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid), 	wts.getSequence()+1);
			if(ws!=null) {
			Integer nextTaskid=ws.getTaskId();
			ManageJournalWorkflow nextTaskDetails= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("nextUserList", nextTaskDetails.getUsers());
			model.put("nextTaskId", nextTaskDetails.getTask_id());
			}else {
				LOGGER.info("next user is not persent");
				model.put("nextUserList", "NA");
				//model.put("nextTaskId","NA");
			}
			WorkflowTaskSeq preSeq=	workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid), 	wts.getSequence()-1);
			if(preSeq!=null) {
				Integer nextTaskid=preSeq.getTaskId();
				ManageJournalWorkflow preTaskDetails= manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
				model.put("preTaskDetails", preTaskDetails.getUsers());
				model.put("preTaskId", preTaskDetails.getTask_id());
				}else {
					LOGGER.info("preTaskDetails user is not persent");
					model.put("preTaskDetails", "NA");
				//	model.put("preTaskId","NA");	
					}
			model.put("manageJournalWorkflows", manageJournalWorkflows);
			System.out.println(manageJournalWorkflows.toString());

		}

		if (workflowid == "") {
			workflowid = request.getAttribute("workflowid").toString();
		}
///		model.put("workflowTaskSeq", workflowTaskSeq);
	
		// find email temp id panding
		// emailJournalWorkflowService.findById(1);
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("workflowid", workflow.getId());

		model.put("taskDetails", taskDetails);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);

//		LOGGER.debug("workflowTaskSeq : " + workflowTaskSeq.toString());
		model.put("taskName", 2);
		model.put("jrid", jid);
		if (emailDetails != null) {
			model.put("emailJournalTask", emailDetails);
			// System.out.println(emailDetails.toString());
			String temp = emailTempService.getEmailTemplateID(emailDetails.getEmailId());
			model.put("template", temp);
		} else {
			model.put("emailJournalTask", emailDetails);
			model.put("template", null);
		}
		return new ModelAndView("/email/issueAssignEmail");
	}
	
	@PostMapping("saveIssueAssignEmail")
	public ModelAndView saveIssueAssignEmail(ModelMap model, HttpServletRequest request,
			EmailJournalWorkflow emailJournalWorkflow) {
		// String name =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.debug("emailJournalWorkflow :" + emailJournalWorkflow.toString());
		String workflowid = null;
		EmailJournalWorkflow emailDetails = null;
		// String roleid = request.getParameter("roleId");
		String ejwId = request.getParameter("ejwId");
		String jid = request.getParameter("jId");
		workflowid = request.getParameter("workflowid");
		String taskId = request.getParameter("taskid");
		String emailId = request.getParameter("emailid");
		List<Role> roleDetails = roleService.getRoleList();
		model.addAttribute("roleDetails", roleDetails);
		LOGGER.debug("taskid :" + Integer.parseInt(taskId));
		TaskDetails task = taskService.getTaskNameBy(Integer.parseInt(taskId));
		if (workflowid == "") {
			workflowid = request.getAttribute("workflowid").toString();
		}

		emailDetails = emailJournalWorkflowService.findByejwt(Integer.parseInt(jid), Integer.parseInt(workflowid),
				task.getId());
		Workflow workflow = workflowService.findworkflowbyname(Integer.parseInt(workflowid));
		model.put("workflowName", workflow.getName());
		model.put("jrid", jid);
		model.put("workflowid", workflow.getId());
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowRoleService
				.workflowTaskSeqlist(Integer.parseInt(workflowid));
		model.put("workflowTaskSeqlist", workflowTaskSeqlist);
		WorkflowTaskSeq wts = workflowRoleService.gettaskDetailsbyid(Integer.parseInt(taskId),
				Integer.parseInt(workflowid));
		List<ManageJournalWorkflow> manageJournalWorkflows = manageJournalworkflowService
				.getlistbyId(Integer.parseInt(jid), Integer.parseInt(workflowid));
		ManageJournalWorkflow mj = manageJournalworkflowService.getUsersallby(Integer.parseInt(workflowid),
				Integer.parseInt(jid), Integer.parseInt(taskId));
		model.put("userList", mj.getUsers());
		WorkflowTaskSeq ws = workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid),
				wts.getSequence() + 1);
		if (ws != null) {
			Integer nextTaskid = ws.getTaskId();
			ManageJournalWorkflow nextTaskDetails = manageJournalworkflowService
					.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("nextUserList", nextTaskDetails.getUsers());
			model.put("nextTaskId", nextTaskDetails.getTask_id());
		} else {
			LOGGER.info("next user is not persent");
			model.put("nextUserList", "NA");
			// model.put("nextTaskId","NA");
		}
		WorkflowTaskSeq preSeq = workflowRoleService.getTaskIdandWorkflowid(Integer.parseInt(workflowid),
				wts.getSequence() - 1);
		if (preSeq != null) {
			Integer nextTaskid = preSeq.getTaskId();
			ManageJournalWorkflow preTaskDetails = manageJournalworkflowService
					.getUsersallby(Integer.parseInt(workflowid), Integer.parseInt(jid), nextTaskid);
			model.put("preTaskDetails", preTaskDetails.getUsers());
			model.put("preTaskId", preTaskDetails.getTask_id());
		} else {
			LOGGER.info("preTaskDetails user is not persent");
			model.put("preTaskDetails", "NA");
			// model.put("preTaskId","NA");
		}
		model.put("manageJournalWorkflows", manageJournalWorkflows);
		model.put("taskName", 2);
		model.put("emailJournalTask", emailDetails);
		model.put("taskList", wts);
		model.put("taskRealName", task.getTaskName());
		model.put("taskid", Integer.parseInt(taskId));
		if (ejwId == "") {
			// emailJournalWorkflow.setEjwId(Integer.parseInt(ejwId));

		} else {
			emailJournalWorkflow.setEjwId(Integer.parseInt(ejwId));

		}

		emailJournalWorkflow.setEmailId(Integer.parseInt(emailId));
		emailJournalWorkflow.setJrid(Integer.parseInt(jid));
		emailJournalWorkflow.setTaskId(Integer.parseInt(taskId));
		emailJournalWorkflow.setWkid(Integer.parseInt(workflowid));
		// emailJournalWorkflow.setRoleId(Integer.parseInt(roleid));
		LOGGER.debug("emailJournalWorkflow :" + emailJournalWorkflow.toString());
		Integer emjw = emailJournalWorkflowService.saveEmailJournalWorkflow(emailJournalWorkflow);
		EmailJournalWorkflow emailJournalTask = emailJournalWorkflowService.getOne(emjw);
		model.put("emailJournalTask", emailJournalTask);
		model.put("template", emailTempService.getEmailTemplateID(emailJournalTask.getEmailId()));
		System.out.println(emailJournalTask.toString());
		model.addAttribute("css", "success");
		model.addAttribute("message",
				" Email configuration\r\n" + "\r\n With \r\n " + task.getTaskName() + "\r\n" + " is saved successfully");
		return new ModelAndView("/email/issueAssignEmail");
	}
}