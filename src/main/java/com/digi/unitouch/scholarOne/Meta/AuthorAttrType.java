package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("attr_type")
public class AuthorAttrType {
	
	@XStreamAlias("attribute")
	@XStreamImplicit
	private List<String> attribute;

	@Override
	public String toString() {
		return "AuthorAttrType [attribute=" + attribute + "]";
	}
	
	

}
