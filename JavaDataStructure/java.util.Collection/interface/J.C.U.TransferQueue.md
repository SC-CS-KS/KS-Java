# J.C.U.TransferQueue
```java
public interface TransferQueue<E> extends BlockingQueue<E> {}
```

```java
boolean tryTransfer(E e);
void transfer(E e) throws InterruptedException;

boolean tryTransfer(E e, long timeout, TimeUnit unit)
        throws InterruptedException;

boolean hasWaitingConsumer();
int getWaitingConsumerCount();
```