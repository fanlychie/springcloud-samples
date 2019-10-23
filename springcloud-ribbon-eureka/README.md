### Spring Cloud Ribbon

客户端负载均衡，它提供：

* PING
    - 用于检查服务的可用性
* RULE
    - 客户端负载策略
* ServiceList
    - 服务列表(静态或动态)

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`RibbonEurekaApplication.main()`访问 http://localhost:9999/

然后可关闭springcloud-eureka-client-provider任意实例，然后在启动关闭的实例，以此可查看负载均衡的效果。