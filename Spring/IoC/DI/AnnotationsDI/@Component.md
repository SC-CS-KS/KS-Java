# @Component

@Component注解用于标注一个普通的组件类，
它没有明确的业务范围，只是通知Spring被此注解的类需要被纳入到Spring Bean容器中并进行管理。

@Component 和 @Bean 目的是一样的，都是注册 bean到 Spring容器中。
@Component（@Controller、@Service、@Repository）通常是通过类路径扫描来自动侦测以及自动装配到Spring容器中。

```java
@Controller
//在这里用Component，Controller，Service，Repository都可以起到相同的作用。
@RequestMapping(″/web/controller1″)
public class WebController {
    .....
}
```