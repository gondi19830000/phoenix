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
	private IDepartmentDao dao = new DepartmentDaoImpl();
	
	@Before
	public void setUp() throws Exception {
		connection = DBUtil.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.getConnection();
	}

	@Test
	public void testAdd() throws SQLException {
		DepartmentPo po = new DepartmentPo();
		po.setId(SequenceUtil.getUUID());
		po.setName("IT支持部");
		po.setParentId("185");
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
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryStringConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryMapOfStringObjectIntIntConnection() {
		fail("Not yet implemented");
	}

}
