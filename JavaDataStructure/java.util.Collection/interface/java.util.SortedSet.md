# java.util.SortedSet
```java
public interface SortedSet<E> extends Set<E> {}
```

```java
Comparator<? super E> comparator();

SortedSet<E> subSet(E fromElement, E toElement);
SortedSet<E> headSet(E toElement);
SortedSet<E> tailSet(E fromElement);
E first();
E last();

@Override
default Spliterator<E> spliterator() {}
```