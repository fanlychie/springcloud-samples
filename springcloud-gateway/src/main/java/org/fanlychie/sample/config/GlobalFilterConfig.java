package org.fanlychie.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GlobalFilterConfig {

    @Bean
    public GlobalFilter preGlobalFilter() {
        return (exchange, chain) -> {
            log.info("======>> [Global Pre ]");
            return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
        };
    }

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("======>> [Global Post]");
        }));
    }

}