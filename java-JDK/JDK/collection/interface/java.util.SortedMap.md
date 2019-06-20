# SortedMap

```md
public interface SortedMap<K,V> extends Map<K,V> 
```
```java
Comparator<? super K> comparator();
SortedMap<K,V> subMap(K fromKey, K toKey);
SortedMap<K,V> headMap(K toKey);
SortedMap<K,V> tailMap(K fromKey);
K firstKey();
K lastKey();

Set<K> keySet();
Collection<V> values();
Set<Map.Entry<K, V>> entrySet();
```