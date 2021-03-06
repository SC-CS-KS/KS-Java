# synchronized

同步锁，每个JAVA对象都有且只有一个同步锁，在任何时刻，最多只允许一个线程拥有这把锁。

CountDownLatch
CyclicBarrier

## 特性

具有原子性，有序性和可见性
是一种阻塞的线程控制方法
Synchronized 先天具有重入性

## 原理

当一个线程试图访问带有synchronized(this)标记的代码块时，必须获得 this关键字引用的 对象的锁。
假如这个锁已经被其它的线程占用，JVM就会把这个线程放到本对象的锁池中，本线程进入阻塞状态。
锁池中可能有很多的线程，等到其他的线程释放了锁，JVM就会从锁池中随机取出一个线程，
使这个线程拥有锁，并且转到就绪状态。

假如这个锁没有被其他线程占用，本线程会获得这把锁，开始执行同步代码块。
一般情况下在执行同步代码块时不会释放同步锁，但也有特殊情况会释放对象锁，
如在执行同步代码块时，遇到异常而导致线程终止，锁会被释放，
在执行代码块时，执行了锁所属对象的wait()方法，这个线程会释放对象锁，进入对象的等待池中。

* 管程(Monitor)

基于进入和退出管程(Monitor)对象实现
其关键就是必须要对对象的监视器monitor进行获取，当线程获取monitor后才能继续往下执行，否则就只能等待。
而这个获取的过程是互斥的，即同一时刻只有一个线程能够获取到monitor。

任意一个对象都拥有自己的监视器，当这个对象由同步块或者这个对象的同步方法调用时。
执行方法的线程必须先获取该对象的监视器才能进入同步块和同步方法，
如果没有获取到监视器的线程将会被阻塞在同步块和同步方法的入口处，进入到BLOCKED状态。

使用monitorenter和monitorexit两个指令分别获取锁标记和释放锁标记，使用了ACC_SYNCHRONIZED来完成锁的获取与释放的
也就是锁的获取与释放synchronized关键字自动帮我们完成了。

# 使用

修饰实例方法
		进入同步代码前要获得当前实例的锁

修饰静态方法
		进入同步代码前要获得当前类对象的锁

修饰代码块
		指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
		实例对象
			synchronized (this) {
        ...
      }
		Class对象
			synchronized (ClassName.class) {
        ...
      }
		任意实例对象
			String lock = "";
      synchronized (lock) {
        ...
      }
  
	注意
		如果锁住的是类对象，尽管new多个实例对象，但它们仍然是属于同一个类依然会被锁住

* vs. happens-before

即监视器锁规则
	对同一个监视器的解锁，happens-before于对该监视器的加锁。

可见性
	释放锁的时候会将值刷新到主内存中，其他线程获取锁时会强制从主内存中获取最新的值。
