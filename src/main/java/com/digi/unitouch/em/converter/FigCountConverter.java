package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.FigCount;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class FigCountConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	FigCount journalidObj = (FigCount) arg0;
        arg1.addAttribute("count", journalidObj.getCount());
        arg1.setValue(journalidObj.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	FigCount journalidObj = new FigCount();
        journalidObj.setValue(arg0.getValue());
        journalidObj.setCount(arg0.getAttribute("count"));
        return journalidObj;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(FigCount.class);
    }

}