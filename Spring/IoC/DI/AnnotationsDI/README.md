# 注解注入

Spring和注入相关的常见注解有Autowired、Resource、Qualifier、Service、Controller、Repository、Component

Spring对于Bean的依赖注入，支持多种注解方式
```java
@Resource
javax.annotation 
JSR250 (Common Annotations for Java) 
@Inject
javax.inject 
JSR330 (Dependency Injection for Java) 
@Autowired
org.springframework.bean.factory 
Spring
```
@Autowired是Spring提供的注解，其他几个都是JDK本身内建的注解，Spring对这些注解也进行了支持。

## 开启 annotation-config

```xml
<beans xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:context="http://www.springframework.org/schema/context"  
    xsi:schemaLocation=" http://www.springframework.org/schema/beans  
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd  
       http://www.springframework.org/schema/context  
       http://www.springframework.org/schema/context/spring-context-3.0.xsd">  
  
    <context:annotation-config/>  
  
</beans> 
```

## 实例化的注解列表

### [@Component](@Component.md)
Component是一种泛指，标记类是组件，Spring扫描注解配置时，会标记这些类要生成bean。

### @Service
在servie层中使用

@Service注解是@Component的一个延伸（特例），它用于标注业务逻辑类。
与@Component注解一样，被此注解标注的类，会自动被Spring所管理。

### @Repository
在dao层中使用

@Repository注解也是@Component注解的延伸，与@Component注解一样，
被此注解标注的类会被 Spring 自动管理起来，@Repository注解用于标注DAO层的数据持久化类。

### @Controller：标记Controller层

## 注入的注解的标签

### @Autowired
Autowired是自动注入，自动从spring的上下文找到合适的bean来注入。

@Qualifier和Autowired配合使用，指定bean的名称。

### @Resource（name=""）
Resource用来指定名称注入。没有name时和Autowired一样，但是他可以根据名称进行装配。

## 装配标签

```xml
<context:compoent-scan pack-name="">
```

## 设置类装配的范围

### @Scope（）

