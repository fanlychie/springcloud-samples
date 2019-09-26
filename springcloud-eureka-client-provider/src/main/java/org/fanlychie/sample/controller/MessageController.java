package org.fanlychie.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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
    public String sayHi() throws InterruptedException {
        log.info("======== HI ========");
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2));
        return "Hi, my friend.";
    }

}