package com.fumanting.rpc.openfeign.config;

import com.fumanting.boot.config.YamlPropertyLoaderFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName OpensabreLoadBalancerConfig
 * @Description 负载均衡配置
 * @Author zhang zhengdong
 * @DATE 2024/7/29 17:47
 * @Version 1.0
 */
@AutoConfiguration
@LoadBalancerClients(defaultConfiguration = OpensabreLoadBalancerBean.class)
@PropertySource(value = {"classpath:opensabre-rpc.yml"}, encoding = "UTF8", factory = YamlPropertyLoaderFactory.class)
public class OpensabreLoadBalancerConfig {
}
