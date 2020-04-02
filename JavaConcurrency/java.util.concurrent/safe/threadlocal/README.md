# ThreadLocal

## [WhatIs](WhatIs.md)

## Design
```md
原理
	每一个Thread线程都有属于自己的ThreadLocalMap,里面有一个弱引用的Entry(ThreadLocal,Object),
		Entry(ThreadLocal k, Object v) {
                super(k);
                value = v;
    }
	从ThreadLocal中get值的时候
		首先通过Thread.currentThread得到当前线程
			然后拿到这个线程的ThreadLocalMap
		再传递当前ThreadLocal对象（结合上一点）。取得Entry中的value值
	set值的时候同理，更改的是当先线程的ThreadLocalMap中Entry中key为当前Threadlocal对象的value值
	被废弃了的ThreadLocal所绑定对象的引用，会在以下4情况被清理
		Thread结束时。
		当Thread的ThreadLocalMap的threshold超过最大值时。rehash
		向Thread的ThreadLocalMap中存放一个ThreadLocal，hash算法没有命中既有Entry,而需要新建一个Entry时。
		手工通过ThreadLocal的remove()方法或set(null)。
```

## Extend
* [InheritableThreadLocal](https://blog.csdn.net/a837199685/article/details/52712547)
```md
	子线程获得父线程ThreadLocal？
	问题
		对于使用线程池等会缓存线程的组件的情况
			线程由线程池创建好，并且线程是缓存起来反复使用的
		这时父子线程关系的ThreadLocal值传递已经没有意义
		应用需要的实际上是把 任务提交给线程池时的ThreadLocal值传递到 任务执行时
	ThreadLocal.ThreadLocalMap threadLocals = null;
	ThreadLocal.ThreadLocalMap inheritableThreadLocals = null;
	InheritableThreadLocal还有问题吗？
		不能够解决线程池当中获得父线程中ThreadLocal中的值。
		线程在执行完毕的时候并没有清除ThreadLocal中的值，导致后面的任务重用现在的localMap。
```
* [TransmittableThreadLocal](https://github.com/alibaba/transmittable-thread-local)
```md
	使用类TransmittableThreadLocal来保存值，并跨线程池传递。
		TransmittableThreadLocal继承InheritableThreadLocal，使用方式也类似
	相比InheritableThreadLocal，添加了
		protected方法copy
			用于定制任务提交给线程池时的ThreadLocal值传递到任务执行时的拷贝行为，缺省传递的是引用。
		protected方法beforeExecute/afterExecute
			执行任务(Runnable/Callable)的前/后的生命周期回调，缺省是空操作。
	保证线程池中传递值
		修饰Runnable和Callable
			使用com.alibaba.ttl.TtlRunnable和com.alibaba.ttl.TtlCallable来修饰传入线程池的Runnable和Callable。
			时序图
		修饰线程池
			省去每次Runnable和Callable传入线程池时的修饰，这个逻辑可以在线程池中完成。
			通过工具类com.alibaba.ttl.threadpool.TtlExecutors完成
				getTtlExecutor：修饰接口Executor
				getTtlExecutorService：修饰接口ExecutorService
				ScheduledExecutorService：修饰接口ScheduledExecutorService
		使用Java Agent来修饰JDK线程池实现类
			这种方式，实现线程池的传递是透明的，代码中没有修饰Runnable或是线程池的代码
				即可以做到应用代码 无侵入
```
