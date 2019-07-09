package com.demo;

import org.junit.Test;

/**
 * 加密工具类测试类
 * @author Administrator
 *
 */
public class EncodeUtilsTest {

	@Test
	public void MD5EncodeTest() {
		String md5Encode = EncodeUtils.MD5Encode("admin");
		System.out.println(md5Encode);
	}
}
