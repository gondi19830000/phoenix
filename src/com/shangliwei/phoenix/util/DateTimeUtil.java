package com.shangliwei.phoenix.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class DateTimeUtil {

	public static Timestamp getTimestamp() {
		return new Timestamp(new java.util.Date().getTime());
	}
	
	public static Date getDate() {
		return new Date(new java.util.Date().getTime());
	}
	
	public static String format(Timestamp timestamp) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(timestamp);
	}
	
	public static String format(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static Date parse(String date) throws ParseException {
		return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
	}
	
}
