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
定义多个不同的profiles，不同的profiles之间用---（只适合yml配置文件）进行分割，在spring容器启动时，使用spring.profiles.active来指定激活那个profiles。
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