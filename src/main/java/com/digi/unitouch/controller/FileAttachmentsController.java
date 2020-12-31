package com.digi.unitouch.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.util.matcher.MediaTypeServerWebExchangeMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.FileAttachments;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.FileAttachmentsService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ArticleSearchDetailvo;

@Controller
public class FileAttachmentsController extends LoggerClass {
	@Autowired
	ArticleService articleService;
	@Autowired
	FileAttachmentsService fileAttachmentsService;
	@Autowired
	UserService userService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	TaskService taskService;
	@Autowired
	JournalService journalService;

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
	private Environment env;

	@Value("${journal.path}")
	private String UPLOAD_FOLDER;

	@Value("${journal.extraFolder}")
	private String EXTRA_FOLDER;

	@RequestMapping(value = "/fileAttachments", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String fileAttachments(FileAttachments extfile, RedirectAttributes ra, ModelMap model,
			HttpServletRequest request, @RequestParam MultipartFile[] fileAttachments) throws IOException {
		Path path = null;
		byte[] bytes = null;
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		ArticleDetail article = articleService.findArticleDetailBy(extfile.getAid());
		String filePath = UPLOAD_FOLDER + File.separator + article.getJournals().getJournalAbbrName().toLowerCase()
				+ File.separator + article.getArticle_doi() + File.separator + EXTRA_FOLDER;
		for (MultipartFile attachment : fileAttachments) {
			FileAttachments extrafile = new FileAttachments();
			if (!attachment.isEmpty()) {
				bytes = attachment.getBytes();
				if (!new File(filePath).exists()) {
					new File(filePath).mkdirs();
				}
				extrafile.setAid(article.getArticle_id());
				extrafile.setFileName(attachment.getOriginalFilename());
				extrafile.setJid(article.getJournalId());

				LOGGER.info("extra file path  " + filePath + File.separator + attachment.getOriginalFilename());
				path = Paths.get(filePath + File.separator + attachment.getOriginalFilename());
				LOGGER.info("extra file path  " + path.toString());
				extrafile.setFilePath(path.toString());
				extrafile.setComment("");
				extrafile.setCreated_at(new Date());
				extrafile.setCreated_by(users.getUserID());
				fileAttachmentsService.save(extrafile);
				Files.write(path, bytes);

				System.out.println(extrafile.toString());
			}
		}
		ra.addAttribute("message", "File uploaded successfully");
		ra.addAttribute("css", "success");
		ra.addAttribute("article_id", extfile.getAid());
		return "redirect:articleHistory";
	}

	@GetMapping("/articleHistory")
	public ModelAndView articalDetails(ModelMap model, HttpServletRequest request,
			@ModelAttribute("message") String message, @ModelAttribute("css") String css,
			@ModelAttribute("article_id") String article_id) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
//		String article_id = request.getParameter("article_id");
		model.put("article_id", article_id);
		ArticleDetail articleDetail = articleService.findArticleDetailBy(Integer.parseInt(article_id));
		int JrID = articleDetail.getJournalId();
		Journal journal = journalService.getJournalNameby(JrID);
		int workFlowID = journal.getArticleWorkflowId();
		LOGGER.info("journal-->" + journal.toString());
		model.put("ArticleTitle", articleDetail.getArticle_title());
		model.put("aid", articleDetail.getAid());
		model.put("article_title", articleDetail.getArticle_title());
		model.put("journalName", journal.getJournalName());
		model.put("aid", articleDetail.getAid());
		model.put("journalAbbr", articleDetail.getJournals().getJournalAbbrName());
		model.put("articleNote", articleDetail.getArticle_comment());
		model.put("colorCount", articleDetail.getColorImgCount());
		model.put("article_pages", articleDetail.getArticle_pages());
		model.put("wordCount", articleDetail.getWordCount());
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
		List<FileAttachments> fileAttachments = fileAttachmentsService.findByArticle(Integer.parseInt(article_id),
				journal.getJournalId());
		System.out.println(fileAttachments.toString());
		model.put("fileAttachments", fileAttachments);
		System.out.println(nextTasks.toString());
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		model.addAttribute("flag", 1);
		return new ModelAndView("searchDetailsList");
	}

	@GetMapping(value = ".well-known/pki-validation/ca3-d4c27c5450be46538c7ebd6e0289f9f6.txt")
	public ResponseEntity<InputStreamResource> downloadFile() {
		String file1 ="/unitouch_tomcat/unitouch/ca3-d4c27c5450be46538c7ebd6e0289f9f6.txt";
		System.out.println("fileURL----->" + file1);
		File file = null;
		System.out.println(file1);
		file = new File(file1);
		InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
			LOGGER.info("file  found ------------->"+file1);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					.contentType(MediaType.APPLICATION_PDF).contentLength(file.length()).body(resource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			LOGGER.info("file not found ------------->"+file1);
			LOGGER.info("]Message------------->"+e.getMessage());
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" +"No__File___Found")
					.contentType(MediaType.APPLICATION_PDF).contentLength(file.length()).body(null);
		}
		
	}
}
