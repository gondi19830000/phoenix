package com.shangliwei.phoenix.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IDao;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.util.JDBCTemplate;

public class EmployeeDaoImpl extends JDBCTemplate implements IDao<EmployeePo> {

	@Override
	public void add(EmployeePo po, Connection connection) throws SQLException {
		String sql = "INSERT INTO S_T_EMPLOYEE(ID,SEQUENCE,USERNAME,PASSWORD,EMAIL,PHONE,STATE,DEPARTMENT_ID,CREATER,CREATTIME) VALUES(?,?,?,?,?,?,?,?,,?,?)";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getId());
		parameters.add(po.getSequence());
		parameters.add(po.getUsername());
		parameters.add(po.getPassword());
		parameters.add(po.getEmail());
		parameters.add(po.getPhone());
		parameters.add(po.getState());
		parameters.add(po.getDepartmentId());
		parameters.add(po.getCreater());
		parameters.add(po.getCreattime());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void update(EmployeePo po, Connection connection) throws SQLException {
		String sql = "UPDATE S_T_EMPLOYEE SET USERNAME=?,PASSWORD=?,EMAIL=?,PHONE=?,STATE=?,DEPARTMENT_ID=?,EDITER=?,EDITTIME=? WHERE ID=?";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getUsername());
		parameters.add(po.getPassword());
		parameters.add(po.getEmail());
		parameters.add(po.getPhone());
		parameters.add(po.getState());
		parameters.add(po.getDepartmentId());
		parameters.add(po.getEditer());
		parameters.add(po.getEdittime());
		parameters.add(po.getId());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void delete(String id, Connection connection) throws SQLException {
		String sql = "DELETE FROM S_T_EMPLOYEE WHERE ID=?";
		this.executeUpdate(sql, Arrays.asList(id), connection);
	}

	@Override
	public EmployeePo query(String id, Connection connection) throws SQLException {
		EmployeePo po = null;
		String sql = "SELECT * FROM S_T_EMPLOYEE WHERE ID=?";
		Map<String, Object> result = this.executeOne(sql, Arrays.asList(id), connection);
		if (result != null) {
			po = this.toPo(result);
		}
		return po;
	}

	@Override
	public List<EmployeePo> query(Map<String, Object> condition, int beginRow, int endRow, Connection connection) throws SQLException {
		List<EmployeePo> poList = null;
		StringBuffer sql = new StringBuffer();
		List<Object> parameters = new ArrayList<>();
		sql.append("SELECT * FROM S_T_EMPLOYEE WHERE 1=1 ");
		if (condition != null && condition.size()>0) {
			if (condition.get("username") != null && !"".equals(condition.get("username"))) {
				sql.append("AND USERNAME LIKE '%?%' ");
				parameters.add(condition.get("username"));
			}
			if (condition.get("email") != null && !"".equals(condition.get("email"))) {
				sql.append("AND EMAIL LIKE '%?%' ");
				parameters.add(condition.get("email"));
			}
			if (condition.get("phone") != null && !"".equals(condition.get("phone"))) {
				sql.append("AND PHONE LIKE '%?%' ");
				parameters.add(condition.get("phone"));
			}
			if (condition.get("state") != null && !"".equals(condition.get("state"))) {
				sql.append("AND STATE=? ");
				parameters.add(condition.get("state"));
			}
			if (condition.get("departmentId") != null && !"".equals(condition.get("departmentId"))) {
				sql.append("AND DEPARTMENT_ID LIKE '%?%' ");
				parameters.add(condition.get("departmentId"));
			}
			if (beginRow>0 && endRow>0) {
				sql.append("ROWNUM BETWEEN ? AND ? ");
				parameters.add(beginRow);
				parameters.add(endRow);
			}
		}
		List<Map<String, Object>> resultList = this.executeList(sql.toString(), parameters, connection);
		if (resultList != null && resultList.size() > 0) {
			poList = new ArrayList<>();
			for (Map<String, Object> result : resultList) {
				poList.add(this.toPo(result));
			}
		}
		return poList;
	}
	
	private EmployeePo toPo(Map<String, Object> result) {
		EmployeePo po = new EmployeePo();
		po.setId((String) result.get("id"));
		po.setSequence((int) result.get("sequence"));
		po.setUsername((String) result.get("username"));
		po.setPassword((String) result.get("password"));
		po.setEmail((String) result.get("email"));
		po.setPhone((String) result.get("phone"));
		po.setState((String) result.get("state"));
		po.setDepartmentId((String) result.get("department_id"));
		po.setCreater((String) result.get("creater"));
		po.setCreattime((Timestamp) result.get("creattime"));
		po.setEditer((String) result.get("editer"));
		po.setEdittime((Timestamp) result.get("edittime"));
		return po;
	}

}
