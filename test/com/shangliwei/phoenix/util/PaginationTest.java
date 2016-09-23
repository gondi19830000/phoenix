package com.shangliwei.phoenix.util;

import org.junit.Test;

import com.shangliwei.phoenix.constant.PaginationConstant;

public class PaginationTest {

	@Test
	public void test() {
		Pagination pagination = new Pagination(100, PaginationConstant.PAGE_SIZE, 1);
		System.out.println("count row:" + pagination.getCountRow());
		System.out.println("page size:" + pagination.getPageSize());
		System.out.println("current page:" + pagination.getCurrentPage());
		System.out.println("begin row:" + pagination.getBeginRow());
		System.out.println("end row:" + pagination.getEndRow());
		System.out.println("count page:" + pagination.getCountPage());
	}

}
