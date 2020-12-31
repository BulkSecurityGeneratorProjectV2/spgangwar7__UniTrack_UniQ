//
//package com.digi.unitouch.util;
//
//import java.util.Map;
//import java.util.Set;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.MapMessage;
//import javax.jms.MessageProducer;
//import javax.jms.Session;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DataSenderMQ {
//
//	// private static final String url = "tcp://172.16.1.227:61616";
//	private static final String url = "tcp://172.16.2.202:61616";
//	// user=admin,password=admin.
////	private static final String url = "tcp://localhost:61616";
//	// default broker URL is : tcp://localhost:61616"
//
//	// private static final String subject="TDXPS_FMS1P1PQ";
//
//	public void sendMessageUniTouch(Map<String, String> inputMessage, String name) throws JMSException {
//
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//		Connection connection = connectionFactory.createConnection();
//		connection.start();
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//		Destination destination = session.createQueue("UniTouch");
//
//		MessageProducer producer = session.createProducer(destination);
//
//		MapMessage message = session.createMapMessage();
//		Set<String> keys = inputMessage.keySet();
//		for (String key : keys) {
//			message.setString(key, inputMessage.get(key));
//		}
//		producer.setPriority(4);// 4
//		producer.send(message);
//
//		System.out.println("JCG printing@@ '");
//		connection.close();
//	}
//}
