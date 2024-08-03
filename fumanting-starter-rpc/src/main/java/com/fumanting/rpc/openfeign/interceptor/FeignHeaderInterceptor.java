package com.fumanting.rpc.openfeign.interceptor;

import com.google.common.collect.Maps;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import javafx.scene.Parent;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FeignHeaderInterceptor
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/29 17:49
 * @Version 1.0
 */
public class FeignHeaderInterceptor implements RequestInterceptor {

	/**
	 * 获取request header 放入远程template
	 *
	 * @param requestTemplate
	 */
	@Override
	public void apply(RequestTemplate requestTemplate) {
		getHeaders().forEach(requestTemplate::header);
	}

	private Map<String, String> getHeaders() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HashMap<String, String> map = Maps.newHashMap();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			String value = request.getHeader(key);

			map.put(key, value);
		}
		return map;
	}
}
