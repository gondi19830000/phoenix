package com.shangliwei.phoenix.domain.transform;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shangliwei.phoenix.domain.bo.DepartmentBo;
import com.shangliwei.phoenix.domain.po.DepartmentPo;
import com.shangliwei.phoenix.domain.transform.impl.DepartmentTransformImpl;
import com.shangliwei.phoenix.util.DBUtil;
import com.shangliwei.phoenix.util.DateTimeUtil;
import com.shangliwei.phoenix.util.SequenceUtil;

public class DepartmentTransformImplTest {

	private DepartmentPo po;
	private IDepartmentTransform transform;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		po = new DepartmentPo();
		po.setId(SequenceUtil.getUUID());
		po.setName("IT支持部");
		po.setParentId("185");
		po.setType("01");
		po.setState("01");
		po.setManager("admin");
		po.setDescription("测试新增部门");
		po.setCreateDate(DateTimeUtil.getDate());
		po.setCreater("admin");
		po.setCreattime(DateTimeUtil.getTimestamp());
		transform = new DepartmentTransformImpl();
		connection = DBUtil.getConnection(true);
	}
	
	@After
	public void tearDown() throws Exception {
		DBUtil.release(connection);
	}
	
	@Test
	public void testToBo() throws SQLException {
		DepartmentBo bo = (DepartmentBo) transform.toBo(po, connection);
		System.out.println(bo);
	}

	@Test
	public void testToDetailVo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToListVo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToPopVo() {
		fail("Not yet implemented");
	}

}
