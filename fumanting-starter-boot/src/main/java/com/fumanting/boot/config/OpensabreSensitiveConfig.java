package com.fumanting.boot.config;

import com.fumanting.boot.event.OpensabreSensitiveDesensitizerProcessor;
import com.fumanting.boot.sensitive.log.LogBackCoreConverter;
import com.fumanting.boot.sensitive.log.desensitizer.LogBackDesensitizer;
import com.fumanting.boot.sensitive.log.desensitizer.RegxLogBackDesensitizer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName OpensabreSensitiveConfig
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:12
 * @Version 1.0
 */
@AutoConfiguration
@ConditionalOnProperty(value = "opensabre.sensitive.log.enabled", havingValue = "true")
public class OpensabreSensitiveConfig {

	@Bean
	public BeanFactoryPostProcessor beanFactoryPostProcessor() {

		return configurableListableBeanFactory -> {
			LogBackCoreConverter logBackCoreConverter = LogBackCoreConverter.getInstance();
			configurableListableBeanFactory.registerSingleton("logBackCoreConverter", logBackCoreConverter);
			configurableListableBeanFactory.registerSingleton("defaultDesensitizerStrategy", logBackCoreConverter.getDesensitizerStrategy());
		};
	}

	@Bean
	@ConditionalOnMissingBean
	public LogBackDesensitizer regxLogBackDesensitizer() {
		return new RegxLogBackDesensitizer();
	}

	@Bean
	public BeanPostProcessor opensabreSensitiveDesensitizerProcessor() {
		return new OpensabreSensitiveDesensitizerProcessor();
	}

}
