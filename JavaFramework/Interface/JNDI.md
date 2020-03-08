# JNDI - Java Naming and Directory Interface（JAVA命名和目录接口）
```md
JNDI 提出的目的是为了解藕，是为了开发更加easy维护，easy扩展。easy部署的应用。 
JNDI 是一个sun提出的一个规范(相似于jdbc),详细的实现是各个j2ee容器提供商
	sun   仅仅是要求，j2ee容器必须有JNDI这种功能。
JNDI 在j2ee系统中的角色是“交换机”，是J2EE组件在执行时间接地查找其它组件、资源或服务的通用机制。 
JNDI 是通过资源的名字来查找的，资源的名字在整个j2ee应用中(j2ee容器中)是唯一的。 
```
```md
JNDI避免了程序与数据库之间的紧耦合，使应用更加易于配置、易于部署。
```
* Naming
```md
是将Java对象以某个名称的形式绑定（binding）到一个容器环境（Context）中
以后调用容器环境（Context）的查找（lookup）方法又可以查找出某个名称所绑定的Java对象。
```
