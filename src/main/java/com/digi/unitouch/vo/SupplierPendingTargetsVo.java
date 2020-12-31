package com.digi.unitouch.vo;

public class SupplierPendingTargetsVo {
	private Long count;
	private Integer deptId;
    private String journalName;
    private String articelTitle;
    private Integer articelId;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getJournalName() {
		return journalName;
	}
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	public String getArticelTitle() {
		return articelTitle;
	}
	public void setArticelTitle(String articelTitle) {
		this.articelTitle = articelTitle;
	}
	
	public Integer getArticelId() {
		return articelId;
	}
	public void setArticelId(Integer articelId) {
		this.articelId = articelId;
	}
	@Override
	public String toString() {
		return "SupplierPendingTargetsVo [count=" + count + ", deptId=" + deptId + ", journalName=" + journalName
				+ ", articelTitle=" + articelTitle + ", articelId=" + articelId + "]";
	}
	public SupplierPendingTargetsVo(Long count, Integer deptId, String journalName, String articelTitle,
			Integer articelId) {
		super();
		this.count = count;
		this.deptId = deptId;
		this.journalName = journalName;
		this.articelTitle = articelTitle;
		this.articelId = articelId;
	}


	
	
	
	
		
	
	}
