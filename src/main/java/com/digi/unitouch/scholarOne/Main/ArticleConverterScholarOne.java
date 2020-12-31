package com.digi.unitouch.scholarOne.Main;

import com.digi.unitouch.scholarOne.Meta.ArticleConverterMeta;
import com.digi.unitouch.scholarOne.Meta.Issn;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ArticleConverterScholarOne  implements Converter{

	
    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        // TODO Auto-generated method stub
    	ArticleConverterMeta articlemeta = (ArticleConverterMeta) arg0;
        arg1.addAttribute("export_date", articlemeta.getExportDate());
        arg1.addAttribute("external_id", articlemeta.getExternalId());
        arg1.addAttribute("lang", articlemeta.getLang());
        arg1.addAttribute("ms_no", articlemeta.getMsNo());
        arg1.addAttribute("rev", articlemeta.getRev());
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        // TODO Auto-generated method stub
    	ArticleConverterMeta articlemeta = new ArticleConverterMeta();
        articlemeta.setExportDate(arg0.getAttribute("export_date"));
        articlemeta.setExternalId(arg0.getAttribute("external_id"));
        articlemeta.setLang(arg0.getAttribute("lang"));
        articlemeta.setMsNo(arg0.getAttribute("ms_no"));
        articlemeta.setRev(arg0.getAttribute("rev"));
        return articlemeta;
    }

    @Override
    public boolean canConvert(Class arg0) {
        return arg0.equals(ArticleConverterMeta.class);
    }
}
