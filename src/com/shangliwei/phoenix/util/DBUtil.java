package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shangliwei.phoenix.constant.DBConstant;
import com.shangliwei.phoenix.constant.LogConstant;

public final class DBUtil {

	public static Connection getConnection(boolean autoCommit) throws SQLException, ClassNotFoundException {
		LogUtil.print("Get Connection...auto commit:" + autoCommit, LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
		Class.forName(DBConstant.DB_ORACLE_DRIVER);
		Connection connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);
		connection.setAutoCommit(autoCommit);
		return connection;
	}
	
	public static void release(Connection connection) throws SQLException {
		if (connection != null) {
			LogUtil.print("Release Connection...", LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
			connection.close();
		}
	}
	
	public static void release(PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			LogUtil.print("Release PreparedStatement...", LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
			preparedStatement.close();
		}
		
	}
	
	public static void release(PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
		DBUtil.release(preparedStatement);
		if (resultSet != null) {
			LogUtil.print("Release ResultSet...", LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
			resultSet.close();
		}
	}
	
	public static void commitConnection(Connection connection) throws SQLException {
		if (connection != null) {
			LogUtil.print("Commit Connection...", LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
			connection.commit();
		}
	}
}
