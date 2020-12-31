//package com.digi.unitouch.util;
//
//public class FileVersionChange {
//	public static String versionChange(String filename, Integer maxver) {
////		String filename = "project_health_meterV18458V.jpg";
////		Integer maxver = 45;
//		String[] lFilename = filename.split("[.]");
//		String fast = lFilename[0];
//		String mida[] = fast.split("[_]");
//		int midLenght = mida.length;
//		String finl = mida[midLenght - 1];
//
//		finl = finl.toUpperCase();
//		char c[] = finl.toCharArray();
//		int flag = 0, flag2 = 0;
//		for (int j = 0; j < c.length; j++) {
//			if (c[j] >= 65 && c[j] <= 90) {
//				flag2++;
//				if (c[j] == 86) {
//					flag++;
//				}
//			}
//		}
//
//		if (flag == 1 && flag2 == 1) {
//
//			String finalName = "";
//			for (int i = 0; i < midLenght - 1; i++) {
//				finalName = finalName.concat(mida[i].concat("_"));
//			}
//			finl = finalName;
//			finl = finl.concat("V" + maxver);
//			String f = finl + "." + lFilename[1];
//			System.out.println(f);
//			return f;
//		} else {
//
//			fast = fast.concat("_V1").concat(".").concat(lFilename[1]);
//			System.out.println("g :: " + fast);
//			return fast;
//		}
//
//	}
//}
