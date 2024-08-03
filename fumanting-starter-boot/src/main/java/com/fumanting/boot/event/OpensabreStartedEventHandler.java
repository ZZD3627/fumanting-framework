package com.fumanting.boot.event;

import com.fumanting.boot.rest.MapingInfoHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;

/**
 * @ClassName OpensabreStartedEventHandler
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:04
 * @Version 1.0
 */
@Slf4j
public class OpensabreStartedEventHandler implements ApplicationListener<ApplicationReadyEvent> {

	@Resource
	private ApplicationContext context;

	@Resource
	MapingInfoHandler mappingInfoHandler;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("ApplicationReadyEvent received");
		mappingInfoHandler.getMappingInfo().forEach(mappingInfo -> {
			context.publishEvent(new MappingRegisteredEvent(mappingInfo));
			log.info("Mapping Registered :{}", mappingInfo);
		});

	}
}
