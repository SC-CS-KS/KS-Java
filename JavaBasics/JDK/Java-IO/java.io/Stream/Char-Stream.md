# Char Stream
```md
数据流中最小的数据单元是字符
	流序列中的数据是经一定编码处理后符合某种格式规定的特定数据
	 Java中的字符是Unicode编码，一个字符占用两个字节。

	字符流一次可以读取一个字符（1char = 2byte = 16bit）
	按照ANSI编码标准
		标点符号、数字、大小写字母都占一个字节，汉字占2个字节
	按照UNICODE标准所有字符都占2个字节
 因为数据编码的不同，而有了对字符进行高效操作的流对象
	本质其实就是基于字节流读取时，去查了指定的码表
```
## Reader
```md
Java把Reader抽象类的子类创建的流对象称作字符输入流
	Writer抽象类的子类创建的流对象称作字符输出流
```
```md
int read() 从源中读取一个字符，返回一个整数(0~65535之间的一个整数，Unicode字符值)，如果未读出字符就返回-1。
int read(char b[]) 从源中读取b.length个字符到字符数组中b中，返回实际读取的字符数目，到达末尾则返回-1。
void close() 关闭输入流
```
```md
BufferedReader
	
		缓存流
			BufferedReader类和BufferedWriter类创建的对象称作缓冲输入、输出流
			二者增强了读写文件的能力，提供了读取文件一行的方法
			二者的源和目的地都必须是字符输入流和字符输出流 
InputStreamReader
	
		FileReader
			
				文件字符流
				
					字节流不能很好的操作Unicode字符
						一个汉字在文件中占有2个字节
					如果使用字节流，读取不当会出现”乱码”现象
StringReader
PipedReader
ByteArrayReader
CharArrayReader
FilterReader
	PushbackReader
```
## Writer
```md
OutStream流溢字符为单位顺序的写文件
	只要不关闭流，每次调用write方法就顺序地向目的地写入内容，直到流被关闭
```
```md
void write(int n) 向输入流写入一个字符。
void write(byte []) 向输入流写入一个字符数组。
void close() 关闭输出流
```
```md
BufferedWriter
OutputStreamWriter
	FileWriter
StringWriter
PrintWriter
PipedWriter
CharArrayWriter
FileWriter
```