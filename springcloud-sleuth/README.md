### Spring Cloud Sleuth

`Sleuth`是一个分布式链路跟踪服务。在一个复杂的微服务架构系统中，几乎每一个客户端请求都会形成一条复杂的分布式服务调用链路，对请求调用的跟踪可以帮助我们快速发现错误根源以及监控分析每条请求链路上的性能瓶颈等。

---

日志格式：

```
2019-10-24 10:45:07.968  INFO [ARTICLE-SERVICE,5db11033d9cf3da3a8f8ec3b5593a561,a8f8ec3b5593a561,false] 5140 --- [nio-8660-exec-5] o.f.sample.controller.ArticleController  : ======>> request data: springcloud
```

`[ARTICLE-SERVICE,5db11033d9cf3da3a8f8ec3b5593a561,a8f8ec3b5593a561,false]`

* [AppName, TraceID, SpanID, Zipkin]
    - AppName: 服务名称, 即配置的`spring.application.name`
    - TraceID: 跟踪ID, 用来标记一次请求。一个Trace由一个或多个Span组成, 这些Span都具有相同的TraceID
    - SpanID: Span基本工作单元，当调用一个其它服务时，就会产生一个Span
    - Zipkin: 是否要将该信息输出到Zipkin等服务中来收集和展示

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

启动服务提供者`UserServiceApplication.main()`

启动服务消费者`ArticleServiceApplication.main()`访问 http://localhost:8660/article/query?title=springcloud