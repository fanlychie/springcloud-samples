### Spring Cloud Zipkin

`Zipkin`是Spring Cloud官方推荐的一款分布式链路监控的组件，使用它我们可以得知每一个请求所经过的节点以及耗时等信息，并且它对代码无任何侵入。

---

官网地址 https://zipkin.io/

应用包下载：https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec

运行：

```
java -jar zipkin-server-2.18.3-exec.jar
```

访问 http://localhost:9411

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

启动服务提供者`UserFacadeApplication.main()`

启动服务消费者`ArticleFacadeApplication.main()` 访问 http://localhost:8660/article/query?title=springcloud

访问 http://localhost:9411