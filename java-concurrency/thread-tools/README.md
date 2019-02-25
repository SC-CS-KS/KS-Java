# 线程工具
```md
线程工具其实就是对锁的不断变种，适应更多的开发场景，提高性能，提供更方便的工具，
从最粗暴的同步修饰符，到灵活的可重入锁，到宽松的条件，
接着到允许多个线程访问的信号量，最后到读写分离锁。
```
* [锁 Lock](java-lock/java-lock.md)

## [线程同步控制](https://github.com/SunnnyChan/sc.drill-code/tree/master/java/java.util.concurrent)
* ReentrantLock
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


