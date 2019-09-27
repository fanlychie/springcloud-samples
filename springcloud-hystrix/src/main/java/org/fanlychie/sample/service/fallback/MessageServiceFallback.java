package org.fanlychie.sample.service.fallback;

import org.fanlychie.sample.service.MessageService;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceFallback implements MessageService {

    @Override
    public String sayHi() {
        return "Hi, hystrix";
    }

}