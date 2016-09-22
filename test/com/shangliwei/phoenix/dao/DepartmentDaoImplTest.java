package com.shangliwei.phoenix.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.dao.impl.DepartmentDaoImpl;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DepartmentDaoImplTest {

	private Connection connection;
	private IDepartmentDao dao;
	
	@Before
	public void setUp() throws Exception {
		connection = DBUtil.getConnection();
		dao = new DepartmentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}

	@Test
	public void testAdd() throws SQLException {
		DepartmentPo po = new DepartmentPo();
		po.setId(SequenceUtil.getUUID());
		po.setName("IT支持部本级");
		po.setParentId("18500");
		po.setType("01");
		po.setState("01");
		po.setManager("admin");
		po.setCreateDate(DateTimeUtil.getDate());
		po.setCreater("admin");
		po.setCreattime(DateTimeUtil.getTimestamp());
		dao.add(po, connection);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws SQLException {
		dao.delete("884a5aaa075b4a92aafe5f033769e365", connection);
	}

	@Test
	public void testQueryStringConnection() throws SQLException {
		System.out.println(dao.query("f8be43dcfce84a5ba35e478b553dae5b", connection));
	}

	@Test
	public void testQueryMapOfStringObjectIntIntConnection() throws SQLException {
		System.out.println(dao.query(null, null, connection));
	}

}
