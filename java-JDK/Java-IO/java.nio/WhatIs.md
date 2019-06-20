# java.nio
```md
事件驱动模型
避免多线程
单线程处理多任务
非阻塞I/O，I/O读写不再阻塞，而是返回0
基于block的传输，通常比基于流的传输更高效
更高级的IO函数，zero-copy
IO多路复用大大提高了Java网络应用的可伸缩性和实用性
```

##  NIO vs. IO
```md
IO是面向流的，而NIO是面向块的。
```
```md
面向流是指：系统一次一个字节的处理数据，一个输入流产生一个字节的数据，一个输出流消费一个字节的数据。
面向块是指：以块的形式处理数据。每一个操作都在一步中产生或者消费一个数据块。在NIO中就是Buffer对象。
```
```md
按块的方式处理数据要比按流的方式处理数据快，
因为按块的方式读取或写入数据所执行的系统调用要远少于一次一个字节的方式，类似于BufferedInputStream的方式。
```


## 结合事件模型使用NIO同步非阻塞特性
* 主要事件
```md
读就绪、写就绪、有新连接到来
```
```md
先需要注册当这几个事件到来的时候所对应的处理器。然后在合适的时机告诉事件选择器：我对这个事件感兴趣。

对于写操作，就是写不出去的时候对写事件感兴趣；
对于读操作，就是完成连接和系统没有办法承载新读入的数据的时；
对于accept，一般是服务器刚启动的时候；
而对于connect，一般是connect失败需要重连或者直接异步调用connect的时候。
```
```md
其次，用一个死循环选择就绪的事件，会执行系统调用
（Linux 2.6之前是select、poll，2.6之后是epoll，Windows是IOCP），还会阻塞的等待新事件的到来。
新事件到来的时候，会在selector上注册标记位，标示可读、可写或者有连接到来。
```
```md
注意，select是阻塞的，无论是通过操作系统的通知（epoll）还是不停的轮询(select，poll)，这个函数是阻塞的。
所以你可以放心大胆地在一个while(true)里面调用这个函数而不用担心CPU空转。
```
```java
 interface ChannelHandler{
      void channelReadable(Channel channel);
      void channelWritable(Channel channel);
   }
   class Channel{
     Socket socket;
     Event event;//读，写或者连接
   }

   //IO线程主循环:
   class IoThread extends Thread{
   public void run(){
   Channel channel;
   while(channel=Selector.select()){//选择就绪的事件和对应的连接
      if(channel.event==accept){
         registerNewChannelHandler(channel);//如果是新连接，则注册一个新的读写处理器
      }
      if(channel.event==write){
         getChannelHandler(channel).channelWritable(channel);//如果可以写，则执行写事件
      }
      if(channel.event==read){
          getChannelHandler(channel).channelReadable(channel);//如果可以读，则执行读事件
      }
    }
   }
   Map<Channel，ChannelHandler> handlerMap;//所有channel的对应事件处理器
  }
```
```md
这个程序很简短，也是最简单的Reactor模式：注册所有感兴趣的事件处理器，单线程轮询选择就绪事件，执行事件处理器。
```
## 优化线程模型
* NIO 是怎么解决掉线程的瓶颈并处理海量连接的?
```md
NIO由原来的阻塞读写（占用线程）变成了单线程轮询事件，找到可以进行读写的网络描述符进行读写。
除了事件的轮询是阻塞的（没有可干的事情必须要阻塞），剩余的I/O操作都是纯CPU操作，没有必要开启多线程。

并且由于线程的节约，连接数大的时候因为线程切换带来的问题也随之解决，进而为处理海量连接提供了可能。

单线程处理I/O的效率确实非常高，没有线程切换，只是拼命的读、写、选择事件。
但现在的服务器，一般都是多核处理器，如果能够利用多核心进行I/O，无疑对效率会有更大的提高。
```
* 线程数
```md
1. 事件分发器，单线程选择就绪的事件。
2. I/O处理器，包括connect、read、write等，这种纯CPU操作，一般开启CPU核心个线程就可以。
3. 业务线程，在处理完I/O后，业务一般还会有自己的业务逻辑，有的还会有其他的阻塞I/O，如DB操作，RPC等。

只要有阻塞，就需要单独的线程。
```
* 注意
```md
Java的Selector对于Linux系统来说，有一个致命限制：同一个channel的select不能被并发的调用。
因此，如果有多个I/O线程，必须保证：一个socket只能属于一个IoThread，而一个IoThread可以管理多个socket。

另外连接的处理和读写的处理通常可以选择分开，这样对于海量连接的注册和读写就可以分发。
虽然read()和write()是比较高效无阻塞的函数，但毕竟会占用CPU，如果面对更高的并发则无能为力。
```
* 在客户端上，NIO又有什么使用场景呢?
> * 每连接顺序请求的Redis
```md
对于Redis来说，由于服务端是全局串行的，能够保证同一连接的所有请求与返回顺序一致。
这样可以使用单线程＋队列，把请求数据缓冲。
然后pipeline发送，返回future，然后channel可读时，直接在队列中把future取回来，done()就可以了。

能够充分的利用pipeline来提高I/O能力，同时获取异步处理能力。
```
> * 多连接短连接的HttpClient
```md
类似于竞对抓取的项目，往往需要建立无数的HTTP短连接，然后抓取，然后销毁，当需要单机抓取上千网站线程数又受制的时候，怎么保证性能呢?
何不尝试NIO，单线程进行连接、写、读操作？如果连接、读、写操作系统没有能力处理，简单的注册一个事件，等待下次循环就好了。
如何存储不同的请求/响应呢？由于http是无状态没有版本的协议，又没有办法使用队列，好像办法不多。
比较笨的办法是对于不同的socket，直接存储socket的引用作为map的key。
```
> * 常见的RPC框架，如Thrift，Dubbo
```md
这种框架内部一般维护了请求的协议和请求号，可以维护一个以请求号为key，结果的result为future的map，结合NIO+长连接，获取非常不错的性能。
```
## Reactor 模式
```md
注册所有感兴趣的事件处理器，单线程轮询选择就绪事件，执行事件处理器。
```
```md
步骤1：等待事件到来（Reactor负责）。
步骤2：将读就绪事件分发给用户定义的处理器（Reactor负责）。
步骤3：读数据（用户处理器负责）。
步骤4：处理数据（用户处理器负责）。
```
## Proactor 模式
```md
步骤1：等待事件到来（Proactor负责）。
步骤2：得到读就绪事件，执行读数据（现在由Proactor负责）。
步骤3：将读完成事件分发给用户处理器（Proactor负责）。
步骤4：处理数据（用户处理器负责）。
```

## References
* [美团 - Java NIO浅析](https://tech.meituan.com/2016/11/04/nio.html)