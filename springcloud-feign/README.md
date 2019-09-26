### Spring Cloud Feign

`Feign`是一个声明式的HTTP客户端，可以更便捷和优雅地调用HTTP API/RESTful API。

`feign` + `ribbon` 示例

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`FeignApplication.main()`访问 http://localhost:9999/