# Reactor

```md
Project Reactor，实现了完全非阻塞，并且基于网络HTTP/TCP/UDP等的背压，
即数据传输上游为网络层协议时，通过远程调用也可以实现背压。
同时，它还实现了Reactive Streams API和Reactive Extensions，
以及支持Java 8 functional API/Completable Future/Stream /Duration等各新特性。
```

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