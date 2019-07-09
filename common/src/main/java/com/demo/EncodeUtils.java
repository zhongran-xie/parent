package com.demo;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密解密工具类
 * 
 * @Author:Starry 
 */
public class EncodeUtils {
	/**
	 * MD5加密
	 * 
	 * @param origin      字符
	 * @param charsetname 编码
	 * @return
	 */
	public static String MD5Encode(String origin) {
		String md5Hex = DigestUtils.md5Hex(origin);
		return md5Hex;
	}
}
