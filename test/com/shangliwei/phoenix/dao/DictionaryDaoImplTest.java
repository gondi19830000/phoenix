package com.shangliwei.phoenix.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.dao.impl.DictionaryDaoImpl;
import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DictionaryDaoImplTest {

	private Connection connection;
	private IDictionaryDao dao;
	
	@Before
	public void setUp() throws Exception {
		connection = DBUtil.getConnection();
		dao = new DictionaryDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}

	@Test
	public void testAdd() throws SQLException {
		DictionaryPo po = new DictionaryPo();
		po.setId(SequenceUtil.getUUID());
		po.setCode("02");
		po.setName("离职");
		po.setType("EMPLOYEE_STATE");
		po.setSort(1);
		po.setEffective("01");
		po.setDescription("员工状态");
		po.setCreater("admin");
		po.setCreattime(DateTimeUtil.getTimestamp());
		dao.add(po, connection);
	}

	@Test
	public void testUpdate() throws SQLException {
		DictionaryPo po = dao.query("702c167ea2e74b13947865c98fd6c2ab", connection);
		po.setEffective("02");
		po.setEditer("admin");
		po.setEdittime(DateTimeUtil.getTimestamp());
		dao.update(po, connection);
	}

	@Test
	public void testDelete() throws SQLException {
		dao.delete("e9bcdbd2b250432eb31e2db52e8989c0", connection);
	}

	@Test
	public void testQueryStringConnection() throws SQLException {
		System.out.println(dao.query("702c167ea2e74b13947865c98fd6c2ab", connection));
	}

	@Test
	public void testQueryMapOfStringObjectIntIntConnection() throws SQLException {
		System.out.println(dao.query(null, null, connection));
	}

}
