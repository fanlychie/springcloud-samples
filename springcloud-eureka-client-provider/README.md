##### 单实例运行

启动`EurekaServerApplication.main()`访问 http://localhost:9000/

---

##### 集群

执行打包命令

```shell
mvn clean -U -e package
```

到`target`目录下执行启动多个实例的命令：

```shell
java -jar springcloud-eureka-client-provider-0.0.1-SNAPSHOT.jar --spring.profiles.active=replica1
```

```shell
java -jar springcloud-eureka-client-provider-0.0.1-SNAPSHOT.jar --spring.profiles.active=replica2
```

访问 http://my-eureka-server.gz.com:9001/

访问 http://my-eureka-server.sz.com:9002/

访问 http://my-eureka-server.zh.com:9003/