# SPI（Service Provider Interface）

是Java提供的一套用来被第三方实现或者扩展的API，它可以用来启用框架扩展和替换组件。  
Java SPI 实际上是“基于接口的编程＋策略模式＋配置文件”组合实现的动态加载机制。  

## 场景

调用者根据实际使用需要，启用、扩展、或者替换框架的实现策略

```text
1. 数据库驱动加载接口实现类的加载
2. JDBC加载不同类型数据库的驱动
3. 日志门面接口实现类加载
3. SLF4J加载不同提供商的日志实现类
4. Spring
  Spring 中大量使用了SPI
  比如：对servlet3.0规范对ServletContainerInitializer的实现、
  自动类型转换Type Conversion SPI(Converter SPI、Formatter SPI)等。
5. Dubbo
  Dubbo中也大量使用SPI的方式实现框架的扩展, 
  不过它对Java提供的原生SPI做了封装，允许用户扩展实现Filter接口。
```

## 优点：

使用Java SPI机制的优势是实现解耦，
使得第三方服务模块的装配控制的逻辑与调用者的业务代码分离，而不是耦合在一起。
应用程序可以根据实际业务情况启用框架扩展或替换框架组件。

## 缺点：

虽然ServiceLoader也算是使用的延迟加载，但是基本只能通过遍历全部获取，也就是接口的实现类全部加载并实例化一遍。
如果你并不想用某些实现类，它也被加载并实例化了，这就造成了浪费。
获取某个实现类的方式不够灵活，只能通过Iterator形式获取，不能根据某个参数来获取对应的实现类。
多个并发多线程使用ServiceLoader类的实例是不安全的。
