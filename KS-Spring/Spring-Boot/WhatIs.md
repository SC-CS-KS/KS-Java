# Spring Boot
```md
Spring 和 SpringMVC 的问题在于需要配置大量的参数。
Spring Boot 通过一个自动配置和启动的项来目解决这个问题。
```
* 解决的问题
```md
(1) Spring Boot使编码变简单
(2) Spring Boot使配置变简单
(3) Spring Boot使部署变简单
(4) Spring Boot使监控变简单
```
* 优点
```md
Spring Boot继承了Spring的优点，并新增了一些新功能和特性：
1. 从字面理解，Boot是引导的意思，因此SpringBoot帮助开发者快速搭建Spring框架；
2. SpringBoot帮助开发者快速启动一个Web容器；
3. SpringBoot继承了原有Spring框架的优秀基因；
4. SpringBoot简化了使用Spring的过程；
5. Spring Boot为我们带来了脚本语言开发的效率，但是Spring Boot并没有让我们意外的新技术，都是Java EE开发者常见的技术。
```
* 主要特性
```md
1. 遵循“习惯优于配置”的原则，使用Spring Boot只需要很少的配置，大部分的时候我们直接使用默认的配置即可；
2. 项目快速搭建，可以无需配置的自动整合第三方的框架；
3. 内嵌 Servlet 容器，降低了对环境的要求，可以使用命令直接执行项目，应用可用jar包执行：java -jar；
4. 提供了starter POM, 能够非常方便的进行包管理, 很大程度上减少了jar hell或者dependency hell；
5. 运行中应用状态的监控；
6. 对主流开发框架的无配置集成；
7. 与云计算的天然继承；
```
* 核心功能
```md
1. 独立运行的Spring项目
2. 内嵌的Servlet容器
3. 提供starter简化Manen配置
4. 自动配置Spring
5. 应用监控
    Spring Boot提供了基于http、ssh、telnet对运行时的项目进行监控。
6. 无代码生成和XML配置
```