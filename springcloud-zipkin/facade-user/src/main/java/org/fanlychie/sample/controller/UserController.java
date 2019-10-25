package org.fanlychie.sample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author fanlychie
 * @date 2019/9/20
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/")
    public String ping() {
        log.info("======== PING ========");
        return HttpStatus.OK.name();
    }

    @GetMapping("/user/query")
    public User query(String username) {
        log.info("======>> request data: {}", username);
        if (Objects.equals(username, "fanlychie")) {
            return new User("fanlychie", "fanlychie@yeah.net");
        }
        return null;
    }

    @Data
    public static class User {

        private String username;

        private String email;

        public User(String username, String email) {
            this.email = email;
            this.username = username;
        }

    }

}