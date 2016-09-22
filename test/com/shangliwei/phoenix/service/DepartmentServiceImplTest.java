package com.shangliwei.phoenix.service;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import com.shangliwei.phoenix.domain.vo.DepartmentDetailVo;
import com.shangliwei.phoenix.proxy.ServiceProxy;
import com.shangliwei.phoenix.service.impl.DepartmentServiceImpl;

public class DepartmentServiceImplTest {

	private IDepartmentService service = (IDepartmentService) new ServiceProxy().bind(new DepartmentServiceImpl());//new DepartmentServiceImpl();
	
	@Test
	public void testAdd() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testUpdate() throws ClassNotFoundException, SQLException, ParseException {
		DepartmentDetailVo vo = service.queryDetail("72224d499da04755b0504e3b26da1fd7");
		vo.setState("02");
		vo.setCloseDateCN("2016-09-22");
		service.update(vo, "admin");
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
