# Java 语言特性

* [Java DataType](Java/DataType/README.md)

* [Java Exception](Java/Exception.md)
* [Java Reflect](Java/Reflect.md)

## Java 11
* 支持 Unicode 10.0
* 标准化 TTP Client
* 编译器线程的延迟分配
```md
1. 添加了新的命令-XX:+UseDynamicNumberOfCompilerThreads动态控制编译器线程的数量
```
* 新的垃圾收集器 — ZGC （一种可伸缩的低延迟垃圾收集器(实验性)）
* Epsilon - 一款新的实验性无操作垃圾收集器
```md
1. Epsilon GC 只负责内存分配，不实现任何内存回收机制。这对于性能测试非常有用，可用于与其他GC对比成本和收益。
```
* Lambda 参数的局部变量语法
```md
Java10中引入的var字段得到了增强，现在可以用在lambda表达式的声明中。
如果lambda表达式的其中一个形式参数使用了var，那所有的参数都必须使用var。
```
* String 优化
```md
"String::lines" 获取数据行数
"String::strip" 来移除空格
“String::repeat” 来复制字符串
```

## Java 10
* Local-Variable Type Inference （局部变量类型推断）- var 保留类型名称
* Optional 类添加了新的方法 orElseThrow - 相比于已经存在的get方法，这个方法更推荐使用。

## [Java 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-C23AFD78-C777-460B-8ACE-58BE5EA681F6)
* 模块化系统 – Jigsaw 项目
* 支持私有接口方法
* 垃圾收集机制 - G1设为默认的垃圾回收器实现
* JShell–Java 9 REPL - 交互式编程环境
```md
REPL是一种快速运行语句的命令行工具
```
* 不可变集合工厂方法
* I/O 流新特性
* ***[响应式流](Java9/FlowAPI/README.md)***
* 多分辨率图像API–JEP 251
* 进程 API 的改进
```md
迄今为止，通过Java来控制和管理操作系统的进程的能力有限。
```
* 钻石（diamond）操作符范围的延伸
* 统一的JVM日志
* 多版本兼容 JAR 包
* 注释 SafeVarargs 范围的延伸
* ***HTTP 2 客户端***
* 轻量级的 JSON API - 内置了一个轻量级的JSON API
* 多分辨率图像 API
* 改进的弃用注解 @Deprecated
* 改进钻石操作符(Diamond Operator) 
* 改进的 Stream API
* 改进 try-with-resources
* 改进 Optional 类
* 改进的 CompletableFuture API
* Javadoc 优化
```md
1. 简化 Doclet API
2. 支持生成HTML5格式
3. 加入了搜索框，使用这个搜索框可以查询程序元素、标记的单词和文档中的短语。
4. 支持新的模块系统。
```
* JVM 优化
```md
1. 增强了Garbage-First(G1)并用它替代Parallel GC成为默认的垃圾收集器。
2. 统一了JVM 日志，为所有组件引入了同一个日志系统。
3. 删除了JDK 8中弃用的GC组合。（DefNew + CMS，ParNew + SerialOld，Incremental CMS）。
```
* properties文件支持UTF-8编码，之前只支持ISO-8859-1
* 支持Unicode 8.0，在JDK8中是Unicode 6.2

## Java 8
* ***[Default Methods](Java8/Default-Methods.md)***
* ***[Lambda Expressions]()***
* ***[Stream API]()***
* Method references
* Repeating Annotations 
* Type Annotation
* 类型推断增强
* Method Parameter Reflection
* HashMap 优化
* Date Time API
* java.util 包优化
* java.util.concurrent 包优化
* HotSpot 优化

## Java 7
* 二进制前缀 0b 或者 0B
* switch 支持 String 类型
* 泛型实例化类型自动推断
* try-with-resources
* 单个catch中捕获多个异常类型（用 | 分割)

## Java 6
* JDBC4.0规范
* 集合框架增强
* Scripting - 让其他语言在java平台上运行

## Java 5
* ***[Generics](Java5/Generics/README.md)***
* ***[Typesafe Enums]()***
* ***[Annotation]()***
* Varargs （可变参数）
* Static Import （静态导入）
* java.util.concurrent
