package com.bank.manager.common;

import com.bank.manager.utils.SecurityUtil;

import java.util.Objects;
import java.util.UUID;

/**
 * 用户 token
 */
public class UserToken {
    /**
     * 获取 token
     * @return token
     */
	public static String getToken() {

		return SecurityUtil.md5(UUID.randomUUID().toString() + System.currentTimeMillis());
	}


	/**
	 * 验证 token
	 *
	 * @return true 合法 token;false 非法 token
	 */
	static boolean verifyToken(String inputToken,String realToken) {

		return Objects.equals(inputToken,realToken);
	}
}