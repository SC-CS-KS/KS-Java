# 线程工具
```md
线程工具其实就是对锁的不断变种，适应更多的开发场景，提高性能，提供更方便的工具，
从最粗暴的同步修饰符，到灵活的可重入锁，到宽松的条件，
接着到允许多个线程访问的信号量，最后到读写分离锁。
```
* [锁 Lock](java-lock/java-lock.md)
* [并发库 JCU](JCU/README.md)

## 线程同步控制
* ReentrantLock
```md
可重入互斥锁具有与使用synchronized的隐式监视器锁具有相同的行为和语义，但具有更好扩展功能。
ReentrantLock由最后成功锁定的线程拥有，而且还未解锁。
当锁未被其他线程占有时，线程调用lock()将返回并且成功获取锁。
如果当前线程已拥有锁，则该方法将立即返回。这可以使用方法isHeldByCurrentThread()和getHoldCount()来检查。

构造函数接受可选的fairness参数。当设置为true时，在竞争条件下，锁定有利于赋予等待时间最长线程的访问权限。
否则，锁将不保证特定的访问顺序。在多线程访问的情况，使用公平锁比默认设置，有着更低的吞吐量，
但是获得锁的时间比较小而且可以避免等待锁导致的饥饿。但是，锁的公平性并不能保证线程调度的公平性。
因此，使用公平锁的许多线程中的一个可以连续多次获得它，而其他活动线程没有进展并且当前没有持有锁。
不定时的tryLock（）方法不遵循公平性设置。即使其他线程正在等待，如果锁可用，它也会成功。

任意指定锁的起始位置
中断响应
锁申请等待限时tryLock()
公平锁
```
* Condition
```md
Condition从拥有监控方法（wait,notify,notifyAll）的Object对象中抽离出来成为独特的对象，
高效的让每个对象拥有更多的等待线程。
和锁对比起来，如果说用Lock代替synchronized，那么Condition就是用来代替Object本身的监控方法。

Condition实例跟Object本身的监控相似，同样提供wait()方法让调用的线程暂时挂起让出资源，
直到其他线程通知该对象转态变化，才可能继续执行。
Condition实例来源于Lock实例，通过Lock调用newCondition()即可。
Condition较Object原生监控方法，可以保证通知顺序。
```
* Semaphore
```md
锁和同步块同时只能允许单个线程访问共享资源，
这个明显有些单调，部分场景其实可以允许多个线程访问，这个时候信号量实例就派上用场了。
信号量逻辑上维持了一组许可证， 线程调用acquire()阻塞直到许可证可用后才能执行。 
执行release()意味着释放许可证，实际上信号量并没有真正的许可证，只是采用了计数功能来实现这个功能。
```
* ReadWriteLock
```md
顾名思义读写锁将读写分离，细化了锁的粒度，照顾到性能的优化。
```
* CountDownLatch
```md
这个锁有点“关门放狗”的意思，尤其在我们压测的时候模拟实时并行请求，
该实例将线程积累到指定数量后，调用countDown()方法让所有线程同时执行。
```
* CyclicBarrier
```md
CyclicBarrier是加强版的CountDownLatch，上面讲的是一次性“关门放狗”，
而循环栅栏则是集齐了指定数量的线程，在资源都允许的情况下同时执行，然后下一批同样的操作，周而复始。
```
* LockSupport
```md
LockSupport是用来创建锁和其他同步类的基本线程阻塞原语。

LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，
而且park()和unpark()不会遇到“Thread.suspend 和 Thread.resume所可能引发的死锁”问题。
因为park() 和 unpark()有许可的存在；
调用 park() 的线程和另一个试图将其 unpark() 的线程之间的竞争将保持活性。
```
## [线程池 ThreadPool](thread-pool/README.md)

## 并发容器
```md
ConcurrentHashMap
CopyOnWriteArrayList
ConcurrentLinkedQueue
BlockingQueue
ConcurrentSkipListMap
Vector
HashTable
... ... 
```

## Reference
* [Java Source Code](https://github.com/SunnnyChan/sc.drill-code/tree/master/java)


