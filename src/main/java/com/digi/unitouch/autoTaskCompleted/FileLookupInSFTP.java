package com.digi.unitouch.autoTaskCompleted;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Vector;

import com.digi.unitouch.util.LoggerClass;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.ChannelSftp.LsEntrySelector;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileLookupInSFTP extends LoggerClass {

	public boolean getFileName(final String EmInputDIRLocation, final String outputDIRLocation,
			final String InputServerPath, final String articleID, final String SFTPHOST, final String SFTPUSER,
			final String SFTPPASS, final String SFTPPORT) {
		boolean status = false;
//		final String SFTPHOST = "65.182.161.205";
//		final int SFTPPORT = 22;
//		final String SFTPUSER = "Uni_SFTP";
//		final char s = '"';
//		final String SFTPPASS = "<" + s + "c#Kv53bn&jv";
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, Integer.parseInt(SFTPPORT));
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			LOGGER.info("channelSftp  Uni_SFTP connect pathEmInputDIRLocation----->" + EmInputDIRLocation);
			LOGGER.info("channelSftp  Uni_SFTP connect EmOutputDIRLocation------>" + outputDIRLocation);
			LOGGER.info("channelSftp  Uni_SFTP connect InputServerPath------->" + InputServerPath);
			channel = session.openChannel("sftp");
			channel.connect();
			LOGGER.info("channelSftp  Uni_SFTP connect");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(EmInputDIRLocation);
			Vector<?> filelist = channelSftp.ls(EmInputDIRLocation);

			for (int i = 0; i < filelist.size(); i++) {
				LsEntry entry = (LsEntry) filelist.get(i);
				LOGGER.info("file name " + entry.getFilename());
				if (entry.getFilename().equals(".") || entry.getFilename().equals("..")) {
					continue;
				}
				String[] filename = entry.getFilename().split(".");
				// LOGGER.info("file name[0]----------article--ID----"+filename[0]);
				if (filename[0].equalsIgnoreCase(articleID)) {
					LOGGER.info("channelSftp  Uni_SFTP getFilename ---->" + entry.getFilename().toString());
					LOGGER.info("fileCopyInUnitouch connect -------------> " + entry.getFilename().toString());
					// APPROACH #1: using retrieveFile(String, OutputStream)
					String remoteFile1 = EmInputDIRLocation + entry.getFilename().toString();
					File downloadFile1 = new File(InputServerPath + File.separator + entry.getFilename().toString());
					OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
					System.out.println(downloadFile1);
					LOGGER.info("download File: " + downloadFile1);
					channelSftp.get(remoteFile1, outputStream1);
					boolean success = true;
					outputStream1.close();

					if (success) {
						channelSftp.rename(EmInputDIRLocation + entry.getFilename().toString(),
								outputDIRLocation + entry.getFilename().toString());
						System.out.println("File #1 has been downloaded successfully.");
						LOGGER.info("File #1" + downloadFile1 + " has been downloaded successfully.");
						status = true;
						// return;
					}

				} else {
					System.out.println("file with article Id---> " + articleID);
				}

				System.out.println(filelist.get(i).toString());
				System.out.println(EmInputDIRLocation + entry.getFilename());

			}

			while (session == null) {
				System.out.println("Killing the session");
				session.disconnect();

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

}
