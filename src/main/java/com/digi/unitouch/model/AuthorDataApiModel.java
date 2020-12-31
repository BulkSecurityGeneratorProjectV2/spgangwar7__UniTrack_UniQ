package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author 80055
 *
 */
@Entity
@Table(name = "author_api_data")
@Component
public class AuthorDataApiModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="aad_id")
	private Integer aadId;
	
	@Column(name="manuscript_code")
	private String manuscriptCode="";
	
	@Column(name="manuscript_status_id")
	private String manuscriptStatusId="";
	
	@Column(name="input_file")
	private String inputFile="";
	
	@Column(name="output_file")
	private String outputFile="";
	
	@Column(name="manuscript_task_id")
	private String manuscriptTaskId;
	
	@Column(name="file_type")
	private String fileType="";
	
	@Column(name="is_recheck")
	private String isRecheck="";
	
	@Column(name="no_change_approved")
	private String noChangeApproved="";

	@Column(name="comment")
	private String commentFromProduction="";
	
//	@Column(name="file_path_map")
//	private String  filePathMap="";

	@Column(name="api_url")
	private String apiUrl;
	
	@Column(name="transmit")
	private String transmit;
	
	@Column(name="response_code")
	private String response_code;
	
	@Column(name="info_time")
	private Date infoTime;


	public Integer getAadId() {
		return aadId;
	}


	public void setAadId(Integer aadId) {
		this.aadId = aadId;
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


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
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



//
//	public String getFilePathMap() {
//		return filePathMap;
//	}
//
//
//	public void setFilePathMap(String filePathMap) {
//		this.filePathMap = filePathMap;
//	}


	public String getCommentFromProduction() {
		return commentFromProduction;
	}


	public void setCommentFromProduction(String commentFromProduction) {
		this.commentFromProduction = commentFromProduction;
	}


	public String getTransmit() {
		return transmit;
	}


	public String getApiUrl() {
		return apiUrl;
	}


	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}


	public void setTransmit(String transmit) {
		this.transmit = transmit;
	}


	public String getResponse_code() {
		return response_code;
	}


	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}


	public Date getInfoTime() {
		return infoTime;
	}


	public void setInfoTime(Date infoTime) {
		this.infoTime = infoTime;
	}


	@Override
	public String toString() {
		return "AuthorDataApiModel [aadId=" + aadId + ", manuscriptCode=" + manuscriptCode + ", manuscriptStatusId="
				+ manuscriptStatusId + ", inputFile=" + inputFile + ", outputFile=" + outputFile + ", manuscriptTaskId="
				+ manuscriptTaskId + ", fileType=" + fileType + ", isRecheck=" + isRecheck + ", noChangeApproved="
				+ noChangeApproved + ", commentFromProduction=" + commentFromProduction  + ", transmit=" + transmit
				+ ", response_code=" + response_code + ", infoTime=" + infoTime + "]";
	}


	

}