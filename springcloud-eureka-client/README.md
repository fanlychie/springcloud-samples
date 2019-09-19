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
java -jar springcloud-eureka-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=replica1
```

```shell
java -jar springcloud-eureka-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=replica2
```

```shell
java -jar springcloud-eureka-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=replica3
```

访问 http://localhost:9001/

访问 http://localhost:9002/

访问 http://localhost:9003/