package com.shangliwei.phoenix.util;

public final class LogUtil {

	public static final String LEVEL_DEBUG = "1";
	public static final String LEVEL_ERROR = "3";
	
	public static void print(String message, String level, boolean developMode) {
		if (developMode) {
			if (level.equals(LEVEL_DEBUG)) {
				System.out.print("[LOG DEBUG] ");
			} else if (level.equals(LEVEL_ERROR)) {
				System.out.print("[LOG ERROR] ");
			}
			System.out.println(message);
		}
	}
}
