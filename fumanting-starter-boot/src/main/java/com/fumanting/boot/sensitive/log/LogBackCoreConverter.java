package com.fumanting.boot.sensitive.log;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fumanting.boot.sensitive.log.strategy.DefaultDesensitizerStrategy;
import com.fumanting.boot.sensitive.log.strategy.DesensitizerStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName LogBackCoreConverter
 * @Description 日志支持核心转换器
 * @Author zhang zhengdong
 * @DATE 2024/8/1 15:15
 * @Version 1.0
 */
public class LogBackCoreConverter extends MessageConverter {

	/**
	 * 实例引用
	 */
	private static LogBackCoreConverter logBackCoreConverter;

	/**
	 * 默认日志脱敏策略
	 */
	private static DesensitizerStrategy desensitizerStrategy;

	public LogBackCoreConverter() {
		logBackCoreConverter = this;
		if (desensitizerStrategy == null)
			desensitizerStrategy = new DefaultDesensitizerStrategy();
	}

	/**
	 * 获取实例
	 *
	 * @return
	 */
	public static LogBackCoreConverter getInstance() {
		return logBackCoreConverter;
	}

	/**
	 * 获取脱敏器
	 *
	 * @return
	 */
	public DesensitizerStrategy getDesensitizerStrategy() {
		return desensitizerStrategy;
	}

	/**
	 * 设置脱敏器
	 *
	 * @param desensitizerStrategy
	 */
	public void setDesensitizerStrategy(DesensitizerStrategy desensitizerStrategy) {
		this.desensitizerStrategy = desensitizerStrategy;
	}

	@Override
	public String convert(ILoggingEvent event) {
		if (StringUtils.isBlank(event.getFormattedMessage()))
			return StringUtils.EMPTY;
		return desensitizerStrategy.desensitizing(event);
	}
}
