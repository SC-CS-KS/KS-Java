# JSR-330 / Dependency Injection for Java
```md
JSR-299（Contexts and Dependency Injection for Java EE platform）在依赖注入上也使用该规范。
JSR-330 规范并未按 JSR 惯例发布规范文档，只发布了规范 API 源码。

JSR-330注释的最终规范于2009年10月13日发布。
```

## [javax.inject](https://github.com/javax-inject/javax-inject)
```xml
<dependency>
	<groupId>javax.inject</groupId>
	<artifactId>javax.inject</artifactId>
	<version>1</version>
</dependency>
```
```md
该依赖定义了DI必须实现的基础注解，这也就是JSR-330规范的标准接口协议。
JSR330只规定了依赖注入的描述，对于容器实现未作要求。
Spring 、Guice 、Dagger这三大DI框架都兼容该协议。
```
### Annotation Types Summary
* Inject	Identifies injectable constructors, methods, and fields.
```md
标记为“可注入”，相当于Spring里面的AutoWired。
```
* Named	String-based qualifier.
```md
基于 String 的限定器，也就是名称限定器。
```
* Qualifier	Identifies qualifier annotations.
```md
限定器，用于分门别类，最常用的是名称限定器。
```
* Scope	Identifies scope annotations.
```md
标记作用域，最常用的就是单例作用域，扩展里面还有请求作用域、会话作用域等，这不是必须的。
```
* Singleton	Identifies a type that the injector only instantiates once.
```md
标记为单例，也就是单例作用域。
```

## Resource
* [最简单的Java依赖注入框架 区区200行代码，用于学习再合适不过](https://github.com/pyloque/iockids)