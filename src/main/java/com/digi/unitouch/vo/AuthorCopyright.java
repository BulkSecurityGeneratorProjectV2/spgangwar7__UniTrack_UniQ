package com.digi.unitouch.vo;

public class AuthorCopyright {

	private String manuScriptId;
	private String copyrightStatus;
	private String authorEmail;

	public AuthorCopyright() {
		super();
	}

	public AuthorCopyright(String manuScriptId, String copyrightStatus, String authorEmail) {
		super();
		this.manuScriptId = manuScriptId;
		this.copyrightStatus = copyrightStatus;
		this.authorEmail = authorEmail;
	}

	public String getManuScriptId() {
		return manuScriptId;
	}

	public void setManuScriptId(String manuScriptId) {
		this.manuScriptId = manuScriptId;
	}

	public String getCopyrightStatus() {
		return copyrightStatus;
	}

	public void setCopyrightStatus(String copyrightStatus) {
		this.copyrightStatus = copyrightStatus;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	@Override
	public String toString() {
		return "AuthorCopyright [manuScriptId=" + manuScriptId + ", copyrightStatus=" + copyrightStatus
				+ ", authorEmail=" + authorEmail + "]";
	}

}
