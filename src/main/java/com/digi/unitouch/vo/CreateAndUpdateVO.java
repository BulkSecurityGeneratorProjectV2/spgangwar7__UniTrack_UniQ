package com.digi.unitouch.vo;

public class CreateAndUpdateVO {
	
	private String createdBy;
	private String modifiedBy;
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "CreateAndUpdateVO [createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

	
}
