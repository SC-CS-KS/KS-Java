# J.C.U.BlockingQueue
```java
public interface BlockingQueue<E> extends Queue<E> {}
```

```java
boolean add(E e);
boolean offer(E e); 
void put(E e) throws InterruptedException; // 添加一个元素,如果队列满，则阻塞
boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException;
E take() throws InterruptedException; // 移除并返回队列头部的元素，如果队列为空，则阻塞
E poll(long timeout, TimeUnit unit) throws InterruptedException;

int remainingCapacity();
boolean remove(Object o);
public boolean contains(Object o);
int drainTo(Collection<? super E> c);
int drainTo(Collection<? super E> c, int maxElements);
```