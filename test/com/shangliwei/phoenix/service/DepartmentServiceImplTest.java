package com.shangliwei.phoenix.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.shangliwei.phoenix.domain.vo.DepartmentDetailVo;
import com.shangliwei.phoenix.service.impl.DepartmentServiceImpl;

public class DepartmentServiceImplTest {

	private IDepartmentService service = new DepartmentServiceImpl();
	
	@Test
	public void testAdd() throws ClassNotFoundException, SQLException {
		DepartmentDetailVo vo = new DepartmentDetailVo();
		vo.setName("IT支持部开发组");
		vo.setParentId("18500");
		vo.setType("01");
		vo.setManager("admin");
		vo.setCreateDateCN("2016-09-15");
		vo.setDescription("测试");
		service.add(vo, "admin");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws ClassNotFoundException, SQLException {
		service.delete("7eda6c68ca2543dfbfebfae713bcb368", "admin");
	}

	@Test
	public void testQueryDetail() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryDetail("d4ac44e4c5e8458587bc81ba1b0a6e81"));
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
