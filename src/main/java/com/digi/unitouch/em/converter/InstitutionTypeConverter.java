package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.InstitutionType;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class InstitutionTypeConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	InstitutionType institutionType = (InstitutionType) arg0;
        arg1.addAttribute("content-type",institutionType.getContentType());
     
        arg1.setValue(institutionType.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	InstitutionType institutionType = new InstitutionType();
    	institutionType.setValue(arg0.getValue());
    	institutionType.setContentType(arg0.getAttribute("content-type"));
    
        return institutionType;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(InstitutionType.class);
    }

}
