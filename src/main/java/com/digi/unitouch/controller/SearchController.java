package com.digi.unitouch.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.CurrentIssueStatus;
import com.digi.unitouch.model.FileAttachments;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.IssueArticle;
import com.digi.unitouch.model.IssueComment;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.IssueFileVersion;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.FileAttachmentsService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.IssueArticleService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.serviceImpl.CurrentIssueServiceImpl;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ArticleDetailvo;
import com.digi.unitouch.vo.ArticleSearchDetailvo;
import com.digi.unitouch.vo.IssueSearchDetailvo;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearchController extends LoggerClass {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	TaskService taskService;
	@Autowired
	JournalService journalService;
	@Autowired
	ArticleService articleService;
	@Autowired
	WorkflowService workflowService;
	@Autowired
	FileVersionService fileversionservice;
	@Autowired
	AuthorArticleService authorArticleService;
	@Autowired
	IssueDetailService issueDetailService;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	FileAttachmentsService fileAttachmentsService;
	@Autowired
	IssueArticleService issueArticleService;
	@Autowired
	IssueDetailService issueService;
	@Autowired
	CurrentIssueServiceImpl currentIssueServiceImpl;
	
	@RequestMapping(value = { "/srchart" })
	public ModelAndView GroupTaskDetail(ModelMap model) {
		return new ModelAndView("searchList");
	}

	@RequestMapping(value = { "/searchArticleData" })
	public ModelAndView searchArticleData(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String article_title = request.getParameter("article_title");
		String article_doi = request.getParameter("article_doi");
		String article_type_cd = request.getParameter("article_type_cd");
		String publisherName = request.getParameter("publisherName");
		String journalAbbr = request.getParameter("journalAbbr");
		String keywords = request.getParameter("keywords");
		String aid = request.getParameter("aid");
		String lname = request.getParameter("lname");
		String authorEmail = request.getParameter("authorEmail");
		String articleStatus = request.getParameter("articleStatus");
		model.put("authorEmail", authorEmail);
		model.put("lname", lname);
		model.put("aid", aid);
		model.put("article_title", article_title);
		model.put("article_doi", article_doi);
		model.put("article_type_cd", article_type_cd);
		model.put("publisherName", publisherName);
		model.put("journalAbbr", journalAbbr);
		model.put("keywords", keywords);
		model.put("articleStatus", articleStatus);
		List<ArticleDetailvo> ArticleDetail = articleService.getArticleDetailList(article_title, article_doi,
				article_type_cd, publisherName, journalAbbr, aid, keywords, lname, authorEmail, articleStatus);
		model.put("ArticleDetail", ArticleDetail);
		for (ArticleDetailvo articleDetailvo : ArticleDetail) {
			List<IssueArticle> la= issueArticleService.getIssueByarticleID(articleDetailvo.getArticle_id());
			System.out.println(la.toString());
			StringBuilder sb= new StringBuilder();
			for (IssueArticle issueArticle :la) {
				IssueDetail iss=	issueService.getIsuuelistbyid(issueArticle.getIssueId());
				sb.append(iss.getIssue_title()+" | ");
			//	articleDetailvo.setIssueTitle();
			}
			articleDetailvo.setIssueTitle(sb.toString());
		}
		if (ArticleDetail.isEmpty()) {
			model.addAttribute("message", "No matching records found !!!");
			model.addAttribute("css", "danger");
		}
		return new ModelAndView("searchList");
	}

	@RequestMapping(value = "/startGroupTask", method = RequestMethod.POST)
	public ModelAndView articalDetails(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String article_title = request.getParameter("article_title");
		String article_doi = request.getParameter("article_doi");
		String article_type_cd = request.getParameter("article_type_cd");
		String publisherName = request.getParameter("publisherName");
		String journalAbbr = request.getParameter("journalAbbr");
		String lname = request.getParameter("lname");
		String authorEmail = request.getParameter("authorEmail");
		model.put("authorEmail", authorEmail);
		model.put("lname", lname);
		String flag = request.getParameter("flag");
		model.put("article_title", article_title);
		model.put("article_doi", article_doi);
		model.put("article_type_cd", article_type_cd);
		model.put("publisherName", publisherName);
		model.put("flag", flag);
		String aid = request.getParameter("aid");
		model.put("aid", aid);
		String article_id = request.getParameter("article_id");
		model.put("article_id", article_id);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Integer.parseInt(article_id));
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		LOGGER.info("journal-->" + journal.toString());
		model.put("ArticleTitle", articleDetail.getArticle_title());
		model.put("journalName", journal.getJournalName());
		model.put("aid", articleDetail.getAid());
		model.put("journalAbbr", journalAbbr);
		model.put("articleNote", articleDetail.getArticle_comment());
		model.put("colorCount", articleDetail.getColorImgCount());
		model.put("wordCount", articleDetail.getWordCount());
		model.put("article_pages", articleDetail.getArticle_pages());
		model.put("article_doi", articleDetail.getArticle_doi());
		model.put("article_type", articleDetail.getArticle_type_cd());
		model.put("reviewDate", articleDetail.getReview());
		model.put("submissionDate", articleDetail.getSubmissionDate());
		model.put("commentorproductions", articleDetail.getCommentoForProduction());
		model.put("Journalissn", articleDetail.getJournals().getJournalIssn());
		List<ArticleSearchDetailvo> finallist = new ArrayList<ArticleSearchDetailvo>();
		List<ArticleSearchDetailvo> ArticleDetail = articleService
				.getArticleSearchDetailList(Integer.parseInt(article_id));
		Iterator<ArticleSearchDetailvo> iterator = ArticleDetail.iterator();
		while (iterator.hasNext()) {
			ArticleSearchDetailvo article = iterator.next();
			// Department department =
			// departmentService.getDepartmentsByID(article.getDept_id());
			article.setDeptName("");
			finallist.add(article);
		}
		model.put("article_keywords", articleDetail.getKeywords());
		model.put("article_ingested", articleDetail.getAccepted_date());
		List<FileVersion> fileVersions = fileversionservice.findbyAidJid(Integer.parseInt(article_id),
				journal.getJournalId());
		/*
		 * ArticleSearchDetailvo articleSearchDetailvo;
		 * articleSearchDetailvo.getSch_end_time()
		 */
		model.put("fileVersions", fileVersions);
		model.put("ArticleDetail", finallist);

		Workflow workflows = workflowService.findworkflowbyname(workFlowID);
		List<ArticleComment> articleCommentsList = articleService.getArticleCommentsList(journal.getJournalId(),
				Integer.parseInt(article_id));
		model.put("workflowName", workflows.getName());
		model.put("commentsList", articleCommentsList);
		List<AuthorArticleDetails> authorArticle = authorArticleService.fileByArticleId(Integer.parseInt(article_id));
		// System.out.println(authorArticle.toString());
		model.put("authorDetails", authorArticle);
		CurrentArticleStatus curr = articleService.findArticleStatusBy(Integer.parseInt(article_id));

		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(curr.getTask_id(), workFlowID);
		System.out.println("workflowTaskSeq--->" + workflowTaskSeq.toString());
		int currentTaskSequence = workflowTaskSeq.getSequence();
		List<TaskDetails> nextTasks = taskService.getnextTaskListBy(workFlowID, currentTaskSequence);
		model.addAttribute("nextTasks", nextTasks);
		List<TaskDetails> task = taskService.getPreviousTaskListBy(workFlowID, currentTaskSequence);
		model.put("TaskList", task);
		List<FileAttachments> fileAttachments= fileAttachmentsService.findByArticle(Integer.parseInt(article_id),journal.getJournalId());
		System.out.println(fileAttachments.toString());
		model.put("fileAttachments",fileAttachments);
		System.out.println(nextTasks.toString());
		return new ModelAndView("searchDetailsList");
	}

	@RequestMapping(value = "/startarticleTask", method = RequestMethod.POST)
	public ModelAndView supplierarticalDetails(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		/*
		 * String article_title=request.getParameter("article_title"); String
		 * article_doi=request.getParameter("article_doi"); String
		 * article_type_cd=request.getParameter("article_type_cd"); String
		 * publisherName=request.getParameter("publisherName");
		 * model.put("article_title", article_title); model.put("article_doi",
		 * article_doi); model.put("article_type_cd", article_type_cd);
		 * model.put("publisherName", publisherName); String
		 * aid=request.getParameter("aid"); model.put("aid", aid);
		 */
		String article_id = request.getParameter("article_id");
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Integer.parseInt(article_id));
		/*
		 * int JrID = articleDetail.getJournalId(); Journal journal =
		 * journalService.getJournalNameby(JrID); int workFlowID =
		 * journal.getArticleWorkflowId(); model.put("ArticleTitle",
		 * articleDetail.getArticle_title()); model.put("journalName",
		 * journal.getJournalName()); model.put("aid", articleDetail.getAid());
		 * model.put("article_doi", articleDetail.getArticle_doi());
		 */
		List<ArticleSearchDetailvo> ArticleDetail = articleService
				.getArticleSearchDetailList(Integer.parseInt(article_id));
		LOGGER.info("ArticleDetail        : " + ArticleDetail);
		model.put("ArticleDetail", ArticleDetail);
		/*
		 * List<AuthorArticleDetails>
		 * authorArticle=authorArticleService.fileByArticleId(Integer.parseInt(
		 * article_id)); System.out.println(authorArticle.toString());
		 * model.put("authorDetails", authorArticle);
		 */
		/*
		 * Workflow workflows = workflowService.findworkflowbyname(workFlowID);
		 * model.put("workflowName", workflows.getName());
		 */

		return new ModelAndView("searchDetailsList");
	}

//	@GetMapping(value = "/singleFileDownload")
//	public ResponseEntity<InputStreamResource> downloadFile(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String filePath = request.getParameter("file_Path");
//		File file = null;
//		file = new File(filePath);
//		File directory = new File(sourceFile);
//		String[] files = null;
//		files = directory.list();
//
//		byte[] zip = zipFiles(directory, files);
//		ServletOutputStream sos = response.getOutputStream();
//		response.setContentType("application/zip");
//		response.setHeader("Content-Disposition", "attachment; filename=" + "test" + ".zip");
//		sos.write(zip);
//		sos.flush();
//		
//		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//				.contentLength(file.length()).body(resource);
//	}

	@RequestMapping(value = "/issueShecdulerDetails", method = RequestMethod.POST)
	public ModelAndView IssueDetails(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
	
		String flag = request.getParameter("flag");
		model.put("flag", flag);
		String issue_Id = request.getParameter("issue_id");
		model.put("article_id", issue_Id);
		IssueDetail issueDetail = issueDetailService.getIsuuelistbyid(Integer.parseInt(issue_Id));
		int JrID = issueDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getIssueWorkflowId();
		model.put("IssueTitle", issueDetail.getIssue_title());
		model.put("journalName", issueDetail.getJournals().getJournalName());
		model.put("volumeYear", issueDetail.getVolume_year());
		model.put("journalAbbr", issueDetail.getJournals().getJournalAcronym());
		model.put("lastIssueNumber", issueDetail.getLast_issue_number());
		model.put("numberVolumePerYear", issueDetail.getNumber_of_volume_per_year());
		model.put("Journalissn", issueDetail.getJournals().getJournalIssn());
		List<IssueSearchDetailvo> finallist = new ArrayList<IssueSearchDetailvo>();
		List<IssueSearchDetailvo> ArticleDetail = issueDetailService
				.getIssueSearchDetailList(Integer.parseInt(issue_Id));

		Iterator<IssueSearchDetailvo> iterator = ArticleDetail.iterator();
		while (iterator.hasNext()) {
			IssueSearchDetailvo article = iterator.next();
			article.setDeptName("");
			finallist.add(article);
		}
		model.put("article_keywords", issueDetail.getAnnual_article_budget());
		model.put("article_ingested", issueDetail.getProduction_time_target());
		List<IssueFileVersion> issuefileVersions = fileversionservice.findbyissueIdJid(Integer.parseInt(issue_Id),
				journal.getJournalId());
		model.put("fileVersions", issuefileVersions);
		model.put("ArticleDetail", finallist);
		Workflow workflows = workflowService.findworkflowbyname(workFlowID);
		model.put("workflowName", workflows.getName());
		

		CurrentIssueStatus curr = currentIssueServiceImpl.findIssuetatusById(Integer.parseInt(issue_Id));
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(curr.getTaskId(), workFlowID);
		int currentTaskSequence = workflowTaskSeq.getSequence();
		List<TaskDetails> nextTasks = taskService.getnextTaskListBy(workFlowID, currentTaskSequence);
		model.addAttribute("nextTasks", nextTasks);
		List<TaskDetails> task = taskService.getPreviousTaskListBy(workFlowID, currentTaskSequence);
		model.put("TaskList", task);
		
		List<IssueComment> issueCommentsList = issueDetailService.getIssueCommentsList(journal.getJournalId(),
				Integer.parseInt(issue_Id));
		model.put("commentsList", issueCommentsList);
		return new ModelAndView("Issue/issueSearchDeatils");
	}

}
