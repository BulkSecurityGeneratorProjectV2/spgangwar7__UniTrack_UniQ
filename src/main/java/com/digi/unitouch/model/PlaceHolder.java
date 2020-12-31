package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="placeholder")
@Entity
public class PlaceHolder {
	
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="p_id")
	private Integer pId;
	
	@Column(name="p_name")
	private String placeHoldername;
	
	@Column(name="created_at")

	private Date createAt;
	
	@Column(name="created_by")
	private String createdBy;

	
	
	public Integer getpId() {
		return pId;
	}



	public void setpId(Integer pId) {
		this.pId = pId;
	}



	public String getPlaceHoldername() {
		return placeHoldername;
	}



	public void setPlaceHoldername(String placeHoldername) {
		this.placeHoldername = placeHoldername;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	@Override
	public String toString() {
		return "PlaceHolder [pId=" + pId + ", placeHoldername=" + placeHoldername + ", createAt=" + createAt
				+ ", createdBy=" + createdBy + "]";
	}

	
}
