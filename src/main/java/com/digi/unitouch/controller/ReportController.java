package com.digi.unitouch.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.IssueArticle;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.IssueArticleService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.MenuService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.util.DateApi;
import com.digi.unitouch.util.ExcelDataUtils;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.util.MasterDetailsExcelUtils;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.ArticlePlanner;
import com.digi.unitouch.vo.ArticleTaskDetailsVO;
import com.digi.unitouch.vo.AvilabelLode;
import com.digi.unitouch.vo.IssueTaskManagementVo;
import com.digi.unitouch.vo.LoadReportForcast;
import com.digi.unitouch.vo.ProductivityTaskVo;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.TaskTime;
import com.digi.unitouch.vo.TotelLode;

@Controller
public class ReportController extends LoggerClass {

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
	RoleService roleService;
	@Autowired
	IssueDetailService issueDetailService;
//	@Autowired
//	ArticleTaskDetailService articleTaskDetailService;
	@Autowired
	IssueArticleService issueArticleService;

	@RequestMapping(value = { "/viewcloud" })
	public ModelAndView viewviewcloud(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/dashboardcloud");
	}

	@RequestMapping(value = { "/viewrecord" })
	public ModelAndView viewRecord(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/record");
	}

	@RequestMapping(value = { "/viewauthorrecord" })
	public ModelAndView viewAuthorRecord(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/AuthorRecord");
	}

	@RequestMapping(value = { "/SupplierPending" })
	public ModelAndView viewSupplierPending(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/SupplierPending");
	}

	@RequestMapping(value = { "/ArticalDeliverystatus" })
	public ModelAndView viewArticalDeliverystatus(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/Deliverystatuswithduedate");
	}

	@RequestMapping(value = { "/JournalDeliveryTrend" })
	public ModelAndView viewJournalDeliveryTrend(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/JournalDeliveryTrend");
	}

	@RequestMapping(value = { "/JournalCurrentLoadandOverdue" })
	public ModelAndView viewJournalCurrentLoadandOverdue(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/JournalCurrentLoadandOverdue");
	}

	@RequestMapping(value = { "/OtherJournalDeliveryTrend" })
	public ModelAndView viewOtherJournalDeliveryTrend(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/OtherJournalDeliveryTrend");
	}

	@RequestMapping(value = { "/OtherJournalCurrentLoadandOverdue" })
	public ModelAndView viewOtherJournalCurrentLoadandOverdue(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/OtherJournalCurrentLoadandOverdue");
	}

	@RequestMapping(value = { "/LoadJournalwiseProofInPreparation" })
	public ModelAndView viewLoadJournalwiseProofInPreparation(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("/LoadJournalwiseProofInPreparation");
	}

	@GetMapping("/journalwiseload")
	public ModelAndView journalWiseList(ModelMap model) {

		return new ModelAndView("journalwiseload");

	}

	@GetMapping("/journalwiseproofbeingcorrected")
	public ModelAndView journalwiseproof(ModelMap model) {

		return new ModelAndView("journalwiseProofBeing");

	}

	@GetMapping("/journalwisedataset")
	public ModelAndView journalwisedate(ModelMap model) {

		return new ModelAndView("journalwisedataset");

	}

	@GetMapping("/aritlcerejections")
	public ModelAndView aritlcerejections(ModelMap model) {

		return new ModelAndView("articlerejections");

	}

	@RequestMapping(value = { "/loadforcastreport" })
	public ModelAndView loadForcastReportAccordingTojournal(ModelMap model, HttpServletRequest request) {

		List<LoadReportForcast> loadforcastReport = articleService.getloadforcastreport();

		LOGGER.debug("Load Forcast Report" + loadforcastReport);
		model.put("loadforcastReport", loadforcastReport);

		return new ModelAndView("/loadfrocastreport");
	}

	@RequestMapping(value = { "/articleplanner" })
	public ModelAndView articleplanner(ModelMap model, HttpServletRequest request) {

		List<ArticlePlanner> articleplanner = articleService.getarticlePlannerDetails();

		LOGGER.debug("Ldvfb Forcast Report" + articleplanner);
		model.put("articleplanner", articleplanner);

		return new ModelAndView("/articleplanner");
	}

	@RequestMapping(value = { "/avilloade" })
	public ModelAndView avilabelLoad(ModelMap model, HttpServletRequest request) {

		int deptId = 2;
		List<AvilabelLode> avilabelLoad = articleService.getTotalLode();
		model.put("avilabelLoad", avilabelLoad);
		List<TotelLode> totelLoad = articleService.getavilabelLode();
		model.put("totelLoad", totelLoad);
		// List<Department> deptDetails = deptService.getDepartmentsList();
		List<Role> deptDetails = roleService.getRoleList();
		model.put("deptDetails", deptDetails);
		model.put("depNmae", deptDetails.get(0).getRoleName());
		LOGGER.debug("group name : " + deptDetails.get(0).getRoleName());
		return new ModelAndView("/avilabeLode");
	}

	@RequestMapping(value = { "/viewLoadRecordDepartmrntWise" })
	public ModelAndView dashboard(ModelMap model, HttpServletRequest request) {

		int deptId = 2;
		List<AvilabelLode> avilabelLoad = articleService.getTotalLodebyDeptId(deptId);
		model.put("avilabelLoad", avilabelLoad);
		List<TotelLode> totelLoad = articleService.getavilabelLodebyDeptId(deptId);
		model.put("totelLoad", totelLoad);
		List<Department> deptDetails = deptService.getDepartmentsList();
		model.put("deptDetails", deptDetails);
		model.put("depNmae", deptDetails.get(0).getGroupName());
		LOGGER.debug("group name : " + deptDetails.get(0).getGroupName());
		return new ModelAndView("/avilabeLode");

	}

	@GetMapping("/totalArticleByuser")
	public String totalArticleByuser(ModelMap model, HttpServletRequest request) {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<TaskManagementVo> taskManagementVoList = null;
		// taskManagementVoList =
		// taskManagementService.getmyTaskManagementTotalList(users.getUserID());
		taskManagementVoList = taskManagementService.getmyTaskManagementList(users.getUserID());
		System.out.println(taskManagementVoList.toString());
		System.out.println("Articles :" + taskManagementVoList.size());

		List<IssueTaskManagementVo> taskManagementVo = issueDetailService.getIssueTaskManagementList(users.getUserID());
		System.out.println("Issues :" + taskManagementVo.size());

		Integer TotalPage = null;
		for (int i = 0; i < taskManagementVoList.size(); i++) {
			Integer journalID = taskManagementVoList.get(i).getJournalId();
			Integer articalId = taskManagementVoList.get(i).getArticle_id();

			List<ArticleDetail> list = articleService.getArticleListbyJrIdPage(journalID, articalId);
			Integer page = null;
			for (int j = 0; j < list.size(); j++) {
				if (page == null) {
					page = list.get(j).getArticle_pages();
				} else {
					page = page + list.get(j).getArticle_pages();
				}
			}
			if (TotalPage == null) {
				TotalPage = page;
			} else {
				try {
					TotalPage = TotalPage + page;
				} catch (NullPointerException e) {
					System.out.print("NullPointerException Caught");
				}
			}
		}
		System.out.println("TotalPage : " + TotalPage);
		model.put("totalArticle", taskManagementVoList.size());
		model.put("totalPage", TotalPage);
		model.put("totalIssue", taskManagementVo.size());
		List<ProductivityTaskVo> productivityTaskVo = taskService.getproductivityTaskCount(users.getUserID());
		model.put("productivityTask", productivityTaskVo);
		// model.put("totalpages", TotalPage);
		return "articlePageIssueUser";
	}

	@GetMapping("/totalArticleByAdmin")
	public ModelAndView totalArticleByuserAdmin(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		List<Role> roleDetails = roleService.getRoleList();
		model.addAttribute("roleDetails", roleDetails);
		List<ArticleDetail> taskManagementVoList = articleService.getallList();
		model.put("ArticleDetail", taskManagementVoList.size());
		System.out.println("ArticleDetail :" + taskManagementVoList.size());

		List<IssueDetail> issuetaskDetails = issueDetailService.getAllList();
		System.out.println("Issues :" + issuetaskDetails.size());

		Integer TotalPage = null;
		Integer Totalnoms = null;
		
		for (int i = 0; i < taskManagementVoList.size(); i++) {
			Integer journalID = taskManagementVoList.get(i).getJournalId();
			Integer articalId = taskManagementVoList.get(i).getArticle_id();

			List<ArticleDetail> list = articleService.getArticleListbyJrIdPage(journalID, articalId);
			Integer page = null;
			Integer noms = null;
			for (int j = 0; j < list.size(); j++) {
				if (page == null) {
					page = list.get(j).getArticle_pages();
					noms=Integer.parseInt(list.get(j).getSubjectnoms());
				} else {
					page = page + list.get(j).getArticle_pages();
					noms=Integer.parseInt(list.get(j).getSubjectnoms());
				}
			}
			if (TotalPage == null) {
				TotalPage = page;
				Totalnoms=noms;
			} else {
				try {
					TotalPage = TotalPage + page;
					Totalnoms=Totalnoms+noms;
				} catch (NullPointerException e) {
					System.out.println("NullPointerException Caught");
				}
			}
		}
		System.out.println("TotalPage " + TotalPage);
		// model.put("totalpages", TotalPage);
		model.put("totalArticle", taskManagementVoList.size());
		model.put("totalPage", TotalPage);
		
		model.put("totalIssue", Totalnoms);
		List<ProductivityTaskVo> productivityTaskVo = taskService.getproductivityTaskCount();
		model.put("productivityTask", productivityTaskVo);
		List<ArticleDetail> statusRejectCount = articleService.getTotalcountRejected();
		System.out.println("statusRejectCount ArticleDetail:->" + statusRejectCount.size());
		model.put("statusRejectCount", statusRejectCount.size());
		return new ModelAndView("totalArticleByAdmin");
	}

	@GetMapping("/WipUserAdmin")
	public void WipUserAdmin(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

//		List<ArticleDetail> taskManagementVoList = articleService.getallList();
//		model.put("ArticleDetail", taskManagementVoList.size());
//
//		try {
//			ExcelDataUtils.downloadExcelAdmin(response, taskManagementVoList);
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
		try {
			List<ArticleDetailsVO> taskManagementVoList = articleService.getarticleDetail();
			List<ArticleDetailsVO> taskManagementVoli = new ArrayList<>();
			// List<ArticleDetail> taskManagementVoList = articleService.getallList();

			for (ArticleDetailsVO data : taskManagementVoList) {

				ArticleDetailsVO vo = new ArticleDetailsVO();
				int diffDays = 0;
				List<TaskScheduler> ts = taskService.getAricleIDORTaskID(data.getArticle_id());
				System.out.println(ts.toString());
				if (ts != null) {
					Date startdate = ts.get(0).getSch_start_time();
					Date Currentdate = new Date();

					long diff = Currentdate.getTime() - startdate.getTime();
					diffDays = (int) (diff / (24 * 60 * 60 * 1000));
					System.out.println("difference between days: " + diffDays);

				}
				vo.setAid(data.getAid());
				vo.setJournalName(data.getJournalName());
				vo.setArticle_title(data.getArticle_title());
				vo.setArticle_type_cd(data.getArticle_type_cd());
				vo.setAccepted_date(data.getAccepted_date());
				vo.setArticle_doi(data.getArticle_doi());
				vo.setTaskName(data.getTaskName());
				vo.setAge(diffDays);
				vo.setReportsDate(DateApi.getCurrentIndianTime());

				taskManagementVoli.add(vo);
			}
			model.put("ArticleDetail", taskManagementVoli.size());
			ExcelDataUtils.downloadExcelAdmin(response, taskManagementVoli);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException Caught");
		}

	}

	@GetMapping("/WipUserWise")
	public void WipUserWise(ModelMap model, HttpServletRequest request, HttpServletResponse response, Users users) {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users usersList = userService.findUserIdByUserName(name);
		List<TaskManagementVo> taskManagementVoList = null;
		System.out.println(users.toString());
		if (users.getUserID() != null) {
			taskManagementVoList = taskManagementService.getmyTaskManagementList(users.getUserID());
		} else {
			taskManagementVoList = taskManagementService.getmyTaskManagementList(usersList.getUserID());
		}
		// taskManagementVoList =
		// taskManagementService.getmyTaskManagementTotalList(users.getUserID());
		model.put("ArticleDetail", taskManagementVoList.size());

		try {
			ExcelDataUtils.downloadExcelUser(response, taskManagementVoList);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@RequestMapping(value = "/totalArticleByuserExcel", method = RequestMethod.POST)
	public void totalArticleByuserExcel(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// String ID = request.getParameter("user_id");
		// int Userid = Integer.parseInt(ID);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		int Userid = users.getUserID();
		List<TaskManagementVo> taskManagementVoList = taskManagementService.getmyTaskManagementTotalList(Userid);
		System.out.println("Articles :" + taskManagementVoList.size());

		List<IssueTaskManagementVo> issuetaskDetails = issueDetailService.getIssueTaskManagementList(Userid);
		System.out.println("Issues :" + issuetaskDetails.size());

		Integer TotalPage = null;
		for (int i = 0; i < taskManagementVoList.size(); i++) {
			Integer journalID = taskManagementVoList.get(i).getJournalId();
			Integer articalId = taskManagementVoList.get(i).getArticle_id();

			List<ArticleDetail> list = articleService.getArticleListbyJrIdPage(journalID, articalId);
			Integer page = null;
			for (int j = 0; j < list.size(); j++) {
				if (page == null) {
					page = list.get(j).getArticle_pages();
				} else {
					page = page + list.get(j).getArticle_pages();
				}
			}
			if (TotalPage == null) {
				TotalPage = page;
			} else {
				try {
					TotalPage = TotalPage + page;
				} catch (NullPointerException e) {
					System.out.println("NullPointerException Caught");
				}
			}
		}
		System.out.println(" " + TotalPage);
		// model.put("totalpages", TotalPage);
		Integer TPage = TotalPage;
		Integer ArticleCount = taskManagementVoList.size();
		Integer IssueCount = issuetaskDetails.size();

		ExcelDataUtils.downloadTotalCountExcelAdmin(response, ArticleCount, IssueCount, TPage);

	}

	@RequestMapping(value = "/totalArticleByuserAdminExcel", method = RequestMethod.POST)
	public void totalArticleByuserAdminExcel(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		List<ArticleDetail> taskManagementVoList = articleService.getallList();
		model.put("ArticleDetail", taskManagementVoList.size());
		System.out.println("ArticleDetail :" + taskManagementVoList.size());

		List<IssueDetail> issuetaskDetails = issueDetailService.getAllList();
		System.out.println("Issues :" + issuetaskDetails.size());

		Integer TotalPage = null;
		for (int i = 0; i < taskManagementVoList.size(); i++) {
			Integer journalID = taskManagementVoList.get(i).getJournalId();
			Integer articalId = taskManagementVoList.get(i).getArticle_id();

			List<ArticleDetail> list = articleService.getArticleListbyJrIdPage(journalID, articalId);
			Integer page = null;
			for (int j = 0; j < list.size(); j++) {
				if (page == null) {
					page = list.get(j).getArticle_pages();
				} else {
					page = page + list.get(j).getArticle_pages();
				}
			}
			if (TotalPage == null) {
				TotalPage = page;
			} else {
				try {
					TotalPage = TotalPage + page;
				} catch (NullPointerException e) {
					System.out.println("NullPointerException Caught");
				}
			}
		}
		System.out.println(" " + TotalPage);
		// model.put("totalpages", TotalPage);
		Integer TPage = TotalPage;
		Integer ArticleCount = taskManagementVoList.size();
		Integer IssueCount = issuetaskDetails.size();

		ExcelDataUtils.downloadTotalCountExcelAdmin(response, ArticleCount, IssueCount, TPage);

	}
//
//	@GetMapping("articleRejectedCount")
//	public ModelAndView statusByArticleRejectedCount(ModelMap model, HttpServletRequest request ) {
//
//        List<ArticleDetail> statusRejectCount = articleService.getTotalcountRejected();
//        System.out.println("statusRejectCount ArticleDetail:-"+statusRejectCount.size());
//		model.put("statusRejectCount", statusRejectCount);
//		
//		return new ModelAndView("");
//		
//	}

	@GetMapping("/articleRejected")
	public void articleRejected(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		List<ArticleDetail> statusRejectCount = articleService.getTotalcountRejected();
		System.out.println("statusRejectCount ArticleDetail:-" + statusRejectCount.size());
		model.put("statusRejectCount", statusRejectCount);

		try {
			ExcelDataUtils.downloadExcelRejected(response, statusRejectCount);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	// MasterReports report

	@GetMapping("/masterReports")
	public void MasterReports(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, ParseException {

		try {
			List<ArticleTaskDetailsVO> taskManagementVoList = articleService.getarticleMastereDetail();
			List<TaskScheduler> articlecompleteDetail = articleService.getAllLastMaxArticleDetail();
			List<ArticleTaskDetailsVO> taskManagementVoli = new ArrayList<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			List<String> s = new ArrayList<String>();
			List<String> s1 = new ArrayList<String>();
			List<Integer> articleid = new ArrayList<Integer>();
			for (int j = 0; j < articlecompleteDetail.size(); j++) {
				articleid.add(articlecompleteDetail.get(j).getArticle_id());
			}
			for (ArticleTaskDetailsVO data : taskManagementVoList) {
				// for(TaskScheduler ts1 :articlecompleteDetail) {
				ArticleTaskDetailsVO vo = new ArticleTaskDetailsVO();
				// if(data.getArticle_id() != ts1.getArticle_id()) {

				List<TaskScheduler> ts = taskService.getAricleIDORTaskID(data.getArticle_id());
		//		System.out.println(ts.toString());
				List<String> taskName = new ArrayList<String>();
				Set<TaskTime> taskTime = new HashSet<TaskTime>();
				LinkedHashMap<String, TaskTime> taskMap1 = new LinkedHashMap<String, TaskTime>();
				if (ts != null) {
					for (int i = 0; i < ts.size(); i++) {
						s.add(dateFormat.format(ts.get(i).getSch_start_time()));
						s1.add(dateFormat.format(ts.get(i).getSch_end_time()));

						int diffDays;
						Date startdate = ts.get(0).getSch_start_time();
						Date Currentdate = new Date();

						long diff = Currentdate.getTime() - startdate.getTime();
						diffDays = (int) (diff / (24 * 60 * 60 * 1000));
						//System.out.println("difference between days: " + diffDays);
						vo.setCurrentPhaseDate(dateFormat.format(ts.get(0).getTask_assigned_date()));
						vo.setDuePhaseDate(dateFormat.format(ts.get(0).getTask_due_date()));
						vo.setAge(diffDays);
						TaskTime tn = new TaskTime();
						taskName.add(ts.get(i).getTask().getTaskName());
						tn.setStartTime(ts.get(i).getTask_est_time_from());
						
						if (ts.get(i).getTask_est_time_end() != null) {
						tn.setEndTime(ts.get(i).getTask_est_time_end());}
						else {
							tn.setEndTime("");
						}
						tn.setTaskName(ts.get(i).getTask().getTaskName());
						taskTime.add(tn);
						taskMap1.put(ts.get(i).getTask().getTaskName(), tn);
					}
					vo.setTaskArray(taskName);
					vo.setTaskMap(taskMap1);
					List<IssueArticle> issue = issueArticleService.getIssueByarticleID(data.getArticle_id());
					if (issue != null && !issue.isEmpty()) {
						vo.setIssue("Assigned");
					} else {
						vo.setIssue("Unassigned");
					}
					vo.setAid(data.getAid());
					vo.setJournalName(data.getJournalName());
					vo.setJournalAbbrName(data.getJournalAbbrName());
					vo.setArticle_title(data.getArticle_title());
					vo.setArticle_type_cd(data.getArticle_type_cd());
					vo.setAccepted_date(data.getAccepted_date());
					vo.setArticle_doi(data.getArticle_doi());
					vo.setTaskName(data.getTaskName());
					vo.setUserName(data.getFirstname() + " " + data.getLastname());
					if (data.getNoOfPages() == null) {
						vo.setNoOfPages(0);
					} else {
						vo.setNoOfPages(data.getNoOfPages());
					}
					vo.setUseremail(data.getUseremail());
					vo.setReportsDate(dateFormat.format(new Date()));

					taskManagementVoli.add(vo);

				}
			}

			model.put("masterReport", taskManagementVoli.size());
			MasterDetailsExcelUtils.downloadMasterReports(response, taskManagementVoli);

		} catch (NullPointerException e) {
			LOGGER.info("Null pointer"+e);
			e.printStackTrace();
			System.out.println("NullPointerException Caught");
		}
	}


}
