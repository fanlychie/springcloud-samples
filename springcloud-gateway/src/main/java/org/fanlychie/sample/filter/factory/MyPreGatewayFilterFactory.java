package org.fanlychie.sample.filter.factory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义过滤器, Pre 过滤器, 用于特定的路由, 只对配置的路由起效
 */
@Slf4j
@Component
public class MyPreGatewayFilterFactory extends AbstractGatewayFilterFactory<MyPreGatewayFilterFactory.Config> {

    public static final String ARG1_KEY = "arg1";

    public static final String ARG2_KEY = "arg2";

    public MyPreGatewayFilterFactory() {
        super(Config.class);
    }

    // 配置文件参数顺序(英文逗号分开)
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(ARG1_KEY, ARG2_KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("======>> [Pre ] {}, {}", config.arg1, config.arg2);
            return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
        };
    }

    @Data
    public static class Config {

        private String arg1;

        private String arg2;

    }

}