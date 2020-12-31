package com.digi.unitouch.scholarOne.Main;

import com.digi.unitouch.scholarOne.Meta.Issn;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class IssnConverterScholar implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
        Issn issnObj = (Issn) arg0;
        arg1.addAttribute("issn_type", issnObj.getIssnType());
        arg1.setValue(issnObj.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
        Issn issnObj = new Issn();
        issnObj.setValue(arg0.getValue());
        issnObj.setIssnType(arg0.getAttribute("issn_type"));
        return issnObj;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(Issn.class);
    }

}