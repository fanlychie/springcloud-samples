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

#### Hystrix Dashboard

```xml
<!-- hystrix dashboard -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
<!-- actuator -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<!-- turbine -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-turbine</artifactId>
</dependency>
```

访问 Endpoint http://localhost:9090/actuator/hystrix.stream

访问 http://localhost:9999/hystrix

访问 http://localhost:9999/turbine.stream

第一行长输入框地址填入：

Hystrix Dashboard 支持三种不同的监控方式：

* 默认的集群监控
    - http://turbine-hostname:port/turbine.stream
* 指定的集群监控
    - http://turbine-hostname:port/turbine.stream?cluster=[clusterName]
* 单体应用的监控
    - http://hystrix-app:port/actuator/hystrix.stream

http://localhost:9090/actuator/hystrix.stream

http://localhost:9999/turbine.stream