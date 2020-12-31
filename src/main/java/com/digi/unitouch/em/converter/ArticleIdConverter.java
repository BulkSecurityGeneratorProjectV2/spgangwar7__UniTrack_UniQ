package com.digi.unitouch.em.converter;

import com.digi.unitouch.em.Meta.ArticleID;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ArticleIdConverter implements Converter {

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	ArticleID articleidObj = (ArticleID) arg0;
        arg1.addAttribute("pub-id-type", articleidObj.getPubIdType());
        arg1.setValue(articleidObj.getValue());

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	ArticleID articleidObj = new ArticleID();
    	articleidObj.setValue(arg0.getValue());
    	articleidObj.setPubIdType(arg0.getAttribute("pub-id-type"));
        return articleidObj;
    }

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(ArticleID.class);
    }

}
