package com.digi.unitouch.vo;

public class TaskProcess {

	private String fileName;
	private String filePath;
	private String processStatus;
	private String processName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Override
	public String toString() {
		return "TaskProcess [fileName=" + fileName + ", filePath=" + filePath + ", processStatus=" + processStatus
				+ ", processName=" + processName + "]";
	}

	
	
	
}
