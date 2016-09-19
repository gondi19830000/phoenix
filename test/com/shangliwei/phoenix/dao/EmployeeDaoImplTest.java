package com.shangliwei.phoenix.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.dao.impl.EmployeeDaoImpl;
import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class EmployeeDaoImplTest {

	private Connection connection;
	private IDao<EmployeePo> dao;
	
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
		po.setSequence(new BigDecimal("1"));
		po.setUsername("shangliwei");
		po.setPassword("123456");
		po.setEmail("shangliwei@icloud.com");
		po.setPhone("13700000000");
		po.setState("01");
		po.setDepartmentId("18500");
		po.setCreater("admin");
		//po.setCreattime(DateTimeUtil.getTimestamp());
		dao.add(po, connection);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws SQLException {
		dao.delete("2262fed5d6534a8688da10de76eb5a24", connection);
	}

	@Test
	public void testQueryStringConnection() throws SQLException {
		System.out.println(dao.query("131a4f6b10874bf3a9c6d97f3f332367", connection));
	}

	@Test
	public void testQueryMapOfStringObjectIntIntConnection() {
		fail("Not yet implemented");
	}

}
