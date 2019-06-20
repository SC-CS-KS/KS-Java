# java.util.List

```java
public interface List<E> extends Collection<E> {}
```
* Query Operations
* Modification Operations

* Bulk Modification Operations
```java
boolean addAll(int index, Collection<? extends E> c);
default void replaceAll(UnaryOperator<E> operator) {}
default void sort(Comparator<? super E> c) {}
```

* Comparison and hashing
```java
E get(int index);
E set(int index, E element);
void add(int index, E element);
E remove(int index);
int indexOf(Object o);
int lastIndexOf(Object o);
```
* List Iterators
```java
ListIterator<E> listIterator(int index);
```
* View
```java
List<E> subList(int fromIndex, int toIndex);
default Spliterator<E> spliterator(){};
```