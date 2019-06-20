# Stream
```md
流是一组有顺序的，有起点和终点的字节集合
	是对数据传输的总称或抽象
即数据在两设备间的传输称为流，流的本质是数据传输
	根据数据传输特性将流抽象为各种类，方便更直观的进行数据操作。
```
* 输入流和输出流
```md
  差别在于出和入，是相对于“使用程序”这个参照物而言的
		如果数据的流向是程序至设备，我们称为输出流，反之我们称为输入流
		服务器端的输出流对应就是接受客户端的输入流
	输出流和输入流，二者没有必然的联系，都是流，差别是方向不同
		也就是说，程序可以只有输入流而没有输出流，或者只有输出流而没有输入流。
```

## 
* [字符流](Char-Stream.md)
* [字节流](Byte-Stream.md)
```md
区别
	读写单位不同
		字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节
	处理对象不同
		字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据
	字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的
		而字符流在操作的时候是会用到缓冲区的，是通过缓冲区来操作文件
```
```md
结论
	优先选用字节流
		首先因为硬盘上的所有文件都是以字节的形式进行传输或者保存的，包括图片等内容
		但是字符只是在内存中才会形成的，所以在开发中，字节流使用广泛
```
## 
* [文件流](File-Stream.md)
```md
对文件进行读、写操作 FileReader、FileWriter、FileInputStream、FileOutputStream
```
* 数组流
```md
流的源和目标是计算机内存
字节数组输入流 ByteArrayInputStream 和字节数组输出流 ByteArrayOutputStream
对应字符数组流 CharArrayReader 和 CharArrayWriter
```
* 字符串流
```md
从/向内存字符串读写数据 StringReader、StringWriter、StringBufferInputStream
```
* 数据流
```md
允许程序按着机器无关的风格读取Java原始数据。
按基本数据类型读、写处理的数据是Java的基本类型（如布尔型，字节，整数和浮点数）
DateInputStream 和 DateOutputStream 数据输入流和数据输出流
```
* 对象流
```md
ObjectInputStream 和ObjectOutputStream 类创建的对象称作对象输入流和对象输出流有涉及对象序列化
```
* 打印流
```md
包含方便的打印方法 PrintWriter、PrintStream
```
* 管道流
```md
实现管道的输入和输出（进程间通信）PipedReader、PipedWriter、PipedInputStream、PipedOutputStream
```
* 缓冲流
```md
在读入或写出时，对数据进行缓存，以减少I/O的次数。
BufferedReader、BufferedWriter、BufferedInputStream、BufferedOutputStream
```