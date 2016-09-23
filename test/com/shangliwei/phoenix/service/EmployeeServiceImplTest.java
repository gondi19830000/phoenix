package com.shangliwei.phoenix.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.impl.EmployeeTransformImpl;
import com.shangliwei.phoenix.domain.vo.EmployeeDetailVo;
import com.shangliwei.phoenix.proxy.ServiceProxy;
import com.shangliwei.phoenix.service.impl.EmployeeServiceImpl;
import com.shangliwei.phoenix.util.DBUtil;

public class EmployeeServiceImplTest {

	private IEmployeeService service = (IEmployeeService) new ServiceProxy().bind(new EmployeeServiceImpl());
	
	@Test
	public void testAdd() throws ClassNotFoundException, SQLException, ParseException {
		EmployeeDetailVo vo = new EmployeeDetailVo();
		vo.setUsername("shangliwei1");
		vo.setPassword("123456");
		vo.setEmail(vo.getUsername() + "@icloud.com");
		vo.setPhone("13700000000");
		vo.setDepartmentId("18500");
		service.add(vo, "admin");
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection(true);
			EmployeePo po = new EmployeeDaoImpl().query("e16ade479ddd478fbe46a74a6477d554", connection);
			EmployeeDetailVo vo = new EmployeeTransformImpl().toDetailVo(po, connection);
			vo.setState("02");
			service.update(vo, "admin");
		} finally {
			DBUtil.release(connection);
		}
	}

	@Test
	public void testDelete() throws ClassNotFoundException, SQLException {
		service.delete("cbf2e270332c4c579ae97d18f2e317a6", "admin");
	}

	@Test
	public void testQueryDetail() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryDetail("3d280f723da547c1bf809d6d430f8c0e"));
	}

	@Test
	public void testQueryList() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryList(null, null));
	}

	@Test
	public void testQueryPop() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryPop(null, null));
	}

}
