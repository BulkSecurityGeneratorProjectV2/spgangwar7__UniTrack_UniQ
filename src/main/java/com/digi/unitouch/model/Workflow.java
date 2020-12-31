package com.digi.unitouch.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.digi.unitouch.util.DateApi;

@Entity
@Table(name="workflow")
public class Workflow {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "workflow_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "workflow_type")
	private String workflowType;
	
	@Column(name = "created_by")
	private String createdBY ;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_at")
	private Date createdAT;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}

	public String getCreatedBY() {
		return createdBY;
	}

	public void setCreatedBY(String createdBY) {
		this.createdBY = createdBY;
	}

	public String getCreatedAT() throws ParseException {
		return DateApi.LocalDateTimeApi(createdAT);
	}

	public void setCreatedAT(Date createdAT) {
		this.createdAT = createdAT;
	}

	@Override
	public String toString() {
		return "Workflow [id=" + id + ", name=" + name + ", status=" + status + ", workflowType=" + workflowType
				+ ", createdBY=" + createdBY + ", createdAT=" + createdAT + "]";
	}

}
