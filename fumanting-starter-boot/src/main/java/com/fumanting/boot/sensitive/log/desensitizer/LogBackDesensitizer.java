package com.fumanting.boot.sensitive.log.desensitizer;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @ClassName LogBackDesensitizer
 * @Description logback脱敏器
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:24
 * @Version 1.0
 */
public interface LogBackDesensitizer {

	/**
	 * 是否支持脱敏
	 *
	 * @param event 日志事件
	 * @return true/false 支持/不支持
	 */
	boolean support(ILoggingEvent event);


	/**
	 * 脱敏接口定义
	 *
	 * @param event     事件
	 * @param originStr 原始字段
	 * @return 脱敏后的字段
	 */
	String desensitize(final ILoggingEvent event, String originStr);
}
