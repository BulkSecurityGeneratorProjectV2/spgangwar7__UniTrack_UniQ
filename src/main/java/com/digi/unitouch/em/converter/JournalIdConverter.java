package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.JournaID;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class JournalIdConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	JournaID journalidObj = (JournaID) arg0;
        arg1.addAttribute("journal-id-type", journalidObj.getJournalIdType());
        arg1.setValue(journalidObj.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	JournaID journalidObj = new JournaID();
        journalidObj.setValue(arg0.getValue());
        journalidObj.setJournalIdType(arg0.getAttribute("journal-id-type"));
        return journalidObj;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(JournaID.class);
    }

}
