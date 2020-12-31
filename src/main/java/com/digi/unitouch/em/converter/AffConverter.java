package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.AffType;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AffConverter implements Converter {

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
		AffType contribType = (AffType) arg0;
		arg1.addAttribute("id", contribType.getId());


	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
		AffType contribType = new AffType();
		contribType.setId(arg0.getAttribute("corresp"));
		return contribType;
	}

	@Override
	public boolean canConvert(Class arg0) {
		return arg0.equals(AffType.class);
	}
}
