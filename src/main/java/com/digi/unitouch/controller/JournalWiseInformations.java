package com.digi.unitouch.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.DepartmentsTask;

@Controller
public class JournalWiseInformations {

	@Autowired
	JournalService journalService;
	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;

	@GetMapping("/getAssosiatedjournalList")
	public ModelAndView getAssosiatedJournalList(ModelMap model, HttpServletRequest request, HttpSession session) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<Journal> journalList = new ArrayList<Journal>();
		Set<Integer> set = new LinkedHashSet<Integer>();
		List<DepartmentsTask> daptTask = new LinkedList<DepartmentsTask>();
		List<Integer> jr = new ArrayList<>();

		daptTask.addAll(taskManagementService.getAllTaskAndALLJournalByUserID(users.getUserID()));

		for (DepartmentsTask desk : daptTask) {
			jr.add(desk.getJournalId());
		}
		set.addAll(jr); // Clear the list
		jr.clear(); // add the elements of set // with no duplicates to the list
		jr.addAll(set);// return the list
		for (Integer jid : jr) {
			journalList.add(journalService.getjournalbyId(jid));
		}
		model.put("journalList", journalList);
		return new ModelAndView("JournalWise/JournalWiseInformations");
	}

	@GetMapping("journal-{journalAbbr}")
	public ModelAndView getjournalsWiseArticle(@PathVariable("journalAbbr") String journalAbbr, ModelMap model) {
		Journal journalInfo = journalService.getJournalbyabbrname(journalAbbr);
//		CopyOnWriteArrayList<ArticleDetail> journalWisearticle = articleService
//				.getassignedArticlebyJrId(journalInfo.getJournalId());
		List<ArticleDetailsVO> ArticleDetail = articleService.getarticleDetailByjournalID(journalInfo.getJournalId());
		model.put("journalWisearticle", ArticleDetail);
		return new ModelAndView("JournalWise/JournalWiseArticle");
	}
}
