# Spring Boot
```md
Spring 和 SpringMVC 的问题在于需要配置大量的参数。Spring Boot 通过一个自动配置和启动的项来目解决这个问题。
Spring Boot使编码、配置、部署、监控变简单。
```
```md
简化了基于Spring的应用开发，通过少量的代码就能创建一个独立的、产品级别的Spring应用，
它可以让你尽可能快的运行起Spring程序。

Spring Boot就是一个内嵌Web服务器（tomcat/jetty）的可执行程序的框架，
你开发的web应用不需要作为war包部署到web服务器中，而是作为一个可执行程序，启动时把Web服务器配置好，加载起来。

Spring Boot其实不是什么新的框架，它默认配置了很多框架的使用方式。
```
## 核心思想
```md
约定大于配置，一切自动完成。
```
## 主要特性
```md
1. 遵循“习惯优于配置”的原则，使用Spring Boot只需要很少的配置，大部分的时候我们直接使用默认的配置即可；
2. 项目快速搭建，可以无需配置的自动整合第三方的框架；
3. 内嵌 Servlet 容器，降低了对环境的要求，可以使用命令直接执行项目，应用可用jar包执行：java -jar；
4. 提供了starter POM, 能够非常方便的进行包管理, 很大程度上减少了jar hell或者dependency hell；
5. 运行中应用状态的监控；
6. 对主流开发框架的无配置集成；
7. 与云计算的天然继承；
```
## 核心功能
```md
1. 独立运行的Spring项目
2. 内嵌的Servlet容器
3. 提供starter简化Manen配置
4. 自动配置Spring
5. 应用监控
    Spring Boot提供了基于http、ssh、telnet对运行时的项目进行监控。
6. 无代码生成和XML配置
```
## 优点
```md
Spring Boot继承了Spring的优点，并新增了一些新功能和特性：
1. 从字面理解，Boot是引导的意思，因此SpringBoot帮助开发者快速搭建Spring框架；
2. SpringBoot帮助开发者快速启动一个Web容器；
3. SpringBoot继承了原有Spring框架的优秀基因；
4. SpringBoot简化了使用Spring的过程；
5. Spring Boot为我们带来了脚本语言开发的效率，但是Spring Boot并没有让我们意外的新技术，都是Java EE开发者常见的技术。
```
## 微服务构建框架
```md
Spring Boot比较适合微服务部署方式。
不再是把一堆应用放到一个Web服务器下，重启Web服务器会影响到其他应用，
而是每个应用独立使用一个Web服务器，重启动和更新都很容易。
```
* 讲到 Spring Boot，它离微服务还差些什么？
```md
它其实就是一个构建微服务的框架，在这个基础上面没有注册发现，也没有授权等。
也不能通过这个把所有的应用监控起来，配置还是跟应用关联在一起。
```
### 与 DropWizard
* Spring的依赖
```md
Spring Boot聚焦于Spring应用，如果你希望进入Spring生态环境，或者已经熟悉它，希望有一个快速起步，那么选择它是好的选择。
DropWizard 是将其REST和Jersey结合在一起，它帮助你离开对Spring的依赖。
```
* Http服务器
```md
我们看到Spring Boot更加灵活，
DropWizard以约定优于配置，比Spring Boot更极端点，完全是基于Jetty，
而Spring Boot默认使用嵌入的Tomcat，其他也可以选择。
```
* 日志
```md
DropWizard 从log4j切换到LogBack
Spring boot提供 Logback, log4j 和 log4j2选择，LogBack是一个更好的Log4j，性能要比log4j提高
不过要注意不同的方法使用性能不同。
```
* 依赖注入
```md
两个框架主要区别是依赖注入的不同
Spring核心有依赖注入，而DropWizard需要你选择这带来了灵活性，有 Google Guice 或更新更好的依赖注入框架可供选择。
```
* 总结
```md
最后，两者都有很强很大的社区支持
如果你更喜欢轻量，无疑DropWizard胜出
如果你已经有Spring经验，无疑使用Spring Boot。
```
