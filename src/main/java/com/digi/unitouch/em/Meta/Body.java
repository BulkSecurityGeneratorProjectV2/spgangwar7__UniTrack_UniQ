package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("body")
public class Body {
	
	@XStreamAlias("fig")
	@XStreamImplicit
	private List<Fig> fig;

	@XStreamAlias("table-wrap")
	@XStreamImplicit
	private List<TableWrap> tableWrap;
	
	
	public List<Fig> getFig() {
		return fig;
	}


	public void setFig(List<Fig> fig) {
		this.fig = fig;
	}


	public List<TableWrap> getTableWrap() {
		return tableWrap;
	}


	public void setTableWrap(List<TableWrap> tableWrap) {
		this.tableWrap = tableWrap;
	}


	@Override
	public String toString() {
		return "Body [fig=" + fig + ", tableWrap=" + tableWrap + "]";
	}
	
	
	
}
