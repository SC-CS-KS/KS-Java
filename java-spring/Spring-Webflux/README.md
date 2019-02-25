# Spring Webflux
```md
Spring 5 中最重要改动是把反应式编程的思想应用到了框架的各个方面，Spring 5 的反应式编程以 Reactor 库为基础。

在服务器端，WebFlux 支持两种不同的编程模型：
第一种是 Spring MVC 中使用的基于 Java 注解的方式；
第二种是基于 Java 8 的 lambda 表达式的函数式编程模型。
这两种编程模型只是在代码编写方式上存在不同。它们运行在同样的反应式底层架构之上，因此在运行时是相同的。

WebFlux 需要底层提供运行时的支持，
WebFlux 可以运行在支持 Servlet 3.1 非阻塞 IO API 的 Servlet 容器上，或是其他异步运行时环境，如 Netty 和 Undertow。
```