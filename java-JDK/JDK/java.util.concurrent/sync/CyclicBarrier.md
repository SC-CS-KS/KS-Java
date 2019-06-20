# java.util.concurrent.CyclicBarrier 
```md
栅栏
CyclicBarrier允许一组线程互相等待，直到到达某个公共屏障点。
叫做cyclic是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用(对比于CountDownLatch是不能重用的)。

是一种同步机制，它能够对处理一些算法的线程实现同步。
它就是一个所有线程必须等待的一个栅栏，直到所有线程都到达这里，然后所有线程才可以继续做其他事情。
```
* vs. CountDownLatch
```md
CountDownLatch 注重的是等待其他线程完成。
CyclicBarrier注重的是：当线程到达某个状态后，暂停下来等待其他线程，所有线程均到达以后，继续执行。
```
