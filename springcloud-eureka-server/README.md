##### Host 配置

打开文件目录，地址栏输入：`%SystemRoot%\system32\drivers\etc`并回车

在文件末尾添加如下内容并保存退出：

```html
127.0.0.1	my-eureka-server.com
```

打开`cmd`输入命令：`ipconfig /flushdns`

##### 单实例运行

启动`EurekaServerApplication.main()`访问 http://my-eureka-server.com:9000/

---

##### 集群

执行打包命令

```shell
mvn clean -U -e package
```

到`target`目录下执行启动多个实例的命令：

```shell
java -jar springcloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
```

```shell
java -jar springcloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
```

```shell
java -jar springcloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
```

访问 http://my-eureka-server.com:9001/

访问 http://my-eureka-server.com:9002/

访问 http://my-eureka-server.com:9003/