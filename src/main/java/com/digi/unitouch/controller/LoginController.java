package com.digi.unitouch.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author 80055
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.ApplicationResponse;
import com.digi.unitouch.component.WebUtils;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.UserTracker;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.ArticleTaskDetailService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.MenuService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.UserTrackerService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ArticleDetailHavingOverloadvo;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.IssueTaskManagementVo;
import com.digi.unitouch.vo.ProductivityTaskVo;
import com.digi.unitouch.vo.TaskManagementVo;

@Controller
public class LoginController extends LoggerClass {

	@Autowired
	TaskService taskService;
	@Autowired
	MenuService menuservice;
	@Autowired
	WorkflowService workflowService;
	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	JournalService journalService;
	@Autowired
	DepartmentService deptService;
	@Autowired
	ArticleTaskDetailService articleTaskDetailService;
	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;

	@Autowired
	UserTrackerService userTracker;
	@Autowired
	IssueDetailService issueDetailService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String view() {
		return "redirect:dashboard";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
			LOGGER.debug("error1");
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
			LOGGER.debug("error2");
		}
		model.addAttribute("errorMessge", errorMessge);
		LOGGER.debug("error3");

		return "login";
	}

	@RequestMapping(value = { "/dashboard" })
	public ModelAndView dashboard(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("message") String message, @ModelAttribute("css") String css) {
		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().replaceAll("\\[", "")
				.replaceAll("\\]", "").equalsIgnoreCase("Management")) {
			return new ModelAndView("/dashboard_management");
		}
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("emailId", name);
		Users users = userService.findUserIdByUserName(name);
		UserTracker ut = WebUtils.getClientIp(users.getUserID());
		userTracker.saveUserTrackerDetails(ut);
		session.setAttribute("passcode", users.getPassword());
		if (users.getRole().getRoleID().equals(Integer.valueOf(1))) {
			List<ArticleDetailsVO> ArticleDetail = articleService.getarticleDetail();
			model.put("ArticleDetail", ArticleDetail.size());
			model.put("articleDetaillist", ArticleDetail);
			List<TaskScheduler> taskScheduler = taskService.getOverDueTaskListDetails();
			model.put("taskScheduler", taskScheduler.size());

			List<ArticleDetailHavingOverloadvo> articleInProgressDetail = articleService.getarticleInProgressDetail();
			model.put("articleInProgressDetail", articleInProgressDetail);
			List<TaskScheduler> articlecompleteDetail = articleService.getarticleCompleteDetail();
			model.put("articlecompleteDetail", articlecompleteDetail);
			List<ArticleDetailHavingOverloadvo> articleOverDueDetail = articleService.getarticleOverDueDetail();
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagementVo);
			model.put("articleOverDueDetail", articleOverDueDetail);
			model.addAttribute("css", css);
			model.addAttribute("message", message);

			LOGGER.info("------------->admindashboard <-------------------");
			return new ModelAndView("/admindashboard");
		}
		if (users.getRole().getRoleID().equals(Integer.valueOf(7))) {
			LOGGER.debug("afdfsdfs  ");
			List<ArticleDetail> ArticleDetail = articleService.getallList();
			model.put("articleDetaillist", ArticleDetail);
			LOGGER.debug("articleDetaillist :" + ArticleDetail);
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagementVo);
			model.addAttribute("css", css);
			model.addAttribute("message", message);
			LOGGER.info("------------->admindashboard  7role <-------------------");
			return new ModelAndView("/admindashboard");
		}
		if (users.getRole().getRoleID().equals(Integer.valueOf(1424))) {
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagementVo);
			model.addAttribute("css", css);
			model.addAttribute("message", message);
			return new ModelAndView("/dashboard_graphics");
		}
		if (users.getRole().getRoleID().equals(Integer.valueOf(3712))) {
			List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagementVo);
			Set<Integer> set = new LinkedHashSet<Integer>();
			List<Journal> journalList = new ArrayList<Journal>();
			List<DepartmentsTask> daptTask = new LinkedList<DepartmentsTask>();
			List<Integer> jr = new ArrayList<>();

			daptTask.addAll(taskManagementService.getAllTaskAndALLJournalByDept(users.getUserID()));

			for (DepartmentsTask desk : daptTask) {
				jr.add(desk.getJournalId());
			}
			set.addAll(jr); // Clear the list
			jr.clear(); // add the elements of set // with no duplicates to the list
			jr.addAll(set);// return the list
			for (Integer jid : jr) {
				journalList.add(journalService.getjournalbyId(jid));
			}

			List<TaskManagementVo> taskManagement = taskManagementService.getmyTaskManagementList(users.getUserID());
			model.put("taskScheduler", taskManagement);
			List<TaskScheduler> taskSchedulerDue = taskService.getOverDueTaskList(users.getUserID());
			model.put("taskSchedulerDue", taskSchedulerDue);
			model.put("journalList", journalList);
			List<IssueTaskManagementVo> issuetaskManagementVo = issueDetailService
					.getIssueTaskManagementList(users.getUserID());
			model.put("issueScheduler", issuetaskManagementVo);
			model.put("departmentsTask", daptTask);
			List<ProductivityTaskVo> productivityTaskVo = taskService.getproductivityTaskCount(users.getUserID());
			model.put("productivityTask", productivityTaskVo);

			model.addAttribute("css", css);
			model.addAttribute("message", message);
			LOGGER.info("------------->productionDashboard <-------------------");
			return new ModelAndView("/productionDashboard");
		}
		List<TaskDetails> taskDetails = taskService.getAlltaskList();
		model.put("taskDetails", taskDetails);
		List<IssueTaskManagementVo> issuetaskManagementVo = issueDetailService
				.getIssueTaskManagementList(users.getUserID());
		model.put("issueScheduler", issuetaskManagementVo);
		List<TaskManagementVo> taskManagementVo = taskManagementService.getmyTaskManagementList(users.getUserID());
		model.put("taskScheduler", taskManagementVo);// done
		List<TaskManagementVo> taskManagementVoc = new ArrayList<TaskManagementVo>();
		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
		// int dptId = users.getGroup1().get(0).getDeptID();
//		for (Department dept : users.getGroup1()) {
////			 mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept.getDeptID()));
//		}
//		
		for (ManageJournalWorkflow manageJourWk : mjw) {
			taskManagementVoc.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
					manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
		}

//		System.out.println(mjw.toString());
		model.put("taskManagementVoc", taskManagementVoc);
//		List<TaskManagementVo> taskManagementVoc = taskManagementService.getTaskManagementGroupList(users.getUserID());
		// model.put("taskManagementVoc", taskManagementVoc);
//		----
		List<TaskScheduler> taskSchedulerDue = taskService.getOverDueTaskList(users.getUserID());
		model.put("taskSchedulerDue", taskSchedulerDue);// done

		List<ProductivityTaskVo> productivityTaskVo = taskService.getproductivityTaskCount(users.getUserID());
		model.put("productivityTask", productivityTaskVo);
		LOGGER.info("------------->dashboard <-------------------");
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		return new ModelAndView("/dashboard");
	}

	@GetMapping("/articalDeatilsList")
	public ModelAndView articalDeatilsList(ModelMap model) {

		List<ArticleDetail> ArticleDetail = articleService.getallList();
		model.put("ArticleDetail", ArticleDetail);
		return new ModelAndView("ArticleDetail");

	}

	@PostMapping("getjournalsTask")
	public ResponseEntity<ApplicationResponse> getArticleInPool(@RequestBody ManageJournalWorkflow mjwv) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		Users users = userService.findUserIdByUserName(name);
		LOGGER.info("----ajax call------>getjournalsTask<--------------");
		List<DepartmentsTask> daptjournalTask = taskManagementService.getAllTaskAndALLJournalByDept(users.getUserID(),
				mjwv.getJournal_id());
		// System.out.println("daptjournalTask ::"+daptjournalTask);
		List<TaskManagementVo> mytaskList = taskManagementService.getmyTaskManagementList(users.getUserID(),
				mjwv.getJournal_id());

		// System.out.println("mytask :"+mytaskList.toString());
		applicatonResponse.setPayload(daptjournalTask);
		applicatonResponse.setPayloadNext(mytaskList);
		applicatonResponse.setMessage("OK");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}
}
