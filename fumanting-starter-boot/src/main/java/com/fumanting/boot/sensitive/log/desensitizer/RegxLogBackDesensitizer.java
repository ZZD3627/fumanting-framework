package com.fumanting.boot.sensitive.log.desensitizer;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fumanting.boot.sensitive.rule.DefaultSensitiveRule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * @ClassName RegxLogBackDesensitizer
 * @Description 正则脱敏器
 * 包含常用的敏感日志正则，如身份证、银行卡、手机号、姓名
 * @Author zhang zhengdong
 * @DATE 2024/8/1 16:29
 * @Version 1.0
 */
public class RegxLogBackDesensitizer extends AbstractLogBackDesensitizer {
	@Value("${opensabre.sensitive.log.rules}")
	private String sensitiveRuleConfig;

	public Set<DefaultSensitiveRule> sensitiveRules;

	private void init() {
		Map<String, DefaultSensitiveRule> sensitiveRuleMap = Arrays.stream((DefaultSensitiveRule.values()))
				.filter(rule -> StringUtils.contains(sensitiveRuleConfig, rule.category()))
				.collect(Collectors.toMap(DefaultSensitiveRule::category, rule -> rule));

		this.sensitiveRules = Arrays.stream(StringUtils.split(sensitiveRuleConfig, ","))
				.map(sensitiveRuleMap::get)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	@Override
	public String desensitizing(ILoggingEvent event, String originStr) {
		AtomicReference<String> message = new AtomicReference<>(originStr);
		sensitiveRules.forEach(sensitiveRule -> {
			Matcher matcher = sensitiveRule.pattern().matcher(originStr);
			while (matcher.find()) {
				String matcherStr = matcher.group();
				message.set(message.get().replaceAll(matcherStr, sensitiveRule.replace(matcherStr)));
			}
		});
		return message.get();
	}

	@Override
	public boolean support(ILoggingEvent event) {
		return sensitiveRules.stream()
				.allMatch(sensitiveRule -> sensitiveRule.pattern().matcher(event.getFormattedMessage()).find());
	}
}
