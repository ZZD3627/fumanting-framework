package com.fumanting.boot.config;

import com.fumanting.boot.entity.SwaggerInfo;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @ClassName OpensabreSwaggerConfig
 * @Description Swagger配置类
 * @Author zhang zhengdong
 * @DATE 2024/8/1 17:25
 * @Version 1.0
 */
@AutoConfiguration
@EnableConfigurationProperties(SwaggerInfo.class)
public class OpensabreSwaggerConfig {

	@Resource
	private SwaggerInfo swaggerInfo;

	/**
	 * Swagger 配置对象初始化
	 *
	 * @return OpenAPI
	 */
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title(swaggerInfo.getTitle())
						.description(swaggerInfo.getDescription())
						.version(swaggerInfo.getVersion())
						.license(new License().name(swaggerInfo.getLicenseName()).url(swaggerInfo.getLicenseUrl())))
				.externalDocs(new ExternalDocumentation().description(swaggerInfo.getWikiDocumentation())
						.url(swaggerInfo.getWikiUrl()));

	}
}
