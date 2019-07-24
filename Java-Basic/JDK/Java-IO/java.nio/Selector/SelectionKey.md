# SelectionKey
```md
代表 ServerSocketChannel 及 SocketChannel 向 Selector 注册事件的句柄。

是一个二进制掩码，它指明当前选择器感兴趣当前通道的哪些事件。
当一个 SelectionKey 对象位于Selector 对象的 selected-keys 集合中时, 就表示与这个 SelectionKey 对象相关的事件发生了。
```
```md
在SelectionKey 类中有几个静态常量：
SelectionKey.OP_ACCEPT  ->客户端连接就绪事件 等于监听 serversocket.accept() 返回一个socket 
SelectionKey.OP_CONNECT ->准备连接服务器就绪  跟上面类似，只不过是对于socket的 相当于监听了 socket.connect()
SelectionKey.OP_READ    ->读就绪事件 表示输入流中已经有了可读数据, 可以执行读操作了
SelectionKey.OP_WRITE   ->写就绪事件
```
```md
register 方法会返回一个 SelectionKey 实例，该实例代表的就是选择器与通道的一个关联关系。
你可以调用它的 selector 方法返回当前相关联的选择器实例，也可以调用它的 channel 方法返回当前关联关系中的通道实例。
```
```md
SelectionKey 的 readyOps 方法将返回当前选择感兴趣当前通道中事件中准备就绪的事件集合，
依然返回的一个整型数值，也就是一个二进制掩码。

int readySet = selectionKey.readyOps()
假如 readySet 的值为 13，二进制 「0000 1101」，从后向前数，第一位为 1，第三位为 1，第四位为 1，
那么说明选择器关联的通道，读就绪、写就绪，连接就绪。

所以，当我们注册一个通道到选择器之后，就可以通过返回的 SelectionKey 实例监听该通道的各种事件。
```
```md
当然，一旦某个选择器中注册了多个通道，我们不可能一个一个的记录它们注册时返回的 SelectionKey 实例来监听通道事件，
选择器应当有方法返回所有注册成功的通道相关的 SelectionKey 实例。

Set<SelectionKey> selectionKeys = selector.selectedKeys()
selectedKeys 方法会返回选择器中注册成功的所有通道的 SelectionKey 实例集合。
我们通过这个集合的 SelectionKey 实例，可以得到所有通道的事件就绪情况并进行相应的处理操作。
```