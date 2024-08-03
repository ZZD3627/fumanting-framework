package com.fumanting.boot.sensitive.log.desensitizer;

import com.fumanting.boot.sensitive.rule.DefaultSensitiveRule;

/**
 * @ClassName NameLogBackDesensitizer
 * @Description 姓名脱敏器
 * 日志中形如 姓名:张三 / name=李四 等形如此类的中文姓名敏感数据进行屏蔽
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:33
 * @Version 1.0
 */
public class NameLogBackDesensitizer extends PrefixLogBackDesensitizer {
	public NameLogBackDesensitizer() {
		super(DefaultSensitiveRule.NAME, 3);
	}
}
