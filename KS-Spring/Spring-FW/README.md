# [Spring Framework](https://spring.io/projects/spring-framework)
```md
Spring Framework 为现代基于 Java的企业应用程序提供了全面的编程和配置模型 - 在任何类型的部署平台上。
Spring的一个关键要素是应用程序级别的基础架构支持：
Spring专注于企业应用程序的“管道”，以便团队可以专注于应用程序级业务逻辑，而无需与特定部署环境建立不必要的联系。
```
## Features
```md
核心技术：依赖注入，事件，资源，i18n，验证，数据绑定，类型转换，SpEL，AOP。
测试：模拟对象，TestContext框架，Spring MVC测试，WebTestClient。
数据访问：事务，DAO支持，JDBC，ORM，编组XML。
Spring MVC 和 Spring WebFlux Web 框架。
集成：远程处理，JMS，JCA，JMX，电子邮件，任务，调度，缓存。
语言：Kotlin，Groovy，动态语言。
```
## 架构
![](z_pic/spring4-framework-runtime.png)

### Core
* [Spring-Core - 依赖注入 IoC 与 DI 的最基本实现](Spring-Core/README.md)
* [Spring-Beans - Bean 工厂与 bean的装配](Spring-Beans/README.md)
* [Spring-Context - Spring的 上下文即 IoC容器](Spring-Context/README.md)
* Spring-Expression - Spring 表达式语言

### AOP
* Spring-AOP - 面向切面编程
* Spring-Aspects - 集成AspectJ
* Spring-Instrument - 提供一些类级的工具支持和ClassLoader级的实现，用于服务器
* Spring-Instrument-Tomcat - 针对 Tomcat的 Instrument实现

### Data Access
* Spring-JDBC
* Spring-TX - 事物控制
* Spring-ORM - 对象关系映射，集成orm框架
* Spring-OXM - 对象xml映射
* Spring-JMS - Java消息服务

### Web
* Spring-Web - 基础Web功能，如文件上传
* Spring-WebMVC - MVC实现
* Spring-WebMVC-Portlet - 基于 portlet的 MVC实现
* Spring-Struts - 与struts的集成，不推荐，spring4不再提供

### Test
* Spring-Test - 提供 junit与 mock测试功能

### Support
* Spring-Context-Support - 额外支持包，比如邮件服务、视图解析等

##
* [Spring MVC](Spring-MVC/README.md)
* [Spring Webflux](Spring-Webflux/README.md)

