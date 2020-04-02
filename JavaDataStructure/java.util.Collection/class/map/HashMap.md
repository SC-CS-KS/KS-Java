# java.util.HashMap
```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {}
```

## 链表节点 Node
* static class Node<K,V> implements Map.Entry<K,V> {}

## 存储 
* static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {}

## 构造函数

## 主要方法
### 增 
* public V put(K key, V value) {}
```java
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
```

* public void putAll(Map<? extends K, ? extends V> m) {}
### 查
* public V get(Object key) {}
* public boolean containsKey(Object key) {}
* public boolean containsValue(Object value) {}
* public V getOrDefault(Object key, V defaultValue) {}
### 删
* public V remove(Object key) {}
* public void clear() {}

### 扩容
* final Node<K,V>[] resize() {}

### 遍历


