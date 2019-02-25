# What is RxJava?
```md
Reactive Streams API是最小的接口规范，RxJava 2是它的一个实现，
另外RxJava声明了一大堆额外的方法来形成自己的丰富和流畅的API。
```
## Usage scenarios
* 客户端 
```md
在 Android 开发中已经非常流行。
```
* 服务端
```md
RxJava虽然很酷, 但服务端使用RxJava的优势真心很少：
主要的原因还是大多数的 Java 服务端还是以同步逻辑为主, 迁移成本太高了。
RxJava的响应式优势只有在异步逻辑占主导时才会体现出来，
异步和同步的夹杂使用, 还不如整体使用 NodeJS 的异步处理协调。

其次, RxJava一大堆的数据处理API对习惯了同步逻辑的程序员来说, 学习成本也是相当高的。
再加上后端的类库大多都是同步的 API, 兼容 RxJava 的API的类库寥寥无几。

目前后端基于RxJava构建的最著名的类库是Hystrix，
它提供的API也是通过Command模式来作为同步的方式来调用，者无需关心内部的RxJava实现。
Hystrix 使用 RxJava 简洁的 window API 来构建 metric 应该算是一种不错的后端使用场景。

兼容RxJava API的rxjava-jdbc, 虽然使用起来代码会简洁不少,
但现在的项目已经很少直接使用jdbc了, 也是英雄无用武之地。

如果想在后端使用响应式编程的话，不妨看看 vertx, 
它基本用自己的响应式打通了后端的各个环节, 它规划的技术栈还是很全面,基本上覆盖到后端开发的功能.
```
## Compare With
* vs. Java 9 Flow API
```md
If you need working and reliable solutions relatively soon, 
I suggest you stick with the Reactive Streams ecosystem for now. 
If you have plenty of time or you want to explore things, you could start using the Flow API.
```