package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shangliwei.phoenix.constant.DBConstant;

public final class DBUtil {

	public static Connection getConnection(boolean autoCommit) throws SQLException, ClassNotFoundException {
		Logger.print("Get Connection...auto commit:" + autoCommit, Logger.LEVEL_DEBUG);
		Class.forName(DBConstant.DB_ORACLE_DRIVER);
		Connection connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);
		connection.setAutoCommit(autoCommit);
		return connection;
	}
	
	public static void release(Connection connection) throws SQLException {
		if (connection != null) {
			Logger.print("Release Connection...", Logger.LEVEL_DEBUG);
			connection.close();
		}
	}
	
	public static void release(PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			Logger.print("Release PreparedStatement...", Logger.LEVEL_DEBUG);
			preparedStatement.close();
		}
		
	}
	
	public static void release(PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
		DBUtil.release(preparedStatement);
		if (resultSet != null) {
			Logger.print("Release ResultSet...", Logger.LEVEL_DEBUG);
			resultSet.close();
		}
	}
	
	public static void commitConnection(Connection connection) throws SQLException {
		if (connection != null) {
			Logger.print("Commit Connection...", Logger.LEVEL_DEBUG);
			connection.commit();
		}
	}
}
