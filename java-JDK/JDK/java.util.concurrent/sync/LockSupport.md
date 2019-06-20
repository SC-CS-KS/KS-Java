# LockSupport
```md
LockSupport是用来创建锁和其他同步类的基本线程阻塞原语。

LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，
而且park()和unpark()不会遇到“Thread.suspend 和 Thread.resume所可能引发的死锁”问题。
因为park() 和 unpark()有许可的存在；
调用 park() 的线程和另一个试图将其 unpark() 的线程之间的竞争将保持活性。
```