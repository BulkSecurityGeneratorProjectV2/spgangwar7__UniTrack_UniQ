package com.digi.unitouch.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlBeautify {
	public static String xmlBeautify(String input, String output) {
		try {
			Path path = Paths.get(output);
			Path path2 = Paths.get(input);
			Charset charset = StandardCharsets.UTF_8;

			String totalStr = "";
			try (BufferedReader br = new BufferedReader(new FileReader(path2.toString()))) {
				String line;
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
					if (line.contains("<") || line.contains(">")) {
						String key = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
						String newContent = "";
						if (key.charAt(0) == '/') {
						//	System.out.println(key);
							newContent = line.replaceAll(key, key.toLowerCase());
							newContent = PrettyPrintXMLInJava.getbetufyXml(newContent);
							totalStr += newContent;
						} else {
							newContent = line.replaceAll(key, key.toLowerCase());
							newContent = PrettyPrintXMLInJava.getbetufyXml(newContent);
							totalStr += newContent;
						}
						Files.write(path, totalStr.getBytes(charset));
					} else {
					//	System.out.println("tag is not in this line");
					}
				}
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return output;
	}
}