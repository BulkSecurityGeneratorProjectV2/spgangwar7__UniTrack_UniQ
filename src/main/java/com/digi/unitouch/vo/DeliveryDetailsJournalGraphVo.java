package com.digi.unitouch.vo;

public class DeliveryDetailsJournalGraphVo {
	private Long count;
	private String journalName;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getJournalName() {
		return journalName;
	}
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	@Override
	public String toString() {
		return "DeliveryDetailsJournalGraphVo [count=" + count + ", journalName=" + journalName + "]";
	}
	public DeliveryDetailsJournalGraphVo(Long count, String journalName) {
		super();
		this.count = count;
		this.journalName = journalName;
	}
	
	
	

	
	
	
	
	
		
	
	}
