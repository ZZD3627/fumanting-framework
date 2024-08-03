package com.fumanting.common.web.entity.form;

import com.fumanting.common.web.entity.convert.EntityModelConverter;

import java.io.Serializable;

/**
 * @ClassName BaseForm
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:41
 * @Version 1.0
 */
public class BaseForm<P> implements Serializable {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * Form转化为Po
	 *
	 * @param clazz
	 * @return
	 */
	public P toPo(Class<P> clazz) {
		return EntityModelConverter.getInstance().convert(this, clazz);
	}
}
