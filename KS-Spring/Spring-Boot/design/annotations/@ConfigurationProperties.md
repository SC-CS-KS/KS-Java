# @ConfigurationProperties
```md
当我们先获取application.xml中几个值的时候用@Value比较方便，
但是如果一些配置频繁使用，或者有关联关系，把他们放在一块更好的时候，可以用@ConfigurationProperties注解，直接将配置项映射为对象
```
```md
假如配置文件如下所示
connection.username=admin
connection.password=admin
```
```java
定义实体类，装载属性

@Component
@ConfigurationProperties(prefix="connection")
public class ConnectionConfig {
    private String username;
    private String password ;
    // getter & setter
}
```
```md
还可以把 @ConfigurationProperties 还可以直接定义在@bean的注解上，
这时 bean实体类就不用@Component和@ConfigurationProperties了。
```
```java
@SpringBootApplication
public class ShowApplication{

    @Bean
    @ConfigurationProperties(prefix = "connection")
    public ConnectionSettings connectionSettings(){
        return new ConnectionSettings();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
```java
需要使用的时候，直接 @Autowired 注入即可

@Service
public class ShowService {
    @Autowired 
    ConnectionSettings conn;
}
```
```md
yaml文件和properties文件都支持。
```