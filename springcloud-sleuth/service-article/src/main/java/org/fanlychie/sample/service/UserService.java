package org.fanlychie.sample.service;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("USER-SERVICE")
public interface UserService {

    @GetMapping("/user/query")
    User query(@RequestParam String username);

    @Data
    class User {

        private String username;

        private String email;

        public User(String username, String email) {
            this.email = email;
            this.username = username;
        }

    }

}