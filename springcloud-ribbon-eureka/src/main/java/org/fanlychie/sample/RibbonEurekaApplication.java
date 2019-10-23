package org.fanlychie.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fanlychie
 * @date 2019/09/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaApplication.class, args);
    }

}