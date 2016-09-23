package com.shangliwei.phoenix.util;

import java.math.BigDecimal;
import java.sql.SQLException;

import oracle.sql.TIMESTAMP;

public final class TypeCaseUtil {
	
	public static Object oracleToJava(Object value) throws SQLException {
		Object result = null;
		if (value == null) {
			result = null;
		} else if ("java.lang.String".equals(value.getClass().getName())) {
			result = (String) value;
		} else if ("oracle.sql.TIMESTAMP".equals(value.getClass().getName())) {
			result = ((TIMESTAMP) value).timestampValue();
		} else if ("oracle.sql.DATE".equals(value.getClass().getName())) {
			result = new java.sql.Date(((TIMESTAMP) value).dateValue().getTime());
		} else if ("java.math.BigDecimal".equals(value.getClass().getName())) {
			if (((BigDecimal) value).toString().indexOf(".") < 0) {
				result = Integer.valueOf(String.valueOf(value));
			} else {
				result = Double.valueOf(String.valueOf(value));
			}
		} else if ("java.sql.Date".equals(value.getClass().getName())) {
			result = value;
		} else {
			String message = "Lack type case with oracle type:" + value.getClass().getName();
			LogUtil.print(message, LogUtil.LEVEL_ERROR);
			throw new RuntimeException(message);
		}
		return result;
	}
	
}
