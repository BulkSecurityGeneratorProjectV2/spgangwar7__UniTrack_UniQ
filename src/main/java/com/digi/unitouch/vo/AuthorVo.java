package com.digi.unitouch.vo;

import java.util.Arrays;

public class AuthorVo {
	
	private String[] title;
	private String[] fname;
	private String[] lname;
	private String[] mname;
	private String[] email;
	private String[] is_corresponding;
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	public String[] getFname() {
		return fname;
	}
	public void setFname(String[] fname) {
		this.fname = fname;
	}
	public String[] getLname() {
		return lname;
	}
	public void setLname(String[] lname) {
		this.lname = lname;
	}
	public String[] getMname() {
		return mname;
	}
	public void setMname(String[] mname) {
		this.mname = mname;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public String[] getIs_corresponding() {
		return is_corresponding;
	}
	public void setIs_corresponding(String[] is_corresponding) {
		this.is_corresponding = is_corresponding;
	}
	@Override
	public String toString() {
		return "AuthorVo [title=" + Arrays.toString(title) + ", fname=" + Arrays.toString(fname) + ", lname="
				+ Arrays.toString(lname) + ", mname=" + Arrays.toString(mname) + ", email=" + Arrays.toString(email)
				+ ", is_corresponding=" + Arrays.toString(is_corresponding) + "]";
	}
	

	
}
