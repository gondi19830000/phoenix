package com.shangliwei.phoenix.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shangliwei.phoenix.constant.LogConstant;
import com.shangliwei.phoenix.dao.IDictionaryDao;
import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.util.JDBCTemplate;
import com.shangliwei.phoenix.util.LogUtil;
import com.shangliwei.phoenix.util.Pagination;

public class DictionaryDaoImpl extends JDBCTemplate implements IDictionaryDao {

	@Override
	public void add(DictionaryPo po, Connection connection) throws SQLException {
		String sql = "INSERT INTO S_T_DICTIONARY(ID,CODE,NAME,TYPE,SORT,EFFECTIVE,DESCRIPTION,CREATER,CREATTIME) VALUES(?,?,?,?,?,?,?,?,?)";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getId());
		parameters.add(po.getCode());
		parameters.add(po.getName());
		parameters.add(po.getType());
		parameters.add(po.getSort());
		parameters.add(po.getEffective());
		parameters.add(po.getDescription());
		parameters.add(po.getCreater());
		parameters.add(po.getCreattime());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void update(DictionaryPo po, Connection connection) throws SQLException {
		String sql = "UPDATE S_T_DICTIONARY SET CODE=?,NAME=?,TYPE=?,SORT=?,EFFECTIVE=?,DESCRIPTION=?,EDITER=?,EDITTIME=? WHERE ID=?";
		List<Object> parameters = new ArrayList<>();
		parameters.add(po.getCode());
		parameters.add(po.getName());
		parameters.add(po.getType());
		parameters.add(po.getSort());
		parameters.add(po.getEffective());
		parameters.add(po.getDescription());
		parameters.add(po.getEditer());
		parameters.add(po.getEdittime());
		parameters.add(po.getId());
		this.executeUpdate(sql, parameters, connection);
	}

	@Override
	public void delete(String id, Connection connection) throws SQLException {
		String sql = "DELETE FROM S_T_DICTIONARY WHERE ID=?";
		this.executeUpdate(sql, Arrays.asList(id), connection);
	}

	@Override
	public DictionaryPo query(String id, Connection connection) throws SQLException {
		/*DictionaryPo po = null;
		String sql = "SELECT * FROM S_T_DICTIONARY WHERE ID=?";
		Map<String, Object> result = this.executeOne(sql, Arrays.asList(id), connection);
		if (result != null) {
			po = this.toPo(result);
		}
		return po;*/
		String message = "Un imploment interface method:" + Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
		LogUtil.print(message, LogUtil.LEVEL_ERROR, LogConstant.DEVELOP_MODE);
		throw new RuntimeException(message);
	}

	@Override
	public List<DictionaryPo> query(Map<String, Object> condition, Pagination pagination, Connection connection) throws SQLException {
		List<DictionaryPo> poList = null;
		StringBuffer sql = new StringBuffer();
		List<Object> parameters = new ArrayList<>();
		sql.append("SELECT * FROM S_T_DICTIONARY WHERE 1=1 ");
		if (condition != null && condition.size() > 0) {
			if (condition.get("code")!=null && !"".equals(condition.get("code"))) {
				sql.append("AND CODE=? ");
				parameters.add(condition.get("code"));
			}
			if (condition.get("name")!=null && !"".equals(condition.get("name"))) {
				sql.append("AND LIKE ? ");
				parameters.add("%" + condition.get("name") + "%");
			}
			if (condition.get("type")!=null && !"".equals(condition.get("type"))) {
				sql.append("AND TYPE=? ");
				parameters.add(condition.get("type"));
			}
			if (condition.get("description")!=null && !"".equals(condition.get("description"))) {
				sql.append("AND DESCRIPTION like ? ");
				parameters.add("%" + condition.get("description") + "%");
			}
			if (pagination != null) {
				sql.append("ROWNUM BETWEEN ? AND ? ");
				parameters.add(pagination.getBeginRow());
				parameters.add(pagination.getEndRow());
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
	
	private DictionaryPo toPo(Map<String, Object> result) {
		DictionaryPo po = new DictionaryPo();
		po.setId((String) result.get("ID"));
		po.setCode((String) result.get("CODE"));
		po.setName((String) result.get("NAME"));
		po.setType((String) result.get("TYPE"));
		po.setSort((int) result.get("SORT"));
		po.setEffective((String) result.get("EFFECTIVE"));
		po.setDescription((String) result.get("DESCRIPTION"));
		po.setCreater((String) result.get("CREATER"));
		po.setCreattime((Timestamp) result.get("CREATTIME"));
		po.setEditer((String) result.get("EDITER"));
		po.setEdittime((Timestamp) result.get("EDITTIME"));
		return po;
	}

	@Override
	public DictionaryPo query(String code, String type, Connection connection) throws SQLException {
		DictionaryPo po = null;
		String sql = "SELECT * FROM S_T_DICTIONARY WHERE CODE=? AND TYPE=?";
		Map<String, Object> result = this.executeOne(sql, Arrays.asList(code, type), connection);
		if (result != null) {
			po = this.toPo(result);
		}
		return po;
	}

}
