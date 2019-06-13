## <center>spring-boot 操作手册</center>
### 1、spring-boot配置文件
```
spring-boot会按顺序读取以下目录的application.properties
1、项目根目录的config目录
2、项目根目录
3、项目classpath下的config目录
4、项目classpath根目录
```

### 2、指定配置文件位置
```
如果想自己指定配置文件，可以在spring容器的启动命令中加入参数
new SpringApplicationBuilder(Application.class).properties("spring.config.location=classpath:/test-folder/my-config.properties").run(args);
```

### 3、yml文件
```
注意：使用yml配置文件的缩进要使用空格，不要使用tab键进行缩进。
```
### 4、允许时指定profiles配置
```
定义多个不同的profiles，yml的profiles可以用---（只适合yml配置文件）进行分割，properties配置文件需要编写多份区分，（-dev.properties、-test.properties等）在spring容器启动时，使用spring.profiles.active来指定激活那个profiles。
```
### 5、Profiles实现多环境下配置切换
```
创建application-{profile}.properties文件 存放不同环境特有的配置，将于环境无关的属性放置到application.properties文件里面，
并在application.properties文件中通过spring.profiles.active=xxx 指定加载不同环境的配置。
如果不指定，则默认加载application.properties的配置，不会加载带有profile的配置。
server.port=8081
#配置项目启动的时候，决定使用哪个环境，开发(dev)、测试(test)还是产品(prod)环境
spring.profiles.active=dev
创建配置文件：application-dev.properties application-test.properties application-prod.properties
```
### 6、热部署
```
不用每次修改java文件后，都需要重写允许main方法才能生效。
添加依赖
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
</dependency>
坑：我在实际开发中配置之后没有效果，原因是idea默认是没有自动编译的,我们这里需要添加修改配置
1、File-Settings-Compiler-> Build Project automatically  打勾
2、mac：shift+alt+command+/   选择Registry,勾上 Compiler autoMake allow when app running
   windows:ctrl + shift + alt + /
```
### 7、自定义 Filter
```
见  com.hyperchain.filter.WebConfiguration 中的代码
```
### 8、将SpringBoot配置文件中数据加载到实体类中
```
@Configuration
@PropertySource(value=”classpath:application.yml”)
指明了配置文件所处的位置，classpath 下的 application.yml。
@ConfigurationProperties(prefix=”com.springboot”)
注：实体类对应的属性名要与配置文件中的属性保持一致，并且要加上 setter 和 getter 方法。
这样在项目启动的时候，SpringBoot 就会去加载对应配置文件中的属性，反射创建一个 bean 对象，
并放入 Spring 的容器（ConcurrentHashMap）中，在需要使用的地方用 @Autowired 属性注入。
```
### 9、springBoot日志
```
只要在application.properties 中加入logging.level.xxxx=DEBUG就可以了。其中xxxx是你想监听的包路径，logging.level 后面可以根据包路径配置不同资源的 log 级别
logging.path=/Users/lixuanfeng/Desktop/workspace/spring_boot/logs
logging.level.org.springframework.web=INFO
参考博客：https://blog.csdn.net/weixin_41660188/article/details/80113837
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
```
### 10、关闭特定的自动配置
```
我在pom.xml中添加了有关spring-boot-starter-data-jpa依赖，Spring Boot会自动进行JPA相关的配置，如果配置文件中没有相关的配置启动会报错
则可以在spring的启动类的@SpringBootApplication注解上添加exclude参数。
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
```

### 11、自定义Banner
```
在 src/main/resources 下新建一个banner.txt
通过网站：http://patorjk.com/software/taag 网站生成字符，将生成的字符复制到banner.txt中
关闭banner
  关闭banner第一种方法
  SpringApplication application = new SpringApplication(Ch522Application.class);
  application.setBannerMode(Banner.Mode.OFF);//关闭banner
  application.run(args);
  关闭banner第二种方法
  new SpringApplicationBuilder(Ch522Application.class).bannerMode(Banner.Mode.OFF).run(args);
  关闭banner第三种方法在application.properties 文件中配置如下
  spring.main.banner-mode = off
```
### 12、通过jar启动时候指定参数
```
java  -jar  xx.jar  --server.port=9090
```
### 13、基于Docker的部署
```
1、把项目打成jar包传到安装了docker的服务器上。
2、编写Dockerfile文件，与jar包放在同级目录。
FROM java:8
MAINTAINER LXF
ADD spring_boot-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
3、编译镜像
docker build -t wisely/ch10docker .
如果报错：docker报错Get https://registry-1.docker.io/v2/: x509: certificate has expired or is not yet valid
同步时间即可：
yum install -y ntp
ntpdate cn.pool.ntp.org   
推荐几个时间服务器：
          time.nist.gov
          time.nuri.net
          asia.pool.ntp.org
          asia.pool.ntp.org
          asia.pool.ntp.org
          asia.pool.ntp.org
4、查看本地镜像
docker images
5、运行镜像
docker run -d -name ch10  -p 8080:8080 wisely/ch10docker
```
### 14、springBoot jar包部署
```
1、cd 项目跟目录（和pom.xml同级）
mvn clean package
## 或者执行下面的命令
## 排除测试代码后进行打包
mvn clean package  -Dmaven.test.skip=true
2、打包完成后 jar 包会生成到 target 目录下，命名一般是 项目名+版本号.jar
java -jar  target/spring-boot-scheduler-1.0.0.jar   这种方式，只要控制台关闭，服务就不能访问了
nohup java -jar target/spring-boot-scheduler-1.0.0.jar &
java -jar app.jar --spring.profiles.active=dev  启动时选取不同的配置文件
java -Xms10m -Xmx80m -jar app.jar &   设置jvm参数
```
### 15、springBoot war包部署
```
1、maven 项目，修改 pom 包
<packaging>war</packaging>
2、打包时排除tomcat
dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
3、注册启动类
创建 ServletInitializer.java，继承 SpringBootServletInitializer ，覆盖 configure()，把启动类 Application 注册进去。
外部 Web 应用服务器构建 Web Application Context 的时候，会把启动类添加进去。
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
4、打包
mvn clean package  -Dmaven.test.skip=true
5、放到tomcat的webapp中运行即可。
```
### 16、查看JVM参数值
```
jinfo -flags pid(进程号)
-XX:CICompilerCount=2  最大的并行编译数
-XX:InitialHeapSize=16777216 指定 JVM 的最大堆内存大小
-XX:MaxHeapSize=257949696    指定 JVM 的初始堆内存大小
-XX:MaxNewSize=85983232 
-XX:MinHeapDeltaBytes=196608 
-XX:NewSize=5570560 
-XX:OldSize=11206656
-XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps
```
### 17、通过./xxx.jar启动项目
```
1、maven,需要包含以下的配置
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <executable>true</executable>
    </configuration>
</plugin>
2、打包 mvn clean package -Dmaven.skip.test=true
3、可以直接./yourapp.jar 来启动
4、注册为服务，做一个软链接指向你的jar包并加入到init.d中，然后用命令来启动。
ln -s /var/yourapp/yourapp.jar /etc/init.d/yourapp
chmod +x /etc/init.d/yourapp
5、stop或者是restart命令去管理你的应用。
/etc/init.d/yourapp start|stop|restart
或者：service yourapp start|stop|restart
```
### 18、springBoot启动完成之后初始化资源
```
1、直接创建一个类继承 CommandLineRunner ，并实现它的 run() 方法。
2、在类中加上注解
       @Component
       @Order(1)  确保初始化的顺序，越小越先执行。
```
### 19、springBoot定时任务
```
1、在启动类上加上@EnableScheduling注解。
2、编写定时任务类，在类上加上@Component注解，在方法上加上定时计划 @Scheduled(cron="*/6 * * * * ?")
```
### 20、favicon（图标）配置
```
1、在配置文件中设置，默认为true
  spring.mvc.favicon.enabled=true
2、
```
### 21、springBoot集成jwt,实现token验证
```
1、参考资料：https://www.jianshu.com/p/e88d3f8151db
```


### 22、springBoot全局异常处理
```
1、创建全局异常处理类：GlobalException 在类上加上注解 @RestControllerAdvice
2、创建具体的需要捕获的异常方法：handleBusinessException(BusinessException be) ,在方法上加入注解。
     @ResponseBody
        @ExceptionHandler(BusinessException.class)
        public BaseResponse handleBusinessException(BusinessException be) {
            logger.warn(be.getMsg());
            BaseResponse fail = BaseResponse.fail(be.getErrorCode(), be.getMsg());
            return fail;
        }   
```


未完待续。。。








### 遇到的坑
```
1、不能自动建数据库表排查原因我在启动类上加了： @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
2、全局异常处理序列化问题：com.fasterxml.jackson.databind.exc.InvalidDefinitionException ， 在BaseResponse 中放入Object对象会出现这个问题。
```