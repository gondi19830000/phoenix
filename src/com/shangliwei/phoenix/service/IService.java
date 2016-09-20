package com.shangliwei.phoenix.service;

import java.sql.SQLException;
import java.util.Map;

import com.shangliwei.phoenix.util.Pagination;

public interface IService<T> {

	public void add(T vo, String currendEmployeeId) throws ClassNotFoundException, SQLException;
	public void update(T vo, String currendEmployeeId);
	public void delete(String id, String currendEmployeeId);
	public T queryDetail(String id);
	public Object queryList(Map<String, Object> condition, Pagination pagination);
	public Object queryPop(Map<String, Object> condition, Pagination pagination);
}
