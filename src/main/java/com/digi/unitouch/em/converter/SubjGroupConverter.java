package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.SubjgroupType;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SubjGroupConverter implements Converter {

	 @Override
	    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
	        // TODO Auto-generated method stub
		 SubjgroupType subjgroupType = (SubjgroupType) arg0;
	        arg1.addAttribute("subj-group-type", subjgroupType.getSubjGroupType());
	   //     arg1.setValue(journalidObj.getValue());

	    }

	    @Override
	    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
	        // TODO Auto-generated method stub
	    	SubjgroupType subjgroupType = new SubjgroupType();
	    	//subjgroupType.setValue(arg0.getValue());
	    	subjgroupType.setSubjGroupType(arg0.getAttribute("subj-group-type"));
	        return subjgroupType;
	    }

	    @Override
	    public boolean canConvert(Class arg0) {
	        // TODO Auto-generated method stub
	        return arg0.equals(SubjgroupType.class);
	    }
}
