# Java 类库

## 核心类库
### 核心
* java.lang 
* java.util
* java.io

### 应用类库
* java.applet - 含有控制 HTML 文档格式、应用程序中的声音等资源的类
* java.net - 含有与网络操作相关的类，如 TCP Scokets、URL 等工具。
* java.swing & java.awt - 提供了创建图形用户界面元素的类
* java.beans - 定义了应用程序编程接口（API），封装业务逻辑的组件，可以实现业务组件的重用。
* java.math 
* java.nio
* java.sql
* java.rmi
* java.security
* java.text - 提供以与自然语言无关的方式来处理文本、日期、数字和消息的类和接口

## 扩展类库
### Javax
```md
java和javax都是Java的API(Application Programming Interface)包，java是核心包。
javax的x是extension的意思，也就是扩展包
```
```md
javax.accessibility
javax.activation
javax.activity
javax.annotation
javax.crypto
javax.imageio
javax.jws
	A package of the Java Image I/O API dealing with low-level I/O from files and streams.
	javax.jws.soap
javax.lang
	javax.lang.model
javax.management
	Provides the core classes for the Java Management Extensions.
javax.naming
	Provides the classes and interfaces for accessing naming services.
javax.net
	Provides classes for networking applications.
javax.print
	Provides the principal classes and interfaces for the JavaTM Print Service API.
javax.rmi
	Contains user APIs for RMI-IIOP.
javax.script
	The scripting API consists of interfaces and classes that define Java TM Scripting Engines and provides a framework for their use in Java applications.
javax.security
	javax.security.auth
javax.sound
	javax.sound.midi
		Provides interfaces and classes for I/O, sequencing, and synthesis of MIDI (Musical Instrument Digital Interface) data.
javax.sql
javax.swing
javax.tools
javax.transaction
javax.xml
java.time
	The main API for dates, times, instants, and durations.
	Java 8 吸收了 Joda-Time 的精华，以一个新的开始为 Java 创建优秀的 API
```
### Org
```md
由企业或者组织提供的java类库，集成到JDK中但大部分不是sun公司的，可以直接使用。
其中比较常用的是w3c提供的对XML、网页、服务器的类和接口。
```
* org.ietf.jgss
* org.omg
* org.w3c.dom
* org.xml.sax

## 非JDK集成
### SerDe
* Json

### Util
* [Google Guava]()
* Apache Commons

### Log
* java.util.logging (JUL)
* Log4j
* Logback
* common-logging
* slf4j

### Config
* com.typesafe.config

### Cli
* sun.misc.Signal - 信号处理
* [JLine - 是一个用来处理控制台输入的Java类库](https://jline.github.io/)
* Apache.Commons.CLI - Java中命令行参数解析

## 参考
* [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/)