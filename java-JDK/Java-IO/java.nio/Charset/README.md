# Java Charset
## 获取字符集
```java
//返回指定的字符集CharSet
Charset charset = Charset.forName("utf8");
//返回虚拟机默认的字符集CharSet
Charset charset = Charset.defaultCharset();
```
## 创建编码器和解码器
```java
//编码器
CharsetEncoder encoder = charset.newEncoder();
//解码器
CharsetDecoder decoder = charset.newDecoder();
```
## 解析数据
```java
//编码，传入CharBuffer
ByteBuffer byteBuffer = encoder.encode(in);
//解码，传入ByteBuffer
CharBuffer charBuffer = decoder.decode(in);
```

