package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.DateType;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {


@Override
public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
	DateType datatype = (DateType) arg0;
	arg1.addAttribute("date-type", datatype.getDateType());


}

@Override
public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
	DateType datatype = new DateType();
	datatype.setDateType(arg0.getAttribute("date-type"));
	return datatype;
}

@Override
public boolean canConvert(Class arg0) {
	return arg0.equals(DateType.class);
}
}