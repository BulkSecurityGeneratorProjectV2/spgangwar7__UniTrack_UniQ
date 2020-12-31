package com.digi.unitouch.vo;

public class Attachment 
{
	String image_file_name;
	String image_type;
	String legend;
	String citation;
	public Attachment() {}
	public Attachment(String image_file_name, String image_type, String legend, String citation) {
		super();
		this.image_file_name = image_file_name;
		this.image_type = image_type;
		this.legend = legend;
		this.citation = citation;
	}
	public String getImage_file_name() {
		return image_file_name;
	}
	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}
	public String getImage_type() {
		return image_type;
	}
	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	public String getLegend() {
		return legend;
	}
	public void setLegend(String legend) {
		this.legend = legend;
	}
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	@Override
	public String toString() {
		return "Attachment [image_file_name=" + image_file_name + ", image_type=" + image_type + ", legend=" + legend
				+ ", citation=" + citation + "]";
	}

}
