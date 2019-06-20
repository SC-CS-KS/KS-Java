# [commons-pools](http://commons.apache.org/proper/commons-pool/)
```md
Commons Pool组件提供了一整套用于实现对象池化的框架，以及若干种各具特色的对象池实现。
2.0 版本包含可靠的实例跟踪和池监控。

commos-pool在很多场景中用来实现"连接池"/"任务worker池"等。
dbcp数据库连接池，也是基于commons-pool实现。
```
## Dependency
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
    <version>${commons-pool2-version}</version>
</dependency>
```
## 对象生命周期
![](pic/object-lifecycle.jpg)

## 组成
* ObjectPool
```java
实现对对象存取和状态管理的池实现；如：线程池、数据库连接池
//从池中获取对象
T borrowObject() throws Exception, NoSuchElementException, IllegalStateException;

//将对象放回池中
void returnObject(T obj) throws Exception;

//废弃对象
void invalidateObject(T obj) throws Exception;

//添加对象
void addObject() throws Exception, IllegalStateException, UnsupportedOperationException;

//获取空闲对象个数
int getNumIdle();

//获取活跃对象个数
int getNumActive();

//清除池，池可用
void clear() throws Exception, UnsupportedOperationException;

//关闭池，池不可用
void close();
```
* PooledObject
```java
池化对象，是需要放到ObjectPool对象的一个包装类。
添加了一些附加的信息，比如说状态信息，创建时间，激活时间，关闭时间等。
```

* PooledObjectFactory
```java
是一个池化对象工厂接口，定义了生成对象、激活对象、钝化对象、销毁对象的方法

// 创建一个新对象;当对象池中的对象个数不足时,将会使用此方法来"输出"一个新的"对象",并交付给对象池管理
PooledObject<T> makeObject() throws Exception;

// 销毁对象,如果对象池中检测到某个"对象"idle的时间超时,
// 或者操作者向对象池"归还对象"时检测到"对象"已经无效,那么此时将会导致"对象销毁";
// "销毁对象"的操作设计相差甚远,但是必须明确:当调用此方法时,
// "对象"的生命周期必须结束.如果object是线程,那么此时线程必须退出;
// 如果object是socket操作,那么此时socket必须关闭;如果object是文件流操作,那么此时"数据flush"且正常关闭.
void destroyObject(PooledObject<T> p) throws Exception;

// 检测对象是否"有效";Pool中不能保存无效的"对象",因此"后台检测线程"会周期性的检测Pool中"对象"的有效性,
// 如果对象无效则会导致此对象从Pool中移除,并destroy;
// 此外在调用者从Pool获取一个"对象"时,也会检测"对象"的有效性,确保不能讲"无效"的对象输出给调用者;
// 当调用者使用完毕将"对象归还"到Pool时,仍然会检测对象的有效性.
// 所谓有效性,就是此"对象"的状态是否符合预期,是否可以对调用者直接使用;
// 如果对象是Socket,那么它的有效性就是socket的通道是否畅通/阻塞是否超时等.
boolean validateObject(PooledObject<T> p);

// "激活"对象,当Pool中决定移除一个对象交付给调用者时额外的"激活"操作,
// 比如可以在activateObject方法中"重置"参数列表让调用者使用时感觉像一个"新创建"的对象一样;
// 如果object是一个线程,可以在"激活"操作中重置"线程中断标记",或者让线程从阻塞中唤醒等;
// 如果object是一个socket,那么可以在"激活操作"中刷新通道,或者对socket进行链接重建(假如socket意外关闭)等.
void activateObject(PooledObject<T> p) throws Exception;

// "钝化"对象,当调用者"归还对象"时,Pool将会"钝化对象"；钝化的言外之意,就是此"对象"暂且需要"休息"一下.
// 如果object是一个socket,那么可以passivateObject中清除buffer,将socket阻塞;如果object是一个线程,
// 可以在"钝化"操作中将线程sleep或者将线程中的某个对象wait.
// 需要注意的时,activateObject和passivateObject两个方法需要对应,避免死锁或者"对象"状态的混乱.
void passivateObject(PooledObject<T> p) throws Exception;
```

## 创建对象池
```md
在org.apache.commons.pool2.impl中预设了三个可以直接使用的对象池：
GenericObjectPool、GenericKeyedObjectPool和SoftReferenceObjectPool。

通常使用GenericObjectPool来创建对象池，如果是对象池是Keyed的，
那么可以使用GenericKeyedObjectPool来创建对象池。

这两个类都提供了丰富的配置选项。
这两个对象池的特点是可以设置对象池中的对象特征，包括LIFO（后进先出）方式、最大空闲数、最小空闲数、是否有效性检查等等。

SoftReferenceObjectPool对象池，它利用一个java.util.ArrayList对象来保存对象池里的对象。
不过它并不在对象池里直接保存对象本身，而是保存它们的“软引用”(Soft Reference）
```
```java
new GenericObjectPool<StringBuffer>(new PooledStringBufferFactory());
```

## 对象池配置
```md
对象池配置提供了对象池初始化所需要的参数，Common Pool2 中的基础配置类是 BaseObjectPoolConfig。
其有两个实现类分别为 GenericObjectPoolConfig和 GenericKeyedObjectPoolConfig，
分别为 GenericObjectPool 和GenericKeyedObjectPool 所使用。
```
```java
GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
conf.setMaxTotal(20);
conf.setMaxIdle(10);
GenericObjectPool<StringBuffer> pool = new GenericObjectPool<StringBuffer>(new PooledStringBufferFactory(), conf);
```

## 池化对象的状态
```md
IDLE 在池中，处于空闲状态
ALLOCATED 被使用中
EVICTION 正在被逐出器验证
VALIDATION 正在验证
INVALID 驱逐测试或验证失败并将被销毁
ABANDONED 对象被客户端拿出后，长时间未返回池中，或没有调用 use 方法，即被标记为抛弃的
```

## References
* [Apache Commons-pool2](https://www.jianshu.com/p/b0189e01de35)

