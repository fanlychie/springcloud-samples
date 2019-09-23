### 声明式HTTP客户端 (内部整合了Ribbon)

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`FeignApplication.main()`访问 http://localhost:9999/