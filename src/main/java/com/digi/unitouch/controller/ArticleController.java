package com.digi.unitouch.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.digi.unitouch.ApplicationResponse;
import com.digi.unitouch.RestController.ArticleRestApiUniprr;
import com.digi.unitouch.RestController.AuthorRestController;
import com.digi.unitouch.autoTaskCompleted.AutoCompleteScheduler;
import com.digi.unitouch.autoTaskCompleted.FileLookupInSFTP;
import com.digi.unitouch.em.Meta.Contrib;
import com.digi.unitouch.em.Meta.Front;
import com.digi.unitouch.em.Meta.IssnConverter;
import com.digi.unitouch.em.Meta.Name;
import com.digi.unitouch.em.converter.AddrLineConverter;
import com.digi.unitouch.em.converter.AffConverter;
import com.digi.unitouch.em.converter.ArticleIdConverter;
import com.digi.unitouch.em.converter.ContribConverter;
import com.digi.unitouch.em.converter.DateConverter;
import com.digi.unitouch.em.converter.FigCountConverter;
import com.digi.unitouch.em.converter.JournalIdConverter;
import com.digi.unitouch.em.converter.SubjGroupConverter;
import com.digi.unitouch.emailScheduler.SchedulerMail;
import com.digi.unitouch.emun.EmailEnum;
import com.digi.unitouch.emun.EmunAticleStatus;
import com.digi.unitouch.ftp.EMFileRInjection;
import com.digi.unitouch.ftp.FtpFileCopy;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.AuthorDataApiModel;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.scholarOne.Main.IssnConverterScholar;
import com.digi.unitouch.scholarOne.Meta.ArticleScholarOne;
import com.digi.unitouch.scholarOne.Meta.MS;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.ArticleTaskDetailService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.EmailJournalWorkflowService;
import com.digi.unitouch.service.EmailTriggerService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.PublisherService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.util.DateApi;
import com.digi.unitouch.util.FileReading;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.util.ParseXML;
import com.digi.unitouch.util.ParseXmlUniPRR;
import com.digi.unitouch.util.SendEmailUtility;
import com.digi.unitouch.util.UnZip;
import com.digi.unitouch.util.XmlBeautify;
import com.digi.unitouch.util.ZipFileUnZip;
import com.digi.unitouch.vo.Article;
import com.digi.unitouch.vo.ArticleDataApi;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.ArticleInfoAPI;
import com.digi.unitouch.vo.Attachment;
import com.digi.unitouch.vo.Author;
import com.digi.unitouch.vo.AuthorVo;
import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.ingestionvo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Controller
public class ArticleController extends LoggerClass {

	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	JournalService journalService;
	@Autowired
	PublisherService publisherService;
	@Autowired
	WorkflowService workflowService;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	TaskService taskService;
	@Autowired
	WorkflowTaskService workflowRoleService;

	@Autowired
	ArticleTaskDetailService articleTaskDetailService;

	@Autowired
	TaskManagementService taskManagementService;
	@Autowired
	FileVersionService fileversionservice;
	@Autowired
	EmailJournalWorkflowService emailJournalWorkflowService;
	@Autowired
	EmailTriggerService emailTriggerService;
	@Autowired
	SchedulerMail schedulerMail;
	@Autowired
	AuthorArticleService authorService;
	@Autowired
	private Environment env;
	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;

	@Value("${unitouch.Scheduled}")
	private String unitouchScheduled;
	
	@Value("${journal.path}")
	private String journalPath;

	@Value("${journal.InputPath}")
	private String InputPath;

	@Value("${journal.OutputPath}")
	private String OutputPath;

	@Value("${journalErrorPath}")
	private String ErrorPath;

	@Value("${journal.finalErrorPath}")
	private String finalErrorPath;

	@Value("${Journal.ErrorDIRLocation}")
	private String JournalErrorDIRLocation;
	
	// SO SFtp File Path
	@Value("${Journal.SOInputDIRLocation}")
	private String SOInputDIRLocation;

	@Value("${Journal.SOOutputDIRLocation}")
	private String SOOutputDIRLocation;

	@Value("${Journal.SOErrorDIRLocation}")
	private String JournalSOErrorDIRLocation;

	// EM File Location
	@Value("${journal.EMInputPath}")
	private String InputEMPath;

	@Value("${journal.EMOutputPath}")
	private String OutputEMPath;

	@Value("${journal.EMErrorPath}")
	private String ErrorEMPath;

	// EM SFtp File Path
	@Value("${Journal.EmInputDIRLocation}")
	private String EmInputDIRLocation;

	@Value("${Journal.EmOutputDIRLocation}")
	private String EmOutputDIRLocation;

	@Value("${Journal.EmErrorDIRLocation}")
	private String JournalEmErrorDIRLocation;

	// uniprr or medknow SFtp File Path
	@Value("${Journal.InputDIRLocation}")
	private String InputDIRLocation;

	@Value("${Journal.OutputDIRLocation}")
	private String OutputDIRLocation;

	// SO File Location
	@Value("${journal.SOInputPath}")
	private String InputSOPath;

	@Value("${journal.SOOutputPath}")
	private String OutputSOPath;

	@Value("${journal.SOErrorPath}")
	private String ErrorSOPath;

	// sftp
	@Value("${sftp.host}")
	private String sftpHost;

	@Value("${sftp.port}")
	private String sftpPort;

	@Value("${sftp.user}")
	private String sftpUser;

	@Value("${sftp.password}")
	private String sftpPassword;

	@GetMapping("/articleDetail")
	public ModelAndView ArticleDetail(ModelMap model, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) throws Exception {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		List<ArticleDetailsVO> ArticleDetail = articleService.getarticleDetail();
		model.put("ArticleDetail", ArticleDetail);
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		LOGGER.info("--------ArticleController  ----->---articleDetail------------------name=>" + name);
		return new ModelAndView("articleList");
	}

	@PostMapping("withdrawArtical")
	public ModelAndView withdrawArtical(ModelMap model, ArticleDetail article) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String status = "Y";
		Integer articleID = article.getArticle_id();
		System.out.println(articleID);
		boolean stastus = articleService.withdrawArtical(status, articleID);
		LOGGER.info("withdrawArtical------------------->" + article.getArticle_id()
				+ "-------------->successfully Status" + stastus);
		model.put("message", "Subject withdraw successfully");
		model.put("css", "success");
		List<ArticleDetailsVO> ArticleDetail = articleService.getarticleDetail();
		// List<ArticleDetail> ArticleDetail = articleService.getallList();
		model.put("ArticleDetail", ArticleDetail);
		LOGGER.info("--------ArticleController  ----->---withdrawArtical-----------------name------" + name);
		return new ModelAndView("articleList");
	}

	@PostMapping("articalWithdraw")
	public ModelAndView articalWithdraw(ModelMap model, ArticleDetail article) {
		String status = "Y";
		Integer articleID = article.getArticle_id();
		ArticleDetail articledata = articleService.findArticleDetailBy(articleID);
		boolean stastus = articleService.withdrawArtical(status, articleID);
		LOGGER.info("withdrawArtical------------------->" + article.getArticle_id()
				+ "-------------->successfully Status" + stastus);
		model.put("message", "Subject withdraw successfully");
		model.put("css", "success");
		List<ArticleDetailsVO> ArticleDetail = articleService.getarticleDetailByjournalID(articledata.getJournalId());
		model.put("journalWisearticle", ArticleDetail);
		return new ModelAndView("JournalWise/JournalWiseArticle");
	}

//	@GetMapping("resetArticle")
//	public ModelAndView resetArticle(ModelMap model) {
//
//		taskService.resetDataFormScheduler();
//		return new ModelAndView("resetArticle");
//	}

	@RequestMapping(value = { "/createArticle" })
	public ModelAndView createDetail(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		if (users.getRole().getRoleID() == 1) {
			List<Journal> journal = journalService.getjournalList();
			model.put("journallist", journal);
//			List<Publisher> publisher = publisherService.getallList();
//			model.put("publisherList", publisher);	
		} else {
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
			model.put("journallist", journalList);
		}
		return new ModelAndView("articleCreate");
	}

	@RequestMapping(value = { "/SaveArticle" })
	public String saveArticle(ModelMap model, HttpServletRequest request, ArticleDetail articleDetail, AuthorVo author,
			@RequestParam MultipartFile attachment, RedirectAttributes ra) {
		articleDetail.setPublisher_id(142);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		ArticleDetail articleDetails = articleService.findByAid(articleDetail.getAid());
		if (articleDetails == null) {
			articleDetail.setWithdrawStatus("N");
			articleDetail.setPriority("Medium Priority");
			articleDetail.setKeywords(articleDetail.getKeywords() + "");
			articleDetail.setSubmissionDate(DateApi.getCurrentIndianTime());
			articleDetail.setArticle_doi(articleDetail.getAid()+"/"+articleDetail.getSubjectnoms());
			int aId = articleService.saveArticle(articleDetail);
//			for (int i = 0; i < author.getFname().length; i++) {
//				AuthorArticleDetails aad = new AuthorArticleDetails();
//				aad.setArticle_id(aId);
//				aad.setTitle(author.getTitle()[i]);
//				aad.seteMail(author.getEmail()[i]);
//				aad.setfName(author.getFname()[i]);
//				aad.setlName(author.getLname()[i]);
//				aad.setAuthor_order(i + 1 + "");
//				aad.setmName(author.getMname()[i]);
//				aad.setCopyright("YES");
//				aad.setIs_corresponding(author.getIs_corresponding()[i]);
//				authorService.save(aad);
//				LOGGER.info("Auhtor info save for " + articleDetail.getArticle_title());
//			}
			// authorService.save(author);

			Journal journal = new Journal();
			journal = journalService.getjournalbyId(articleDetail.getJournalId());

			WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(journal.getArticleWorkflowId());
			int taskId = workflowTaskSeq.getTaskId();
			if (!attachment.isEmpty()) {
				try {
					byte[] bytes = attachment.getBytes();
					if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin").exists()) {
						new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin").mkdirs();
					}

					Path path = Paths.get(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin"
							+ File.separator + attachment.getOriginalFilename());
					FileVersion fileVersion = new FileVersion();
					fileVersion.setArticleId(aId);
					fileVersion.setJournalId(journal.getJournalId());
					fileVersion.setFileName(attachment.getOriginalFilename());
					fileVersion.setFileType(attachment.getContentType());
					fileVersion.setFileVersion(1);
					fileVersion.setTaskId(taskId);
					fileVersion.setFilePath(path.toString());
					fileversionservice.saveFileVersion(fileVersion);
					Files.write(path, bytes);
					String filename = journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin"
							+ File.separator + attachment.getOriginalFilename();
					taskSchedular(aId, filename);
					// bundling calling
					// bundlingCall(attachment.getOriginalFilename());

					// LOGGER.debug("filename " + filename);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			List<Journal> journal = journalService.getjournalList();
			model.put("journallist", journal);
//			List<Publisher> publisher = publisherService.getallList();
//			model.put("publisherList", publisher);
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Subject ID \r\n" + articleDetail.getAid() + "\r\n is already exist");
			return "articleCreate";
		}
		// String value = mailService.sendEmail(email, Subject, Body);
		// List<ArticleDetail> ArticleDetail = articleService.getallList();
		// model.put("ArticleDetail", ArticleDetail);
		ra.addAttribute("css", "success");
		ra.addAttribute("message", "Subject ID \r\n" + articleDetail.getAid() + "\r\n is created successfully");
		if (users.getRole().getRoleID() == 1) {
			return "redirect:articleDetail";
		} else {
			return "redirect:dashboard";
		}
	}

	@PostMapping("/getuserListByjournalID")
	public ResponseEntity<ApplicationResponse> getuserListByDptID(@RequestBody Journal journal, ModelMap model) {
		LOGGER.debug(journal.getJournalId().toString());
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		Journal journal1 = journalService.getjournalbyId(journal.getJournalId());
		String doiprefix = journal1.getDoiPrefix() + "/" + journal1.getJournalAcronym().toUpperCase() + ".";
		ArticleRestApiUniprr unprr = new ArticleRestApiUniprr();
		ArticleDataApi articleApi = unprr.getAidDOIFromUniprr(journal1.getJournalAcronym());
		if (articleApi.getManuscriptCode() != null) {
			// model.put("doiPrefix", articleApi.getStatusCode());
			// model.put("aid",articleApi.getManuscriptStatus());
			applicatonResponse.setPayload(articleApi.getManuscriptStatus());
			applicatonResponse.setPayloadNext(articleApi.getManuscriptCode());
		} else {
			// model.put("aid",articleApi.getManuscriptStatus());
			System.out.println("else call not get data from uniprr");
			model.put("doiPrefix", doiprefix);
			applicatonResponse.setPayload(doiprefix);
		}
		LOGGER.debug("Article cnt journal ------------ getuserListByjournalID :" + journal1.getJournalName());
		applicatonResponse.setMessage("OK");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/view-articleDetail", method = RequestMethod.POST)
	public ModelAndView showArticleDetails(ModelMap model, HttpServletRequest request) {
		String ID = request.getParameter("article_id");
		int id = Integer.parseInt(ID);
		model.put("article_id", id);
		ArticleDetail ArticleDetail = articleService.findArticleDetailBy(id);
		model.put("ArticleDetail", ArticleDetail);
		List<Journal> journal = journalService.getallList();
		model.put("journallist", journal);
		List<Publisher> publisher = publisherService.getallList();
		model.put("publisherList", publisher);
		return new ModelAndView("ArticleDetailEdit");
	}

	@RequestMapping(value = "/updateArticleDetail", method = RequestMethod.POST)
	public ModelAndView saveTicketUpdatePage(ModelMap model, HttpServletRequest request, ArticleDetail articleDetail) {
		String ID = request.getParameter("article_id");
		int id = Integer.parseInt(ID);
		model.put("article_id", id);
		ArticleDetail updateArticle = articleService.findArticleDetailBy(id);
		updateArticle.setArticle_title(articleDetail.getArticle_title());
		updateArticle.setJournalId(articleDetail.getJournalId());
		updateArticle.setPublisher_id(articleDetail.getPublisher_id());
		updateArticle.setJournal_issue_number(articleDetail.getJournal_issue_number());
		updateArticle.setJournal_volume_number(articleDetail.getJournal_volume_number());
		updateArticle.setArticle_doi(articleDetail.getArticle_doi());
		updateArticle.setAid(articleDetail.getAid());
		updateArticle.setArticle_type_cd(articleDetail.getArticle_type_cd());
		articleService.updateArticleDetail(updateArticle);

		List<ArticleDetail> ArticleDetail = articleService.getallList();
		model.put("ArticleDetail", ArticleDetail);
		return new ModelAndView("articleList");

	}

	@RequestMapping(value = "/delete-articleDetail", method = RequestMethod.POST)
	public ModelAndView salesdeletecontact(ModelMap model, HttpServletRequest request, ArticleDetail articleDetail) {
		String ID = request.getParameter("article_id");
		int id = Integer.parseInt(ID);
		model.put("article_id", id);
		articleService.deleteArticleDetailById(id);
		List<ArticleDetail> ArticleDetail = articleService.getallList();
		model.put("ArticleDetail", ArticleDetail);
		return new ModelAndView("articleList");
	}

	public void taskSchedular(int artId, String fileName) {
		String fusername = null;
		String productionuser = null;
		// TaskScheduler ts = taskService.findtaskId(128);
		TaskScheduler ts = new TaskScheduler();

		LOGGER.debug("artID :" + artId);

		ArticleDetail articleDetail = articleService.findArticleDetailBy(artId);
		LOGGER.debug("articleController " + articleDetail);
		Journal journal = journalService.getjournalbyId(articleDetail.getJournalId());
		LOGGER.debug("journal :" + journal);
		CurrentArticleStatus currentArticleStatus = new CurrentArticleStatus();
		int wfid = journal.getArticleWorkflowId();
		WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(wfid);
		int taskId = workflowTaskSeq.getTaskId();
		LOGGER.debug("Taskid: " + taskId);
		currentArticleStatus.setTask_id(taskId);
		currentArticleStatus.setArticle_id(artId);
		articleService.saveCurrentArticleStatus(currentArticleStatus);
		currentArticleStatus.setArticle_id(artId);
//		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowTaskService.workflowTaskSeqlist(wfid);

//		List<WorkflowTaskSeq> finallist = new ArrayList<WorkflowTaskSeq>();
		List<WorkflowTaskSeq> uu = (List<WorkflowTaskSeq>) workflowTaskService.workflowTaskSeqlist(wfid);
//		final String input = journal.getJournalAbbrName().toLowerCase() + "//" + articleDetail.getArticle_doi();
		final String SFTPHOST = sftpHost;
		final String SFTPUSER = sftpUser;
		// final char s = '"';
		final String SFTPPASS = sftpPassword;

//		AutoCompleteScheduler.fileCopyToClientLocation(articleDetail, journal, SFTPHOST, SFTPUSER, SFTPPASS, uu,
//				fileName);
		Iterator<WorkflowTaskSeq> iterator = uu.iterator();
		Date name;
		Date name1 = null;
		Date name2 = null;
		while (iterator.hasNext()) {
			name2 = name1;
			WorkflowTaskSeq producationTrackers = iterator.next();

			int Tat = producationTrackers.getTat();
			TaskDetails task = producationTrackers.getTask();

			/*
			 * Task MkDir
			 */
			try {

				if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
						+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
								.exists()) {
					new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
							+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
									.mkdirs();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			int day = 0;
			// day = (Tat / 8); // 8 hr = 1 day
			day = Tat; // new add on 04/07/2020
			// int hours = Tat % 8; // cmnt on 04/072020
			/*
			 * if(hours>0) { day =day+1; }
			 */
			int taskid = producationTrackers.getTaskId();
			Date dd = null;
			if (name2 == null) {
				dd = ts.setSch_start_time(new Date());
			} else {
				dd = name2;
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dd);
			Calendar dateCal = Calendar.getInstance();
			dateCal.setTime(dd);
			// dateCal.add(Calendar.HOUR_OF_DAY, hours); // cmnt on 04/072020
			// dateCal.add(Calendar.DATE, day);

//			for (int i = 0; i < day - 1; i++) {
//				dateCal.add(dateCal.DATE, 1);
//				if (dateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
//						|| dateCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//					dateCal.add(dateCal.DATE, 1);
//					// i--;
//				}
//			}
			LocalDate result = LocalDate.now();
			int addedDays = 0;
			int c = 0;
			while (addedDays < day) {
				result = result.plusDays(1);

				if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
					addedDays++;
				}
				c++;
			}
			dateCal.add(dateCal.DATE, c);
			Date dc = dateCal.getTime();
			name = dc;
			name1 = name;

			TaskScheduler tschedule = new TaskScheduler();
			tschedule.setArticle_id(artId);
			tschedule.setWorkflow_id(wfid);
			tschedule.setTask_id(taskid);
			tschedule.setTask_assigned_date(dd);
			tschedule.setTask_due_date(dc);
			tschedule.setSch_start_time(dd);
			tschedule.setSch_end_time(dc);
			tschedule.setAssign_back_count(0);
			tschedule.setCreated_date(new Date());
			if (producationTrackers.getSequence().equals(0)) {
				ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((wfid),
						(articleDetail.getJournalId()), (producationTrackers.getRoleId()),
						producationTrackers.getTaskId());
				LOGGER.info("WorkflowTaskSeq  InPool------->" + producationTrackers);
				tschedule.setUser_id(manageJournalWorkflow.getUser_id());
				tschedule.setTask_status("Yet-to-Start");
				fusername = manageJournalWorkflow.getUsers().getUsername();
			} else {
				LOGGER.info("WorkflowTaskSeq  Yet-to-Start------->" + producationTrackers);
				tschedule.setTask_status("Yet-to-Start");
			}
			tschedule.setRunId(0);
			taskService.savetakSchedulars(tschedule);
			if (producationTrackers.getRoleId() == 3712) {
				ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((wfid),
						(articleDetail.getJournalId()), (producationTrackers.getRoleId()),
						producationTrackers.getTaskId());
				productionuser = manageJournalWorkflow.getUsers().getUsername();
			}
			LOGGER.debug(tschedule.toString());

		} // 3712

		try {
			// List<String> fTask =
			// EmunAticleStatus.fiststageMail(articleDetail.getArticle_title(),
			// articleDetail.getAid(), journal.getJournalName());
			EmailJournalWorkflow emailTaskWorkflow = emailJournalWorkflowService
					.findByejwt(articleDetail.getJournalId(), wfid, taskId);
			String body = EmunAticleStatus.modifiedMailTemplate(emailTaskWorkflow.getEmailTemp().getReplyBody(),
					articleDetail,journal);
			String subject = EmunAticleStatus.modifiedMailTemplate(emailTaskWorkflow.getEmailTemp().getReplySubject(),
					articleDetail,journal);
			// SendEmailUtility.sendFistStageProductioMail(fusername, fTask.get(0),
			// fTask.get(1), journal.getFromEmail());
			SendEmailUtility.sendFistStageProductioMail(fusername, subject, body, journal.getFromEmail());
			LOGGER.info("----------------->mail send at 1st time " + fusername + "\r\n" + subject + "\r\n" + body
					+ "\r\n" + journal.getFromEmail());

			List<String> produ = EmunAticleStatus.toProduction(articleDetail.getArticle_title(), articleDetail.getAid(),
					journal.getJournalName());
			SendEmailUtility.sendFistStageProductioMail(productionuser, produ.get(0), produ.get(1),
					journal.getFromEmail());
			LOGGER.info("----------------->mail to pe " + productionuser + " \n ------" + produ.get(0) + "\n  "
					+ produ.get(1));
		} catch (MessagingException e) {
			LOGGER.info("error to sending  PE mail" + e);
		}

		// only for Em and SO
		if (journal.getJournalType().equalsIgnoreCase("EM")||journal.getJournalType().equalsIgnoreCase("SO")) {

			LOGGER.info("calling uniprr api for EM data Insert ");
			List<AuthorArticleDetails> authorDetail = authorService.fileByArticleId(articleDetail.getArticle_id());
			ArticleInfoAPI aip = new ArticleInfoAPI(authorDetail, articleDetail, journal, journal.getJournalAbbrName());
			ArticleRestApiUniprr aru = new ArticleRestApiUniprr();
			aru.sendArticleInfo(aip);

		} else {
			LOGGER.info("else Its not the EM Article--Type------>" + journal.getJournalType());
		}
	}

	@PostMapping("/unitouchLogo")

	public ModelAndView unitouchLogo(ModelMap model, HttpServletRequest request) {

		Integer article_task_id = Integer.parseInt(request.getParameter("article_task_id"));

		model.put("article_task_id", article_task_id);
		LOGGER.debug("Task id Is" + article_task_id);
		return new ModelAndView("unitouch");

	}

	@RequestMapping(value = { "/srchbook" })
	public String IngestionDetail(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		return "ingestion";
	}

	@RequestMapping(value = { "/insert-articles" })
	public ModelAndView IngestionArticle(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		ingestion(model, null);
		return new ModelAndView("ingestion");
	}

	public String ingestion(ModelMap model, HttpServletRequest request) {
		BufferedReader reader;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> list = new ArrayList<String>();
		Map<String, List<String>> error = new HashMap<String, List<String>>();
		List<String> errorlist = new ArrayList<String>();
		Map<String, List<String>> semierror = new HashMap<String, List<String>>();
		ingestionvo ingestion = new ingestionvo();
		try {

			File inputDir = new File("C:\\Users\\all\\Desktop\\Medknownew");// Directory where XML file exists

			File[] Articlefiles = inputDir.listFiles();

			for (File artcleFolder : Articlefiles) { // loop for iterate all XML files

				LOGGER.debug("Aricle folder: " + artcleFolder);
				if (artcleFolder.isDirectory()) {
					File[] files1 = artcleFolder.listFiles();
					for (File articleFile : files1) {
						if (articleFile.isFile() && articleFile.getName().endsWith(".xml")) {

							File filePath = articleFile;
							LOGGER.debug("Aricle files: " + filePath);
//	     				while (articleFile != null) {

							// read next line
							File fXmlFile = articleFile;
							Document doc;
							DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
							doc = dBuilder.parse(fXmlFile);
							doc.getDocumentElement().normalize();
							LOGGER.debug("Root element :" + doc.getDocumentElement().getNodeName());
							NodeList nList = doc.getElementsByTagName("manuscript");
							for (int temp = 0; temp < nList.getLength(); temp++) {

								Node nNode = nList.item(temp);

								LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

								if (nNode.getNodeType() == Node.ELEMENT_NODE) {

									Element eElement = (Element) nNode;
									ingestion.setAid(eElement.getElementsByTagName("id").item(0).getTextContent());
									ingestion.setArticle_doi(
											eElement.getElementsByTagName("doi").item(0).getTextContent());
									ingestion.setArticletype(
											eElement.getElementsByTagName("articletype").item(0).getTextContent());
									ingestion.setArticletitle(
											eElement.getElementsByTagName("title").item(0).getTextContent());
									ingestion.setFile(
											eElement.getElementsByTagName("articlefile").item(0).getTextContent());
									String[] data = eElement.getElementsByTagName("id").item(0).getTextContent()
											.split("_");
									String roleId = data[0].trim();
									ingestion.setJournalAbbrName(roleId);
									LOGGER.debug("Staff id : " + eElement.getAttribute("id"));
									LOGGER.debug("Article ID : "
											+ eElement.getElementsByTagName("id").item(0).getTextContent());
									LOGGER.debug("Article title : "
											+ eElement.getElementsByTagName("title").item(0).getTextContent());
									LOGGER.debug("Article type : "
											+ eElement.getElementsByTagName("articletype").item(0).getTextContent());
									LOGGER.debug("Article file : "
											+ eElement.getElementsByTagName("articlefile").item(0).getTextContent());
									LOGGER.debug(
											"DOI : " + eElement.getElementsByTagName("doi").item(0).getTextContent());
								}
							}
							File f = new File(artcleFolder + File.separator + ingestion.getFile());
							Journal journal1 = journalService.getJournalbyabbrname(ingestion.getJournalAbbrName());
							if (journal1 != null && f.exists()) {
								ArticleDetail articleDetail = new ArticleDetail();
								articleDetail.setArticle_doi(ingestion.getArticle_doi());
								articleDetail.setAid(ingestion.getAid());
								articleDetail.setJournalId(journal1.getJournalId());
								articleDetail.setPublisher_id(142);
								articleDetail.setArticle_type_cd(ingestion.getArticletype());
								articleDetail.setArticle_title(ingestion.getArticletitle());
								int aId = articleService.saveArticle(articleDetail);

								Journal journal = new Journal();
								journal = journalService.getjournalbyId(articleDetail.getJournalId());
								// String f =artcleFolder+ingestion.getFile();
								String attachment = ingestion.getFile();

								if (!attachment.isEmpty()) {
									try {
										byte[] bytes = attachment.getBytes();
										if (!new File(journalPath + File.separator
												+ journal.getJournalAbbrName().toLowerCase() + File.separator
												+ articleDetail.getArticle_doi() + File.separator + "Origin")
														.exists()) {
											new File(journalPath + File.separator
													+ journal.getJournalAbbrName().toLowerCase() + File.separator
													+ articleDetail.getArticle_doi() + File.separator + "Origin")
															.mkdirs();
										}
										Path path = Paths.get(journalPath + File.separator
												+ journal.getJournalAbbrName().toLowerCase() + File.separator
												+ articleDetail.getArticle_doi() + File.separator + "Origin"
												+ File.separator + attachment);
										Files.write(path, bytes);

										String filename = journalPath + File.separator
												+ journal.getJournalAbbrName().toLowerCase() + File.separator
												+ articleDetail.getArticle_doi() + File.separator + "Origin"
												+ File.separator + attachment;
										LOGGER.debug("filename " + filename);
										taskSchedular(aId, filename);
										list.add("In journal " + ingestion.getJournalAbbrName() + " " + "files "
												+ ingestion.getFile() + " " + " is  uploaded in folder "
												+ ingestion.getAid());
										LOGGER.debug("dgf95yw1f");
										map.put("error", list);
										LOGGER.debug("lis :" + list.toString());
										model.put("map", map);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}

							} else {
								LOGGER.debug("data is incomplete..");
							}
							LOGGER.debug("final" + ingestion);

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "ingestion";
	}

	@Scheduled(fixedDelay = 300000)
	public void integration() throws AddressException, MessagingException {
////		SFTPinJava.filCopyScheduled();
//		SFTPinJava dftp= new SFTPinJava();
//		dftp.filCopyScheduled();
//		
	LOGGER.info("uniprr or medknow file Integration Started  :: " + Calendar.getInstance().getTime());
		EMFileRInjection dftp = new EMFileRInjection();
		dftp.EMfilCopyScheduled(InputDIRLocation, OutputDIRLocation, InputPath, sftpHost, sftpUser, sftpPassword,
				sftpPort);
		LOGGER.info("uniprr or medknow file Integration Started  :: " + Calendar.getInstance().getTime());
		Map<String, String> errorMap = new HashMap<String, String>();
		Map<String, List<?>> succEmailMap = new HashMap<String, List<?>>();
		String jornname = "";
		File inputDir = new File(InputPath);// Directory where XML file exists
		File outDir = new File(OutputPath);// Directory where XML file exists
		File[] Articlefiles = inputDir.listFiles();

		if (inputDir.exists() && outDir.exists()) {
			for (File artcleFolder : Articlefiles) {
				UnZip.unZipIt(artcleFolder.getAbsolutePath(), artcleFolder.getName(), OutputPath);

			}

			File[] outArticlefiles = outDir.listFiles();
			for (File artcleFolder : outArticlefiles) {
				boolean ArticleIngestionFlag = false;
				LOGGER.info("Aricle folder: " + artcleFolder);
				if (artcleFolder.isDirectory()) {
					File[] files1 = artcleFolder.listFiles();
					String file[] = artcleFolder.getName().split("_");
					String Journalabbev = file[0].toLowerCase();
					Article article = null;
//articleFile is in xml input
					for (File articleFile : files1) {
						if (articleFile.isFile() && articleFile.getName().endsWith(".xml")) {
							try {
								String temppath = OutputPath + File.separator + "temp" + articleFile.getName();
								String temppathBeautify = OutputPath + File.separator + "tempBeautify"
										+ articleFile.getName();
								String content = FileUtils.readFileToString(articleFile);
								File tempfile = new File(temppath);
								char quot = '"';
								String rep = "<?xml version=" + quot + "1.0" + quot + " " + "encoding=" + quot + "UTF-8"
										+ quot + "?>";
								System.out.println(rep);
								FileUtils.writeStringToFile(tempfile, content.replace("contrubution", "contribution")
										.replace("</dates>", "<dates>   </dates>").replace(rep, " "));
								String temp = XmlBeautify.xmlBeautify(temppath, temppathBeautify);
								String filename[] = artcleFolder.getName().split("_");
								String uniprr = filename[filename.length - 1];
								String uniprr2 = filename[filename.length - 2];
								System.out.println("uniprr----------------->" + uniprr);
								if (uniprr.equalsIgnoreCase("UNIPRR") || uniprr2.equalsIgnoreCase("UNIPRR")) {
									// article = ParseXmlUniPRR.parseXMLMetadata(temp); not Beautify for uniprr
									article = ParseXmlUniPRR.parseXMLMetadata(temppath);
								} else {
									article = ParseXML.parseXMLMetadata(temp);
								}
								ArticleDetail articleDetails = articleService.findByAid(article.getId());
								if (articleDetails != null) {
//									mailservice.sendEmail("haramohan.nanda@digiscapetech.com",
//											"haramohan.nanda@digiscapetech.com", "Ingestion Error", "Artile Id :\r\n"
//													+ article.getId() + "\r\nArticle Name :\r\n" + article.getTitle());
									SendEmailUtility.mail(EmailEnum.to, "Ingestion Error",
											"Article ID :" + article.getId() + "\r\nArticle Name :" + article.getTitle()
													+ "\r\n Already  Exit in Unitouch" + "\r\n Thanks, UniTouch");
								} else {
									ArticleDetail articleDetail = new ArticleDetail();
									articleDetail.setAid(article.getId());
									articleDetail.setArticle_doi(article.getDoi());
									articleDetail.setArticle_type_cd(article.getArticletype());
									articleDetail.setArticle_title(article.getTitle());
									Journal journal = new Journal();
									journal = journalService.getJournalbyabbrname(Journalabbev);
									articleDetail.setJournalId(journal.getJournalId());
									jornname = journal.getJournalName();
									articleDetail.setJournal_issue_number(journal.getJournalIssn());
									articleDetail.setPublisher_id(142);
									articleDetail.setAccepted_date(article.getAcceptedDate());
									articleDetail.setKeywords(article.getKeywords());
									articleDetail.setPriority("Medium Priority");
									articleDetail.setWithdrawStatus("N");
									articleDetail.setSubmissionDate(article.getSubmissionDate());
									articleDetail.setWordCount(Integer.parseInt(article.getWordCount()));
									articleDetail.setCommentoForProduction(article.getCommentoForProduction());
									articleDetail.setReview(article.getReview());
									StringBuilder builderj = new StringBuilder();
									if (journal.getArticleWorkflowId() == 0) {
										LOGGER.info("Journal Name = " + journal.getJournalName() + ", journal Abbr = "
												+ journal.getJournalAbbrName().toLowerCase());
										LOGGER.info("error = " + "Please add a worklflow to this Journal "
												+ journal.getJournalAbbrName().toLowerCase());
										builderj.append("Journal Name = " + journal.getJournalName()
												+ ", journal Abbr = " + journal.getJournalAbbrName().toLowerCase());
										builderj.append("error = " + "Please add a worklflow to this Journal "
												+ journal.getJournalAbbrName().toLowerCase());
										/*
										 * mailservice.sendEmail("haramohan.nanda@digiscapetech.com",
										 * "haramohan.nanda@digiscapetech.com", "Ingestion Error", builderj.toString());
										 */
										SendEmailUtility.mail(EmailEnum.to, "Ingestion Error MK(Uniprr) journal worklflow not setup --  "+journal.getJournalName(), builderj.toString());
									} else {
										WorkflowTaskSeq workflowTaskSeq = workflowRoleService
												.getTaskId(journal.getArticleWorkflowId());

										int taskId = workflowTaskSeq.getTaskId();
										int aId = articleService.saveArticle(articleDetail);
										List<Attachment> attachments = article.getFiles();
										Iterator<Attachment> attachmentIterator = attachments.iterator();
										while (attachmentIterator.hasNext()) {
											Attachment attachment = attachmentIterator.next();
											FileVersion fileVersion = new FileVersion();
											fileVersion.setArticleId(aId);
											fileVersion.setJournalId(journal.getJournalId());
											fileVersion.setFileName(attachment.getImage_file_name());
											fileVersion.setFileType(attachment.getImage_type());
											fileVersion.setFileVersion(1);
											fileVersion.setTaskId(taskId);
											fileVersion.setFilePath(journalPath + File.separator + Journalabbev
													+ File.separator + article.getDoi() + File.separator + "Origin"
													+ File.separator + attachment.getImage_file_name());
											// fileVersion.setSize(new File(OutputPath + File.separator + ).length() /
											// 1024
											// + " kb");
											fileversionservice.saveFileVersion(fileVersion);
										}
										// for Qrcode
										FileVersion Qrcode = new FileVersion();
										Qrcode.setArticleId(aId);
										Qrcode.setJournalId(journal.getJournalId());
										Qrcode.setFileName(article.getQr_code());
//									String ftyep=article.getQr_code();
//									String f[]=ftyep.split(".");
										Qrcode.setFileType("Qrcode");
										Qrcode.setFileVersion(1);
										Qrcode.setTaskId(taskId);
										Qrcode.setFilePath(journalPath + File.separator + Journalabbev + File.separator
												+ article.getDoi() + File.separator + "Origin" + File.separator
												+ article.getQr_code());
										fileversionservice.saveFileVersion(Qrcode);

										// for articlefile

										FileVersion articlefile = new FileVersion();
										articlefile.setArticleId(aId);
										articlefile.setJournalId(journal.getJournalId());
										articlefile.setFileName(article.getArticleFile());
//									String ftyepe=article.getArticleFile();
//									String fa[]=ftyepe.split(".");
										articlefile.setFileType("articlefile ");
										articlefile.setFileVersion(1);
										articlefile.setTaskId(taskId);
										articlefile.setFilePath(journalPath + File.separator + Journalabbev
												+ File.separator + article.getDoi() + File.separator + "Origin"
												+ File.separator + article.getArticleFile());
										System.out.println(articlefile.toString());
										fileversionservice.saveFileVersion(articlefile);

										// firstpagefile
										FileVersion firstpagefile = new FileVersion();
										firstpagefile.setArticleId(aId);
										firstpagefile.setJournalId(journal.getJournalId());
										firstpagefile.setFileName(article.getFirstpagefile());
//									String ftypeff=article.getFirstpagefile();
//									String fff[]=ftypeff.split(".");
										firstpagefile.setFileType("First page file");
										firstpagefile.setFileVersion(1);
										firstpagefile.setTaskId(taskId);
										firstpagefile.setFilePath(journalPath + File.separator + Journalabbev
												+ File.separator + article.getDoi() + File.separator + "Origin"
												+ File.separator + article.getFirstpagefile());
										System.out.println(firstpagefile.toString());
										fileversionservice.saveFileVersion(firstpagefile);
										//
										FileVersion fileVersion = new FileVersion();
										fileVersion.setArticleId(aId);
										fileVersion.setJournalId(journal.getJournalId());
										fileVersion.setFileName(artcleFolder.getName() + ".zip");
										fileVersion.setFileType("zip");
										fileVersion.setFileVersion(1);
										fileVersion.setTaskId(taskId);
										fileVersion.setFilePath(journalPath + File.separator + Journalabbev
												+ File.separator + article.getDoi() + File.separator + "Origin"
												+ File.separator + artcleFolder.getName() + ".zip");
										// fileVersion.setSize(new File(OutputPath + File.separator + ).length() /
										// 1024
										// + " kb");
										fileversionservice.saveFileVersion(fileVersion);
										List<Author> author = article.getAuthor();
										Iterator<Author> authorI = author.iterator();
										while (authorI.hasNext()) {
											Author aad = authorI.next();
											AuthorArticleDetails aadt = new AuthorArticleDetails();
											aadt.setArticle_id(aId);
											aadt.seteMail(aad.getEmail());
											aadt.setfName(aad.getFname());
											aadt.setlName(aad.getLname());
											aadt.setmName(aad.getMname());
											aadt.setTitle(aad.getTitle());
											aadt.setIs_corresponding(aad.getIs_corresponding());
											aadt.setOrcid(aad.getOrcid());
											aadt.setAuthor_order(aad.getAuthor_order());
											aadt.setCopyright(aad.getCopyright_agreement());
											aadt.setCopyrightAgreementContent(aad.getCopyright_agreement_content());
											authorService.save(aadt);
										}
										if (uniprr.equalsIgnoreCase("UNIPRR")) {
											LOGGER.info("UNIPRR file in taskSchedular");
											String input = InputPath + File.separator + artcleFolder.getName() + ".zip";
											taskSchedular(aId, input);
											ArticleIngestionFlag = true;
										} else {
											LOGGER.info("jow file in ");
											boolean status = workflowTaskService
													.checkArticleTask(article.getCurrentPhase(), aId);
//											if (article.getCurrentPhase().equals("Published online (AoP)")) {
											if (status) {
												LOGGER.info("-----------jow  stage file-----> "
														+ article.getCurrentPhase());
												String input = InputPath + File.separator + artcleFolder.getName()
														+ ".zip";
												taskSchedular(aId, article.getCurrentPhase(), input);// api to ing
																										// article to
																										// prr
												ArticleIngestionFlag = false;// for file move
											} else {
												LOGGER.info("jow in 1st stage file taskSchedular");
												String input = InputPath + File.separator + artcleFolder.getName()
														+ ".zip";
												taskSchedular(aId, input);
												ArticleIngestionFlag = true;
											}
										}
										LOGGER.info("ArticleIngestionFlag :: true in -->" + ArticleIngestionFlag);
										// ArticleIngestionFlag = true;
										LOGGER.info("ArticleIngestionFlag :: true done --->" + ArticleIngestionFlag);
									}
								}
							} catch (JDOMException | IOException e) {
								ArticleIngestionFlag = false;

								LOGGER.info("Exception --->" + ArticleIngestionFlag);
								LOGGER.info("Error in parsing the XML:" + articleFile.getName() + " with exception "
										+ e.getLocalizedMessage());
								errorMap.put(articleFile.getName(), e.getLocalizedMessage());
							} catch (Exception e) {
								// TODO: handle exception
								ArticleIngestionFlag = false;
								// TODO Auto-generated catch block
								LOGGER.info("Exception --->" + ArticleIngestionFlag);
								LOGGER.info("Error in ingecting XML:" + articleFile.getName() + " with exception"
										+ e.getLocalizedMessage());
								errorMap.put(articleFile.getName(),
										e.getLocalizedMessage() + " message " + e.getCause());
							}

						}
					}

					if (ArticleIngestionFlag) {
						LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
						String copyPath = InputPath + File.separator + artcleFolder.getName() + ".zip";
						String SuccessPath = journalPath + File.separator + Journalabbev + File.separator
								+ article.getDoi() + File.separator + "Origin";

						String OutputFile = SuccessPath + File.separator + artcleFolder.getName() + ".zip";
						// mailset;
						succEmailMap.put(artcleFolder.getName(),
								EmunAticleStatus.fiststageMail(article.getTitle(), article.getId(), jornname));
						File tempFile = new File(copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(SuccessPath).exists()) {
									new File(SuccessPath).mkdirs();
									LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
									LOGGER.info("SuccessPath  ::: --->" + SuccessPath);
									LOGGER.info("tempFile  ::: --->" + tempFile);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile));
								LOGGER.info(temp + "<--move location <-----------------File moved Succesfull");
								LOGGER.info("temp ::: --->" + temp);
								UnZip.unZipIt(OutputFile, SuccessPath);
								LOGGER.info(article.getId()
										+ "<-------Unzip  Done<--------->OutputFile  and SuccessPath  is ::: --->"
										+ OutputFile + " ---- :" + SuccessPath);

							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info(e + "File Not moved Succesfull");
								LOGGER.info("IOException ::: --->" + e);
							}
						}
					} else {
						String copyPath = InputPath + File.separator + artcleFolder.getName() + ".zip";
						String OutputFile = ErrorPath + File.separator + artcleFolder.getName() + ".zip";
						Path ferrorPath = Paths.get(finalErrorPath + File.separator + artcleFolder.getName() + ".zip");
						String filename[] = artcleFolder.getName().split("_");
						String uniprr = filename[filename.length - 1];
						// String uniprr2 = filename[filename.length - 2];
						if (uniprr.equalsIgnoreCase("UNIPRR")) {
							OutputFile = ErrorPath + File.separator + artcleFolder.getName() + "_1" + ".zip";
							LOGGER.info("OutputFile---->" + OutputFile);
						}
						if (uniprr.equalsIgnoreCase("1")) {
							Integer index = Integer.parseInt(uniprr);
							StringBuilder builder = new StringBuilder();
							for (int i = 0; i < filename.length - 1; i++) {
								builder.append(filename[i] + "_");
							}
							builder.append(index + 1 + "");
							OutputFile = ErrorPath + File.separator + builder + ".zip";
							LOGGER.info("OutputFile---->" + OutputFile);
						}
						if (uniprr.equalsIgnoreCase("2")) {
							try {
								Path ftemp = Files.move(Paths.get(copyPath), Paths.get(ferrorPath.toString()),
										StandardCopyOption.REPLACE_EXISTING);
								LOGGER.info("ftemp-----file move at final folder--------->" + ftemp);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						File tempFile = new File(copyPath);
						LOGGER.info("else in ::: --->temp path" + tempFile + " ---- :copyPath------>" + copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(ErrorPath).exists()) {
									new File(ErrorPath).mkdirs();
									LOGGER.info("else in ErrorPath::: --->" + ErrorPath);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile),
										StandardCopyOption.REPLACE_EXISTING);
								LOGGER.info(temp + " File moved Succesfull to error folder");

							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info("else in IOException::: --->" + e);
							}
						}
					}
				}

			}
			File file = new File(OutputPath);
			try {
				FileUtils.cleanDirectory(file);
				LOGGER.info("try FileUtils.cleanDirectory(file) in file::: --->" + file);
			} catch (IOException e) {
				LOGGER.error("Error in deleting output folder");
			}
			if (!errorMap.isEmpty()) {
				LOGGER.info("Details of error after ingestion");
				LOGGER.info("Details of Success after ingestion");
				StringBuilder builder = new StringBuilder();
				StringBuilder sus = new StringBuilder();
				builder.append("Hi,");
				builder.append(System.lineSeparator());
				builder.append("Please find the error details for the ingestion of " + new Date());
				builder.append(System.lineSeparator());
				sus.append("Hi,");
				sus.append(System.lineSeparator());
				sus.append("Please find the Success details for the ingestion of " + new Date());
				sus.append(System.lineSeparator());
				for (Map.Entry<String, String> entry : errorMap.entrySet()) {
					builder.append("File Name = " + entry.getKey() + ", Error = " + entry.getValue());
					builder.append(System.lineSeparator());
					LOGGER.info("File Name = " + entry.getKey() + ", Error = " + entry.getValue());

				}
				for (Map.Entry<String, List<?>> suss : succEmailMap.entrySet()) {
					sus.append("File Name = " + suss.getKey() + ", Success = " + suss.getValue());
					sus.append(System.lineSeparator());
					LOGGER.info("File Name = " + suss.getKey() + ", Success = " + suss.getValue());

				}
				builder.append("Thanks, UniTouch");
				builder.append(System.lineSeparator());
				LOGGER.error(builder.toString());
				sus.append("Thanks, UniTouch");
				sus.append(System.lineSeparator());
				LOGGER.error(builder.toString());
				SendEmailUtility.mail(EmailEnum.to, "Ingestion Error", builder.toString());
				SendEmailUtility.mail(EmailEnum.to, "Ingestion", sus.toString());
				// mailservice.sendEmail("haramohan.nanda@digiscapetech.com",
				// "haramohan.nanda@digiscapetech.com","Ingestion Error", builder.toString());
			}
		} else {
			LOGGER.info("Error in finding input path " + inputDir.getAbsolutePath() + "or output path "
					+ outDir.getAbsolutePath());
		}
	}

	// for particular stage
	public void taskSchedular(int artId, String stageName, String artcleFolderame) {
		TaskDetails currentTask = null;
		if (stageName.equalsIgnoreCase("Published online (AoP)")) {
			currentTask = taskService.getTaskNameByName("Published_online_(AoP)");
		} else {
			String taskname = stageName.replace(" ", "_");
			taskname = taskname.replace("-", "_");
			currentTask = taskService.getTaskNameByName(taskname);
		}
		// String taskname = stageName.replace(" ", "_");
		TaskScheduler ts = new TaskScheduler();

		// TaskDetails currentTask = taskService.getTaskNameByName(taskname);

		LOGGER.debug("artID :" + artId);

		ArticleDetail articleDetail = articleService.findArticleDetailBy(artId);
		LOGGER.debug("articleController " + articleDetail);
		Journal journal = journalService.getjournalbyId(articleDetail.getJournalId());
		LOGGER.debug("journal :" + journal);
		CurrentArticleStatus currentArticleStatus = new CurrentArticleStatus();
		int wfid = journal.getArticleWorkflowId();
		// WorkflowTaskSeq workflowTaskSeq = workflowRoleService.getTaskId(wfid);
		// int taskId = workflowTaskSeq.getTaskId();
		int taskID = currentTask.getId();
		LOGGER.debug("Taskid: " + taskID);
		currentArticleStatus.setTask_id(taskID);
		currentArticleStatus.setArticle_id(artId);
		articleService.saveCurrentArticleStatus(currentArticleStatus);
		currentArticleStatus.setArticle_id(artId);
		List<WorkflowTaskSeq> workflowTaskSeqlist = workflowTaskService.workflowTaskSeqlist(wfid);

		// List<WorkflowTaskSeq> finallist = new ArrayList<WorkflowTaskSeq>();
		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskID, wfid); // current task
		WorkflowTaskSeq workflowpre = workflowTaskService.getNextTaskIdBy(workflowTaskSeq.getSequence() - 1, wfid);// prev
																													// next
																													// id
		Path destinationPath = Paths
				.get(journalPath + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator
						+ workflowpre.getTask().getTaskName().replace(' ', '_') + File.separator);
		System.out.println(destinationPath.toString());
		Integer preTaskSeq = workflowTaskSeq.getSequence() - 1; // one step back
		Integer currentTaskSeq = workflowTaskSeq.getSequence();
		List<WorkflowTaskSeq> uu = (List<WorkflowTaskSeq>) workflowTaskService.workflowTaskSeqlist(wfid);
		final String SFTPHOST = sftpHost;
		final String SFTPUSER = sftpUser;
		// final char s = '"';
		final String SFTPPASS = sftpPassword;

		AutoCompleteScheduler.fileCopyToClientLocation(articleDetail, journal, SFTPHOST, SFTPUSER, SFTPPASS, uu,
				artcleFolderame, currentTask.getTaskName());
		Iterator<WorkflowTaskSeq> iterator = uu.iterator();
		Date name;
		Date name1 = null;
		Date name2 = null;
		Integer counter = 0;
		while (iterator.hasNext()) {
			name2 = name1;
			WorkflowTaskSeq producationTrackers = iterator.next();

			int Tat = producationTrackers.getTat();
			TaskDetails task = producationTrackers.getTask();

			/*
			 * Task MkDir
			 */
			try {

				if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
						+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
								.exists()) {
					new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
							+ articleDetail.getArticle_doi() + File.separator + task.getTaskName().replace(' ', '_'))
									.mkdirs();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			int day = 0;
			// day = (Tat / 8); // 8 hr = 1 day
			day = Tat; // new add on 04/07/2020
			// int hours = Tat % 8; // cmnt on 04/072020
			/*
			 * if(hours>0) { day =day+1; }
			 */
			int taskid = producationTrackers.getTaskId();
			Date dd = null;
			if (name2 == null) {
				dd = ts.setSch_start_time(new Date());
			} else {
				dd = name2;
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dd);
			Calendar dateCal = Calendar.getInstance();
			dateCal.setTime(dd);
			LocalDate result = LocalDate.now();
			int addedDays = 0;
			int c = 0;
			while (addedDays < day) {
				result = result.plusDays(1);

				if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
					addedDays++;
				}
				c++;
			}
			dateCal.add(dateCal.DATE, c);
			Date dc = dateCal.getTime();
			name = dc;
			name1 = name;

			TaskScheduler tschedule = new TaskScheduler();
			tschedule.setArticle_id(artId);
			tschedule.setWorkflow_id(wfid);
			tschedule.setTask_id(taskid);
			tschedule.setTask_assigned_date(new Date());
			tschedule.setTask_due_date(new Date());
			tschedule.setSch_start_time(dd);
			tschedule.setSch_end_time(dc);
			tschedule.setAssign_back_count(0);
			tschedule.setCreated_date(new Date());
			// 8<=9
			if (currentTaskSeq <= counter) {
				if (counter.equals(currentTaskSeq.intValue())) {
					ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
							(wfid), (articleDetail.getJournalId()), (producationTrackers.getRoleId()),
							producationTrackers.getTaskId());

					LOGGER.info("WorkflowTaskSeq  Yet-to-Start------->" + producationTrackers);
					tschedule.setUser_id(manageJournalWorkflow.getUser_id());
					tschedule.setTask_status("Yet-to-Start");
				} else {
					LOGGER.info("WorkflowTaskSeq  Yet-to-Start------->" + producationTrackers);
					tschedule.setTask_status("Yet-to-Start");
				}
			} else {
				LOGGER.info("WorkflowTaskSeq  Skiped" + EmunAticleStatus.ArticleStatus.Skipped + "------->"
						+ producationTrackers);
				ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby((wfid),
						(articleDetail.getJournalId()), (producationTrackers.getRoleId()),
						producationTrackers.getTaskId());
				tschedule.setUser_id(manageJournalWorkflow.getUser_id());
				tschedule.setTask_status("Skiped");
				tschedule.setTask_est_time_from(new Date());
				tschedule.setTask_est_time_end(new Date());
			}
			tschedule.setRunId(0);
			taskService.savetakSchedulars(tschedule);

			LOGGER.debug(tschedule.toString());
			counter++;
		}

		Path startpath = Paths
				.get(journalPath + File.separator + articleDetail.getJournals().getJournalAbbrName().toLowerCase()
						+ File.separator + articleDetail.getArticle_doi() + File.separator + "Origin" + File.separator);
		// taskID = workflowTaskSeq.getTaskId();
		LOGGER.info(workflowTaskSeq.getSequence() + "<---currentTaskSequence ---- start path File--->"
				+ startpath.toString());
		String copyPath = InputPath + File.separator + artcleFolderame + ".zip";
		String SuccessPath = journalPath + File.separator
				+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + File.separator
				+ articleDetail.getArticle_doi() + File.separator + "Origin";

		String OutputFile = SuccessPath + File.separator + artcleFolderame + ".zip";
		String des = destinationPath + File.separator + artcleFolderame + ".zip";
		File tempFile = new File(copyPath);
		if (tempFile.exists()) {
			try {
				if (!new File(SuccessPath).exists()) {
					new File(SuccessPath).mkdirs();
					// LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
					LOGGER.info("SuccessPath  ::: --->" + SuccessPath);
					LOGGER.info("tempFile  ::: --->" + tempFile);
				}

				Path temp = Files.copy(Paths.get(copyPath), Paths.get(OutputFile));
				Path currentPathTemp = Files.move(Paths.get(copyPath), Paths.get(des));
				System.out.println("des----->" + des.toString());
				LOGGER.info(temp + "File moved Succesfull");
				LOGGER.info("temp ::: --->" + temp);
				LOGGER.info("currentPathTemp------->" + currentPathTemp);
				UnZip.unZipIt(OutputFile, SuccessPath);
				LOGGER.info("OutputFile  and SuccessPath  is ::: --->" + OutputFile + " ---- :" + SuccessPath);

			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.info(e + "File Not moved Succesfull");
				LOGGER.info("IOException ::: --->" + e);
			}

		}

		List<AuthorArticleDetails> authorDetail = authorService.fileByArticleId(articleDetail.getArticle_id());
		ArticleInfoAPI aip = new ArticleInfoAPI(authorDetail, articleDetail, journal, journal.getJournalAbbrName());
		ArticleRestApiUniprr aru = new ArticleRestApiUniprr();
		aru.sendArticleInfo(aip);
		LOGGER.info(" set for---->api" + aip);
		// EmailSetup es = new EmailSetup();
//		boolean status = es.emailSetupforDone(articleDetail.getArticle_id(), journal.getJournalId(),
//				journal.getArticleWorkflowId(), taskID);
		EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(journal.getJournalId(),
				journal.getArticleWorkflowId(), taskID);
		if (emailJournalWorkflow != null) {
			EmailTrigger trigger = new EmailTrigger();
			trigger.setArticleId(articleDetail.getArticle_id());
			trigger.setTaskId(taskID);
			trigger.setEtSubject("" + emailJournalWorkflow.getEmailTemp().getToSubject());
			trigger.setEtBody("" + emailJournalWorkflow.getEmailTemp().getEditorData());
			trigger.setEtTo(emailJournalWorkflow.getTo().toString());
			trigger.setEtBcc("" + emailJournalWorkflow.getBcc());
			trigger.setEtCc("" + emailJournalWorkflow.getCc());
			if (emailJournalWorkflow.getEmailTemp().getFinishBody() != null) {
				trigger.setFinishBody("" + emailJournalWorkflow.getEmailTemp().getFinishBody());
			}
			if (emailJournalWorkflow.getEmailTemp().getFinishSubject() != null) {
				trigger.setFinishSubject("" + emailJournalWorkflow.getEmailTemp().getFinishSubject());
			}
			if (emailJournalWorkflow.getEmailTemp().getReplySubject() != null) {
				trigger.setReplySubject("" + emailJournalWorkflow.getEmailTemp().getReplySubject());
			}
			if (emailJournalWorkflow.getEmailTemp().getReplyBody() != null) {
				trigger.setReplyBody("" + emailJournalWorkflow.getEmailTemp().getReplyBody());
			}
			if (emailJournalWorkflow.getNextUserid() != null) {
				trigger.setNextUser(emailJournalWorkflow.getNextUserid().toString());
			}
			if (emailJournalWorkflow.getPreUserid() != null) {
				trigger.setPreUser(emailJournalWorkflow.getPreUserid().toString());
			}
			if (emailJournalWorkflow.getPreTaskid() != null) {
				trigger.setPreTaskid(emailJournalWorkflow.getPreTaskid());
			}
			if (emailJournalWorkflow.getNextTaskid() != null) {
				trigger.setNextTaskid(emailJournalWorkflow.getNextTaskid());
			}
			if (emailJournalWorkflow.getPreUserid() != null) {
				trigger.setPreUserid(emailJournalWorkflow.getPreUserid());
			}
			if (emailJournalWorkflow.getNextUserid() != null) {
				trigger.setNextUserid(emailJournalWorkflow.getNextUserid());
			}
			trigger.setIsActive(0);
			trigger.setCreatedAt(new Date());
			trigger.setCreatedBy("System");
			emailTriggerService.save(trigger);
		} else {
			LOGGER.info("Email template is not set");
			System.out.println("Email template is not set");

		}
		// LOGGER.info("mail temp set for---->status" + status);
	}

	///////// EM ingetion code

	@Scheduled(fixedRate = 500000)
	public void EMFileRInjection() throws JDOMException, AddressException, MessagingException {
		EMFileRInjection dftp = new EMFileRInjection();
		dftp.EMfilCopyScheduled(EmInputDIRLocation, EmOutputDIRLocation, InputEMPath, sftpHost, sftpUser, sftpPassword,
				sftpPort);
		System.out.println("fixed " + new Date());
//			SFTPinJava dftp= new SFTPinJava();
//			dftp.filCopyScheduled();
		LOGGER.info("Integration Started  for EMFileRInjection:: " + Calendar.getInstance().getTime());
		Map<String, String> errorMap = new HashMap<String, String>();
		File inputDir = new File(InputEMPath);// Directory where XML file exists
		File outDir = new File(OutputEMPath);// Directory where XML file exists
		File[] Articlefiles = inputDir.listFiles();

		if (inputDir.exists() && outDir.exists()) {
			for (File artcleFolder : Articlefiles) {
				UnZip.unZipIt(artcleFolder.getAbsolutePath(), artcleFolder.getName(), OutputEMPath);

			}

			File[] outArticlefiles = outDir.listFiles();
			for (File artcleFolder : outArticlefiles) {
				boolean ArticleIngestionFlag = false;
				LOGGER.info("Aricle folder: " + artcleFolder);
				if (artcleFolder.isDirectory()) {
					File[] files1 = artcleFolder.listFiles();
					String file[] = artcleFolder.getName().split("_");
					String Journalabbev = file[0].toLowerCase();
					String aid = "";
					// Article article = null;
					com.digi.unitouch.em.Meta.Article articleMeta = new com.digi.unitouch.em.Meta.Article();
					XStream xstream = createObjectXstream();

					for (File articleFile : files1) {
						if (articleFile.isFile() && articleFile.getName().endsWith(".xml")) {
							try {
								String temppath = OutputEMPath + File.separator + "temp" + articleFile.getName();
								// String temppathBeautify = OutputEMPath + File.separator + "tempBeautify"
								// + articleFile.getName();
								String content = FileUtils.readFileToString(articleFile);
								File tempfile = new File(temppath);
								char quot = '"';
								String rep = "<!DOCTYPE article SYSTEM " + quot + "JATS-archivearticle1-mathml3.dtd"
										+ quot + ">";
								FileUtils.writeStringToFile(tempfile, content.replace(rep, " "));
								System.out.println(rep);
								xstream.fromXML(tempfile, articleMeta);
								System.out.println("hi");
								System.out.println(articleMeta.toString());
								aid = articleMeta.getFront().getArticleMeta().getArticleId().get(0).getValue();

								ArticleDetail articleDetails = articleService.findByAid(aid);
								if (articleDetails != null) {
									SendEmailUtility.mail(EmailEnum.to, "Ingestion Error EM", "Article ID :"
											+ articleMeta.getFront().getArticleMeta().getArticleId().get(0).getValue()
											+ "\r\nArticle Name :"
											+ articleMeta.getFront().getArticleMeta().getTitleGroup().getArticletitle()
											+ "\r\n Already  Exists in Unitouch" + "\r\n Thanks, UniTouch Team");
								} else {
									Journal journal = new Journal();
									journal = journalService.getJournalbyabbrname(Journalabbev);
									ArticleDetail articleDetail = new ArticleDetail();
									articleDetail.setAid(
											articleMeta.getFront().getArticleMeta().getArticleId().get(0).getValue());
									articleDetail.setArticle_doi(journal.getDoiPrefix() + Journalabbev + "." + aid);
									articleDetail.setArticle_type_cd(articleMeta.getFront().getArticleMeta()
											.getArticlecategories().getSubjGroup().get(0).getSubject());
									articleDetail.setArticle_title(
											articleMeta.getFront().getArticleMeta().getTitleGroup().getArticletitle());

									articleDetail.setJournalId(journal.getJournalId());
									articleDetail.setJournal_issue_number(journal.getJournalIssn());
									articleDetail.setPublisher_id(142);
									List<com.digi.unitouch.em.Meta.Date> date = articleMeta.getFront().getArticleMeta()
											.getHistory().getDate();

									for (com.digi.unitouch.em.Meta.Date dateType : date) {
										if (dateType.getDateType().contains("accepted")) {
											articleDetail.setAccepted_date(dateType.getDay() + "-" + dateType.getMonth()
													+ "-" + dateType.getYear());
										}

										if (dateType.getDateType().contains("received")) {
											articleDetail.setSubmissionDate(dateType.getDay() + "-"
													+ dateType.getMonth() + "-" + dateType.getYear());
										}

									}
									List<String> keyword = articleMeta.getFront().getArticleMeta().getKwdgroup()
											.getKwdgroup();
//										for (String string : keyword) {
//											articleDetail.setKeywords(string.);
//										}
									articleDetail.setKeywords(keyword.toString());
									articleDetail.setPriority("Medium Priority");
									articleDetail.setWithdrawStatus("N");
									// articleDetail.setSubmissionDate(keyword.getSubmissionDate());
									articleDetail.setCommentoForProduction("");
									StringBuilder builderj = new StringBuilder();
									if (journal.getArticleWorkflowId() == 0) {
										LOGGER.info("Journal Name = " + journal.getJournalName() + ", journal Abbr = "
												+ journal.getJournalAbbrName().toLowerCase());
										LOGGER.info("error = " + "Please add a worklflow to this Journal "
												+ journal.getJournalAbbrName().toLowerCase());
										builderj.append("Journal Name = " + journal.getJournalName()
												+ ", journal Abbr = " + journal.getJournalAbbrName().toLowerCase());

										/*
										 * mailservice.sendEmail("haramohan.nanda@digiscapetech.com",
										 * "haramohan.nanda@digiscapetech.com", "Ingestion Error", builderj.toString());
										 */
										SendEmailUtility
												.mailToCC(EmailEnum.to,
														"Ingestion Error EM journal worklflow not setup --  "
																+ journal.getJournalName(),
														builderj.toString(), EmailEnum.cc);
									} else {
										WorkflowTaskSeq workflowTaskSeq = workflowRoleService
												.getTaskId(journal.getArticleWorkflowId());

										int taskId = workflowTaskSeq.getTaskId();
										int aId = articleService.saveArticle(articleDetail);

										String copyPath = InputEMPath + File.separator + artcleFolder.getName()
												+ ".zip";

										// File target = new File(From.toString());
										// File[] target = artcleFolder.listFiles();
										// File[] target = artcleFolder.listFiles();
										for (File file2 : files1) {

											FileVersion fileVersion = new FileVersion();
											fileVersion.setArticleId(aId);
											fileVersion.setJournalId(journal.getJournalId());
											fileVersion.setFileName(file2.getName());
											// fileVersion.setFileType(file2.getImage_type());
											fileVersion.setFileVersion(1);
											fileVersion.setTaskId(taskId);
											fileVersion.setFilePath(journalPath + File.separator + Journalabbev
													+ File.separator + Journalabbev + aid + File.separator + "Origin"
													+ File.separator + file2.getName());
											// fileVersion.setSize(new File(OutputPath + File.separator + ).length() /
											// 1024
											// + " kb");
											fileversionservice.saveFileVersion(fileVersion);

										}

										FileVersion fileVersion = new FileVersion();
										fileVersion.setArticleId(aId);
										fileVersion.setJournalId(journal.getJournalId());
										fileVersion.setFileName(artcleFolder.getName() + ".zip");
										fileVersion.setFileType("zip");
										fileVersion.setFileVersion(1);
										fileVersion.setTaskId(taskId);
										fileVersion.setFilePath(journalPath + File.separator + Journalabbev
												+ File.separator + Journalabbev + aid + File.separator + "Origin"
												+ File.separator + artcleFolder.getName() + ".zip");
										fileversionservice.saveFileVersion(fileVersion);

//											List<Attachment> attachments = article.getFiles();
//											Iterator<Attachment> attachmentIterator = attachments.iterator();
//											while (attachmentIterator.hasNext()) {
//												Attachment attachment = attachmentIterator.next();
//												FileVersion fileVersion = new FileVersion();
//												fileVersion.setArticleId(aId);
//												fileVersion.setJournalId(journal.getJournalId());
//												fileVersion.setFileName(attachment.getImage_file_name());
//												fileVersion.setFileType(attachment.getImage_type());
//												fileVersion.setFileVersion(1);
//												fileVersion.setTaskId(taskId);
//												fileVersion.setFilePath(journalPath + File.separator + Journalabbev
//														+ File.separator + article.getDoi() + File.separator + "Origin"
//														+ File.separator + attachment.getImage_file_name());
//												// fileVersion.setSize(new File(OutputPath + File.separator + ).length() /
//												// 1024
//												// + " kb");
//												fileversionservice.saveFileVersion(fileVersion);
//											}
										List<Contrib> Contrib = articleMeta.getFront().getArticleMeta()
												.getContribGroup().getContrib();
										for (Contrib author : Contrib) {
											AuthorArticleDetails aadt = new AuthorArticleDetails();
											if (author.getContribType().contains("author")) {
												aadt.setIs_corresponding(author.getCorresp());
												aadt.setArticle_id(aId);
												aadt.seteMail(author.getEmail());
												Name authorName = author.getName();
												aadt.setfName(authorName.getGivenNames());
												aadt.setlName(authorName.getSurname());
												aadt.setmName("");
												aadt.setTitle(authorName.getPrefix());
												aadt.setOrcid("");
												// aadt.setAuthor_order(author.getRole().getContentType());
												aadt.setCopyright("NO");
												aadt.setCopyrightAgreementContent("");
												authorService.save(aadt);
											} else {
												LOGGER.info("editor info-->" + aadt.toString());
											}

										}

//											List<Author> author = article.getAuthor();
//											Iterator<Author> authorI = author.iterator();
//											while (authorI.hasNext()) {
//												Author aad = authorI.next();
//												AuthorArticleDetails aadt = new AuthorArticleDetails();
//												aadt.setArticle_id(aId);
//												aadt.seteMail(aad.getEmail());
//												aadt.setfName(aad.getFname());
//												aadt.setlName(aad.getLname());
//												aadt.setmName(aad.getMname());
//												aadt.setTitle(aad.getTitle());
//												aadt.setIs_corresponding(aad.getIs_corresponding());
//												aadt.setOrcid(aad.getOrcid());
//												aadt.setAuthor_order(aad.getAuthor_order());
//												aadt.setCopyright(aad.getCopyright_agreement());
//												aadt.setCopyrightAgreementContent(aad.getCopyright_agreement_content());
//												authorService.save(aadt);
//											}
										String input = InputEMPath + File.separator + artcleFolder.getName() + ".zip";
										taskSchedular(aId, input);
										ArticleIngestionFlag = true;
										LOGGER.info("ArticleIngestionFlag :: true in -->" + ArticleIngestionFlag);
										// ArticleIngestionFlag = true;
										LOGGER.info("ArticleIngestionFlag :: true done --->" + ArticleIngestionFlag);
									}
								}
							} catch (Exception e) {
								ArticleIngestionFlag = false;
								// TODO Auto-generated catch block
								LOGGER.info("Exception --->" + ArticleIngestionFlag);
								LOGGER.info("Error in ingecting XML:" + articleFile.getName() + " with exception"
										+ e.getLocalizedMessage());
								errorMap.put(articleFile.getName(),
										e.getLocalizedMessage() + " message " + e.getCause());
							}

						}
					}

					if (ArticleIngestionFlag) {
						LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
						String copyPath = InputEMPath + File.separator + artcleFolder.getName() + ".zip";
						String SuccessPath = journalPath + File.separator + Journalabbev + File.separator + Journalabbev
								+ aid + File.separator + "Origin";

						String OutputFile = SuccessPath + File.separator + artcleFolder.getName() + ".zip";

						File tempFile = new File(copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(SuccessPath).exists()) {
									new File(SuccessPath).mkdirs();
									LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
									LOGGER.info("SuccessPath  ::: --->" + SuccessPath);
									LOGGER.info("tempFile  ::: --->" + tempFile);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile));
								LOGGER.info(temp + "File moved Succesfull");
								LOGGER.info("temp ::: --->" + temp);
								UnZip.unZipIt(OutputFile, SuccessPath);
								LOGGER.info("OutputFile  and SuccessPath  is ::: --->" + OutputFile + " ---- :"
										+ SuccessPath);

							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info(e + "File Not moved Succesfull");
								LOGGER.info("IOException ::: --->" + e);
							}
						}
					} else {
						String copyPath = InputEMPath + File.separator + artcleFolder.getName() + ".zip";
						String OutputFile = ErrorEMPath + File.separator + artcleFolder.getName() + ".zip";
						File tempFile = new File(copyPath);
						LOGGER.info("else in ::: --->temp path" + tempFile + " ---- :copyPath------>" + copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(ErrorEMPath).exists()) {
									new File(ErrorEMPath).mkdirs();
									LOGGER.info("else in ErrorPath::: --->" + ErrorEMPath);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile),
										StandardCopyOption.REPLACE_EXISTING);
								LOGGER.info(temp + " File moved Succesfull to error folder");

							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info("else in IOException::: --->" + e);
							}
						}
					}
				}

			}
			File file = new File(OutputEMPath);
			try {
				FileUtils.cleanDirectory(file);
				LOGGER.info("try FileUtils.cleanDirectory(file) in file::: --->" + file);
			} catch (IOException e) {
				LOGGER.error("Error in deleting output folder");
			}
			if (!errorMap.isEmpty()) {
				LOGGER.info("Details of error after ingestion");
				StringBuilder builder = new StringBuilder();
				builder.append("Hi,");
				builder.append(System.lineSeparator());
				builder.append("Please find the error details for the ingestion of " + new Date());
				builder.append(System.lineSeparator());
				for (Map.Entry<String, String> entry : errorMap.entrySet()) {
					builder.append("File Name = " + entry.getKey() + ", Error = " + entry.getValue());
					builder.append(System.lineSeparator());
					LOGGER.info("File Name = " + entry.getKey() + ", Error = " + entry.getValue());

				}
				builder.append("Thanks, UniTouch");
				builder.append(System.lineSeparator());
				LOGGER.error(builder.toString());
				SendEmailUtility.mail(EmailEnum.to, "Ingestion Error", builder.toString());
				// mailservice.sendEmail("haramohan.nanda@digiscapetech.com",
				// "haramohan.nanda@digiscapetech.com","Ingestion Error", builder.toString());
			}
		} else {
			LOGGER.info("Error in finding input path " + inputDir.getAbsolutePath() + "or output path "
					+ outDir.getAbsolutePath());
		}

	}

	public static XStream createObjectXstream() {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(com.digi.unitouch.em.Meta.Article.class);
		xstream.processAnnotations(Front.class);
		xstream.registerConverter(new IssnConverter());
		xstream.registerConverter(new JournalIdConverter());
		xstream.registerConverter(new ArticleIdConverter());
		xstream.registerConverter(new ContribConverter());
		xstream.registerConverter(new SubjGroupConverter());
		xstream.registerConverter(new AffConverter());
		xstream.registerConverter(new AddrLineConverter());
		xstream.registerConverter(new DateConverter());
		xstream.registerConverter(new FigCountConverter());
		// xstream.registerConverter(new InstitutionIDConverter());
		// xstream.registerConverter(new RoleConverter());
		return xstream;
	}

//	@Scheduled(fixedRate = 9000000)
	@Scheduled(cron = "0 0 9 * * *")
	public void taskDoneScheduler() {
		if(unitouchScheduled=="ON") {
		LOGGER.info("------------------------------------------------------------------------------------------------");
		List<CurrentArticleStatus> currentArticle = articleService.getCurrentArticleList();
		for (int i = 0; i < currentArticle.size(); i++) {

			ArticleDetail articleDetail = articleService.findArticleDetailBy(currentArticle.get(i).getArticle_id());

			LOGGER.info("--------->Start file lookup in FTP --------->current articleDetail----------->"
					+ articleDetail.getArticle_title());
			LOGGER.info("----->current task Name----------->" + currentArticle.get(i).getTask().getTaskName());
			TaskScheduler taskscheduler = taskService.getRunId(currentArticle.get(i).getArticle_id(),
					currentArticle.get(i).getTask_id()); // currentTaskID
			WorkflowTaskSeq workflowTaskSeq = workflowTaskService.gettaskDetailsbyid(taskscheduler.getTask_id(),
					taskscheduler.getWorkflow_id());
			int nextTaskSequence = (workflowTaskSeq.getSequence() + 1);

			WorkflowTaskSeq workflowTaskSequ = workflowTaskService.getNextTaskIdBy(nextTaskSequence,
					taskscheduler.getWorkflow_id());
			if (workflowTaskSequ == null) {
				continue;
			}
			final String startFilepath = "//"+ "home"+"//"+ "Uni_SFTP" + "//"+ "Uni_SFTP" + "//" + "medknow" + "//"
					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + "//"
					+ taskscheduler.getTask().getTaskName().replace(' ', '_') + "//" + "output" + "//";

			final String endFileCopypath = "//"+ "home"+"//"+ "Uni_SFTP" + "//"+ "Uni_SFTP" + "//" + "medknow" + "//"
					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + "//"
					+ workflowTaskSequ.getTask().getTaskName().replace(' ', '_') + "//" + "input" + "//";

			final String InputServerPath = "//medknow" + "//"
					+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + "//"
					+ articleDetail.getArticle_doi() + "//" + taskscheduler.getTask().getTaskName().replace(' ', '_')
					+ "//";
			LOGGER.info("startFilepath-------" + startFilepath);
			LOGGER.info("endFileCopypath-------" + endFileCopypath);
			LOGGER.info("InputServerPath-------" + InputServerPath);
			FileLookupInSFTP ftp = new FileLookupInSFTP();
			boolean status = ftp.getFileName(startFilepath, endFileCopypath, InputServerPath, articleDetail.getAid(),
					sftpHost, sftpUser, sftpPassword, sftpPort);
			System.out.println("status------------------------------------------>" + status);
			if (status) {
				LOGGER.info("workflowTaskSequ----------->" + workflowTaskSequ.getTask().getTaskName() + " \n sn---->"
						+ workflowTaskSequ.getSequence());
				int nextTaskID = workflowTaskSequ.getTaskId();
				ManageJournalWorkflow manageJournalAuthor = manageJournalworkflowService.getdepartmentIdallby(
						(taskscheduler.getWorkflow_id()), (taskscheduler.getArticleDetail().getJournalId()),
						(workflowTaskSequ.getRole().getRoleID()), nextTaskID);

				if (manageJournalAuthor.getRole().getRoleID().equals(5)) {
					int uniprrStatus = 57;
					if (manageJournalAuthor.getTask_id() == 105936) {
						uniprrStatus = 62;
					}
					Path authorPath = Paths.get(journalPath + File.separator
							+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + File.separator
							+ articleDetail.getArticle_doi() + File.separator
							+ manageJournalAuthor.getTask().getTaskName().replace(' ', '_'));
					LOGGER.info("Stating Author Api and calling to uniprr-------In FTP-------> (role Name )"
							+ "----------> user ID" + taskscheduler.getUser_id());
					AuthorRestController ar = new AuthorRestController();
//					// String articleTaskID = "";
//					ManageJournalWorkflow manageJournalAuthor1 = manageJournalworkflowService.getdepartmentIdallby((workFlowID),
//							(JrID), (workflowTaskSequNext.getRole().getRoleID()), workflowTaskSequNext.getTaskId());
					TaskManagementVo taskInThisUser = taskManagementService
							.getspecificTask(manageJournalAuthor.getUser_id(), articleDetail.getArticle_id());
					LOGGER.info("taskInThisUser------in FTP------->" + taskInThisUser.toString());
					String pathTO = "http://unitouchcdn.digiscapetech.com" + File.separator
							+ articleDetail.getJournals().getJournalAbbrName().toLowerCase() + File.separator
							+ articleDetail.getArticle_doi() + File.separator
							+ manageJournalAuthor.getTask().getTaskName().replace(' ', '_');
					AuthorDataApiModel apimodel = ar.setCompleteddata(articleDetail.getAid(), uniprrStatus + "", pathTO,
							authorPath.toString(), taskInThisUser.getArticle_task_id().toString(),
							workflowTaskSequ.getFileType(), "Done By FTP");
					articleService.saveAuthorAPIData(apimodel);
					LOGGER.info("Author Api called------in FTP ------------>" + apimodel);
				} else {
					LOGGER.info("no Author role ");
				}

				LOGGER.info("manage task Name----In FTP--->" + manageJournalAuthor.getTask().getTaskName());
				CurrentArticleStatus currentArticleStatus = articleService
						.findCurrentArticleStatusBy(taskscheduler.getTask_id(), taskscheduler.getArticle_id());
				currentArticleStatus.setTask_id(nextTaskID);
				articleService.saveCurrentArticleTaskStatus(currentArticleStatus);
				taskscheduler.setTask_status("Completed");
				taskscheduler.setTask_est_time_end(new Date());
				taskService.saveTaskSchedulerStatus(taskscheduler);
				LOGGER.info("taskscheduler aid-------IN FTP--------->" + taskscheduler.getArticleDetail().getAid());
				TaskScheduler taskPoolUpdate = taskService.getRunId(taskscheduler.getArticle_id(),
						workflowTaskSequ.getTaskId());
				taskPoolUpdate.setTask_status("Yet-to-Start");
				taskPoolUpdate.setUser_id(manageJournalAuthor.getUser_id());
				taskPoolUpdate.setTask_est_time_from(new Date());
				taskService.saveTaskSchedulerStatus(taskPoolUpdate);
				LOGGER.info("task ftp Update-------Next Task------>" + taskPoolUpdate.getTask().getTaskName() + ""
						+ manageJournalAuthor.getUsers().getUsername());
				EmailJournalWorkflow emailJournalWorkflow = emailJournalWorkflowService.findByejwt(
						articleDetail.getArticle_id(), taskscheduler.getWorkflow_id(), taskscheduler.getTask_id());
				if (emailJournalWorkflow != null) {
					EmailTrigger trigger = new EmailTrigger();
					trigger.setArticleId(articleDetail.getArticle_id());
					trigger.setTaskId(taskscheduler.getTask_id());
					trigger.setEtSubject("" + emailJournalWorkflow.getEmailTemp().getToSubject());
					trigger.setEtBody("" + emailJournalWorkflow.getEmailTemp().getEditorData());
					trigger.setEtTo(emailJournalWorkflow.getTo().toString());
					trigger.setEtBcc("" + emailJournalWorkflow.getBcc());
					trigger.setEtCc("" + emailJournalWorkflow.getCc());
					if (emailJournalWorkflow.getEmailTemp().getFinishBody() != null) {
						trigger.setFinishBody("" + emailJournalWorkflow.getEmailTemp().getFinishBody());
					}
					if (emailJournalWorkflow.getEmailTemp().getFinishSubject() != null) {
						trigger.setFinishSubject("" + emailJournalWorkflow.getEmailTemp().getFinishSubject());
					}
					if (emailJournalWorkflow.getEmailTemp().getReplySubject() != null) {
						trigger.setReplySubject("" + emailJournalWorkflow.getEmailTemp().getReplySubject());
					}
					if (emailJournalWorkflow.getEmailTemp().getReplyBody() != null) {
						trigger.setReplyBody("" + emailJournalWorkflow.getEmailTemp().getReplyBody());
					}
					if (emailJournalWorkflow.getNextUserid() != null) {
						trigger.setNextUser(emailJournalWorkflow.getNextUserid().toString());
					}
					if (emailJournalWorkflow.getPreUserid() != null) {
						trigger.setPreUser(emailJournalWorkflow.getPreUserid().toString());
					}
					if (emailJournalWorkflow.getPreTaskid() != null) {
						trigger.setPreTaskid(emailJournalWorkflow.getPreTaskid());
					}
					if (emailJournalWorkflow.getNextTaskid() != null) {
						trigger.setNextTaskid(emailJournalWorkflow.getNextTaskid());
					}
					if (emailJournalWorkflow.getPreUserid() != null) {
						trigger.setPreUserid(emailJournalWorkflow.getPreUserid());
					}
					if (emailJournalWorkflow.getNextUserid() != null) {
						trigger.setNextUserid(emailJournalWorkflow.getNextUserid());
					}
					trigger.setIsActive(0);
					trigger.setCreatedAt(new Date());
					trigger.setCreatedBy(manageJournalAuthor.getUsers().getUsername());
					emailTriggerService.save(trigger);
				} else {
					LOGGER.info("Email template is not set");
				}

			} else {
				LOGGER.info("------------------------End----No file found-----------------------");
			}
		}
		}else {
			LOGGER.info("unitouchScheduled Status -------------->"+unitouchScheduled);
		}
	}

	@Scheduled(cron = "0 2 * ? * *")
	public void fileMove() {
		LOGGER.info(">-----------------------------inside file move---------------------------<");
		File target = new File(ErrorPath);
		String fileName = "";
		File[] listOfFiles = target.listFiles();
		if (listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					LOGGER.info("---------------------->fileMove----------------> " + listOfFiles[i].getName());
					fileName = listOfFiles[i].getName();
					LOGGER.info("------------------->File name<------------------>" + fileName);
					Path whereTOStart = Paths.get(ErrorPath + File.separator + fileName);
					Path whereTOEnd = Paths.get(InputPath + File.separator + fileName);
					Path ferrorPath = Paths.get(finalErrorPath + File.separator + fileName);

					try {
						boolean fileStatus = FtpFileCopy.fileCopyToClientLocation(whereTOStart.toString(),
								JournalErrorDIRLocation + fileName, sftpHost, sftpUser, sftpPassword);
						LOGGER.info("file server copy----" + JournalErrorDIRLocation + fileName + "-------------------"
								+ fileStatus);
						Path temp = Files.copy(whereTOStart, whereTOEnd, StandardCopyOption.REPLACE_EXISTING);
						LOGGER.info("fileMove path----------->-temp--------->" + temp);
						Path finalError = Files.move(whereTOStart, ferrorPath, StandardCopyOption.REPLACE_EXISTING);
						LOGGER.info("fileMove path----------->-finalError--------->" + finalError);
					} catch (IOException e) {
						LOGGER.info("IOException--->" + e);
					}
				} else if (listOfFiles[i].isDirectory()) {
					LOGGER.info("fileMove Directory " + listOfFiles[i].getName());
				}
			}
		}
		LOGGER.info(">-----------------------------End file move---------------------------<");
	}

	@GetMapping("/cronPage")
	public String cronPage(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.info(">--------cron List------" + name);
		Map<String, String> cronlist = new HashMap<String, String>();
		cronlist.put("startTaskScheduler", "FTP Task Completion");
		cronlist.put("ingestionFileMove", " File Move");
		cronlist.put("startEMFileRInjection", " EM-Injection Service");
		cronlist.put("startIntegration", " Injection-Service");
		cronlist.put("articleMailService", " Article Mail Service");
		cronlist.put("issueMailService", "Issue MailService");
		model.put("cronlist", cronlist);
		return "cronList";
	}

	@GetMapping("/issueMailService")
	public ResponseEntity<ApplicationResponse> issueMailService() {
		LOGGER.info(">-----------------------------Start issueMailService ---------------------------<");
		schedulerMail.sendMailJobForIssue();

		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("Article Mail issueMailService");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End issueMailService ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("/articleMailService")
	public ResponseEntity<ApplicationResponse> articleMailService() {
		LOGGER.info(">-----------------------------Start articleMailService ---------------------------<");
		schedulerMail.sendMailJob();
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("Article Mail Service");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End articleMailService ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("/startTaskScheduler")
	public ResponseEntity<ApplicationResponse> startTaskScheduler() {
		LOGGER.info(">-----------------------------Start Task Scheduler ---------------------------<");
		taskDoneScheduler();
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("End Task Scheduler");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End Task Scheduler ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("/ingestionFileMove")
	public ResponseEntity<ApplicationResponse> ingestionFileMove() {
		LOGGER.info(">-----------------------------Start ingestionFileMove ---------------------------<");
		fileMove();
		LOGGER.info(">-----------------------------End ingestionFileMove ---------------------------<");
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("Ingestion File Move");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End ingestionFileMove ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("/startEMFileRInjection")
	public ResponseEntity<ApplicationResponse> startEMFileRInjection() {
		LOGGER.info(">-----------------------------Start EMFileRInjection ---------------------------<");
		try {
			EMFileRInjection();
		} catch (Exception e) {
			LOGGER.error(">-------Got----------------Exception---->" + e);
		}
		LOGGER.info(">-----------------------------End EMFileRInjection ---------------------------<");
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("EMFileRInjection");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End EMFileRInjection ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("/startIntegration")
	public ResponseEntity<ApplicationResponse> startIntegration() {
		LOGGER.info(">-----------------------------Start Medknow Integration ---------------------------<");
		try {
			integration();
		} catch (Exception e) {
			LOGGER.error(">-------Got----------------Exception---->" + e);
		}
		LOGGER.info(">-----------------------------End Medknow Integration ---------------------------<");
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("Medknow Integration");
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End MedknowIntegration ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("synWithUniprr-{aid}")
	public ResponseEntity<ApplicationResponse> synWithUniprr(@PathVariable("aid") String aid, ModelMap model) {
		LOGGER.info("-----------------------------> uniprr api for synWithUniprr " + aid);
		ArticleDetail articleDetail = articleService.findByAid(aid);
		List<AuthorArticleDetails> authorDetail = authorService.fileByArticleId(articleDetail.getArticle_id());
		ArticleInfoAPI aip = new ArticleInfoAPI(authorDetail, articleDetail, articleDetail.getJournals(),
				articleDetail.getJournals().getJournalAbbrName());
		ArticleRestApiUniprr aru = new ArticleRestApiUniprr();
		aru.sendArticleInfo(aip);
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		applicatonResponse.setPayload("------------------------>synWithUniprr---------------->" + aid);
		applicatonResponse.setMessage("OK");
		LOGGER.info(">-----------------------------End synWithUniprr ---------------------------<");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
	}

	@Scheduled(fixedRate = 900000)
	public void SOFileRInjection() {
		if(unitouchScheduled=="ON") {
		EMFileRInjection dftp = new EMFileRInjection();
		dftp.EMfilCopyScheduled(SOInputDIRLocation, SOOutputDIRLocation, 
				InputSOPath,sftpHost,sftpUser,sftpPassword,sftpPort);
		System.out.println("fixed " + new Date());
//			SFTPinJava dftp= new SFTPinJava();
//			dftp.filCopyScheduled();
		LOGGER.info("Integration Started  for EMFileRInjection:: " + Calendar.getInstance().getTime());
		Map<String, String> errorMap = new HashMap<String, String>();
		File inputDir = new File(InputSOPath);// Directory where XML file exists
		File outDir = new File(OutputSOPath);// Directory where XML file exists
		File[] Articlefiles = inputDir.listFiles();

		if (inputDir.exists() && outDir.exists()) {
			for (File artcleFolder : Articlefiles) {
				Path source = Paths.get(artcleFolder.getAbsolutePath());
				Path target = Paths.get(OutputSOPath);
				// UnZip.unZipIt(artcleFolder.getAbsolutePath(), artcleFolder.getName(),
				// OutputEMPath);
				try {
					ZipFileUnZip.unzipFolder(source, target);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			File[] outArticlefiles = outDir.listFiles();
			for (File artcleFolder : outArticlefiles) {
				boolean ArticleIngestionFlag = false;
				LOGGER.info("Aricle folder: " + artcleFolder);
				if (artcleFolder.isDirectory()) {
					File[] files1 = artcleFolder.listFiles();
					String file[] = artcleFolder.getName().split("-");
					String Journalabbev = file[0].toLowerCase();
					String aid = "";
					String adoi = "";
					int aId = 0;
					int taskId = 0;
					Journal journal = new Journal();
					aid = file[0].toLowerCase() + "-" + file[1].toLowerCase() + "-" + file[2].toLowerCase();
					ArticleScholarOne articleMeta = new ArticleScholarOne();
					XStream xstream = createObjectXstreamScholarOne();

					for (File articleFile : files1) {
						if (articleFile.isFile() && articleFile.getName().endsWith(".xml")) {
							try {
								String temppath = OutputEMPath + File.separator + "temp" + articleFile.getName();
								// String temppathBeautify = OutputEMPath + File.separator + "tempBeautify"
								// + articleFile.getName();
								String content = FileUtils.readFileToString(articleFile);
								File tempfile = new File(temppath);
								char quot = '"';
								String rep = "<!DOCTYPE article_set SYSTEM " + quot + "s1.dtd" + quot + ">";
								FileUtils.writeStringToFile(tempfile, content.replace(rep, " "));
								System.out.println(rep);
								xstream.fromXML(tempfile, articleMeta);
								LOGGER.info(articleMeta.toString());
								ArticleDetail articleDetails = articleService.findByAid(aid);
								if (articleDetails != null) {
									SendEmailUtility.mail(EmailEnum.to, "Ingestion Error", "Article ID :" + aid
											+ "\r\nArticle Name :" + articleMeta.getArticle().getArticleTitle()
											+ "\r\n Already  Exists in Unitouch" + "\r\n Thanks, UniTouch Team");
								} else {
									journal = journalService.getJournalbyabbrname(Journalabbev);
									ArticleDetail articleDetail = new ArticleDetail();
									articleDetail.setAid(aid);
									articleDetail.setArticle_doi(journal.getDoiPrefix() + Journalabbev + "." + aid);
									adoi = journal.getDoiPrefix() + Journalabbev + "." + aid;
									articleDetail.setArticle_type_cd(articleMeta.getArticle().getPublicationType());
									articleDetail.setArticle_title(articleMeta.getArticle().getArticleTitle());
									articleDetail.setJournalId(journal.getJournalId());
									articleDetail.setJournal_issue_number(journal.getJournalIssn());
									articleDetail.setPublisher_id(142);
									List<MS> ms = articleMeta.getArticle().getHistory().getMsId();
									String subittedDate = ms.get(0).getSubittedDate().getYear() + "-"
											+ ms.get(0).getSubittedDate().getMonth() + "-"
											+ ms.get(0).getSubittedDate().getDay() + " "
											+ ms.get(0).getSubittedDate().getHour() + ":"
											+ ms.get(0).getSubittedDate().getMinute() + ":"
											+ ms.get(0).getSubittedDate().getSecond() + ".0";

									String acceptedDate = ms.get(0).getDicisionDate().getDay() + "-"
											+ ms.get(0).getDicisionDate().getMonth() + "-"
											+ ms.get(0).getDicisionDate().getYear();

									articleDetail
											.setAccepted_date(DateApi.convertTimeFormat(acceptedDate, "dd-M-yyyy"));
									articleDetail.setSubmissionDate(subittedDate);

									articleDetail.setKeywords("need to insert");
									articleDetail.setPriority("Medium Priority");
									articleDetail.setWithdrawStatus("N");
									// articleDetail.setSubmissionDate(keyword.getSubmissionDate());
									articleDetail.setCommentoForProduction("");
									StringBuilder builderj = new StringBuilder();
									if (journal.getArticleWorkflowId() == 0) {
										LOGGER.info("Journal Name = " + journal.getJournalName() + ", journal Abbr = "
												+ journal.getJournalAbbrName().toLowerCase());
										LOGGER.info("error = " + "Please add a worklflow to this Journal "
												+ journal.getJournalAbbrName().toLowerCase());
										builderj.append("Journal Name = " + journal.getJournalName()
												+ ", journal Abbr = " + journal.getJournalAbbrName().toLowerCase());
										SendEmailUtility.mail(EmailEnum.to,"Ingestion Error SO journal worklflow not setup --  "+journal.getJournalName(), builderj.toString());
									} else {
										WorkflowTaskSeq workflowTaskSeq = workflowRoleService
												.getTaskId(journal.getArticleWorkflowId());

										taskId = workflowTaskSeq.getTaskId();
										aId = articleService.saveArticle(articleDetail);
										FileVersion fileVersion = new FileVersion();
										fileVersion.setArticleId(aId);
										fileVersion.setJournalId(journal.getJournalId());
										fileVersion.setFileName(artcleFolder.getName() + ".zip");
										fileVersion.setFileType("zip");
										fileVersion.setFileVersion(1);
										fileVersion.setTaskId(taskId);
										fileVersion.setCreatedAt(new Date());
										fileVersion.setUpdaetdAt(new Date());
										fileVersion.setFilePath(journalPath + File.separator + Journalabbev
												+ File.separator + Journalabbev + aid + File.separator + "Origin"
												+ File.separator + artcleFolder.getName() + ".zip");
										fileversionservice.saveFileVersion(fileVersion);

										List<com.digi.unitouch.scholarOne.Meta.Author> authorContrib = articleMeta
												.getArticle().getAuthorList().getAuthor();
										for (com.digi.unitouch.scholarOne.Meta.Author author : authorContrib) {
											AuthorArticleDetails aadt = new AuthorArticleDetails();
											if (author.getCorr().equalsIgnoreCase("true")) {
												aadt.setIs_corresponding("YES");
											} else {
												aadt.setIs_corresponding("NO");
											}
											aadt.setArticle_id(aId);
											aadt.seteMail(author.getEmail().get(0));
											aadt.setfName(author.getFirstName());
											aadt.setlName(author.getLastName());
											aadt.setmName(author.getMiddleName());
											aadt.setTitle(author.getSalutation());
											aadt.setOrcid("");
											// aadt.setAuthor_order(author.getRole().getContentType());
											aadt.setCopyright("NO");
											aadt.setCopyrightAgreementContent("");
											authorService.save(aadt);
										}
										String input = InputSOPath + File.separator + artcleFolder.getName() + ".zip";
										taskSchedular(aId, input);
										ArticleIngestionFlag = true;
										LOGGER.info("ArticleIngestionFlag :: true in -->" + ArticleIngestionFlag);
										LOGGER.info("ArticleIngestionFlag :: true done --->" + ArticleIngestionFlag);
									}
								}
							} catch (Exception e) {
								ArticleIngestionFlag = false;
								LOGGER.info("Exception --->" + ArticleIngestionFlag);
								LOGGER.info("Error in ingecting XML:" + articleFile.getName() + " with exception"
										+ e.getLocalizedMessage());
								errorMap.put(articleFile.getName(),
										e.getLocalizedMessage() + " message " + e.getCause());
							}

						}
					}

					if (ArticleIngestionFlag) {
						LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
						String copyPath = InputSOPath + File.separator + artcleFolder.getName() + ".zip";
						String SuccessPath = journalPath + File.separator + Journalabbev + File.separator + adoi
								+ File.separator + "Origin";

						String OutputFile = SuccessPath + File.separator + artcleFolder.getName() + ".zip";
						final File folder = new File(SuccessPath + File.separator + artcleFolder.getName());
						File tempFile = new File(copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(SuccessPath).exists()) {
									new File(SuccessPath).mkdirs();
									LOGGER.info("ArticleIngestionFlag is true ::: --->" + ArticleIngestionFlag);
									LOGGER.info("SuccessPath  ::: --->" + SuccessPath);
									LOGGER.info("tempFile  ::: --->" + tempFile);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile));
								LOGGER.info(temp + "File moved Succesfull");
								LOGGER.info("temp ::: --->" + temp);
								UnZip.unZipIt(OutputFile, SuccessPath);
								LOGGER.info("OutputFile  and SuccessPath  is ::: --->" + OutputFile + " ---- :"
										+ SuccessPath);
								FileReading fileReading = new FileReading();
								Map<String, String> fileListinFolder = fileReading.listFilesForFolder(folder);
								LOGGER.info("------>File  Saving is Start from  Origin path  ");
								for (Entry<String, String> spath : fileListinFolder.entrySet()) {
									FileVersion fileVersion = new FileVersion();
									fileVersion.setArticleId(aId);
									fileVersion.setJournalId(journal.getJournalId());
									fileVersion.setFileName(spath.getKey());
									fileVersion.setFileVersion(1);
									fileVersion.setTaskId(taskId);
									fileVersion.setFilePath(spath.getValue());
									fileVersion.setCreatedAt(new Date());
									fileVersion.setUpdaetdAt(new Date());
									fileversionservice.saveFileVersion(fileVersion);
									LOGGER.info(spath.getKey() + "------>File Save from  Origin path  ");
								}
								LOGGER.info("------>File Saving is END  from  Origin path  ");
							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info(e + "File Not moved Succesfull");
								LOGGER.info("IOException ::: --->" + e);
							}
						}
					} else {
						String copyPath = InputSOPath + File.separator + artcleFolder.getName() + ".zip";
						String OutputFile = ErrorSOPath + File.separator + artcleFolder.getName() + ".zip";
						File tempFile = new File(copyPath);
						LOGGER.info("else in ::: --->temp path" + tempFile + " ---- :copyPath------>" + copyPath);
						if (tempFile.exists()) {
							try {
								if (!new File(ErrorSOPath).exists()) {
									new File(ErrorSOPath).mkdirs();
									LOGGER.info("else in ErrorPath::: --->" + ErrorSOPath);
								}

								Path temp = Files.move(Paths.get(copyPath), Paths.get(OutputFile),
										StandardCopyOption.REPLACE_EXISTING);
								LOGGER.info(temp + " File moved Succesfull to error folder");

							} catch (IOException e) {
								e.printStackTrace();
								LOGGER.info("else in IOException::: --->" + e);
							}
						}
					}
				}

			}
			File file = new File(OutputSOPath);
			try {
				FileUtils.cleanDirectory(file);
				LOGGER.info("try FileUtils.cleanDirectory(file) in file::: --->" + file);
			} catch (IOException e) {
				LOGGER.error("Error in deleting output folder");
			}
			if (!errorMap.isEmpty()) {
				LOGGER.info("Details of error after ingestion");
				StringBuilder builder = new StringBuilder();
				builder.append("Hi,");
				builder.append(System.lineSeparator());
				builder.append("Please find the error details for the ingestion of " + new Date());
				builder.append(System.lineSeparator());
				for (Map.Entry<String, String> entry : errorMap.entrySet()) {
					builder.append("File Name = " + entry.getKey() + ", Error = " + entry.getValue());
					builder.append(System.lineSeparator());
					LOGGER.info("File Name = " + entry.getKey() + ", Error = " + entry.getValue());

				}
				builder.append("Thanks, UniTouch");
				builder.append(System.lineSeparator());
				LOGGER.error(builder.toString());
				try {
					SendEmailUtility.mail(EmailEnum.to, "Ingestion Error", builder.toString());
				} catch (javax.mail.MessagingException e) {
					LOGGER.error("error in MessagingException MAIL--->" + e);
				}
			}
		} else {
			LOGGER.info("Error in finding input path " + inputDir.getAbsolutePath() + "or output path "
					+ outDir.getAbsolutePath());
		}
		}
		else {
			LOGGER.info("----------------------- unitouch.Scheduled-----Status------------------"+unitouchScheduled);
		}
	}

	public static XStream createObjectXstreamScholarOne() {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(ArticleScholarOne.class);
		xstream.registerConverter(new IssnConverterScholar());
		return xstream;
	}

}