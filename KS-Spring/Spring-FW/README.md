# [Spring Framework](https://spring.io/projects/spring-framework)
```md
Spring Framework 为现代基于 Java的企业应用程序提供了全面的编程和配置模型 - 在任何类型的部署平台上。
Spring的一个关键要素是应用程序级别的基础架构支持：
Spring专注于企业应用程序的“管道”，以便团队可以专注于应用程序级业务逻辑，而无需与特定部署环境建立不必要的联系。
```

## 架构
![](z_pic/spring4-framework-runtime.png)
```md
Data Access/Integration层包含有JDBC、ORM、OXM、JMS和Transaction模块。
Web层包含了Web、Web-Servlet、WebSocket、Web-Porlet模块。
AOP模块提供了一个符合AOP联盟标准的面向切面编程的实现。
Core Container(核心容器)：包含有Beans、Core、Context和SpEL模块。
Test模块支持使用JUnit和TestNG对Spring组件进行测试。
```

### Core
* [Spring-Core - 依赖注入 IoC 与 DI 的最基本实现](Spring-Core/README.md)
* [Spring-Beans - Bean 工厂与 bean的装配](Spring-Beans/README.md)
* [Spring-Context - Spring的 上下文即 IoC容器](Spring-Context/README.md)
* Spring-Expression - Spring 表达式语言

### AOP
* [Spring-AOP - 面向切面编程](AOP/Spring-AOP/README.md)
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
* [Spring-WebMVC - MVC实现](Spring-WebMVC/README.md)
* Spring-WebMVC-Portlet - 基于 portlet 的 MVC实现
* Spring-Struts - 与struts的集成，不推荐，spring4不再提供

### Test
* Spring-Test - 提供 junit与 mock测试功能

### Support
* Spring-Context-Support - 额外服务支持包，比如邮件服务、视图解析等

