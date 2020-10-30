# ThreadLocal

维持线程封闭性的一种更规范的方法是使用ThreadLocal
	这个类能使线程的某个值与保存值的对象联系起来

	这个类给线程提供了一个本地变量
		这个变量是该线程自己拥有的
	在该线程存活和ThreadLocal实例能访问的时候，保存了对这个变量副本的引用
		当线程消失的时候，所有的本地实例都会被GC
	并且建议我们ThreadLocal最好是 private static 修饰的成员

* 基本思想
将线程作为key，将要保存、更新的对象作为value维护在一个同步Map中，从而达到各个线程分隔
	（因为每个使用变量的线程都一份独立的副本）
这些特定于某个线程值，当线程终止后，这些会作为垃圾回收

* 场景

当某个频繁执行的操作需要一个临时对象
	例如一个缓冲区，而同时又希望避免每次执行时都重新分配该临时对象，就可以使用这项技术。
在实际应用程序框架时大量使用了ThreadLocal。

需求场景即是TTL（TransmittableThreadLocal）的潜在需求场景
如果你的业务需要『在使用线程池等会缓存线程的组件情况下传递ThreadLocal』则是TTL目标场景。
分布式跟踪系统
应用容器或上层框架跨应用代码给下层SDK传递信息
日志收集记录系统上下文

* ThreadLocal和Thread的关系

Thread里面有一个类似MAP的东西，但是初始化的时候为null，map的key为当前ThreadLocal
当使用ThreadLocal的时候，ThreadLocal会帮助当前线程初始化这个MAP，并且把我们需要和线程绑定的值放入改Map中。
