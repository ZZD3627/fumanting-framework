package com.fumanting.boot.sensitive.rest.strategy;

import com.fumanting.boot.sensitive.rule.SensitiveRule;

/**
 * @ClassName CustomSensitiveStrategy
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:38
 * @Version 1.0
 */
public class CustomSensitiveStrategy implements SensitiveStrategy {

	private final SensitiveRule sensitiveRule;

	/**
	 * @param sensitiveRule 脱敏规则
	 */
	public CustomSensitiveStrategy(SensitiveRule sensitiveRule) {
		this.sensitiveRule = sensitiveRule;
	}

	/**
	 * 脱敏处理
	 *
	 * @param type      类型
	 * @param originStr 原始字符串
	 * @return 脱敏后的字符
	 */
	@Override
	public String desensitizing(SensitiveRule type, String originStr) {
		return sensitiveRule.replace(originStr);
	}
}
