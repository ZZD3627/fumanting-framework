package com.fumanting.boot.sensitive.rest.strategy;

import com.fumanting.boot.sensitive.rule.SensitiveRule;

/**
 * @ClassName SensitiveStrategy
 * @Description 脱敏策略接口
 * @Author zhang zhengdong
 * @DATE 2024/8/1 14:28
 * @Version 1.0
 */
public interface SensitiveStrategy {

	/**
	 * 脱敏处理
	 *
	 * @param type      类型
	 * @param originStr 原始字符串
	 * @return 脱敏后的字符
	 */
	String desensitizing(SensitiveRule type, String originStr);
}
