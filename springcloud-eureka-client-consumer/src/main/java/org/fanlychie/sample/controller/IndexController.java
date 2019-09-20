package org.fanlychie.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fanlychie
 * @date 2019/9/20
 */
@RestController
public class IndexController {

    @Value("${client.provider.service-url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return restTemplate.getForObject(serviceUrl + "sayHi", String.class);
    }

}