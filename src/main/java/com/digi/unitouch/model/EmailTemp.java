package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "email_template")
/* @Component */
public class EmailTemp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id")
	private Integer id;

	@Column(name="email_tempname")
	private String emailTempName; 
	
	@Column(name = "email_subject")
	private String toSubject;
	
	@Column(name = "email_body")
	private String editorData;

	@Column(name = "finish_subject")
	private String finishSubject;
	
	@Column(name = "finish_body")
	private String finishBody;
	
	@Column(name = "reply_subject")
	private String replySubject;
	
	@Column(name = "reply_body")
	private String replyBody;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getEmailTempName() {
		return emailTempName;
	}

	public void setEmailTempName(String emailTempName) {
		this.emailTempName = emailTempName;
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
		return "EmailTemp [id=" + id + ", emailTempName=" + emailTempName + ", toSubject=" + toSubject + ", editorData="
				+ editorData + ", finishSubject=" + finishSubject + ", finishBody=" + finishBody + ", replySubject="
				+ replySubject + ", replyBody=" + replyBody + "]";
	}
	
}