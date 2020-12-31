package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class GraphicConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	GraphicLink graphicLink = (GraphicLink) arg0;
        arg1.addAttribute("xlink:href",graphicLink.getHref());
        arg1.addAttribute("xmlns:xlink",graphicLink.getXlink());
        arg1.setValue(graphicLink.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	GraphicLink graphicLink = new GraphicLink();
    	graphicLink.setValue(arg0.getValue());
    	graphicLink.setHref(arg0.getAttribute("xlink:href"));
    	graphicLink.setXlink(arg0.getAttribute("xmlns:xlink"));
        return graphicLink;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(GraphicLink.class);
    }

}
