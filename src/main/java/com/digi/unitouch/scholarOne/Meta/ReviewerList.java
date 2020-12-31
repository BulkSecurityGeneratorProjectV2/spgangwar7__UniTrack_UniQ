package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("reviewer_list")
public class ReviewerList {

	
	@XStreamAlias("reviewer")
	@XStreamImplicit
	private List<Reviewer> reviewer;

	@Override
	public String toString() {
		return "ReviewerList [reviewer=" + reviewer + "]";
	}
	
	
}
