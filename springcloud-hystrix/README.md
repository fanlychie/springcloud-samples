### Spring Cloud Hystrix

断路器。它提供：

- 跳闸机制
    * 当某服务的错误率超过一定阈值时，Hystrix可以自动或手动跳闸，停止请求该服务一段时间。
- 监控
    * Hystrix可以近乎实时地监控运行指标和配置的变化。
- 回退机制
    * 当请求失败、超时、被拒绝，或者当断路器打开时，执行回退逻辑。
- 自我修复
    * 当断路器打开一段时间后，会自动进入“半打开”状态，允许一个请求访问依赖的服务，如果该请求成功，则关闭断路器，否则继续保持打开状态。

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`HystrixApplication.main()`访问 http://localhost:9999/