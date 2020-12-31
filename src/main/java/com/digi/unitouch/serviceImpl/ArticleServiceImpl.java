package com.digi.unitouch.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorDataApiModel;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.repository.ArticleCommentRepo;
import com.digi.unitouch.repository.ArticleRepo;
import com.digi.unitouch.repository.AuthorDataApiModelRepo;
import com.digi.unitouch.repository.CurrentArticleRepo;
import com.digi.unitouch.repository.SchedularRepo;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.WorkflowTaskService;
import com.digi.unitouch.vo.ArticleDetailHavingOverloadvo;
import com.digi.unitouch.vo.ArticleDetailplannerVo;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.ArticleDetailvo;
import com.digi.unitouch.vo.ArticlePlanner;
import com.digi.unitouch.vo.ArticleSearchDetailvo;
import com.digi.unitouch.vo.ArticleTaskDetailsVO;
import com.digi.unitouch.vo.AvilabelLode;
import com.digi.unitouch.vo.LoadReportForcast;
import com.digi.unitouch.vo.TaskManagementVocArt;
import com.digi.unitouch.vo.TotelLode;

@Service

@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepo articleRepo;
	@Autowired
	CurrentArticleRepo currentArticleRepo;
	@Autowired 
	ArticleCommentRepo articleCommentRepo;
	@Autowired
	SchedularRepo schedularRepo;
	@Autowired
	WorkflowTaskService workflowTaskService;
	@Autowired
	AuthorDataApiModelRepo authorDataApiModelRepo;
	

	@Override
	public int saveArticle(ArticleDetail articleDetail) {
		articleRepo.saveAndFlush(articleDetail);
		return articleDetail.getArticle_id();
	}
	
	@Override
	public List<TaskScheduler> getAllData(){
		return schedularRepo.findAll();
	}

	@Override
	public List<ArticleDetail> getallList() {
		return articleRepo.findArticleDetail();
	}
	@Override
	public List<ArticleDetailsVO> getarticleDetail() {
		
		return articleRepo.getarticleDetail();
	}
	@Override
	public List<ArticleDetailsVO> getarticleDetailByjournalID(Integer journalID) {
		
		return articleRepo.getarticleDetailByjournalID(journalID);
	}
	@Override
	@Transactional
	public boolean withdrawArtical(String status, Integer articleID) {
		// TODO Auto-generated method stub
		ArticleDetail article = articleRepo.findArticleDetailBy(articleID);
		System.out.println("withdrawArtical------------------->"+article.toString());
		article.setWithdrawStatus(status);
		article.setRejectedDate(new Date());
		articleRepo.saveAndFlush(article);
		schedularRepo.withdrawArtical(articleID, "Withdraw");
		return true;
	}
	
	@Override
	public ArticleDetail findArticleDetailBy(int id) {
		return articleRepo.findArticleDetailBy(id);
	}
	
	@Override
	public ArticleDetail findByAid(String aid) {
		return articleRepo.findByAid(aid);
	}

	@Override
	public void updateArticleDetail(ArticleDetail updateArticle) {
		articleRepo.save(updateArticle);

	}

	@Override
	public String deleteArticleDetailById(int id) {
		articleRepo.deleteById(id);
		return "Article deleted successfully.";

	}

	@Override
	public List<ArticleDetailvo> getArticleDetailList(String article_title, String article_doi, String article_type_cd,
			String publisherName,String journalAbbrName,String aid,String keywords,String lName,String authorEmail,String articleStatus) {
		return articleRepo.getArticleDetailList(article_title, article_doi, article_type_cd, publisherName,journalAbbrName, aid,keywords,lName,authorEmail,articleStatus);
	}

	@Override
	public void saveCurrentArticleStatus(CurrentArticleStatus currentArticleStatus) {
		currentArticleRepo.save(currentArticleStatus);

	}

	@Override
	public List<ArticleSearchDetailvo> getArticleSearchDetailList(int article_id) {
		return articleRepo.getArticleSearchDetailList(article_id);
	}

	@Override
	public CurrentArticleStatus findCurrentArticleStatusBy(int taskID, int aid) {
		return currentArticleRepo.findCurrentArticleStatusBy(taskID, aid);
	}

	@Override
	public void saveCurrentArticleTaskStatus(CurrentArticleStatus currentArticleStatus) {
		currentArticleRepo.save(currentArticleStatus);

	}

	@Override
	public CurrentArticleStatus findArticleStatusBy(int aid) {
		return currentArticleRepo.findArticleStatusBy(aid);
	}

	@Override
	public List<TaskManagementVocArt> getArticleDetailListByArtId(int articleId) {

		System.out.println("Query" + articleRepo.getArticleDetailListByArtId(articleId));
		return articleRepo.getArticleDetailListByArtId(articleId);
	}

	@Override
	public List<ArticleDetailHavingOverloadvo> getarticleInProgressDetail() {
		return articleRepo.getarticleInProgressDetail();
	}

	@Override
	public List<TaskScheduler> getarticleCompleteDetail() {
		List<TaskScheduler> task = new ArrayList<TaskScheduler>();
	///	List<WorkflowTaskSeq> wl = new ArrayList<WorkflowTaskSeq>();
		List<WorkflowTaskSeq> womax = workflowTaskService.findMaxSeqNumberInWorkflowTaskSeq();
	//change 06-11
		for (WorkflowTaskSeq worSeq : womax) {
			List<TaskScheduler> task1 = schedularRepo.getArticleBywkIDTaskID(worSeq.getWorkflowId(),
					worSeq.getTaskId());
			if (task1.isEmpty()) {

			} else {
				task.addAll(task1);
			}
		}
		System.out.println(task.toString());
		return task;
	}

	@Override
	public List<TaskScheduler> getAllLastMaxArticleDetail() {
//		List<TaskScheduler> task = new ArrayList<TaskScheduler>();
//		// List<WorkflowTaskSeq> womax =
//		// workflowTaskService.findLastMaxSeqNumberInWorkflowTaskSeq();
//		List<TaskScheduler> task1 = schedularRepo.findAll();
//		HttpServletResponse response;
//		task.addAll(task1);
//	//	MasterDetailsExcelUtils.downloadMasterReports(response, task1);
//		System.out.println(task.toString());
//		return task;
		List<TaskScheduler> task = new ArrayList<TaskScheduler>();
	///	List<WorkflowTaskSeq> wl = new ArrayList<WorkflowTaskSeq>();
		List<WorkflowTaskSeq> womax = workflowTaskService.findLastMaxSeqNumberInWorkflowTaskSeq();
	
		for (WorkflowTaskSeq worSeq : womax) {
			List<TaskScheduler> task1 = schedularRepo.getArticleBywkIDTaskID(worSeq.getWorkflowId(),
					worSeq.getTaskId());
			if (task1.isEmpty()) {

			} else {
				task.addAll(task1);
			}
		}
		System.out.println(task.toString());
		return task;
	}
	
	@Override
	public List<ArticleDetailHavingOverloadvo> getarticleOverDueDetail() {
		return articleRepo.getarticleOverDueDetail();
	}

	@Override
	public List<ArticleDetailplannerVo> getalldetailsplaneer() {
		return articleRepo.getarticlegroupbyToday();
	}

	@Override
	public List<ArticleDetailplannerVo> getarticlegroupby() {
		return articleRepo.getarticlegroupby();
	}

	@Override
	public List<ArticleDetailplannerVo> gettotalarticleOnDeptVirtual() {
		return articleRepo.gettotalarticleOnDeptVirtual();
	}

	@Override
	public List<ArticleDetailplannerVo> gettotalarticleOnDeptTodayVirtual() {
		return articleRepo.gettotalarticleOnDeptTodayVirtual();
	}

	@Override
	public List<LoadReportForcast> getloadforcastreport() {

		return articleRepo.getloadforcastreport();
	}

	@Override
	public List<ArticlePlanner> getarticlePlannerDetails() {

		return articleRepo.getarticlePlannerDetails();
	}

	@Override
	public List<AvilabelLode> getTotalLode() {

		return articleRepo.getTotalLode();
	}

	@Override
	public List<TotelLode> getavilabelLode() {

		return articleRepo.getavilabelLode();
	}

	@Override
	public List<TotelLode> getavilabelLodebyDeptId(int deptId) {

		return articleRepo.getavilabelLodebyDeptId(deptId);
	}

	@Override
	public List<AvilabelLode> getTotalLodebyDeptId(int deptId) {

		return articleRepo.getTotalLodebyDeptId(deptId);
	}

	@Override
	public List<ArticleDetail> getunassignedArticleList() {
		return articleRepo.getunassignedArticleList();
	}

	@Override
	public CopyOnWriteArrayList<ArticleDetailsVO> getunassignedArticleListbyJrId(Integer journalId) {
		return articleRepo.getunassignedArticleListbyJrId(journalId);
	}
	@Override
	public CopyOnWriteArrayList<ArticleDetail> getArticleListbyJrIdGetPage(Integer journalId) {
		return articleRepo.getArticleListbyJrIdGetPage(journalId);
	}

	@Override
	public void save(ArticleComment articleCommen){
		System.out.println("articleCommen: "+articleCommen.toString());
		articleCommentRepo.saveAndFlush(articleCommen);
	}

	@Override
	public List<ArticleComment> getArticleCommentsList(Integer jid, Integer aid) {
		return articleCommentRepo.getArticleComemntsList(jid,aid);
	}

	@Override
	public List<ArticleComment> getTaskArticleCommentsList(Integer jid, Integer aid, Integer taskid) {
		return articleCommentRepo.getTaskArticleCommentsList(jid,aid,taskid);
	}
	@Override
	public List<ArticleDetail> getArticleListbyJrIdPage(Integer journalID, Integer articalId) {
		
		return articleRepo.getArticleListbyJrIdGetPage(journalID,articalId);
	}

	@Override
	public CopyOnWriteArrayList<ArticleDetail> getunassignedArticlebyJrId(Integer journalId) {
		// TODO Auto-generated method stub
		return articleRepo.getunassignedArticlebyJrId(journalId);
	}
	
	@Override
	public CopyOnWriteArrayList<ArticleDetail> getassignedArticlebyJrId(Integer journalId) {
		// TODO Auto-generated method stub
		return articleRepo.getassignedArticlebyJrId(journalId);
	}
	
	@Override
	public List<ArticleDetail> getTotalcountRejected() {
		return articleRepo.getwithdrawRejected();
	}

	@Override
	public List<CurrentArticleStatus> getCurrentArticleList() {
		// TODO Auto-generated method stub
		return currentArticleRepo.findAll();
	}
	
	@Override
	public List<TaskScheduler> getarticleLastStepDetail() {
		List<TaskScheduler> task = new ArrayList<TaskScheduler>();
		List<WorkflowTaskSeq> womax = workflowTaskService.findMaxSeqNumberInWorkflowTaskSeq();
//		List<WorkflowTaskSeq> womax = workflowTaskService.findLastMaxSeqNumberInWorkflowTaskSeq();
		for (WorkflowTaskSeq worSeq : womax) {
			List<TaskScheduler> task1 = schedularRepo.getArticleLastStepBywkIDTaskID(worSeq.getWorkflowId(),
					worSeq.getTaskId());
			if (task1.isEmpty()) {

			} else {
				task.addAll(task1);
			}
		}
		System.out.println(task.toString());
		return task;
	}
	
	@Override
	public List<ArticleTaskDetailsVO> getarticleMastereDetail() {
		return articleRepo.getarticleMasterDetail();
	}
	
	@Override
	@Transactional
	public boolean saveAuthorAPIData(AuthorDataApiModel authorApi) {
		try {
			authorDataApiModelRepo.saveAndFlush(authorApi);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<AuthorDataApiModel> findbyResponseCodeAndTransmit(String code, String Transmit) {
		List<AuthorDataApiModel> authorData=authorDataApiModelRepo.findbyResponseCodeAndTransmit( code,  Transmit);
		return authorData;
	}

	@Override
	public ArticleDetailsVO findByAidWithStatus(String aid) {
		// TODO Auto-generated method stub
		return articleRepo.findByAidWithStatus(aid);
	}
}