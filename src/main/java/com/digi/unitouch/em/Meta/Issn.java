package com.digi.unitouch.em.Meta;

public class Issn {

    private String issnType = "";
    private String value = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIssnType() {
        return issnType;
    }

    public void setIssnType(String issnType) {
        this.issnType = issnType;
    }

	@Override
	public String toString() {
		return "Issn [issnType=" + issnType + ", value=" + value + "]";
	}

}
