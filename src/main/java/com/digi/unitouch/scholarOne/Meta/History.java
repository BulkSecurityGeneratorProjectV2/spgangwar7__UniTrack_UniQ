package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("history")
public class History {
	
	@XStreamAlias("ms_id")
	@XStreamImplicit
	private List<MS> msId;
	
	
	public List<MS> getMsId() {
		return msId;
	}


	public void setMsId(List<MS> msId) {
		this.msId = msId;
	}


	@Override
	public String toString() {
		return "History [msId=" + msId + "]";
	}


	
}
