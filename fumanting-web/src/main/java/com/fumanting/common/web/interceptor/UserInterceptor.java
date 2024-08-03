package com.fumanting.common.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fumanting.common.core.util.UserContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName UserInterceptor
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:51
 * @Version 1.0
 */
public class UserInterceptor implements HandlerInterceptor {


	/**
	 * 服务间调用token用户信息，格式为json
	 * {
	 * "user_name":"必须有"
	 * "自定义key:"value"
	 * }
	 */
	public static final String X_CLIENT_TOKEN_USER = "x-client-token-user";

	/**
	 * 服务间调用的认证token
	 */
	public static final String X_CLIENT_TOKEN = "x-client-token";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//从网关获取并校验,通过校验就可信任x-client-token-user中的信息
		checkToken(request.getHeader(X_CLIENT_TOKEN));
		String userInfoString = StringUtils.defaultIfBlank(request.getHeader(X_CLIENT_TOKEN_USER), "{}");
		UserContextHolder.getInstance().setContext(new ObjectMapper().readValue(userInfoString, Map.class));
		return true;
	}

	/**
	 * 校验Token
	 *
	 * @param token 传来的token
	 */
	private void checkToken(String token) {
		//TODO 从网关获取并校验,通过校验就可信任x-client-token-user中的信息
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		UserContextHolder.getInstance().clear();
	}

}
