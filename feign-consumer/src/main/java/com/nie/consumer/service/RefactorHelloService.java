package com.nie.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nie.consumer.config.FullLogConfiguration;
import com.nie.consumer.service.impl.HelloServiceFallback;
import com.nie.provider.api.service.HelloServiceApi;

@FeignClient(value="PROVIDER", fallback=HelloServiceFallback.class, configuration=FullLogConfiguration.class)
public interface RefactorHelloService extends HelloServiceApi {

}
