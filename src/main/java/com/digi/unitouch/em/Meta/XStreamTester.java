package com.digi.unitouch.em.Meta;
//package com.unitouch.em.Meta;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Source;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.sax.SAXSource;
//import javax.xml.transform.sax.SAXTransformerFactory;
//import javax.xml.transform.stream.StreamResult;
//
//import org.xml.sax.InputSource;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//import com.thoughtworks.xstream.io.xml.StaxDriver;
//import com.unitouch.em.converter.AddrLineConverter;
//import com.unitouch.em.converter.AffConverter;
//import com.unitouch.em.converter.ArticleIdConverter;
//import com.unitouch.em.converter.ContribConverter;
//import com.unitouch.em.converter.DateConverter;
//import com.unitouch.em.converter.FigCountConverter;
//import com.unitouch.em.converter.JournalIdConverter;
//import com.unitouch.em.converter.SubjGroupConverter;
//
//public class XStreamTester {
//
//   public static void main(String args[]) throws FileNotFoundException {
//
//      XStreamTester tester = new XStreamTester();
////      XStream xstream = new XStream(new StaxDriver());
////      Article student = tester.getArticleDetails();
////      
////      xstream.processAnnotations(Article.class);		
////      xstream.autodetectAnnotations(true);
////      //Object to XML Conversion
////      String xml = xstream.toXML(student);
////      xstream.alias("student", Student.class);
////      xstream.alias("note", Note.class);
////
////      xstream.useAttributeFor(Student.class, "studentName");
////      xstream.aliasField("name", Student.class, "studentName");
////      xstream.addImplicitCollection(Student.class, "notes");
//  	//	FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\TJO-D-19-00089.xml");
//// 		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\DS-D-19-00086.xml");
//
////  		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\JQSH-19-31.xml");
//  //		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\JQSH-20-2.xml");
//
////		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\JIPO-19-25.xml");
////		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\eJCRP-D-19-00046.xml");
//
//		FileInputStream xmlPath = new FileInputStream("C:\\Users\\80065\\Desktop\\Rohit\\mpsfile\\CronLocation\\Cron_tjo_TJO-D-19-00089\\md_MD-D-19-09304.xml");
//
//  		reding(xmlPath);
//      //System.out.println(formatXml(xml));		
//   }
//   
//   private Article getArticleDetails() {
//	   Article student = new Article();
////    //  Article student = new Article("Case Report","1.2");
////      List<JournaID> jl= new ArrayList<JournaID>();
////      JournaID jp= new JournaID("publisher","tjo");
////      JournaID je= new JournaID("email","cindy770225@gmail.com");
////      jl.add(jp);
////      jl.add(je);
////      
////      List<JournaltTitel> jt=new ArrayList<JournaltTitel>();
////      JournaltTitel jtt= new JournaltTitel("Taiwan Journal of Ophthalmology");
////      jt.add(jtt);
////      List<Issn> is=new ArrayList<Issn>();
////      Issn iss= new Issn("ppub","564654657");
////      Issn iss1= new Issn("epub","677658");
////      is.add(iss);
////      is.add(iss1);
////      JournalMeta j=new JournalMeta(jl,jt,is);
////      
////    //  student.addNote(new Front(j,"first","My first assignment."));
////     // student.addNote(new Front(j,"second","My Second assignment."));
////  //   student.setType(1);
////      
//      return student;
//   }
//
//   public static String reding(FileInputStream xml) {
//	   Article articleMeta = new Article();
//		XStream xstream = createObjectXstream();
//		xstream.fromXML(xml, articleMeta);
//		System.out.println("hi");
//		System.out.println(articleMeta.toString());
//		return null;
//	 
//   }
//   
//   
//	public static XStream createObjectXstream() {
//        XStream xstream = new XStream(new DomDriver());
//        xstream.processAnnotations(Article.class);
//        xstream.processAnnotations(Front.class);
//        xstream.registerConverter(new IssnConverter());
//        xstream.registerConverter(new JournalIdConverter());
//        xstream.registerConverter(new ArticleIdConverter());
//        xstream.registerConverter(new ContribConverter());
//        xstream.registerConverter(new SubjGroupConverter());
//        xstream.registerConverter(new AffConverter());
//        xstream.registerConverter(new AddrLineConverter());
//        xstream.registerConverter(new DateConverter());
//        xstream.registerConverter(new FigCountConverter());
//    //    xstream.registerConverter(new InstitutionIDConverter());
//   //     xstream.registerConverter(new RoleConverter());
//        return xstream;
//    }
//   
////   public static String formatXml(String xml) {
////   
////      try {
////         Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
////         
////         serializer.setOutputProperty(OutputKeys.INDENT, "yes");
////         serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
////         
////         Source xmlSource = new SAXSource(new InputSource(
////            new ByteArrayInputStream(xml.getBytes())));
////         StreamResult res = new StreamResult(new ByteArrayOutputStream());            
////         
////         serializer.transform(xmlSource, res);
////         
////         return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
////         
////      } catch(Exception e) {
////         return xml;
////      }
////   }
//}
