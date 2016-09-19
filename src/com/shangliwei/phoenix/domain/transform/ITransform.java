package com.shangliwei.phoenix.domain.transform;

import java.sql.Connection;

public interface ITransform<T> {

	public Object toBo(T po, Connection connection);
	public Object toDetailVo(T po, Connection connection);
	public Object toListVo(T po, Connection connection);
	public Object toPopVo(T po, Connection connection);
}
