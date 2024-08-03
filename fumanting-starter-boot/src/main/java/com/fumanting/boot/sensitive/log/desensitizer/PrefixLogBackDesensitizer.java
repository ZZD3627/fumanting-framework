package com.fumanting.boot.sensitive.log.desensitizer;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fumanting.boot.sensitive.rule.SensitiveRule;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;

/**
 * @ClassName PrefixLogBackDesensitizer
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:27
 * @Version 1.0
 */
@Slf4j

public class PrefixLogBackDesensitizer extends AbstractLogBackDesensitizer {
	/**
	 * 规则
	 */
	private final SensitiveRule sensitiveRule;
	/**
	 * 匹配的关键词所在位置
	 */
	private final int keywordsGroupIndex;

	public PrefixLogBackDesensitizer(SensitiveRule sensitiveRule, int keywordsGroupIndex) {
		this.sensitiveRule = sensitiveRule;
		this.keywordsGroupIndex = keywordsGroupIndex;
	}


	/**
	 * 将内容中匹配前缀关键词的内容替换为*
	 *
	 * @param event     日志事件
	 * @param originStr 日志原始内容
	 * @return 脱敏后内容
	 */
	@Override
	public String desensitizing(ILoggingEvent event, String originStr) {
		AtomicReference<String> message = new AtomicReference<>(originStr);
		Matcher matcher = sensitiveRule.pattern().matcher(originStr);
		while (matcher.find()) {
			String passwd = matcher.group(keywordsGroupIndex);
			message.set(message.get().replaceAll(passwd, sensitiveRule.replace(passwd)));
		}
		return message.get();
	}

	/**
	 * 判断日志内容中是否包含关键词等字样
	 *
	 * @param event 日志事件
	 * @return true/false
	 */
	@Override
	public boolean support(ILoggingEvent event) {
		return sensitiveRule.pattern().matcher(event.getFormattedMessage()).find();
	}
}
