//
//package com.digi.unitouch.util;
//
//import java.util.Enumeration;
//import java.util.HashMap;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.MapMessage;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.Session;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//
//public final class Consumer {
//
//	private Consumer() {
//	}
//
//	public static void main(String[] args) throws JMSException, InterruptedException {
//
//		String url = "tcp://172.16.2.202:61616";
//		// String url = "tcp://localhost:61616";
//		if (args.length > 0) {
//			url = args[0];
//		}
//
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//		Destination destination = new ActiveMQQueue("UniTouch");
//
//		Connection connection = connectionFactory.createConnection();
//		connection.start();
//
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//		MessageConsumer consumer = session.createConsumer(destination);
//
//		Message msg = consumer.receive();
//
//		System.out.println(".print received message: " + msg.getJMSMessageID());
////		    if (msg instanceof ObjectMessage) {
////		        ObjectMessage objMsg = (ObjectMessage) msg;
////		        System.out.println(".print object: " + objMsg.getObject().toString());
////		    } else {
//		MapMessage mapMsg = (MapMessage) msg;
//		HashMap<Object, Object> map = new HashMap<Object, Object>();
//		Enumeration en = mapMsg.getMapNames();
//		while (en.hasMoreElements()) {
//			String property = (String) en.nextElement();
//			Object mapObject = mapMsg.getObject(property);
//			map.put(property, mapObject);
//		}
//		System.out.println(".print map: " + map);
//		// }
//
//		// ActiveMQMapMessage amq= new ActiveMQMapMessage (); //
//		// amq.getBody(java.util.Map.class ); // System.out.println("active Mq :"+amq);
////		for (;;) {
////			System.out.println("Waiting for message.");
////			Message message = consumer.receive();
////			if (message == null) {
////				break;
////			}
////			System.out.println("Got message: " + message);
////			String text = message + "";
////			System.out.println(text);
////			if (text.contains("text = [")) {
////
////				String message1 = text.substring(text.lastIndexOf("text = [") + 8, text.lastIndexOf("]}"));
////				mqMsg = message1;
////				System.out.println("setMsg :" + mqMsg);
////			}
////			if (text.contains("JournalId:")) {
////
////				journalId = mqMsg.substring(mqMsg.lastIndexOf("journalId:") + 11, mqMsg.lastIndexOf(", UserId"));
////				System.out.println("journalId :"+ journalId);
////			}
////			if (text.contains("UserId:")) {
////
////				userId = mqMsg.substring(mqMsg0
////		       .lastIndexOf("UserId:") + 7, mqMsg.lastIndexOf(", ArticleID"));
////				System.out.println("UserId :"+ userId);
////			}
////			if (text.contains("ArticleID:")) {
////
////				 articleID = mqMsg.substring(mqMsg.lastIndexOf("ArticleID:") + 10, mqMsg.lastIndexOf(""));
////				System.out.println("articleID :"+ articleID);
////			}
////		}
//
//		connection.close();
//	}
//}
