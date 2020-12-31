package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("journal-title-group")
public class JournaltTitel {
	@XStreamAlias("journal-title")
	private String journalTitle;

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	@Override
	public String toString() {
		return "JournaltTitel [journalTitle=" + journalTitle + "]";
	}

	
}
