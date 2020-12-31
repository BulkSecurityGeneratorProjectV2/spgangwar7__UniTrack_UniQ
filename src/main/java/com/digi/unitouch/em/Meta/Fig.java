package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("fig")
public class Fig {

	@XStreamAsAttribute
	@XStreamAlias("label")
	private String label;

	@XStreamAsAttribute
	@XStreamAlias("graphic")
	@XStreamConverter(GraphicConverter.class)
	private GraphicLink graphic;


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	@Override
	public String toString() {
		return "Fig [label=" + label + ", graphic=" + graphic + "]";
	}


	
	
}
