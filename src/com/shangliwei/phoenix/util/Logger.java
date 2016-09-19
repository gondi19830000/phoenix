package com.shangliwei.phoenix.util;

public final class Logger {

	public static final String LEVEL_DEBUG = "1";
	public static final String LEVEL_ERROR = "3";
	
	public static void print(String message, String level) {
		if (level.equals(LEVEL_DEBUG)) {
			System.out.print("[LOGGER DEBUG] ");
		} else if (level.equals(LEVEL_ERROR)) {
			System.out.print("[LOGGER ERROR] ");
		}
		System.out.println(message);
	}
}
