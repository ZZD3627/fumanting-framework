package com.fumanting.boot.sensitive.log.desensitizer;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @ClassName AbstractLogBackDesensitizer
 * @Description 日志脱敏处理器抽象类
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:27
 * @Version 1.0
 */
public abstract class AbstractLogBackDesensitizer implements LogBackDesensitizer {


	/**
	 * 如果实现类支持，再执行脱敏的动作
	 *
	 * @param event     事件
	 * @param originStr 原始字段
	 * @return 脱敏后的字符
	 */
	@Override
	public String desensitize(ILoggingEvent event, String originStr) {
		if (support(event))
			return desensitizing(event, originStr);
		return originStr;
	}

	/**
	 * 脱敏执行
	 *
	 * @param event     日志事件
	 * @param originStr 日志信息
	 * @return 脱敏后的字符
	 */
	public abstract String desensitizing(ILoggingEvent event, String originStr);
}
