##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`RibbonApplication.main()`访问 http://localhost:9999/

然后可关闭springcloud-eureka-client-provider任意实例，然后在启动关闭的实例，以此可查看负载均衡的效果。