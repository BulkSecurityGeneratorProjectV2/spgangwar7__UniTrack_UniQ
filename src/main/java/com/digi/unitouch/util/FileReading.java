package com.digi.unitouch.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileReading {
	Map<String, String> fileList = new HashMap<String, String>();

	public Map<String, String> listFilesForFolder(File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				fileList.put(fileEntry.getName(), fileEntry.getPath());
			}
		}
		return fileList;
	}
}