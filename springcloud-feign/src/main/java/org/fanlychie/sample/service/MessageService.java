package org.fanlychie.sample.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// CLIENT-PROVIDER-CLUSTER 为服务提供者注册到 Eureka 中的服务ID
@FeignClient("CLIENT-PROVIDER-CLUSTER")
public interface MessageService {

    @GetMapping("/sayHi")
    String sayHi();

}