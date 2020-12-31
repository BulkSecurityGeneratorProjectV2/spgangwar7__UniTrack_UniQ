package com.digi.unitouch.operatingSystem;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public final class OperatingSystem {
	/*
	 *  types of Operating Systems
	 */
	
	static boolean isWindows = System.getProperty("os.name")
			  .toLowerCase().startsWith("windows");
	
	public enum OSType {
		Windows, MacOS, Linux, Other
	};

	// cached result of OS detection
	protected static OSType detectedOS;

	/*
	 * @returns - the operating system detected
	 */
	public static OSType getOperatingSystemType() {
		if (detectedOS == null) {
			String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
			if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
				detectedOS = OSType.MacOS;
			} else if (OS.indexOf("win") >= 0) {
				detectedOS = OSType.Windows;
			} else if (OS.indexOf("nux") >= 0) {
				detectedOS = OSType.Linux;
			} else {
				detectedOS = OSType.Other;
			}
		}
		return detectedOS;
	}
	
	public static void runScrit() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder();
		OSType os=	getOperatingSystemType();
		if(!isWindows) {
			builder.command("sh", "-c", "chmod 7777 -R /medknow");
			builder.directory(new File(System.getProperty("user.home")));
			Process process = builder.start();
			int exitCode = process.waitFor();
			assert exitCode == 0;
		}
		
	}
//	public static void main(String[] args) throws IOException, InterruptedException {
//		runScrit();
//	}
}