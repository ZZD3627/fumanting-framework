package com.fumanting.register.config;

import com.fumanting.boot.config.YamlPropertyLoaderFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName OpensabreDiscoveryConfiguration
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/29 16:29
 * @Version 1.0
 */
@AutoConfiguration
@PropertySource(value = {"classpath:opensabre-register.yml"}, encoding = "UTF8"
		, factory = YamlPropertyLoaderFactory.class)
public class OpensabreDiscoveryConfiguration {
}
