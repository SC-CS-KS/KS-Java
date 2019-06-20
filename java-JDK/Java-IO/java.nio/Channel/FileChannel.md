# FileChannel
```md
Java NIO FileChannel是连接文件的通道。
使用FileChannel，可以从文件中读取数据和将数据写入文件。
Java NIO FileChannel类是NIO用于替代使用标准Java IO API读取文件的方法。
```
```md
FileChannel无法设置为非阻塞模式，它总是以阻止模式运行。
对于read方法，除非遇到文件结束，否则会把缓冲区的剩余空间读满再返回。
对于write方法，会一次性把缓冲区中的内容全部写入到文件中才会返回。
```
## 开启FileChannel
```md
使用之前，FileChannel必须被打开，但是你无法直接打开FileChannel。
需要通过InputStream，OutputStream 或 RandomAccessFile 获取 FileChannel。
```
## 从FileChannel读取数据

## 将数据写入FileChannel

## 关闭FileChannel

## FileChannel位置
```md
对FileChannel进行读取或写入时，你会在特定的位置上这样做。
可以通过调用FileChannel的position()方法来获取对象的当前位置。
还可以通过调用FileChannel的position(long pos)方法设置位置。
```
```md
如果在文件结束后设置位置，并尝试从通道读取位置，您将获得-1  - 是 文件结尾标记。
如果在文件结束后设置位置，并写入到通道，文件将被扩展以适应位置和写入数据。
这可能会导致“文件孔”，其中磁盘上的物理文件在写入的数据中有间隙。
```
## FileChannel大小
```md
FileChannel对象的size()方法返回通道连接到的文件的文件大小。
```
## FileChannel截断
```md
可以通过调用该FileChannel的truncate()方法来截断文件。
当截断文件时，可以在给定的长度上将其截断。
```
## FileChannel Force
```md
FileChannel的force()方法将所有未写入的数据从通道刷新到磁盘中。
在调用force()方法之前，出于性能原因，操作系统可能会将数据缓存在内存中，因此不能保证写入通道的数据实际上写入磁盘。
force()方法采用布尔值作为参数，说明文件元数据（权限等）是否也应被刷新。
```

## 示例
```java
 File file = new File("data.txt");
 FileOutputStream outputStream = new FileOutputStream(file);
 FileChannel channel = outputStream.getChannel();
 ByteBuffer buffer = ByteBuffer.allocate(1024);
 String string = "java nio";
 buffer.put(string.getBytes());
 buffer.flip(); //此处必须要调用buffer的flip方法
 channel.write(buffer);
 channel.close();
 outputStream.close();
```
