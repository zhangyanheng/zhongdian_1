package com.three.zhongdian.util;

import java.util.UUID;

/**
 * @action UUID工具类
 * @user 白雪杰
 * @date 2017年6月26日
 */
public class Uid {
	public static String getUuid() {
		return UUID.randomUUID().toString();
	}
}
