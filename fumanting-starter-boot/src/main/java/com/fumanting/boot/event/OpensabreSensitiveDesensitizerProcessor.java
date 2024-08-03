package com.fumanting.boot.event;

import com.fumanting.boot.sensitive.log.desensitizer.LogBackDesensitizer;
import com.fumanting.boot.sensitive.log.strategy.DefaultDesensitizerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.Resource;

/**
 * @ClassName OpensabreSensitiveDesensitizerProcessor
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 16:46
 * @Version 1.0
 */
@Slf4j
public class OpensabreSensitiveDesensitizerProcessor implements BeanPostProcessor {

	@Resource
	private DefaultDesensitizerStrategy defaultDesensitizerStrategy;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LogBackDesensitizer) {
			log.info("postProcessAfterInitialization==> Bean Name: {}", beanName);
			defaultDesensitizerStrategy.addDesensitizer((LogBackDesensitizer) bean);
		}
		return bean;
	}
}
