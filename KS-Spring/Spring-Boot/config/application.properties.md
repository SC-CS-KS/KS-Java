# application.properties
```md
src/main/java/resources/application.properties
```
## 自定义属性
```md
com.zzq.name="张小凡"
com.zzq.title="vip"
```
```md
通过注解@Value(value=”${config.name}”)就可以绑定到你想要的属性上面
```
```java
@RestController
public class UserController {

    @Value("${com.zzq.name}")
    private  String name;
    @Value("${com.zzq.title}")
    private  String title;

    @RequestMapping("/")
    public String hexo(){
        return name+","+title;
    }
}
```
* 绑定一个对象的bean
```java
@ConfigurationProperties(prefix = "com.zzq")
public class ConfigBean {
    private String name;
    private String title;
    // 省略getter和setter
}
```
## 参数间引用
```md
com.zzq.name="张小凡"
com.zzq.title="vip"
com.zzq.hello=${com.zzq.name}的title${com.zzq.title}
```
## 使用自定义配置文件
```md
有时候我们不希望把所有配置都放在application.properties里面，这时候我们可以另外定义一个，
这里我们取名为test.properties,路径跟也放在src/main/resources下面。 
```
```java
@Configuration
@ConfigurationProperties(prefix = "com.zzq") 
@PropertySource("classpath:test.properties")
public class ConfigTestBean {
    private String name;
    private String title;
    // 省略getter和setter
}
```
## 随机值配置
```md
配置文件中${random} 可以用来生成各种不同类型的随机值，从而简化了代码生成的麻烦，例如 生成 int 值、long 值或者 string 字符串。
```
```java
zzq.secret=${random.value}
zzq.number=${random.int}
zzq.bignumber=${random.long}
zzq.uuid=${random.uuid}
zzq.number.less.than.ten=${random.int(10)}
zzq.number.in.range=${random.int[1024,65536]}
```
## 外部配置-命令行参数配置
```md
Spring Boot是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：
java -jar xx.jar

可以以下命令修改tomcat端口号：
java -jar xx.jar --server.port=9090
```
```md
命令行中连续的两个减号–就是对application.properties中的属性值进行赋值的标识。 
所以java -jar xx.jar –server.port=9090等价于在application.properties中添加属性server.port=9090。 
如果你怕命令行有风险，可以使用SpringApplication.setAddCommandLineProperties(false)禁用它。
```
## 不同配置方式的优先级
```md
Spring Boot应用程序有多种设置途径，Spring Boot能从多重属性源获得属性
```
```md
根目录下的开发工具全局设置属性(当开发工具激活时为~/.spring-boot-devtools.properties)。
测试中的@TestPropertySource注解。
测试中的@SpringBootTest#properties注解特性。
命令行参数
SPRING_APPLICATION_JSON中的属性(环境变量或系统属性中的内联JSON嵌入)。
ServletConfig初始化参数。
ServletContext初始化参数。
java:comp/env里的JNDI属性
JVM系统属性
操作系统环境变量
随机生成的带random.* 前缀的属性（在设置其他属性时，可以应用他们，比如${random.long}）
应用程序以外的application.properties或者appliaction.yml文件
打包在应用程序内的application.properties或者appliaction.yml文件
通过@PropertySource标注的属性源
默认属性(通过SpringApplication.setDefaultProperties指定).
```
```md
这里列表按组优先级排序，也就是说，任何在高优先级属性源里设置的属性都会覆盖低优先级的相同属性，
例如我们上面提到的命令行属性就覆盖了application.properties的属性。
```
## 配置文件的优先级
```md
application.properties和application.yml文件可以放在以下四个位置：

外置，在相对于应用程序运行目录的/congfig子目录里。 
外置，在应用程序运行的目录里 
内置，在config包内 
内置，在Classpath根目录 
```
```md
同样，这个列表按照优先级排序，也就是说，src/main/resources/config下application.properties
覆盖src/main/resources下application.properties中相同的属性
```
```md
此外，如果你在相同优先级位置同时有application.properties和application.yml，
那么application.properties里的属性里面的属性就会覆盖application.yml。
```
## 引入多个xml配置
```md
SpringBoot提倡零配置，即无xml配置，但是在实际项目中，可能有一些特殊要求你必须使用XML配置，这时我们可以通过Spring提供的@ImportResource来加载xml配置。
```
```java
@ImportResource({"classpath:some-context.xml","classpath:another-context.xml"})
```
## 多环境配置
```md
当应用程序需要部署到不同运行环境时，一些配置细节通常会有所不同，
最简单的比如日志，生产日志会将日志级别设置为WARN或更高级别，并将日志写入日志文件，而开发的时候需要日志级别为DEBUG，日志输出到控制台即可。
```
```md
如果按照以前的做法，就是每次发布的时候替换掉配置文件，这样太麻烦了，Spring Boot的Profile就给我们提供了解决方案，命令带上参数就搞定。
```
* 命令带参数的方式
```md
在Spring Boot中多环境配置文件名需要满足application-{profile}.properties的格式，其中{profile}对应你的环境标识，比如：

application-dev.properties：开发环境
application-prod.properties：生产环境
```
```md
想要使用对应的环境，只需要在application.properties中使用spring.profiles.active属性来设置，
值对应上面提到的{profile}，这里就是指dev、prod这2个。

当然你也可以用命令行启动的时候带上参数：
java -jar xxx.jar --spring.profiles.active=dev
```
```md
我给不同的环境添加不同的数据库连接spring.data.mongodb.uri，然后根据指定不同的spring.profiles.active来切换使用。
```
```md
多环境配置的坑 
需要注意的的是 多环节配置时需要注意，如果默认的application.properties中有与其他环境配置环境中一样的变量，则会覆盖生效。 
```
```md
所以 application.properties最好只用来记录共同的属性或者用于指定默认环境
spring.profiles.active=dev
```
* @Profile注解的方式
```md
除了可以用profile的配置文件来分区配置我们的环境变量，在代码里，我们还可以直接用@Profile注解来进行配置
```
```java
public  interface DBConnector { public  void  configure(); }
分别定义俩个实现类来实现它
/**
  * 开发环境数据库
  */
@Component
@Profile("devdb")
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("devdb");
    }
}
/**
 * 生产数据库
 */
@Component
@Profile("proddb")
public class ProdDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("proddb");
    }
}
```
```md
通过在配置文件激活具体使用哪个实现类
spring.profiles.active=devdb
```
```md
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired DBConnector connector ;

    @RequestMapping(value = {"/",""})
    public String hellTask(){

        connector.configure(); //最终打印devdb     
        return "oK";
    }
}
```
```md
除了spring.profiles.active来激活一个或者多个profile之外，还可以用spring.profiles.include来叠加profile

spring.profiles.active: devdb  
spring.profiles.include: proddb,prodmq
```
## 修改端口
```md
在application.properties中添加
server.port=8011
可将tomcat默认端口号修改为8011
```
```md
如果是application.yml 
则使用属性:
server:
  port: 8888
```
## 常用配置
```md
server.port=9090 # 服务端口号
server.tomcat.uri-encoding=UTF-8 #以Tomcat为web容器时的字符编码
spring.data.mongodb.uri=mongodb://localhost:27017/mydb #mongodb连接

spring.application.name=customer # 应用名称，一般就是项目名称，这个名称在SpringCloud中比较关键
spring.profiles.active=dev #指定当前的活动配置文件，主要用于多环境多配置文件的应用中
spring.http.encoding.charset=UTF-8 #http请求的字符编码
spring.http.multipart.max-file-size=10MB #设置文件上传时单个文件的大小限制
spring.http.multipart.max-request-size=100MB #设置文件上传时总文件大小限制

spring.thymeleaf.prefix=classpath:/templates/ #配置在使用Thymeleaf做页面模板时的前缀，即页面所在路径
spring.thymeleaf.suffix=.html #设置在使用Thymeleaf做页面模板时的后缀
spring.thymeleaf.cache=false #设置在使用Thymeleaf做页面模板时是否启用缓存

spring.mvc.static-path-pattern=/** #设置静态资源的请求路径
spring.resources.static-locations=classpath:/static/,classpath:/public/ #指定静态资源的路径

##以下是使用MySQL数据库的配置
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect #指定数据库方言
hibernate.show_sql=true #是否显示sql语句
hibernate.hbm2dll.auto=update #设置使用Hibernate的自动建表方式
entitymanager.packagesToScan=com.zslin #设置自动扫描的包前缀

spring.datasource.url=jdbc:mysql://localhost:3306/customer?\
useUnicode=true&characterEncoding=utf-8&useSSL=true&autoReconnect=true #数据库链接
spring.datasource.username=root #数据库用户名
spring.datasource.password=123 #数据库用户对应的密码
spring.datasource.driver-class-name=com.mysql.jdbc.Driver #数据库驱动名称
```