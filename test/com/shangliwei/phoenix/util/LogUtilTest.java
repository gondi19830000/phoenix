package com.shangliwei.phoenix.util;

import org.junit.Test;

import com.shangliwei.phoenix.constant.LogConstant;

public class LogUtilTest {

	@Test
	public void testPrint() {
		LogUtil.print("Test message", LogUtil.LEVEL_DEBUG, LogConstant.DEVELOP_MODE);
	}

}
