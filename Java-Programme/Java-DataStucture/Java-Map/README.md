# Java Map
```md
一组成对的值键对对象，允许用键来查找值，也被称为关联数组，或者叫做字典。
Map本身是不保证有序性的，Map中的元素顺序与它所返回的集合视图中的元素的迭代顺序相关。

要求映射中的key是不可变对象。
```
* 三种访问的集合视图
```md
包含所有key的集合
包含所有value的集合
包含所有键值对的集合
```

## java.util.map
### Interface
* Map<K,V>
* SortedMap - A Map that further provides a total ordering on its keys.

### Implementation Class
* AbstractMap - 提供了Map 接口的骨干实现

* HashMap - 是基于哈希表的Map接口的非同步实现
* LinkedHashMap - 是 Map 接口的哈希表和链接列表实现
* TreeMap - 是 SortedMap 接口的基于红黑树的实现
* WeakHashMap - 类的行为部分取决于垃圾回收器的动作
* IdentityHashMap 

* java.util.EnumMap<K,V>

* HashTable (extends Dictionary<K,V>)

## J.U.C
### Interface
* ConcurrentMap<K,V>

### Implementation Class
* [ConcurrentHashMap]()

## 参考


