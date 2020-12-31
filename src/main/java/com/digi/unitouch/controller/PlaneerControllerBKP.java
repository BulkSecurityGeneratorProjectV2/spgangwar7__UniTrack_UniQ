//package com.digi.unitouch.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.digi.unitouch.model.Department;
//import com.digi.unitouch.model.ManageJournalWorkflow;
//import com.digi.unitouch.model.Role;
//import com.digi.unitouch.model.TaskScheduler;
//import com.digi.unitouch.service.ArticleService;
//import com.digi.unitouch.service.DepartmentService;
//import com.digi.unitouch.service.ManageJournalworkflowService;
//import com.digi.unitouch.service.RoleService;
//import com.digi.unitouch.service.TaskManagementService;
//import com.digi.unitouch.service.TaskService;
//import com.digi.unitouch.util.LoggerClass;
//import com.digi.unitouch.vo.ArticleDetailplannerVo;
//import com.digi.unitouch.vo.PlannerVo;
//import com.digi.unitouch.vo.TaskManagementVo;
//import com.digi.unitouch.vo.userDepartmentVo;
//
//@Controller
//public class PlaneerControllerBKP extends LoggerClass{
//	
//	@Autowired
//	ArticleService articleService;
//	@Autowired
//	TaskService taskService;
//	@Autowired
//	DepartmentService departmentService;
//	@Autowired
//	DepartmentService deptService;
//	@Autowired
//	ManageJournalworkflowService manageJournalworkflowService;
//	@Autowired
//	TaskManagementService taskManagementService;
//	@Autowired
//	RoleService roleService;
//	
//	@GetMapping("/planner")
//	public ModelAndView articalDeatilsList(ModelMap model) {
//
//		int taskId =1611;
//		List<TaskScheduler> taskSchedulerpendingall = taskService.gettaskSchedulerpendingall();
//		model.put("taskSchedulerpendingall", taskSchedulerpendingall);
//		List<TaskScheduler> taskSchedulerpendingToday = taskService.gettaskSchedulerpendingToday();
//		model.put("taskSchedulerpendingToday", taskSchedulerpendingToday);
//		List<TaskScheduler> totalarticleavailable = taskService.gettotalarticleavailable();
//		System.out.println(totalarticleavailable.toString());
//		model.put("totalarticleavailable", totalarticleavailable);
//		List<PlannerVo> totalarticleavailableGraph = taskService.gettotalarticleavailableGraph(taskId);
//		model.put("totalarticleavailableGraph", totalarticleavailableGraph);
//		List<TaskScheduler> totalarticleavailableToday = taskService.gettotalarticleavailableToday();
//		model.put("totalarticleavailableToday", totalarticleavailableToday);
//		List<TaskScheduler> totalarticleavailablepast24 = taskService.gettotalarticleavailablepast24();
//		model.put("totalarticleavailablepast24", totalarticleavailablepast24);
//		model.put("totalarticleavailable24", totalarticleavailablepast24.size());
//		LOGGER.debug(totalarticleavailablepast24.size()+": :"+totalarticleavailablepast24);
//		List<TaskScheduler> totalarticleavailablepast48 = taskService.gettotalarticleavailablepast48();
//		model.put("totalarticleavailablepast48", totalarticleavailablepast48);
//		model.put("totalarticleavailable48", totalarticleavailablepast48.size());
//		LOGGER.debug("totalarticleavailablepast48 : "+totalarticleavailablepast48.size());
//		List<TaskScheduler> totalarticleavailablepastdate = taskService.gettotalarticleavailablepastdate();
//		model.put("totalarticleavailablepastdate", totalarticleavailablepastdate);
//		model.put("totalarticleavailablepast", totalarticleavailablepastdate.size());
//		
//		LOGGER.debug("totalarticleavailablepastdate : "+totalarticleavailablepastdate.size());
//		return new ModelAndView("Planeerdashboard");
//		
//	}
//	
//	@GetMapping("/plannerSuplierUserWise")
//	public ModelAndView articalDeatilsListDepartmentUser(ModelMap model) {
//
//		List<Role> roleDetails = roleService.getRoleList();
//		model.addAttribute("roleDetails", roleDetails);
//	    
//		List<Department> deptDetails = deptService.getDepartmentsList();
//		model.addAttribute("deptDetails", deptDetails);
//		
//		return new ModelAndView("plannerDeptUserDashboard");
//		
//	}
////	
////	@GetMapping("/plannerSuplierUserWise")
////	public ModelAndView articalDeatilsListDepartmentUser(ModelMap model) {
////
////		List<Department> deptDetails = deptService.getDepartmentsList();
////		model.addAttribute("deptDetails", deptDetails);
////		
////		return new ModelAndView("plannerDeptUserDashboard");
////		
////	}
////	
//
//	
//	@PostMapping("/viewplannerSuplierUserWise")
//	
//	
//public ModelAndView findPlannerDepartmentByUserIds(HttpServletRequest request,ModelMap model) {
//		
//		String userId  = request.getParameter("userid");
//		String roleId=request.getParameter("roleID");
//	    int role = Integer.parseInt(roleId);
//	    int uid = Integer.parseInt(userId);
//		    
//	    
//		LOGGER.debug(roleId+"  :: "+userId);
//        
//		
//		List<PlannerVo> totalarticleavailableGraph = taskService.gettotalarticleavailableGraphBYdeptandUser(role,uid);
//		model.put("totalarticleavailableGraph", totalarticleavailableGraph);
//		
//		List<TaskScheduler> taskSchedulerpendingall = taskService.gettaskSchedulerpendingallBYdeptandUser(role,uid);
//		model.put("taskSchedulerpendingall", taskSchedulerpendingall);
//    	List<TaskScheduler> taskSchedulerpendingToday = taskService.gettaskSchedulerpendingTodayBYdeptandUser(role,uid);
// 		model.put("taskSchedulerpendingToday", taskSchedulerpendingToday);
//			
// 		List<TaskScheduler> totalarticleavailableToday = taskService.gettotalarticleavailableTodayBydeptandUser(role,uid);
//		model.put("totalarticleavailableToday", totalarticleavailableToday);
//		List<TaskScheduler> totalarticleavailablepast24 = taskService.gettotalarticleavailablepast24BYdeptandUser(role,uid);
//		model.put("totalarticleavailablepast24", totalarticleavailablepast24);
//		model.put("totalarticleavailable24", totalarticleavailablepast24.size());
//		LOGGER.debug(totalarticleavailablepast24.size()+": :"+totalarticleavailablepast24);
//		List<TaskScheduler> totalarticleavailablepast48 = taskService.gettotalarticleavailablepast48BYdeptandUser(role,uid);;
//		model.put("totalarticleavailablepast48", totalarticleavailablepast48);
//		model.put("totalarticleavailable48", totalarticleavailablepast48.size());
//		LOGGER.debug("totalarticleavailablepast48 : "+totalarticleavailablepast48.size());
//		List<TaskScheduler> totalarticleavailablepastdate = taskService.gettotalarticleavailablepastdateBYdeptandUser(role,uid);;
//		model.put("totalarticleavailablepastdate", totalarticleavailablepastdate);
//		model.put("totalarticleavailablepast", totalarticleavailablepastdate.size());
//		
//		LOGGER.debug("totalarticleavailablepastdate : "+totalarticleavailablepastdate.size());
//	
//		
//		//String message = deptService.saveDepartmentHead(departmentHead);
//		//responseVo.setResponseText(message);
//		return new ModelAndView("plannerSuplierUserWisefinal");
//	}
////	
////	public ModelAndView findPlannerDepartmentByUserIds(HttpServletRequest request,ModelMap model) {
////		//LOGGER.debug("sdfgnjdfl :"+departmentHead.toString());
////		//int taskId =1611;
////		
////		/*
////		 * TaskScheduler findtaskId = taskService.gettaskIdbyJournal(); int task=
////		 * findtaskId.getTask_id(); LOGGER.debug("task is is "+task);
////		 */
////		
////		String userId  = request.getParameter("userid");
////		String deptId=request.getParameter("deptID");
////	    int dept = Integer.parseInt(deptId);
////	    int uid = Integer.parseInt(userId);
////		    
////	    
////		LOGGER.debug(deptId+"  :: "+userId);
////        
////		
////		List<PlannerVo> totalarticleavailableGraph = taskService.gettotalarticleavailableGraphBYdeptandUser(dept,uid);
////		model.put("totalarticleavailableGraph", totalarticleavailableGraph);
////		
////		List<TaskScheduler> taskSchedulerpendingall = taskService.gettaskSchedulerpendingallBYdeptandUser(dept,uid);
////		model.put("taskSchedulerpendingall", taskSchedulerpendingall);
////    	List<TaskScheduler> taskSchedulerpendingToday = taskService.gettaskSchedulerpendingTodayBYdeptandUser(dept,uid);
//// 		model.put("taskSchedulerpendingToday", taskSchedulerpendingToday);
////			
//// 		List<TaskScheduler> totalarticleavailableToday = taskService.gettotalarticleavailableTodayBydeptandUser(dept,uid);
////		model.put("totalarticleavailableToday", totalarticleavailableToday);
////		List<TaskScheduler> totalarticleavailablepast24 = taskService.gettotalarticleavailablepast24BYdeptandUser(dept,uid);
////		model.put("totalarticleavailablepast24", totalarticleavailablepast24);
////		model.put("totalarticleavailable24", totalarticleavailablepast24.size());
////		LOGGER.debug(totalarticleavailablepast24.size()+": :"+totalarticleavailablepast24);
////		List<TaskScheduler> totalarticleavailablepast48 = taskService.gettotalarticleavailablepast48BYdeptandUser(dept,uid);;
////		model.put("totalarticleavailablepast48", totalarticleavailablepast48);
////		model.put("totalarticleavailable48", totalarticleavailablepast48.size());
////		LOGGER.debug("totalarticleavailablepast48 : "+totalarticleavailablepast48.size());
////		List<TaskScheduler> totalarticleavailablepastdate = taskService.gettotalarticleavailablepastdateBYdeptandUser(dept,uid);;
////		model.put("totalarticleavailablepastdate", totalarticleavailablepastdate);
////		model.put("totalarticleavailablepast", totalarticleavailablepastdate.size());
////		
////		LOGGER.debug("totalarticleavailablepastdate : "+totalarticleavailablepastdate.size());
////	
////		
////		//String message = deptService.saveDepartmentHead(departmentHead);
////		//responseVo.setResponseText(message);
////		return new ModelAndView("plannerSuplierUserWisefinal");
////	}
//	
//	@GetMapping("/plannerSuplierWiseRecord")
//	public ModelAndView articalDeatilsListDepartmentwise(ModelMap model) {
//
//		List<Department> deptDetails = deptService.getDepartmentsList();
//		model.addAttribute("deptDetails", deptDetails);
//		
//		return new ModelAndView("plannerDeptWiseRec");
//		
//	}
//	
//	
//
//	//change on this controller
//	@PostMapping("/viewplannerSuplierWise")
//	public ModelAndView findPlannerDepartment(HttpServletRequest request,ModelMap model) {
//	
//		String deptId = request.getParameter("deptID");
//		int dept = Integer.parseInt(deptId);
//
//		List<TaskManagementVo> taskManagementVo = new ArrayList<TaskManagementVo>();
//		List<ManageJournalWorkflow> mjw = new ArrayList<ManageJournalWorkflow>();
//	//	mjw.addAll(manageJournalworkflowService.getManageJournalByDptId(dept));
//		for (ManageJournalWorkflow manageJourWk : mjw) {
//			taskManagementVo.addAll(taskManagementService.getTaskManagementGroupList(manageJourWk.getWorkflow_id(),
//					manageJourWk.getJournal_id(), manageJourWk.getTask_id()));
//		}
//		System.out.println(mjw.toString());
//		List<TaskScheduler> totalarticleavailable =null;
//		model.put("taskManagementVo", taskManagementVo);
//		int i=0;
////	    for (TaskManagementVo manageJournalWorkflow : taskManagementVo) {
////	    	totalarticleavailable.
////			
////		}
////		  List<TaskScheduler> totalarticleavailable =
//	//	  taskService.gettotalarticleavailable();
//		//  System.out.println(totalarticleavailable.toString());
//		  model.put("totalarticleavailable", totalarticleavailable);
//		 
//	    List<PlannerVo> totalarticleavailableGraph = taskService.gettotalarticleavailableGraphBYdeptartment(dept);
//		model.put("totalarticleavailableGraph", totalarticleavailableGraph);
//		List<TaskScheduler> taskSchedulerpendingall = taskService.gettaskSchedulerpendingallBYdept(dept);
//		model.put("taskSchedulerpendingall", taskSchedulerpendingall);
//    	List<TaskScheduler> taskSchedulerpendingToday = taskService.gettaskSchedulerpendingTodayBYdept(dept);
// 		model.put("taskSchedulerpendingToday", taskSchedulerpendingToday);
//			
// 		List<TaskScheduler> totalarticleavailableToday = taskService.gettotalarticleavailableTodayBydept(dept);
//		model.put("totalarticleavailableToday", totalarticleavailableToday);
//		List<TaskScheduler> totalarticleavailablepast24 = taskService.gettotalarticleavailablepast24BYdept(dept);
//		model.put("totalarticleavailablepast24", totalarticleavailablepast24);
//		model.put("totalarticleavailable24", totalarticleavailablepast24.size());
//		LOGGER.debug(totalarticleavailablepast24.size()+": :"+totalarticleavailablepast24);
//		List<TaskScheduler> totalarticleavailablepast48 = taskService.gettotalarticleavailablepast48BYdept(dept);;
//		model.put("totalarticleavailablepast48", totalarticleavailablepast48);
//		model.put("totalarticleavailable48", totalarticleavailablepast48.size());
//		LOGGER.debug("totalarticleavailablepast48 : "+totalarticleavailablepast48.size());
//		List<TaskScheduler> totalarticleavailablepastdate = taskService.gettotalarticleavailablepastdateBYdept(dept);;
//		model.put("totalarticleavailablepastdate", totalarticleavailablepastdate);
//		model.put("totalarticleavailablepast", totalarticleavailablepastdate.size());
//		
//		LOGGER.debug("totalarticleavailablepastdate : "+totalarticleavailablepastdate.size());
//
//		return new ModelAndView("plannerSuplierUserWisefinal");
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	@GetMapping("/plannerDept")
//	public ModelAndView articalplannerDept(ModelMap model) {
//		
//		List<ArticleDetailplannerVo> totalarticleOnDept = articleService.getalldetailsplaneer();
//		model.put("totalarticleOnDept", totalarticleOnDept);
//		model.put("totalarticlDept", totalarticleOnDept.size());
//		LOGGER.debug("totalarticleOnDept : "+totalarticleOnDept.size());
//		
//		List<ArticleDetailplannerVo> totalarticleOnDeptToday = articleService.getarticlegroupby();
//		model.put("totalarticleOnDeptToday", totalarticleOnDeptToday);
//		model.put("totalarticleDeptToday", totalarticleOnDeptToday.size());
//		List<ArticleDetailplannerVo> totalarticleOnDeptVirtual = articleService.gettotalarticleOnDeptVirtual();
//		model.put("totalarticleOnDeptVirtual", totalarticleOnDeptVirtual);
//		model.put("totalarticleDeptVirtual", totalarticleOnDeptVirtual.size());
//		LOGGER.debug("totalarticleOnDeptVirtual : "+totalarticleOnDeptVirtual.size());
//		
//		List<ArticleDetailplannerVo> totalarticleOnDeptTodayVirtual = articleService.gettotalarticleOnDeptTodayVirtual();
//		model.put("totalarticleOnDeptTodayVirtual", totalarticleOnDeptTodayVirtual);
//		model.put("totalarticleDeptTodayVirtual", totalarticleOnDeptTodayVirtual.size());
//		LOGGER.debug("totalarticleOnDeptTodayVirtual : "+ totalarticleOnDeptTodayVirtual.size());
//		
//		List<Department> department =departmentService.getDepartmentsList();
//		model.put("department", department);
////		List<TaskScheduler> totalarticleOnDeptTodayVirtual = taskService.gettotalarticleOnDeptTodayVirtual();
////		model.put("totalarticleOnDeptTodayVirtual", totalarticleOnDeptTodayVirtual);
//	
//		
//		return new ModelAndView("PlaneerDeptdashboard");
//		
//		
//		
//	}
//}