[TOC]

# 2-1 创建SpringBoot项目

------

### 一、创建SpringBoot项目

1. 创建项目的时候选择 Spring Initializr

   <img src="https://typora-pic-1304435145.cos.ap-beijing.myqcloud.com/image-20210525150602902.png" alt="image-20210525150602902" style="zoom:50%;" align="left"/>

2. 填写好项目信息

   ![image-20210525145815922](https://typora-pic-1304435145.cos.ap-beijing.myqcloud.com/image-20210525145815922.png)

3. 在依赖库界面，勾选如下内容

   | 序号 | 序号                | 作用              |
   | ---- | ------------------- | ----------------- |
   | 1    | SpringBoot DevTool  | 热部署插件        |
   | 2    | Lombok              | 生成SET/GET方法   |
   | 3    | Spring Web          | SpringMVC框架     |
   | 4    | MySQL Driver        | MySQL数据库驱动   |
   | 5    | MyBatis Framework   | MyBatis持久层框架 |
   | 6    | Spring Data Redis   | 操作Redis技术     |
   | 7    | Spring Data MongoDB | 操作MongoDB技术   |
   | 8    | Spring For RabbitMQ | RabbitMQ驱动      |
   | 9    | Java Mail Sender    | 邮件发送技术      |
   | 10   | QuartZ Scheduler    | 定时器技术        |

4. 填写项目名称及存放路径（上面已经设置好了，无需修改）

   ![image-20210525150658355](https://typora-pic-1304435145.cos.ap-beijing.myqcloud.com/image-20210525150658355.png)

5. 生成的项目结构如下所示

   <img src="https://typora-pic-1304435145.cos.ap-beijing.myqcloud.com/image-20210525150016467.png" alt="image-20210525150016467"  />

6. 把`application.properties`文件修改成`application.yml`

### 二、配置Tomcat

```yaml
server:
  tomcat:
    uri-encoding: UTF-8
    threads:
      max: 200
      min-spare: 30
    connection-timeout: 5000ms
  port: 8080
  servlet:
    context-path: /emos-wx-api
```

### 三、配置MySQL数据源

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      driver-class-name: com.mysql.jdbc.Driver
      url: jdbc:mysql://localhost:3306/emos?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
      username: root
      password: abc123456
      initial-size: 8
      max-active: 16
      min-idle: 8
      max-wait: 60000
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
```

因为使用了阿里巴巴的Druid连接池，所以要在pom.xml文件中添加依赖，然后让Maven执行reload，依赖库就下载好了。

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.13</version>
</dependency>
```

### 四、配置Redis数据源

```yaml
spring:
  #这里省略MySQL配置信息
  redis:
    database: 0
    host: localhost
    port: 6379
    jedis:
      pool:
        max-active: 1000
        max-wait: -1ms
        max-idle: 16
        min-idle: 8
```

### 五、配置MongoDB数据源

```yaml
spring:
  #这里省略MySQL配置信息
  #这里省略Redis配置信息
  data:
    mongodb:
      host: localhost
      port: 27017
      database: emos
      authentication-database: admin
      username: admin
      password: abc123456
```

### 六、运行项目，检测配置

找到EmosWxApiApplication类，运行主方法，启动SpringBoot项目，然后观察控制台的输出，如果没有异常消息，说明以上的这些配置完全正确。如果出现了异常信息，需要你检查数据库是否都启动了，而且依赖库是否加载了，最后还要核对一下yml文件中的配置信息。