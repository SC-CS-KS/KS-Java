# Closeable
```md
A Closeable is a source or destination of data that can be closed.
	public interface Closeable extends AutoCloseable
	java.lang.AutoCloseable
Closeable和Flushable，它们是在java.io包中定义的，并且是由JDK5添加的
Closeable接口也定义了close()方法
	实现了Closeable接口的类的对象可以被关闭
从JDK7开始，Closeable扩展了AutoCloseable。
	因此，在JDK7中，所有实现了Closeable接口的类也都实现了AutoCloseable接口。
```
* Method
```md
void close() throws IOException
		Closes this stream and releases any system resources associated with it.
			 If the stream is already closed then invoking this method has no effect.
		As noted in AutoCloseable.close()
			cases where the close may fail require careful attention.
		It is strongly advised to relinquish the underlying resources and to internally mark the Closeable as closed, prior to throwing the IOException.
			relinquish
英 [rɪ'lɪŋkwɪʃ]  美 [rɪ'lɪŋkwɪʃ] 
vt. 放弃；放手；让渡
		Closeable接口也定义了close()方法。实现了Closeable接口的类的对象可以被关闭。
			从JDK7开始，Closeable扩展了AutoCloseable。
			因此，在JDK7中，所有实现了Closeable接口的类也都实现了AutoCloseable接口。
```
```java
public interface Closeable extends AutoCloseable
	AutoCloseable
		java.lang
			public interface AutoCloseable
			void close() throws Exception
```