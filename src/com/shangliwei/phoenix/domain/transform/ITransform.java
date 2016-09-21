package com.shangliwei.phoenix.domain.transform;

import java.sql.Connection;
import java.sql.SQLException;

public interface ITransform<T> {

	public Object toBo(T po, Connection connection) throws SQLException;
	public Object toDetailVo(T po, Connection connection);
	public Object toListVo(T po, Connection connection);
	public Object toPopVo(T po, Connection connection);
}
