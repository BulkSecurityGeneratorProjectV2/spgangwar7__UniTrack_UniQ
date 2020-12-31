//package com.digi.unitouch.ftp;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Vector;
//
//import com.digi.unitouch.util.LoggerClass;
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.ChannelSftp.LsEntry;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//
//public class SFTPinJava extends LoggerClass {
//	/**
//	 * @author 80055
//	 *
//	 */
//	public SFTPinJava() {
//	}
//
//	// @Scheduled(fixedDelay = 30000)
//	public void filCopyScheduled() {
//		String SFTPHOST = "65.182.161.205";
//		int SFTPPORT = 22;
//		String SFTPUSER = "Uni_SFTP";
//		char s = '"';
//		String SFTPPASS = "<" + s + "c#Kv53bn&jv";
//		String SFTPWORKINGDIR = "/Uni_SFTP/";
//	//	String InputPath = "//medknow//input//";
//		  String InputPath="C:\\unitouch\\input\\";
//		Session session = null;
//		Channel channel = null;
//		ChannelSftp channelSftp = null;
//
//		try {
//			JSch jsch = new JSch();
//			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
//			session.setPassword(SFTPPASS);
//			java.util.Properties config = new java.util.Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			session.connect();
//			channel = session.openChannel("sftp");
//			channel.connect();
//			LOGGER.info("channelSftp  Uni_SFTP connect");
//			channelSftp = (ChannelSftp) channel;
//			channelSftp.cd(SFTPWORKINGDIR);
//			Vector<?> filelist = channelSftp.ls(SFTPWORKINGDIR);
//			for (int i = 0; i < filelist.size(); i++) {
//				LsEntry entry = (LsEntry) filelist.get(i);
//				System.out.println(entry.getFilename());
//				if (entry.getFilename().endsWith(".zip")) {
//					LOGGER.info("channelSftp  Uni_SFTP getFilename ---->" + entry.getFilename().toString());
//					// FTPDownloadFile ftf=new FTPDownloadFile();
//					// boolean status = ftf.fileCopyInUnitouch(entry.getFilename().toString());
//					// LOGGER.info("file read status"+status);
//					// Path temp = Files.move(Paths.get(SFTPWORKINGDIR+entry.getFilename()),
//					// Paths.get(SFTPWORKINGDIR+entry.getFilename()));
//
//					LOGGER.info("fileCopyInUnitouch connect -------------> " + entry.getFilename().toString());
//					// APPROACH #1: using retrieveFile(String, OutputStream)
//					String remoteFile1 = "/Uni_SFTP/" + entry.getFilename().toString();
//					File downloadFile1 = new File(InputPath + entry.getFilename().toString());
//					OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
//					System.out.println(downloadFile1);
//					LOGGER.info("download File: " + downloadFile1);
//					channelSftp.get(remoteFile1, outputStream1);
//					boolean success = true;
//					outputStream1.close();
//
//					if (success) {
//						channelSftp.rename(SFTPWORKINGDIR + entry.getFilename().toString(),
//								SFTPWORKINGDIR + "/output/" + entry.getFilename().toString());
//						System.out.println("File #1 has been downloaded successfully.");
//						LOGGER.info("File #1" + downloadFile1 + " has been downloaded successfully.");
//						//return;
//					}
//
//				} else {
//					System.out.println("file not zip ");
//				}
//
//				System.out.println(filelist.get(i).toString());
//				System.out.println(SFTPWORKINGDIR + entry.getFilename());
//
//			}
//
//			while (session == null) {
//				System.out.println("Killing the session");
//				session.disconnect();
//			
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
////        finally {
////        	  System.out.println("Killing the session");
////              session.disconnect();
////           
////		}
//	}
//
//	public static void main(String[] args) {
//		SFTPinJava dftp = new SFTPinJava();
//		dftp.filCopyScheduled();
//	}
//}