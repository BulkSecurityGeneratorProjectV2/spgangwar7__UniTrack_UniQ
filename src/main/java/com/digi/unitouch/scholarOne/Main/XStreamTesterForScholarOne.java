//package com.digi.unitouch.scholarOne.Main;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//import com.digi.unitouch.scholarOne.Meta.ArticleConverterMeta;
//import com.digi.unitouch.scholarOne.Meta.ArticleScholarOne;
//import com.digi.unitouch.scholarOne.Meta.Issn;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//public class XStreamTesterForScholarOne {
//	
//	public static void main(String args[]) throws FileNotFoundException {
//		String inputpath = "C:\\Users\\80065\\Desktop\\Rohit\\impfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\ScholarTest.xml";
//		FileInputStream xmlScholarPath1 = new FileInputStream(inputpath);
//		redingForScholarOne(xmlScholarPath1);
//	}
//
//	public static String redingForScholarOne(FileInputStream xml) {
//		ArticleScholarOne articleMetaScholar = new ArticleScholarOne();
//		XStream xstream = createObjectXstreamScholarOne();
//		xstream.fromXML(xml, articleMetaScholar);
//		System.out.println("hi Scholar One");
//		System.out.println(articleMetaScholar.toString());
//		return null;
//
//	}
//	
//	public static XStream createObjectXstreamScholarOne() {
//		XStream xstream = new XStream(new DomDriver());
//		xstream.processAnnotations(ArticleScholarOne.class);
//		xstream.processAnnotations(ArticleConverterMeta.class);
//		xstream.processAnnotations(Issn.class);
//		xstream.registerConverter(new IssnConverterScholar());
//		xstream.registerConverter(new ArticleConverterScholarOne());
//		return xstream;
//	}
//
//}
