package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DBUtilTest {

	@Test
	public void testGetConnection() throws ClassNotFoundException, SQLException {
		System.out.println(DBUtil.getConnection(true));
	}

	@Test
	public void testReleaseConnection() throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection(true);
		DBUtil.release(connection);
		System.out.println(connection.isClosed());
	}

}
