package org.fanlychie.sample.service;

import org.fanlychie.sample.service.fallback.MessageServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// CLIENT-PROVIDER-CLUSTER 为服务提供者注册到 Eureka 中的服务ID
@FeignClient(value = "CLIENT-PROVIDER-CLUSTER", fallback = MessageServiceFallback.class)
public interface MessageService {

    @GetMapping("/sayHi")
    String sayHi();

}