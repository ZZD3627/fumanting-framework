package com.fumanting.rpc.openfeign.config;

import com.fumanting.boot.config.YamlPropertyLoaderFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName OpensabreFeignConfig
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/29 17:38
 * @Version 1.0
 */
@AutoConfiguration
@PropertySource(value = {"classpath:opensabre-rpc.yml"}, encoding = "UTF8", factory = YamlPropertyLoaderFactory.class)
public class OpensabreFeignConfig {
}
