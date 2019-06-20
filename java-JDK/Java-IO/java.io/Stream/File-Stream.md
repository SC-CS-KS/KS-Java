# File Stream

* FileDescriptor
* RandomAccessFile
```md
既可以读文件也可以写文件的流
	RandomAccessFile 类创建的流称作随机流
```
```md
seek(long a) 定位RandomAccessFile 流的读写位置，a确认读写位置距离文件开头的字节个数。
getFilePointer() 获取流的当前读写位置。
readInt()  读取一个int的值
readLine() 读取一个文本行
```
```md
非ASCII字符乱码
	RandomAccessFile 流的readLine()方法在读取非ASCII字符的文件时
		如汉字的文件）会出现”乱码”现象
```

## 文件的删除和创建
## 运行可执行文件
