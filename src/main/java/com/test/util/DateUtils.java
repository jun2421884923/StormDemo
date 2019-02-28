package com.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static final String DATE_WITH_DIGIT_FORMAT = "%02d-%02d";

	private static final String DATE_WITH_DIGIT_FORMAT2 = "%04d%02d%02d";

	public static long getStartdateTimpstamp(String startdate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(startdate + " " + "00:00:00");
		long res = date.getTime();
		return res;
	}

	public static long getEnddateTimpstamp(String enddate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(enddate + " " + "23:59:59");
		long res = date.getTime();
		return res;
	}

	public static String startDateKeyMysql2Redis(String startDate) throws ParseException {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df1.parse(startDate);
		SimpleDateFormat df2 = new SimpleDateFormat("MM-dd");
		String res = df2.format(date);
		return res;
	}

	public static String getCurDay() {

		Calendar calendar = Calendar.getInstance();
		return String.format(DATE_WITH_DIGIT_FORMAT, calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
	}

	public static int getReportDay(int days) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		String str_res = String.format(DATE_WITH_DIGIT_FORMAT2, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
		return Integer.parseInt(str_res);
	}
}
