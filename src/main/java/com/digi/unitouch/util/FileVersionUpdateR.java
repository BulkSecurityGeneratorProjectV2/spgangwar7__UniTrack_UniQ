package com.digi.unitouch.util;

public class FileVersionUpdateR {
	public static FilVerVo versionChange(String filename) {
		//String filename = "poRject_health_meteV1R5241RRRR24243242.jpg";
		StringBuilder getCurrentVersion = new StringBuilder();
		// Integer maxver = 45;
		boolean update = false;
		String[] lFilename = filename.split("[.]");
		int lenght = lFilename[0].length();
		String fast = lFilename[0];
		System.out.println("lenght---" + lenght);
		String finl = fast.toUpperCase();
		char c[] = finl.toCharArray();
		int flag2 = 0, count = 0;
		for (int j = lenght - 1; j >= 0; j--) {
			// System.out.print(c[j]);
			if (c[j] >= 65 && c[j] <= 90) {
				if (c[j] == 82) {
					int macloop = lenght - 1 - flag2;
					for (int i = lenght - 1; i >= macloop; i--) {
						System.out.print(c[i]);
						getCurrentVersion.append(c[i]);
					}
					char[] ff = getCurrentVersion.toString().toCharArray();
					for (int k = 0; k < getCurrentVersion.length(); k++) {
						if (ff[k] >= 65 && ff[k] <= 90) {
							System.out.println("String With R1 1st Time version");
							count++;
						}
					}
					update = true;
					break;
				}

			}
			flag2++;
		}

		if (update && count == 1) {
			StringBuilder version = getCurrentVersion.reverse();
			version.charAt(0);
			System.out.println("\nversion--->" + version.toString());
			String name = version.toString().substring(0);
			name = name.replace("R", "").trim();
			System.out.println("number of ---->" + name);
			if (name.equalsIgnoreCase("")) {
				fast = fast.concat("R1").concat(".").concat(lFilename[1]);
				System.out.println("\n g :: " + fast);
				FilVerVo fv=new FilVerVo(fast,1);
				return fv;
			} else {
				Integer versionNo = Integer.parseInt(name);
				Integer nextVersionNo = versionNo + 1;
				System.out.println("Orignal file Name------------>" + filename);
				String filna = filename.replaceAll(versionNo + "", nextVersionNo + "");

				System.out.println("filna--------------->" + filna);
				FilVerVo fv=new FilVerVo(filna,nextVersionNo);
				return fv;
			}
		} else {

			fast = fast.concat("R1").concat(".").concat(lFilename[1]);
			System.out.println("\n g :: " + fast);
			FilVerVo fv=new FilVerVo(fast,1);
			return fv;
		}

	}

	public static FilVerVo versionChange(String filename,int versionNumber) {
		//filename = "poRject_health_meteV1R5241RRRR24.jpg";
		StringBuilder getCurrentVersion = new StringBuilder();
		// Integer maxver = 45;
		boolean update = false;
		String[] lFilename = filename.split("[.]");
		int lenght = lFilename[0].length();
		String fast = lFilename[0];
		System.out.println("lenght---" + lenght);
		String finl = fast.toUpperCase();
		char c[] = finl.toCharArray();
		int flag2 = 0, count = 0;
		for (int j = lenght - 1; j >= 0; j--) {
			// System.out.print(c[j]);
			if (c[j] >= 65 && c[j] <= 90) {
				if (c[j] == 82) {
					int macloop = lenght - 1 - flag2;
					for (int i = lenght - 1; i >= macloop; i--) {
						System.out.print(c[i]);
						getCurrentVersion.append(c[i]);
					}
					char[] ff = getCurrentVersion.toString().toCharArray();
					for (int k = 0; k < getCurrentVersion.length(); k++) {
						if (ff[k] >= 65 && ff[k] <= 90) {
							System.out.println("String With R1 1st Time version");
							count++;
						}
					}
					update = true;
					break;
				}

			}
			flag2++;
		}

		if (update && count == 1) {
			StringBuilder version = getCurrentVersion.reverse();
			version.charAt(0);
			System.out.println("\nversion--->" + version.toString());
			String name = version.toString().substring(0);
			name = name.replace("R", "").trim();
			System.out.println("number of ---->" + name);
			if (name.equalsIgnoreCase("")) {
				fast = fast.concat("R_"+versionNumber).concat(".").concat(lFilename[1]);
				System.out.println("\n g :: " + fast);
				FilVerVo fv=new FilVerVo(fast,versionNumber);
				System.out.println(fv.toString());
				return fv;
			} else {
			//	Integer versionNo = Integer.parseInt(name);
			//	Integer nextVersionNo = versionNo + 1;
			//	System.out.println("Orignal file Name------------>" + filename);
			//	String filna = filename.replaceAll(versionNo + "", nextVersionNo + "");
				
				String filnanew = filename.replaceAll(name + "", versionNumber + "");

				//System.out.println("filna--------------->" + filna);
			//	FilVerVo fv=new FilVerVo(filna,nextVersionNo);
				FilVerVo fv1=new FilVerVo(filnanew,versionNumber);
				System.out.println(fv1.toString());
				return fv1;
			}
		} else {

			//fast = fast.concat("R1").concat(".").concat(lFilename[1]);
			fast = fast.concat("R_"+versionNumber).concat(".").concat(lFilename[1]);
			System.out.println("\n g :: " + fast);
			FilVerVo fv=new FilVerVo(fast,versionNumber);
			System.out.println(fv.toString());
			return fv;
		}

	}
	
	public static FilVerVo getfileNameByArticleIDwithVersion(String filename, int versionNumber, String aID) {
		String[] filenameArr = filename.split("[.]");
		String fname = filenameArr[0];
		String lname = filenameArr[1];
		String newFileName = "";
		newFileName=newFileName.concat(aID+"_R"+versionNumber).concat(".").concat(lname);
		FilVerVo fv = new FilVerVo(newFileName, versionNumber);
		System.out.println(fv.toString());
		return fv;
	}

	public static void main(String[] args) {
		FileVersionUpdateR.getfileNameByArticleIDwithVersion("zzzR43.xml",245,"issue 12");
	}
}
