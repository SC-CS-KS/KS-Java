# Java Lock


## JVM 锁机制
* 自旋锁(Spin Lock)
* 偏向锁(Biased Lock)
* 轻量级锁(Lightweight Lock)
* 重量级锁(Heavyweight Lock)



## 公平锁 和 非公平锁
```md
线程获取锁是否公平，是指线程是否能够按照申请加锁的顺序来获得锁。

如果一个线程申请锁时，会判断AQS队列中是否有等待线程，如果有，则入队等待，
当持有锁的线程释放锁时，处于队头的等待线程会获得锁，此时就是 公平锁策略。

如果一个线程申请锁时，有可能先于AQS队列中的等待线程先获得锁，
则此时实现的是 非公平锁 策略。

* 实现
ReentrantLock lock = new ReentrantLock() // 非公平锁
ReentrantLock lock = new ReentrantLock(true) // 公平锁

JUC 很多锁默认的策略都是非公平的。
```
