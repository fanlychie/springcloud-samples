package org.fanlychie.sample.controller;

import org.fanlychie.sample.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String index() {
        return messageService.sayHi();
    }

}