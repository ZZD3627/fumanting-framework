package com.fumanting.cache.redis;

import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName JetCacheConfig
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 17:27
 * @Version 1.0
 */
@AutoConfiguration(before = JetCacheAutoConfiguration.class)
@PropertySource(value = "classpath:opensabre-cache.properties",encoding = "UTF8")
public class JetCacheConfig {
}
