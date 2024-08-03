package com.fumanting.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MappingRegisteredEvent
 * @Description 自定义Spring事件，用于Rest信息以事件方式发送出去
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:23
 * @Version 1.0
 */
public class MappingRegisteredEvent extends ApplicationEvent {
	public MappingRegisteredEvent(Object source) {
		super(source);
	}
}
