package com.fumanting.boot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SwaggerInfo
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:26
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "opensabre.rest.swagger")
public class SwaggerInfo {

	private String version;
	private String title;
	private String description;
	private String licenseUrl;
	private String licenseName;
	private String wikiUrl;
	private String wikiDocumentation;

}
