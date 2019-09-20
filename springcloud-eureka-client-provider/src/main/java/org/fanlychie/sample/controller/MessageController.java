package org.fanlychie.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanlychie
 * @date 2019/9/20
 */
@Slf4j
@RestController
public class MessageController {

    @GetMapping("/")
    public String ping() {
        log.info("======== PING ========");
        return HttpStatus.OK.name();
    }

    @GetMapping("/sayHi")
    public String sayHi() {
        log.info("======== HI ========");
        return "Hi, my friend.";
    }

}