package com.shangliwei.phoenix.domain.transform;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.domain.po.EmployeePo;
import com.shangliwei.phoenix.domain.transform.impl.EmployeeTransformImpl;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class EmployeeTransformImplTest {

	private EmployeePo po;
	private IEmployeeTransform transform;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		po = new EmployeePo();
		po.setId(SequenceUtil.getUUID());
		po.setSequence(1);
		po.setEmail("shangliwei@phoenix.com");
		po.setPhone("13700000000");
		po.setState("01");
		po.setDepartmentId("101100");
		po.setCreater("admin");
//		po.setCreattime(DateTimeUtil.getTimestamp());
		transform = new EmployeeTransformImpl();
		connection = DBUtil.getConnection(true);
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
