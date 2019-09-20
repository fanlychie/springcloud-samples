package org.fanlychie.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置根路径的访问许可，以便客户端负载均衡器能够 PING 通本服务
        registry.addStatusController("/", HttpStatus.OK);
    }

}