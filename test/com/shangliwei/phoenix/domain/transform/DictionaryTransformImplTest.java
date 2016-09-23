package com.shangliwei.phoenix.domain.transform;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.domain.po.DictionaryPo;
import com.shangliwei.phoenix.domain.transform.impl.DictionaryTransformImpl;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DictionaryTransformImplTest {

	private DictionaryPo po;
	private IDictionaryTransform transform;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		po = new DictionaryPo();
		po.setId(SequenceUtil.getUUID());
		po.setCode("01");
		po.setName("正常");
		po.setType("EMPLOYEE_STATE");
		po.setSort(1);
		po.setEffective("01");
		po.setDescription("员工状态");
		po.setCreater("admin");
		po.setCreattime(DateTimeUtil.getTimestamp());
		po.setEditer("admin");
		po.setEdittime(DateTimeUtil.getTimestamp());
		transform = new DictionaryTransformImpl();
		connection = null;
	}

	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}

	@Test
	public void testToBo() throws SQLException {
		System.out.println(transform.toBo(po, connection));
	}

	@Test
	public void testToDetailVo() throws SQLException {
		System.out.println(transform.toDetailVo(po, connection));
	}

	@Test
	public void testToListVo() throws SQLException {
		System.out.println(transform.toListVo(po, connection));
	}

	@Test
	public void testToPopVo() throws SQLException {
		System.out.println(transform.toPopVo(po, connection));
	}

}
