package com.fumanting.register.config;

import com.fumanting.boot.metadata.OpensabreCloud;
import com.fumanting.boot.metadata.OpensabreVersion;

import java.util.HashMap;
import java.util.Map;

import static com.fumanting.boot.config.OpensabreEnvConfig.*;

/**
 * @ClassName Meradata
 * @Description 应用元数据类
 * @Author zhang zhengdong
 * @DATE 2024/7/29 16:16
 * @Version 1.0
 */
public class Metadata {

	/**
	 * 元数据存储容器
	 */
	private final Map<String, String> metadata = new HashMap<>();

	public Metadata() {
		metadata.put(OPENSABRE_VERSION, OpensabreVersion.getVersion());
		metadata.put(OPENSABRE_CLOUD_AZ, OpensabreCloud.getCloudAz());
		metadata.put(OPENSABRE_CLOUD_REGION, OpensabreCloud.getCloudRegion());
	}

	/**
	 * 获取全部元数据
	 *
	 * @return
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}
}
