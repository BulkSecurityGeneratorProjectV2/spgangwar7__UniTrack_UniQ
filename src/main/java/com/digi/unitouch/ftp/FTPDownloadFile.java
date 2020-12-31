//package com.digi.unitouch.ftp;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.springframework.stereotype.Component;
//
//import com.digi.unitouch.util.LoggerClass;
//@Component
//public class FTPDownloadFile extends LoggerClass {
//	/**
//	 * @author 80055
//	 *
//	 */
//	private static String InputPath="//medknow//input//";
////	private static String InputPath="C:\\unitouch\\input\\";
//	public  boolean fileCopyInUnitouch(String filename) {
//		LOGGER.info("fileCopyInUnitouch function call-------------> "+filename);
//		String SFTPWORKINGDIR = "/Uni_SFTP/";
//		String server = "65.182.161.205";
//		int port = 21;
//		String user = "Uni_SFTP";
//		char s = '"';
//		String pass = "<" + s + "c#Kv53bn&jv";
//
//		FTPClient ftpClient = new FTPClient();
//		try {
//
//			ftpClient.connect(server);
//			ftpClient.login(user, pass);
//			ftpClient.enterLocalPassiveMode();
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//			LOGGER.info("fileCopyInUnitouch connect -------------> "+filename);
//			// APPROACH #1: using retrieveFile(String, OutputStream)
//			String remoteFile1 = "/Uni_SFTP/" + filename;
//			File downloadFile1 = new File(InputPath + filename);
//			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
//			System.out.println(downloadFile1);
//			LOGGER.info("download File: " + downloadFile1);
//			boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
//			outputStream1.close();
//
//			if (success) {
//				ftpClient.rename(SFTPWORKINGDIR+filename, SFTPWORKINGDIR+"/output/"+filename);
//				System.out.println("File #1 has been downloaded successfully.");
//				LOGGER.info("File #1" + downloadFile1 + " has been downloaded successfully.");
//				return true;
//			}
//
//		} catch (IOException ex) {
//			System.out.println("Error: " + ex.getMessage());
//			ex.printStackTrace();
//		} finally {
//			try {
//				if (ftpClient.isConnected()) {
//					ftpClient.logout();
//					ftpClient.disconnect();
//				}
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return false;
//	}
//}