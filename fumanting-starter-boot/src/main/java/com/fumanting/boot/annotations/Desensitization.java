package com.fumanting.boot.annotations;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fumanting.boot.sensitive.rest.DesensitizationSerialize;
import com.fumanting.boot.sensitive.rule.DefaultSensitiveRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Desensitization
 * @Description 脱敏
 * @Author zhang zhengdong
 * @DATE 2024/8/1 14:24
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerialize.class)
public @interface Desensitization {

	/**
	 * 脱敏数据类型，只有在CUSTOM的时候，retainPrefixCount和retainSuffixCount生效
	 *
	 * @return 脱敏器类型 type
	 */
	DefaultSensitiveRule type() default DefaultSensitiveRule.CUSTOM;

	/**
	 * 保留前缀个数
	 *
	 * @return
	 */
	int retainPrefixCount() default 0;

	/**
	 * 保留后缀个数
	 *
	 * @return
	 */
	int retainSuffixCount() default 0;

	/**
	 * 掩码符号
	 *
	 * @return
	 */
	char replaceChar() default '*';


}
