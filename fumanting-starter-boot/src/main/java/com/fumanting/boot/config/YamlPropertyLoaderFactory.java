package com.fumanting.boot.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;

/**
 * @ClassName YamlPropertyLoaderFactory
 * @Description 加载yaml的Factory
 * @Author zhang zhengdong
 * @DATE 2024/7/29 16:32
 * @Version 1.0
 */
public class YamlPropertyLoaderFactory extends DefaultPropertySourceFactory {

	@Override
	public PropertySource<?> createPropertySource(@Nullable String name
			, EncodedResource resource) throws IOException {
		return new YamlPropertySourceLoader()
				.load(resource.getResource().getFilename(), resource.getResource())
				.get(0);
	}

}
