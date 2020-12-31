package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.InstitutionID;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class InstitutionIDConverter implements Converter {

	  @Override
	    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
	        // TODO Auto-generated method stub
		  InstitutionID institution = (InstitutionID) arg0;
	        arg1.addAttribute("institution-id-type", institution.getInstitutionIdType());
	        arg1.setValue(institution.getValue());

	    }

	    @Override
	    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
	        // TODO Auto-generated method stub
	    	InstitutionID institution = new InstitutionID();
	    	institution.setValue(arg0.getValue());
	    	institution.setInstitutionIdType(arg0.getAttribute("institution-id-type"));
	        return institution;
	    }

	    @Override
	    public boolean canConvert(Class arg0) {
	        // TODO Auto-generated method stub
	        return arg0.equals(InstitutionID.class);
	    }
}
