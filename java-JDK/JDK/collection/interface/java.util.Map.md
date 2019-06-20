# java.util.Map
```md
 public interface Map<K,V>
```

## Method Summary
* // Query Operations
```java
int size();
boolean isEmpty();
boolean containsKey(Object key);
boolean containsValue(Object value);
V get(Object key);
```
* // Modification Operations
```java
V put(K key, V value);
V remove(Object key);
```
* // Bulk Operations
```
void putAll(Map<? extends K, ? extends V> m);
void clear();
```
* // Views
```java
Set<K> keySet();
Collection<V> values();
Set<Map.Entry<K, V>> entrySet();
```
* // Comparison and hashing
```java
boolean equals(Object o);
int hashCode();
```
* // Defaultable methods
```md
default V getOrDefault(Object key, V defaultValue)
default void forEach(BiConsumer<? super K, ? super V> action)
default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
default V putIfAbsent(K key, V value) 
default boolean remove(Object key, Object value)
default boolean replace(K key, V oldValue, V newValue)
default V replace(K key, V value)
default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
default V computeIfPresent(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction)
default V compute(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction)
default V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction)
```

## Nested Classes
* interface Entry<K,V> 

```java
K getKey();
V getValue();
V setValue(V value);
boolean equals(Object o);
int hashCode();
public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey()
public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue()
public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp)
public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp)
```
