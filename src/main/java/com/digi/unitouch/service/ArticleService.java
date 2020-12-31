package com.digi.unitouch.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.digi.unitouch.model.ArticleComment;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorDataApiModel;
import com.digi.unitouch.model.CurrentArticleStatus;
import com.digi.unitouch.model.TaskScheduler;
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

public interface ArticleService {

	public int saveArticle(ArticleDetail articleDetail);
	
	public List<ArticleDetail> getallList();

	public ArticleDetail findArticleDetailBy(int id);

	public abstract ArticleDetail findByAid(String aid);
	
	public ArticleDetailsVO findByAidWithStatus(String aid);
	
	public void updateArticleDetail(ArticleDetail updateArticle);

	public String deleteArticleDetailById(int id);

	public List<ArticleDetailvo> getArticleDetailList(String article_title, String article_doi, String article_type_cd, String publisherName,String journalAbbr,String aid,String keywords,String lName,String authorEmail,String articleStatus);

	public void saveCurrentArticleStatus(CurrentArticleStatus currentArticleStatus);

	public List<ArticleSearchDetailvo> getArticleSearchDetailList(int article_id);

	public CurrentArticleStatus findCurrentArticleStatusBy(int taskID, int aid);

	public void saveCurrentArticleTaskStatus(CurrentArticleStatus currentArticleStatus);

	public CurrentArticleStatus findArticleStatusBy(int aid);

	public List<TaskManagementVocArt> getArticleDetailListByArtId(int articleId);

	public List<ArticleDetailHavingOverloadvo> getarticleInProgressDetail();

	public List<TaskScheduler> getarticleCompleteDetail();

	public List<ArticleDetailHavingOverloadvo> getarticleOverDueDetail();

	public List<LoadReportForcast> getloadforcastreport();

	public List<ArticlePlanner> getarticlePlannerDetails();

	public List<AvilabelLode> getTotalLode();

	public List<TotelLode> getavilabelLode();

	public List<TotelLode> getavilabelLodebyDeptId(int deptId);

	public List<AvilabelLode> getTotalLodebyDeptId(int deptId);

	public List<ArticleDetailplannerVo> getalldetailsplaneer();

	public List<ArticleDetailplannerVo> getarticlegroupby();

	public List<ArticleDetailplannerVo> gettotalarticleOnDeptVirtual();

	public List<ArticleDetailplannerVo> gettotalarticleOnDeptTodayVirtual();

	public List<ArticleDetail> getunassignedArticleList();

	public CopyOnWriteArrayList<ArticleDetailsVO> getunassignedArticleListbyJrId(Integer journalId);

	public CopyOnWriteArrayList<ArticleDetail> getunassignedArticlebyJrId(Integer journalId);
	
	void save(ArticleComment articleCommen);
	
	public List<ArticleComment> getArticleCommentsList(Integer jid, Integer aid);

	public List<ArticleComment> getTaskArticleCommentsList(Integer jid, Integer aid, Integer taskid);

	CopyOnWriteArrayList<ArticleDetail> getArticleListbyJrIdGetPage(Integer journalId);

	public boolean withdrawArtical(String status,Integer articleID);
	
	public List<ArticleDetail> getArticleListbyJrIdPage(Integer journalID, Integer articalId);

	public List<ArticleDetailsVO> getarticleDetail();

	public List<ArticleDetail> getTotalcountRejected();
	
	public List<CurrentArticleStatus> getCurrentArticleList();

	List<TaskScheduler> getarticleLastStepDetail();

	public List<ArticleTaskDetailsVO> getarticleMastereDetail();

	List<TaskScheduler> getAllLastMaxArticleDetail();

	CopyOnWriteArrayList<ArticleDetail> getassignedArticlebyJrId(Integer journalId);

	List<ArticleDetailsVO> getarticleDetailByjournalID(Integer journalID);

	public boolean saveAuthorAPIData(AuthorDataApiModel authorApi);
	
	public List<AuthorDataApiModel> findbyResponseCodeAndTransmit(String code,String Transmit);

	public List<TaskScheduler> getAllData();
}
