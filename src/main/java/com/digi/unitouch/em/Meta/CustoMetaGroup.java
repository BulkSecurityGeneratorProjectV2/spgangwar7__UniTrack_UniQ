package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("custom-meta-group")
public class CustoMetaGroup {
	
	@XStreamAlias("custom-meta")
	@XStreamImplicit
	private List<CustomMeta> custometa;

	@Override
	public String toString() {
		return "CustoMetaGroup [custometa=" + custometa + "]";
	}

	
}
