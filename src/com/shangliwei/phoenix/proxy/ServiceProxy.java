package com.shangliwei.phoenix.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import com.shangliwei.phoenix.util.DBUtil;

public class ServiceProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);   
	}
	
	 @Override  
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			openTransaction();
			result = method.invoke(target, args);
			saveTransaction();
		} finally {
			closeTransaction();
		}
		return result;
	}

	private void openTransaction() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, SQLException {
		Field field = target.getClass().getDeclaredField("connection");
		field.setAccessible(true);
		field.set(target, DBUtil.getConnection(false));
	}

	private void saveTransaction() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		Field field = target.getClass().getDeclaredField("connection");
		field.setAccessible(true);
		DBUtil.commitConnection((Connection) field.get(target));
	}

	private void closeTransaction() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		Field field = target.getClass().getDeclaredField("connection");
		field.setAccessible(true);
		DBUtil.release((Connection) field.get(target));
	}
	
}
