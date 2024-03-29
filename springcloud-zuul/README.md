### Spring Cloud Zuul

在微服务架构中，后端服务往往不直接公开给客户端调用，而是通过一个`API`网关根据请求的`URL`，路由到相应的服务。

`Zuul`作为微服务网关组件，它主要提供路由、监控、弹性伸缩和安全等。

Zuul中的过滤器总共有4种类型：

* `pre`
    - 在请求被路由之前执行。适用于身份认证的场景，认证通过后再继续执行下面的流程。
* `route`
    - 在请求被路由时执行。适用于灰度发布场景，在将要路由的时候可以做一些自定义的逻辑。
* `post`
    - 在route和error执行完成之后执行。这种过滤器将请求路由到达具体的服务之后执行。适用于需要添加响应头，记录响应日志等应用场景。
* `error`
    - 处理请求发生错误时执行。可以用来统一记录错误信息。

集群方式：

* 使用Nginx

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`ZuulApplication.main()`访问 http://localhost:8888/api/provider/sayHi