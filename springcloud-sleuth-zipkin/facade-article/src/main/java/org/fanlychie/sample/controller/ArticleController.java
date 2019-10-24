package org.fanlychie.sample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.fanlychie.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.fanlychie.sample.service.UserService.*;

/**
 * @author fanlychie
 * @date 2019/9/20
 */
@Slf4j
@RestController
public class ArticleController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String ping() {
        log.info("======== PING ========");
        return HttpStatus.OK.name();
    }

    @GetMapping("/article/query")
    public Article query(String title) {
        log.info("======>> request data: {}", title);
        if (Objects.equals(title, "springcloud")) {
            return new Article("springcloud", "Hello Spring Cloud", userService.query("fanlychie"));
        }
        return null;
    }

    @Data
    public static class Article {

        private String title;

        private String content;

        private User user;

        public Article(String title, String content, User user) {
            this.user = user;
            this.title = title;
            this.content = content;
        }

    }

}