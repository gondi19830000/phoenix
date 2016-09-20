package com.shangliwei.phoenix.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.domain.po.EmployeePo;

public interface IEmployeeDao extends IDao<EmployeePo> {

	public int getMaxSequence(Connection connection) throws SQLException;
}
