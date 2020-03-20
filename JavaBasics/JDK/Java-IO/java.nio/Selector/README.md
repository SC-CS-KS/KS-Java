## Selector
```md
是 Java NIO 的一个组件，它用于监听多个 Channel 的各种状态，用于管理多个 Channel。
轮询每个注册的Channel，一旦发现Channel有注册的事件发生，便获取事件然进行处理。

但本质上由于 FileChannel 不支持注册选择器，所以 Selector 一般被认为是服务于网络套接字通道的。
```
```md
而大家口中的「NIO 是非阻塞的」，准确来说，指的是网络编程中客户端与服务端连接交换数据的过程是非阻塞的。
普通的文件读写依然是阻塞的，和 IO 是一样的。
```
```md
用单线程处理一个Selector，然后通过Selector.select()方法来获取到达事件，
在获取了到达事件之后，就可以逐个地对这些事件进行响应处理。
```
```md
为ServerSocketChannel 监控接收客户端连接就绪事件，为 SocketChannel 监控连接服务器就绪, 读就绪和写就绪事件。
```

## [SelectionKey](SelectionKey.md)

## 流程
### 创建
```md
创建一个选择器一般是通过 Selector 的工厂方法，Selector.open。
```
### 注册
```md
支持注册选择器的通道都有一个 register 方法，该方法就是用于注册当前实例通道到指定选择器的。
一个通道想要注册到某个选择器中，必须调整模式为非阻塞模式。
```
```md
这个该方法会返回一个 SeletctKey 对象，但在这里我们通常忽略这个返回值。
SeletctionKey 对象内部包含了这个注册的通道和这个通道感兴趣的事件（ops参数），
以及附带的对象（由att参数传递），这个附带的对象通常就是和这个通道相关的读写缓冲区。
```
### 通道的选择与取消
```md
三个方法的返回值都表示就绪通道的数量。
```
* select()
```md
阻塞方法，有通道就绪才会返回。
```
* select(long timeout)
```md
最多阻塞timeout毫秒，即使没有通道就绪也会返回，若超时返回，则当前线程中断标志位被设置。
若阻塞时间内有通道就绪，就提前返回。
```
* seletor.selectNow()
```md
非阻塞方法
```
#### 一个 seletor 对象内部维护了三个集合
```md
1）已注册集合：表示了所有已注册通道的SelectionKey对象。
2）就绪集合：表示了所有已就绪通道的SelectionKey对象。
3）取消集合：表示了所有需要取消注册关系的通道的SelectionKey对象。
```
## NIO服务器端开发
```md
1、创建ServerSocketChannel，配置它为非阻塞模式
2、绑定监听，配置TCP参数，如backlog大小
3、创建一个独立的I/O线程，用于轮询多路复用器Selector
4、创建Selector，将之前创建的ServerSocketChannel注册到Selector上，监听SelectionKey.ACCEPT
5、启动I/O线程，在循环体内执行Selector.select()方法，轮询就绪的Channel
6、当轮询到了处于就绪状态的Channel时，需对其进行判断，
    如果是OP_ACCEPT状态，说明是新的客户端接入，则调用ServerSocketChannel.accept()方法接受新的客户端
7、设置新接入的客户端链路SocketChannel为非阻塞模式，配置其他的一些TCP参数
8、将SocketChannel注册到Selector，监听OP_WRITE
9、如果轮询的Channel为OP_WRITE，则说明要向SockChannel中写入数据，则构造ByteBuffer对象，写入数据包
```
