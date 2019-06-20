# Queue

* [ArrayDeque（数组双端队列）]()

* [ArrayBlockingQueue（基于数组的并发阻塞队列）](JUC.ArrayBlockingQueue.md) 
```md
在构造时需要指定容量， 并可以选择是否需要公平性，
如果公平参数被设置true，等待时间最长的线程会优先得到处理
（其实就是通过将ReentrantLock设置为true来达到这种公平性的：即等待时间最长的线程会先操作）。

通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。
它是基于数组的阻塞循环队 列，此队列按 FIFO（先进先出）原则对元素进行排序。
```
* [PriorityQueue（优先级队列）](java.util.PriorityQueue.md)
```md
是一个带优先级的 队列，而不是先进先出队列。
PriorityQueue是没有容量限制的。
```
* [ConcurrentLinkedQueue（基于链表的并发队列）](JUC.ConcurrentLinkedQueue.md) 
```md
是一个线程安全的队列，基于链表结构实现，是一个无界队列，理论上来说队列的长度可以无限扩大。

采用的是先进先出（FIFO）入队规则，对元素进行排序。


```
* [PriorityBlockingQueue](JUC.ArrayBlockingQueue.md)
```md
PriorityBlockingQueue是对 PriorityQueue的再次包装，是基于堆数据结构的。

```
* [DelayQueue（延期阻塞队列）（阻塞队列实现了BlockingQueue接口）](JUC.DelayQueue.md)
```md
基于PriorityQueue来实现的，是一个存放Delayed 元素的无界阻塞队列。

只有在延迟期满时才能从中提取元素。
该队列的头部是延迟期满后保存时间最长的 Delayed 元素。
如果延迟都还没有期满，则队列没有头部，并且poll将返回null


```