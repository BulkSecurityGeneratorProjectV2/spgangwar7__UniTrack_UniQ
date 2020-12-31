package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ms_id")
public class MS {

	@XStreamAlias("rev_id")
	private String revID;

	@XStreamAlias("submitted_date")
	private HistoryDate subittedDate;

	@XStreamAlias("received_date")
	private HistoryDate receivedDate;

	@XStreamAlias("received_date_resub")
	private HistoryDate receivedDatresub;

	@XStreamAlias("revised_date")
	private HistoryDate revisedDate;

	@XStreamAlias("decision_date")
	private HistoryDate dicisionDate;

	@XStreamAlias("approval_date")
	private HistoryDate approvalDate;

	@XStreamAlias("author_returned_date")
	private HistoryDate authorReturnedDate;

	@XStreamAlias("most_recent_decision_date")
	private HistoryDate mostRecentDecisionDate;

	@XStreamAlias("transmission_date")
	private HistoryDate transmissionDate;

	@XStreamAlias("web_publish_date")
	private HistoryDate webPublishDate;

	@XStreamOmitField
	@XStreamAlias("task")
	private Object task;

	
	public String getRevID() {
		return revID;
	}


	public void setRevID(String revID) {
		this.revID = revID;
	}


	public HistoryDate getSubittedDate() {
		return subittedDate;
	}


	public void setSubittedDate(HistoryDate subittedDate) {
		this.subittedDate = subittedDate;
	}


	public HistoryDate getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(HistoryDate receivedDate) {
		this.receivedDate = receivedDate;
	}


	public HistoryDate getReceivedDatresub() {
		return receivedDatresub;
	}


	public void setReceivedDatresub(HistoryDate receivedDatresub) {
		this.receivedDatresub = receivedDatresub;
	}


	public HistoryDate getRevisedDate() {
		return revisedDate;
	}


	public void setRevisedDate(HistoryDate revisedDate) {
		this.revisedDate = revisedDate;
	}


	public HistoryDate getDicisionDate() {
		return dicisionDate;
	}


	public void setDicisionDate(HistoryDate dicisionDate) {
		this.dicisionDate = dicisionDate;
	}


	public HistoryDate getApprovalDate() {
		return approvalDate;
	}


	public void setApprovalDate(HistoryDate approvalDate) {
		this.approvalDate = approvalDate;
	}


	public HistoryDate getAuthorReturnedDate() {
		return authorReturnedDate;
	}


	public void setAuthorReturnedDate(HistoryDate authorReturnedDate) {
		this.authorReturnedDate = authorReturnedDate;
	}


	public HistoryDate getMostRecentDecisionDate() {
		return mostRecentDecisionDate;
	}


	public void setMostRecentDecisionDate(HistoryDate mostRecentDecisionDate) {
		this.mostRecentDecisionDate = mostRecentDecisionDate;
	}


	public HistoryDate getTransmissionDate() {
		return transmissionDate;
	}


	public void setTransmissionDate(HistoryDate transmissionDate) {
		this.transmissionDate = transmissionDate;
	}


	public HistoryDate getWebPublishDate() {
		return webPublishDate;
	}


	public void setWebPublishDate(HistoryDate webPublishDate) {
		this.webPublishDate = webPublishDate;
	}


	public Object getTask() {
		return task;
	}


	public void setTask(Object task) {
		this.task = task;
	}


	@Override
	public String toString() {
		return "MS [revID=" + revID + ", subittedDate=" + subittedDate + ", receivedDate=" + receivedDate
				+ ", receivedDatresub=" + receivedDatresub + ", revisedDate=" + revisedDate + ", dicisionDate="
				+ dicisionDate + ", approvalDate=" + approvalDate + ", authorReturnedDate=" + authorReturnedDate
				+ ", mostRecentDecisionDate=" + mostRecentDecisionDate + ", transmissionDate=" + transmissionDate
				+ ", webPublishDate=" + webPublishDate + ", task=" + task + "]";
	}
	
	
}
