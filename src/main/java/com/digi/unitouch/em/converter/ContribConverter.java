package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.ContribType;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ContribConverter implements Converter {

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
		// TODO Auto-generated method stub
		ContribType contribType = (ContribType) arg0;
		arg1.addAttribute("contrib-type", contribType.getContribtype());
		arg1.addAttribute("corresp", contribType.getCorresp());
		// arg1.setValue(journalidObj.getValue());

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
		// TODO Auto-generated method stub
		ContribType contribType = new ContribType();
		contribType.setCorresp(arg0.getAttribute("corresp"));
		contribType.setContribtype(arg0.getAttribute("contrib-type"));
		return contribType;
	}

	@Override
	public boolean canConvert(Class arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(ContribType.class);
	}
}
