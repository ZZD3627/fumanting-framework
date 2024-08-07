package com.fumanting.boot.sensitive.log.strategy;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fumanting.boot.sensitive.log.desensitizer.LogBackDesensitizer;
import com.fumanting.boot.sensitive.log.desensitizer.PasswordLogBackDesensitizer;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName DefaultDesensitizerStrategy
 * @Description 默认脱敏策略  可支持多个脱敏器，循环使用全部脱敏器处理一次
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:21
 * @Version 1.0
 */
public class DefaultDesensitizerStrategy implements DesensitizerStrategy {

	/**
	 * 默认的脱敏器
	 */
	private final Set<LogBackDesensitizer> desensitizers = Sets.newHashSet(new PasswordLogBackDesensitizer());

	@Override
	public String desensitizing(ILoggingEvent event) {
		AtomicReference<String> message = new AtomicReference<>(event.getFormattedMessage());
		desensitizers.forEach(desensitizer -> {
			message.set(desensitizer.desensitize(event, message.get()));
		});
		return message.get();
	}

	/**
	 * 追回脱敏器
	 *
	 * @param logBackDesensitizer 脱敏器
	 */
	public void addDesensitizer(LogBackDesensitizer logBackDesensitizer) {
		desensitizers.add(logBackDesensitizer);
	}
}
