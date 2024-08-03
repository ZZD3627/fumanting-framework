package com.fumanting.boot.config;

import com.fumanting.common.web.exception.DefaultGlobalExceptionHandlerAdvice;
import com.fumanting.common.web.rest.RestResponseBodyAdvice;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName OpensabreBootConfig
 * @Description 初使化全局报文和全局异常配置
 * @Author zhang zhengdong
 * @DATE 2024/8/1 14:53
 * @Version 1.0
 */
@AutoConfiguration
@PropertySource(value = "classpath:opensabre-boot.properties", encoding = "UTF8")
@Import({DefaultGlobalExceptionHandlerAdvice.class, RestResponseBodyAdvice.class})
public class OpensabreBootConfig {
}
