
package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ArticleTaskDetail;
import com.digi.unitouch.repository.ArticleTaskDetailRepo;
import com.digi.unitouch.repository.TaskRepo;
import com.digi.unitouch.service.ArticleTaskDetailService;

@Service

@Transactional
public class ArticleTaskDetailServiceImpl implements ArticleTaskDetailService {

	@Autowired
	ArticleTaskDetailRepo articleTaskDetailRepo;
	


	@Override
	public void saveArticleTaskDetail(ArticleTaskDetail articleTaskDetail) {
		articleTaskDetailRepo.save(articleTaskDetail);

	}

	@Override
	public ArticleTaskDetail findtaskDetailById(int taskID) {
		return articleTaskDetailRepo.findtaskDetailById(taskID);
	}

	@Override
	public ArticleTaskDetail findtaskDetailById(int taskID, Integer aid) {
		return articleTaskDetailRepo.findtaskDetailById(taskID,aid);
	}
	@Override
	public void saveArticleTaskStatus(ArticleTaskDetail articleTaskDetail) {
		articleTaskDetailRepo.save(articleTaskDetail);

	}

	@Override
	public List<ArticleTaskDetail> findUserWiseProductivity(Integer userID) {

		return articleTaskDetailRepo.findUserWiseProductivity(userID);
	}


	@Override
	public List<ArticleTaskDetail> getTotalcountByStatusRejected(String status) {
		return articleTaskDetailRepo.getTotalcountByStatus(status);
	}
	
//		@Override
//		public ArticleTaskDetail findRecordByArticleTaskID(int id) {
//			return articleTaskDetailRepo.findRecordByArticleTaskID(id);
//		}
//		  

}
