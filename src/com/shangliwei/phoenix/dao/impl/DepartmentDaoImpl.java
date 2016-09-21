package com.shangliwei.phoenix.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.dao.IDepartmentDao;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.util.JDBCTemplate;

public class DepartmentDaoImpl extends JDBCTemplate implements IDepartmentDao {

	@Override
	public void add(DepartmentPo po, Connection connection) throws SQLException {
		String sql = "INSERT INTO S_T_DEPARTMENT(ID,NAME,PARENT_ID,TYPE,MANAGER,STATE,CREATE_DATE,CLOSE_DATE,DESCRIPTION,CREATER,CREATTIME) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getId());
		parameters.add(po.getName());
		parameters.add(po.getParentId());
		parameters.add(po.getType());
		parameters.add(po.getManager());
		parameters.add(po.getState());
		parameters.add(po.getCreateDate());
		parameters.add(po.getCloseDate());
		parameters.add(po.getDescription());
		parameters.add(po.getCreater());
		parameters.add(po.getCreattime());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void update(DepartmentPo po, Connection connection) throws SQLException {
		String sql = "UPDATE S_T_DEPARTMENT SET NAME=?,PARENT_ID=?,TYPE=?,MANAGER=?,STATE=?,CREATE_DATE=?,CLOSE_DATE=?,DESCRIPTION=?,EDITER=?,EDITTIME=? WHERE ID=?";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getName());
		parameters.add(po.getParentId());
		parameters.add(po.getType());
		parameters.add(po.getManager());
		parameters.add(po.getState());
		parameters.add(po.getCreateDate());
		parameters.add(po.getCloseDate());
		parameters.add(po.getDescription());
		parameters.add(po.getCreater());
		parameters.add(po.getCreattime());
		parameters.add(po.getId());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void delete(String id, Connection connection) throws SQLException {
		String sql = "DELETE FROM S_T_DEPARTMENT WHERE ID=?";
		this.executeUpdate(sql, Arrays.asList(id), connection);

	}

	@Override
	public DepartmentPo query(String id, Connection connection) throws SQLException {
		DepartmentPo po = null;
		String sql = "SELECT * FROM S_T_DEPARTMENT WHERE ID=?";
		Map<String, Object> result = this.executeOne(sql, Arrays.asList(id), connection);
		if (result != null) {
			po = this.toPo(result);
		}
		return po;
	}

	@Override
	public List<DepartmentPo> query(Map<String, Object> condition, int beginRow, int endRow, Connection connection) throws SQLException {
		List<DepartmentPo> poList = null;
		StringBuffer sql = new StringBuffer();
		List<Object> parameters = new ArrayList<>();
		sql.append("SELECT * FROM S_T_DEPARTMENT WHERE 1=1 ");
		if (condition != null && condition.size() > 0) {
			if (condition.get("name") != null && !"".equals(condition.get("name"))) {
				sql.append("AND NAME LIKE ? ");
				parameters.add("%" + condition.get("name") + "%");
			}
			if (condition.get("parentId") != null && !"".equals(condition.get("parentId"))) {
				sql.append("AND PARENT_ID LIKE ? ");
				parameters.add("%" + condition.get("parentId") + "%");
			}
			if (condition.get("type") != null && !"".equals(condition.get("type"))) {
				sql.append("AND TYPE=? ");
				parameters.add(condition.get("type"));
			}
			if (condition.get("manager") != null && !"".equals(condition.get("manager"))) {
				sql.append("AND MANAGER LIKE ? ");
				parameters.add("%" + condition.get("manager") + "%");
			}
			if (condition.get("state") != null && !"".equals(condition.get("state"))) {
				sql.append("AND STATE=? ");
				parameters.add(condition.get("state"));
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
	
	private DepartmentPo toPo(Map<String, Object> result) {
		DepartmentPo po = new DepartmentPo();
		po.setId((String) result.get("ID"));
		po.setName((String) result.get("NAME"));
		po.setParentId((String) result.get("PARENT_ID"));
		po.setType((String) result.get("TYPE"));
		po.setManager((String) result.get("MANAGER"));
		po.setState((String) result.get("STATE"));
		po.setCreateDate((Date) result.get("CREATE_DATE"));
		po.setCloseDate((Date) result.get("CLOSE_DATE"));
		po.setDescription((String) result.get("DESCRIPTION"));
		po.setCreater((String) result.get("CREATER"));
		po.setCreattime((Timestamp) result.get("CREATTIME"));
		po.setEditer((String) result.get("EDITER"));
		po.setEdittime((Timestamp) result.get("EDITTIME"));
		return po;
	}

}
