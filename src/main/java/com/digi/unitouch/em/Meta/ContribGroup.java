package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.AffConverter;
import com.digi.unitouch.em.converter.ContribConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("contrib-group")
public class ContribGroup {

	@XStreamAlias("contrib")
	@XStreamImplicit
	@XStreamConverter(ContribConverter.class)
	private List<Contrib> contrib;

	
	@XStreamAlias("aff")
	@XStreamImplicit
	@XStreamConverter(AffConverter.class)
	private List<Aff> aff;


	public List<Contrib> getContrib() {
		return contrib;
	}


	public void setContrib(List<Contrib> contrib) {
		this.contrib = contrib;
	}


	public List<Aff> getAff() {
		return aff;
	}


	public void setAff(List<Aff> aff) {
		this.aff = aff;
	}


	@Override
	public String toString() {
		return "ContribGroup [contrib=" + contrib + ", aff=" + aff + "]";
	}
	

	
}

