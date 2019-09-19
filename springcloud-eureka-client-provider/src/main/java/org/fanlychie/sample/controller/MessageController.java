package org.fanlychie.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanlychie
 * @date 2019/9/20
 */
@Slf4j
@RestController
public class MessageController {

    @GetMapping("/sayHi")
    public String sayHi() {
        log.info("------ sayHi ------");
        return "Hi, my friend.";
    }

}