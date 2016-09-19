package com.shangliwei.phoenix.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IDao;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.util.JDBCTemplate;

public class EmployeeDaoImpl extends JDBCTemplate implements IDao<EmployeePo> {

	@Override
	public void add(EmployeePo po, Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(EmployeePo po, Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id, Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeePo query(String id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePo> query(Map<String, Object> condition, int beginRow, int endRow, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

}
