package org.fanlychie.sample.filter.factory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义过滤器, Pre 过滤器, 用于特定的路由, 只对配置的路由起效
 */
@Slf4j
@Component
public class MyPostGatewayFilterFactory extends AbstractGatewayFilterFactory<MyPostGatewayFilterFactory.Config> {

    public static final String ARG1_KEY = "arg1";

    public static final String ARG2_KEY = "arg2";

    public MyPostGatewayFilterFactory() {
        super(Config.class);
    }

    // 配置文件参数顺序(英文逗号分开)
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(ARG2_KEY, ARG1_KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("======>> [Post] {}, {}", config.arg1, config.arg2);
        }));
    }

    @Data
    public static class Config {

        private String arg1;

        private String arg2;

    }

}