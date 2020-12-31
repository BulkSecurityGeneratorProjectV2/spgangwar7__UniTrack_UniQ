
package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.AddrLine;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AddrLineConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	AddrLine addrLine = (AddrLine) arg0;
        arg1.addAttribute("content-type", addrLine.getContentType());
        arg1.setValue(addrLine.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	AddrLine addrLine = new AddrLine();
    	addrLine.setValue(arg0.getValue());
    	addrLine.setContentType(arg0.getAttribute("content-type"));
        return addrLine;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(AddrLine.class);
    }

}
