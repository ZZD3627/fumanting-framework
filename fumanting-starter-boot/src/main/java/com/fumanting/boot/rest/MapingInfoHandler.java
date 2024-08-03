package com.fumanting.boot.rest;

import com.fumanting.boot.entity.RestMappingInfo;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName MapingInfoHandler
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:09
 * @Version 1.0
 */
public class MapingInfoHandler {

	/**
	 * RequestMappingHandlerMapping类，spring web的Rest注册管理类
	 */
	@Resource
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	/**
	 * 获取spring web应用所有注册的接口服务信息
	 *
	 * @return Set RestMappingInfo
	 */
	public Set<RestMappingInfo> getMappingInfo() {
		Map<RequestMappingInfo, HandlerMethod> methodMap = requestMappingHandlerMapping.getHandlerMethods();

		Set<RestMappingInfo> interfaceInfos = new HashSet<>();

		for (RequestMappingInfo requestMappingInfo : methodMap.keySet()) {
			Set<String> urls = requestMappingInfo.getPathPatternsCondition().getPatternValues();
			Set<RequestMethod> methods = requestMappingInfo.getMethodsCondition().getMethods();
			Set<RestMappingInfo> mappingInfoSet = urls.stream().flatMap(url -> methods.stream().map(method -> new RestMappingInfo(url, method.name())))
					.collect(Collectors.toSet());
			interfaceInfos.addAll(mappingInfoSet);
		}
		return interfaceInfos;

	}

}
