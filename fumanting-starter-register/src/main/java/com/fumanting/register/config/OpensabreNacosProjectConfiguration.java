package com.fumanting.register.config;

import com.alibaba.cloud.nacos.ConditionalOnNacosDiscoveryEnabled;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClientConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @ClassName OpensabreNacosProjectConfiguration
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/29 16:43
 * @Version 1.0
 */
@Slf4j
@AutoConfiguration
@ConditionalOnNacosDiscoveryEnabled
@AutoConfigureBefore({NacosDiscoveryClientConfiguration.class})
public class OpensabreNacosProjectConfiguration implements EnvironmentAware {

	@Value("${spring.application.name}")
	private String applicationName;

	@Override
	public void setEnvironment(Environment environment) {
		if (StringUtils.isBlank(System.getProperty("project.name"))) {
			System.setProperty("project.name", applicationName);
		}
	}
}
