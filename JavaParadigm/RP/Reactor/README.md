# [Reactor](https://projectreactor.io/)

## [What Is](WhatIs.md)

## 操作符
```md
1）新序列创建，例如创建数组类序列等；
2）现有序列转换，将其转换为新的序列，例如常见的map操作；
3）从现有的序列取出某些元素；
4）序列过滤；
5）序列异常处理；
6）与时间相关的操作，例如某个序列是由时间触发器定期发起事件；
7）序列分割；
8）序列拉至同步世界，不是所有的框架都支持异步，再需要和同步操作进行交互时就需要这种处理。
```

##
[Reactor Core](https://github.com/reactor/reactor-core)


## [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)
```md
Flux类似RaxJava的Observable，它可以触发零到多个事件，并根据实际情况结束处理或触发错误。
```
## [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)
```md
Mono最多只触发一个事件，它跟RxJava的Single和Maybe类似，所以可以把Mono用于在异步任务完成时发出通知。
```
## Mono和Flux
```md
Mono和Flux都是Publisher（发布者）。
其实，对于大部分业务开发人员来说，当编写反应式代码时，我们通常只会接触到 Publisher 这个接口，
对应到 Reactor 便是 Mono 和 Flux。

对于 Subscriber 和 Subscription 这两个接口，Reactor 必然也有相应的实现。
但是，这些都是 Web Flux 和 Spring Data Reactive 这样的框架用到的。
如果不开发中间件，通常开发人员是不会接触到的。
```
```md
比如，在 Web Flux，你的方法只需返回 Mono 或 Flux 即可。你的代码基本也只和 Mono 或 Flux 打交道。
而 Web Flux 则会实现 Subscriber ，onNext 时将业务开发人员编写的 Mono 或 Flux 转换为 HTTP Response 返回给客户端。
```
```md
因为这两种类型之间的简单区别，我们可以很容易地区分响应式API的类型：
从返回的类型我们就可以知道一个方法会“发射并忘记”或“请求并等待”（Mono），还是在处理一个包含多个数据项的流（Flux）。
```
```md
Flux和Mono的一些操作利用了这个特点在这两种类型间互相转换。例如，调用Flux的single()方法将返回一个Mono，
而使用concatWith()方法把两个Mono串在一起就可以得到一个Flux。
类似地，有些操作对Mono来说毫无意义（例如take(n)会得到1的结果），而有些操作只有作用在Mono上才有意义（例如or(otherMono)）。
```

## Reference
* [Reactor 实例解析](https://www.infoq.cn/article/reactor-by-example)

