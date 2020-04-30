# [JMX （Java Management Extensions）](https://www.zhihu.com/question/36688387)

即Java管理扩展，是一个为应用程序植入管理功能的框架。  
JMX是一套标准的代理和服务，实际上，用户可以在任何Java应用程序中使用这些代理和服务实现管理。  

![](_pic/JMX-Arch.png)

* 基础层：主要是 Mbean，被管理的java bean  
* * Mbean  
```text
standard MBean
dynamic MBean
model MBean
```

* 适配层： MbeanServer，提供对资源的注册和管理
* 接入层： 提供远程访问的入口

## Model
* Notification

Notification 起到了在 MBean 之间沟通桥梁的作用  

## Utilities

中间件软件 WebLogic 的管理页面就是基于JMX开发的，而 JBoss 则整个系统都基于JMX。  
