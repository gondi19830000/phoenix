package com.shangliwei.phoenix.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.dao.IDepartmentDao;
import com.shangliwei.phoenix.dao.IDictionaryDao;
import com.shangliwei.phoenix.dao.IEmployeeDao;
import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.dao.impl.DictionaryDaoImpl;
import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.domain.po.EmployeePo;

public final class CacheUtil {

	private static IEmployeeDao employeeDao = new EmployeeDaoImpl();
	private static IDepartmentDao departmentDao = new DepartmentDaoImpl();
	private static IDictionaryDao dictionaryDao = new DictionaryDaoImpl();
	
	public static String getUsername(String employeeId, Connection connection) throws SQLException {
		String username = "";
		EmployeePo employeePo = employeeDao.query(employeeId, connection);
		if (employeePo != null) {
			username = employeePo.getUsername();
		}
		return username;
	}
	
	public static String getDepartmentName(String departmentId, Connection connection) throws SQLException {
		String name = "";
		DepartmentPo departmentPo = departmentDao.query(departmentId, connection);
		if (departmentPo != null) {
			name = departmentPo.getName();
		}
		return name;
	}
	
	public static String getDictionaryName(String code, String type, Connection connection) throws SQLException {
		String name = "";
		DictionaryPo dictionaryPo = dictionaryDao.query(code, type, connection);
		if (dictionaryPo != null) {
			name = dictionaryPo.getName();
		}
		return name;
	}
}
