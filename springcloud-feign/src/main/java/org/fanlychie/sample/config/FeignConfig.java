package org.fanlychie.sample.config;

import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    /**
     * Feign 日志级别
     * NONE: 不记录日志
     * BASIC: 只记录一些基础的请求信息(如请求方法,地址,响应码,执行时间)
     * FULL:
     * HEADERS:
     * @return
     */
    @Bean
    public Level loggerLevel() {
        return Level.FULL;
    }

}