package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueTaskDetail;

public interface IssueTaskDetailRepo extends JpaRepository<IssueTaskDetail, Integer> {

	 @Query(value="SELECT itd FROM IssueTaskDetail itd WHERE itd.issueTaskId=?1")
	IssueTaskDetail findtaskDetailById(Integer issuetaskId);

	 @Query(value="SELECT itd FROM IssueTaskDetail itd WHERE itd.issueTaskId=?1 and itd.issueId=?2" )
	IssueTaskDetail getIssueTaskScheById(int taskId, int issueId);

}
