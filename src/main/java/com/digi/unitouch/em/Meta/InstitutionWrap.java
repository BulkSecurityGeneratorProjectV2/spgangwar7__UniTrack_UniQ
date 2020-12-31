package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("institution-wrap") 
public class InstitutionWrap {


	@XStreamAlias("institution")
	@XStreamImplicit
	private String institution;
	
	
	@XStreamAlias("institution-id")
//	@XStreamConverter(InstitutionIDConverter.class)
	@XStreamImplicit
	private InstitutionID institutionID;
	
}
