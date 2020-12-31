package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.FigCountConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("counts")
public class Counts {

	@XStreamAlias("fig-count")
	@XStreamImplicit
	@XStreamConverter(FigCountConverter.class)
	private List<FigCount> figCount;

	@Override
	public String toString() {
		return "Counts [figcount=" + figCount + "]";
	}
	
	
}
