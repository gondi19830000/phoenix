package com.shangliwei.phoenix.util;

import org.junit.Test;

public class SequenceUtilTest {

	@Test
	public void testGetUUID() {
		for (int i=0; i<10; i++) {
			System.out.println(SequenceUtil.getUUID());
		}
	}

}
