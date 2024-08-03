package com.fumanting.boot.sensitive.rest.strategy;

import com.fumanting.boot.sensitive.rule.DefaultSensitiveRule;
import com.fumanting.boot.sensitive.rule.SensitiveRule;

import java.util.Arrays;

import static com.fumanting.boot.sensitive.rule.DefaultSensitiveRule.values;


/**
 * @ClassName DefaultSensitiveStrategy
 * @Description 默认的脱敏策略
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:40
 * @Version 1.0
 */
public class DefaultSensitiveStrategy implements SensitiveStrategy {

	/**
	 * 脱敏处理
	 *
	 * @param type      类型
	 * @param originStr 原始字符串
	 * @return
	 */
	@Override
	public String desensitizing(SensitiveRule type, String originStr) {

		DefaultSensitiveRule sensitiveRule = Arrays.stream(values()).sequential()
				.filter(rule -> rule.equals(type))
				.findFirst().orElse(DefaultSensitiveRule.CUSTOM);
		return sensitiveRule.replace(originStr);
	}
}
