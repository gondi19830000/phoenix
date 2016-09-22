package com.shangliwei.phoenix.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import com.shangliwei.phoenix.util.Pagination;

public interface IService<T> {

	public void add(T vo, String currendEmployeeId) throws ClassNotFoundException, SQLException, ParseException;
	public void update(T vo, String currendEmployeeId) throws ClassNotFoundException, SQLException, ParseException;
	public void delete(String id, String currendEmployeeId) throws ClassNotFoundException, SQLException;
	public T queryDetail(String id) throws ClassNotFoundException, SQLException;
	public Object queryList(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException;
	public Object queryPop(Map<String, Object> condition, Pagination pagination) throws ClassNotFoundException, SQLException;
}
