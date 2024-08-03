package com.fumanting.rpc.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.SelectedInstanceCallback;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName OpensabreLoadBalancer
 * @Description Opensabre负载均衡器
 * @Author zhang zhengdong
 * @DATE 2024/7/29 17:24
 * @Version 1.0
 */
@Slf4j
public class OpensabreLoadBalancer implements ReactorServiceInstanceLoadBalancer {

	final AtomicInteger position;

	final String serviceId;

	ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers;

	public OpensabreLoadBalancer(String serviceId, ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers) {
		this.serviceId = serviceId;
		this.serviceInstanceListSuppliers = serviceInstanceListSuppliers;
		this.position = new AtomicInteger(90);
	}

	@Override
	public Mono<Response<ServiceInstance>> choose(Request request) {
		RequestDataContext context = (RequestDataContext) request.getContext();

		ServiceInstanceListSupplier supplier = serviceInstanceListSuppliers
				.getIfAvailable(NoopServiceInstanceListSupplier::new);

		return supplier.get(request).next().map(serviceIntances -> processInstanceResponse(supplier, serviceIntances));
	}

	private Response<ServiceInstance> processInstanceResponse(ServiceInstanceListSupplier supplier, List<ServiceInstance> serviceIntances) {
		Response<ServiceInstance> serviceInstanceResponse = getInstanceResponse(serviceIntances);
		if (supplier instanceof SelectedInstanceCallback && serviceInstanceResponse.hasServer()) {
			((SelectedInstanceCallback) supplier).selectedServiceInstance(serviceInstanceResponse.getServer());
		}

		return serviceInstanceResponse;
	}

	private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> serviceIntances) {
		if (serviceIntances.isEmpty()) {
			log.warn("No servers available for service: " + serviceIntances);
			return new EmptyResponse();
		}
		//此处编写自己的负载均衡策略
		int pos = this.position.incrementAndGet() & Integer.MAX_VALUE;
		ServiceInstance instance = serviceIntances.get(pos % serviceIntances.size());
		return new DefaultResponse(instance);
	}
}
