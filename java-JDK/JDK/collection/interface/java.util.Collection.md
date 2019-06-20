# java.util.Collection

```md
public interface Collection<E> extends Iterable<E> {}
```
* Query Operations
```java
int size();
boolean isEmpty();
boolean contains(Object o);
Iterator<E> iterator();
Object[] toArray();
<T> T[] toArray(T[] a);
```
* Modification Operations
```java
boolean add(E e);
boolean remove(Object o);
```
* Bulk Operations
```java
boolean containsAll(Collection<?> c);
boolean addAll(Collection<? extends E> c);
boolean removeAll(Collection<?> c);
default boolean removeIf(Predicate<? super E> filter) {}
boolean retainAll(Collection<?> c);
void clear();
```
* Comparison and hashing
```java
boolean equals(Object o);
int hashCode();
default Spliterator<E> spliterator() {}
default Stream<E> stream(){}
default Stream<E> parallelStream() {}     
```