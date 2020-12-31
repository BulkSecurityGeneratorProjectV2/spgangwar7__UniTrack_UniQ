package com.digi.unitouch.util;

import org.springframework.stereotype.Component;

@Component
public class FilVerVo {
	String filename = "";
	Integer updateNumber;

	public FilVerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FilVerVo(String filename, Integer updateNumber) {
		super();
		this.filename = filename;
		this.updateNumber = updateNumber;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getUpdateNumber() {
		return updateNumber;
	}

	public void setUpdateNumber(Integer updateNumber) {
		this.updateNumber = updateNumber;
	}

	@Override
	public String toString() {
		return "FilVerVo [filename=" + filename + ", updateNumber=" + updateNumber + "]";
	}

}