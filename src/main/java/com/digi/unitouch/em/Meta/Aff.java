package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.AddrLineConverter;
import com.digi.unitouch.em.converter.InstitutionTypeConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Aff {

	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;

//	@XStreamAlias("institution-wrap") 
//	@XStreamImplicit
//	private InstitutionWrap institutionWrap; 

	@XStreamAlias("institution-wrap") 
	@XStreamAsAttribute
	private String institutionWrap; 
	
	
	@XStreamAlias("institution")
	@XStreamAsAttribute
	private String institution;

	
	@XStreamAlias("institution")
	@XStreamImplicit
	@XStreamConverter(InstitutionTypeConverter.class)
	private List<InstitutionType> institutionType;
	
	@XStreamAlias("addr-line")
	@XStreamImplicit
	@XStreamConverter(AddrLineConverter.class)
	private List<AddrLine> addrLine;
	
//	@XStreamAlias("addr-line")
//	@XStreamAsAttribute
//	private String addrLine;
	
	@XStreamAlias("country")
	@XStreamAsAttribute
	private String country;
	
	@XStreamAlias("phone")
	@XStreamAsAttribute
	private String phone;

	@Override
	public String toString() {
		return "Aff [id=" + id + ", institutionWrap=" + institutionWrap + ", institution=" + institution
				+ ", institutionType=" + institutionType + ", addrLine=" + addrLine + ", country=" + country
				+ ", phone=" + phone + "]";
	}

	
}
