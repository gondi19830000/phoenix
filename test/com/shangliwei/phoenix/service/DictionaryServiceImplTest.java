package com.shangliwei.phoenix.service;

import java.sql.SQLException;

import org.junit.Test;

import com.shangliwei.phoenix.domain.vo.DictionaryDetailVo;
import com.shangliwei.phoenix.service.impl.DictionaryServiceImpl;

public class DictionaryServiceImplTest {

	private IDictionaryService service = new DictionaryServiceImpl();

	@Test
	public void testAdd() throws ClassNotFoundException, SQLException {
		DictionaryDetailVo vo = new DictionaryDetailVo();
		vo.setCode("01");
		vo.setName("有效");
		vo.setType("DICTIONARY_EFFECTIVE");
		vo.setSort("1");
		vo.setEffective("01");
		vo.setDescription("字典项是否有效");
		service.add(vo, "admin");
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		DictionaryDetailVo vo = service.queryDetail("702c167ea2e74b13947865c98fd6c2ab");
		vo.setEffective("02");
		service.update(vo, "admin");
	}

	@Test
	public void testDelete() throws ClassNotFoundException, SQLException {
		service.delete("090efe7df96d46e595f09a8ad4db4413", "admin");
	}

	@Test
	public void testQueryDetail() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryDetail("702c167ea2e74b13947865c98fd6c2ab"));
	}

	@Test
	public void testQueryList() throws ClassNotFoundException, SQLException {
		System.out.println(service.queryList(null, null));
	}

	@Test
	public void testQueryPop() throws ClassNotFoundException, SQLException {
		service.queryPop(null, null);
	}

}
