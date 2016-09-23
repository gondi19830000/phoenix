package com.shangliwei.phoenix.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.domain.po.DictionaryPo;

public interface IDictionaryDao extends IDao<DictionaryPo> {

	public DictionaryPo query(String code, String type, Connection connection) throws SQLException;
}
