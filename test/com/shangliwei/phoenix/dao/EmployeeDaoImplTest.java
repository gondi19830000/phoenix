package com.shangliwei.phoenix.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class EmployeeDaoImplTest {

	private Connection connection;
	private IEmployeeDao dao;
	
	@Before
	public void setUp() throws Exception {
		connection = DBUtil.getConnection();
		dao = new EmployeeDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}

	@Test
	public void testAdd() throws SQLException {
		EmployeePo po = new EmployeePo();
		po.setId(SequenceUtil.getUUID());
		po.setSequence(18);
		po.setUsername("sunxiaomei");
		po.setPassword("123456");
		po.setEmail("sunxiaomei@icloud.com");
		po.setPhone("13700000000");
		po.setState("01");
		po.setDepartmentId("18500");
		po.setCreater("admin");
		po.setCreattime(DateTimeUtil.getTimestamp());
		dao.add(po, connection);
	}

	@Test
	public void testUpdate() throws SQLException {
		EmployeePo po = dao.query("c2f39a1947ca419a8d0c351730501fb2", connection);
		po.setState("02");
		po.setEditer("admin");
		po.setEdittime(DateTimeUtil.getTimestamp());
		dao.update(po, connection);
	}

	@Test
	public void testDelete() throws SQLException {
		dao.delete("2262fed5d6534a8688da10de76eb5a24", connection);
	}

	@Test
	public void testQueryStringConnection() throws SQLException {
		System.out.println(dao.query("c2f39a1947ca419a8d0c351730501fb2", connection));
	}

	@Test
	public void testQueryMapOfStringObjectIntIntConnection() throws SQLException {
		Map<String, Object> condition = new HashMap<>();
		condition.put("username", "shangliwei");
		System.out.println(dao.query(condition, 0, 0, connection));
	}
	
	@Test
	public void testGetMaxSequence() throws SQLException {
		System.out.println(dao.getMaxSequence(connection));
	}

}
