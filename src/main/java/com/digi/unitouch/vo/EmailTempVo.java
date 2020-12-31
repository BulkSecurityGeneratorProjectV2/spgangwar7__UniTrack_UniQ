package com.digi.unitouch.vo;

public class EmailTempVo {

	private Integer tempId;
	private String toEmail;
	private String toFrom;
	private String toCc;
	private String templateName;
	private String toSubject;
	private String editorData;
	private String finishSubject;
	private String finishBody;
	private String replySubject;
	private String replyBody;
	
	

	public Integer getTempId() {
		return tempId;
	}

	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getToFrom() {
		return toFrom;
	}

	public void setToFrom(String toFrom) {
		this.toFrom = toFrom;
	}

	public String getToCc() {
		return toCc;
	}

	public void setToCc(String toCc) {
		this.toCc = toCc;
	}


	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getToSubject() {
		return toSubject;
	}

	public void setToSubject(String toSubject) {
		this.toSubject = toSubject;
	}

	public String getEditorData() {
		return editorData;
	}

	public void setEditorData(String editorData) {
		this.editorData = editorData;
	}

	
	public String getFinishSubject() {
		return finishSubject;
	}

	public void setFinishSubject(String finishSubject) {
		this.finishSubject = finishSubject;
	}

	public String getFinishBody() {
		return finishBody;
	}

	public void setFinishBody(String finishBody) {
		this.finishBody = finishBody;
	}

	public String getReplySubject() {
		return replySubject;
	}

	public void setReplySubject(String replySubject) {
		this.replySubject = replySubject;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	@Override
	public String toString() {
		return "EmailTempVo [tempId=" + tempId + ", toEmail=" + toEmail + ", toFrom=" + toFrom + ", toCc=" + toCc
				+ ", templateName=" + templateName + ", toSubject=" + toSubject + ", editorData=" + editorData
				+ ", finishSubject=" + finishSubject + ", finishBody=" + finishBody + ", replySubject=" + replySubject
				+ ", replyBody=" + replyBody + "]";
	}

}
