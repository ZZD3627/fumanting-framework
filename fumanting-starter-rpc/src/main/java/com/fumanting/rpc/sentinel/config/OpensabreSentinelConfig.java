package com.fumanting.rpc.sentinel.config;

import io.undertow.servlet.handlers.SendErrorPageHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName OpensabreSentinelConfig
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/29 18:00
 * @Version 1.0
 */
@AutoConfiguration
@Import({SendErrorPageHandler.class})
public class OpensabreSentinelConfig {
}
