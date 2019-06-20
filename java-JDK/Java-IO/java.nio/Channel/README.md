# Channel
```md
官方对Channel的解释:一个用于输入/输出操作的连接。
通道表示对实体的开放连接，如硬件设备、文件、网络套接字或能够执行一个或多个不同的输入/输出操作的程序组件，例如读取或写入。
```
```md
Thanking In Java中的描述：
速度的提高来自于使用的结构更接近OS执行IO的方式：通道和缓存器。
可以把它想象成一个煤矿，通道是一个包含煤层（数据）的矿藏，而缓冲器是配送到矿藏的卡车。卡车载满煤而归，我们再从卡车上获得煤炭。
也就是我们并没有直接和通道交互，而只是和缓冲器交互，并把缓冲器送至通道。
通道要么从缓冲器获取数据，要么向缓冲器发送数据。
```
```md
通道不能单独存在，它永远需要绑定一个缓存区，所有的数据只会存在于缓存区中，
无论你是写或是读，必然是缓存区通过通道到达磁盘文件，或是磁盘文件通过通道到达缓存区。
```
```md
Channel是对I/O操作的封装。
FileChannel 配合着 ByteBuffer，将读写的数据缓存到内存中，然后以批量/缓存的方式read/write，
省去了非批量操作时的重复中间操作，操纵大文件时可以显著提高效率。
```
## Channel 对象
```md
FileChannel 是基于文件的通道
SocketChannel 和 ServerSocketChannel 用于网络 TCP 套接字数据报读写
DatagramChannel 是用于网络 UDP 套接字数据报读写
```
* [FileChannel](FileChannel.md)
* [DatagramChannel](DatagramChannel.md)
* [SocketChannel & ServerSocketChannel](SocketChannel.md)

## 创建
```md
通过调用内部的open静态方法实现的，此方法是线程安全的。
```

## 读写
```md
不论哪种类型的Channel对象，都有read（要理解为从通道中读取，写入缓冲区中）和 
write（要理解为从缓冲区中读取数据，写入到通道中）方法，而且read和write方法都只针对ByteBuffer对象。
```
```md
要获取由通道传输过来的数据时，先调用channel.read（byteBufferObj）方法，
这个方法在内部调用了byteBufferObj对象的put方法，将通道中的数据写入缓冲区中。

接着调用byteBufferObj.flip()，然后调用byteBufferObj的get方法获取通道传过来的数据，
最后调用clear或compact方法转换成写模式，为下次channel.read做准备。
```
```md
要向通道发送数据时，先调channel.write（byteBufferObj）方法，
这个方法内部调用了byteBufferObj的get方法获取数据，然后将数据写入通道中。

当写入完成后调用clear或compact方法转换成写模式，为下次channel.write写入缓冲区取做准备。
```
