package com.digi.unitouch.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.ApplicationResponse;
import com.digi.unitouch.emun.EmailEnum;
import com.digi.unitouch.emun.EmunAticleStatus;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.CoverPage;
import com.digi.unitouch.model.CurrentIssueStatus;
import com.digi.unitouch.model.IssueArticle;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.IssueFileVersion;
import com.digi.unitouch.model.IssueSequence;
import com.digi.unitouch.model.IssueTaskScheduler;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.ManageJournalWorkflow;
import com.digi.unitouch.model.TaskDetails;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.model.Workflow;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.AuthorArticleService;
import com.digi.unitouch.service.CoverPageService;
import com.digi.unitouch.service.CurrentIssueService;
import com.digi.unitouch.service.FileVersionService;
import com.digi.unitouch.service.IssueArticleService;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.service.IssueSequenceService;
import com.digi.unitouch.service.IssueTaskSchedulerService;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.service.ManageJournalworkflowService;
import com.digi.unitouch.service.PublisherService;
import com.digi.unitouch.service.TaskService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.service.WorkflowService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.util.ExcelDataUtils;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.util.SendEmailUtility;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.IssueSequenceVo;

@Controller
public class IssueMakeupController extends LoggerClass {
	@Autowired
	ArticleService articleService;
	@Autowired
	FileVersionService fileversionservice;
//	@Autowired
//	MailService mailservice;
	@Autowired
	JournalService journalService;
	@Autowired
	PublisherService publisherService;
	@Autowired
	IssueDetailService issueDetailService;
	@Autowired
	WorkflowService workflowService;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	TaskService taskService;

//	@Autowired
	// WorkflowTaskService workflowRoleService;
	@Autowired
	CurrentIssueService currentIssueService;
	@Autowired
	IssueTaskSchedulerService issueTaskSchedulerService;
	@Autowired
	IssueSequenceService issueSequenceService;
	@Autowired
	IssueArticleService issueArticleService;
	@Autowired
	AuthorArticleService authorService;
	@Autowired
	ManageJournalworkflowService manageJournalworkflowService;

	@Autowired
	UserService userService;

	@Value("${journal.path}")
	private String UPLOAD_FOLDER;
	@Autowired
	private Environment env;
	@Autowired
	CoverPageService coverPageService;

	@Value("${journal.path}")
	private String journalPath;
	@Value("${journal.InputPath}")
	private String InputPath;
	@Value("${journal.OutputPath}")
	private String OutputPath;
	@Value("${journalErrorPath}")
	private String ErrorPath;

	@GetMapping("getIssueList")
	public ModelAndView getIssueList(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		List<IssueDetail> issueList = new ArrayList<IssueDetail>();
		if (users.getRole().getRoleID() == 1) {
			issueList = issueDetailService.getAllList();
		} else {
			List<ManageJournalWorkflow> mj = manageJournalworkflowService.getmanagedetailsbyUserId(users.getUserID());
			for (ManageJournalWorkflow manageJournalWorkflow : mj) {
				issueList.addAll(issueDetailService.getIsuuelistbyJournalId(manageJournalWorkflow.getJournal_id()));
			}
		}
		
		List<IssueDetail> upcomingIssue = new ArrayList<IssueDetail>();
		CopyOnWriteArrayList<IssueDetail> runingIssue = new CopyOnWriteArrayList<IssueDetail>();
		// List<IssueDetail> issueupcomingList=issueDetailService.getupcomimgIssue();
		for (IssueDetail issueDetail : issueList) {
			if (issueDetail.getIsssueArticle().isEmpty()) {
				upcomingIssue.add(issueDetail);
			} else {
				runingIssue.add(issueDetail);
			//	isse.add(issueDetail.getIssue_id());
				}
		}
		System.out.println("runingIssue-->" + runingIssue);
		System.out.println("upcomingIssue-->" + upcomingIssue);
		model.put("issueList", issueList);
		
		model.put("upcomingIssue", upcomingIssue);
		List<IssueTaskScheduler> articlecompleteDetail = issueTaskSchedulerService.getIssueCompleteDetail();
		//int i=0;
		for (IssueTaskScheduler issueTaskScheduler : articlecompleteDetail) {
			int j=0;
			for (IssueDetail issueTaskScheduler2 : runingIssue) {
				if(issueTaskScheduler.getIssueId().equals(issueTaskScheduler2.getIssue_id())) {
					runingIssue.remove(j);
				}j++;
			}
			//i++;
		}
		model.put("completeDetail", articlecompleteDetail);
		model.put("runingIssue", runingIssue);
		System.out.println(issueList.toString());
		return new ModelAndView("issueList");

	}

	@PostMapping("getIssueArticleList")
	public ResponseEntity<ApplicationResponse> getIssueArticleList(@RequestBody IssueSequence issue) {
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		List<IssueSequence> issueSeq = issueSequenceService.getIssue(issue.getIssueId(), issue.getjId());
		applicatonResponse.setPayload(issueSeq);
		applicatonResponse.setMessage("ok");
		System.out.println(issueSeq.toString());
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@GetMapping("issueMakeup")
	public ModelAndView issueMakeup(ModelMap model) {
		// List<Journal> journalList1S = journalService.getjournalListForIssue();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		if (users.getRole().getRoleID() == 1) {
			List<Journal> journalList = journalService.getjournalListForIssue();
			model.put("journallist", journalList);
		} else {
			List<Journal> journalList = new ArrayList<Journal>();
			List<ManageJournalWorkflow> mj = manageJournalworkflowService.getmanagedetailsbyUserId(users.getUserID());
			for (ManageJournalWorkflow manageJournalWorkflow : mj) {
				Journal jourl = journalService.getjournalForIssue(manageJournalWorkflow.getJournal_id());
				if (jourl != null)
					journalList.add(jourl);
			}
			model.put("journallist", journalList);
			System.out.println(journalList);
		}
		// model.put("journallist", journalList1S);
		model.put("ArticleDetail", null);
		return new ModelAndView("IssueMakeupList");

	}

	@RequestMapping(value = { "/getIssueData" })
	public ModelAndView getIssueData(ModelMap model, HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		// List<Journal> journalList = journalService.getjournalListForIssue();

		if (users.getRole().getRoleID() == 1) {
			List<Journal> journalList = journalService.getjournalListForIssue();
			model.put("journallist", journalList);
		} else {
			List<Journal> journalList = new ArrayList<Journal>();
			List<ManageJournalWorkflow> mj = manageJournalworkflowService.getmanagedetailsbyUserId(users.getUserID());
			for (ManageJournalWorkflow manageJournalWorkflow : mj) {
				Journal jourl = journalService.getjournalForIssue(manageJournalWorkflow.getJournal_id());
				if (jourl != null)
					journalList.add(jourl);
			}
			model.put("journallist", journalList);
		}
		// List<Publisher> publisher = publisherService.getallList();
		// model.put("publisherList", publisher);
		String issueId = request.getParameter("issueId");
		IssueDetail issueData = issueDetailService.getIsuuelistbyid(Integer.parseInt(issueId));
		Integer issuewkid = issueData.getJournals().getIssueWorkflowId();
		if (issuewkid == 0) {
			model.put("ArticleDetail", null);
			model.put("issueData", null);
			model.put("message", "Please assign the workflow of this journal");
			model.put("css", "danger");
			return new ModelAndView("IssueMakeupList");
		}
		Integer isseueq = issueData.getIssueSeqNo();
		model.put("issueData", issueData);
		System.out.println(isseueq);
		if (1 == isseueq) {
			LOGGER.info("Issue at 1st time create ---------->URL--getIssueData");
		} else {
			IssueDetail issueJournal = issueDetailService.getIsuuelistbyJournalIdWithSeq(issueData.getJournalId(),
					isseueq - 1);
			for (int i = (isseueq-1); i >= 1; i--) {
				issueJournal = issueDetailService.getIsuuelistbyJournalIdWithSeq(issueData.getJournalId(), i);
				if (issueJournal.getIsSupplementary().equalsIgnoreCase("N")) {
					issueJournal = issueDetailService.getIsuuelistbyJournalIdWithSeq(issueData.getJournalId(), i);
					break;
				}
			}
			IssueSequence issSeqLast = issueSequenceService.getLastPageNumberIssue(issueJournal.getIssue_id(),
					issueData.getJournalId());
			if (issSeqLast == null) {
				model.put("ArticleDetail", null);
				model.put("issueData", null);
				model.put("message", "Please create the preceding issue before creating this issue");
				model.put("css", "danger");
				return new ModelAndView("IssueMakeupList");
			}
			System.out.println("issSeqLast-->" + issSeqLast.toString());
			if (issSeqLast.getTo_page() % 2 != 0) {
				issSeqLast.setTo_page(issSeqLast.getTo_page() + 1);
			}
			model.put("issSeqLast", issSeqLast);
		}
		// List<ArticleDetail> artcleList= new ArrayList<ArticleDetail>();
	//	CopyOnWriteArrayList<ArticleDetail> articleList = articleService
	//			.getArticleListbyJrIdGetPage(issueData.getJournalId());
		CopyOnWriteArrayList<ArticleDetailsVO> articleList = articleService
				.getunassignedArticleListbyJrId(issueData.getJournalId());
		
		System.out.println("articleList-->" + articleList.toString());
		System.out.println(issueData.toString());
		Journal journal = journalService.getJournalNameby(issueData.getJournalId());
		model.put("journal", journal);
		Workflow workflow = workflowService.findworkflowbyname(journal.getIssueWorkflowId());
		int i = 0;
		for (ArticleDetailsVO articleDetailvo : articleList) {
			List<IssueArticle> la = issueArticleService.getIssueByarticleID(articleDetailvo.getArticle_id());
			System.out.println(la.toString());

			for (IssueArticle issueArticle : la) {
				// IssueDetail iss=
				// issueDetailService.getIsuuelistbyid(issueArticle.getIssueId());
				articleList.remove(i);
				i--;
			}
			i++;
		}

		model.put("workflow", workflow);
		model.put("ArticleDetail", articleList);
		LOGGER.debug("articleList :" + articleList.toString());
		model.put("articleIssue", articleList);
		return new ModelAndView("IssueMakeupList");

	}

	@RequestMapping(value = { "/saveIssue" })
	public ModelAndView saveIssue(ModelMap model, HttpServletRequest request,
			IssueDetail issueDetail/* ,@RequestParam MultipartFile attachment */) {
		IssueDetail issue = issueDetailService.findByIssueTitle(issueDetail.getIssue_title().trim(),
				issueDetail.getJournalId());
		if (!(issue == null)) {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Issue is already exist");
			return issueMakeup(model);

		} else {
			List<IssueDetail> issuecCount = issueDetailService.getIsuuelistbyJournalId(issueDetail.getJournalId());
			Integer numberOfIssue = issuecCount.size();
			System.out.println(issuecCount.size());
			issueDetail.setCreate_date(new Date());
			issueDetail.setPublisher_id(142);
			issueDetail.setIssueSeqNo(numberOfIssue + 1);
			issueDetail.setIssue_status("Y");
			issueDetail.setIsScheduled("N");
			Integer issueId = issueDetailService.saveIssue(issueDetail);
			model.addAttribute("message", " Issue has been created successfully. ");
			model.addAttribute("css", "success");
			return issueMakeup(model);
		}
	}

	@GetMapping("getfile")
	public ModelAndView sendfile(ModelMap model, HttpServletRequest request) {

		return new ModelAndView("Workflow/datatable");
	}

//	@PostMapping("createIsserSeq")
	@RequestMapping(value = "createIsserSeq", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationResponse> createIsserSeq(@RequestParam("files") MultipartFile files[],
			HttpServletRequest request /* ,@RequestBody List<IssueSeqVo> issueSeq */, @RequestParam String filedata,
			@RequestParam String jrID, @RequestParam String issueIdP, HttpServletResponse response) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		Integer issueId = 0;
		Integer filecount = 0;
		int count = 1;
		boolean issuesheduler = true;
		Journal journal = journalService.getjournalbyId(Integer.parseInt(jrID));
		IssueDetail issueDetailList = issueDetailService.getIsuuelistbyid(Integer.parseInt(issueIdP));
		if (issueDetailList.getIsssueArticle().isEmpty()) {
			issuesheduler = true;
		} else {
			issuesheduler = false;
		}
		Integer seqNo = issueDetailList.getIssueSeqNo();
		if (seqNo == 1) {
			count = 1;
		} else {

			IssueDetail issueJournal = issueDetailService.getIsuuelistbyJournalIdWithSeq(Integer.parseInt(jrID),
					seqNo - 1);
			IssueSequence issSeq = issueSequenceService.getLastSeqNoIssue(issueJournal.getIssue_id(),
					Integer.parseInt(jrID));
			count = issSeq.getSequenceNo() + 1;
		}
		// WorkflowTaskSeq workflowTaskSeq =
		// workflowTaskService.getTaskId(journal.getArticleWorkflowId());
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		JSONArray array = new JSONArray(filedata);
		for (int i = 0; i < array.length(); i++) {

			IssueSequence issueSequence = new IssueSequence();
			JSONObject object = array.getJSONObject(i);
			String ar = object.getString("articleId");
			if (ar.equalsIgnoreCase(""))
				continue;
			System.out.println(object.getString("articleId"));
			System.out.println(object.getString("pages"));
			issueSequence.setArticle_type_cd(object.getString("articleType"));
			issueSequence.setArticleDoi(object.getString("articleDOI"));
			issueSequence.setPage_from(Integer.parseInt(object.getString("pageFrom")));
			issueSequence.setTo_page(Integer.parseInt(object.getString("pageTo")));
			issueSequence.setColorimage(object.getString("colorimage"));
			issueSequence.setBwimage(object.getString("bwimage"));
			issueSequence.setSequenceNo(count++);
			issueId = Integer.parseInt(object.getString("issueId"));
			issueSequence.setArticletitle(object.getString("articletitle"));
			if (object.getString("pages").equals("")) {
				issueSequence.setPages("0");
			} else {
				issueSequence.setPages(object.getString("pages"));
			}
			issueSequence.setCoverArticleId(object.getString("articleId"));
			if (object.getString("articleDOI").equalsIgnoreCase("Remove")) {
				issueSequence.setArticleDoi("Remove");
				issueSequence.setFileFlag(files[filecount].getName());

				if (!files[filecount].isEmpty()) {
					try {
						byte[] bytes = files[filecount].getBytes();
						if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + issueId + File.separator + "Origin").exists()) {
							new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
									+ File.separator + issueId + File.separator + "Origin").mkdirs();
						}

						Path path = Paths.get(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + issueId + File.separator + "Origin" + File.separator
								+ files[filecount].getOriginalFilename());
						// FileVersion fileVersion = new FileVersion();
						IssueFileVersion fileVersion = new IssueFileVersion();
						fileVersion.setIssueId(issueId);
						fileVersion.setCover_name(object.getString("articleId"));
						fileVersion.setJournalId(journal.getJournalId());
						fileVersion.setFileName(files[filecount].getOriginalFilename());
						fileVersion.setFileType(files[filecount].getContentType());
						fileVersion.setFileVersion(1);
						fileVersion.setTaskId(111452);// set pe id by
						fileVersion.setFilePath(path.toString());
						fileVersion.setCreatedAt(new Date());
						fileVersion.setCreated_by(users.getUserID());
						fileversionservice.saveIssueFileVersion(fileVersion);
						// fileversionservice.saveFileVersion(fileVersion);
						Integer issueFileId = fileversionservice.saveIssueFileVersionID(fileVersion);
						CoverPage cp = new CoverPage();

						cp.setWkid(object.getString("workflowid"));
						cp.setJid(journal.getJournalId() + "");
						cp.setIssue_id(issueId + "");
						cp.setCover_titel(object.getString("articleId"));
						cp.setCover_no_of_page(object.getString("pages"));
						cp.setPage_id(issueFileId + "");
						cp.setCover_path(path.toString());
						cp.setCreated_at(new Date());
						System.out.println("cover data save");
						coverPageService.saveCoverPage(cp);
						issueSequence.setIssueFileId(issueFileId);
						Files.write(path, bytes);
						issueSequence.setFilePath(path.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				LOGGER.debug(object.getString("articleId") + " : :cover Id we got");
				filecount++;
			} else {
				ArticleDetail articleDetails = articleService.findByAid(object.getString("articleId"));
				String comment = object.getString("articleComment");
				articleDetails.setArticle_comment(comment);
				articleService.saveArticle(articleDetails);
				LOGGER.info("articleComment Save");
				IssueArticle issueArticle = new IssueArticle();
				issueArticle.setArticleId(articleDetails.getArticle_id());
				issueArticle.setIssueId(Integer.parseInt(object.getString("issueId")));
				issueArticleService.SaveIssueArticle(issueArticle);
			}
			issueSequence.setWorkflowid(Integer.parseInt(object.getString("workflowid")));
			issueSequence.setjId(Integer.parseInt(object.getString("jId")));
			issueSequence.setCreatedAt(new Date());
			issueSequence.setCreatedBy(name);
			issueSequence.setIssueId(Integer.parseInt(object.getString("issueId")));

			LOGGER.debug("----------------------");
			LOGGER.debug("issue ::" + issueSequence.toString());
			issueSequenceService.Save(issueSequence);
		}

		System.out.println(issueId);
		//23-12 comt 
//		if (issuesheduler) {
//			IssuetaskSchedular(issueId);
//			LOGGER.info("issue Schedular created ");
//		} else {
//			LOGGER.info("issue Schedular already created");
//
//		}
		issueDetailList.setIssue_status("N");
		issueDetailService.saveIssue(issueDetailList);
		List<IssueSequence> issueList = issueSequenceService.getAllElements(issueId);
		LOGGER.info("issueList ------------------------------:: " + issueList.toString());
		applicatonResponse.setPayload(issueList);
		applicatonResponse.setMessage("OK");
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@PostMapping("issueMakeuplist")
	public ResponseEntity<ApplicationResponse> saveTaskRunId(@RequestBody IssueDetail issueDetail, ModelMap model)
			throws InterruptedException, IOException {
		LOGGER.debug(issueDetail.getJournalId().toString());
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		List<IssueDetail> issueDetailList = issueDetailService
				.getIsuueStatusListbyJournalId(issueDetail.getJournalId());
		applicatonResponse.setPayload(issueDetailList);
		applicatonResponse.setMessage("OK");
		LOGGER.debug("agds :" + issueDetailList);
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);

	}

	@PostMapping("uploadCoverpage")
	public ResponseEntity<ApplicationResponse> uploadCoverpage(@RequestParam String CustomField,
			@RequestParam String wrkId, @RequestParam String jrId, @RequestParam String isuId,
			@RequestParam String pageId, @RequestParam String issueTitle, @RequestParam String pageNo,
			@RequestParam MultipartFile files, HttpServletRequest request) {
		CoverPage cp = new CoverPage();

		cp.setWkid(wrkId);
		cp.setJid(jrId);
		cp.setIssue_id(isuId);
		cp.setCover_titel(issueTitle);
		cp.setCover_no_of_page(pageNo);
		cp.setPage_id(pageId);

		Journal journal = new Journal();
		journal = journalService.getjournalbyId(Integer.parseInt(jrId));

		WorkflowTaskSeq workflowTaskSeq = workflowTaskService.getTaskId(journal.getArticleWorkflowId());
		int taskId = workflowTaskSeq.getTaskId();
		if (!files.isEmpty()) {
			try {
				byte[] bytes = files.getBytes();
				if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
						+ Integer.parseInt(isuId) + File.separator + "Origin").exists()) {
					new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase() + File.separator
							+ Integer.parseInt(isuId) + File.separator + "Origin").mkdirs();
				}

				Path path = Paths.get(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
						+ File.separator + Integer.parseInt(isuId) + File.separator + "Origin" + File.separator
						+ files.getOriginalFilename());
				IssueFileVersion fileVersion = new IssueFileVersion();
				fileVersion.setIssueId(Integer.parseInt(isuId));
				fileVersion.setJournalId(journal.getJournalId());
				fileVersion.setFileName(files.getOriginalFilename());
				fileVersion.setFileType(files.getContentType());
				fileVersion.setFileVersion(1);
				fileVersion.setTaskId(taskId);
				fileVersion.setFilePath(path.toString());
				fileversionservice.saveIssueFileVersion(fileVersion);
				Files.write(path, bytes);
				cp.setCover_path(path.toString());
				cp.setCreated_at(new Date());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// cp.setCoverSeq(coverSeq);

		System.out.println("function call");
		coverPageService.saveCoverPage(cp);
		return new ResponseEntity<ApplicationResponse>(HttpStatus.OK);
	}

	// @Scheduled(fixedDelay = 300)
//	@Scheduled(cron = "0 3 16 32 * ?") //create automatic sheduler
//	public void issueFuture() {
//		List<IssueDetail> issueList=issueDetailService.getAllList();
//		for (IssueDetail issueDetail : issueList) {
//			if(issueDetail.getIsssueArticle().isEmpty()) {
//				
//			}else {
//				IssuetaskSchedular(issueDetail.getIssue_id());
//			}
//		}
//	}
	public void IssuetaskSchedular(int issueID) {
		String to = EmailEnum.to;
		String msgSubject = "Automated Email: Unitouch IssueSchedular";

		// TaskScheduler ts = taskService.findtaskId(128);
		TaskScheduler ts = new TaskScheduler();

		// LOGGER.debug("issueID :" + issueID);

		IssueDetail issueArticle = issueDetailService.getIsuuelistbyid(issueID);
		// LOGGER.debug("issueArticle " + issueArticle);
		Journal journal = journalService.getjournalbyId(issueArticle.getJournalId());
		LOGGER.debug("journal :" + journal);
		CurrentIssueStatus currentIssueeStatus = new CurrentIssueStatus();
		int wfid = journal.getIssueWorkflowId();
		String productionuser = "";
		String fusername = "";
		String pename = "";
		if (wfid == 0) {
			String msgBody = "Dear ,\r\n" + "\r\n" + "Please add  the Issue Workflow in " + "\r\n\" + journal : "
					+ journal.getJournalName() + "With Issue : " + issueArticle.getIssue_title() + " in Unitouch\r\n"
					+ "\r\n" + "Thanks,\r\n" + "Unitouch\r\n" + "";
			try {
				SendEmailUtility.mail(to, msgSubject, msgBody);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			WorkflowTaskSeq workflowTaskSeq = workflowTaskService.getTaskId(wfid);
			int taskId = workflowTaskSeq.getTaskId();
			// LOGGER.debug(taskId);
			currentIssueeStatus.setTaskId(taskId);
			currentIssueeStatus.setIssueId(issueID);
			currentIssueService.saveCurrentIssueS(currentIssueeStatus);
			currentIssueeStatus.setIssueId(issueID);
			List<WorkflowTaskSeq> workflowTaskSeqlist = workflowTaskService.workflowTaskSeqlist(wfid);

			List<WorkflowTaskSeq> finallist = new ArrayList<WorkflowTaskSeq>();
			List<WorkflowTaskSeq> uu = (List<WorkflowTaskSeq>) workflowTaskService.workflowTaskSeqlist(wfid);
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

					if (!new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
							+ File.separator + issueArticle.getIssue_id() + File.separator
							+ task.getTaskName().replace(' ', '_')).exists()) {
						new File(journalPath + File.separator + journal.getJournalAbbrName().toLowerCase()
								+ File.separator + issueArticle.getIssue_id() + File.separator
								+ task.getTaskName().replace(' ', '_')).mkdirs();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				int day = 0;
				day = Tat;
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

				IssueTaskScheduler tschedule = new IssueTaskScheduler();
				tschedule.setIssueId(issueID);
				tschedule.setWorkflowId(wfid);
				tschedule.setTaskId(taskid);
				tschedule.setTaskAssignedDate(new Date());
				tschedule.setTaskDueDate(new Date());
				tschedule.setSchStartTime(dd);
				tschedule.setAssignBackCount(0);
				tschedule.setSchEndTime(dc);
				if (producationTrackers.getSequence().equals(0)) {
					ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
							(wfid), (issueArticle.getJournalId()), (producationTrackers.getRoleId()),
							producationTrackers.getTaskId());
					LOGGER.info("WorkflowTaskSeq  InPool------->" + producationTrackers);
					tschedule.setUserId(manageJournalWorkflow.getUser_id());
					tschedule.setTaskStatus("Yet-to-Start");
					fusername = manageJournalWorkflow.getUsers().getUsername();
				} else {
					LOGGER.info("WorkflowTaskSeq  Yet-to-Start------->" + producationTrackers);
					tschedule.setTaskStatus("Yet-to-Start");
				}
				tschedule.setRunId(0);
				issueTaskSchedulerService.saveTaskSchedulars(tschedule);
				if (producationTrackers.getRoleId() == 3712) {
					ManageJournalWorkflow manageJournalWorkflow = manageJournalworkflowService.getdepartmentIdallby(
							(wfid), (journal.getJournalId()), (producationTrackers.getRoleId()),
							producationTrackers.getTaskId());
					productionuser = manageJournalWorkflow.getUsers().getUsername();
					pename = manageJournalWorkflow.getUsers().getFirstName() + "\r\n"
							+ manageJournalWorkflow.getUsers().getLastName();

				}
				LOGGER.debug(tschedule.toString());

			}
		}
		// sending mail to 1st user and Pe of this journal
		try {
			List<String> fTask = EmunAticleStatus.fiststageforIssueMailVender(issueArticle.getIssue_title(), pename,
					journal.getJournalName());
			LOGGER.info("msg sending---->to 1st tast");
			SendEmailUtility.sendFistStageProductioMail(fusername, fTask.get(0), fTask.get(1), journal.getFromEmail());
			LOGGER.info("msg send---->" + fTask.get(1));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<String> produ = EmunAticleStatus.toProductionforIssue(issueArticle.getIssue_title(), pename,
					journal.getJournalName());
			LOGGER.info("msg sending---->to 1st tast");
			SendEmailUtility.sendFistStageProductioMail(productionuser, produ.get(0), produ.get(1),
					journal.getFromEmail());
			LOGGER.info("msg send---->" + produ.get(1));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/createExcel")
	public void CreateExcel(HttpServletResponse response) {
		List<IssueSequenceVo> issueSequenceList = null;
		List<IssueSequence> issueList = issueSequenceService.getAllList();
		if (issueList != null) {
			issueSequenceList = new ArrayList<>();
			for (IssueSequence issueData : issueList) {
				IssueSequenceVo bean = new IssueSequenceVo();
				bean.setArticleDoi(issueData.getArticleDoi());
				bean.setArticletitle(issueData.getArticletitle());
				bean.setCoverArticleId(issueData.getCoverArticleId());
				bean.setIspId(issueData.getIspId());
				bean.setJournalName(issueData.getJournals().getJournalName());
				bean.setIssueName(issueData.getIssue().getIssue_title());
				bean.setJournalVN(issueData.getIssue().getLast_volume_number());
				bean.setIssueVN(issueData.getIssue().getLast_issue_number());
				bean.setFilePath(issueData.getFilePath());
				bean.setPage_from(issueData.getPage_from());
				bean.setWorkflowName(issueData.getWorkflows().getName());
				bean.setFileFlag(issueData.getFileFlag());
				bean.setSequenceNo(issueData.getSequenceNo());

				issueSequenceList.add(bean);
			}
		}
		try {
			// System.out.println(issueSequenceList.toString());
			ExcelDataUtils.downloadAttendance(response, issueSequenceList);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@PostMapping("issueCreateExcel")
	public void issueCreateExcel(HttpServletResponse response, IssueDetail issue) {
		List<IssueSequenceVo> issueSequenceList = null;
		List<IssueSequence> issueList = issueSequenceService.getAllElements(issue.getIssue_id());
		if (issueList != null) {
			issueSequenceList = new ArrayList<>();
			for (IssueSequence issueData : issueList) {
				IssueSequenceVo bean = new IssueSequenceVo();
				if (issueData.getArticleDoi().equalsIgnoreCase("Remove")) {
					bean.setArticleDoi("");
				} else {
					bean.setArticleDoi(issueData.getArticleDoi());
				}
				bean.setArticletitle(issueData.getArticletitle());
				bean.setCoverArticleId(issueData.getCoverArticleId());
				bean.setIspId(issueData.getIspId());
				bean.setJournalName(issueData.getJournals().getJournalName());
				bean.setIssueName(issueData.getIssue().getIssue_title());
				bean.setFilePath(issueData.getFilePath());
				bean.setPage_from(issueData.getPage_from());
				bean.setPages(issueData.getPages());
				bean.setTo_page(issueData.getTo_page());
				bean.setWorkflowName(issueData.getWorkflows().getName());
				bean.setFileFlag(issueData.getFileFlag());
				bean.setSequenceNo(issueData.getSequenceNo());
				bean.setColorimage(issueData.getColorimage());
				bean.setBwimage(issueData.getBwimage());
				bean.setArticleType(issueData.getArticle_type_cd());
				issueSequenceList.add(bean);
			}
		}
		try {
			ExcelDataUtils.downloadAttendance(response, issueSequenceList);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

	@PostMapping("issuesheduler")
	public String issueShdular(HttpServletResponse response, IssueDetail issue) {
		List<IssueTaskScheduler> issueScheduler = issueTaskSchedulerService
				.getIssueSchedulerDetailByIssueID(issue.getIssue_id());
		if (issueScheduler.isEmpty()) {
			IssuetaskSchedular(issue.getIssue_id());
			IssueDetail issueDetails = issueDetailService.getIsuuelistbyid(issue.getIssue_id());
			issueDetails.setIsScheduled("Y");
			issueDetailService.saveIssue(issueDetails);
			LOGGER.info("issue Schedular created ");
		} else {
			LOGGER.info("issue Schedular already created");

		}
		return "redirect:getIssueList";
	}
}