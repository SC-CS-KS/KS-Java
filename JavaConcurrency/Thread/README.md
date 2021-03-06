# Thread

## 线程状态  

* NEW
* RUNNABLE
* BLOCKED
* WAITING
* TIMED_WAITING
* TERMINATED

## 线程操作

新建线程：  
new  Thread()，新建一个线程对象，内存为线程在栈上分配好内存空间

启动线程：  
start()，告诉系统系统准备就绪，只要资源允许随时可以执行我栈里面的指令了

执行线程：  
run()，分配了CPU等计算资源，正在执行栈里面的指令集

停止线程(过时)：  
stop()，把CPU和内存资源回收，线程消亡，由于太过粗暴，已经被标记为过时

线程中断：  
interrupt()，中断是对线程打上了中断标签，可供run()里面的方法体接收中断信号，
至于线程要不要中断，全靠业务逻辑设计，而不是简单粗暴的把线程直接停掉
isInterrupt()，主要是run()方法体来判断当前线程是否被置为中断
interrupted()，静态方法，也是用户判断线程是否被置为中断状态，同时判断完将线程中断状态复位

线程休眠：  
sleep()，静态方法，线程休眠指定时间段，此间让出CPU资源给其他线程，
但是线程依然持有对象锁，其他线程无法进入同步块，休眠完成后也未必立刻执行，需要等到资源允许才能执行

线程等待(对象方法)：  
wait()，是Object的方法，也即是对象的内置方法，在同步块中线程执行到该方法时，也即让出了该对象的锁，所以无法继续执行

线程通知(对象方法)：  
notify(),notifyAll()，此时该对象持有一个或者多个线程的wait，
调用notify()随机的让一个线程恢复对象的锁，调用notifyAll()则让所有线程恢复对象锁

线程挂起(过时)：  
suspend()，线程挂起并没有释放资源，而是只能等到resume()才能继续执行

线程恢复(过时)：  
resume()，由于指令重排可能导致resume()先于suspend()执行，导致线程永远挂起，所以该方法被标为过时

线程加入：  
join()，在一个线程调用另外一个线程的join()方法表明当前线程阻塞执行被调用线程执行结束再进行，也即是被调用线程织入进来

线程让步：  
yield()，暂停当前线程进而执行别的线程，当前线程等待下一轮资源允许再进行，防止该线程一直霸占资源，而其他线程饿死

线程等待：  
park()，基于线程对象的操作，较对象锁更为精准

线程恢复：  
unpark(Thread thread)，对应park()解锁，为不可重入锁

## 线程分组

为了管理线程，于是有了线程组的概念，业务上把类似的线程放在一个ThreadGroup里面统一管理。
线程组表示一组线程，此外，线程组还可以包括其他线程组。
线程组形成一个树，其中除了初始线程组以外的每个线程组都有一个父线程。
线程被允许访问它自己的线程组信息，但不能访问线程组的父线程组或任何其他线程组的信息。

## 守护线程

通常情况下，线程运行到最后一条指令后则完成生命周期，结束线程，然后系统回收资源。或者单遇到异常或者return提前返回，
但是如果我们想让线程常驻内存的话，比如一些监控类线程，需要24小时值班的，于是我们又创造了守护线程的概念。

setDaemon()传入true则会把线程一直保持在内存里面，除非JVM宕机否则不会退出。

## 线程优先级

线程优先级其实只是对线程打的一个标志，
但并不意味这高优先级的一定比低优先级的先执行，具体还要看操作系统的资源调度情况。
通常线程优先级为5，边界为[1,10]。

```java
 /**
  * The minimum priority that a thread can have.
  */
 public final static int MIN_PRIORITY = 1;/**
  * The default priority that is assigned to a thread.
  */
 public final static int NORM_PRIORITY = 5; /**
  * The maximum priority that a thread can have.
  */
 public final static int MAX_PRIORITY = 10;
```

## 总结  

* wait vs. sleep

wait 是Object类中的方法，而sleep是Thread类中的方法。
sleep 是Thread类中的静态方法。无论是在a线程中调用b的sleep方法，还是b线程中调用a的sleep方法，谁调用，谁睡觉。

最主要的是sleep方法调用之后，并没有释放锁。使得线程仍然可以同步控制。sleep不会让出系统资源。
而wait是进入线程等待池中等待，让出系统资源。

调用wait方法的线程，不会自己唤醒，需要线程调用 notify / notifyAll 方法唤醒等待池中的所有线程，才会进入就绪队列中等待系统分配资源。
sleep方法会自动唤醒，如果时间不到，想要唤醒，可以使用interrupt方法强行打断。
Thread.sleep(0) // 触发操作系统立刻重新进行一次CPU竞争。

sleep可以在任何地方使用。而wait，notify，notifyAll只能在同步控制方法或者同步控制块中使用。
sleep必须捕获异常，而wait，notify，notifyAll的不需要捕获异常。  
