package com.fumanting.common.web.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = MobileValidator.class)//标明由哪个类执行校验逻辑
@Documented
public @interface Mobile {

	/**
	 * 校验失败提示信息
	 *
	 * @return 校验失败提示信息
	 */
	String message() default "手机号格式错误";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
