package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CacheUtilTest {

	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		connection = DBUtil.getConnection(true);
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}

	@Test
	public void testGetUsername() throws SQLException {
		System.out.println(CacheUtil.getUsername("0c2dba9e71e145e1b43e2e2a3b8853e5", connection));
	}

	@Test
	public void testGetDepartmentName() throws SQLException {
		System.out.println(CacheUtil.getDepartmentName("f8be43dcfce84a5ba35e478b553dae5b", connection));
	}

	@Test
	public void testGetDictionaryName() throws SQLException {
		System.out.println(CacheUtil.getDictionaryName("01", "EMPLOYEE_STATE", connection));
	}

}
