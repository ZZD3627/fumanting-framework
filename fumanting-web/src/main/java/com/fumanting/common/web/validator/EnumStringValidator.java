package com.fumanting.common.web.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName EnumStringValidator
 * @Description 枚举字符串校验注解判定器
 * @Author zhang zhengdong
 * @DATE 2024/7/26 20:04
 * @Version 1.0
 */
public class EnumStringValidator implements ConstraintValidator<EnumString, String> {
	/**
	 * 枚举字串，被校验对象，包含在内的字串
	 */
	private List<String> enumStringList;

	@Override
	public void initialize(EnumString constraintAnnotation) {
		enumStringList = Arrays.asList(constraintAnnotation.value());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//值为空时不校验
		if (StringUtils.isBlank(value)) {
			return true;
		}
		return enumStringList.contains(value);
	}
}
