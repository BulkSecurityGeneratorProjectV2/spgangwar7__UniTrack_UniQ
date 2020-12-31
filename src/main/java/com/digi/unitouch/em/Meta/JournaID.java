package com.digi.unitouch.em.Meta;

public class JournaID {
	
	private String journalIdType="";
	
	private String value="";

	public String getJournalIdType() {
		return journalIdType;
	}

	public void setJournalIdType(String journalIdType) {
		this.journalIdType = journalIdType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "JournaID [journalIdType=" + journalIdType + ", value=" + value + "]";
	}
	
	
}
