# CountDownLatch java.util.concurrent.CountDownLatch 
```md
是一个同步的辅助类，它允许一个或多个线程等待一系列指定操作的完成。

CountDownLatch 以一个给定的数量初始化，countDown() 每被调用一次，这一数量就减一。
通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
```
## 
* await()
```md
await()方法可以阻塞至超时或者计数器减至0，其他线程当完成自己目标的时候可以减少1。
```
* countDown()

## 
```md
count初始化CountDownLatch，然后需要等待的线程调用await方法，await方法会一直受阻塞直到count=0。
而其它线程完成自己的操作后，调用countDown()使计数器count减1，当count减到0时，所有在等待的线程均会被释放。

说白了就是通过count变量来控制等待，如果count值为0了(其他线程的任务都完成了)，那就可以继续执行。
```
