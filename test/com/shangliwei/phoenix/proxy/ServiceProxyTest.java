package com.shangliwei.phoenix.proxy;

import java.sql.SQLException;

import org.junit.Test;

import com.shangliwei.phoenix.service.IEmployeeService;
import com.shangliwei.phoenix.service.impl.EmployeeServiceImpl;

public class ServiceProxyTest {

	@Test
	public void testBind() throws ClassNotFoundException, SQLException {
		IEmployeeService service = (IEmployeeService) new ServiceProxy().bind(new EmployeeServiceImpl());
		System.out.println(service.queryDetail("3d280f723da547c1bf809d6d430f8c0e"));
	}

}
