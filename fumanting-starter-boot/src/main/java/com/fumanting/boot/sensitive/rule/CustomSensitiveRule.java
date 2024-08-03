package com.fumanting.boot.sensitive.rule;

import java.util.regex.Pattern;

/**
 * @ClassName CustomSensitiveRule
 * @Description 自定义脱敏规则
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:32
 * @Version 1.0
 */
public class CustomSensitiveRule implements SensitiveRule {

	/**
	 * 正则表达式
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
	 * 掩码符号，默认为*
	 */
	private char replaceChar = '*';

	/**
	 * 定义保留后/后缀个数的构造方法
	 *
	 * @param retainPrefixCount 保留前缀个数
	 * @param retainSuffixCount 保留后缀个数
	 */
	public CustomSensitiveRule(int retainPrefixCount, int retainSuffixCount) {
		this.pattern = Pattern.compile("\\*");
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
	}

	/**
	 * @param retainPrefixCount 保留前缀个数
	 * @param retainSuffixCount 保留后缀个数
	 * @param replaceChar       掩码符号
	 */
	public CustomSensitiveRule(int retainPrefixCount, int retainSuffixCount, char replaceChar) {
		this.pattern = Pattern.compile("\\*");
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
		this.replaceChar = replaceChar;
	}

	/**
	 * @param pattern           正则表达式
	 * @param retainPrefixCount 保留前缀个数
	 * @param retainSuffixCount 保留后缀个数
	 */
	public CustomSensitiveRule(String pattern, int retainPrefixCount, int retainSuffixCount) {
		this.pattern = Pattern.compile(pattern);
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
	}

	/**
	 * @param pattern           正则表达式
	 * @param retainPrefixCount 保留前缀个数
	 * @param retainSuffixCount 保留后缀个数
	 * @param replaceChar       掩码符号
	 */
	public CustomSensitiveRule(String pattern, int retainPrefixCount, int retainSuffixCount, char replaceChar) {
		this.pattern = Pattern.compile(pattern);
		this.retainPrefixCount = retainPrefixCount;
		this.retainSuffixCount = retainSuffixCount;
		this.replaceChar = replaceChar;
	}

	@Override
	public String category() {
		return "custom";
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
