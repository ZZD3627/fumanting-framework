package com.fumanting.boot.sensitive.rule;

import cn.hutool.core.text.CharSequenceUtil;

import java.util.regex.Pattern;

/**
 * 脱敏策略
 */
public interface SensitiveRule {

	/**
	 * 类别
	 * 如: 类别[电话]，就包含mobile phone telephone等
	 *
	 * @return 保留前缀个数
	 */
	String category();

	/**
	 * 正则表达式
	 *
	 * @return 脱敏字段的正则
	 */
	Pattern pattern();

	/**
	 * 保留前缀个数（许满足大于等于0）
	 * 如: 538261, 保留前缀个数为2的话， 那么就是 53
	 *
	 * @return
	 */
	int retainPrefixCount();


	/**
	 * 保留后缀格式（需满足 大于等于0个）
	 * 如: 123456, 保留后缀个数为2的话， 那么就是 56
	 *
	 * @return 保留后缀
	 */
	int retainSuffixCount();


	/**
	 * 用于替代明文的 密文字符
	 * 如: 对123456使用*进行前2后2的脱敏, 那么就是 12**56
	 *
	 * @return 用于替代明文的 密文字符，默认*
	 */
	default char repalceChar() {
		return '*';
	}

	/**
	 * 原始字符串 替换
	 *
	 * @param originStr 原始字符串
	 * @return 替换后的字符串
	 */
	default String replace(String originStr) {
		return CharSequenceUtil.replace(originStr
				, this.retainPrefixCount()
				, originStr.length() - this.retainSuffixCount()
				, this.repalceChar());
	}


}
