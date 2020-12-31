package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("subj-group")
public class SubjGroup {
	@XStreamAlias("subject")
	private String subject;

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	@Override
	public String toString() {
		return "SubjGroup [subject=" + subject + "]";
	}
	
	
}