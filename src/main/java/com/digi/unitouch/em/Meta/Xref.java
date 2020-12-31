package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("xref")
public class Xref {
	
	@XStreamAlias("ref-type")
	@XStreamAsAttribute
	private String refType="";
	
	@XStreamAlias("rid")
	@XStreamAsAttribute
	private String rid="";

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Xref [refType=" + refType + ", rid=" + rid + "]";
	}

}
