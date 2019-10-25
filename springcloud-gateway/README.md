### Spring Cloud Gateway

`Gateway`是Spring Cloud生态中的网关组件，它的目标是替代Netflix Zuul，它提供路由、安全、监控/埋点和限流等。

核心概念：

* `Route`
    - 网关的基础元素，由ID、URI、断言、过滤器组成。当请求到达网关时，若断言为真，则匹配到路由
* `Predicate`
    - 断言, 匹配HTTP请求的条件
* `Filter`
    - 过滤器，和Zuul类似，最大的区别就是Gateway的Filter只有`pre`和`post`两种

---

### 内置断言

用于匹配HTTP请求，如果匹配成功，则进行路由转发。

内置断言(`org.springframework.cloud.gateway.handler.predicate.*`)：

* `After`(AfterRoutePredicateFactory)
    - 请求时间在配置的值之后
```
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: https://example.org
        predicates:
        - After=2017-01-20T17:42:47.789-07:00[America/Denver]
```

* `Before`(BeforeRoutePredicateFactory)
    - 请求时间在配置的值之前
```
spring:
  cloud:
    gateway:
      routes:
      - id: before_route
        uri: https://example.org
        predicates:
        - Before=2017-01-20T17:42:47.789-07:00[America/Denver]
```

* `Between`(BetweenRoutePredicateFactory)
    - 请求时间在配置的值之间
```
spring:
  cloud:
    gateway:
      routes:
      - id: between_route
        uri: https://example.org
        predicates:
        - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
```

* `Cookie`(CookieRoutePredicateFactory)
    - 请求携带的Cookie匹配配置的值或正则
```
spring:
  cloud:
    gateway:
      routes:
      - id: cookie_route
        uri: https://example.org
        predicates:
        - Cookie=chocolate, ch.p
```

* `Header`(HeaderRoutePredicateFactory)
    - 请求的Header匹配配置的值或正则
```
spring:
  cloud:
    gateway:
      routes:
      - id: header_route
        uri: https://example.org
        predicates:
        - Header=X-Request-Id, \d+
```

* `Host`(HostRoutePredicateFactory)
    - 请求的Host匹配配置的值或Ant表达式
```
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: https://example.org
        predicates:
        - Host=**.somehost.org,**.anotherhost.org
```

* `Method`(MethodRoutePredicateFactory)
    - 请求的Method匹配配置的值
```
spring:
  cloud:
    gateway:
      routes:
      - id: method_route
        uri: https://example.org
        predicates:
        - Method=GET
```

* `Path`(PathRoutePredicateFactory)
    - 请求地址匹配配置的值或正则
```
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: https://example.org
        predicates:
        - Path=/foo/{segment},/bar/{segment}
```

* `Query`(QueryRoutePredicateFactory)
    - 请求的查询参数匹配配置的值或正则
```
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: https://example.org
        predicates:
        - Query=foo, ba.
```

* `RemoteAddr`(RemoteAddrRoutePredicateFactory)
    - 请求的远程地址匹配配置的值
```
spring:
  cloud:
    gateway:
      routes:
      - id: remoteaddr_route
        uri: https://example.org
        predicates:
        - RemoteAddr=192.168.1.1/24
```

---

### 内置过滤器

可以改变HTTP请求的入参和HTTP响应的结果。

内置过滤器(`org.springframework.cloud.gateway.filter.factory.*`)：

* `AddRequestHeader`(AddRequestHeaderGatewayFilterFactory)
    - 添加请求头(AddRequestHeader=Key, Value)
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: https://example.org
        predicates:
        - Path=/foo/{segment}
        filters:
        - AddRequestHeader=X-Request-Foo, Bar-{segment}
```

* `AddRequestParameter`(XXXXXXXXX)
    - 添加请求参数(AddRequestParameter=Key, Value)
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_parameter_route
        uri: https://example.org
        filters:
        - AddRequestParameter=foo, bar
```

* `AddResponseHeader`(XXXXXXXXX)
    - 添加响应头
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_response_header_route
        uri: https://example.org
        predicates:
        - Host: {segment}.myhost.org
        filters:
        - AddResponseHeader=foo, bar-{segment}
```

* `PrefixPath`(XXXXXXXXX)
    - 路由转发请求时，自动加上PrefixPath的值进行转发
```
spring:
  cloud:
    gateway:
      routes:
      - id: prefixpath_route
        uri: https://example.org
        filters:
        - PrefixPath=/mypath
```

* `RewritePath`(XXXXXXXXX)
    - 重写请求路径，如下配置/foo/bar的请求会转发到/bar
```
spring:
  cloud:
    gateway:
      routes:
      - id: rewritepath_route
        uri: https://example.org
        predicates:
        - Path=/foo/**
        filters:
        - RewritePath=/foo/(?<segment>.*), /$\{segment}
```

* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```
* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```
* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```
* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```
* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```
* `XXXXXXXXX`(XXXXXXXXX)
    - XXXXXXXXX
```
YYYYYYYYYYYYYYYYYYYYYYYY
```

---

##### 单实例运行

参考springcloud-eureka-server项目启动服务注册中心集群。

参考springcloud-eureka-client-provider项目启动服务提供者集群。

启动服务消费者`ZuulApplication.main()`访问 http://localhost:8888/provider/sayHi