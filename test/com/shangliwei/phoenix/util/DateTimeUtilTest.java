package com.shangliwei.phoenix.util;

import java.text.ParseException;

import org.junit.Test;

public class DateTimeUtilTest {

	@Test
	public void testGetTimestamp() {
		System.out.println(DateTimeUtil.getTimestamp());
	}

	@Test
	public void testGetDate() {
		System.out.println(DateTimeUtil.getDate());
	}

	@Test
	public void testFormatTimestamp() {
		System.out.println(DateTimeUtil.format(DateTimeUtil.getTimestamp()));
	}

	@Test
	public void testFormatDate() {
		System.out.println(DateTimeUtil.format(DateTimeUtil.getDate()));
	}

	@Test
	public void testParse() throws ParseException {
		System.out.println(DateTimeUtil.parse("2016-01-01"));
	}

}
