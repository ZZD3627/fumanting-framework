package com.fumanting.boot.config;

import com.fumanting.boot.event.OpensabreStartedEventHandler;
import com.fumanting.boot.rest.MapingInfoHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName OpensabreServiceConfig
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:03
 * @Version 1.0
 */
@AutoConfiguration
@Import({OpensabreStartedEventHandler.class, MapingInfoHandler.class})
public class OpensabreServiceConfig {
}
