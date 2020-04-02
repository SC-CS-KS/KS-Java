# SocketChannel & ServerSocketChannel
## SocketChannel
```md
SocketChannel: Socket 的替代类, 支持阻塞通信与非阻塞通信。

TCP客户端和TCP服务器端都用它来传输数据。
客户端必须调用connect方法去连接服务器。
```
## ServerSocketChannel
```md
ServerSocket 的替代类, 支持阻塞通信与非阻塞通信。

能够监听客户端发起的TCP连接，并为每个TCP连接创建一个新的SocketChannel来进行数据读写。
服务器端用于创建TCP连接的通道，只能对accept事件感兴趣。
accept方法会返回一个已和客户端连接好的SocketChannel通道，它才服务器是真正传输数据的通道。
```

## Socket、ServerSocket、SocketChannel、ServerSocketChannel
```md
Socket 和ServerSocket 是一对，是java.net下面实现socket通信的类。
SocketChannel 和ServerSocketChannel 是一对，他们是 java.nio 下面实现通信的类，支持异步通信。
```
```md
服务器必须先建立ServerSocket 或者 ServerSocketChannel 来等待客户端的连接。
客户端必须建立相对应的 Socket 或者 SocketChannel 来与服务器建立连接。
服务器接受到客户端的连接受，再生成一个 Socket 或者 SocketChannel 与此客户端通信。
```
```md
不过Socket和SocketChannel可以通过 socket.channel() SocketChannel.socket() 方法相互转换。
同理ServerSocket 和ServerSocketChannel 也可以相互转换。
```


