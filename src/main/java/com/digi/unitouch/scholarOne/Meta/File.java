package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("file")
public class File {
	
	@XStreamAlias("file_createddate")
	private String fileCreateddate;


	@XStreamAlias("file_designation")
	private String fileDesignation;

	@XStreamAlias("file_format")
	private String file_format;

	@XStreamAlias("file_extension")
	private String file_extension;

	@XStreamAlias("file_originalname")
	private String file_originalname;

	@XStreamAlias("file_caption")
	private String file_caption;

	@XStreamAlias("file_tag")
	private String file_tag;

	@XStreamAlias("attribute")
	private String attribute;

	@XStreamAlias("num_pages_calc")
	private String num_pages_calc;
	
	@XStreamAlias("num_pages_actual")
	private String num_pages_actual;

	@Override
	public String toString() {
		return "FileList [fileCreateddate=" + fileCreateddate + ", fileDesignation=" + fileDesignation
				+ ", file_format=" + file_format + ", file_extension=" + file_extension + ", file_originalname="
				+ file_originalname + ", file_caption=" + file_caption + ", file_tag=" + file_tag + ", attribute="
				+ attribute + ", num_pages_calc=" + num_pages_calc + ", num_pages_actual=" + num_pages_actual + "]";
	}
}
