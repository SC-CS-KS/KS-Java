# java.io
```md
Java的核心库java.io提供了全面的IO接口，通过数据流、序列化和文件系统提供系统输入和输出。 
Provides for system input and output through data streams, serialization and the file system.

I/O 的核心问题要么是数据格式影响 I/O 操作，要么是传输方式影响 I/O 操作，
也就是将什么样的数据写到什么地方的问题，I/O 只是人与机器或者机器与机器交互的手段，
除了在它们能够完成这个交互功能外，我们关注的就是如何提高它的运行效率了，
而数据格式和传输方式是影响效率最关键的因素。

java.io 对继承和接口运用得最优雅的案例。
```
```md
主要含有与输入/输出相关的类，这些类提供了对不同的输入和输出设备读写数据的支持，
这些输入和输出设备包括键盘、显示器、打印机、磁盘文件等。
```
![IO体系](../pic/Java.IO.png)

## Interface
* [Closeable](interface/Closeable.md)
* [Flushable](interface/Flushable.md)
* [Serializable](interface/Serializable.md)

## [Stream](Stream/README.md)
* [StreamDecoder - 字节流和字符流的转换器]()

## Java I/O
* [基于字节操作的 I/O 接口：InputStream 和 OutputStream](InputStream-OutpurStream.md)
* [基于字符操作的 I/O 接口：Writer 和 Reader](Writer-Reader.md)
* [基于磁盘操作的 I/O 接口：File](File/README.md)
* 基于网络操作的 I/O 接口：Socket  

```md
前两组主要是根据传输数据的数据格式，后两组主要是根据传输数据的方式。
Socket 类并不在 java.io 包。
```
## References
* [深入分析 Java I/O 的工作机制](https://www.ibm.com/developerworks/cn/java/j-lo-javaio/index.html)
