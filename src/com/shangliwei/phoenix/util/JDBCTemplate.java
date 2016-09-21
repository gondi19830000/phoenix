package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JDBCTemplate {

	public void executeUpdate(String sql, List<Object> parameters, Connection connection) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i=0; i<parameters.size(); i++) {
				preparedStatement.setObject(i+1, parameters.get(i));
			}
			this.loggerSQLAndParametersMessage(sql, parameters);
			preparedStatement.executeUpdate();			
		} finally {
			DBUtil.release(preparedStatement);
		}
	}
	
	public Map<String, Object> executeOne(String sql, List<Object> parameters, Connection connection) throws SQLException {
		List<Map<String, Object>> resultList = this.executeQuery(sql, parameters, connection);
		Map<String, Object> result = null;
		if (resultList != null) {
			if (resultList.size() == 1) {
				result = resultList.get(0);
			} else {
				String message = "ExecuteOne Return multiple rows!";
				Logger.print(message, Logger.LEVEL_ERROR);
				throw new RuntimeException(message);
			}
		}
		return result;
	}
	
	public List<Map<String, Object>> executeList(String sql, List<Object> parameters, Connection connection) throws SQLException {
		return this.executeQuery(sql, parameters, connection);
	}
	
	private List<Map<String, Object>> executeQuery(String sql, List<Object> parameters, Connection connection) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (parameters != null) {
				for (int i=0; i<parameters.size(); i++) {
					preparedStatement.setObject(i+1, parameters.get(i));
				}				
			}
			this.loggerSQLAndParametersMessage(sql, parameters);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<>();
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				for (int i=0; i<columnCount; i++) {
					String column = metaData.getColumnName(i+1);
					map.put(column, TypeCaseUtil.oracleToJava(resultSet.getObject(column)));
				}
				result.add(map);
			}
			if (result.size() == 0) {
				result = null;
			}
		} finally {
			DBUtil.release(preparedStatement, resultSet);
		}
		return result;
	}
	
	private String getParametersMessage(List<Object> parameters) {
		String result = "";
		if (parameters != null && parameters.size() > 0) {
			for (int i=0; i<parameters.size(); i++) {
				result += (parameters.get(i) + ",");
			}
			result = result.substring(0, result.length()-1);
		}
		return result;
	}
	
	private void loggerSQLAndParametersMessage(String sql, List<Object> parameters) {
		Logger.print("Execute SQL:" + sql, Logger.LEVEL_DEBUG);
		String parametersMessage = this.getParametersMessage(parameters);
		if (parametersMessage != null && !"".equals(parametersMessage)) {
			Logger.print("Execute Parameters:" + parametersMessage, Logger.LEVEL_DEBUG);
		}
	}
}
