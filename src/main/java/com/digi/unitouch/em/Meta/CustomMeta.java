package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("custom-meta")
public class CustomMeta {
	
	@XStreamAlias("meta-name")
	@XStreamImplicit
	private List<String> metaName;

	@XStreamAlias("meta-value")
	@XStreamImplicit
	private List<String> metaValue;

	@Override
	public String toString() {
		return "CustomMeta [metaName=" + metaName + ", metaValue=" + metaValue + "]";
	}

	
}
