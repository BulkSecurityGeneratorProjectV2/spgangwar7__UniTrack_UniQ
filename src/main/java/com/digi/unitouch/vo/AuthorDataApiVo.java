package com.digi.unitouch.vo;

import java.util.HashMap;
import java.util.Map;

public class AuthorDataApiVo {

	private String manuscriptCode;
	private String manuscriptStatusId;
	private String inputFile;
	private String outputFile;
	private String manuscriptTaskId;
	private String fileType;
	private String isRecheck;
	private String noChangeApproved;
	private String	comment;
	private String commentFromProduction;
	private Map<String, String> filePathMap= new HashMap<String, String>();
	public AuthorDataApiVo() {
		super();
	}

//	public AuthorDataApiVo(String manuscriptCode, String manuscriptStatusId, String inputFile, 
//			String outputFile,String articleTaskID,String fileType) {
//		super();
//		this.manuscriptCode = manuscriptCode;
//		this.manuscriptStatusId = manuscriptStatusId;
//		this.inputFile = inputFile;
//		this.outputFile = outputFile;
//		this.manuscriptTaskId=articleTaskID;
//		this.fileType=fileType;
//	}

	public AuthorDataApiVo(String manuscriptCode, String manuscriptStatusId, String inputFile, 
			String outputFile,String articleTaskID,String fileType,String commentFromProduction) {
		super();
		this.manuscriptCode = manuscriptCode;
		this.manuscriptStatusId = manuscriptStatusId;
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		this.manuscriptTaskId=articleTaskID;
		this.fileType=fileType;
		this.commentFromProduction=commentFromProduction;
	}

	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getManuscriptCode() {
		return manuscriptCode;
	}

	public void setManuscriptCode(String manuscriptCode) {
		this.manuscriptCode = manuscriptCode;
	}

	public String getManuscriptStatusId() {
		return manuscriptStatusId;
	}

	public void setManuscriptStatusId(String manuscriptStatusId) {
		this.manuscriptStatusId = manuscriptStatusId;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	
	public String getManuscriptTaskId() {
		return manuscriptTaskId;
	}

	public void setManuscriptTaskId(String manuscriptTaskId) {
		this.manuscriptTaskId = manuscriptTaskId;
	}

	public String getIsRecheck() {
		return isRecheck;
	}

	public void setIsRecheck(String isRecheck) {
		this.isRecheck = isRecheck;
	}

	public String getNoChangeApproved() {
		return noChangeApproved;
	}

	public void setNoChangeApproved(String noChangeApproved) {
		this.noChangeApproved = noChangeApproved;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Map<String, String> getFilePathMap() {
		return filePathMap;
	}

	public void setFilePathMap(Map<String, String> filePathMap) {
		this.filePathMap = filePathMap;
	}

	public String getCommentFromProduction() {
		return commentFromProduction;
	}

	public void setCommentFromProduction(String commentFromProduction) {
		this.commentFromProduction = commentFromProduction;
	}

	@Override
	public String toString() {
		return "AuthorDataApiVo [manuscriptCode=" + manuscriptCode + ", manuscriptStatusId=" + manuscriptStatusId
				+ ", inputFile=" + inputFile + ", outputFile=" + outputFile + ", manuscriptTaskId=" + manuscriptTaskId
				+ ", fileType=" + fileType + ", isRecheck=" + isRecheck + ", noChangeApproved=" + noChangeApproved
				+ ", comment=" + comment + ", commentFromProduction=" + commentFromProduction + ", filePathMap="
				+ filePathMap + "]";
	}




}
