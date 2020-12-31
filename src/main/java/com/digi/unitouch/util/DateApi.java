package com.digi.unitouch.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateApi {

	public static String setLocalDateTimeApi() {

		LocalDateTime current = LocalDateTime.now();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

		String formatedDateTime = current.format(format);

		return formatedDateTime;
	}

	public static String LocalDateTimeApi(Date date) throws ParseException {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

			String newDate = formatter.format(date);
			System.out.println("Date is: " + newDate);
			return newDate;
		}
	}

	public static String DateTimeApi(Date date, String dateformat) throws ParseException {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");

			String newDate = formatter.format(date);
			return newDate;
		}
	}

	public static String getCurrentIndianTimeFormet() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		return sd.format(date);
	}

	// 23-Jul-20
	public static String getCurrentIndianTime() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yy ");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		return sd.format(date);
	}

	public static String getCurrentIndianTimeyyyy() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy ");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		return sd.format(date);
	}

	public static String convertTimeFormat(String dateInString,String formatOfDate) {
		//"dd-M-YYYY"
		SimpleDateFormat sd = new SimpleDateFormat(formatOfDate);
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		Date date;
		String datereturn = "";
		try {
			date = sd.parse(dateInString);
			datereturn = DateTimeApi(date,"dd-MMM-yy");
			System.out.println(datereturn);
		} catch (Exception e) {

		}
		return datereturn;
	}

//	public static void main(String[] args) {
//		System.out.println(convertTimeFormat("15-10-2020","dd-M-yyyy"));
//	}
}