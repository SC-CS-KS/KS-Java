# java.util.Queue

```java
public interface Queue<E> extends Collection<E> {}
```

```java
boolean add(E e); //增加一个元索，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
boolean offer(E e); //添加一个元素并返回true，如果队列已满，则返回false
E remove(); //移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
E poll(); //移除并返问队列头部的元素，如果队列为空，则返回null
E element(); //返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
E peek(); //返回队列头部的元素，如果队列为空，则返回null
```
