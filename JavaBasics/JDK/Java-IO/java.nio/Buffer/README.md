# Buffer
```md
实质上是一个容器对象，通常它是一个字节数组，但是也可以使用其他种类的数组，包含一些要写入或者刚读出的数据。
在 NIO 库中，所有数据都是用缓冲区处理的，在读取数据时，它是直接读到缓冲区中的，在写入数据时，它是写入到缓冲区中的。
缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。
```
```md
除了boolean类型之外，Java为每种基本类型都封装了对应的Buffer对象。
```

## 状态变量
* 容量(Capacity)：缓冲区的总容量
```md
指定了底层数组的大小。在缓冲区创建时被设定，并且永远不能被改变。
```
* 位置(Position)：下一个要被读或写的元素的索引
```md
指定了下一个字节将放到数组的哪一个元素中。
比如，从通道中读三个字节到缓冲区中，那么缓冲区的 position 将会设置为3，指向数组中第四个元素。

初始时候 position 等于 0。
```
* 边界(Limit) 缓冲区中现存元素的计数
```md
在写模式下，Buffer的 limit 表示你最多能往Buffer里写多少数据。
读模式时， limit 表示你最多能读到多少数据。

当切换Buffer到读模式时，limit 会被设置成写模式下的 position 值。
```
* 标记(Mark)：一个备忘位置
```md
调用 mark()来设定 mark = postion。
调用 reset()设定 position = mark。
初始的mark值为-1。
```
***上面四个属性遵循以下的关系***
```md
0 <= mark <= position <= limit <= capacity
```

## Buffer
```md
对于文件读写，上面几种Buffer都可能会用到。
对于网络读写来说，用的最多的是ByteBuffer。
```
* [ByteBuffer](ByteBuffer.md)
* ShortBuffer
* IntBuffer 
* LongBuffer
* FloatBuffer
* DoubleBuffer 
* CharBuffer
* MappedByteBuffer


