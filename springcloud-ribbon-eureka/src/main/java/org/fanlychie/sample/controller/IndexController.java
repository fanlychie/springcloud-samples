package org.fanlychie.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fanlychie
 * @date 2019/09/18
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return restTemplate.getForObject("http://CLIENT-PROVIDER-CLUSTER/sayHi", String.class);
    }

}