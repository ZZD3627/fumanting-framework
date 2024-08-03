package com.fumanting.common.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName RestResponseBodyAdvice
 * @Description Rest统一返回报文封装，在rest方法返回后送给客户端前执行
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:58
 * @Version 1.0
 */
public class RestResponseBodyAdvice implements ResponseBodyAdvice<Object> {


	/**
	 * 框架中不需要包装为Result对象的包名
	 */
	@Value("${opensabre.rest.result.framework.excludes}")
	private String excludeFrameworkPackageStr;

	/**
	 * 应用中不需要包装为Result对象的包名
	 */
	@Value("${opensabre.rest.result.excludes}")
	private String excludePackageStr;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return false;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		return null;
	}
}
