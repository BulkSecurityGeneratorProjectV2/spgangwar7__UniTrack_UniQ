package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.ArticleTaskDetail;

public   interface ArticleTaskDetailService {

	public abstract void saveArticleTaskDetail(ArticleTaskDetail articleTaskDetail);

	public  ArticleTaskDetail findtaskDetailById(int taskID, Integer articleID);

	public abstract void saveArticleTaskStatus(ArticleTaskDetail articleTaskDetail) ;

	//ArticleTaskDetail findRecordByArticleTaskID(int id);
	public abstract List<ArticleTaskDetail> findUserWiseProductivity(Integer userID);

	ArticleTaskDetail findtaskDetailById(int taskID);

	public abstract List<ArticleTaskDetail> getTotalcountByStatusRejected(String status);
	
}
