package com.digi.unitouch.em.converter;
//package com.xStream;
//
//import com.thoughtworks.xstream.converters.Converter;
//import com.thoughtworks.xstream.converters.MarshallingContext;
//import com.thoughtworks.xstream.converters.UnmarshallingContext;
//import com.thoughtworks.xstream.io.HierarchicalStreamReader;
//import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//
//public class XrefConverter implements Converter {
//
//    @Override
//    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
//        // TODO Auto-generated method stub
//    	XrefData xref = (XrefData) arg0;
//        arg1.addAttribute("ref-type", xref.getRefType());
//        arg1.addAttribute("rid", xref.getRid());
//
//    }
//
//    @Override
//    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
//        // TODO Auto-generated method stub
//    	XrefData xref = new XrefData();
//    	xref.setRefType(arg0.getAttribute("ref-type"));
//    	xref.setRid(arg0.getAttribute("rid"));
//        return xref;
//    }
//
//    @Override
//    public boolean canConvert(Class arg0) {
//        // TODO Auto-generated method stub
//        return arg0.equals(XrefData.class);
//    }
//}