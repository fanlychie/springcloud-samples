package org.fanlychie.sample.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

public class RibbonConfig {

    /**
     * PING: 用于检查服务的可用性
     */
    @Bean
    public IPing ping() {
        return new PingUrl();
    }

    /**
     * RULE: 客户端负载均衡策略
     * RandomRule: 随机, 对服务列表中的服务进行随机选择访问
     * RoundRobinRule: 轮询, 对服务列表中的服务进行轮询访问
     * WeightedResponseTimeRule: 权重, 对服务列表中的服务根据其平均响应时间计算每个服务的权重, 响应快的服务权重高, 被选中的概率越大
     * AvailabilityFilteringRule: 过滤掉服务列表中故障和并发请求数量超过阀值的服务, 然后采用轮询策略对剩余的服务列表进行服务访问
     * RetryRule: 对服务列表中的服务采用轮询的方式进行访问, 如果失败则进行重试
     * BestAvailableRule: 剔除服务列表中故障的服务, 然后选择最空闲(并发访问数量最小)的服务进行访问
     * ZoneAvoidanceRule: 默认策略, 通过判断服务所在的区域和性能来选择一个服务访问
     */
    @Bean
    public IRule rule() {
        return new AvailabilityFilteringRule();
    }

}