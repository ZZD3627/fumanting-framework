package com.fumanting.boot.sensitive.rule;

import java.util.regex.Pattern;

/**
 * @ClassName DefaultSensitiveRule
 * @Description 简单的脱敏策略
 * @Author zhang zhengdong
 * @DATE 2024/8/1 14:41
 * @Version 1.0
 */
public enum DefaultSensitiveRule implements SensitiveRule {

	/**
	 * 自定义
	 */
	CUSTOM("custom", 0, 0),
	/**
	 * 账号类脱敏策略
	 */
	ACCOUNT_NO("accountNo", 3, 2),
	/**
	 * 姓名类脱敏策略
	 */
	NAME("name", "((?i)name|姓名)\\s*(?:((?i)is)|[:：=<>]+)\\s*([\\u4e00-\\u9fa5][\\u4e00-\\u9fa5]{1,5})", 1, 0),
	/**
	 * 身份证号类脱敏策略
	 */
	ID_CARD("idCard", "(\\d{6})(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])(\\d{3})((?i)x|[0-9])", 6, 2),
	/**
	 * 银行卡号
	 */
	BANK_CARD("bankCard", "([3-6]\\d{3})(\\d{8,12})(\\d{4})", 4, 3),
	/**
	 * 车牌号
	 */
	CAR_LICENSE("carLicense", "(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼][A-Z](([0-9]{5}[A-HJK])|([A-HJK]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))", 2, 2),
	/**
	 * 邮箱类脱敏策略
	 */
	EMAIL("email", "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}", 2, 7),
	/**
	 * 手机号码类脱敏策略
	 */
	MOBILE("mobile", "(13[0-9]|14[01456789]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])(\\d{8})", 3, 4),
	/**
	 * 中国固定电话
	 */
	PHONE("phone", "(0[1-9]\\d{1,2})[-]?\\d{7,8}$", 3, 2),

	/**
	 * 密码
	 */
	PASSWORD("password", "((?i)password|pass|passwd|secret|key|credential|token)\\s*(?:((?i)is)|[:：=<>]+)\\s*(\\S+)", 0, 0),

	/**
	 * 中国住址类
	 */
	ADDRESS("address", "([\\u4e00-\\u9fa5]{2,5}[省|市|自治区|行政区])([\\u4e00-\\u9fa5]{1,}[市|县|区|地区|自治州|行政单位])([\\u4e00-\\u9fa5]{1,}[市|县|区|镇|地区|市辖区|旗|岛|路|街道|巷子|海域])(\\S*)", 2, 4);
	/**
	 * 规则名称
	 */
	private final String category;
	/**
	 * 正则表达式，日志脱敏使用
	 */
	private final Pattern pattern;

	/**
	 * 保留前缀个数
	 */
	private final int retainPrefixCount;
	/**
	 * 保留后缀个数
	 */
	private final int retainSuffixCount;
	/**
	 * 用于替代明文的 密文字符
	 */
	private char replaceChar = '*';


	DefaultSensitiveRule(String category, String pattern, int retainPrefixCount, int retainSuffixCount, char replaceChar) {
		this.category = category;
		this.pattern = Pattern.compile(pattern);
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
		this.replaceChar = replaceChar;
	}


	DefaultSensitiveRule(String category, String pattern, int retainPrefixCount, int retainSuffixCount) {
		this.category = category;
		this.pattern = Pattern.compile(pattern);
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
	}


	DefaultSensitiveRule(String category, int retainPrefixCount, int retainSuffixCount) {
		this.category = category;
		this.pattern = Pattern.compile("\\*");
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
	}

	DefaultSensitiveRule(String category, String pattern) {
		this.category = category;
		this.pattern = Pattern.compile(pattern);
		this.retainPrefixCount = 0;
		this.retainSuffixCount = 0;
	}


	@Override
	public String category() {
		return this.category;
	}

	@Override
	public Pattern pattern() {
		return this.pattern;
	}

	@Override
	public int retainPrefixCount() {
		return this.retainPrefixCount;
	}

	@Override
	public int retainSuffixCount() {
		return this.retainSuffixCount;
	}

	@Override
	public char repalceChar() {
		return this.replaceChar;
	}
}
