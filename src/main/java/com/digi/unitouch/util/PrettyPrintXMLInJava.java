package com.digi.unitouch.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PrettyPrintXMLInJava {
	public static String getbetufyXml(String args) {

		List<String> matchList = new ArrayList<String>();
		 Pattern regex = Pattern.compile("\\<(.*?)\\>");
		    String input = args;
		Matcher regexMatcher = regex.matcher(input);

		StringBuffer sb = new StringBuffer();
		int counter = 0;
		while (regexMatcher.find()) {// Finds Matching Pattern in String
			regexMatcher.appendReplacement(sb, "{" + counter + "}");
			matchList.add(regexMatcher.group().toLowerCase());// Fetching Group from String
			counter++;
		}
		  String format = MessageFormat.format(sb.toString(), matchList.toArray());
		//System.out.println(input);
		//System.out.println("----------------------");
		//System.out.println(format);
		return format;
	}
}
