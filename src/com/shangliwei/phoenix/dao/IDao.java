package com.shangliwei.phoenix.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDao<T> {

	public void add(T po, Connection connection) throws SQLException;
	public void update(T po, Connection connection) throws SQLException;
	public void delete(String id, Connection connection) throws SQLException;
	public T query(String id, Connection connection) throws SQLException;
	public List<T> query(Map<String, Object> condition, int beginRow, int endRow, Connection connection) throws SQLException;
}
