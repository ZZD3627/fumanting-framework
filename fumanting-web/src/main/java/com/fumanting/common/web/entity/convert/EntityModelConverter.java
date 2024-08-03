package com.fumanting.common.web.entity.convert;

import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName EntityModelConverter
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:35
 * @Version 1.0
 */
public class EntityModelConverter implements EntityConverter {

	private EntityModelConverter() {
	}


	/**
	 * 返回实例
	 *
	 * @return 单例
	 */
	public static EntityModelConverter getInstance() {
		return SingletonHolder.sInstance;
	}

	/**
	 * 静态内部类单例模式
	 * 单例初使化
	 */
	private static class SingletonHolder {
		private static final EntityModelConverter sInstance = new EntityModelConverter();
	}

	@SneakyThrows
	@Override
	public <F, P> P convert(F source, Class<P> targetClass) {
		P target = targetClass.getDeclaredConstructor().newInstance();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
