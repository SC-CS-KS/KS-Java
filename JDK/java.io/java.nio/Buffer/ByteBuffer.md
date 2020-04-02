# ByteBuffer
```md
实质上是对byte数组进行了封装，其内部是一个byte数组，
ByteBuffer 对象提供了一些实用的API供我们去操作这个数组，完成一些读取或写入的功能。
```
## 创建
```md
缓冲区类没有一种是可以直接实例化的，他们都是抽象类，但都包含了静态工厂方法创建相应的实例。
```
```java
static ByteBuffer allocate(int capacity)
static ByteBuffer allocateDirect(int capacity)
static ByteBuffer wrap(byte[] array)
static ByteBuffer wrap(byte[] array, int offset, int length)
```
```java
ByteBuffer buffer = ByteBuffer.allocate(1024);
```
```java
byte array[] = new byte[1024];
ByteBuffer buffer = ByteBuffer.wrap(array);
```
```md
allocate 方法分配了一个具有指定大小底层数组的缓冲区对象，这个大小也就是上面提到的Capacity。

wrap 方法使用已经存在的数组来作为缓冲区对象的底层数组。
此时，buffer对象的底层数组指向了array，这意味着直接修改array数组也会使buffer对象读取的数据产生变化。
```
```java
byte[] bs = new byte[10];
ByteBuffer buffer = ByteBuffer.wrap(bs);
System.out.println(buffer.toString());
打印如下：
java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
```
* 非直接缓冲区
```md
wrap方式 和allocate方式 创建的ByteBuffer没有本质区别，都创建的是非直接缓冲区。
ByteBuffer对象(和对象包含的缓冲数组)都位于JVM的堆区。
```
* 直接缓冲区
```md
allocateDirect方法创建的 ByteBuffer 称之为直接缓冲区，
ByteBuffer 对象本身在堆区，而缓冲数组位于非堆区，
ByteBuffer 对象内部存储了这个非堆缓冲数组的地址。

在非堆区的缓冲数组可以通过JNI方式进行IO操作，JNI不受GC影响，机器码执行速度也比较快，
同时还避免了JVM堆区与操作系统内核缓冲区的数据拷贝，所以IO速度比非直接缓冲区快。

直接缓冲区创建和回收花费的时间比较多，适用于需要重复使用的缓冲区对象。
```
## 读写数据
```md
通过 Channel 读写数据到Buffer。
通过 Buffer 的get()、put()方法读写数据。
```
* put() 向缓冲区放入数据
```md
put方法中0到position-1的区域表示有效数据，position到limit之间区域表示空闲区域。
put方法会从position的当前位置放入数据，每放入一个数据position增加1，
当position等于limit（即空闲区域使用完）时还继续放入数据就会抛出BufferUnderflowException异常
```
* get() 从缓冲区读取数据
```md
get方法中， 0到position-1的区域表示已读数据，position到limit之间的区域表示未读取的数据。
每读取一个数据position增加1，当position等于limit时继续读取数据就会抛出BufferUnderflowException异常。
```

* flip() 将写模式转换成读模式
```md
想要将刚刚写入的数据读出的话应该怎么做？
应该将 position 设为0：buffer.position(0)，就可以从正确的位置开始获取数据。

但是它是怎样知道何时到达我们所插入数据末端的呢？
这就是边界属性被引入的目的。边界属性指明了缓冲区有效内容的末端。
需要将limit设置为当前位置：buffer.limit(buffer.position())。

buffer.limit(buffer.position()).position(0);

buffer.flip()封装了这些操作，调用buffer.flip()后，limit设置为当前position值，position重置为0.
```
* clear：清空缓冲区，将读模式转换写模式
```java
public final Buffer clear() {
    position = 0;
    limit = capacity;
    mark = -1;
    return this;
}
```
* compact：保留未读取的数据，将读模式转换写模式
```java
public ByteBuffer compact() {
 
    int pos = position();
    int lim = limit();
    assert (pos <= lim);
    int rem = (pos <= lim ? lim - pos : 0);
 
    unsafe.copyMemory(ix(pos), ix(0), (long)rem << 0);
    position(rem);
    limit(capacity());
    discardMark();
    return this;
 
}
```
```md
compact()方法并不是Buffer接口中定义的，而是属于ByteBuffer。
如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先写些数据，那么使用compact()方法。

compact()方法将所有未读的数据拷贝到Buffer起始处。
然后将position设到最后一个未读元素正后面。
limit属性依然像clear()方法一样，设置成capacity。
现在Buffer准备好写数据了，但是不会覆盖未读的数据。
```
* Buffer.mark() 保存当前position的位置到mark变量
```java
public final Buffer mark() {
    mark = position;
    return this;
}
```
```md
Buffer.mark()，使缓冲区能够记住一个位置并在之后将其返回。
缓冲区的标记在mark()函数被调用之前是未定义的，调用时标记被设为当前位置的值。
```
* Buffer.reset() 将position置为mark变量中的值
```java
public final Buffer reset() {
    int m = mark;
    if (m < 0)
        throw new InvalidMarkException();
    position = m;
    return this;
}
```
```md
reset()函数将位置设为当前的标记值。
如果标记值未定义，调用reset()将导致InvalidMarkException异常。

mark方法和rest方法联合使用可实现从指定位置的重读。
```

* Buffer.rewind() 从头开始重读
```java
public final Buffer rewind() {
    position = 0;
    mark = -1;
    return this;
}
```
```md
rewind()方法与filp()相似，但是不影响limit，他只是将position设为0，这样就可以从新读取已经读过的数据了。
```
* Buffer.remaining()、Buffer.hasRemaining()
```md
remaining()函数将返回从当前位置到上界还剩余的元素数目。
hasRemaining()会返回是否已经达到缓冲区的边界。
```

* ByteBuffer.equals()、ByteBuffer.compareTo()

***注意***
```md
ByteBuffer对象既可以读，也可以写。
除非我们能保证在读操作一次性使用完ByteBuffer对象中的所有数据，
并且保证写入ByteBuffer对象向中的内容全部写入完成，
否则同时用于读写的ByteBuffer对象会造成数据的混乱和错误。

一般来说，我们都会创建两个ByteBuffer对象向，一个用于接收数据，另一个用于发送数据。
```

## getInt，putInt，getFloat，putFloat
```md
如果需要从基本数据类型数组中写入到ByteBuffer中，或者从ByteBuffer中读取到基本数据类型的数组中，
那么我们可以通过已创建好的ByteBuffer对象的asXxxBuffer方法创建基本数据类型的Buffer。
```
```java
IntBuffer intBufferObj = byteBufferObj.asIntBuffer();
```
```md
intBufferObj和byteBufferObj对象共享底层的数组。
但是比较坑爹的是两个buffer的position，limit是独立的，极易产生bug，需要引起注意。
```

## ByteBuffer的编码和解码
```md
数据传输中我们使用的是ByteBuffer对象作为缓冲区，如果在通道两端通信的内容是文本数据，就涉及到ByteBuffer与CharBuffer的转换。
可以使用Charset类实现转换的功能。
```
* 解码示例
```java
ByteBuffer byteBuffer = ByteBuffer.allocate(128);
byteBuffer.put(new byte[]{-26, -120, -111, -25, -120, -79, -28, -67, -96});
byteBuffer.flip();
 
/*对获取utf8的编解码器*/
Charset utf8 = Charset.forName("UTF-8");
CharBuffer charBuffer = utf8.decode(byteBuffer);/*对bytebuffer中的内容解码*/
 
/*array()返回的就是内部的数组引用，编码以后的有效长度是0~limit*/
char[] charArr = Arrays.copyOf(charBuffer.array(), charBuffer.limit());
System.out.println(charArr); /*运行结果：我爱你*/
```
* 编码示例
```java
CharBuffer charBuffer = CharBuffer.allocate(128);
charBuffer.append("我爱你");
charBuffer.flip();
 
/*对获取utf8的编解码器*/
Charset utf8 = Charset.forName("UTF-8");
ByteBuffer byteBuffer = utf8.encode(charBuffer); /*对charbuffer中的内容解码*/
 
/*array()返回的就是内部的数组引用，编码以后的有效长度是0~limit*/
byte[] bytes = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
System.out.println(Arrays.toString(bytes));
/*运行结果：[-26, -120, -111, -25, -120, -79, -28, -67, -96] */
```
```md
还可以通过代码中的utf8编解码器分别获取编码器对象和解码器对象。
然后通过编码器和解码器提供的方法进行编解码，其中一些方法可以使ByteBuffer和CharBuffer对象循环使用，不必每次都产生一个新的对象。

注意encode和decode方法都会改变源buffer中的position的位置，这点也是容易产生bug的方法。
```

## asReadOnlyBuffer() 只读缓冲区
```md
可以使用asReadOnlyBuffer()函数来生成一个只读的缓冲区视图。
这个新的缓冲区不允许使用put()，并且其isReadOnly()函数将会返回true。
对这一只读缓冲区的put()函数的调用尝试会导致抛出ReadOnlyBufferException异常。

两个缓冲区共享数据元素，拥有同样的容量，但每个缓冲区拥有各自的位置，上界和标记属性。
对一个缓冲区内的数据元素所做的改变会反映在另外一个缓冲区上。
```
## duplicate() 复制缓冲区
```md
duplicate()函数创建了一个与原始缓冲区相似的新缓冲区。
两个缓冲区共享数据元素，拥有同样的容量，但每个缓冲区拥有各自的位置，上界和标记属性。
对一个缓冲区内的数据元素所做的改变会反映在另外一个缓冲区上。
这一副本缓冲区具有与原始缓冲区同样的数据视图。
如果原始的缓冲区为只读，或者为直接缓冲区，新的缓冲区将继承这些属性。

复制一个缓冲区会创建一个新的Buffer对象，但并不复制数据。
原始缓冲区和副本都会操作同样的数据元素。
```

## 缓冲区分片
```md
slice() 方法根据现有的缓冲区创建一种 子缓冲区 。
也就是说，它创建一个新的缓冲区，新缓冲区与原来的缓冲区的一部分共享数据。
```
```md
对这个缓冲区 分片 ，以创建一个包含槽 3 到槽 6 的子缓冲区。
在某种意义上，子缓冲区就像原来的缓冲区中的一个 窗口。
窗口的起始和结束位置通过设置 position 和 limit 值来指定。
```
```java
print(buffer, bs);
buffer.position( 3 ).limit( 7 );
ByteBuffer slice = buffer.slice();
print(slice, slice.array());

打印如下：
java.nio.HeapByteBuffer[pos=4 lim=10 cap=10]
lloyoy$$$$
java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]
lloyoy$$$$
```
```md
slice 是缓冲区的 子缓冲区 。
不过， slice 和 buffer 共享同一个底层数据数组。
```

## 类型视图缓冲区
```md
在进行IO操作时，可能会使用各种ByteBuffer类去读取文件内容，
接收来自网络连接的数据使用各种ByteBuffer类去读取文件内容，接收来自网络连接的数据等。
一旦数据到达了您的 ByteBuffer，我们需要对他进行一些操作。
```
```md
ByteBuffer类允许创建视图来将byte型缓冲区字节数据映射为其它的原始数据类型。
asLongBuffer()函数创建一个将八个字节型数据当成一个 long 型数据来存取的视图缓冲区。
```
```java
public abstract class ByteBuffer extends Buffer implements Comparable{
    // 这里仅列出部分API
    public abstract CharBuffer asCharBuffer();
    public abstract ShortBuffer asShortBuffer();
    public abstract IntBuffer asIntBuffer();
    public abstract LongBuffer asLongBuffer();
    public abstract FloatBuffer asFloatBuffer();
    public abstract DoubleBuffer asDoubleBuffer();
}

buffer.clear();
buffer.order(ByteOrder.BIG_ENDIAN);//指定字节序
buffer.put (0, (byte)0);
buffer.put (1, (byte)'H');
buffer.put (2, (byte)0);
buffer.put (3, (byte)'i');
buffer.put (4, (byte)0);
buffer.put (5, (byte)'!');
buffer.put (6, (byte)0);

CharBuffer charBuffer = buffer.asCharBuffer();
System.out.println("pos=" + charBuffer.position() + " limit=" + charBuffer.limit() + " cap=" + charBuffer.capacity());;
print(charBuffer, bs);

打印如下：
pos=0 limit=5 cap=5
Hi!   
$H$i$!$$$$
```
```md
新的缓冲区的容量是字节缓冲区中存在的元素数量除以视图类型中组成一个数据类型的字节数。
视图缓冲区的第一个元素从创建它的ByteBuffer对象的位置开始(positon()函数的返回值)。
```