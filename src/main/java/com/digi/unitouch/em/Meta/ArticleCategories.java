package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.SubjGroupConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("article-categories")
public class ArticleCategories {
	
	
	@XStreamAlias("subj-group")
	@XStreamImplicit
	@XStreamConverter(SubjGroupConverter.class)
	private List<SubjGroup> subjGroup;

	
	public List<SubjGroup> getSubjGroup() {
		return subjGroup;
	}


	public void setSubjGroup(List<SubjGroup> subjGroup) {
		this.subjGroup = subjGroup;
	}


	@Override
	public String toString() {
		return "ArticleCategories [subjGroup=" + subjGroup + "]";
	}

	
}