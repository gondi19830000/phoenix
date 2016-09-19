package com.shangliwei.phoenix.service;

import java.util.Map;

import com.shangliwei.phoenix.util.Pagination;

public interface IService<T> {

	public void add(T detailVo);
	public void update(T detailVo);
	public void delete(String id);
	public T queryDetail(String id);
	public Object queryList(Map<String, Object> condition, Pagination pagination);
	public Object queryPop(Map<String, Object> condition, Pagination pagination);
}
