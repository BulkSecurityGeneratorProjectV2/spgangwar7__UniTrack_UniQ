package com.digi.unitouch.em.Meta;

public class InstitutionID {

private String institutionIdType="";
	
	private String value="";



	public String getInstitutionIdType() {
		return institutionIdType;
	}

	public void setInstitutionIdType(String institutionIdType) {
		this.institutionIdType = institutionIdType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "InstitutionID [institutionIdType=" + institutionIdType + ", value=" + value + "]";
	}

	
}
