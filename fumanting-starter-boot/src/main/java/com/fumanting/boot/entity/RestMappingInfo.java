package com.fumanting.boot.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @ClassName RestMappingInfo
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:12
 * @Version 1.0
 */
@Data
@RequiredArgsConstructor
public class RestMappingInfo {

	/**
	 * Rest 的path url.如：/user/{name}
	 */
	@NonNull
	private String url;

	/**
	 * Rest 的方法，如:GET/POST
	 */
	@NonNull
	private String method;

}
