package com.digi.unitouch.autoTaskCompleted;

import java.util.List;

import com.digi.unitouch.ftp.LoggerClassStatic;
import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.Journal;
import com.digi.unitouch.model.WorkflowTaskSeq;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

public class AutoCompleteScheduler extends LoggerClassStatic {
	public static boolean fileCopyToClientLocation(ArticleDetail article, Journal journal, String userIp,
			String username, String password, List<WorkflowTaskSeq> uu, String input) {
		String jid = journal.getJournalAbbrName().toLowerCase();
		String aid = article.getAid();
		JSch jsch = new JSch();
		Session session = null;
		try {
			session = jsch.getSession(username, userIp, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp channelSftp = (ChannelSftp) channel;
		//	String currentDirectory = channelSftp.pwd();
			final String path = "//"+ "home"+"//"+ "Uni_SFTP" + "//"+ "Uni_SFTP" + "//" + "medknow" + "//" + jid;
			SftpATTRS jr = null;
			try {
				jr = channelSftp.stat(path);
			} catch (Exception e) {
				System.out.println(path + " not found");
			}
			if (jr != null) {
				System.out.println("Directory exists IsDir=" + jr.isDir());
			} else {
				channelSftp.mkdir(path);
			}

			// channelSftp.mkdir(currentDirectory + "Uni_SFTP" + "//" + "medknow" + "//" +
			// jid + "//" + aid);
			int count = 0;
			for (WorkflowTaskSeq workflowTaskSeq : uu) {

				SftpATTRS attrs = null;
				try {
					attrs = channelSftp.stat(path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
				} catch (Exception e) {
					System.out.println(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + " not found");
				}

				if (attrs != null) {
					System.out.println("Directory exists IsDir=" + attrs.isDir());
				} else {
					System.out.println(
							"Creating dir " + path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
					channelSftp.mkdir(path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
					channelSftp.mkdir(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + "//" + "input");
					channelSftp.mkdir(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + "//" + "output");
				}
				if (count == 0) {
					String output = path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + "//"
							+ "input" + "//";
					channelSftp.put(input, output);
					LOGGER.info(input + "file copy in ftp location---------> " + output);
				} else {
					LOGGER.info("file only copy in 0 count " + count);
				}
				count++;
			}
			channelSftp.exit();
			session.disconnect();
			System.out.println("Done");
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		}
		return true;
	}

	// for Stage

	public static boolean fileCopyToClientLocation(ArticleDetail article, Journal journal, String userIp,
			String username, String password, List<WorkflowTaskSeq> uu, String input, String currentTask) {
		String jid = journal.getJournalAbbrName().toLowerCase();
		currentTask=currentTask.replace("-", "_").replace(" ", "_");
		String aid = article.getAid();
		JSch jsch = new JSch();
		Session session = null;
		try {
			session = jsch.getSession(username, userIp, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp channelSftp = (ChannelSftp) channel;
			//String currentDirectory = channelSftp.pwd();
			final String path = "//" +"home"+"//"+ "Uni_SFTP" + "//"+ "Uni_SFTP" + "//" + "medknow" + "//" + jid;
			SftpATTRS jr = null;
			try {
				jr = channelSftp.stat(path);
			} catch (Exception e) {
				System.out.println(path + " not found");
			}
			if (jr != null) {
				System.out.println("Directory exists IsDir=" + jr.isDir());
			} else {
				channelSftp.mkdir(path);
			}

			// channelSftp.mkdir(currentDirectory + "Uni_SFTP" + "//" + "medknow" + "//" +
			// jid + "//" + aid);
			// int count = 0;
			for (WorkflowTaskSeq workflowTaskSeq : uu) {

				SftpATTRS attrs = null;
				try {
					attrs = channelSftp.stat(path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
				} catch (Exception e) {
					System.out.println(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + " not found");
				}

				if (attrs != null) {
					System.out.println("Directory exists IsDir=" + attrs.isDir());
				} else {
					System.out.println(
							"Creating dir " + path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
					channelSftp.mkdir(path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_'));
					channelSftp.mkdir(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + "//" + "input");
					channelSftp.mkdir(
							path + "//" + workflowTaskSeq.getTask().getTaskName().replace(' ', '_') + "//" + "output");
				}
//				if (count == 0) {
//					String output = path + "//" +currentTask.replace(' ', '_') + "//"
//							+ "input" + "//";
//					channelSftp.put(input, output);
//					LOGGER.info(input + "file copy in ftp location---------> " + output);
//				} else {
//					LOGGER.info("file only copy in 0 count " + count);
//				}
//				count++;
			}
			String output = path + "//" + currentTask.replace(' ', '_') + "//" + "input" + "//";
			channelSftp.put(input, output);
			LOGGER.info(input + "file copy in ftp location---------> " + output);
			channelSftp.exit();
			session.disconnect();
			System.out.println("Done");
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		}
		return true;
	}

}
