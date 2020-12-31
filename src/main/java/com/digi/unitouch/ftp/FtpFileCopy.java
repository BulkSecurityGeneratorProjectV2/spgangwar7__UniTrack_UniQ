package com.digi.unitouch.ftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FtpFileCopy {
	public static boolean fileCopyToClientLocation(String input, String output, String userIp, String username,
			String password) {
		JSch jsch = new JSch();
		Session session = null;
		try {
			// session = jsch.getSession("medknow", "44.233.195.95", 22);//unitouch
			// session = jsch.getSession("medknow", "54.214.210.6", 22);//uniprr
			session = jsch.getSession(username, userIp, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.put(input, output);
			sftpChannel.exit();
			session.disconnect();
			System.out.println("Done");
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		} finally {
			session.disconnect();
		}
		return true;
	}
}
