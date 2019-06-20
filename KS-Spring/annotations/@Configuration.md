# @Configuration

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Configuration {
	/**
	 * Explicitly specify the name of the Spring bean definition associated
	 * with this Configuration class. If left unspecified (the common case),
	 * a bean name will be automatically generated.
	 * <p>The custom name applies only if the Configuration class is picked up via
	 * component scanning or supplied directly to a {@link AnnotationConfigApplicationContext}.
	 * If the Configuration class is registered as a traditional XML bean definition,
	 * the name/id of the bean element will take precedence.
	 * @return the suggested component name, if any (or empty String otherwise)
	 * @see org.springframework.beans.factory.support.DefaultBeanNameGenerator
	 */
	String value() default "";
}

```
```md
从Spring3.0，@Configuration 用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
这些方法将会被 AnnotationConfigApplicationContext 或 AnnotationConfigWebApplicationContext 类进行扫描，
并用于构建bean定义，初始化Spring容器。
```
```md
注意：@Configuration注解的配置类有如下要求：
1. 不可以是final类型；
2. 不可以是匿名类；
2. 嵌套的Configuration必须是静态类。
```
```md
@Configuration 注释的类 类似于于一个 xml 配置文件的存在(针对于 ClassXmlPathApplicationContext 来说)。
不过它是由 AnnotationConfigApplicationContext 类进行解析并注册到Bean的注册表中。
```


## [Spring @Configuration 注解介绍](https://www.jianshu.com/p/721c76c1529c)